import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;
import nitf.IOHandle;
import nitf.ImageReader;
import nitf.ImageSegment;
import nitf.ImageSubheader;
import nitf.NITFException;
import nitf.Reader;
import nitf.Record;
import nitf.SubWindow;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

public class ReadImageSample {

    static class ImageRunner implements Runnable {

        private File file;

        public ImageRunner(File file) {
            this.file = file;
        }

        public void run() {
            try {
                long t = System.currentTimeMillis();
                System.out.println("== Reading " + file.getAbsolutePath() + " ==");
                Reader reader = new Reader();
                IOHandle handle = new IOHandle(file.getAbsolutePath(), IOHandle.NITF_ACCESS_READONLY, IOHandle.NITF_OPEN_EXISTING);
                Record record = reader.read(handle);
                ImageSegment[] segments = record.getImages();
                if (segments.length > 0) {
                    ImageSegment segment = segments[0];
                    ImageReader deserializer = reader.getNewImageReader(0);
                    ImageSubheader subheader = segment.getSubheader();
                    int nBits = subheader.getNumBitsPerPixel().getIntData();
                    int nBands = subheader.getNumImageBands().getIntData();
                    int xBands = subheader.getNumMultispectralImageBands().getIntData();
                    nBands += xBands;
                    int nRows = subheader.getNumRows().getIntData();
                    int nColumns = subheader.getNumCols().getIntData();
                    int numBytesPerPixel = ((nBits - 1) / 8 + 1);
                    int imageBandSize = nRows * nColumns * numBytesPerPixel;
                    byte[][] buffer = new byte[nBands][imageBandSize];
                    int[] bands = new int[nBands];
                    for (int i = 0; i < bands.length; i++) bands[i] = i;
                    SubWindow imageRequest = new SubWindow();
                    imageRequest.setStartCol(0);
                    imageRequest.setStartRow(0);
                    imageRequest.setNumCols(nColumns);
                    imageRequest.setNumRows(nRows);
                    imageRequest.setBandList(bands);
                    imageRequest.setNumBands(nBands);
                    boolean readStatus = deserializer.read(imageRequest, buffer);
                }
                handle.close();
                System.out.println("Time elapsed: " + ((System.currentTimeMillis() - t) / 1000.0) + " seconds : " + file.getAbsolutePath());
            } catch (NITFException e) {
                System.err.println(ExceptionUtils.getStackTrace(e));
            }
        }
    }

    public static void main(String[] args) throws NITFException {
        if (args.length < 1) {
            System.err.println("args: <filenames>");
            System.exit(0);
        }
        List<File> files = new LinkedList<File>();
        for (int arg = 0; arg < args.length; ++arg) {
            File f = new File(args[arg]);
            if (f.exists() && f.isFile()) files.add(f); else if (f.exists() && f.isDirectory()) {
                for (File nitf : f.listFiles(new FilenameFilter() {

                    public boolean accept(File dir, String name) {
                        return StringUtils.endsWithIgnoreCase(name, "ntf") || StringUtils.endsWithIgnoreCase(name, "nitf");
                    }
                })) {
                    files.add(nitf);
                }
            }
        }
        for (File file : files) {
            new Thread(new ImageRunner(file)).run();
        }
    }
}
