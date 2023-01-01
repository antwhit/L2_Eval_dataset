import com.webobjects.directtoweb.*;
import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;
import com.webobjects.directtoweb.*;

public class ERDDefaultSectionComponent extends WOComponent {

    public ERDDefaultSectionComponent(WOContext context) {
        super(context);
    }

    public boolean isStateless() {
        return true;
    }

    public EOEnterpriseObject object() {
        return (EOEnterpriseObject) valueForBinding("object");
    }

    public Object sectionTitle() {
        D2WContext c = (D2WContext) valueForBinding("d2wContext");
        Object result = object();
        boolean computed = false;
        if (result != null) {
            if (c != null) {
                String k = (String) c.valueForKey("keyWhenGrouping");
                if (k != null) {
                    result = ((EOEnterpriseObject) result).valueForKey(k);
                    computed = true;
                }
            }
        }
        return result;
    }
}
