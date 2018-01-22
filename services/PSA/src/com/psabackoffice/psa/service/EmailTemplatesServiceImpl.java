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

import com.psabackoffice.psa.EmailTemplates;


/**
 * ServiceImpl object for domain model class EmailTemplates.
 *
 * @see EmailTemplates
 */
@Service("PSA.EmailTemplatesService")
@Validated
public class EmailTemplatesServiceImpl implements EmailTemplatesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailTemplatesServiceImpl.class);


    @Autowired
    @Qualifier("PSA.EmailTemplatesDao")
    private WMGenericDao<EmailTemplates, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EmailTemplates, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public EmailTemplates create(EmailTemplates emailTemplates) {
        LOGGER.debug("Creating a new EmailTemplates with information: {}", emailTemplates);

        EmailTemplates emailTemplatesCreated = this.wmGenericDao.create(emailTemplates);
        return emailTemplatesCreated;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public EmailTemplates getById(Integer emailtemplatesId) throws EntityNotFoundException {
        LOGGER.debug("Finding EmailTemplates by id: {}", emailtemplatesId);
        EmailTemplates emailTemplates = this.wmGenericDao.findById(emailtemplatesId);
        if (emailTemplates == null){
            LOGGER.debug("No EmailTemplates found with id: {}", emailtemplatesId);
            throw new EntityNotFoundException(String.valueOf(emailtemplatesId));
        }
        return emailTemplates;
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public EmailTemplates findById(Integer emailtemplatesId) {
        LOGGER.debug("Finding EmailTemplates by id: {}", emailtemplatesId);
        return this.wmGenericDao.findById(emailtemplatesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public EmailTemplates update(EmailTemplates emailTemplates) throws EntityNotFoundException {
        LOGGER.debug("Updating EmailTemplates with information: {}", emailTemplates);
        this.wmGenericDao.update(emailTemplates);

        Integer emailtemplatesId = emailTemplates.getId();

        return this.wmGenericDao.findById(emailtemplatesId);
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public EmailTemplates delete(Integer emailtemplatesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmailTemplates with id: {}", emailtemplatesId);
        EmailTemplates deleted = this.wmGenericDao.findById(emailtemplatesId);
        if (deleted == null) {
            LOGGER.debug("No EmailTemplates found with id: {}", emailtemplatesId);
            throw new EntityNotFoundException(String.valueOf(emailtemplatesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<EmailTemplates> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all EmailTemplates");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<EmailTemplates> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all EmailTemplates");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table EmailTemplates to {} format", exportType);
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

