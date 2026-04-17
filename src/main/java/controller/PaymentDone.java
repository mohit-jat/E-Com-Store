package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import Dao.OrderDao;

@WebServlet("/PaymentDone")
public class PaymentDone extends HttpServlet {

	
	public PaymentDone() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        
        
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        String address = (String) session.getAttribute("address");
        String payment = (String) session.getAttribute("payment");

        OrderDao dao = new OrderDao();
        dao.placeOrder(userId, address, payment);

        session.removeAttribute("address");
        session.removeAttribute("payment");

        request.getRequestDispatcher("Order-Success.jsp").forward(request, response);
    }
}