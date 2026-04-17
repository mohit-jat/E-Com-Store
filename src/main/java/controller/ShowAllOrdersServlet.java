package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Dao.OrderDao;
import model.OrderDetails;;

@WebServlet("/ShowAllOrdersServlet")
public class ShowAllOrdersServlet extends HttpServlet {

	public ShowAllOrdersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		        
        OrderDao dao = new OrderDao();
        List<OrderDetails> list = dao.getAllOrders();

        request.setAttribute("orderList", list);

        request.getRequestDispatcher("ShowAllOrders.jsp")
               .forward(request, response);
    }

	
}