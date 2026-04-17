package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.projects;

import java.io.IOException;
import java.util.List;

import Dao.ProductsDao;


@WebServlet("/AllProducts")
public class GetAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GetAllProducts() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	
	   ProductsDao pd = new ProductsDao();
	   
	   List<projects> list = pd.getAllProducts();
	   
	   request.setAttribute("Products", list);
		
	
		request.getRequestDispatcher("Index.jsp").forward(request, response);

	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
