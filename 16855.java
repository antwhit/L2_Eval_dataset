import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.directtoweb.D2W;

public class Main extends WOComponent {

    public String username;

    public String password;

    public Main(WOContext aContext) {
        super(aContext);
    }

    public WOComponent defaultPage() {
        return D2W.factory().defaultPage(session());
    }
}
