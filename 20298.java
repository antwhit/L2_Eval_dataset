import com.webobjects.foundation.*;
import com.webobjects.directtoweb.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;
import demo.eo.*;

public class LinkToViewReviews extends WOComponent {

    public LinkToViewReviews(WOContext aContext) {
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

    public boolean hasReviews() {
        return movie().reviews().count() > 0;
    }

    public Movie movie() {
        return (Movie) (object() instanceof Movie ? object() : object().valueForKeyPath(key()));
    }

    public WOComponent view() {
        ListPageInterface lpi = (ListPageInterface) D2W.factory().pageForConfigurationNamed("ListReviews", session());
        EOClassDescription cd = EOClassDescription.classDescriptionForEntityName("Review");
        EOArrayDataSource dataSource = new EOArrayDataSource(cd, movie().editingContext());
        dataSource.setArray(movie().reviews());
        lpi.setDataSource(dataSource);
        lpi.setNextPage(context().page());
        return (WOComponent) lpi;
    }
}
