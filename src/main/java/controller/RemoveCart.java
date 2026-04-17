package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import Dao.CartDao;

@WebServlet("/RemoveCart")
public class RemoveCart extends HttpServlet {

   
	public RemoveCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
        
        
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        int pid = Integer.parseInt(request.getParameter("id"));

        int userId = (int) session.getAttribute("userId");

        CartDao dao = new CartDao();
        dao.removeFromCart(userId, pid);

        response.sendRedirect("Cart");
    }
}