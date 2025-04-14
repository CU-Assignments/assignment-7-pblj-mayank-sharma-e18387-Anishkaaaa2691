import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // Static check
        if ("admin".equals(user) && "1234".equals(pass)) {
            request.setAttribute("username", user);
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>Invalid credentials</h3>");
        }
    }
}
