package com.jmail.Security;

import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import com.jmail.util.EmailUtil;


public class TLSSecurityManager extends SecurityManager {

	
	private String port;  // ssl  default port 
	private String fromEmail ; //requires valid mail id
	private String password ; // correct password for mail id
	private String toEmail ; // can be any email id 
	private String host_smtp;
	private Properties props;
	private Session session;
	
	
	 public TLSSecurityManager(String host_smtp, String port , String fromEmail , String password) throws AuthenticationFailedException{
		 
		 
			this.fromEmail = fromEmail;
			this.password = password;
			this.host_smtp= host_smtp;
			this.port = port;
		 
		    props= new Properties();
			props.put("mail.smtp.host", "smtp."+host_smtp+".com"); //SMTP Host
			props.put("mail.smtp.port", port); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
			
	        //create Authenticator object to pass in Session.getInstance argument
			
			Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
			
           };

               session = Session.getInstance(props, auth);

	 }


	@Override
	public void sendMail(String toEmail, String subject, String body_message) {
		
		  try {
			EmailUtil.sendEmail(session, toEmail, subject, body_message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}
	
	
	public String getDefaultPort() 
	{		
		 return "587";		
	}
	 
	 
	
	
}
