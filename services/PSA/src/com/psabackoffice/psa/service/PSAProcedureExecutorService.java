/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.psabackoffice.psa.models.procedure.*;

public interface PSAProcedureExecutorService {

    Void executeImportInstalledQuantitiesEquip(String jobNumber);

    CompareColumnsResponse executeCompareColumns(String tableName, String jobNumber);

    GetImportTotalsResponse executeGetImportTotals(String tableNameLanding, String tableNameDestination, String jobNumber);

    LandingToWeldSpecProceduresResponse executeLandingToWeldSpecProcedures(String jobNumber);

    LandingToTrackerCivilResponse executeLandingToTrackerCivil(String jobNumber);

    Void executeImportInstalledQuantitiesPipe(String jobNumber);

    CreateNewJobDbResponse executeCreateNewJobDB(CreateNewJobDbRequest createNewJobDbRequest);

    CreateNewJobSeedsResponse executeCreateNewJobSeeds(CreateNewJobSeedsRequest createNewJobSeedsRequest);

    Void executeImportInstalledQuantitiesSteel(String jobNumber);

    LandingToTrackerEquipResponse executeLandingToTrackerEquip(String jobNumber);

    CreateNewConversationResponse executeCreateNewConversation(CreateNewConversationRequest createNewConversationRequest);

    ValidateLandingDataResponse executeValidateLandingData(String tableName, String jobNumber);

    Void executeImportInstalledQuantitiesCivil(String jobNumber);

    LandingToTrackerPipeResponse executeLandingToTrackerPipe(String jobNumber);

    LandingToPipeSpoolsResponse executeLandingToPipeSpools(String jobNumber);

    LandingToTrackerSteelResponse executeLandingToTrackerSteel(String jobNumber);

}


