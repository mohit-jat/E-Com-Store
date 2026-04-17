package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

import Dao.OrderDao;

@WebServlet("/RejectReturn")
public class RejectReturnServlet extends HttpServlet {

 	
	public RejectReturnServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        
        String idStr = request.getParameter("id");

        if(idStr == null){
            response.sendRedirect("AdminReturnReqest");
            return;
        }

        int orderId = Integer.parseInt(idStr);

        OrderDao dao = new OrderDao();
        boolean f = dao.rejectReturn(orderId);

        if(f){
            System.out.println("Return Rejected");
        } else {
            System.out.println("Reject Failed");
        }

        response.sendRedirect("AdminReturnRequests");
    }
}