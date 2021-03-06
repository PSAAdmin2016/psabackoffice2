/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.emailsmtp;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

//import com.psabackoffice.emailsmtp.model.*;
//My Imports
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@ExposeToClient
public class EmailSMTP {


    private static final Logger logger=LoggerFactory.getLogger(EmailSMTP.class);


    public String sendEmail(String from, String subject, String body, String fileDir, String fileName, String to, String emailServerHost, String emailPort, String userName, String password){
        String result = null;
        Boolean attachment = false;
        
        //Set Default connection properties
        if (from == "" || from == null){
            from = "PSAMailer@Performance-Contractors.com";
        }
        if (emailServerHost == "" || emailServerHost == null){
            emailServerHost = "webmail.performance-br.com";
        }
        if (emailPort == "" || emailPort == null){
            emailPort = "324";
        }
        if (userName == "" || userName == null){
            userName = "Psamailer@performance.performance-contractors.com";
        }
        if (password == "" || password == null){
            password = "e_8Vdmy6/3.;_WoK";
        }
        
        
        logger.debug("EmailServerHost..." + emailServerHost);
        
        final String fusername = userName;
        final String fpassword = password;

        //### Connection Settings ###
        Properties properties = new Properties();
        properties.put("mail.smtp.host", emailServerHost);
        properties.put("mail.smtp.port", emailPort);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.auth", "true");
        
        
        Session session = Session.getInstance(properties,
            new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(fusername, fpassword);
                }
            }
        );
        
        //### Build Message ###
        try {
            logger.debug("Starting Email try...");
            
            //Email Header
            logger.debug("Email Header...");
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setSentDate(new Date());
            
            //Email Body
            logger.debug("Email Body...");
            MimeBodyPart messageBody = new MimeBodyPart();
            messageBody.setContent(body, "text/html");
            
            //Email Attachments
            logger.debug("Attachments...");
            if (fileName != null) {
                MimeBodyPart messageAttachment = new MimeBodyPart();
                
                FileDataSource fileDataSource = new FileDataSource(fileDir + fileName) {
                    //@Override
                    public String getContentType() {
                        return "application/octet-stream";
                    }
                };
                
                messageAttachment.setDataHandler(new DataHandler(fileDataSource));
                messageAttachment.setFileName(fileName);
                
                //Assemble Email parts With attachment
                logger.debug("Assembling Attachment Email...");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBody);
                multipart.addBodyPart(messageAttachment);
                message.setContent(multipart);
                
            } else {
                //Assemble Email parts with OUT attachment
                logger.debug("Assembling NON-Attachment Email...");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBody);
                message.setContent(multipart);
            }

            //### Send Email ### 
            logger.debug("Sending Email...");;
            Transport transport = session.getTransport("smtp");
            transport.connect(emailServerHost, userName, password);
            Transport.send(message);
            logger.debug("Send Complete...");
            transport.close();
            
            return "1";
            
        //### Handle Exceptions ### 
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
