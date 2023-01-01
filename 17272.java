import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.HTMLFilter;

/**
 * Example servlet showing request headers
 *
 * @author James Duncan Davidson <duncan@eng.sun.com>
 */
public class RequestHeaderExample extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final ResourceBundle RB = ResourceBundle.getBundle("LocalStrings");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body bgcolor=\"white\">");
        out.println("<head>");
        String title = RB.getString("requestheader.title");
        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<a href=\"../reqheaders.html\">");
        out.println("<img src=\"../images/code.gif\" height=24 " + "width=24 align=right border=0 alt=\"view code\"></a>");
        out.println("<a href=\"../index.html\">");
        out.println("<img src=\"../images/return.gif\" height=24 " + "width=24 align=right border=0 alt=\"return\"></a>");
        out.println("<h3>" + title + "</h3>");
        out.println("<table border=0>");
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String headerName = e.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<tr><td bgcolor=\"#CCCCCC\">");
            out.println(HTMLFilter.filter(headerName));
            out.println("</td><td>");
            out.println(HTMLFilter.filter(headerValue));
            out.println("</td></tr>");
        }
        out.println("</table>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
