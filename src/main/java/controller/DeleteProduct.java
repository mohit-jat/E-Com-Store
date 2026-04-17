package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import Dao.ProductsDao;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {

    public DeleteProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
        try {

            int id = Integer.parseInt(request.getParameter("id"));

            ProductsDao dao = new ProductsDao();
            dao.deleteProduct(id);

            response.sendRedirect("ShowProducts");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}