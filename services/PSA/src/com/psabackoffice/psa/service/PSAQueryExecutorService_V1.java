/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.psa.models.query.*;

@Deprecated
public interface PSAQueryExecutorService_V1 {

    @Deprecated
    public Page<Object> executeGetForemenBySuper(Pageable pageable, Integer superId);

    @Deprecated
    public Page<Object> executeGetSteelActivityTypes(Pageable pageable);

    @Deprecated
    public Page<Object> executeSuperintendents(Pageable pageable, Integer jobNumber);

    @Deprecated
    public int executeInsertUserPSA(Integer performanceEmployeeId, String firstName, String lastName, String email, String password, Byte mobileUser, Byte activeUser, Integer modifiedBy, Integer disciplineId, Integer craftId, Integer craftClassId, Integer roleId, Integer jobNumber);

    @Deprecated
    public int executeInsertAssignedJobNumber(Integer userId, String jobNumber);

    @Deprecated
    public int executeDeleteUserAssignedApps(Integer userId, Integer mobileAppGroupId);

    @Deprecated
    public Page<Object> executeGetJobNumberCountByJobNumber(Pageable pageable, Integer jobNumber);

    @Deprecated
    public Page<Object> executeGetChatConversationsByLoggedInUser(Pageable pageable, Integer userId);

    @Deprecated
    public Page<Object> executeGetUsersManagers(Pageable pageable, Integer jobNumber);

    @Deprecated
    public Page<Object> executeGetChatMessagesByConversationID(Pageable pageable, Integer conversationId);

    @Deprecated
    public int executeInsertLoginFailure(String enteredUsername, String enteredPassword);

    @Deprecated
    public Page<Object> executeGetRolesByDiscipline(Pageable pageable, Integer disciplineId);

    @Deprecated
    public int executeInsertUserCreds(Integer userId, String userName, String password);

    @Deprecated
    public int executeUpdateUserCredsUserName(String userName, Integer userId);

    @Deprecated
    public int executeInsertLoginSuccess(String enteredUsername);

    @Deprecated
    public int executeInsertFeedbackTicket(Integer userId, Integer feedbackType, Integer fbsubType, Integer errorSeverity);

    @Deprecated
    public Page<Object> executeGetDefaultJobNumber(Pageable pageable, Integer userId);

    @Deprecated
    public int executeUpdateUserPSA(Integer performanceEmployeeId, String firstName, String lastName, String nickname, String email, Byte activeUser, Integer modifiedBy, Integer disciplineId, Integer craftId, Integer craftClassId, Integer roleId, Integer defaultJobNumberId, Integer userId);

    @Deprecated
    public Page<Object> executeGetFBNotesByFBID(Pageable pageable, Integer feedbackId);

    @Deprecated
    public int executeInsertChatMessage(Integer conversationId, Integer userId, String message);

    @Deprecated
    public int executeDeleteAssignedJobNumber(Integer userId, String jobNumber);

    @Deprecated
    public Page<Object> executeGetUsersForemen(Pageable pageable, Integer jobNumber, String disciplineId, String pm, String constM, String siteM, String areaM, String super_);

    @Deprecated
    public Page<Object> executeGetFBSubTypeByType(Pageable pageable, Integer fbtype);

    @Deprecated
    public int executeInsertFeedbackNotes(Integer userId, String notes);

    @Deprecated
    public int executeUpdateUserCreds(String userName, String password, Integer userId);

    @Deprecated
    public Page<Object> executeGetUsersSupers(Pageable pageable, Integer jobNumber, String disciplineId, String pm, String constM, String siteM, String areaM);

    @Deprecated
    public int executeInsertUserAssignedApps(Integer userId, Integer mobileAppGroupId);

    @Deprecated
    public Page<Object> executeGetAssignedJobNumbers(Pageable pageable, Integer userId);

    @Deprecated
    public Page<Object> executeManagers(Pageable pageable, Integer jobNumber);

    @Deprecated
    public Page<Object> executeGetJobSites(Pageable pageable, String siteName, String city, String state);

    @Deprecated
    public Page<Object> executeGetSettingDashUpdateInt(Pageable pageable);

    @Deprecated
    public Page<Object> executeGetChatRecipientName(Pageable pageable, Integer conversationId, Integer userId);

    @Deprecated
    public Page<Object> executeGetPSAUsers(Pageable pageable);

    @Deprecated
    public int executeInsertFeedbackTicketNotes(Integer ticketId, Integer userId, String note);

    @Deprecated
    public Page<Object> executeGetHelpMenuVideos(Pageable pageable);

}


