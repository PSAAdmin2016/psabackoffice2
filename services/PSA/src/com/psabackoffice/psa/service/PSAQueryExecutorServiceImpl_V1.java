/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/

package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
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

import com.psabackoffice.psa.models.query.*;

@Service
public class PSAQueryExecutorServiceImpl_V1 implements PSAQueryExecutorService_V1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(PSAQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("PSAWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetForemenBySuper(Pageable pageable, Integer superId) {
        Map params = new HashMap(1);

        params.put("SuperID", superId);

        return queryExecutor.executeNamedQuery("GetForemenBySuper", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetSteelActivityTypes(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSteelActivityTypes", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeSuperintendents(Pageable pageable, Integer jobNumber) {
        Map params = new HashMap(1);

        params.put("JobNumber", jobNumber);

        return queryExecutor.executeNamedQuery("Superintendents", params, Object.class, pageable);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeInsertUserPSA(Integer performanceEmployeeId, String firstName, String lastName, String email, String password, Byte mobileUser, Byte activeUser, Integer modifiedBy, Integer disciplineId, Integer craftId, Integer craftClassId, Integer roleId, Integer jobNumber) {
        Map params = new HashMap(13);

        params.put("PerformanceEmployeeID", performanceEmployeeId);
        params.put("FirstName", firstName);
        params.put("LastName", lastName);
        params.put("Email", email);
        params.put("Password", password);
        params.put("MobileUser", mobileUser);
        params.put("ActiveUser", activeUser);
        params.put("ModifiedBy", modifiedBy);
        params.put("DisciplineId", disciplineId);
        params.put("CraftId", craftId);
        params.put("CraftClassId", craftClassId);
        params.put("RoleId", roleId);
        params.put("JobNumber", jobNumber);

        return queryExecutor.executeNamedQueryForUpdate("InsertUserPSA", params);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeInsertAssignedJobNumber(Integer userId, String jobNumber) {
        Map params = new HashMap(2);

        params.put("UserId", userId);
        params.put("JobNumber", jobNumber);

        return queryExecutor.executeNamedQueryForUpdate("InsertAssignedJobNumber", params);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeDeleteUserAssignedApps(Integer userId, Integer mobileAppGroupId) {
        Map params = new HashMap(2);

        params.put("UserID", userId);
        params.put("MobileAppGroupID", mobileAppGroupId);

        return queryExecutor.executeNamedQueryForUpdate("DeleteUserAssignedApps", params);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetJobNumberCountByJobNumber(Pageable pageable, Integer jobNumber) {
        Map params = new HashMap(1);

        params.put("JobNumber", jobNumber);

        return queryExecutor.executeNamedQuery("GetJobNumberCountByJobNumber", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetChatConversationsByLoggedInUser(Pageable pageable, Integer userId) {
        Map params = new HashMap(1);

        params.put("UserID", userId);

        return queryExecutor.executeNamedQuery("GetChatConversationsByLoggedInUser", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetUsersManagers(Pageable pageable, Integer jobNumber) {
        Map params = new HashMap(1);

        params.put("JobNumber", jobNumber);

        return queryExecutor.executeNamedQuery("GetUsersManagers", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetChatMessagesByConversationID(Pageable pageable, Integer conversationId) {
        Map params = new HashMap(1);

        params.put("ConversationID", conversationId);

        return queryExecutor.executeNamedQuery("GetChatMessagesByConversationID", params, Object.class, pageable);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeInsertLoginFailure(String enteredUsername, String enteredPassword) {
        Map params = new HashMap(2);

        params.put("EnteredUsername", enteredUsername);
        params.put("EnteredPassword", enteredPassword);

        return queryExecutor.executeNamedQueryForUpdate("InsertLoginFailure", params);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetRolesByDiscipline(Pageable pageable, Integer disciplineId) {
        Map params = new HashMap(1);

        params.put("DisciplineID", disciplineId);

        return queryExecutor.executeNamedQuery("GetRolesByDiscipline", params, Object.class, pageable);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeInsertUserCreds(Integer userId, String userName, String password) {
        Map params = new HashMap(3);

        params.put("UserID", userId);
        params.put("UserName", userName);
        params.put("Password", password);

        return queryExecutor.executeNamedQueryForUpdate("InsertUserCreds", params);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeUpdateUserCredsUserName(String userName, Integer userId) {
        Map params = new HashMap(2);

        params.put("UserName", userName);
        params.put("UserID", userId);

        return queryExecutor.executeNamedQueryForUpdate("UpdateUserCredsUserName", params);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeInsertLoginSuccess(String enteredUsername) {
        Map params = new HashMap(1);

        params.put("EnteredUsername", enteredUsername);

        return queryExecutor.executeNamedQueryForUpdate("InsertLoginSuccess", params);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeInsertFeedbackTicket(Integer userId, Integer feedbackType, Integer fbsubType, Integer errorSeverity) {
        Map params = new HashMap(4);

        params.put("UserID", userId);
        params.put("FeedbackType", feedbackType);
        params.put("FBSubType", fbsubType);
        params.put("ErrorSeverity", errorSeverity);

        return queryExecutor.executeNamedQueryForUpdate("InsertFeedbackTicket", params);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetDefaultJobNumber(Pageable pageable, Integer userId) {
        Map params = new HashMap(1);

        params.put("UserID", userId);

        return queryExecutor.executeNamedQuery("GetDefaultJobNumber", params, Object.class, pageable);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeUpdateUserPSA(Integer performanceEmployeeId, String firstName, String lastName, String nickname, String email, Byte activeUser, Integer modifiedBy, Integer disciplineId, Integer craftId, Integer craftClassId, Integer roleId, Integer defaultJobNumberId, Integer userId) {
        Map params = new HashMap(13);

        params.put("PerformanceEmployeeId", performanceEmployeeId);
        params.put("FirstName", firstName);
        params.put("LastName", lastName);
        params.put("Nickname", nickname);
        params.put("Email", email);
        params.put("ActiveUser", activeUser);
        params.put("ModifiedBy", modifiedBy);
        params.put("DisciplineId", disciplineId);
        params.put("CraftId", craftId);
        params.put("CraftClassId", craftClassId);
        params.put("RoleId", roleId);
        params.put("DefaultJobNumberId", defaultJobNumberId);
        params.put("UserID", userId);

        return queryExecutor.executeNamedQueryForUpdate("UpdateUserPSA", params);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetFBNotesByFBID(Pageable pageable, Integer feedbackId) {
        Map params = new HashMap(1);

        params.put("FeedbackID", feedbackId);

        return queryExecutor.executeNamedQuery("GetFBNotesByFBID", params, Object.class, pageable);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeInsertChatMessage(Integer conversationId, Integer userId, String message) {
        Map params = new HashMap(3);

        params.put("ConversationID", conversationId);
        params.put("UserID", userId);
        params.put("Message", message);

        return queryExecutor.executeNamedQueryForUpdate("InsertChatMessage", params);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeDeleteAssignedJobNumber(Integer userId, String jobNumber) {
        Map params = new HashMap(2);

        params.put("UserID", userId);
        params.put("JobNumber", jobNumber);

        return queryExecutor.executeNamedQueryForUpdate("DeleteAssignedJobNumber", params);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetUsersForemen(Pageable pageable, Integer jobNumber, String disciplineId, String pm, String constM, String siteM, String areaM, String super_) {
        Map params = new HashMap(7);

        params.put("JobNumber", jobNumber);
        params.put("DisciplineID", disciplineId);
        params.put("PM", pm);
        params.put("ConstM", constM);
        params.put("SiteM", siteM);
        params.put("AreaM", areaM);
        params.put("Super", super_);

        return queryExecutor.executeNamedQuery("GetUsersForemen", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetFBSubTypeByType(Pageable pageable, Integer fbtype) {
        Map params = new HashMap(1);

        params.put("FBType", fbtype);

        return queryExecutor.executeNamedQuery("GetFBSubTypeByType", params, Object.class, pageable);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeInsertFeedbackNotes(Integer userId, String notes) {
        Map params = new HashMap(2);

        params.put("UserID", userId);
        params.put("Notes", notes);

        return queryExecutor.executeNamedQueryForUpdate("InsertFeedbackNotes", params);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeUpdateUserCreds(String userName, String password, Integer userId) {
        Map params = new HashMap(3);

        params.put("UserName", userName);
        params.put("Password", password);
        params.put("UserID", userId);

        return queryExecutor.executeNamedQueryForUpdate("UpdateUserCreds", params);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetUsersSupers(Pageable pageable, Integer jobNumber, String disciplineId, String pm, String constM, String siteM, String areaM) {
        Map params = new HashMap(6);

        params.put("JobNumber", jobNumber);
        params.put("DisciplineID", disciplineId);
        params.put("PM", pm);
        params.put("ConstM", constM);
        params.put("SiteM", siteM);
        params.put("AreaM", areaM);

        return queryExecutor.executeNamedQuery("GetUsersSupers", params, Object.class, pageable);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeInsertUserAssignedApps(Integer userId, Integer mobileAppGroupId) {
        Map params = new HashMap(2);

        params.put("UserID", userId);
        params.put("MobileAppGroupID", mobileAppGroupId);

        return queryExecutor.executeNamedQueryForUpdate("InsertUserAssignedApps", params);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetAssignedJobNumbers(Pageable pageable, Integer userId) {
        Map params = new HashMap(1);

        params.put("UserID", userId);

        return queryExecutor.executeNamedQuery("GetAssignedJobNumbers", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeManagers(Pageable pageable, Integer jobNumber) {
        Map params = new HashMap(1);

        params.put("JobNumber", jobNumber);

        return queryExecutor.executeNamedQuery("Managers", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetJobSites(Pageable pageable, String siteName, String city, String state) {
        Map params = new HashMap(3);

        params.put("SiteName", siteName);
        params.put("City", city);
        params.put("State", state);

        return queryExecutor.executeNamedQuery("GetJobSites", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetSettingDashUpdateInt(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetSettingDashUpdateInt", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetChatRecipientName(Pageable pageable, Integer conversationId, Integer userId) {
        Map params = new HashMap(2);

        params.put("ConversationID", conversationId);
        params.put("UserID", userId);

        return queryExecutor.executeNamedQuery("GetChatRecipientName", params, Object.class, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetPSAUsers(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetPSAUsers", params, Object.class, pageable);
    }

    @Transactional(value = "PSATransactionManager")
    @Override
    public int executeInsertFeedbackTicketNotes(Integer ticketId, Integer userId, String note) {
        Map params = new HashMap(3);

        params.put("TicketID", ticketId);
        params.put("UserID", userId);
        params.put("Note", note);

        return queryExecutor.executeNamedQueryForUpdate("InsertFeedbackTicketNotes", params);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Object> executeGetHelpMenuVideos(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("GetHelpMenuVideos", params, Object.class, pageable);
    }

}


