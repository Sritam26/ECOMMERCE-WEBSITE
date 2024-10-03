package AuthenticationServlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import LoginRegistration.dao.AdminDao;
import UserModel.Admin;

@WebServlet("/AdminLogin")
public class Adminlogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private AdminDao adminDao;
    
    public void init() {
        adminDao = new AdminDao(); // Initialize the AdminDao object
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Admin admin = adminDao.loginAdmin(email, password);
        
        if (admin != null) {
            // Successful login
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin); // Store admin in session
            response.sendRedirect("Login_v2/adminlanding.jsp"); // Redirect to admin landing page
        } else {
            // Login failed, redirect to login page with error
            response.sendRedirect("login.jsp?error=true"); 
        }
    }
}
