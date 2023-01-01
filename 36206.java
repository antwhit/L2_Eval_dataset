import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;
import demo.eo.*;

public class LinkToViewMovie1 extends WOComponent {

    public LinkToViewMovie1(WOContext aContext) {
        super(aContext);
    }

    public boolean isStateless() {
        return true;
    }

    public EOEnterpriseObject object() {
        return (EOEnterpriseObject) valueForBinding("object");
    }

    public String key() {
        return (String) valueForBinding("key");
    }

    public Movie movie() {
        return (Movie) (object() instanceof Movie ? object() : object().valueForKeyPath(key()));
    }

    public WOComponent view() {
        MyD2WInspect1 view = (MyD2WInspect1) pageWithName("MyD2WInspect1");
        view.setMovie(movie());
        view.setBackPage(context().page());
        return view;
    }
}
