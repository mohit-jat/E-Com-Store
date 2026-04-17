package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

import Dao.HelpDao;

@WebServlet("/Help")
public class HelpServlet extends HttpServlet {

  
	public HelpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		request.getRequestDispatcher("Help.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
    	
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        HelpDao dao = new HelpDao();

        boolean f = dao.saveSupport(name, email, message);

        if(f){
            System.out.println("Support message saved successfully");
        } else {
            System.out.println("Failed to save message");
        }

		request.getRequestDispatcher("Help.jsp").forward(request, response);
    }
}