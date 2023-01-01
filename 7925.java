import junit.textui.TestRunner;
import com.webobjects.foundation.NSLog;
import er.extensions.ERXApplication;

public class Application extends ERXApplication {

    public static void main(String argv[]) {
        ERXApplication.main(argv, Application.class);
    }

    public Application() {
        setAllowsConcurrentRequestHandling(true);
        setAutoOpenInBrowser(false);
        NSLog.out.appendln("Welcome to " + this.name() + " !");
    }

    @Override
    public void didFinishLaunching() {
        super.didFinishLaunching();
        try {
            TestRunner.run(new ERXObjectStoreCoordinatorSynchronizerTestCase());
            System.out.println("Application.didFinishLaunching: DONE!");
        } catch (Throwable t) {
        }
    }
}
