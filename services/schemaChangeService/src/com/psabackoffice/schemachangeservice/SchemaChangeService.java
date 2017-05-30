/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.schemachangeservice;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.psabackoffice.schemachangeservice.model.*;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import javax.servlet.http.*;
import org.apache.commons.lang3.StringUtils;
import com.psabackoffice.psa.service.TblUserPsaService;
import org.springframework.beans.factory.annotation.Autowired;
import com.wavemaker.runtime.security.SecurityService;
import com.psabackoffice.psa.TblUserPsa;

/**
 * This is a singleton class with all of its public methods exposed to the client via controller.
 * Their return values and parameters will be passed to the client or taken
 * from the client respectively.
 */
@ExposeToClient
public class SchemaChangeService {

    private static final String DEFAULT_SCHEMA = "Job1111";

    @Autowired
    private SecurityService securityService;

    @Autowired
    private TblUserPsaService tblUserPsaService;
    private static final Logger logger=LoggerFactory.getLogger(SchemaChangeService.class);
    
    public String changeSchema(String newSchema, HttpServletRequest request){
        
        if(StringUtils.isNotBlank(newSchema)){
            logger.info("NEW SCHEMA: " + newSchema);
            request.getSession().setAttribute("jobNumber",newSchema);
            logger.info("SETTING JOB NUMBER ATTRIBUTE TO: " + request.getSession().getAttribute("jobNumber"));
        return newSchema;
        } else {
            return DEFAULT_SCHEMA;
        }
    }
    
    public String getSchemaForUser(String userName){
        boolean authenticated = securityService.isAuthenticated();
        if (authenticated){
            String userID = securityService.getUserId();
            logger.info("user ID is: " + userID);
            final TblUserPsa tblUserPsa = tblUserPsaService.findById(Integer.parseInt(userID));

            //String jobID = String.valueOf(tblUserPsa.getTblJobNumbers().getJobNumber());
            String jobID = String.valueOf(tblUserPsa.getFkDefaultJobNumberId());
            
            return getUpdatedJobNumber(jobID);   
        }else{
            logger.warn("Warning: Can not access this service with out being authenticated");
          return DEFAULT_SCHEMA;    
        }
        
    }
    
    
    private String getUpdatedJobNumber(String jobNumber) {
        if (jobNumber.startsWith("Job")){
            return jobNumber;
        }
        return "Job" + jobNumber;
    }
}