/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.fileimporter;

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
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;


@ExposeToClient
public class FileImporter {

    private static final Logger logger = LoggerFactory.getLogger(FileImporter.class);
    @Autowired
    private SecurityService securityService;
    @Autowired
    @Qualifier("Job1111DataSource")
    private DataSource datasource;


    //File Import function
    public String importFile(String jobNumber, String tableName, String fileName ){
        Connection connection = null;
        //String path = "/root/WaveMaker/appdata/PSABackOffice/uploads/jobData/" + jobNumber + "/" + tableName + "/" + fileName; //UNCOMMENT in Dev Enviroment
        String path = "/home/tomcat/WaveMaker/appdata/PSABackOffice/uploads/jobData/" + jobNumber + "/" + tableName + "/" + fileName; //UNCOMMENT in Production Enviroment
        
            try{
                //Connect to DB
                connection = datasource.getConnection(); 

                //SQL Statement 
                connection.createStatement().execute("TRUNCATE " + tableName);
                connection.createStatement().execute("LOAD DATA LOCAL INFILE " + "'" + path + "'" + "INTO TABLE `" + tableName + "` FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"' LINES TERMINATED BY '\r\n'");

                return "1";
            } catch(SQLException e){
                return "INFILE Failure : " + path + " : " + tableName + " : " + e;
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