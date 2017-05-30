/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.emailews;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

//My Imports
import java.util.*;
import microsoft.exchange.webservices.data.core.*;
import microsoft.exchange.webservices.data.core.service.item.*;
import microsoft.exchange.webservices.data.property.complex.*;
import microsoft.exchange.webservices.data.credential.*;
//import microsoft.exchange.webservices.data.ExchangeService;
import java.net.URI;


@ExposeToClient
public class EmailEWS {

    private static final Logger logger = LoggerFactory.getLogger(EmailEWS.class);

    @Autowired
    private SecurityService securityService;

        public String sendEmail(String to, String subject, String body, String fileDir, String fileName,  String emailServerURL, String userName, String userDomain, String password){
            String result = null;
            Boolean attachment = false;
            final String fusername = userName;
            final String fpassword = password;
            
            //Setup Connection Properties
            ExchangeService service = new ExchangeService();
            ExchangeCredentials creds = new WebCredentials(userName, password, userDomain);
            URI webAddress = URI.create (emailServerURL);
            logger.debug("URL" + webAddress);
            service.setCredentials(creds);
            service.setUrl(webAddress);
            
            logger.debug("Starting Email Web API try...");
            try {
                //Build Message
                logger.debug("Building Message...");
                EmailMessage msg= new EmailMessage(service);
                msg.setSubject(subject);
                msg.setBody(MessageBody.getMessageBodyFromText(body));
                if(fileName != null || fileName != ""){
                    logger.debug("Attaching File...");
                    msg.getAttachments().addFileAttachment(fileDir + fileName);
                }
                
                //Build Recipients list
                logger.debug("Building Recipients...");
                String[] recipients = to.split(",");
                for(String emailAddress : recipients){
                    msg.getToRecipients().add(emailAddress);
                }
                
                //Send Email
                logger.debug("Sending email...");
                msg.send();
                return "1";
                
            } catch (Exception e) {
                logger.error("Email EWS Java Service encountered error: ");
                e.printStackTrace();
                return "Email EWS Java Service encountered error: " + e;
            } 
        }


}
