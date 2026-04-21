package controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Review;

import java.io.IOException;
import java.util.List;

import Dao.ProductsDao;


@WebServlet("/GetReviews")
public class GetReviewsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));

        ProductsDao dao = new ProductsDao();
        
        List<Review> list = dao.getReviewsByProduct(pid);
        
        model.Products p = dao.getProductById(pid); 

        request.setAttribute("reviewList", list);
        request.setAttribute("product", p);

        request.getRequestDispatcher("Profile-View.jsp").forward(request, response);
    }
}