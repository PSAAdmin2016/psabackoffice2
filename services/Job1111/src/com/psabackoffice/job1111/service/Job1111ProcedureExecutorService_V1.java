/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.job1111.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.psabackoffice.job1111.models.procedure.*;

@Deprecated
public interface Job1111ProcedureExecutorService_V1 {

    @Deprecated
    List<Object> executeGetSteelPCOT(Integer runMode);

    @Deprecated
    List<Object> executeCreateManualActivitySteel(Integer varBidId, Integer varActivityType, Integer varQuantity, BigDecimal varPercentCompleted, String varNotes, Integer varUserId);

    @Deprecated
    List<Object> executeLockSSActivity(Integer runMode, Integer userId, Integer activityId);

    @Deprecated
    List<Object> executeGetPipePCOT(Integer runMode);

    @Deprecated
    List<Object> executeClassicTrackerPipeUpdate(Integer runMode, Integer updateBidId);

    @Deprecated
    List<Object> executeGetJobPCOT(Integer runMode);

    @Deprecated
    List<Object> executeCreateManualActivityPipe(Integer varBidId, Integer varQuantity, String varNotes, Integer varUserId);

    @Deprecated
    List<Object> executeGetCivilPCOT(Integer runMode);

    @Deprecated
    List<Object> executeGetPipeStats(String groupedBy, Integer runMode);

    @Deprecated
    List<Object> executeGetCivilStats(String groupedBy, Integer runMode);

    @Deprecated
    List<Object> executeCreateManualActivityCivil(Integer varBidId, Integer varQuantity, BigDecimal varPercentCompleted, String varNotes, Integer varUserId);

    @Deprecated
    List<Object> executeGetSteelStats(String groupedBy, Integer runMode);

    @Deprecated
    List<Object> executeClassicTrackerCivilUpdate(Integer runMode, Integer updateBidId);

    @Deprecated
    List<Object> executeCreateLooseHoursActivitiesSteel(Integer submissionId, Integer userId, String testPackage);

    @Deprecated
    List<Object> executeCreateLooseHoursActivitiesCivil(Integer submissionId, Integer userId, String testPackage);

    @Deprecated
    List<Object> executeCreateLooseHoursActivitiesPipe(Integer submissionId, Integer userId, String testPackage);

    @Deprecated
    List<Object> executeClassicTrackerSteelUpdate(Integer runMode, Integer updateBidId);

}


