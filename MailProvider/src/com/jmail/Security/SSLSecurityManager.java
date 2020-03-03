package com.jmail.Security;

import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.jmail.util.EmailUtil;


public class SSLSecurityManager extends SecurityManager {
	
	
	private String port;  // ssl  default port 
	private String fromEmail ; //requires valid mail id	
	private String password ; // correct password for mail id
	private String toEmail ; // can be any email id 
	private String host_smtp;
	private Properties props;
	private Authenticator auth;
	private Session session;
	
	
	public SSLSecurityManager(String host_smtp, String port ,String fromEmail , String password)throws AuthenticationFailedException
	{
		
		
		this.fromEmail = fromEmail;
		this.password = password;
		this.host_smtp= host_smtp;
		this.port = port;
		
		// setup smtp host to send messages
		props = new Properties();
		props.put("mail.smtp.host", "smtp."+host_smtp+".com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", port); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", port); //SMTP Port
		
		 auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		
		this.session = Session.getInstance(props, auth);		
	
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
		 return  "465";		
	}

}
