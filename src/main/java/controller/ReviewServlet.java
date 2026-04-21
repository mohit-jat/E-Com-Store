package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dao.ProductsDao;

@WebServlet("/AddReview")
public class ReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int pid = Integer.parseInt(request.getParameter("pid"));
        int uid = Integer.parseInt(request.getParameter("uid"));
        int rating = Integer.parseInt(request.getParameter("rating"));
        String msg = request.getParameter("comment");

        ProductsDao dao = new ProductsDao(); 
        
        boolean f = dao.addReview(pid, uid, rating, msg);

        if(f) {
           
            dao.updateProductAverageRating(pid);
            
           response.sendRedirect("GetReviews?pid=" + pid); 
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}