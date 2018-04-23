/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.job1111.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.job1111.models.query.*;

@Deprecated
public interface Job1111QueryExecutorService_V1 {

    @Deprecated
    public Page<Object> executeGetBidWorkHistorySteel(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetQuantitiesTestPackageSteel(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetSettingPipeHydroPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeErection(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeWeld(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdateSteelDemo(Integer bidId, BigDecimal percentcompleted, String notes, Integer activityId);

    @Deprecated
    public Page<Object> executeGetQuantitiesTestPackageCivil(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetSettingSteelImpPercent(Pageable pageable);

    @Deprecated
    public int executeUpdateSteelMisc(Integer bidId, BigDecimal percentCompleted, Byte rework, String notes, Integer activityId);

    @Deprecated
    public int executeUpdatePipeMiscQuantity(BigDecimal quantity, Integer activityId);

    @Deprecated
    public Page<Object> executeGetBidWorkHistoryCivil(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetDrawingByTestPackageSteel(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetQuantityBoltUpInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetSettingSteelSellPercent(Pageable pageable);

    @Deprecated
    public int executeUpdatePipeMisc(String drawingNumber, String lineNumber, String sheetNumber, BigDecimal quantity, Integer rework, String notes, Integer activityId);

    @Deprecated
    public int executeCreateSASNote(Integer activityId, Integer createdBy, String note);

    @Deprecated
    public Page<Object> executeGetReportDPRSteelDetailed(Pageable pageable, String pm, String constM, String siteM, String areaM, String super_, String gf, String foreman, Date startDate, Date endDate);

    @Deprecated
    public Page<Object> executeGetBidActivityQuantitiesSteel(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetSettingPipeTestingPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetNotesByActivityID(Pageable pageable, List<Integer> activityId);

    @Deprecated
    public int executeUpdatePipeBoltupQuantity(Integer quantity, Integer activityId);

    @Deprecated
    public Page<Object> executeGetPSRecentActivities(Pageable pageable, Integer userId);

    @Deprecated
    public int executeUpdatePipeErection(Integer bidId, String spool1, Integer spool1length, String spool2, Integer spool2length, String spool3, Integer spool3length, String spool4, Integer spool4length, String spool5, Integer spool5length, String spool6, Integer spool6length, Byte onCords, String drawingNumber, String lineNumber, String sheetNumber, BigDecimal size, Integer rework, String notes, Integer activityId);

    @Deprecated
    public int executeUpdateSettingPipeRFTPercent(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetSettingCivilWork(Pageable pageable);

    @Deprecated
    public int executeUpdatePipeErectionQuantity(Integer spool1length, Integer activityId);

    @Deprecated
    public int executeUpdatePipeWeldQuantity(BigDecimal percentCompleted, Integer activityId);

    @Deprecated
    public Page<Object> executeGetActivityHistorySteelMisc(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetSettingPipeRFTPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesByTestPackageCivil(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetBidActivityQuantitiesPipe(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetQuantityMiscInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetSettingSteelErectPercent(Pageable pageable);

    @Deprecated
    public int executeUpdateSteelMiscQuantity(BigDecimal percentCompleted, Integer activityId);

    @Deprecated
    public int executeUpdateSettingCivilPunch(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetQuantityLFInstalledByActivityID(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetActivityHistoryStatus(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeMisc(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetActivityHistorySteelDemo(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdateSettingPipeCTOPercent(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesPipe(Pageable pageable, Integer bidId, String lineNumber, String drawingNumber, String sheetNumber, String activityType, String activitySubType);

    @Deprecated
    public int executeUpdatePipeWeld(String spool1, String spool2, String drawingNumber, String lineNumber, String sheetNumber, String lineSpec, String weldNumber, String stencil, BigDecimal size, String thickness, String weldType, String weldPosition, String material, String procedure, Byte complete, Byte shared, BigDecimal percentCompleted, Byte rework, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesSteel(Pageable pageable, Integer bidId, String sortGroup1, String pieceMark);

    @Deprecated
    public Page<Object> executeGetQuantityLFInstalledByBidID(Pageable pageable, Integer bidId);

    @Deprecated
    public int executeUpdateSettingCivilWork(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetNoteCount(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetReportDWRByDate(Pageable pageable, Date beginDate, Date endDate);

    @Deprecated
    public Page<Object> executeGetSettingProductivityIntervals(Pageable pageable);

    @Deprecated
    public int executeUpdateSettingSteelSell(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetQuantitySupportsInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public int executeUpdateSettingSteelShake(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetQuantityCutPrepInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public int executeUpdateSettingSteelErect(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetQuantitiesTestPackagePipe(Pageable pageable, String testPackage);

    @Deprecated
    public int executeUpdateSettingPipeHydroPercent(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetReportDPRSteelCondensed(Pageable pageable, String pm, String constM, String siteM, String areaM, String super_, String gf, String foreman, Date startDate, Date endDate);

    @Deprecated
    public Page<Object> executeGetActivitiesPendingApproval(Pageable pageable, Integer userId, String craft, String foremanName);

    @Deprecated
    public Page<Object> executeGetSettingPipeCTOPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetQuantityTrimInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetActivityHistoryCivilFA(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdateSettingSteelImp(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetSettingCivilPunch(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetReportDPRPipe(Pageable pageable, String foremanId, String superId, String managerId, Date startDate, Date endDate);

    @Deprecated
    public int executeUpdatePipeBoltUp(Integer bidId, String spool1, String spool2, String drawingNumber, String lineNumber, String sheetNumber, BigDecimal size, Integer quantity, Integer rework, String notes, Integer activityId);

    @Deprecated
    public int executeUpdateCivilFA(Integer bidId, Integer quantity, BigDecimal percent, Integer rework, String notes, Integer activityId);

    @Deprecated
    public Page<Object> executeGetBidWorkHistorySteelExpanded(Pageable pageable, Integer bidId, Integer submissionId);

    @Deprecated
    public Page<Object> executeGetSuperRecentActivites(Pageable pageable, Integer userId, Integer selectedSuper);

    @Deprecated
    public int executeUpdateSettingPipeMechPercent(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesCivil(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetQuantityDemoRemoved(Pageable pageable, Integer bidId);

    @Deprecated
    public int executeUpdateCivilFAQuantity(Integer quantity, BigDecimal percent, Integer activityId);

    @Deprecated
    public int executeUpdateSettingPipeTestingPercent(BigDecimal value1);

    @Deprecated
    public int executeUpdateCivilSellPackage(String testPackageNumber, String notes, Integer activityId);

    @Deprecated
    public Page<Object> executeGetSettingPipeMechPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetQuantityWeldInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetSettingSteelBoltoutPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetDrawingsByTestPackagePipe(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetSettingSteelShakePercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesByTestPackageSteel(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesByTestPackagePipe(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetBidWorkHistoryPipe(Pageable pageable, Integer bidId);

    @Deprecated
    public int executeUpdateSteelDemoQuantity(BigDecimal percentCompleted, Integer activityId);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeTesting(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdatePipeTesting(String testPackageNumber, Integer rework, String notes, Integer activityId);

    @Deprecated
    public Page<Object> executeGetDrawingByTestPackageCivil(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetBidActivityQuantitiesCivil(Pageable pageable, Integer bidId);

    @Deprecated
    public int executeUpdateSteelSellPackage(String testPackage, String notes, Integer activityId);

    @Deprecated
    public int executeUpdateSettingSteelBoltout(BigDecimal value1);

}


