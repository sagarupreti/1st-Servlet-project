/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ideapad-520S
 */
public class Mailer {
    private String to,from,subject,body;
    private String host,port;
    
    public Mailer(){
        
    }

    public String getTo() {
        return to;
    }

    public Mailer setTo(String to) {
        this.to = to;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public Mailer setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Mailer setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Mailer setBody(String body) {
        this.body = body;
        return this;
    }

    public String getHost() {
        return host;
    }

    public Mailer setHost(String host) {
        this.host = host;
        return this;
    }

    public String getPort() {
        return port;
    }

    public Mailer setPort(String port) {
        this.port = port;
        return this;
    }
    
    public void send() {
       
       Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        
         try {
             
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));
         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         // Set Subject: header field
         message.setSubject(subject);
         // Now set the actual message
         message.setText(body);
         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
        
      } catch (MessagingException mex) {
             System.out.println(mex.getMessage());
      }
    }
}
