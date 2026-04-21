package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Products;

import java.io.IOException;
import java.util.List;

import Dao.ProductsDao;

@WebServlet("/ShowProducts")
public class ShowProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ShowProducts() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	   ProductsDao pd = new ProductsDao();
	   
	   List<Products> list = pd.getAllProducts();
	   
	   request.setAttribute("productList", list);
		
	
		request.getRequestDispatcher("Show-Products.jsp").forward(request, response);

	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
