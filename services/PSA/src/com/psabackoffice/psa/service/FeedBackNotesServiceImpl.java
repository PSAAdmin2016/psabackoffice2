/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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

import com.psabackoffice.psa.FeedBackNotes;


/**
 * ServiceImpl object for domain model class FeedBackNotes.
 *
 * @see FeedBackNotes
 */
@Service("PSA.FeedBackNotesService")
@Validated
public class FeedBackNotesServiceImpl implements FeedBackNotesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedBackNotesServiceImpl.class);


    @Autowired
    @Qualifier("PSA.FeedBackNotesDao")
    private WMGenericDao<FeedBackNotes, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<FeedBackNotes, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public FeedBackNotes create(FeedBackNotes feedBackNotes) {
        LOGGER.debug("Creating a new FeedBackNotes with information: {}", feedBackNotes);

        FeedBackNotes feedBackNotesCreated = this.wmGenericDao.create(feedBackNotes);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(feedBackNotesCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public FeedBackNotes getById(Integer feedbacknotesId) {
        LOGGER.debug("Finding FeedBackNotes by id: {}", feedbacknotesId);
        return this.wmGenericDao.findById(feedbacknotesId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public FeedBackNotes findById(Integer feedbacknotesId) {
        LOGGER.debug("Finding FeedBackNotes by id: {}", feedbacknotesId);
        try {
            return this.wmGenericDao.findById(feedbacknotesId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No FeedBackNotes found with id: {}", feedbacknotesId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public FeedBackNotes update(FeedBackNotes feedBackNotes) {
        LOGGER.debug("Updating FeedBackNotes with information: {}", feedBackNotes);

        this.wmGenericDao.update(feedBackNotes);
        this.wmGenericDao.refresh(feedBackNotes);

        return feedBackNotes;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public FeedBackNotes delete(Integer feedbacknotesId) {
        LOGGER.debug("Deleting FeedBackNotes with id: {}", feedbacknotesId);
        FeedBackNotes deleted = this.wmGenericDao.findById(feedbacknotesId);
        if (deleted == null) {
            LOGGER.debug("No FeedBackNotes found with id: {}", feedbacknotesId);
            throw new EntityNotFoundException(String.valueOf(feedbacknotesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(FeedBackNotes feedBackNotes) {
        LOGGER.debug("Deleting FeedBackNotes with {}", feedBackNotes);
        this.wmGenericDao.delete(feedBackNotes);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<FeedBackNotes> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all FeedBackNotes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<FeedBackNotes> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all FeedBackNotes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table FeedBackNotes to {} format", exportType);
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

