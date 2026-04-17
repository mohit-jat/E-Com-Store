package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

import Dao.ContactDao;

@WebServlet("/Contact")
public class ContactServlet extends HttpServlet {

	
	public ContactServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Contact.jsp").forward(request, response);


		
	}
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        ContactDao dao = new ContactDao();

        boolean f = dao.saveContact(name, email, message);

        if(f){
            System.out.println("Contact message saved");
        } else {
            System.out.println("Failed to save contact message");
        }

        
        request.getRequestDispatcher("Contact.jsp").forward(request, response);
    }
}