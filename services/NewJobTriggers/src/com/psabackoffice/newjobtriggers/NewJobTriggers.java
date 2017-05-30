/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.newjobtriggers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

//My Imports...
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;


@ExposeToClient
public class NewJobTriggers {

    private static final Logger logger = LoggerFactory.getLogger(NewJobTriggers.class);
    @Autowired
    private SecurityService securityService;
    @Autowired
    @Qualifier("Job1111DataSource")
    private DataSource datasource;


//Create Triggers with Retrieved SQL query
    public String createTriggers(int jobNumber){
        Connection connection = null;
        
        try{
            //Connect to DB
            connection = datasource.getConnection();
            
            CallableStatement cStmt = connection.prepareCall("call PSA.Create_JobTriggersStatement(?)");
            cStmt.setInt(1,jobNumber);
            ResultSet rs1 = cStmt.executeQuery();
            while (rs1.next()){
                try{
                    connection.createStatement().execute(rs1.getString(1));
                } catch(SQLException e){
                    System.out.println("createTriggers Failure : " + jobNumber + " : " + e);
                    return "createTriggers Failure : " + jobNumber + " : " + e;
                }
            }

            return "1";
        } catch(SQLException e){
            System.out.println("getTriggers Failure : " + jobNumber + " : " + e);
            return "getTriggers Failure : " + jobNumber + " : " + e;
        } finally {
            try{
                    if(connection!=null){
                        connection.close();
                    }
                } catch(SQLException e){
                    throw new RuntimeException(e);
                }
        }
    }


}
