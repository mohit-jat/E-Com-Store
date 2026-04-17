package controller;

import java.io.IOException;

import Dao.CartDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {

   
	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("Login");
            
            
            return;
        }

        int pid = Integer.parseInt(request.getParameter("pid"));

        int userId = (int) session.getAttribute("userId");

        CartDao dao = new CartDao();
        dao.addToCart(userId, pid);

        response.sendRedirect("Cart");
    }
}