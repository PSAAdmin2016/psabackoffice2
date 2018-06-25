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
import com.psabackoffice.psa.RefFbStatuses;


/**
 * ServiceImpl object for domain model class RefFbStatuses.
 *
 * @see RefFbStatuses
 */
@Service("PSA.RefFbStatusesService")
@Validated
public class RefFbStatusesServiceImpl implements RefFbStatusesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefFbStatusesServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("PSA.FeedBackService")
	private FeedBackService feedBackService;

    @Autowired
    @Qualifier("PSA.RefFbStatusesDao")
    private WMGenericDao<RefFbStatuses, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefFbStatuses, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefFbStatuses create(RefFbStatuses refFbStatuses) {
        LOGGER.debug("Creating a new RefFbStatuses with information: {}", refFbStatuses);

        RefFbStatuses refFbStatusesCreated = this.wmGenericDao.create(refFbStatuses);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refFbStatusesCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefFbStatuses getById(Integer reffbstatusesId) {
        LOGGER.debug("Finding RefFbStatuses by id: {}", reffbstatusesId);
        return this.wmGenericDao.findById(reffbstatusesId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefFbStatuses findById(Integer reffbstatusesId) {
        LOGGER.debug("Finding RefFbStatuses by id: {}", reffbstatusesId);
        try {
            return this.wmGenericDao.findById(reffbstatusesId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No RefFbStatuses found with id: {}", reffbstatusesId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefFbStatuses update(RefFbStatuses refFbStatuses) {
        LOGGER.debug("Updating RefFbStatuses with information: {}", refFbStatuses);

        List<FeedBack> feedBacks = refFbStatuses.getFeedBacks();
        if(feedBacks != null && Hibernate.isInitialized(feedBacks)) {
            feedBacks.forEach(_feedBack -> _feedBack.setRefFbStatuses(refFbStatuses));
        }

        this.wmGenericDao.update(refFbStatuses);
        this.wmGenericDao.refresh(refFbStatuses);

        return refFbStatuses;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefFbStatuses delete(Integer reffbstatusesId) {
        LOGGER.debug("Deleting RefFbStatuses with id: {}", reffbstatusesId);
        RefFbStatuses deleted = this.wmGenericDao.findById(reffbstatusesId);
        if (deleted == null) {
            LOGGER.debug("No RefFbStatuses found with id: {}", reffbstatusesId);
            throw new EntityNotFoundException(String.valueOf(reffbstatusesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(RefFbStatuses refFbStatuses) {
        LOGGER.debug("Deleting RefFbStatuses with {}", refFbStatuses);
        this.wmGenericDao.delete(refFbStatuses);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefFbStatuses> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefFbStatuses");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefFbStatuses> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefFbStatuses");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefFbStatuses to {} format", exportType);
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
    public Page<FeedBack> findAssociatedFeedBacks(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated feedBacks");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("refFbStatuses.id = '" + id + "'");

        return feedBackService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service FeedBackService instance
	 */
	protected void setFeedBackService(FeedBackService service) {
        this.feedBackService = service;
    }

}

