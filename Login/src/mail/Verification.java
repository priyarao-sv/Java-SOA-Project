package mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Verification {
	
	public static void sendMail(String recepient) throws AddressException, MessagingException {		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String senderEmail = "dummymailer92@gmail.com";
		String senderPassword = "dummymailer123";
		
		Session session = Session.getInstance(properties, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});
		
		Message message = verificationMessage(session, senderEmail, recepient);
		
		Transport.send(message);
	}

	private static Message verificationMessage(Session session, String senderEmail, String recepient) throws AddressException, MessagingException {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(senderEmail));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
		message.setSubject("Verification");
		String htmlContent = "Hello +" recepient+" <br/>To get verified,&nbsp;click&nbsp;<a href=\"http://localhost:8080/Login/verify?email=" + recepient + "\">here</a>";
		message.setContent(htmlContent, "text/html");
		return message;
	}
}