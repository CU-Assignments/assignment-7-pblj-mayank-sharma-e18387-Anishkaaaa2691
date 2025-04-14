import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    Properties props = new Properties();

    public void init() {
        try (InputStream in = getServletContext().getResourceAsStream("/WEB-INF/db-config.properties")) {
            props.load(in);
        } catch (Exception e) { e.printStackTrace(); }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String idParam = request.getParameter("id");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(
                    props.getProperty("jdbc.url"),
                    props.getProperty("jdbc.user"),
                    props.getProperty("jdbc.password")
            )) {
                PreparedStatement ps;
                if (idParam != null && !idParam.isEmpty()) {
                    ps = con.prepareStatement("SELECT * FROM employees WHERE id=?");
                    ps.setInt(1, Integer.parseInt(idParam));
                } else {
                    ps = con.prepareStatement("SELECT * FROM employees");
                }

                ResultSet rs = ps.executeQuery();
                out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Dept</th><th>Email</th></tr>");
                while (rs.next()) {
                    out.println("<tr><td>" + rs.getInt("id") + "</td><td>" +
                                rs.getString("name") + "</td><td>" +
                                rs.getString("department") + "</td><td>" +
                                rs.getString("email") + "</td></tr>");
                }
                out.println("</table>");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
