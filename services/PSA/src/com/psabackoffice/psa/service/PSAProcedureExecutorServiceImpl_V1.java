/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;

import com.psabackoffice.psa.models.procedure.*;

@Service
public class PSAProcedureExecutorServiceImpl_V1 implements PSAProcedureExecutorService_V1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(PSAProcedureExecutorServiceImpl.class);

    @Autowired
    @Qualifier("PSAWMProcedureExecutor")
    private WMProcedureExecutor procedureExecutor;

    public List<Object> executeGetImportTotals(String tableNameLanding, String tableNameDestination, String jobNumber) {
        Map params = new HashMap(8);

        params.put("tableNameLanding", tableNameLanding);
        params.put("tableNameDestination", tableNameDestination);
        params.put("jobNumber", jobNumber);

        return procedureExecutor.executeNamedProcedure("GetImportTotals", params);

    }

    public List<Object> executeCreateNewJobDB(Integer jobNumber) {
        Map params = new HashMap(2);

        params.put("jobNumber", jobNumber);

        return procedureExecutor.executeNamedProcedure("CreateNewJobDB", params);

    }

    public List<Object> executeCreateNewJobSeeds(Integer jobNumber) {
        Map params = new HashMap(2);

        params.put("jobNumber", jobNumber);

        return procedureExecutor.executeNamedProcedure("CreateNewJobSeeds", params);

    }

    public List<Object> executeCreateNewConversation(Integer varCreator, Integer varRecipient) {
        Map params = new HashMap(4);

        params.put("varCreator", varCreator);
        params.put("varRecipient", varRecipient);

        return procedureExecutor.executeNamedProcedure("CreateNewConversation", params);

    }

    public List<Object> executeValidateLandingData(String tableName, String jobNumber) {
        Map params = new HashMap(4);

        params.put("tableName", tableName);
        params.put("jobNumber", jobNumber);

        return procedureExecutor.executeNamedProcedure("ValidateLandingData", params);

    }

}


