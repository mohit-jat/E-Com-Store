package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Dao.UserDao;
import model.USER;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

    public ChangePasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔥 CACHE CONTROL (IMPORTANT)
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("activeUser") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        String oldP = request.getParameter("oldPass");
        String newP = request.getParameter("newPass");

        USER u = (USER) session.getAttribute("activeUser");

        UserDao dao = new UserDao();
        int i = dao.changePassword(u.getUser_id(), oldP, newP);

        if (i != 0) {
            session.setAttribute("succMsg", "Password Updated!");
        } else {
            session.setAttribute("errorMsg", "Old password is wrong!");
        }

        response.sendRedirect("Settings.jsp");
    }
}