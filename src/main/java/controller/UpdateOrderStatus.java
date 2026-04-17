package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Dao.OrderDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateOrderStatus")
public class UpdateOrderStatus extends HttpServlet {

	public UpdateOrderStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    	
        
        int orderId = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

       
        try {
            Connection con = OrderDao.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE orders SET status=? WHERE order_id=?"
            );

            ps.setString(1, status);
            ps.setInt(2, orderId);

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            if(rows > 0){
                System.out.println("Order updated successfully!");
            } else {
                System.out.println("No order found with id: " + orderId);
            }

            response.sendRedirect("AdminOrders");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
}