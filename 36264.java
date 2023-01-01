import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;

public class OrgChart extends WOComponent {

    protected Group currentRootGroup;

    public OrgChart(WOContext context) {
        super(context);
    }

    public NSArray rootGroups() {
        NSDictionary searchBindings = new NSDictionary(new Object[] { NSKeyValueCoding.NullValue }, new Object[] { "parentGroup" });
        return EOUtilities.objectsMatchingValues(session().defaultEditingContext(), "Group", searchBindings);
    }
}
