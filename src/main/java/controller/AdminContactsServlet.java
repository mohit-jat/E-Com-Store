package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

import Dao.ContactDao;
import model.Contact;

@WebServlet("/AdminContacts")
public class AdminContactsServlet extends HttpServlet {

  
	public AdminContactsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ContactDao dao = new ContactDao();

        List<Contact> list = dao.getAllContacts();

        request.setAttribute("contacts", list);

        request.getRequestDispatcher("Admin-Contacts.jsp").forward(request, response);
    }
}