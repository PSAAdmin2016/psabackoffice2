/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
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
public class Job1111ProcedureExecutorServiceImpl implements Job1111ProcedureExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Job1111ProcedureExecutorServiceImpl.class);

    @Autowired
    @Qualifier("Job1111WMProcedureExecutor")
    private WMProcedureExecutor procedureExecutor;

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetEquipEarnedHoursResponse executeGetEquipEarnedHours(String groupedBy, String crewId, String crewRev, String foremanId, String superintendentId, String projectManagerId, String constructionManagerId, String siteManagerId, String areaManagerId, Date inputDate, Integer runMode) {
        Map params = new HashMap(13);

        params.put("GroupedBy", groupedBy);
        params.put("CrewID", crewId);
        params.put("CrewRev", crewRev);
        params.put("ForemanID", foremanId);
        params.put("SuperintendentID", superintendentId);
        params.put("ProjectManagerID", projectManagerId);
        params.put("ConstructionManagerID", constructionManagerId);
        params.put("SiteManagerID", siteManagerId);
        params.put("AreaManagerID", areaManagerId);
        params.put("InputDate", inputDate);
        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetEquipEarnedHours", params, GetEquipEarnedHoursResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetSteelPcotResponse executeGetSteelPCOT(Integer runMode) {
        Map params = new HashMap(3);

        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetSteelPCOT", params, GetSteelPcotResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public ClassicTrackerEquipUpdateResponse executeClassicTrackerEquipUpdate(Integer runMode, Integer updateBidId) {
        Map params = new HashMap(4);

        params.put("RunMode", runMode);
        params.put("UpdateBidID", updateBidId);

        return procedureExecutor.executeNamedProcedure("ClassicTrackerEquipUpdate", params, ClassicTrackerEquipUpdateResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public CreateManualActivitySteelResponse executeCreateManualActivitySteel(CreateManualActivitySteelRequest createManualActivitySteelRequest) {
        Map params = new HashMap(8);

        params.put("varBidID", createManualActivitySteelRequest.getVarBidId());
        params.put("varActivityType", createManualActivitySteelRequest.getVarActivityType());
        params.put("varQuantity", createManualActivitySteelRequest.getVarQuantity());
        params.put("varPercentCompleted", createManualActivitySteelRequest.getVarPercentCompleted());
        params.put("varNotes", createManualActivitySteelRequest.getVarNotes());
        params.put("varUserID", createManualActivitySteelRequest.getVarUserId());

        return procedureExecutor.executeNamedProcedure("CreateManualActivitySteel", params, CreateManualActivitySteelResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public LockSsactivityResponse executeLockSSActivity(Integer runMode, Integer userId, Integer activityId) {
        Map params = new HashMap(5);

        params.put("RunMode", runMode);
        params.put("UserID", userId);
        params.put("ActivityID", activityId);

        return procedureExecutor.executeNamedProcedure("LockSSActivity", params, LockSsactivityResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetCivilEarnedHoursResponse executeGetCivilEarnedHours(String groupedBy, String crewId, String crewRev, String foremanId, String superintendentId, String projectManagerId, String constructionManagerId, String siteManagerId, String areaManagerId, Date inputDate, Integer runMode) {
        Map params = new HashMap(13);

        params.put("GroupedBy", groupedBy);
        params.put("CrewID", crewId);
        params.put("CrewRev", crewRev);
        params.put("ForemanID", foremanId);
        params.put("SuperintendentID", superintendentId);
        params.put("ProjectManagerID", projectManagerId);
        params.put("ConstructionManagerID", constructionManagerId);
        params.put("SiteManagerID", siteManagerId);
        params.put("AreaManagerID", areaManagerId);
        params.put("InputDate", inputDate);
        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetCivilEarnedHours", params, GetCivilEarnedHoursResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetPipePcotResponse executeGetPipePCOT(Integer runMode) {
        Map params = new HashMap(3);

        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetPipePCOT", params, GetPipePcotResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public ClassicTrackerPipeUpdateResponse executeClassicTrackerPipeUpdate(Integer runMode, Integer updateBidId) {
        Map params = new HashMap(4);

        params.put("RunMode", runMode);
        params.put("UpdateBidID", updateBidId);

        return procedureExecutor.executeNamedProcedure("ClassicTrackerPipeUpdate", params, ClassicTrackerPipeUpdateResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetJobPcotResponse executeGetJobPCOT(Integer runMode) {
        Map params = new HashMap(3);

        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetJobPCOT", params, GetJobPcotResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public CreateManualActivityPipeResponse executeCreateManualActivityPipe(CreateManualActivityPipeRequest createManualActivityPipeRequest) {
        Map params = new HashMap(6);

        params.put("varBidID", createManualActivityPipeRequest.getVarBidId());
        params.put("varQuantity", createManualActivityPipeRequest.getVarQuantity());
        params.put("varNotes", createManualActivityPipeRequest.getVarNotes());
        params.put("varUserID", createManualActivityPipeRequest.getVarUserId());

        return procedureExecutor.executeNamedProcedure("CreateManualActivityPipe", params, CreateManualActivityPipeResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetSteelEarnedHoursResponse executeGetSteelEarnedHours(String groupedBy, String crewId, String crewRev, String foremanId, String superintendentId, String projectManagerId, String constructionManagerId, String siteManagerId, String areaManagerId, Date inputDate, Integer runMode) {
        Map params = new HashMap(13);

        params.put("GroupedBy", groupedBy);
        params.put("CrewID", crewId);
        params.put("CrewRev", crewRev);
        params.put("ForemanID", foremanId);
        params.put("SuperintendentID", superintendentId);
        params.put("ProjectManagerID", projectManagerId);
        params.put("ConstructionManagerID", constructionManagerId);
        params.put("SiteManagerID", siteManagerId);
        params.put("AreaManagerID", areaManagerId);
        params.put("InputDate", inputDate);
        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetSteelEarnedHours", params, GetSteelEarnedHoursResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetCivilPcotResponse executeGetCivilPCOT(Integer runMode) {
        Map params = new HashMap(3);

        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetCivilPCOT", params, GetCivilPcotResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetEquipPcotResponse executeGetEquipPCOT(Integer runMode) {
        Map params = new HashMap(3);

        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetEquipPCOT", params, GetEquipPcotResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetPipeStatsResponse executeGetPipeStats(String groupedBy, Integer runMode) {
        Map params = new HashMap(4);

        params.put("GroupedBy", groupedBy);
        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetPipeStats", params, GetPipeStatsResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetCivilStatsResponse executeGetCivilStats(String groupedBy, Integer runMode) {
        Map params = new HashMap(4);

        params.put("GroupedBy", groupedBy);
        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetCivilStats", params, GetCivilStatsResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetPipeEarnedHoursResponse executeGetPipeEarnedHours(String groupedBy, String crewId, String crewRev, String foremanId, String superintendentId, String projectManagerId, String constructionManagerId, String siteManagerId, String areaManagerId, Date inputDate, Integer runMode) {
        Map params = new HashMap(13);

        params.put("GroupedBy", groupedBy);
        params.put("CrewID", crewId);
        params.put("CrewRev", crewRev);
        params.put("ForemanID", foremanId);
        params.put("SuperintendentID", superintendentId);
        params.put("ProjectManagerID", projectManagerId);
        params.put("ConstructionManagerID", constructionManagerId);
        params.put("SiteManagerID", siteManagerId);
        params.put("AreaManagerID", areaManagerId);
        params.put("InputDate", inputDate);
        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetPipeEarnedHours", params, GetPipeEarnedHoursResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public CreateManualActivityCivilResponse executeCreateManualActivityCivil(CreateManualActivityCivilRequest createManualActivityCivilRequest) {
        Map params = new HashMap(7);

        params.put("varBidID", createManualActivityCivilRequest.getVarBidId());
        params.put("varQuantity", createManualActivityCivilRequest.getVarQuantity());
        params.put("varPercentCompleted", createManualActivityCivilRequest.getVarPercentCompleted());
        params.put("varNotes", createManualActivityCivilRequest.getVarNotes());
        params.put("varUserId", createManualActivityCivilRequest.getVarUserId());

        return procedureExecutor.executeNamedProcedure("CreateManualActivityCivil", params, CreateManualActivityCivilResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetEquipStatsResponse executeGetEquipStats(String groupedBy, Integer runMode) {
        Map params = new HashMap(4);

        params.put("GroupedBy", groupedBy);
        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetEquipStats", params, GetEquipStatsResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public CreateManualActivityEquipResponse executeCreateManualActivityEquip(CreateManualActivityEquipRequest createManualActivityEquipRequest) {
        Map params = new HashMap(7);

        params.put("varBidID", createManualActivityEquipRequest.getVarBidId());
        params.put("varQuantity", createManualActivityEquipRequest.getVarQuantity());
        params.put("varPercentCompleted", createManualActivityEquipRequest.getVarPercentCompleted());
        params.put("varNotes", createManualActivityEquipRequest.getVarNotes());
        params.put("varUserID", createManualActivityEquipRequest.getVarUserId());

        return procedureExecutor.executeNamedProcedure("CreateManualActivityEquip", params, CreateManualActivityEquipResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public GetSteelStatsResponse executeGetSteelStats(String groupedBy, Integer runMode) {
        Map params = new HashMap(4);

        params.put("GroupedBy", groupedBy);
        params.put("RunMode", runMode);

        return procedureExecutor.executeNamedProcedure("GetSteelStats", params, GetSteelStatsResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public ClassicTrackerCivilUpdateResponse executeClassicTrackerCivilUpdate(Integer runMode, Integer updateBidId) {
        Map params = new HashMap(4);

        params.put("RunMode", runMode);
        params.put("UpdateBidID", updateBidId);

        return procedureExecutor.executeNamedProcedure("ClassicTrackerCivilUpdate", params, ClassicTrackerCivilUpdateResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public CreateLooseHoursActivitiesSteelResponse executeCreateLooseHoursActivitiesSteel(CreateLooseHoursActivitiesSteelRequest createLooseHoursActivitiesSteelRequest) {
        Map params = new HashMap(5);

        params.put("SubmissionId", createLooseHoursActivitiesSteelRequest.getSubmissionId());
        params.put("UserId", createLooseHoursActivitiesSteelRequest.getUserId());
        params.put("TestPackage", createLooseHoursActivitiesSteelRequest.getTestPackage());

        return procedureExecutor.executeNamedProcedure("CreateLooseHoursActivitiesSteel", params, CreateLooseHoursActivitiesSteelResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public CreateLooseHoursActivitiesCivilResponse executeCreateLooseHoursActivitiesCivil(CreateLooseHoursActivitiesCivilRequest createLooseHoursActivitiesCivilRequest) {
        Map params = new HashMap(5);

        params.put("SubmissionId", createLooseHoursActivitiesCivilRequest.getSubmissionId());
        params.put("UserId", createLooseHoursActivitiesCivilRequest.getUserId());
        params.put("TestPackage", createLooseHoursActivitiesCivilRequest.getTestPackage());

        return procedureExecutor.executeNamedProcedure("CreateLooseHoursActivitiesCivil", params, CreateLooseHoursActivitiesCivilResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public CreateLooseHoursActivitiesPipeResponse executeCreateLooseHoursActivitiesPipe(CreateLooseHoursActivitiesPipeRequest createLooseHoursActivitiesPipeRequest) {
        Map params = new HashMap(5);

        params.put("SubmissionId", createLooseHoursActivitiesPipeRequest.getSubmissionId());
        params.put("UserId", createLooseHoursActivitiesPipeRequest.getUserId());
        params.put("TestPackage", createLooseHoursActivitiesPipeRequest.getTestPackage());

        return procedureExecutor.executeNamedProcedure("CreateLooseHoursActivitiesPipe", params, CreateLooseHoursActivitiesPipeResponse.class);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public ClassicTrackerSteelUpdateResponse executeClassicTrackerSteelUpdate(Integer runMode, Integer updateBidId) {
        Map params = new HashMap(4);

        params.put("RunMode", runMode);
        params.put("UpdateBidID", updateBidId);

        return procedureExecutor.executeNamedProcedure("ClassicTrackerSteelUpdate", params, ClassicTrackerSteelUpdateResponse.class);
    }

}


