package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import Dao.ProductsDao;
import model.projects;

@WebServlet("/EditProduct")
public class EditProductServlet extends HttpServlet {

	public EditProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

       

        int id = Integer.parseInt(request.getParameter("id"));

        ProductsDao dao = new ProductsDao();
        projects p = dao.getProductById(id);

        request.setAttribute("product", p);

        request.getRequestDispatcher("Edit-Product.jsp")
               .forward(request, response);
    }
}