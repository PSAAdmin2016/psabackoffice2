/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import com.psabackoffice.email.model.*;
import com.wavemaker.runtime.service.annotations.ExposeToClient;

//My Imports
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
//import microsoft.exchange.webservices.data.*;
//import java.net.URI;


@ExposeToClient
public class Email {

    private static final Logger logger=LoggerFactory.getLogger(Email.class);


    public String sendEmail(String from, String subject, String body, String fileDir, String fileName, String to, String emailServer, String emailPort, String userName, String password){
        String result = null;
        Boolean attachment = false;
        final String fusername = userName;
        final String fpassword = password;

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", emailServer);
        properties.setProperty("mail.smtp.port", emailPort);
		properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.auth", true);
        
        Session session = Session.getInstance(properties,
            new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(fusername, fpassword);
                }
            }
        );
        
        try {
            logger.debug("Starting Email try...");
            MimeMessage message = new MimeMessage(session);
            
            //Email Header
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setSentDate(new Date());
            
            //Email Body
            logger.debug("Email Body...");
            MimeBodyPart messageBody = new MimeBodyPart();
            messageBody.setContent(body, "text/html");
            
            //Email Attachments
            if (fileName != null) {
                logger.debug("Attachment...");
                MimeBodyPart messageAttachment = new MimeBodyPart();
                
                FileDataSource fileDataSource = new FileDataSource(fileDir + fileName) {
                    //@Override
                    public String getContentType() {
                        return "application/octet-stream";
                    }
                };
                
                messageAttachment.setDataHandler(new DataHandler(fileDataSource));
                messageAttachment.setFileName(fileName);
                
                //Assemble Email parts
                logger.debug("Assembling Attachment Email...");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBody);
                multipart.addBodyPart(messageAttachment);
                message.setContent(multipart);
                
            } else {
                //Assemble Email parts
                logger.debug("Assembling NON-Attachment Email...");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBody);
                message.setContent(multipart);
            }

            //Send Email 
            logger.debug("Sending Email...");;
            Transport transport = session.getTransport("smtp");
            transport.connect(emailServer, userName, password);
            Transport.send(message);
            logger.debug("Send Complete...");
            
            return "1";
        } catch (AddressException e) {
            logger.error("Email Java Service encountered Address error: ");
            e.printStackTrace();
            return "Email Java Service encountered Address error: " + e.toString();
        } catch (MessagingException e) {
            logger.error("Email Java Service encountered Messaging error: ");
            e.printStackTrace();
            return "Email Java Service encountered Messaging error: " + e.toString();
        }
        
        
    }


}
