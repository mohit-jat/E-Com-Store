package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import Dao.OrderDao;

@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {

	public PlaceOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
    	
        
        HttpSession session = request.getSession(false);

        // 🔥 LOGIN CHECK
        if(session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        String address = request.getParameter("address");
        String payment = request.getParameter("payment");

        if(address == null || payment == null) {
            response.sendRedirect("Checkout");
            return;
        }

        OrderDao dao = new OrderDao();
        dao.placeOrder(userId, address, payment);

        request.getRequestDispatcher("Fake-Payment.jsp").forward(request, response);
    }
}