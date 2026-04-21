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

@WebServlet("/Home")
public class productservlet extends HttpServlet {

   
	public productservlet() {
		super();
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	
        
        int page = 1;
        int limit = 21;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int offset = (page - 1) * limit;

        ProductsDao dao = new ProductsDao();

        List<Products> list = dao.getProductsWithOffset(offset);
        int total = dao.getTotalProducts();

        int totalPages = (int) Math.ceil((double) total / limit);

        request.setAttribute("Products", list);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("Index.jsp").forward(request, response);
    }
}