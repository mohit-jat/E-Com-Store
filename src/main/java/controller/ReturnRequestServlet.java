package controller;

import java.io.IOException;

import Dao.OrderDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ReturnRequest")
public class ReturnRequestServlet extends HttpServlet {

   
	public ReturnRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        
        
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("userId") == null){
            response.sendRedirect("Login.jsp");
            return;
        }

        int orderId = Integer.parseInt(request.getParameter("id"));

        OrderDao dao = new OrderDao();

        boolean f = dao.requestReturn(orderId);

        if(f){
            System.out.println("Return Requested");
        } else {
            System.out.println("Failed");
        }

        response.sendRedirect("MyReturns");
    }
}