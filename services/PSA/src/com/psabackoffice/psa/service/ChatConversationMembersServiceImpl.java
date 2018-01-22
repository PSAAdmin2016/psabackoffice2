/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.psa.ChatConversationMembers;


/**
 * ServiceImpl object for domain model class ChatConversationMembers.
 *
 * @see ChatConversationMembers
 */
@Service("PSA.ChatConversationMembersService")
@Validated
public class ChatConversationMembersServiceImpl implements ChatConversationMembersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatConversationMembersServiceImpl.class);


    @Autowired
    @Qualifier("PSA.ChatConversationMembersDao")
    private WMGenericDao<ChatConversationMembers, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ChatConversationMembers, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public ChatConversationMembers create(ChatConversationMembers chatConversationMembers) {
        LOGGER.debug("Creating a new ChatConversationMembers with information: {}", chatConversationMembers);

        ChatConversationMembers chatConversationMembersCreated = this.wmGenericDao.create(chatConversationMembers);
        return chatConversationMembersCreated;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public ChatConversationMembers getById(Integer chatconversationmembersId) throws EntityNotFoundException {
        LOGGER.debug("Finding ChatConversationMembers by id: {}", chatconversationmembersId);
        ChatConversationMembers chatConversationMembers = this.wmGenericDao.findById(chatconversationmembersId);
        if (chatConversationMembers == null){
            LOGGER.debug("No ChatConversationMembers found with id: {}", chatconversationmembersId);
            throw new EntityNotFoundException(String.valueOf(chatconversationmembersId));
        }
        return chatConversationMembers;
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public ChatConversationMembers findById(Integer chatconversationmembersId) {
        LOGGER.debug("Finding ChatConversationMembers by id: {}", chatconversationmembersId);
        return this.wmGenericDao.findById(chatconversationmembersId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public ChatConversationMembers update(ChatConversationMembers chatConversationMembers) throws EntityNotFoundException {
        LOGGER.debug("Updating ChatConversationMembers with information: {}", chatConversationMembers);
        this.wmGenericDao.update(chatConversationMembers);

        Integer chatconversationmembersId = chatConversationMembers.getUid();

        return this.wmGenericDao.findById(chatconversationmembersId);
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public ChatConversationMembers delete(Integer chatconversationmembersId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ChatConversationMembers with id: {}", chatconversationmembersId);
        ChatConversationMembers deleted = this.wmGenericDao.findById(chatconversationmembersId);
        if (deleted == null) {
            LOGGER.debug("No ChatConversationMembers found with id: {}", chatconversationmembersId);
            throw new EntityNotFoundException(String.valueOf(chatconversationmembersId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<ChatConversationMembers> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ChatConversationMembers");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<ChatConversationMembers> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ChatConversationMembers");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table ChatConversationMembers to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

