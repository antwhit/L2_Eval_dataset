import java.util.*;
import com.webobjects.appserver.*;
import com.webobjects.foundation.*;

public class AjaxGridExample extends WOComponent {

    private NSMutableDictionary configData;

    public WODisplayGroup displayGroup;

    public AjaxGridExample(WOContext context) {
        super(context);
        displayGroup = new WODisplayGroup();
        displayGroup().setObjectArray(sampleData());
        displayGroup().setNumberOfObjectsPerBatch(Integer.parseInt((String) configData().valueForKey("batchSize")));
    }

    private NSMutableArray sampleData() {
        NSData data = new NSData(application().resourceManager().bytesForResourceNamed("AjaxGridExampleTestData.plist", null, NSArray.EmptyArray));
        NSMutableArray sampleData = new NSMutableArray((NSArray) NSPropertyListSerialization.propertyListFromData(data, "UTF-8"));
        Random random = new Random(new NSTimestamp().getNanos());
        for (int i = 0; i < sampleData.count(); i++) {
            NSMutableDictionary<String, Object> row = (NSMutableDictionary<String, Object>) sampleData.objectAtIndex(i);
            row.setObjectForKey(new Integer(random.nextInt()), "number");
            row.setObjectForKey(new NSTimestamp(random.nextLong()), "date");
            row.setObjectForKey(new Integer(i + 1).toString(), "level");
        }
        return sampleData;
    }

    public NSMutableDictionary configData() {
        if (configData == null) {
            NSData data = new NSData(application().resourceManager().bytesForResourceNamed("AjaxGridExampleConfiguration.plist", null, NSArray.EmptyArray));
            configData = new NSMutableDictionary((NSDictionary) NSPropertyListSerialization.propertyListFromData(data, "UTF-8"));
        }
        return configData;
    }

    /**
	 * @return the disply group containing the data
	 */
    public WODisplayGroup displayGroup() {
        return displayGroup;
    }

    public void updateBatchSize() {
    }

    public void nextBatch() {
        displayGroup().displayNextBatch();
        displayGroup().setSelectedObject(null);
    }

    public void previousBatch() {
        displayGroup().displayPreviousBatch();
        displayGroup().setSelectedObject(null);
    }
}
