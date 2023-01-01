import java.io.*;
import java.net.*;
import com.webobjects.appserver.*;
import com.webobjects.foundation.*;
import er.ajax.*;

public class DragResizeExample extends WOComponent {

    public AjaxDragResizeContainer.ResizeReport report = null;

    public NSMutableArray<Annotation> annotations;

    public Annotation annotationItem;

    public boolean editingEnabled = true;

    public DragResizeExample(WOContext context) {
        super(context);
        annotations = new NSMutableArray<Annotation>(new Annotation[] { new Annotation(377, 96, 79, 68, "Nose", "Due to his big nose, our dog loves to snoop around"), new Annotation(312, 372, 112, 81, "Foot", "Athough the feet are quite big, the legs aren't, so he's not a big sprinter...") });
    }

    @Override
    public void appendToResponse(WOResponse response, WOContext ctx) {
        super.appendToResponse(response, ctx);
        AjaxUtils.addScriptResourceInHead(ctx, response, "app", "overlib.js");
        AjaxUtils.addStylesheetResourceInHead(ctx, response, "app", "dragresize_example.css");
    }

    public void annotationChanged() {
        System.out.println("DragResizeExample.annotationChanged() " + report);
        if (report != null) {
            if (report.isBlur()) {
                report = null;
            } else if (report.isDragEnd() && report.object() != null) {
                Annotation annotation = (Annotation) report.object();
                annotation.x = report.x();
                annotation.y = report.y();
                annotation.w = report.width();
                annotation.h = report.height();
            }
        }
    }

    public void saveAction() {
        System.out.println("DragResizeExample.saveAction()");
    }

    public void toggleEditing() {
        System.out.println("DragResizeExample.toggleEditing()");
        editingEnabled = !editingEnabled;
    }

    public void addAnnotation() {
        System.out.println("DragResizeExample.addAnnotation()");
        annotations.addObject(new Annotation(10, 10, 100, 100, "New Annotation", ""));
    }

    public void removeAnnotation() {
        System.out.println("DragResizeExample.removeAnnotation()");
        if (report != null && report.object() != null) {
            annotations.removeObject(report.object());
        }
    }

    public String overLibJsForAnnotationItem() {
        return editingEnabled ? "" : "return overlib(unescape('" + escapeStringForJS(annotationItem.content) + "'), CAPTION, '" + escapeStringForJS(annotationItem.title) + "');";
    }

    public static String escapeStringForJS(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", " ");
        } catch (UnsupportedEncodingException e) {
            return s;
        }
    }

    public class Annotation {

        public int x, y, w, h;

        public String title, content;

        public Annotation(int x, int y, int w, int h, String title, String content) {
            super();
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.title = title;
            this.content = content;
        }
    }
}
