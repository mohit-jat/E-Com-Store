package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

import Dao.OrderDao;
import model.OrderDetails;

@WebServlet("/MyReturns")
public class MyReturnServlet extends HttpServlet {

    
	public MyReturnServlet() {
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

        List<OrderDetails> list = dao.getUserReturnOrders(userId);

        request.setAttribute("returns", list);

        request.getRequestDispatcher("My-Return.jsp").forward(request, response);
    }
}