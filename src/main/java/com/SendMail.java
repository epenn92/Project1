package com;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
   public static void main(String[] args) {
      //Declare recipient's & sender's e-mail id.
      String destmailid = "destemail@eduonix.com";
      String sendrmailid = "frmemail@eduonix.com";	  
     //Mention user name and password as per your configuration
      final String uname = "username";
      final String pwd = "password";
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
   }
}