/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.job1111.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.job1111.models.query.*;

@Deprecated
public interface Job1111QueryExecutorService_V1 {

    @Deprecated
    public int executeUpdateCivilSellPackage(String testPackageNumber, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetSuperRecentActivites(Pageable pageable, Integer userId, Integer selectedSuper);

    @Deprecated
    public Page<Object> executeGetErectionTotal(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdateSettingSteelShake(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetActivityHistorySteelErect(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetQuantityWeldInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetBidWorkHistorySteelExpanded(Pageable pageable, Integer bidId, Integer subId);

    @Deprecated
    public Page<Object> executeGetSettingPipeRFTPercent(Pageable pageable);

    @Deprecated
    public int executeUpdateSteelImpQuantity(Integer quantity, BigDecimal percent, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeBoltup(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesByTestPackagePipe(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetActivityHistorySteelShake(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdateSteelWeld(String area, String piece, Integer quantity, BigDecimal percent, Character rework, String notes, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSettingCivilPunch(BigDecimal value1);

    @Deprecated
    public int executeUpdatePipeMisc(String drawingNumber, String lineNumber, String sheetNumber, Integer quantity, Integer rework, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetReportDPRPipe(Pageable pageable, String foremanId, String superId, String managerId, Date startDate, Date endDate);

    @Deprecated
    public int executeUpdateSteelMiscQuantity(Integer quantity, Float fieldActivityId);

    @Deprecated
    public int executeUpdateSteelMisc(String area, String piece, Integer quantity, Byte rework, String notes, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSteelDemoQuantity(Integer quantity, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSteelDemo(String area, Integer steelType, String size, Integer quantity, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetBidWorkHistoryPipe(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeWeld(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetReportDPRSteelCondensed(Pageable pageable, String pm, String constM, String siteM, String areaM, String super_, String gf, String foreman, Date startDate, Date endDate);

    @Deprecated
    public int executeUpdateSteelBoltout(String area, String piece, Integer quantity, BigDecimal percent, Byte rework, String notes, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSubDetails(String temp, String precipitation, String wind, Integer submissionId);

    @Deprecated
    public int executeUnLockSSActivity(Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetSettingSteelImpPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesByTestPackageCivil(Pageable pageable, String testPackage);

    @Deprecated
    public int executeUpdateSettingCivilWork(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetBidActivityQuantitiesPipe(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetQuantitiesTestPackageSteel(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeSupport(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdateSteelErectQuantity(Integer quantity, BigDecimal percent, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSteelShake(String area, String piece, Integer quantity, Byte rework, String notes, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSettingPipeCTOPercent(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetSettingSteelErectPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetSettingCivilWork(Pageable pageable);

    @Deprecated
    public int executeUpdateSteelShakeQuantity(Integer quantity, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSettingSteelImp(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetSettingPipeMechPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesPipe(Pageable pageable, String lineNumber, String drawingNumber, String sheetNumber, String ect, String ecttype);

    @Deprecated
    public int executeUpdateSteelWeldQuantity(Integer quantity, BigDecimal percent, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSteelImp(String area, String piece, Integer quantity, BigDecimal percent, Byte rework, String notes, Integer fieldActivityId);

    @Deprecated
    public int executeUpdatePipeBoltupQuantity(Integer boltUpQuantity, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSteelSell(String area, String piece, Integer quantity, Byte rework, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetSettingPipeTestingPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesCivil(Pageable pageable, Integer bidId, String foundation, String drawingNumber, String detailDrawingNumber);

    @Deprecated
    public int executeUpdateSteelErect(String area, String piece, Integer quantity, BigDecimal percent, Byte rework, String notes, Integer fieldActivityId);

    @Deprecated
    public int executeUpdatePipeEWO(String ewonumber, Integer ewohours, String drawingNumber, String lineNumber, String sheetNumber, Integer rework, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetQuantityLFInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetActivityHistorySteelSell(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdateSettingPipeRFTPercent(BigDecimal value1);

    @Deprecated
    public int executeUpdateCivilMisc(String foundation, String drawing, String detailDrawing, BigDecimal percent, Integer rework, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetQuantitySupportsInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public int executeCreateSSNote(String fieldActivityId, Integer createdBy, String note);

    @Deprecated
    public int executeUpdateSettingPipeMechPercent(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetSettingPipeCTOPercent(Pageable pageable);

    @Deprecated
    public int executeUpdateSettingPipeHydroPercent(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeMisc(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdateCivilFA(String description, String foundation, String drawing, String detailDrawing, BigDecimal percent, Integer quantity, Integer rework, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetActivityHistorySteelWeld(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetActivityHistorySteelImp(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdatePipeWeldQuantity(BigDecimal percentComplete, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetQuantityMiscInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public int executeUpdatePipeSupportsQuantity(Integer quantity, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetSettingCivilPunch(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetQuantityDemoRemoved(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetActivitiesPendingReview(Pageable pageable, Integer superId);

    @Deprecated
    public Page<Object> executeGetDrawingByTestPackageSteel(Pageable pageable, Integer testPackage);

    @Deprecated
    public Page<Object> executeGetActivityHistorySteelDemo(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdatePipeErectionQuantity(Integer spool1length, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSteelSellPackage(String testPackage, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetBidWorkHistorySteel(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetSettingProductivityIntervals(Pageable pageable);

    @Deprecated
    public int executeUpdatePipeSupports(String partNumber, Integer quantity, String drawingNumber, String lineNumber, String sheet, Byte complete, Byte shared, Integer percentComplete, Integer rework, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetPSRecentActivities(Pageable pageable, Integer userId);

    @Deprecated
    public Page<Object> executeGetBidActivityQuantitiesCivil(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetActivityHistorySteelBoltout(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetBidChangeLogByID(Pageable pageable, Integer id);

    @Deprecated
    public Page<Object> executeGetActivityHistoryCivilMisc(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetQuantityBoltUpInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesByTestPackageSteel(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeErection(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeCheckSASLock(Pageable pageable, String fieldActivityId);

    @Deprecated
    public int executeUpdateSteelBoltoutQuantity(Integer quantity, BigDecimal percent, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetReportDPRSteelDetailed(Pageable pageable, String pm, String constM, String siteM, String areaM, String super_, String gf, String foreman, Date startDate, Date endDate);

    @Deprecated
    public Page<Object> executeGetDrawingsByTestPackagePipe(Pageable pageable, String testPackage);

    @Deprecated
    public int executeUpdatePipeWeld(String spool1, String spool2, String drawingNumber, String lineNumber, String sheetNumber, String lineSpec, String weldNumber, String stencil, BigDecimal size, String thickness, String weldType, String weldPosition, String material, String procedure, Byte complete, Byte shared, BigInteger percentComplete, Byte rework, String notes, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSettingSteelBoltout(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetBidActivityMatchesSteel(Pageable pageable, String area, String pieceMark, String bidActivityType, String steelType);

    @Deprecated
    public Page<Object> executeGetSettingSteelBoltoutPercent(Pageable pageable);

    @Deprecated
    public int executeUpdateCivilFAQuantity(BigDecimal percent, Integer quantity, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSettingSteelErect(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetActivityHistoryStatus(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdatePipeDemoQuantity(Integer quantity, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetSettingSteelShakePercent(Pageable pageable);

    @Deprecated
    public int executeUpdateSettingPipeTestingPercent(BigDecimal value1);

    @Deprecated
    public Page<Object> executeGetBidActivityQuantitiesSteel(Pageable pageable, Integer bidId);

    @Deprecated
    public int executeUpdatePipeCutPrep(String drawingNumber, String lineNumber, String sheetNumber, BigDecimal size, String thickness, Integer rework, String notes, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSettingSteelSell(BigDecimal value1);

    @Deprecated
    public int executeUpdatePipeTrim(BigDecimal size, Integer plugQuantity, String handleType, String instType, String drawingNumber, String lineNumber, String sheetNumber, Integer rework, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeTesting(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdatePipeMiscQuantity(Integer quantity, Integer fieldActivityId);

    @Deprecated
    public int executeUpdatePipeBoltUp(String spool1, String spool2, String drawingNumber, String lineNumber, String sheetNumber, BigDecimal size, Integer quantity, Integer rework, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetBidWorkHistoryCivil(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetActivitiesPendingApproval(Pageable pageable, Integer userId);

    @Deprecated
    public Page<Object> executeGetSettingPipeHydroPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetDrawingByTestPackageCivil(Pageable pageable, Integer testPackage);

    @Deprecated
    public int executeUpdateCivilMiscQuantity(BigDecimal percent, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSS(Integer activityStatus, Integer userId, Integer bidId, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetQuantitiesTestPackagePipe(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetSettingSteelSellPercent(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetNotesByFieldActivityID(Pageable pageable, Integer fieldActivityId);

    @Deprecated
    public int executeUpdatePipeTrimQuantity(String quantity, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetQuantityCutPrepInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public int executeUpdatePipeTesting(String testPackageNumber, Integer rework, String notes, Integer fieldActivityId);

    @Deprecated
    public int executeUpdateSteelSellQuantity(Integer quantity, Float fieldActivityId);

    @Deprecated
    public Page<Object> executeGetQuantitiesTestPackageCivil(Pageable pageable, String testPackage);

    @Deprecated
    public Page<Object> executeGetReportDWRByDate(Pageable pageable, Date beginDate, Date endDate);

    @Deprecated
    public Page<Object> executeGetNoteCount(Pageable pageable, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeTrim(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetActivityHistorySteelMisc(Pageable pageable, Integer activityId);

    @Deprecated
    public Page<Object> executeGetActivityHistoryCivilFA(Pageable pageable, Integer activityId);

    @Deprecated
    public int executeUpdatePipeDemo(String drawingNumber, String lineNumber, String sheetNumber, Integer quantity, BigDecimal size, String notes, Integer fieldActivityId);

    @Deprecated
    public int executeUpdatePipeErection(String spool1, Integer spool1length, String spool2, Integer spool2length, String spool3, Integer spool3length, String spool4, Integer spool4length, String spool5, Integer spool5length, String spool6, Integer spool6length, Byte onCords, String drawingNumber, String lineNumber, String sheetNumber, BigDecimal size, Integer rework, String notes, Integer fieldActivityId);

    @Deprecated
    public Page<Object> executeGetQuantityTrimInstalled(Pageable pageable, Integer bidId);

    @Deprecated
    public Page<Object> executeGetActivityHistoryPipeDemo(Pageable pageable, Integer activityId);

}


