import java.util.List;
import org.jplate.tabular.util.Rfc4180CsvUtil;

public class Rfc4180CsvTest {

    public static void main(final String[] args) {
        try {
            final List<List<String>> csvList = Rfc4180CsvUtil.getAsList("line 1 col 1, Line 1 col 2, Line 1 Col 3\n" + "line 2 col 1, Line 2 col 2, Line 2 Col 3\n" + "line 3 col 1, Line 3 col 2, Line 3 Col 3\n" + "line 4 col 1, Line 4 col 2, Line 4 Col 3");
            System.out.println();
            System.out.println();
            for (List<String> record : csvList) {
                System.out.print("Record:  ");
                for (String field : record) {
                    System.out.print(field);
                    System.out.print(':');
                }
                System.out.println();
            }
            System.out.println();
        } catch (final Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
