import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import er.extensions.ERXDirectAction;

public class DirectAction extends ERXDirectAction {

    public DirectAction(WORequest aRequest) {
        super(aRequest);
    }

    public WOActionResults defaultAction() {
        return pageWithName(Main.class.getName());
    }
}
