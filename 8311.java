import com.webobjects.appserver.*;
import com.webobjects.directtoweb.*;
import com.webobjects.foundation.*;
import java.util.*;
import java.lang.*;

public class ERDQuestionPage extends WOComponent implements ConfirmPageInterface {

    public ERDQuestionPage(WOContext context) {
        super(context);
    }

    protected String _message;

    protected NextPageDelegate _okDelegate;

    protected WOComponent _cancelNextPage;

    protected WOComponent _okNextPage;

    protected NextPageDelegate _cancelDelegate;

    public void setConfirmDelegate(NextPageDelegate okDelegate) {
        setOkDelegate(okDelegate);
    }

    public void setOkDelegate(NextPageDelegate okDelegate) {
        _okDelegate = okDelegate;
    }

    public void setCancelDelegate(NextPageDelegate cancelDelegate) {
        _cancelDelegate = cancelDelegate;
    }

    public void setCancelNextPage(WOComponent page) {
        _cancelNextPage = page;
    }

    public void setOkNextPage(WOComponent page) {
        _okNextPage = page;
    }

    public String message() {
        return _message;
    }

    public void setMessage(String newValue) {
        _message = newValue;
    }

    public String formattedMessage() {
        return Services.breakDown(_message, 60);
    }

    public WOComponent okClicked() {
        if (_okNextPage == null && _okDelegate == null) throw new RuntimeException("Ok callback is not present");
        return (_okDelegate != null ? _okDelegate.nextPage(this) : _okNextPage);
    }

    public WOComponent cancelClicked() {
        if (_cancelDelegate == null && _cancelNextPage == null) throw new RuntimeException("Cancel callback is not present");
        return (_cancelDelegate != null ? _cancelDelegate.nextPage(this) : _cancelNextPage);
    }
}
