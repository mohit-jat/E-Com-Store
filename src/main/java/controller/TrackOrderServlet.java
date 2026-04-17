package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

import Dao.OrderDao;
import model.OrderDetails;

@WebServlet("/TrackOrder")
public class TrackOrderServlet extends HttpServlet {

   	public TrackOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
        
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("userId") == null){
            response.sendRedirect("Login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        OrderDao dao = new OrderDao();

        List<OrderDetails> list = dao.getUserOrders(userId);

        request.setAttribute("orders", list);

        request.getRequestDispatcher("Track-Order.jsp").forward(request, response);
    }
}