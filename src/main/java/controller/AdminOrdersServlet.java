package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

import Dao.OrderDao;
import model.OrderDetails;

@WebServlet("/AdminOrders")
public class AdminOrdersServlet extends HttpServlet {

    
	public AdminOrdersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderDao dao = new OrderDao();

        List<OrderDetails> list = dao.getAllOrders();

        request.setAttribute("orders", list);

        request.getRequestDispatcher("Admin-Orders.jsp").forward(request, response);
    }
}