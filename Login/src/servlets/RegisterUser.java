package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Registration;
import mail.Verification;


@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		String user = email.substring(0, email.indexOf('@'));
		Registration reg = new Registration();
		int registered;
		try {
			registered = reg.RegisterUser(email, password);
			Verification.sendMail(email);
			if(registered > 0){
				out.print("<h3 style=\"color: #69d900; text-align:center\">Registration for " + user + " is successful</h3>");
			} else {
				out.print("Already registered user<br>Click&nbsp;<a href=\"./loginform.jsp\">here</a>&nbsp;to Login");
			}
		} catch (ClassNotFoundException | SQLException | MessagingException e) {
			out.print(e);
		}		
	}
	
}
