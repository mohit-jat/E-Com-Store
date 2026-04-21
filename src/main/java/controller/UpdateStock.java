package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import Dao.ProductsDao;
import model.Products;

@WebServlet("/UpdateStock")
public class UpdateStock extends HttpServlet {

    public UpdateStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    
        
        try {

            int id = Integer.parseInt(request.getParameter("id"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            ProductsDao dao = new ProductsDao();

            Products p = dao.getProductById(id);

            p.setStock(stock);

            dao.updateProduct(p);

            response.sendRedirect("ShowProducts");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}