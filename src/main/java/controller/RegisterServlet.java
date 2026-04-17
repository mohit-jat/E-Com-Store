package controller;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.USER;


@WebServlet("/Signup")
public class RegisterServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
	public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("Register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	        
        
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone"); 
        String address = request.getParameter("address"); 
        
        String hashp = BCrypt.hashpw(password, BCrypt.gensalt());
        
        USER us = new USER();
        us.setName(name);
        us.setUsername(username);
        us.setPassword(hashp);
        us.setEmail(email);
        us.setPhone(phone);
        us.setAddress(address);
        UserDao dao = new UserDao();
        int i= dao.registerUser(us);
        
        if(i > 0) {
            response.sendRedirect("Login");
        } else {
            System.out.println("Something went wrong in Database Insertion");
            response.sendRedirect("register.jsp?error=failed");
        }
    }
}