package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

import Dao.ProductsDao;
import model.projects;

@WebServlet("/Category")
public class CategoryServlet extends HttpServlet {

    public CategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            ProductsDao dao = new ProductsDao();

            String type = request.getParameter("type");

            List<projects> list = new ArrayList<>();

            if ("Electronics".equalsIgnoreCase(type)) {
                list = dao.getElectronicsProducts();
            }
            else if ("Fashion".equalsIgnoreCase(type)) {
                list = dao.getFashionProducts();
            }
            else if ("Beauty".equalsIgnoreCase(type) || "Health".equalsIgnoreCase(type)) {
                list = dao.getBeautyProducts();
            }
            else if ("Home".equalsIgnoreCase(type) || "HomeDecor".equalsIgnoreCase(type)) {
                list = dao.getHomeProducts();
            }
            else if ("Mobiles".equalsIgnoreCase(type)) {
                list = dao.getMobileProducts();
            }
            else if ("Laptops".equalsIgnoreCase(type)) {
                list = dao.getLaptopProducts();
            }
            else if ("Sports".equalsIgnoreCase(type)) {
                list = dao.getSportsProducts();
            }
            
            else {
                list = dao.getAllProducts();
            }

            request.setAttribute("Products", list);
            request.setAttribute("categoryName", type);
            request.setAttribute("count", list.size());

            request.getRequestDispatcher("Index.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}