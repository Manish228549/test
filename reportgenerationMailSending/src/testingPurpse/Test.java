package testingPurpse;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test 
{
	
	//NOTE : VPN MUST BE CONNECTED TO USE OFFICE MAIL(EXPERIENCED FROM ERROR (javax.mail.MessagingException: Could not connect to SMTP host: mail2.molecularconnections.com, port: 25;)
	
	public static void main(String[] args) throws AddressException 
	 {  
	  
		 String host="mail2.molecularconnections.com";  
		  final String user="manish.k@molecularconnections.com";//change accordingly  
		  final String password="Ssm9430#";//change accordingly  
	    
		  String to="theroyalmanishmaurya@gmail.com";//change accordingly  
		// create a new String array
		  Address[] myCcList = InternetAddress.parse("manish228549@gmail.com,sasaramkigaliyan@gmail.com");

		  
		

		 

	  
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
	    try {  
	     MimeMessage message = new MimeMessage(session);  
	     message.setFrom(new InternetAddress(user));  
	     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	     
	    //----------------------------------------------------------------------------new code 
	     
//	     message.setRecipients(Message.RecipientType.CC,myCcList);
	   
	  // changes,...

	     message.addRecipients(Message.RecipientType.CC, myCcList);
		  
		  
		  
	     
	//--------------------------------------------------------------------     
	     message.setSubject("javatpoint");  
	     message.setText("This is simple program of sending email using JavaMail API");  
	       
	    //send the message  
	     Transport.send(message);  
	  
	     System.out.println("message sent successfully...");  
	   
	     } 
	    catch (MessagingException e) 
	    {
	    	e.printStackTrace();
	    }  
	 }  
	}  


