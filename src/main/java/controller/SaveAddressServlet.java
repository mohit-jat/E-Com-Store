package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Address;

import java.io.IOException;

import Dao.OrderDao;


@WebServlet("/Address")
public class SaveAddressServlet extends HttpServlet {

   
	public SaveAddressServlet() {
		super();
		
		
	}

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("Address.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = (int) request.getSession().getAttribute("userId");

        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pincode = request.getParameter("pincode");

        Address a = new Address();
        a.setUserId(userId);
        a.setName(name);
        a.setMobile(mobile);
        a.setAddress(address);
        a.setCity(city);
        a.setPincode(pincode);

        OrderDao dao = new OrderDao();
        dao.saveAddress(a);
         request.getRequestDispatcher("Address.jsp").forward(request, response);
        
    }
}