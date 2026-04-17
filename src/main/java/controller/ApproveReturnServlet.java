package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

import Dao.OrderDao;

@WebServlet("/ApproveReturn")
public class ApproveReturnServlet extends HttpServlet {
	public ApproveReturnServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
   
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");

        if(idStr == null){
            response.sendRedirect("AdminReturnReqeuests");
            return;
        }

        int orderId = Integer.parseInt(idStr);

        OrderDao dao = new OrderDao();
        boolean f = dao.approveReturn(orderId);

        if(f){
            System.out.println("Return Approved");
        } else {
            System.out.println("Approve Failed");
        }

        response.sendRedirect("AdminReturnRequests");
    }

	
}