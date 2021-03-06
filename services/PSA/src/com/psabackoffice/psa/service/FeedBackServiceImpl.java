/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
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

import com.psabackoffice.psa.FeedBack;
import com.psabackoffice.psa.FeedBackNotes;


/**
 * ServiceImpl object for domain model class FeedBack.
 *
 * @see FeedBack
 */
@Service("PSA.FeedBackService")
@Validated
public class FeedBackServiceImpl implements FeedBackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedBackServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("PSA.FeedBackNotesService")
	private FeedBackNotesService feedBackNotesService;

    @Autowired
    @Qualifier("PSA.FeedBackDao")
    private WMGenericDao<FeedBack, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<FeedBack, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public FeedBack create(FeedBack feedBack) {
        LOGGER.debug("Creating a new FeedBack with information: {}", feedBack);

        FeedBack feedBackCreated = this.wmGenericDao.create(feedBack);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(feedBackCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public FeedBack getById(Integer feedbackId) {
        LOGGER.debug("Finding FeedBack by id: {}", feedbackId);
        return this.wmGenericDao.findById(feedbackId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public FeedBack findById(Integer feedbackId) {
        LOGGER.debug("Finding FeedBack by id: {}", feedbackId);
        try {
            return this.wmGenericDao.findById(feedbackId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No FeedBack found with id: {}", feedbackId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public FeedBack update(FeedBack feedBack) {
        LOGGER.debug("Updating FeedBack with information: {}", feedBack);

        List<FeedBackNotes> feedBackNoteses = feedBack.getFeedBackNoteses();
        if(feedBackNoteses != null && Hibernate.isInitialized(feedBackNoteses)) {
            feedBackNoteses.forEach(_feedBackNotes -> _feedBackNotes.setFeedBack(feedBack));
        }

        this.wmGenericDao.update(feedBack);
        this.wmGenericDao.refresh(feedBack);

        return feedBack;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public FeedBack delete(Integer feedbackId) {
        LOGGER.debug("Deleting FeedBack with id: {}", feedbackId);
        FeedBack deleted = this.wmGenericDao.findById(feedbackId);
        if (deleted == null) {
            LOGGER.debug("No FeedBack found with id: {}", feedbackId);
            throw new EntityNotFoundException(String.valueOf(feedbackId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(FeedBack feedBack) {
        LOGGER.debug("Deleting FeedBack with {}", feedBack);
        this.wmGenericDao.delete(feedBack);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<FeedBack> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all FeedBacks");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<FeedBack> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all FeedBacks");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table FeedBack to {} format", exportType);
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

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<FeedBackNotes> findAssociatedFeedBackNoteses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated feedBackNoteses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("feedBack.id = '" + id + "'");

        return feedBackNotesService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service FeedBackNotesService instance
	 */
	protected void setFeedBackNotesService(FeedBackNotesService service) {
        this.feedBackNotesService = service;
    }

}

