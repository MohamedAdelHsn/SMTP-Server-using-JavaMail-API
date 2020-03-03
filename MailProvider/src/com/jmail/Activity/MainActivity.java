package com.jmail.Activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.AuthenticationFailedException;
import javax.swing.JOptionPane;

import com.jmail.Security.SSLSecurityManager;
import com.jmail.Security.SecurityManager;
import com.jmail.Security.TLSSecurityManager;

public class MainActivity extends MailGUI {

	static SecurityManager manager;
	
	 public MainActivity(){
		 
		 // update form design or code 
		 
	 }
	
	
	public static void main(String[] args) {
		
		
		new MainActivity();
		// send message using smtp server 
		send_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(portNumberField.getText() == null || fromMailField.getText()== null  
						||toMailField.getText() == null || passwordField.getPassword().toString()== null 
						|| subjectField.getText() == null 
						|| message_Area.getText() == null)
				{
							
					 JOptionPane.showMessageDialog(null , "please enter real data you might miss some thing !", "\r\n" + 
								"IllegalException" ,2);
					
					
				}
				
				else {
					
					
					try {
						  
						getTypesecurity().sendMail(toMailField.getText(), subjectField.getText(), message_Area.getText());
						
					} catch (AuthenticationFailedException e1) {
						// TODO Auto-generated catch block
						 JOptionPane.showMessageDialog(null , "please enter real mails and password !", "\r\n" + 
									"AuthenticationFailedException" ,2);
					}
					
					
				}
				
				
			}
		});
		

	}
	
	
	
	
	// get the type of security u want 
	public static SecurityManager getTypesecurity() throws AuthenticationFailedException 
	{
		if(comboBox.getSelectedItem().equals("TLS"))
		{
			
				return manager = new TLSSecurityManager(smtp_hostfield.getText(), portNumberField.getText()
						, fromMailField.getText(),passwordField.getPassword().toString());			
			
		}
		
		    // return  SSLSecurity Object 
			return manager = new SSLSecurityManager(smtp_hostfield.getText(), portNumberField.getText()
					,fromMailField.getText(),passwordField.getPassword().toString());
	
		
	}
	
}
