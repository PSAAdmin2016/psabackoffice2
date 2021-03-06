/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.job1111.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigDecimal;
import java.sql.Date;
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

import com.psabackoffice.job1111.models.procedure.*;

@Service
public class Job1111ProcedureExecutorServiceImpl_V1 implements Job1111ProcedureExecutorService_V1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Job1111ProcedureExecutorServiceImpl.class);

    @Autowired
    @Qualifier("Job1111WMProcedureExecutor")
    private WMProcedureExecutor procedureExecutor;

    public List<Object> executeGetSteelPCOT(Integer runMode) {
        Map params = new HashMap(3);

        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetSteelPCOT", params);

    }

    public List<Object> executeCreateManualActivitySteel(Integer varBidId, Integer varActivityType, Integer varQuantity, BigDecimal varPercentCompleted, String varNotes, Integer varUserId) {
        Map params = new HashMap(8);

        params.put("varBidID", varBidId);
        params.put("varActivityType", varActivityType);
        params.put("varQuantity", varQuantity);
        params.put("varPercentCompleted", varPercentCompleted);
        params.put("varNotes", varNotes);
        params.put("varUserID", varUserId);

        return procedureExecutor.executeNamedProcedure("CreateManualActivitySteel", params);

    }

    public List<Object> executeLockSASActivity(Integer runMode, Integer userId, Integer activityId) {
        Map params = new HashMap(5);

        params.put("RunMode", runMode);
        params.put("UserID", userId);
        params.put("ActivityID", activityId);

        return procedureExecutor.executeNamedProcedure("LockSASActivity", params);

    }

    public List<Object> executeGetPipePCOT(Integer runMode) {
        Map params = new HashMap(3);

        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetPipePCOT", params);

    }

    public List<Object> executeClassicTrackerPipeUpdate(Integer runMode, Integer updateBidId) {
        Map params = new HashMap(4);

        params.put("RunMode", runMode);
        params.put("UpdateBidID", updateBidId);

        return procedureExecutor.executeNamedProcedure("ClassicTrackerPipeUpdate", params);

    }

    public List<Object> executeGetJobPCOT(Integer runMode) {
        Map params = new HashMap(3);

        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetJobPCOT", params);

    }

    public List<Object> executeCreateManualActivityPipe(Integer varBidId, BigDecimal varQuantity, String varNotes, Integer varUserId) {
        Map params = new HashMap(6);

        params.put("varBidID", varBidId);
        params.put("varQuantity", varQuantity);
        params.put("varNotes", varNotes);
        params.put("varUserID", varUserId);

        return procedureExecutor.executeNamedProcedure("CreateManualActivityPipe", params);

    }

    public List<Object> executeGetCivilPCOT(Integer runMode) {
        Map params = new HashMap(3);

        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetCivilPCOT", params);

    }

    public List<Object> executeGetPipeStats(String groupedBy, Integer runMode) {
        Map params = new HashMap(4);

        params.put("GroupedBy", groupedBy);
        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetPipeStats", params);

    }

    public List<Object> executeGetCivilStats(String groupedBy, Integer runMode) {
        Map params = new HashMap(4);

        params.put("GroupedBy", groupedBy);
        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetCivilStats", params);

    }

    public List<Object> executeCreateManualActivityCivil(Integer varBidId, Integer varQuantity, BigDecimal varPercentCompleted, String varNotes, Integer varUserId) {
        Map params = new HashMap(7);

        params.put("varBidID", varBidId);
        params.put("varQuantity", varQuantity);
        params.put("varPercentCompleted", varPercentCompleted);
        params.put("varNotes", varNotes);
        params.put("varUserId", varUserId);

        return procedureExecutor.executeNamedProcedure("CreateManualActivityCivil", params);

    }

    public List<Object> executeGetSteelStats(String groupedBy, Integer runMode) {
        Map params = new HashMap(4);

        params.put("GroupedBy", groupedBy);
        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetSteelStats", params);

    }

    public List<Object> executeClassicTrackerCivilUpdate(Integer runMode, Integer updateBidId) {
        Map params = new HashMap(4);

        params.put("RunMode", runMode);
        params.put("UpdateBidID", updateBidId);

        return procedureExecutor.executeNamedProcedure("ClassicTrackerCivilUpdate", params);

    }

    public List<Object> executeCreateLooseHoursActivitiesSteel(Integer submissionId, Integer userId, String testPackage) {
        Map params = new HashMap(5);

        params.put("SubmissionId", submissionId);
        params.put("UserId", userId);
        params.put("TestPackage", testPackage);

        return procedureExecutor.executeNamedProcedure("CreateLooseHoursActivitiesSteel", params);

    }

    public List<Object> executeCreateLooseHoursActivitiesCivil(Integer submissionId, Integer userId, String testPackage) {
        Map params = new HashMap(5);

        params.put("SubmissionId", submissionId);
        params.put("UserId", userId);
        params.put("TestPackage", testPackage);

        return procedureExecutor.executeNamedProcedure("CreateLooseHoursActivitiesCivil", params);

    }

    public List<Object> executeCreateLooseHoursActivitiesPipe(Integer submissionId, Integer userId, String testPackage) {
        Map params = new HashMap(5);

        params.put("SubmissionId", submissionId);
        params.put("UserId", userId);
        params.put("TestPackage", testPackage);

        return procedureExecutor.executeNamedProcedure("CreateLooseHoursActivitiesPipe", params);

    }

    public List<Object> executeClassicTrackerSteelUpdate(Integer runMode, Integer updateBidId) {
        Map params = new HashMap(4);

        params.put("RunMode", runMode);
        params.put("UpdateBidID", updateBidId);

        return procedureExecutor.executeNamedProcedure("ClassicTrackerSteelUpdate", params);

    }

}


