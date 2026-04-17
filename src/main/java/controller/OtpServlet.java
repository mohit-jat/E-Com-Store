package controller;

import java.io.IOException;
import java.util.Properties;

import Dao.UserDao;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/OTP")
public class OtpServlet extends HttpServlet {

   
	public OtpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	private String generateOTP() {
        String s = "";
        for (int i = 1; i <= 4; i++) {
            s += (int) (Math.random() * 10);
        }
        return s;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
        
        String email = request.getParameter("email");

        if (email == null || email.trim().isEmpty()) {
            response.getWriter().println("Email required");
            return;
        }

        email = email.trim().toLowerCase();

        String otp = generateOTP();
        String ms = "Your OTP is: " + otp;

        UserDao dao = new UserDao();
        int i = dao.storeOtp(email, otp);

        if (i == 0) {
            response.getWriter().println("Email not found in database");
            return;
        }
        String from = "mohitjat743@gmail.com";
		String appPass = "ioyf iiju kmjh ilja";
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, appPass);
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            msg.setSubject("OTP Verification");
            msg.setText(ms);

            Transport.send(msg);

            HttpSession sessionObj = request.getSession();
            sessionObj.setAttribute("otp", otp);
            sessionObj.setAttribute("otpTime", System.currentTimeMillis()); // 30 sec timer
            sessionObj.setAttribute("email", email);

            request.getRequestDispatcher("Update-Password.jsp").forward(request, response);


        } catch (MessagingException e) {
            e.printStackTrace();
            response.getWriter().println("Email sending failed");
        }
    }
}