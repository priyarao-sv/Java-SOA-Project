package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CheckLogin;


@WebServlet("/loginform")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		CheckLogin cl = new CheckLogin();
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		
		String user = email.substring(0, email.indexOf('@'));
	
		try {
			String check = cl.verifyEmail(email, password);
			if(check.equals("No such email in our db")) {
				String register = "New member? Register here!";
			    request.setAttribute("register", register);
				request.getRequestDispatcher("loginform.jsp").forward(request, response);
			} else if(check.equals("Success")){
				request.setAttribute("user", user);
				request.getRequestDispatcher("success.jsp").forward(request, response);
			} else if(check.equals("Invalid Password")){
				String message = "Invalid password";
			    request.setAttribute("message", message);
				request.getRequestDispatcher("loginform.jsp").forward(request, response);
			}		
			
		} catch (ClassNotFoundException | SQLException e) {
			out.print(e);
		}
	}
}
