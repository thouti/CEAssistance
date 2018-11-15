package com.cea.util;


import java.util.Date;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;


@Component
public class MailSendUtil {
public String sendMail(String strEmail,String message,String Subject) throws MessagingException{
		  final String login = "testjavaa123@gmail.com";
		  String strMess="",strDSN="",strEncPwd="";
	        String strResult ="";
	         final String password = "testjavamail";
	        String from ="testjavaa123@gmail.com";
	       // String subject="Request Mail";
	        int userCount=0;
		
	          
				String E1=strEmail;
				String E2=login;
   				String[] toIds = new String[] {E1}; 
	        try {
	            Properties props = System.getProperties();
	            props.put("mail.smtp.starttls.enable","true");
	            props.setProperty("mail.transport.protocol","smtp");
	            props.setProperty("mail.host","smtp.gmail.com");
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.port", "587"); 
	            //props.put("mail.debug", "true");
	            props.put("mail.smtp.socketFactory.port", "465");
	            props.put("mail.smtp.socketFactory.fallback", "false");
	            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(login,password);
	                }
	            });
	            MimeMessage msg = new MimeMessage(session);
	          //  msg.setSubject("Req Id:"+reqid);
	            msg.setContent(message, "text/html");
	            msg.setFrom(new InternetAddress(from));
	            msg.setSubject(Subject);
	            msg.setSentDate(new Date());
	            InternetAddress[] addressTo = new InternetAddress[toIds.length];
				for (int i = 0; i < toIds.length; i++){
				addressTo[i] = new InternetAddress(toIds[i]);
				}
				msg.setRecipients(Message.RecipientType.TO, addressTo);
	           // msg.setRecipients(Message.RecipientType.TO, strEmail);
	            Transport.send(msg);
	            strResult="000"+"~"+strEmail;
	            
	        }catch (AuthenticationFailedException ex) {
		          System.out.println("ErrorMessage ,Authentication failed");
		     ex.printStackTrace();
		          strResult="115";
	        }
	        return strResult;
	}

public String forgotPwdMail(String strEmail, String passwordOne, String url,
		String subject) throws MessagingException {
	 final String login = "testjavaa123@gmail.com";
	  String strMess="",strDSN="",strEncPwd="";
       String strResult ="";
        final String password = "testjavamail";
       String from ="testjavaa123@gmail.com";
      // String subject="Request Mail";
       int userCount=0;
	
         
			String E1=strEmail;
			String E2=login;
				String[] toIds = new String[] {E1}; 
       try {
           Properties props = System.getProperties();
           props.put("mail.smtp.starttls.enable","true");
           props.setProperty("mail.transport.protocol","smtp");
           props.setProperty("mail.host","smtp.gmail.com");
           props.put("mail.smtp.auth", "true");
           props.put("mail.smtp.port", "587"); 
           //props.put("mail.debug", "true");
           props.put("mail.smtp.socketFactory.port", "465");
           props.put("mail.smtp.socketFactory.fallback", "false");
           props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
           Session session = Session.getInstance(props, new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication(login,password);
               }
           });
           MimeMessage msg = new MimeMessage(session);
         //  msg.setSubject("Req Id:"+reqid);
           msg.setContent("Your Password:"+passwordOne+"<br>"+url, "text/html");
           msg.setFrom(new InternetAddress(from));
          // msg.setSubject(url);
           msg.setSubject(subject);
           msg.setSentDate(new Date());
           InternetAddress[] addressTo = new InternetAddress[toIds.length];
			for (int i = 0; i < toIds.length; i++){
			addressTo[i] = new InternetAddress(toIds[i]);
			}
			msg.setRecipients(Message.RecipientType.TO, addressTo);
          // msg.setRecipients(Message.RecipientType.TO, strEmail);
           Transport.send(msg);
           strResult="000"+"~"+strEmail;
           
       }catch (AuthenticationFailedException ex) {
	          System.out.println("ErrorMessage ,Authentication failed");
	     ex.printStackTrace();
	          strResult="115";
       }
       return strResult;
	
}



}