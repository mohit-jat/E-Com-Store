package controller;

import java.io.IOException;
import java.util.List;

import Dao.ProductsDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Products;


@WebServlet("/Search")
public class SearchServlet extends HttpServlet {

    public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String key = request.getParameter("key");

        if (key == null) {
            key = "";
        }
         ProductsDao dao = new ProductsDao();
        List<Products> searchList = dao.searchProductsExtended(key);

        request.setAttribute("Products", searchList);
        request.setAttribute("searchKey", key);

        request.getRequestDispatcher("Index.jsp").forward(request, response);
    }
}