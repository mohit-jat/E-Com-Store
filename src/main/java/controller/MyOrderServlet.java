package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import Dao.OrderDao;
import model.OrderDetails;

@WebServlet("/MyOrders")
public class MyOrderServlet extends HttpServlet {

	
	
	public MyOrderServlet() {
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

        if(session == null || session.getAttribute("userId") == null){
            response.sendRedirect("Login");
            return;
        }

        int userId = (int) session.getAttribute("userId");


        OrderDao dao = new OrderDao();
        List<OrderDetails> list = dao.getUserOrders(userId);

        request.setAttribute("orders", list);

        request.getRequestDispatcher("My-Orders.jsp").forward(request, response);
    }
}