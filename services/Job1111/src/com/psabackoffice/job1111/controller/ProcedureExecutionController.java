/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.psabackoffice.job1111.service.Job1111ProcedureExecutorService;
import com.psabackoffice.job1111.models.procedure.*;

@RestController(value = "Job1111.ProcedureExecutionController")
@RequestMapping("/Job1111/procedureExecutor")
@Api(value = "ProcedureExecutionController", description = "controller class for procedure execution")
public class ProcedureExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureExecutionController.class);

    @Autowired
    private Job1111ProcedureExecutorService procedureService;

    @RequestMapping(value = "/procedure/execute/CreateManualActivityCivil", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "name")
    public List<CreateManualActivityCivilResponse> executeCreateManualActivityCivil(@Valid @RequestBody CreateManualActivityCivilRequest createManualActivityCivilRequest) {
        LOGGER.debug("Executing named procedure: CreateManualActivityCivil");
        CreateManualActivityCivilResponse _result = procedureService.executeCreateManualActivityCivil(createManualActivityCivilRequest);
        LOGGER.debug("got the result for v1 named procedure: CreateManualActivityCivil, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/CreateManualActivityPipe", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Create Miscs manual activities.")
    public List<CreateManualActivityPipeResponse> executeCreateManualActivityPipe(@Valid @RequestBody CreateManualActivityPipeRequest createManualActivityPipeRequest) {
        LOGGER.debug("Executing named procedure: CreateManualActivityPipe");
        CreateManualActivityPipeResponse _result = procedureService.executeCreateManualActivityPipe(createManualActivityPipeRequest);
        LOGGER.debug("got the result for v1 named procedure: CreateManualActivityPipe, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/GetEquipPCOT", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Get Equipment Percent complete over time. RunMode null,0,1 Select from Cache. RunMode 2 Update Cache then select. RunMode 3 Update Cache NO Select")
    public GetEquipPcotResponse executeGetEquipPCOT(@RequestParam(value = "RunMode", required = false) Integer runMode) {
        LOGGER.debug("Executing named procedure: GetEquipPCOT");
        GetEquipPcotResponse _result = procedureService.executeGetEquipPCOT(runMode);
        LOGGER.debug("got the result for named procedure: GetEquipPCOT, result:{}", _result);
        return _result;
    }

    @RequestMapping(value = "/procedure/execute/GetPipeEarnedHours", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Valid GroupedBy are:   CrewID,  ForemanID,  SuperintendentID,  ProjectManagerID,  ConstructionManagerID,  SiteManagerID,  AreaManagerID")
    public GetPipeEarnedHoursResponse executeGetPipeEarnedHours(@RequestParam(value = "GroupedBy") String groupedBy, @RequestParam(value = "CrewID") String crewId, @RequestParam(value = "CrewRev") String crewRev, @RequestParam(value = "ForemanID") String foremanId, @RequestParam(value = "SuperintendentID") String superintendentId, @RequestParam(value = "ProjectManagerID") String projectManagerId, @RequestParam(value = "ConstructionManagerID") String constructionManagerId, @RequestParam(value = "SiteManagerID") String siteManagerId, @RequestParam(value = "AreaManagerID") String areaManagerId, @RequestParam(value = "InputDate") Date inputDate, @RequestParam(value = "RunMode") Integer runMode) {
        LOGGER.debug("Executing named procedure: GetPipeEarnedHours");
        GetPipeEarnedHoursResponse _result = procedureService.executeGetPipeEarnedHours(groupedBy, crewId, crewRev, foremanId, superintendentId, projectManagerId, constructionManagerId, siteManagerId, areaManagerId, inputDate, runMode);
        LOGGER.debug("got the result for named procedure: GetPipeEarnedHours, result:{}", _result);
        return _result;
    }

    @RequestMapping(value = "/procedure/execute/CreateManualActivitySteel", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Name")
    public List<CreateManualActivitySteelResponse> executeCreateManualActivitySteel(@Valid @RequestBody CreateManualActivitySteelRequest createManualActivitySteelRequest) {
        LOGGER.debug("Executing named procedure: CreateManualActivitySteel");
        CreateManualActivitySteelResponse _result = procedureService.executeCreateManualActivitySteel(createManualActivitySteelRequest);
        LOGGER.debug("got the result for v1 named procedure: CreateManualActivitySteel, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/GetPipePCOT", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Gets Pipe Percent Complete Over Time table. RunMode null,0,1 Select from Cache. RunMode 2 Update Cache then select. RunMode 3 Update Cache NO Select")
    public List<GetPipePcotResponse> executeGetPipePCOT(@RequestParam(value = "RunMode", required = false) Integer runMode) {
        LOGGER.debug("Executing named procedure: GetPipePCOT");
        GetPipePcotResponse _result = procedureService.executeGetPipePCOT(runMode);
        LOGGER.debug("got the result for v1 named procedure: GetPipePCOT, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/GetCivilEarnedHours", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Valid GroupedBy are:   CrewID,  ForemanID,  SuperintendentID,  ProjectManagerID,  ConstructionManagerID,  SiteManagerID,  AreaManagerID")
    public GetCivilEarnedHoursResponse executeGetCivilEarnedHours(@RequestParam(value = "GroupedBy") String groupedBy, @RequestParam(value = "CrewID") String crewId, @RequestParam(value = "CrewRev") String crewRev, @RequestParam(value = "ForemanID") String foremanId, @RequestParam(value = "SuperintendentID") String superintendentId, @RequestParam(value = "ProjectManagerID") String projectManagerId, @RequestParam(value = "ConstructionManagerID") String constructionManagerId, @RequestParam(value = "SiteManagerID") String siteManagerId, @RequestParam(value = "AreaManagerID") String areaManagerId, @RequestParam(value = "InputDate") Date inputDate, @RequestParam(value = "RunMode") Integer runMode) {
        LOGGER.debug("Executing named procedure: GetCivilEarnedHours");
        GetCivilEarnedHoursResponse _result = procedureService.executeGetCivilEarnedHours(groupedBy, crewId, crewRev, foremanId, superintendentId, projectManagerId, constructionManagerId, siteManagerId, areaManagerId, inputDate, runMode);
        LOGGER.debug("got the result for named procedure: GetCivilEarnedHours, result:{}", _result);
        return _result;
    }

    @RequestMapping(value = "/procedure/execute/CreateManualActivityEquip", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "name")
    public CreateManualActivityEquipResponse executeCreateManualActivityEquip(@Valid @RequestBody CreateManualActivityEquipRequest createManualActivityEquipRequest) {
        LOGGER.debug("Executing named procedure: CreateManualActivityEquip");
        CreateManualActivityEquipResponse _result = procedureService.executeCreateManualActivityEquip(createManualActivityEquipRequest);
        LOGGER.debug("got the result for named procedure: CreateManualActivityEquip, result:{}", _result);
        return _result;
    }

    @RequestMapping(value = "/procedure/execute/ClassicTrackerPipeUpdate", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "updates and/or retrieves Classic Tracker Pipe. Valid RunModes: '', 0, 1 = Select Cache Table Only 2 = Full update Cache table Then Select 3 = Full update cache table only 4 = Update supplied BidID only")
    public List<ClassicTrackerPipeUpdateResponse> executeClassicTrackerPipeUpdate(@RequestParam(value = "RunMode") Integer runMode, @RequestParam(value = "UpdateBidID", required = false) Integer updateBidId) {
        LOGGER.debug("Executing named procedure: ClassicTrackerPipeUpdate");
        ClassicTrackerPipeUpdateResponse _result = procedureService.executeClassicTrackerPipeUpdate(runMode, updateBidId);
        LOGGER.debug("got the result for v1 named procedure: ClassicTrackerPipeUpdate, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/GetEquipStats", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Get Equipment stats grouped by the input RunMode null,0,1 Select from Cache. RunMode 2 Update Cache then select. RunMode 3 Update Cache NO Select")
    public GetEquipStatsResponse executeGetEquipStats(@RequestParam(value = "GroupedBy") String groupedBy, @RequestParam(value = "RunMode", required = false) Integer runMode) {
        LOGGER.debug("Executing named procedure: GetEquipStats");
        GetEquipStatsResponse _result = procedureService.executeGetEquipStats(groupedBy, runMode);
        LOGGER.debug("got the result for named procedure: GetEquipStats, result:{}", _result);
        return _result;
    }

    @RequestMapping(value = "/procedure/execute/GetPipeStats", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Get Pipe Stats Grouped by user input RunMode null,0,1 Select from Cache. RunMode 2 Update Cache then select. RunMode 3 Update Cache NO Select")
    public List<GetPipeStatsResponse> executeGetPipeStats(@RequestParam(value = "GroupedBy") String groupedBy, @RequestParam(value = "RunMode", required = false) Integer runMode) {
        LOGGER.debug("Executing named procedure: GetPipeStats");
        GetPipeStatsResponse _result = procedureService.executeGetPipeStats(groupedBy, runMode);
        LOGGER.debug("got the result for v1 named procedure: GetPipeStats, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/GetCivilPCOT", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Gets the Percent complete over time. RunMode null,0,1 Select from Cache. RunMode 2 Update Cache then select. RunMode 3 Update Cache NO Select")
    public List<GetCivilPcotResponse> executeGetCivilPCOT(@RequestParam(value = "RunMode", required = false) Integer runMode) {
        LOGGER.debug("Executing named procedure: GetCivilPCOT");
        GetCivilPcotResponse _result = procedureService.executeGetCivilPCOT(runMode);
        LOGGER.debug("got the result for v1 named procedure: GetCivilPCOT, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/GetJobPCOT", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Get PCOT for entire job, also split by crafts. RunMode null,0,1 Select from Cache.")
    public List<GetJobPcotResponse> executeGetJobPCOT(@RequestParam(value = "RunMode", required = false) Integer runMode) {
        LOGGER.debug("Executing named procedure: GetJobPCOT");
        GetJobPcotResponse _result = procedureService.executeGetJobPCOT(runMode);
        LOGGER.debug("got the result for v1 named procedure: GetJobPCOT, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/ClassicTrackerCivilUpdate", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Civil Classic Tracker '', 0, 1 = Select Cache Table Only 2 = Full update Cache table Then Select 3 = Full update cache table only 4 = Update supplied BidID only")
    public List<ClassicTrackerCivilUpdateResponse> executeClassicTrackerCivilUpdate(@RequestParam(value = "RunMode") Integer runMode, @RequestParam(value = "UpdateBidID", required = false) Integer updateBidId) {
        LOGGER.debug("Executing named procedure: ClassicTrackerCivilUpdate");
        ClassicTrackerCivilUpdateResponse _result = procedureService.executeClassicTrackerCivilUpdate(runMode, updateBidId);
        LOGGER.debug("got the result for v1 named procedure: ClassicTrackerCivilUpdate, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/GetSteelStats", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Get Steel Stats Grouped by input RunMode null,0,1 Select from Cache. RunMode 2 Update Cache then select. RunMode 3 Update Cache NO Select")
    public List<GetSteelStatsResponse> executeGetSteelStats(@RequestParam(value = "GroupedBy") String groupedBy, @RequestParam(value = "RunMode", required = false) Integer runMode) {
        LOGGER.debug("Executing named procedure: GetSteelStats");
        GetSteelStatsResponse _result = procedureService.executeGetSteelStats(groupedBy, runMode);
        LOGGER.debug("got the result for v1 named procedure: GetSteelStats, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/ClassicTrackerSteelUpdate", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Steel Classic Tracker '', 0, 1 = Select Cache Table Only 2 = Full update Cache table Then Select 3 = Full update cache table only 4 = Update supplied BidID only")
    public List<ClassicTrackerSteelUpdateResponse> executeClassicTrackerSteelUpdate(@RequestParam(value = "RunMode") Integer runMode, @RequestParam(value = "UpdateBidID", required = false) Integer updateBidId) {
        LOGGER.debug("Executing named procedure: ClassicTrackerSteelUpdate");
        ClassicTrackerSteelUpdateResponse _result = procedureService.executeClassicTrackerSteelUpdate(runMode, updateBidId);
        LOGGER.debug("got the result for v1 named procedure: ClassicTrackerSteelUpdate, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/LockSSActivity", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Locks a SS Activity for approval.  Returns True if lock achieved, False if not.")
    public List<LockSsactivityResponse> executeLockSSActivity(@RequestParam(value = "UserID") Integer userId, @RequestParam(value = "FieldActivityID") Integer fieldActivityId) {
        LOGGER.debug("Executing named procedure: LockSSActivity");
        LockSsactivityResponse _result = procedureService.executeLockSSActivity(userId, fieldActivityId);
        LOGGER.debug("got the result for v1 named procedure: LockSSActivity, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/GetCivilStats", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Get Steel Stats Grouped by input RunMode null,0,1 Select from Cache. RunMode 2 Update Cache then select. RunMode 3 Update Cache NO Select")
    public List<GetCivilStatsResponse> executeGetCivilStats(@RequestParam(value = "GroupedBy") String groupedBy, @RequestParam(value = "RunMode", required = false) Integer runMode) {
        LOGGER.debug("Executing named procedure: GetCivilStats");
        GetCivilStatsResponse _result = procedureService.executeGetCivilStats(groupedBy, runMode);
        LOGGER.debug("got the result for v1 named procedure: GetCivilStats, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/CreateLooseHoursActivitySteel", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "name")
    public List<Void> executeCreateLooseHoursActivitySteel(@Valid @RequestBody CreateLooseHoursActivitySteelRequest createLooseHoursActivitySteelRequest) {
        LOGGER.debug("Executing named procedure: CreateLooseHoursActivitySteel");
        Void _result = procedureService.executeCreateLooseHoursActivitySteel(createLooseHoursActivitySteelRequest);
        LOGGER.debug("got the result for v1 named procedure: CreateLooseHoursActivitySteel, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/GetEquipEarnedHours", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Valid GroupedBy are:   CrewID,  ForemanID,  SuperintendentID,  ProjectManagerID,  ConstructionManagerID,  SiteManagerID,  AreaManagerID")
    public GetEquipEarnedHoursResponse executeGetEquipEarnedHours(@RequestParam(value = "GroupedBy") String groupedBy, @RequestParam(value = "CrewID") String crewId, @RequestParam(value = "CrewRev") String crewRev, @RequestParam(value = "ForemanID") String foremanId, @RequestParam(value = "SuperintendentID") String superintendentId, @RequestParam(value = "ProjectManagerID") String projectManagerId, @RequestParam(value = "ConstructionManagerID") String constructionManagerId, @RequestParam(value = "SiteManagerID") String siteManagerId, @RequestParam(value = "AreaManagerID") String areaManagerId, @RequestParam(value = "InputDate") Date inputDate, @RequestParam(value = "RunMode") Integer runMode) {
        LOGGER.debug("Executing named procedure: GetEquipEarnedHours");
        GetEquipEarnedHoursResponse _result = procedureService.executeGetEquipEarnedHours(groupedBy, crewId, crewRev, foremanId, superintendentId, projectManagerId, constructionManagerId, siteManagerId, areaManagerId, inputDate, runMode);
        LOGGER.debug("got the result for named procedure: GetEquipEarnedHours, result:{}", _result);
        return _result;
    }

    @RequestMapping(value = "/procedure/execute/GetSteelEarnedHours", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Valid GroupedBy are:   CrewID,  ForemanID,  SuperintendentID,  ProjectManagerID,  ConstructionManagerID,  SiteManagerID,  AreaManagerID")
    public GetSteelEarnedHoursResponse executeGetSteelEarnedHours(@RequestParam(value = "GroupedBy") String groupedBy, @RequestParam(value = "CrewID") String crewId, @RequestParam(value = "CrewRev") String crewRev, @RequestParam(value = "ForemanID") String foremanId, @RequestParam(value = "SuperintendentID") String superintendentId, @RequestParam(value = "ProjectManagerID") String projectManagerId, @RequestParam(value = "ConstructionManagerID") String constructionManagerId, @RequestParam(value = "SiteManagerID") String siteManagerId, @RequestParam(value = "AreaManagerID") String areaManagerId, @RequestParam(value = "InputDate") Date inputDate, @RequestParam(value = "RunMode") Integer runMode) {
        LOGGER.debug("Executing named procedure: GetSteelEarnedHours");
        GetSteelEarnedHoursResponse _result = procedureService.executeGetSteelEarnedHours(groupedBy, crewId, crewRev, foremanId, superintendentId, projectManagerId, constructionManagerId, siteManagerId, areaManagerId, inputDate, runMode);
        LOGGER.debug("got the result for named procedure: GetSteelEarnedHours, result:{}", _result);
        return _result;
    }

    @RequestMapping(value = "/procedure/execute/ClassicTrackerEquipUpdate", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the EquipTrackerClassic table '', 0, 1 = Select Cache Table Only 2 = Full update Cache table Then Select 3 = Full update cache table only 4 = Update supplied BidID only")
    public ClassicTrackerEquipUpdateResponse executeClassicTrackerEquipUpdate(@RequestParam(value = "RunMode") Integer runMode, @RequestParam(value = "UpdateBidID", required = false) Integer updateBidId) {
        LOGGER.debug("Executing named procedure: ClassicTrackerEquipUpdate");
        ClassicTrackerEquipUpdateResponse _result = procedureService.executeClassicTrackerEquipUpdate(runMode, updateBidId);
        LOGGER.debug("got the result for named procedure: ClassicTrackerEquipUpdate, result:{}", _result);
        return _result;
    }

    @RequestMapping(value = "/procedure/execute/CreateLooseHoursActivitiesPipe", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "name")
    public List<CreateLooseHoursActivitiesPipeResponse> executeCreateLooseHoursActivitiesPipe(@Valid @RequestBody CreateLooseHoursActivitiesPipeRequest createLooseHoursActivitiesPipeRequest) {
        LOGGER.debug("Executing named procedure: CreateLooseHoursActivitiesPipe");
        CreateLooseHoursActivitiesPipeResponse _result = procedureService.executeCreateLooseHoursActivitiesPipe(createLooseHoursActivitiesPipeRequest);
        LOGGER.debug("got the result for v1 named procedure: CreateLooseHoursActivitiesPipe, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/CreateLooseHoursActivityCivil", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Name")
    public List<CreateLooseHoursActivityCivilResponse> executeCreateLooseHoursActivityCivil(@Valid @RequestBody CreateLooseHoursActivityCivilRequest createLooseHoursActivityCivilRequest) {
        LOGGER.debug("Executing named procedure: CreateLooseHoursActivityCivil");
        CreateLooseHoursActivityCivilResponse _result = procedureService.executeCreateLooseHoursActivityCivil(createLooseHoursActivityCivilRequest);
        LOGGER.debug("got the result for v1 named procedure: CreateLooseHoursActivityCivil, result:{}", _result);
        return Collections.singletonList(_result);
    }

    @RequestMapping(value = "/procedure/execute/GetSteelPCOT", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Get Steel Percent Complete Over Time Table. RunMode null,0,1 Select from Cache. RunMode 2 Update Cache then select. RunMode 3 Update Cache NO Select")
    public List<GetSteelPcotResponse> executeGetSteelPCOT(@RequestParam(value = "RunMode", required = false) Integer runMode) {
        LOGGER.debug("Executing named procedure: GetSteelPCOT");
        GetSteelPcotResponse _result = procedureService.executeGetSteelPCOT(runMode);
        LOGGER.debug("got the result for v1 named procedure: GetSteelPCOT, result:{}", _result);
        return Collections.singletonList(_result);
    }

}


