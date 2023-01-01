import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

public class FavoriteColor extends HttpServlet {

    private static final String[] colors_ = new String[] { "red", "orange", "green", "brown", "slate" };

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String likeInput = request.getParameter("like");
        int like = (likeInput == null || likeInput.length() == 0) ? -1 : Integer.valueOf(likeInput).intValue();
        out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
        out.write("<html>\n");
        out.write("  <head>\n");
        out.write("    <title>Favorite Color</title>\n");
        out.write("  </head>\n");
        out.write("  <body>\n");
        out.write("    <form>\n");
        out.write("      <p>Which color is your favorite? <select name=\"like\">\n");
        out.write("          <option value=\"-1\"></option>\n");
        {
            final String[] $colors_ = colors_;
            final int lim$colors_ = $colors_.length;
            String color;
            for (int iColor = 0; iColor < lim$colors_; ++iColor) {
                color = $colors_[iColor];
                out.write("          <option id=\"color\" value=\"");
                out.write(String.valueOf(iColor));
                out.write("\"");
                if (iColor == like) {
                    out.write(" selected");
                }
                out.write(">");
                out.write(String.valueOf(color));
                out.write("");
                out.write("</option>\n");
            }
        }
        out.write("        </select>");
        out.write("</p>\n");
        out.write("      <p><input type=\"SUBMIT\"></p>\n");
        out.write("    </form>\n");
        out.write("  </body>\n");
        out.write("</html>\n");
        out.flush();
        out.close();
    }
}
