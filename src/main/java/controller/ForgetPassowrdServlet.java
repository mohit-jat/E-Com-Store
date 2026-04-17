package controller;


import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forget")
public class ForgetPassowrdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgetPassowrdServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.getRequestDispatcher("Forget.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
        
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		
		UserDao dao = new UserDao();
		int i =  dao.updatePassword(email, hashed);
		if(i != 0) {
			response.sendRedirect("Login.jsp");
		}
		else {
			System.out.println("Something went wrong !!");
		}
		
	}

}