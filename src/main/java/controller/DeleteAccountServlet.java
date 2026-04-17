package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.USER;

import java.io.IOException;

import Dao.UserDao;

@WebServlet("/DeleteAccount")
public class DeleteAccountServlet extends HttpServlet {

   
	public DeleteAccountServlet() {
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

        if(session == null || session.getAttribute("user") == null){
            response.sendRedirect("Login.jsp");
            return;
        }

        USER user = (USER) session.getAttribute("user");

        UserDao dao = new UserDao();
        int i = dao.deleteAccount(user.getUser_id());

        if(i > 0){
            session.invalidate();
            response.sendRedirect("Signup");
        } else {
            response.getWriter().println("Delete Failed!");
        }
    }
}