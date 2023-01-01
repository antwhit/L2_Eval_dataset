import com.gammastream.validity.*;
import com.webobjects.appserver.*;
import com.webobjects.appserver.xml.*;
import com.webobjects.foundation.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;
import java.io.*;

public class Main extends WOComponent {

    protected Application app = (Application) WOApplication.application();

    protected Session session = (Session) session();

    protected String thePath = "";

    protected String errorMessage = "";

    protected String currentPath = "";

    protected String password = "";

    protected boolean error = false;

    public void awake() {
        super.awake();
        error = false;
    }

    public WOComponent loadEOModelAction() {
        try {
            session.setGsveomodel(new GSVEOModel(thePath));
            this.getGSValidateObject(thePath);
            app.config().addPath(thePath);
            app.saveConfiguration();
            return pageWithName("Modeler");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            error = true;
            errorMessage = "EOModel does not exist at: <br>" + thePath;
            return null;
        } catch (IOException e) {
            System.out.println(e);
            error = true;
            errorMessage = "EOModel does not exist at: <br>" + thePath;
            return null;
        }
    }

    public WOComponent loadRecentEOModelAction() {
        try {
            session.setGsveomodel(new GSVEOModel(currentPath));
            this.getGSValidateObject(currentPath);
            return pageWithName("Modeler");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            error = true;
            errorMessage = "EOModel does not exist at: <br>" + currentPath;
            return null;
        } catch (IOException e) {
            System.out.println(e);
            error = true;
            errorMessage = "EOModel does not exist at: <br>" + currentPath;
            return null;
        }
    }

    public void getGSValidateObject(String tPath) {
        System.out.println(tPath);
        String eomodelRootPath, eomodelPath, xmlPath;
        String modelName = session.gsveomodel().name();
        eomodelRootPath = NSPathUtilities.stringByDeletingLastPathComponent(tPath);
        eomodelPath = NSPathUtilities.stringByAppendingPathComponent(eomodelRootPath, (modelName + ".eomodeld"));
        xmlPath = NSPathUtilities.stringByAppendingPathComponent(eomodelPath, (GSVModel.MODEL_NAME + "." + GSVModel.MODEL_EXTENSION));
        File f = new File(xmlPath);
        if (f.exists()) {
            session.setModel((GSVModel) WOXMLDecoder.decoder().decodeRootObject(xmlPath));
            if (session.model.eomodelGroup().modelWithPath(eomodelPath) == null) {
                session.model.savePath(eomodelPath);
            }
        } else {
            session.setModel(new GSVModel(tPath));
        }
    }

    public WOComponent checkPasswordAction() {
        if (app.config().password() != null) {
            if (app.config().password().equals(password)) session.setIsLoggedIn(true); else {
                session.setIsLoggedIn(false);
                error = true;
                errorMessage = "Incorrect Password";
            }
        } else {
            session.setIsLoggedIn(true);
        }
        return null;
    }
}
