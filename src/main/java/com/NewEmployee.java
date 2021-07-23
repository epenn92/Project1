package com;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewEmployee
 */
public class NewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NewEmployee.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phonenumber");
		String managerEmail = "magicalpen92@gmail.com";
		System.out.println(firstName + " " + lastName + " " + email + " " + phoneNumber + " " + managerEmail);
		
		  
		  String destmailid = managerEmail;
	      String sendrmailid = managerEmail; 
	     //Mention user name and password as per your configuration
	      final String uname = "magicalpen92@gmail.com";
	      final String pwd = "Testing8!";
	      //We are using relay.jangosmtp.net for sending emails
	      String smtphost = "relay.jangosmtp.net";
	     //Set properties and their values
	      Properties propvls = new Properties();
	      propvls.put("mail.smtp.auth", "true");
	      propvls.put("mail.smtp.starttls.enable", "true");
	      propvls.put("mail.smtp.host", smtphost);
	      propvls.put("mail.smtp.port", "25");
	      //Create a Session object & authenticate uid and pwd
	      Session sessionobj = Session.getInstance(propvls,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(uname, pwd);
		   }
	         });

	      try {
		   //Create MimeMessage object & set values
		   Message messageobj = new MimeMessage(sessionobj);
		   messageobj.setFrom(new InternetAddress(sendrmailid));
		   messageobj.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destmailid));
		   messageobj.setSubject("This is test Subject");
		   messageobj.setText("Checking sending emails by using JavaMail APIs");
		  //Now send the message
		   Transport.send(messageobj);
		   System.out.println("Your email sent successfully....");
	      } catch (MessagingException exp) {
	         throw new RuntimeException(exp);
	      }
	   
		
		response.sendRedirect(request.getContextPath() + "");

	}

}
