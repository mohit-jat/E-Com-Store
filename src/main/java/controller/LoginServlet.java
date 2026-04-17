package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.USER;

import java.io.IOException;
import org.mindrot.jbcrypt.BCrypt;

import Dao.UserDao;

@WebServlet("/Login")

public class LoginServlet extends HttpServlet {

public LoginServlet() {
super();
}

private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
	     throws ServletException, IOException {

	request.getRequestDispatcher("Login.jsp").forward(request, response);
	
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {

 String username = request.getParameter("username");
 String password = request.getParameter("password");

 UserDao dao = new UserDao();
 USER user = dao.loginUser(username);

 if (user != null && BCrypt.checkpw(password, user.getPassword())) {
     
     HttpSession session = request.getSession();
     
     session.setAttribute("user", user);
     session.setAttribute("userId", user.getUser_id());
     
     request.getRequestDispatcher("Dashboard.jsp").forward(request, response);

 } else {
     request.setAttribute("msg", "Invalid Username or Password");
     request.getRequestDispatcher("Login.jsp").forward(request, response);
 }
}}