import murlen.util.fscript.*;
import java.io.FileReader;

public class Objects {

    public static void main(String argv[]) throws Exception {
        FSReflectionExtension fe = new FSReflectionExtension();
        BasicIO fs = new BasicIO();
        fs.registerExtension(fe);
        fs.load(new FileReader("objects.script"));
        fs.run();
    }
}
