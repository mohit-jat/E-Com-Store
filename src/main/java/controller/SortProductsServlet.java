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

@WebServlet("/Products")
public class SortProductsServlet extends HttpServlet {

    
	public SortProductsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sort = request.getParameter("sort");

        ProductsDao dao = new ProductsDao();
        List<projects> list = null;

        if("low".equals(sort)){
            list = dao.sortByPriceLow();
        }
        else if("high".equals(sort)){
            list = dao.sortByPriceHigh();
        }
        else if("rating".equals(sort)){
            list = dao.sortByRating();
        }
        else if("newest".equals(sort)){
            list = dao.sortByNewest();
        }

        request.setAttribute("Products", list);

        request.getRequestDispatcher("Index.jsp").forward(request, response);
    }
}