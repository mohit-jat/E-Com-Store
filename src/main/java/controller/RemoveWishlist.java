package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import Dao.WishlistDao;

@WebServlet("/RemoveWishlist")
public class RemoveWishlist extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);


        if(session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        int pid = Integer.parseInt(request.getParameter("pid"));

        // ✅ SESSION USER ID
        int userId = (int) session.getAttribute("userId");

        WishlistDao dao = new WishlistDao();
        dao.removeFromWishlist(userId, pid);

        response.sendRedirect("Wishlist");
    }
}