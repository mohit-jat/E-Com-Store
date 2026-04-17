package controller;

import java.io.IOException;
import org.mindrot.jbcrypt.BCrypt;

import Dao.UserDao;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/updatePasswordUsingOtp")
public class Updatepassword extends HttpServlet {

	public Updatepassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        String email = request.getParameter("email").trim().toLowerCase();
        String password = request.getParameter("password").trim();
        String userOtp = request.getParameter("otp").trim();

        HttpSession session = request.getSession();

        String realOtp = (String) session.getAttribute("otp");
        Long time = (Long) session.getAttribute("otpTime");
        String sessionEmail = (String) session.getAttribute("email");

        long currentTime = System.currentTimeMillis();

        if(time == null || (currentTime - time) > 30000){

            request.setAttribute("msg", "OTP Expired ⏳");
            request.getRequestDispatcher("Update-Password.jsp").forward(request, response);
            return;
        }

        if(realOtp == null || !realOtp.equals(userOtp) || !email.equals(sessionEmail)){

            request.setAttribute("msg", "Invalid OTP ❌");
            request.getRequestDispatcher("Update-Password.jsp").forward(request, response);
            return;
        }

        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        UserDao dao = new UserDao();
        int i = dao.updatePassword(email, hashed, userOtp);

        if (i != 0) {

            session.removeAttribute("otp");
            session.removeAttribute("otpTime");
            session.removeAttribute("email");

            response.sendRedirect("Login.jsp");

        } else {
            request.setAttribute("msg", "Something went wrong ❌");
            request.getRequestDispatcher("Udate-Password.jsp").forward(request, response);
        }
    }
}