/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.job1111.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.job1111.models.query.*;

public interface Job1111QueryExecutorService {

    Page<GetBidWorkHistorySteelResponse> executeGetBidWorkHistorySteel(Integer bidId, Pageable pageable);

    Downloadable exportGetBidWorkHistorySteel(ExportType exportType, Integer bidId, Pageable pageable);

    Page<GetQuantitiesTestPackageSteelResponse> executeGetQuantitiesTestPackageSteel(String testPackage, Pageable pageable);

    Downloadable exportGetQuantitiesTestPackageSteel(ExportType exportType, String testPackage, Pageable pageable);

    Page<GetSettingPipeHydroPercentResponse> executeGetSettingPipeHydroPercent(Pageable pageable);

    Downloadable exportGetSettingPipeHydroPercent(ExportType exportType, Pageable pageable);

    Page<GetActivityHistoryPipeErectionResponse> executeGetActivityHistoryPipeErection(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistoryPipeErection(ExportType exportType, Integer activityId, Pageable pageable);

    Integer executeUpdateSteelErectQuantity(UpdateSteelErectQuantityRequest updateSteelErectQuantityRequest);

    Integer executeUpdateSteelFA(UpdateSteelFaRequest updateSteelFaRequest);

    Page<GetActivityHistoryPipeWeldResponse> executeGetActivityHistoryPipeWeld(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistoryPipeWeld(ExportType exportType, Integer activityId, Pageable pageable);

    Page<GetActivitiesPendingReviewFasResponse> executeGetActivitiesPendingReviewFAs(Integer superId, Pageable pageable);

    Downloadable exportGetActivitiesPendingReviewFAs(ExportType exportType, Integer superId, Pageable pageable);

    Integer executeUpdateSteelDemo(UpdateSteelDemoRequest updateSteelDemoRequest);

    Page<GetQuantitiesTestPackageCivilResponse> executeGetQuantitiesTestPackageCivil(String testPackage, Pageable pageable);

    Downloadable exportGetQuantitiesTestPackageCivil(ExportType exportType, String testPackage, Pageable pageable);

    Integer executeUpdateEquipFAQuantity(UpdateEquipFaquantityRequest updateEquipFaquantityRequest);

    Page<GetActivitiesPendingReviewSteelActivitiesResponse> executeGetActivitiesPendingReviewSteelActivities(Integer submissionId, String pieceMark, Integer statusId, Pageable pageable);

    Downloadable exportGetActivitiesPendingReviewSteelActivities(ExportType exportType, Integer submissionId, String pieceMark, Integer statusId, Pageable pageable);

    Integer executeUpdatePipeTrim(UpdatePipeTrimRequest updatePipeTrimRequest);

    Page<GetSettingSteelImpPercentResponse> executeGetSettingSteelImpPercent(Pageable pageable);

    Downloadable exportGetSettingSteelImpPercent(ExportType exportType, Pageable pageable);

    Integer executeUpdateSteelMisc(UpdateSteelMiscRequest updateSteelMiscRequest);

    Integer executeUpdateSteelWeldQuantity(UpdateSteelWeldQuantityRequest updateSteelWeldQuantityRequest);

    Integer executeUpdatePipeMiscQuantity(UpdatePipeMiscQuantityRequest updatePipeMiscQuantityRequest);

    Page<GetBidWorkHistoryCivilResponse> executeGetBidWorkHistoryCivil(Integer bidId, Pageable pageable);

    Downloadable exportGetBidWorkHistoryCivil(ExportType exportType, Integer bidId, Pageable pageable);

    Page<GetDrawingByTestPackageSteelResponse> executeGetDrawingByTestPackageSteel(String testPackage, Pageable pageable);

    Downloadable exportGetDrawingByTestPackageSteel(ExportType exportType, String testPackage, Pageable pageable);

    Page<GetQuantityBoltUpInstalledResponse> executeGetQuantityBoltUpInstalled(Integer bidId, Pageable pageable);

    Downloadable exportGetQuantityBoltUpInstalled(ExportType exportType, Integer bidId, Pageable pageable);

    Page<GetSettingSteelSellPercentResponse> executeGetSettingSteelSellPercent(Pageable pageable);

    Downloadable exportGetSettingSteelSellPercent(ExportType exportType, Pageable pageable);

    Page<GetActivityHistoryEquipFaResponse> executeGetActivityHistoryEquipFA(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistoryEquipFA(ExportType exportType, Integer activityId, Pageable pageable);

    Integer executeUpdatePipeMisc(UpdatePipeMiscRequest updatePipeMiscRequest);

    Page<GetReportDprsteelDetailedResponse> executeGetReportDPRSteelDetailed(String pm, String constM, String siteM, String areaM, String super_, String gf, String foreman, Date startDate, Date endDate, Pageable pageable);

    Downloadable exportGetReportDPRSteelDetailed(ExportType exportType, String pm, String constM, String siteM, String areaM, String super_, String gf, String foreman, Date startDate, Date endDate, Pageable pageable);

    Integer executeUpdateSteelWeld(UpdateSteelWeldRequest updateSteelWeldRequest);

    Page<GetBidActivityQuantitiesSteelResponse> executeGetBidActivityQuantitiesSteel(Integer bidId, Pageable pageable);

    Downloadable exportGetBidActivityQuantitiesSteel(ExportType exportType, Integer bidId, Pageable pageable);

    Page<GetSettingPipeTestingPercentResponse> executeGetSettingPipeTestingPercent(Pageable pageable);

    Downloadable exportGetSettingPipeTestingPercent(ExportType exportType, Pageable pageable);

    Page<GetBidWorkHistoryEquipResponse> executeGetBidWorkHistoryEquip(String bidId, Pageable pageable);

    Downloadable exportGetBidWorkHistoryEquip(ExportType exportType, String bidId, Pageable pageable);

    Integer executeUpdateSteelSellQuantity(UpdateSteelSellQuantityRequest updateSteelSellQuantityRequest);

    Integer executeUpdateSteelShake(UpdateSteelShakeRequest updateSteelShakeRequest);

    Page<GetActivitiesPendingReviewResponse> executeGetActivitiesPendingReview(Integer superId, Pageable pageable);

    Downloadable exportGetActivitiesPendingReview(ExportType exportType, Integer superId, Pageable pageable);

    Integer executeUpdatePipeDemoQuantity(UpdatePipeDemoQuantityRequest updatePipeDemoQuantityRequest);

    Integer executeUpdatePipeBoltupQuantity(UpdatePipeBoltupQuantityRequest updatePipeBoltupQuantityRequest);

    Integer executeUpdateSteelShakeQuantity(UpdateSteelShakeQuantityRequest updateSteelShakeQuantityRequest);

    Page<GetPsrecentActivitiesResponse> executeGetPSRecentActivities(Integer userId, Pageable pageable);

    Downloadable exportGetPSRecentActivities(ExportType exportType, Integer userId, Pageable pageable);

    Integer executeUpdatePipeErection(UpdatePipeErectionRequest updatePipeErectionRequest);

    Integer executeUpdateSettingPipeRFTPercent(UpdateSettingPipeRftpercentRequest updateSettingPipeRftpercentRequest);

    Page<GetActivityHistoryPipeTrimResponse> executeGetActivityHistoryPipeTrim(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistoryPipeTrim(ExportType exportType, Integer activityId, Pageable pageable);

    Page<GetSettingCivilWorkResponse> executeGetSettingCivilWork(Pageable pageable);

    Downloadable exportGetSettingCivilWork(ExportType exportType, Pageable pageable);

    Integer executeUpdatePipeErectionQuantity(UpdatePipeErectionQuantityRequest updatePipeErectionQuantityRequest);

    Integer executeUpdatePipeWeldQuantity(UpdatePipeWeldQuantityRequest updatePipeWeldQuantityRequest);

    Page<GetActivityHistorySteelMiscResponse> executeGetActivityHistorySteelMisc(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistorySteelMisc(ExportType exportType, Integer activityId, Pageable pageable);

    Page<GetSettingPipeRftpercentResponse> executeGetSettingPipeRFTPercent(Pageable pageable);

    Downloadable exportGetSettingPipeRFTPercent(ExportType exportType, Pageable pageable);

    Page<GetBidActivityMatchesByTestPackageCivilResponse> executeGetBidActivityMatchesByTestPackageCivil(String testPackage, Pageable pageable);

    Downloadable exportGetBidActivityMatchesByTestPackageCivil(ExportType exportType, String testPackage, Pageable pageable);

    Page<GetBidActivityQuantitiesPipeResponse> executeGetBidActivityQuantitiesPipe(Integer bidId, Pageable pageable);

    Downloadable exportGetBidActivityQuantitiesPipe(ExportType exportType, Integer bidId, Pageable pageable);

    Page<GetQuantityMiscInstalledResponse> executeGetQuantityMiscInstalled(Integer bidId, Pageable pageable);

    Downloadable exportGetQuantityMiscInstalled(ExportType exportType, Integer bidId, Pageable pageable);

    Page<GetSettingSteelErectPercentResponse> executeGetSettingSteelErectPercent(Pageable pageable);

    Downloadable exportGetSettingSteelErectPercent(ExportType exportType, Pageable pageable);

    Integer executeUpdateSteelMiscQuantity(UpdateSteelMiscQuantityRequest updateSteelMiscQuantityRequest);

    Integer executeUpdatePipeDemo(UpdatePipeDemoRequest updatePipeDemoRequest);

    Integer executeUpdateSettingCivilPunch(UpdateSettingCivilPunchRequest updateSettingCivilPunchRequest);

    Page<GetQuantityLfinstalledByActivityIdResponse> executeGetQuantityLFInstalledByActivityID(Integer activityId, Pageable pageable);

    Downloadable exportGetQuantityLFInstalledByActivityID(ExportType exportType, Integer activityId, Pageable pageable);

    Page<GetActivityHistoryStatusResponse> executeGetActivityHistoryStatus(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistoryStatus(ExportType exportType, Integer activityId, Pageable pageable);

    Page<GetBidActivityQuantitesEquipResponse> executeGetBidActivityQuantitesEquip(Integer bidId, Pageable pageable);

    Downloadable exportGetBidActivityQuantitesEquip(ExportType exportType, Integer bidId, Pageable pageable);

    Integer executeUpdatePipeCutPrep(UpdatePipeCutPrepRequest updatePipeCutPrepRequest);

    Page<GetActivityHistoryPipeMiscResponse> executeGetActivityHistoryPipeMisc(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistoryPipeMisc(ExportType exportType, Integer activityId, Pageable pageable);

    Page<GetActivityHistorySteelDemoResponse> executeGetActivityHistorySteelDemo(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistorySteelDemo(ExportType exportType, Integer activityId, Pageable pageable);

    Integer executeUpdateSettingPipeCTOPercent(UpdateSettingPipeCtopercentRequest updateSettingPipeCtopercentRequest);

    Page<GetActivityHistoryPipeDemoResponse> executeGetActivityHistoryPipeDemo(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistoryPipeDemo(ExportType exportType, Integer activityId, Pageable pageable);

    Page<GetBidActivityMatchesPipeResponse> executeGetBidActivityMatchesPipe(Integer bidId, String lineNumber, String drawingNumber, String sheetNumber, String activityType, String activitySubType, Pageable pageable);

    Downloadable exportGetBidActivityMatchesPipe(ExportType exportType, Integer bidId, String lineNumber, String drawingNumber, String sheetNumber, String activityType, String activitySubType, Pageable pageable);

    Integer executeUpdateSteelBoltoutQuantity(UpdateSteelBoltoutQuantityRequest updateSteelBoltoutQuantityRequest);

    Integer executeUpdatePipeWeld(UpdatePipeWeldRequest updatePipeWeldRequest);

    Page<GetBidActivityMatchesSteelResponse> executeGetBidActivityMatchesSteel(Integer bidId, String sortGroup1, String pieceMark, Pageable pageable);

    Downloadable exportGetBidActivityMatchesSteel(ExportType exportType, Integer bidId, String sortGroup1, String pieceMark, Pageable pageable);

    Page<GetQuantityLfinstalledByBidIdResponse> executeGetQuantityLFInstalledByBidID(Integer bidId, Pageable pageable);

    Downloadable exportGetQuantityLFInstalledByBidID(ExportType exportType, Integer bidId, Pageable pageable);

    Integer executeUpdateSettingCivilWork(UpdateSettingCivilWorkRequest updateSettingCivilWorkRequest);

    Page<GetNoteCountResponse> executeGetNoteCount(Integer activityId, Pageable pageable);

    Downloadable exportGetNoteCount(ExportType exportType, Integer activityId, Pageable pageable);

    Page<GetReportDwrbyDateResponse> executeGetReportDWRByDate(Date beginDate, Date endDate, Pageable pageable);

    Downloadable exportGetReportDWRByDate(ExportType exportType, Date beginDate, Date endDate, Pageable pageable);

    Page<GetSettingProductivityIntervalsResponse> executeGetSettingProductivityIntervals(Pageable pageable);

    Downloadable exportGetSettingProductivityIntervals(ExportType exportType, Pageable pageable);

    Integer executeUpdateSettingSteelSell(UpdateSettingSteelSellRequest updateSettingSteelSellRequest);

    Page<GetQuantitySupportsInstalledResponse> executeGetQuantitySupportsInstalled(Integer bidId, Pageable pageable);

    Downloadable exportGetQuantitySupportsInstalled(ExportType exportType, Integer bidId, Pageable pageable);

    Integer executeUpdateSteelImpQuantity(UpdateSteelImpQuantityRequest updateSteelImpQuantityRequest);

    Integer executeUpdateSettingSteelShake(UpdateSettingSteelShakeRequest updateSettingSteelShakeRequest);

    Page<GetQuantityCutPrepInstalledResponse> executeGetQuantityCutPrepInstalled(Integer bidId, Pageable pageable);

    Downloadable exportGetQuantityCutPrepInstalled(ExportType exportType, Integer bidId, Pageable pageable);

    Integer executeUpdateEquipFA(UpdateEquipFaRequest updateEquipFaRequest);

    Page<GetActivityHistorySteelFaResponse> executeGetActivityHistorySteelFA(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistorySteelFA(ExportType exportType, Integer activityId, Pageable pageable);

    Integer executeUpdateSettingSteelErect(UpdateSettingSteelErectRequest updateSettingSteelErectRequest);

    Page<GetActivityHistoryPipeConnectionResponse> executeGetActivityHistoryPipeConnection(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistoryPipeConnection(ExportType exportType, Integer activityId, Pageable pageable);

    Page<GetQuantitiesTestPackagePipeResponse> executeGetQuantitiesTestPackagePipe(String testPackage, Pageable pageable);

    Downloadable exportGetQuantitiesTestPackagePipe(ExportType exportType, String testPackage, Pageable pageable);

    Integer executeUpdatePipeSupportsQuantity(UpdatePipeSupportsQuantityRequest updatePipeSupportsQuantityRequest);

    Integer executeUpdateSettingPipeHydroPercent(UpdateSettingPipeHydroPercentRequest updateSettingPipeHydroPercentRequest);

    Page<GetReportDprsteelCondensedResponse> executeGetReportDPRSteelCondensed(String pm, String constM, String siteM, String areaM, String super_, String gf, String foreman, Date startDate, Date endDate, Pageable pageable);

    Downloadable exportGetReportDPRSteelCondensed(ExportType exportType, String pm, String constM, String siteM, String areaM, String super_, String gf, String foreman, Date startDate, Date endDate, Pageable pageable);

    Page<GetActivitiesPendingApprovalResponse> executeGetActivitiesPendingApproval(Integer userId, Pageable pageable);

    Downloadable exportGetActivitiesPendingApproval(ExportType exportType, Integer userId, Pageable pageable);

    Integer executeUpdatePipeTrimQuantity(UpdatePipeTrimQuantityRequest updatePipeTrimQuantityRequest);

    Page<GetSettingPipeCtopercentResponse> executeGetSettingPipeCTOPercent(Pageable pageable);

    Downloadable exportGetSettingPipeCTOPercent(ExportType exportType, Pageable pageable);

    Page<GetQuantityTrimInstalledResponse> executeGetQuantityTrimInstalled(Integer bidId, Pageable pageable);

    Downloadable exportGetQuantityTrimInstalled(ExportType exportType, Integer bidId, Pageable pageable);

    Page<GetActivityHistoryCivilFaResponse> executeGetActivityHistoryCivilFA(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistoryCivilFA(ExportType exportType, Integer activityId, Pageable pageable);

    Page<GetReportDprequipResponse> executeGetReportDPREquip(String foremanId, String superId, String managerId, Date startDate, Date endDate, Pageable pageable);

    Downloadable exportGetReportDPREquip(ExportType exportType, String foremanId, String superId, String managerId, Date startDate, Date endDate, Pageable pageable);

    Integer executeUpdateSettingSteelImp(UpdateSettingSteelImpRequest updateSettingSteelImpRequest);

    Page<CheckSaslockResponse> executeCheckSASLock(String activityId, Pageable pageable);

    Downloadable exportCheckSASLock(ExportType exportType, String activityId, Pageable pageable);

    Page<GetSettingCivilPunchResponse> executeGetSettingCivilPunch(Pageable pageable);

    Downloadable exportGetSettingCivilPunch(ExportType exportType, Pageable pageable);

    Page<GetReportDprpipeResponse> executeGetReportDPRPipe(String foremanId, String superId, String managerId, Date startDate, Date endDate, Pageable pageable);

    Downloadable exportGetReportDPRPipe(ExportType exportType, String foremanId, String superId, String managerId, Date startDate, Date endDate, Pageable pageable);

    Integer executeUpdatePipeBoltUp(UpdatePipeBoltUpRequest updatePipeBoltUpRequest);

    Integer executeUpdateCivilFA(UpdateCivilFaRequest updateCivilFaRequest);

    Integer executeUpdateSS(UpdateSsRequest updateSsRequest);

    Page<GetBidWorkHistorySteelExpandedResponse> executeGetBidWorkHistorySteelExpanded(Integer bidId, Integer submissionId, Pageable pageable);

    Downloadable exportGetBidWorkHistorySteelExpanded(ExportType exportType, Integer bidId, Integer submissionId, Pageable pageable);

    Page<GetSuperRecentActivitesResponse> executeGetSuperRecentActivites(Integer userId, Integer selectedSuper, Pageable pageable);

    Downloadable exportGetSuperRecentActivites(ExportType exportType, Integer userId, Integer selectedSuper, Pageable pageable);

    Page<GetReportDprcivilResponse> executeGetReportDPRCivil(String foremanId, String superId, String managerId, Date startDate, Date endDate, Pageable pageable);

    Downloadable exportGetReportDPRCivil(ExportType exportType, String foremanId, String superId, String managerId, Date startDate, Date endDate, Pageable pageable);

    Integer executeUpdateSettingPipeMechPercent(UpdateSettingPipeMechPercentRequest updateSettingPipeMechPercentRequest);

    Page<GetBidActivityMatchesCivilResponse> executeGetBidActivityMatchesCivil(Integer bidId, Pageable pageable);

    Downloadable exportGetBidActivityMatchesCivil(ExportType exportType, Integer bidId, Pageable pageable);

    Integer executeUpdateSteelSell(UpdateSteelSellRequest updateSteelSellRequest);

    Page<GetActivitiesPendingReviewSteelResponse> executeGetActivitiesPendingReviewSteel(Integer superId, Pageable pageable);

    Downloadable exportGetActivitiesPendingReviewSteel(ExportType exportType, Integer superId, Pageable pageable);

    Integer executeUpdateSteelImp(UpdateSteelImpRequest updateSteelImpRequest);

    Page<GetQuantityDemoRemovedResponse> executeGetQuantityDemoRemoved(Integer bidId, Pageable pageable);

    Downloadable exportGetQuantityDemoRemoved(ExportType exportType, Integer bidId, Pageable pageable);

    Integer executeUpdateCivilFAQuantity(UpdateCivilFaquantityRequest updateCivilFaquantityRequest);

    Integer executeUpdateSettingPipeTestingPercent(UpdateSettingPipeTestingPercentRequest updateSettingPipeTestingPercentRequest);

    Integer executeUpdateSteelErect(UpdateSteelErectRequest updateSteelErectRequest);

    Integer executeUpdateCivilSellPackage(UpdateCivilSellPackageRequest updateCivilSellPackageRequest);

    Page<GetSettingPipeMechPercentResponse> executeGetSettingPipeMechPercent(Pageable pageable);

    Downloadable exportGetSettingPipeMechPercent(ExportType exportType, Pageable pageable);

    Page<GetQuantityWeldInstalledResponse> executeGetQuantityWeldInstalled(Integer bidId, Pageable pageable);

    Downloadable exportGetQuantityWeldInstalled(ExportType exportType, Integer bidId, Pageable pageable);

    Integer executeUpdateSteelFAQuantity(UpdateSteelFaquantityRequest updateSteelFaquantityRequest);

    Page<GetBidActivityMatchesEquipResponse> executeGetBidActivityMatchesEquip(Integer bidId, Pageable pageable);

    Downloadable exportGetBidActivityMatchesEquip(ExportType exportType, Integer bidId, Pageable pageable);

    Page<GetSettingSteelBoltoutPercentResponse> executeGetSettingSteelBoltoutPercent(Pageable pageable);

    Downloadable exportGetSettingSteelBoltoutPercent(ExportType exportType, Pageable pageable);

    Page<GetDrawingsByTestPackagePipeResponse> executeGetDrawingsByTestPackagePipe(String testPackage, Pageable pageable);

    Downloadable exportGetDrawingsByTestPackagePipe(ExportType exportType, String testPackage, Pageable pageable);

    Page<GetSettingSteelShakePercentResponse> executeGetSettingSteelShakePercent(Pageable pageable);

    Downloadable exportGetSettingSteelShakePercent(ExportType exportType, Pageable pageable);

    Page<GetBidActivityMatchesByTestPackageSteelResponse> executeGetBidActivityMatchesByTestPackageSteel(String testPackage, Pageable pageable);

    Downloadable exportGetBidActivityMatchesByTestPackageSteel(ExportType exportType, String testPackage, Pageable pageable);

    Page<GetBidActivityMatchesByTestPackagePipeResponse> executeGetBidActivityMatchesByTestPackagePipe(String testPackage, Pageable pageable);

    Downloadable exportGetBidActivityMatchesByTestPackagePipe(ExportType exportType, String testPackage, Pageable pageable);

    Page<GetBidWorkHistoryPipeResponse> executeGetBidWorkHistoryPipe(Integer bidId, Pageable pageable);

    Downloadable exportGetBidWorkHistoryPipe(ExportType exportType, Integer bidId, Pageable pageable);

    Integer executeUnLockSSActivity(UnLockSsactivityRequest unLockSsactivityRequest);

    Integer executeUpdateSteelDemoQuantity(UpdateSteelDemoQuantityRequest updateSteelDemoQuantityRequest);

    Integer executeUpdatePipeSupports(UpdatePipeSupportsRequest updatePipeSupportsRequest);

    Page<GetActivityHistoryPipeTestingResponse> executeGetActivityHistoryPipeTesting(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistoryPipeTesting(ExportType exportType, Integer activityId, Pageable pageable);

    Integer executeUpdatePipeTesting(UpdatePipeTestingRequest updatePipeTestingRequest);

    Integer executeUpdatePipeEWO(UpdatePipeEwoRequest updatePipeEwoRequest);

    Page<GetDrawingByTestPackageCivilResponse> executeGetDrawingByTestPackageCivil(String testPackage, Pageable pageable);

    Downloadable exportGetDrawingByTestPackageCivil(ExportType exportType, String testPackage, Pageable pageable);

    Integer executeUpdateSteelBoltout(UpdateSteelBoltoutRequest updateSteelBoltoutRequest);

    Page<GetBidActivityQuantitiesCivilResponse> executeGetBidActivityQuantitiesCivil(Integer bidId, Pageable pageable);

    Downloadable exportGetBidActivityQuantitiesCivil(ExportType exportType, Integer bidId, Pageable pageable);

    Integer executeCreateSSNote(CreateSsnoteRequest createSsnoteRequest);

    Page<GetNotesByFieldActivityIdResponse> executeGetNotesByFieldActivityID(Integer activityId, Pageable pageable);

    Downloadable exportGetNotesByFieldActivityID(ExportType exportType, Integer activityId, Pageable pageable);

    Integer executeUpdateSteelSellPackage(UpdateSteelSellPackageRequest updateSteelSellPackageRequest);

    Page<GetActivityHistoryPipeSupportResponse> executeGetActivityHistoryPipeSupport(Integer activityId, Pageable pageable);

    Downloadable exportGetActivityHistoryPipeSupport(ExportType exportType, Integer activityId, Pageable pageable);

    Integer executeUpdateSettingSteelBoltout(UpdateSettingSteelBoltoutRequest updateSettingSteelBoltoutRequest);

}


