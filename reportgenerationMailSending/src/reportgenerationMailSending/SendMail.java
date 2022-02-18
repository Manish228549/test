package reportgenerationMailSending;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import utility.DbOperation;

public class SendMail 
{
	//NOTE : VPN MUST BE CONNECTED TO USE OFFICE MAIL(EXPERIENCED FROM ERROR (javax.mail.MessagingException: Could not connect to SMTP host: mail2.molecularconnections.com, port: 25;)
	 
	public static void main(String[] args) 
	 {  
		 String messageToBeSent = DbOperation.getRecord();
		 
		  String host="mail2.molecularconnections.com";  
		  final String user="manish.k@molecularconnections.com";//change accordingly  
		  final String password="Ssm9430#";//change accordingly  
		    
		  try { 
//		  String to="theroyalmanishmaurya@gmail.com";//change accordingly  
//		  String to="debashish@molecularconnections.com";//change accordingly  
		  String to="manish.k@molecularconnections.com";//change accordingly  
		// create a new String array for CC
		  Address[] myCcList = InternetAddress.parse("debashish@molecularconnections.com,prathap.mp@molecularconnections.com,manish228549@gmail.com");
		  
		   //Get the session object  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.auth", "true");  
		     
		   Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,password);  
		      }  
		    });  
		  
		   //Compose the message  
		    
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		     
		     message.addRecipients(Message.RecipientType.CC, myCcList);
		     
		     message.setSubject("Custom ooutput for Mcpairs report generator and mailer"); 
		     
		  // we use setContent() for sending html, otherwise for normal text we use setText()
//		     message.setContent("\nHi sir, \n\nThis is automated message ,please treat this as final output of yesterdays project Mcpairs report generator and mailer \n\n"+messageToBeSent +"\n\n\nThanks And Regards, \nManish Kumar","text/html");  
		     
		     message.setContent(messageToBeSent,"text/html"); 
//		     message.setText("Thanks");
		       
		    //send the message  
		     Transport.send(message);  
		  
		     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {e.printStackTrace();}  
		 }  
}
