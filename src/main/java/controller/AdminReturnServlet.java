package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

import Dao.OrderDao;
import model.OrderDetails;

@WebServlet("/AdminReturnRequests")
public class AdminReturnServlet extends HttpServlet {

	
	public AdminReturnServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderDao dao = new OrderDao();

        List<OrderDetails> list = dao.getReturnRequests();

        request.setAttribute("returns", list);

        request.getRequestDispatcher("Admin-Returns.jsp").forward(request, response);
    }
}