package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VerificationStatus;

@WebServlet("/verify")
public class Verify extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		VerificationStatus status = new VerificationStatus();
		String email = (String)request.getParameter("email");
		try {
			boolean isVerified = status.verifyStatus(email);
			if(isVerified){
				out.print(email + " verified succefully");
			} else {
				out.print(email + " not verified");
			}
		} catch (ClassNotFoundException | SQLException e) {
			out.print(e);
		}
	}
	
}
