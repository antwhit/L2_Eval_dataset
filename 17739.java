import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;
import demo.eo.*;

public class MyD2WInspect1 extends WOComponent {

    public MyD2WInspect1(WOContext aContext) {
        super(aContext);
    }

    protected Movie _movie;

    protected WOComponent _backPage;

    public void setMovie(Movie movie) {
        _movie = movie;
    }

    public void setBackPage(WOComponent backPage) {
        _backPage = backPage;
    }
}
