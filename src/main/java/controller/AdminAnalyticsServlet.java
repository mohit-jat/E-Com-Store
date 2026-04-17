package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

import Dao.OrderDao;

@WebServlet("/AdminAnalytics")
public class AdminAnalyticsServlet extends HttpServlet {

    public AdminAnalyticsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderDao dao = new OrderDao();

        java.util.Calendar cal = java.util.Calendar.getInstance();
        int year = cal.get(java.util.Calendar.YEAR);
        int month = cal.get(java.util.Calendar.MONTH) + 1;

        double yearSales = dao.getYearSales(year);
        double monthSales = dao.getMonthSales(month, year);
        String topProduct = dao.getTopProduct();
        String topCategory = dao.getTopCategory();

        request.setAttribute("yearSales", yearSales);
        request.setAttribute("monthSales", monthSales);
        request.setAttribute("topProduct", topProduct);
        request.setAttribute("topCategory", topCategory);

        request.getRequestDispatcher("Admin-Analytics.jsp")
               .forward(request, response);
    }
}