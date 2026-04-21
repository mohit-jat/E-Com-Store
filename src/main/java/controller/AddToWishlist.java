package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import Dao.WishlistDao;

@WebServlet("/AddToWishlist")
public class AddToWishlist extends HttpServlet {

  
	
	public AddToWishlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        int pid = Integer.parseInt(request.getParameter("pid"));

        int userId = (int) session.getAttribute("userId");

        WishlistDao dao = new WishlistDao();
        dao.addToWishlist(userId, pid);

        response.sendRedirect("Home");
    }
}