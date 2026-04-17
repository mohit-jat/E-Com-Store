package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import model.USER;

@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet {

	
	public ProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
        
        
        HttpSession session = request.getSession(false);

        //  LOGIN CHECK
        if(session == null || session.getAttribute("user") == null){
            response.sendRedirect("Login.jsp");
            return;
        }

        USER user = (USER) session.getAttribute("user");

        request.setAttribute("user", user);

        request.getRequestDispatcher("My-Profile.jsp").forward(request, response);
    }
}