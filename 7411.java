import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;
import com.webobjects.directtoweb.*;

public class DemoInspectTemplate extends D2WPage implements InspectPageInterface {

    public DemoInspectTemplate(WOContext context) {
        super(context);
    }

    public WOComponent nextPage() {
        return (nextPageDelegate() != null) ? nextPageDelegate().nextPage(this) : super.nextPage();
    }

    public WOComponent editAction() {
        EditPageInterface editPage = D2W.factory().editPageForEntityNamed(object().entityName(), session());
        editPage.setObject(object());
        editPage.setNextPage(nextPage());
        return (WOComponent) editPage;
    }
}
