package AuthenticationServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LoginRegistration.dao.AdminDao;
import UserModel.Admin;


/**
 * Servlet implementation class Adminregistration
 */
@WebServlet("/adminsignup")
public class Adminregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public AdminDao AdminDao;
	public void init() {
		AdminDao=new AdminDao();
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Admin newadmin = new Admin(0, username, email, password);
        try {
        	AdminDao.registerUser(newadmin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        response.sendRedirect("Login_v2/adminlogin.jsp");
    }
	
	}


