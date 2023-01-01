import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;
import com.webobjects.directtoweb.*;

public class DemoListTemplate extends com.webobjects.directtoweb.D2WListPage {

    public DemoListTemplate(WOContext aContext) {
        super(aContext);
    }

    public boolean showReturn() {
        return nextPage() != null;
    }

    public boolean isEntityInspectable() {
        Integer isEntityInspectable = (Integer) d2wContext().valueForKey("isEntityInspectable");
        return isEntityReadOnly() && (isEntityInspectable != null && isEntityInspectable.intValue() != 0);
    }
}
