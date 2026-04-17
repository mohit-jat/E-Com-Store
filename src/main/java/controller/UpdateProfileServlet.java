
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import Dao.UserDao;
import model.USER;

@WebServlet("/UpdateProfile")
public class UpdateProfileServlet extends HttpServlet {
	
	
	public UpdateProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}




	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("user") == null){
            response.sendRedirect("Login.jsp");
            return;
        }

        USER user = (USER) session.getAttribute("user");

        request.setAttribute("user", user);

        request.getRequestDispatcher("Update-Profile.jsp").forward(request, response);
    }

    
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        UserDao dao = new UserDao();
       int  status = dao.updateUserFull(
                user.getUser_id(), name, email, phone, address
        );

        if(status!=0){
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            user.setAddress(address);
            session.setAttribute("user", user);
            response.sendRedirect("Profile");
            
        } else {
            response.getWriter().println("Update Failed!");
        }
    }
}