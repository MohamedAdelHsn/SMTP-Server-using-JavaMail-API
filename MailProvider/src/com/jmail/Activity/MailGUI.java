package com.jmail.Activity;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MailGUI extends JFrame {

	
	private  JLabel smtp_mailhost, fromMail , password , toMail , portNumber , subject , message;
	protected static  JTextField smtp_hostfield , fromMailField , toMailField , portNumberField , subjectField ;
	protected static JTextArea message_Area;
	protected static JPasswordField passwordField;
	protected static final String[] items = {"SSL", "TLS"};
	protected static JComboBox comboBox;
	protected static JButton send_btn;
	
	public MailGUI()
	{
		
		initComponents();
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents()
	{
		
		
		  JPanel mail_panel = new JPanel(null);
		  mail_panel.setBorder(BorderFactory.createTitledBorder(null , "Mail Configuration" 
				   , TitledBorder.CENTER, TitledBorder.TOP ,null,Color.darkGray));
		  mail_panel.setBounds(40, 40 , 550 , 350);		
		   
		  smtp_mailhost = new JLabel("smtp host : ");
		  smtp_mailhost.setBounds(30,32,100,25);
		  smtp_mailhost.setFont(new Font("Consolas" , Font.PLAIN , 14));
		  smtp_mailhost.setForeground(Color.BLACK);
		
		  smtp_hostfield = new JTextField();
		  smtp_hostfield.setBounds(smtp_mailhost.getWidth()+22, 34 , 150 , 22);
		
		  portNumber = new JLabel("smtp port :");
		  portNumber.setBounds(310,32,105,25);
		  portNumber.setFont(new Font("Consolas" , Font.PLAIN , 14));
		  portNumber.setForeground(Color.BLACK);
		  
		  
		  portNumberField = new JTextField();
		  portNumberField.setBounds(portNumber.getX()+portNumber.getWidth()-10 , 32 , 85  , 22);
		  		  		  
		  fromMail = new JLabel("from mail :");
		  fromMail.setBounds(30,smtp_mailhost.getY()+smtp_mailhost.getHeight()+10,100,25);
		  fromMail.setFont(new Font("Consolas" , Font.PLAIN , 14));
		  fromMail.setForeground(Color.BLACK);
		  
		  fromMailField = new JTextField();
		  fromMailField.setBounds(smtp_hostfield.getX(),fromMail.getY() ,150 ,22);
		  
		  password = new JLabel("password :");
		  password.setBounds(portNumber.getX(),fromMail.getY() ,90,25);
		  password.setFont(new Font("Consolas" , Font.PLAIN , 14));
		  password.setForeground(Color.BLACK);
		  
		  passwordField = new JPasswordField();
		  passwordField.setBounds(password.getX() + password.getWidth()+5, password.getY() ,120, 22);

		  
		  toMail = new JLabel("to mail :");
		  toMail.setBounds(30,fromMail.getY()+fromMail.getHeight()+10,100,25);
		  toMail.setFont(new Font("Consolas" , Font.PLAIN , 14));
		  toMail.setForeground(Color.BLACK);
		  
		  toMailField = new JTextField();
		  toMailField.setBounds(smtp_hostfield.getX(),toMail.getY() ,150 ,22);
		  
		  
		  comboBox =  new JComboBox(items);
		  comboBox.setBounds(password.getX(),toMail.getY(), 100 , 22);
		  
		  subject = new JLabel("subject :");
		  subject.setBounds(30,toMail.getY()+toMail.getHeight()+10,100,25);
		  subject.setFont(new Font("Consolas" , Font.PLAIN , 14));
		  subject.setForeground(Color.BLACK);
		  
		  subjectField = new JTextField();
		  subjectField.setBounds(smtp_hostfield.getX(),subject.getY() ,350 ,22);
		  
		  
		  message = new JLabel("Message :");		  
		  message.setBounds(30,subject.getY()+subject.getHeight()+10,100,25);
		  message.setFont(new Font("Consolas" , Font.PLAIN , 14));
		  message.setForeground(Color.BLACK);
		  
		  
		  message_Area = new JTextArea();
		  message_Area.setLineWrap(true); 
		  message_Area.setWrapStyleWord(true);		  
		  JScrollPane scrollPane = new JScrollPane(message_Area);     
	      scrollPane.setBounds(smtp_hostfield.getX(),message.getY() ,350 ,125);  
		  
	      
	      send_btn = new JButton("Send");
	      send_btn.setBounds(passwordField.getX()-20, scrollPane.getY()+scrollPane.getHeight(), 87, 28);
		
		  
		  mail_panel.add(smtp_mailhost);	
		  mail_panel.add(smtp_hostfield);
		  mail_panel.add(portNumber);
		  mail_panel.add(portNumberField);
		  mail_panel.add(fromMail);
		  mail_panel.add(fromMailField);
		  mail_panel.add(password);
		  mail_panel.add(passwordField);
		  mail_panel.add(toMail);
		  mail_panel.add(toMailField);
		  mail_panel.add(comboBox);
		  mail_panel.add(subject);
		  mail_panel.add(subjectField);
		  mail_panel.add(message);
		  mail_panel.add(scrollPane);
		  mail_panel.add(send_btn);
		  	 
		  
		  add(mail_panel);
		  setSize(650, 450);
		  setLayout(null);
	      setDefaultLookAndFeelDecorated(true);
		  setDefaultCloseOperation(EXIT_ON_CLOSE);	
		  setResizable(false);
		  setTitle("Mail Provider");		
		  setVisible(true);
		
		
	}
	
}
