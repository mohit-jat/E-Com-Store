package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import Dao.CartDao;
import model.projects;

@WebServlet("/Cart")
public class CartServlet extends HttpServlet {

    
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        CartDao dao = new CartDao();

        List<projects> list = dao.getCartItems(userId);

        request.setAttribute("cartList", list);

        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }
}