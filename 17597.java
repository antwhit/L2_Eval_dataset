import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;
import com.gammastream.validity.*;

public class SeparatePage extends GSVExceptionableComponent {

    EOClassDescription description;

    User newUser;

    boolean success = false;

    public String verifyPassword = null;

    public SeparatePage(WOContext context) {
        super(context);
        description = EOClassDescription.classDescriptionForEntityName("User");
        newUser = (User) description.createInstanceWithEditingContext(null, null);
    }

    public WOComponent addAgain() {
        success = false;
        newUser = (User) description.createInstanceWithEditingContext(null, null);
        return null;
    }

    public WOComponent add() {
        boolean passwordsMatch = false;
        NSValidation.ValidationException ve = null;
        try {
            passwordsMatch = ((newUser.password() != null) ? newUser.password().equals(verifyPassword) : true);
            newUser.validateForInsert();
            success = true;
            verifyPassword = null;
        } catch (NSValidation.ValidationException e) {
            System.out.println(e);
            ve = e;
        } finally {
            if (!passwordsMatch) {
                ve = GSVEngine.exceptionByAppendingErrorToException("The Password and verified password did not match.", "Verify", ve);
            }
            if (ve != null) {
                raiseGSVException(ve);
                success = false;
                return null;
            }
        }
        return null;
    }

    public Main goToHomePage() {
        Main nextPage = (Main) pageWithName("Main");
        return nextPage;
    }
}
