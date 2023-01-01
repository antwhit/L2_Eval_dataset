import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;
import com.webobjects.directtoweb.*;

public class Main extends WOComponent {

    public Main(WOContext aContext) {
        super(aContext);
    }

    public WOComponent myD2WListPage3() {
        ListPageInterface lpi = (ListPageInterface) D2W.factory().listPageForEntityNamed("Movie", session());
        lpi.setNextPage(context().page());
        lpi.setDataSource(((Session) session()).movieArrayDataSource());
        return (WOComponent) lpi;
    }

    public WOComponent myD2WListPage4() {
        ListPageInterface lpi = (ListPageInterface) D2W.factory().pageForConfigurationNamed("ListMovies2", session());
        lpi.setNextPage(context().page());
        lpi.setDataSource(((Session) session()).movieArrayDataSource());
        return (WOComponent) lpi;
    }

    public WOComponent myD2WListPage5() {
        ListPageInterface lpi = (ListPageInterface) D2W.factory().pageForConfigurationNamed("ListMovies3", session());
        lpi.setNextPage(context().page());
        lpi.setDataSource(((Session) session()).movieArrayDataSource());
        return (WOComponent) lpi;
    }
}
