package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

import Dao.ProductsDao;
import model.projects;

@WebServlet("/viewProduct")
public class ViewMore extends HttpServlet {

    
	public ViewMore() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        String idParam = request.getParameter("id");

        if(idParam != null){
            int id = Integer.parseInt(idParam);

            ProductsDao dao = new ProductsDao();
            projects p = dao.getProductById(id);

            request.setAttribute("product", p);
        }

        request.getRequestDispatcher("Profile-View.jsp").forward(request, response);
    }
}