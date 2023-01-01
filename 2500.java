import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;

public class Session extends WOSession {

    public NSArray movies() {
        return EOUtilities.objectsForEntityNamed(defaultEditingContext(), "Movie");
    }

    public EOArrayDataSource movieArrayDataSource() {
        EOClassDescription cd = EOClassDescription.classDescriptionForEntityName("Movie");
        EOArrayDataSource dataSource = new EOArrayDataSource(cd, defaultEditingContext());
        dataSource.setArray(movies());
        return dataSource;
    }
}
