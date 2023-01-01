import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import java.io.*;
import Person;
import com.webobjects.eoaccess.*;
import com.uw.shared.*;

public class Application extends UWApplication {

    public NSDictionary settings;

    public NSMutableArray yearsCache;

    public static void main(String argv[]) {
        WOApplication.main(argv, Application.class);
    }

    /** Constructor */
    public Application() {
        super();
        setDefaultRequestHandler(requestHandlerForKey(directActionRequestHandlerKey()));
        ModelHelper.sharedInstance().installEOModelAddedNotificationHandler();
        try {
            String settingsDictionaryName = System.getProperty("SettingsDictionaryName");
            settings = NSPropertyListSerialization.dictionaryForString(System.getProperty(settingsDictionaryName));
            setSMTPHost((String) settings.objectForKey("SMTPHost"));
            EOEditingContext newContext = new EOEditingContext();
            NSArray users = EOUtilities.objectsForEntityNamed(newContext, "Person");
            if (users.count() == 0) {
                Person person = new Person(newContext, null);
                person.setName("Default Adminstrator");
                person.setPassword("admin");
                person.setType("Admin");
                person.setUserID("Admin");
                try {
                    newContext.saveChanges();
                } catch (Exception e) {
                    System.out.println("Cannot add admin user");
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public NSMutableArray years() {
        if (yearsCache == null) {
            yearsCache = new NSMutableArray();
            NSArray rawArray = EOUtilities.objectsWithFetchSpecificationAndBindings(new EOEditingContext(), "YearlyData", "fetchYears", null);
            for (int i = 0; i < rawArray.count(); i++) yearsCache.addObject(((NSDictionary) rawArray.objectAtIndex(i)).objectForKey("year"));
        }
        return yearsCache;
    }
}
