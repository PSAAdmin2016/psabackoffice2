/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.List;

import com.psabackoffice.psa.models.procedure.*;

@Deprecated
public interface PSAProcedureExecutorService_V1 {

    @Deprecated
    List<Object> executeCreateNewJobDB(Integer jobNumber);

    @Deprecated
    List<Object> executeCreateNewConversation(Integer varCreator, Integer varRecipient);

    @Deprecated
    List<Object> executeValidateLandingData(String tableName, String jobNumber);

    @Deprecated
    List<Object> executeGetImportTotals(String tableNameLanding, String tableNameDestination, String jobNumber);

    @Deprecated
    List<Object> executeCreateNewJobSeeds(Integer jobNumber);

}


