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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.job1111.models.query.*;

@Service
public class Job1111QueryExecutorServiceImpl_V1 implements Job1111QueryExecutorService_V1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Job1111QueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("Job1111WMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidWorkHistorySteel(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetBidWorkHistorySteel", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantitiesTestPackageSteel(Pageable pageable, String testPackage) {
        Map params = new HashMap(1);

        params.put("TestPackage", testPackage);

        return queryExecutor.executeNamedQuery("GetQuantitiesTestPackageSteel", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingPipeHydroPercent(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingPipeHydroPercent", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetActivityHistoryPipeErection(Pageable pageable, Integer activityId) {
        Map params = new HashMap(1);

        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQuery("GetActivityHistoryPipeErection", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetActivityHistoryPipeWeld(Pageable pageable, Integer activityId) {
        Map params = new HashMap(1);

        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQuery("GetActivityHistoryPipeWeld", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSteelDemo(Integer bidId, BigDecimal percentcompleted, String notes, Integer activityId) {
        Map params = new HashMap(4);

        params.put("BidID", bidId);
        params.put("Percentcompleted", percentcompleted);
        params.put("Notes", notes);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSteelDemo", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantitiesTestPackageCivil(Pageable pageable, String testPackage) {
        Map params = new HashMap(1);

        params.put("TestPackage", testPackage);

        return queryExecutor.executeNamedQuery("GetQuantitiesTestPackageCivil", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingSteelImpPercent(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingSteelImpPercent", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSteelMisc(Integer bidId, BigDecimal percentCompleted, Byte rework, String notes, Integer activityId) {
        Map params = new HashMap(5);

        params.put("BidID", bidId);
        params.put("PercentCompleted", percentCompleted);
        params.put("Rework", rework);
        params.put("Notes", notes);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSteelMisc", params);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdatePipeMiscQuantity(BigDecimal quantity, Integer activityId) {
        Map params = new HashMap(2);

        params.put("Quantity", quantity);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdatePipeMiscQuantity", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidWorkHistoryCivil(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetBidWorkHistoryCivil", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetDrawingByTestPackageSteel(Pageable pageable, String testPackage) {
        Map params = new HashMap(1);

        params.put("TestPackage", testPackage);

        return queryExecutor.executeNamedQuery("GetDrawingByTestPackageSteel", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantityBoltUpInstalled(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetQuantityBoltUpInstalled", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingSteelSellPercent(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingSteelSellPercent", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdatePipeMisc(String drawingNumber, String lineNumber, String sheetNumber, BigDecimal quantity, Integer rework, String notes, Integer activityId) {
        Map params = new HashMap(7);

        params.put("DrawingNumber", drawingNumber);
        params.put("LineNumber", lineNumber);
        params.put("SheetNumber", sheetNumber);
        params.put("Quantity", quantity);
        params.put("Rework", rework);
        params.put("Notes", notes);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdatePipeMisc", params);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeCreateSASNote(Integer activityId, Integer createdBy, String note) {
        Map params = new HashMap(3);

        params.put("ActivityID", activityId);
        params.put("CreatedBy", createdBy);
        params.put("Note", note);

        return queryExecutor.executeNamedQueryForUpdate("CreateSASNote", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetReportDPRSteelDetailed(Pageable pageable, String pm, String constM, String siteM, String areaM, String super_, String gf, String foreman, Date startDate, Date endDate) {
        Map params = new HashMap(9);

        params.put("PM", pm);
        params.put("ConstM", constM);
        params.put("SiteM", siteM);
        params.put("AreaM", areaM);
        params.put("Super", super_);
        params.put("GF", gf);
        params.put("Foreman", foreman);
        params.put("StartDate", startDate);
        params.put("EndDate", endDate);

        return queryExecutor.executeNamedQuery("GetReportDPRSteelDetailed", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidActivityQuantitiesSteel(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetBidActivityQuantitiesSteel", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingPipeTestingPercent(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingPipeTestingPercent", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetNotesByActivityID(Pageable pageable, List<Integer> activityId) {
        Map params = new HashMap(1);

        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQuery("GetNotesByActivityID", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdatePipeBoltupQuantity(Integer quantity, Integer activityId) {
        Map params = new HashMap(2);

        params.put("Quantity", quantity);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdatePipeBoltupQuantity", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetPSRecentActivities(Pageable pageable, Integer userId) {
        Map params = new HashMap(1);

        params.put("UserID", userId);

        return queryExecutor.executeNamedQuery("GetPSRecentActivities", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdatePipeErection(Integer bidId, String spool1, Integer spool1length, String spool2, Integer spool2length, String spool3, Integer spool3length, String spool4, Integer spool4length, String spool5, Integer spool5length, String spool6, Integer spool6length, Byte onCords, String drawingNumber, String lineNumber, String sheetNumber, BigDecimal size, Integer rework, String notes, Integer activityId) {
        Map params = new HashMap(21);

        params.put("BidID", bidId);
        params.put("Spool1", spool1);
        params.put("Spool1Length", spool1length);
        params.put("Spool2", spool2);
        params.put("Spool2Length", spool2length);
        params.put("Spool3", spool3);
        params.put("Spool3Length", spool3length);
        params.put("Spool4", spool4);
        params.put("Spool4Length", spool4length);
        params.put("Spool5", spool5);
        params.put("Spool5Length", spool5length);
        params.put("Spool6", spool6);
        params.put("Spool6Length", spool6length);
        params.put("OnCords", onCords);
        params.put("DrawingNumber", drawingNumber);
        params.put("LineNumber", lineNumber);
        params.put("SheetNumber", sheetNumber);
        params.put("Size", size);
        params.put("Rework", rework);
        params.put("Notes", notes);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdatePipeErection", params);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingPipeRFTPercent(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingPipeRFTPercent", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingCivilWork(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingCivilWork", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdatePipeErectionQuantity(Integer spool1length, Integer activityId) {
        Map params = new HashMap(2);

        params.put("Spool1Length", spool1length);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdatePipeErectionQuantity", params);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdatePipeWeldQuantity(BigDecimal percentCompleted, Integer activityId) {
        Map params = new HashMap(2);

        params.put("PercentCompleted", percentCompleted);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdatePipeWeldQuantity", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetActivityHistorySteelMisc(Pageable pageable, Integer activityId) {
        Map params = new HashMap(1);

        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQuery("GetActivityHistorySteelMisc", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingPipeRFTPercent(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingPipeRFTPercent", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidActivityMatchesByTestPackageCivil(Pageable pageable, String testPackage) {
        Map params = new HashMap(1);

        params.put("TestPackage", testPackage);

        return queryExecutor.executeNamedQuery("GetBidActivityMatchesByTestPackageCivil", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidActivityQuantitiesPipe(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetBidActivityQuantitiesPipe", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantityMiscInstalled(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetQuantityMiscInstalled", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingSteelErectPercent(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingSteelErectPercent", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSteelMiscQuantity(BigDecimal percentCompleted, Integer activityId) {
        Map params = new HashMap(2);

        params.put("PercentCompleted", percentCompleted);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSteelMiscQuantity", params);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingCivilPunch(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingCivilPunch", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantityLFInstalledByActivityID(Pageable pageable, Integer activityId) {
        Map params = new HashMap(1);

        params.put("ActivityId", activityId);

        return queryExecutor.executeNamedQuery("GetQuantityLFInstalledByActivityID", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetActivityHistoryStatus(Pageable pageable, Integer activityId) {
        Map params = new HashMap(1);

        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQuery("GetActivityHistoryStatus", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetActivityHistoryPipeMisc(Pageable pageable, Integer activityId) {
        Map params = new HashMap(1);

        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQuery("GetActivityHistoryPipeMisc", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetActivityHistorySteelDemo(Pageable pageable, Integer activityId) {
        Map params = new HashMap(1);

        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQuery("GetActivityHistorySteelDemo", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingPipeCTOPercent(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingPipeCTOPercent", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidActivityMatchesPipe(Pageable pageable, Integer bidId, String lineNumber, String drawingNumber, String sheetNumber, String activityType, String activitySubType) {
        Map params = new HashMap(6);

        params.put("BidID", bidId);
        params.put("LineNumber", lineNumber);
        params.put("DrawingNumber", drawingNumber);
        params.put("SheetNumber", sheetNumber);
        params.put("ActivityType", activityType);
        params.put("ActivitySubType", activitySubType);

        return queryExecutor.executeNamedQuery("GetBidActivityMatchesPipe", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdatePipeWeld(String spool1, String spool2, String drawingNumber, String lineNumber, String sheetNumber, String lineSpec, String weldNumber, String stencil, BigDecimal size, String thickness, String weldType, String weldPosition, String material, String procedure, Byte complete, Byte shared, BigDecimal percentCompleted, Byte rework, String notes, Integer fieldActivityId) {
        Map params = new HashMap(20);

        params.put("Spool1", spool1);
        params.put("Spool2", spool2);
        params.put("DrawingNumber", drawingNumber);
        params.put("LineNumber", lineNumber);
        params.put("SheetNumber", sheetNumber);
        params.put("LineSpec", lineSpec);
        params.put("WeldNumber", weldNumber);
        params.put("Stencil", stencil);
        params.put("Size", size);
        params.put("Thickness", thickness);
        params.put("WeldType", weldType);
        params.put("WeldPosition", weldPosition);
        params.put("Material", material);
        params.put("Procedure", procedure);
        params.put("Complete", complete);
        params.put("Shared", shared);
        params.put("PercentCompleted", percentCompleted);
        params.put("Rework", rework);
        params.put("Notes", notes);
        params.put("FieldActivityID", fieldActivityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdatePipeWeld", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidActivityMatchesSteel(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetBidActivityMatchesSteel", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantityLFInstalledByBidID(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetQuantityLFInstalledByBidID", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingCivilWork(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingCivilWork", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetReportDWRByDate(Pageable pageable, Date beginDate, Date endDate) {
        Map params = new HashMap(2);

        params.put("BeginDate", beginDate);
        params.put("EndDate", endDate);

        return queryExecutor.executeNamedQuery("GetReportDWRByDate", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingProductivityIntervals(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingProductivityIntervals", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingSteelSell(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingSteelSell", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantitySupportsInstalled(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetQuantitySupportsInstalled", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingSteelShake(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingSteelShake", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantityCutPrepInstalled(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetQuantityCutPrepInstalled", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingSteelErect(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingSteelErect", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantitiesTestPackagePipe(Pageable pageable, String testPackage) {
        Map params = new HashMap(1);

        params.put("TestPackage", testPackage);

        return queryExecutor.executeNamedQuery("GetQuantitiesTestPackagePipe", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingPipeHydroPercent(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingPipeHydroPercent", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetReportDPRSteelCondensed(Pageable pageable, String pm, String constM, String siteM, String areaM, String super_, String gf, String foreman, Date startDate, Date endDate) {
        Map params = new HashMap(9);

        params.put("PM", pm);
        params.put("ConstM", constM);
        params.put("SiteM", siteM);
        params.put("AreaM", areaM);
        params.put("Super", super_);
        params.put("GF", gf);
        params.put("Foreman", foreman);
        params.put("StartDate", startDate);
        params.put("EndDate", endDate);

        return queryExecutor.executeNamedQuery("GetReportDPRSteelCondensed", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetActivitiesPendingApproval(Pageable pageable, Integer userId, String craft, String foremanName) {
        Map params = new HashMap(3);

        params.put("UserID", userId);
        params.put("Craft", craft);
        params.put("ForemanName", foremanName);

        return queryExecutor.executeNamedQuery("GetActivitiesPendingApproval", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingPipeCTOPercent(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingPipeCTOPercent", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantityTrimInstalled(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetQuantityTrimInstalled", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetActivityHistoryCivilFA(Pageable pageable, Integer activityId) {
        Map params = new HashMap(1);

        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQuery("GetActivityHistoryCivilFA", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingSteelImp(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingSteelImp", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingCivilPunch(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingCivilPunch", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetReportDPRPipe(Pageable pageable, String foremanId, String superId, String managerId, Date startDate, Date endDate) {
        Map params = new HashMap(5);

        params.put("ForemanID", foremanId);
        params.put("SuperID", superId);
        params.put("ManagerID", managerId);
        params.put("StartDate", startDate);
        params.put("EndDate", endDate);

        return queryExecutor.executeNamedQuery("GetReportDPRPipe", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdatePipeBoltUp(Integer bidId, String spool1, String spool2, String drawingNumber, String lineNumber, String sheetNumber, BigDecimal size, Integer quantity, Integer rework, String notes, Integer activityId) {
        Map params = new HashMap(11);

        params.put("BidID", bidId);
        params.put("Spool1", spool1);
        params.put("Spool2", spool2);
        params.put("DrawingNumber", drawingNumber);
        params.put("LineNumber", lineNumber);
        params.put("SheetNumber", sheetNumber);
        params.put("Size", size);
        params.put("Quantity", quantity);
        params.put("Rework", rework);
        params.put("Notes", notes);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdatePipeBoltUp", params);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateCivilFA(Integer bidId, Integer quantity, BigDecimal percent, Integer rework, String notes, Integer activityId) {
        Map params = new HashMap(6);

        params.put("BidID", bidId);
        params.put("Quantity", quantity);
        params.put("Percent", percent);
        params.put("Rework", rework);
        params.put("Notes", notes);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdateCivilFA", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidWorkHistorySteelExpanded(Pageable pageable, Integer bidId, Integer submissionId) {
        Map params = new HashMap(2);

        params.put("BidID", bidId);
        params.put("SubmissionID", submissionId);

        return queryExecutor.executeNamedQuery("GetBidWorkHistorySteelExpanded", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSuperRecentActivites(Pageable pageable, Integer userId, Integer selectedSuper) {
        Map params = new HashMap(2);

        params.put("UserID", userId);
        params.put("SelectedSuper", selectedSuper);

        return queryExecutor.executeNamedQuery("GetSuperRecentActivites", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingPipeMechPercent(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingPipeMechPercent", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidActivityMatchesCivil(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetBidActivityMatchesCivil", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantityDemoRemoved(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetQuantityDemoRemoved", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateCivilFAQuantity(Integer quantity, BigDecimal percent, Integer activityId) {
        Map params = new HashMap(3);

        params.put("Quantity", quantity);
        params.put("Percent", percent);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdateCivilFAQuantity", params);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingPipeTestingPercent(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingPipeTestingPercent", params);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateCivilSellPackage(String testPackageNumber, String notes, Integer activityId) {
        Map params = new HashMap(3);

        params.put("TestPackageNumber", testPackageNumber);
        params.put("Notes", notes);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdateCivilSellPackage", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingPipeMechPercent(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingPipeMechPercent", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetQuantityWeldInstalled(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetQuantityWeldInstalled", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingSteelBoltoutPercent(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingSteelBoltoutPercent", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetDrawingsByTestPackagePipe(Pageable pageable, String testPackage) {
        Map params = new HashMap(1);

        params.put("TestPackage", testPackage);

        return queryExecutor.executeNamedQuery("GetDrawingsByTestPackagePipe", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetSettingSteelShakePercent(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingSteelShakePercent", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidActivityMatchesByTestPackageSteel(Pageable pageable, String testPackage) {
        Map params = new HashMap(1);

        params.put("TestPackage", testPackage);

        return queryExecutor.executeNamedQuery("GetBidActivityMatchesByTestPackageSteel", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidActivityMatchesByTestPackagePipe(Pageable pageable, String testPackage) {
        Map params = new HashMap(1);

        params.put("TestPackage", testPackage);

        return queryExecutor.executeNamedQuery("GetBidActivityMatchesByTestPackagePipe", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidWorkHistoryPipe(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetBidWorkHistoryPipe", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSteelDemoQuantity(BigDecimal percentCompleted, Integer activityId) {
        Map params = new HashMap(2);

        params.put("PercentCompleted", percentCompleted);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSteelDemoQuantity", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetActivityHistoryPipeTesting(Pageable pageable, Integer activityId) {
        Map params = new HashMap(1);

        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQuery("GetActivityHistoryPipeTesting", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdatePipeTesting(String testPackageNumber, Integer rework, String notes, Integer activityId) {
        Map params = new HashMap(4);

        params.put("TestPackageNumber", testPackageNumber);
        params.put("Rework", rework);
        params.put("Notes", notes);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdatePipeTesting", params);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetDrawingByTestPackageCivil(Pageable pageable, String testPackage) {
        Map params = new HashMap(1);

        params.put("TestPackage", testPackage);

        return queryExecutor.executeNamedQuery("GetDrawingByTestPackageCivil", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Object> executeGetBidActivityQuantitiesCivil(Pageable pageable, Integer bidId) {
        Map params = new HashMap(1);

        params.put("BidID", bidId);

        return queryExecutor.executeNamedQuery("GetBidActivityQuantitiesCivil", params, Object.class, pageable);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSteelSellPackage(String testPackage, String notes, Integer activityId) {
        Map params = new HashMap(3);

        params.put("TestPackage", testPackage);
        params.put("Notes", notes);
        params.put("ActivityID", activityId);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSteelSellPackage", params);
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
    public int executeUpdateSettingSteelBoltout(BigDecimal value1) {
        Map params = new HashMap(1);

        params.put("Value1", value1);

        return queryExecutor.executeNamedQueryForUpdate("UpdateSettingSteelBoltout", params);
    }

}


