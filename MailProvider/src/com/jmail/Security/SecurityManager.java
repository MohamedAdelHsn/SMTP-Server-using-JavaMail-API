package com.jmail.Security;


public abstract class SecurityManager {
 
	 public abstract void sendMail(String toEmail , String subject  , String body_message);
	
	 public abstract  String getDefaultPort(); 


 }
