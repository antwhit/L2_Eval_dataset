import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class NavBar extends WOComponent {

    public NavBar(WOContext arg0) {
        super(arg0);
    }

    public Main openModelAction() {
        Main nextPage = (Main) pageWithName("Main");
        return nextPage;
    }

    public WOComponent helpAction() {
        return null;
    }

    public String helpDirRootPath() {
        String url = "file://" + WOApplication.application().resourceManager().pathForResourceNamed("help_index.html", "Validity", null);
        return url;
    }

    public WOComponent openConfiguration() {
        EditConfiguration nextPage = (EditConfiguration) pageWithName("EditConfiguration");
        return nextPage;
    }
}
