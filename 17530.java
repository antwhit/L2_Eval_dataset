import javax.ejb.EJB;
import sb.PublisherRemote;

/**
 * The MyAppClient class is the client program for this
 * application.  It calls the publisher's publishNews method
 * twice.
 */
public class MyAppClient {

    @EJB(name = "PublisherRemote")
    private static PublisherRemote publisher;

    public static void main(String[] args) {
        MyAppClient client = new MyAppClient();
        client.doTest();
        System.exit(0);
    }

    public void doTest() {
        try {
            publisher.publishNews();
            publisher.publishNews();
            System.out.println("To view the bean output,");
            System.out.println(" check <install_dir>/domains/domain1/logs/server.log.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
