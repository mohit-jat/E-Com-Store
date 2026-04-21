package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import Dao.WishlistDao;
import model.Products;

@WebServlet("/Wishlist")
public class WishlistServlet extends HttpServlet {

   
	public WishlistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("Login");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        WishlistDao dao = new WishlistDao();
        List<Products> list = dao.getWishlist(userId);

        request.setAttribute("wishlist", list);

        request.getRequestDispatcher("Wishlist.jsp").forward(request, response);
    }
}