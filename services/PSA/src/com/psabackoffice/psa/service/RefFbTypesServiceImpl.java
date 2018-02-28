/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
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
import com.psabackoffice.psa.RefFbSubTypes;
import com.psabackoffice.psa.RefFbTypes;


/**
 * ServiceImpl object for domain model class RefFbTypes.
 *
 * @see RefFbTypes
 */
@Service("PSA.RefFbTypesService")
@Validated
public class RefFbTypesServiceImpl implements RefFbTypesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefFbTypesServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("PSA.FeedBackService")
	private FeedBackService feedBackService;

    @Lazy
    @Autowired
	@Qualifier("PSA.RefFbSubTypesService")
	private RefFbSubTypesService refFbSubTypesService;

    @Autowired
    @Qualifier("PSA.RefFbTypesDao")
    private WMGenericDao<RefFbTypes, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefFbTypes, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefFbTypes create(RefFbTypes refFbTypes) {
        LOGGER.debug("Creating a new RefFbTypes with information: {}", refFbTypes);

        RefFbTypes refFbTypesCreated = this.wmGenericDao.create(refFbTypes);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refFbTypesCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefFbTypes getById(Integer reffbtypesId) throws EntityNotFoundException {
        LOGGER.debug("Finding RefFbTypes by id: {}", reffbtypesId);
        return this.wmGenericDao.findById(reffbtypesId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefFbTypes findById(Integer reffbtypesId) {
        LOGGER.debug("Finding RefFbTypes by id: {}", reffbtypesId);
        try {
            return this.wmGenericDao.findById(reffbtypesId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No RefFbTypes found with id: {}", reffbtypesId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefFbTypes update(RefFbTypes refFbTypes) throws EntityNotFoundException {
        LOGGER.debug("Updating RefFbTypes with information: {}", refFbTypes);

        List<FeedBack> feedBacks = refFbTypes.getFeedBacks();
        List<RefFbSubTypes> refFbSubTypeses = refFbTypes.getRefFbSubTypeses();

        if(feedBacks != null && Hibernate.isInitialized(feedBacks)) {
            if(!feedBacks.isEmpty()) {
                for(FeedBack _feedBack : feedBacks) {
                    _feedBack.setRefFbTypes(refFbTypes);
                }
            }
        }

        if(refFbSubTypeses != null && Hibernate.isInitialized(refFbSubTypeses)) {
            if(!refFbSubTypeses.isEmpty()) {
                for(RefFbSubTypes _refFbSubTypes : refFbSubTypeses) {
                    _refFbSubTypes.setRefFbTypes(refFbTypes);
                }
            }
        }

        this.wmGenericDao.update(refFbTypes);
        this.wmGenericDao.refresh(refFbTypes);

        return refFbTypes;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefFbTypes delete(Integer reffbtypesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefFbTypes with id: {}", reffbtypesId);
        RefFbTypes deleted = this.wmGenericDao.findById(reffbtypesId);
        if (deleted == null) {
            LOGGER.debug("No RefFbTypes found with id: {}", reffbtypesId);
            throw new EntityNotFoundException(String.valueOf(reffbtypesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(RefFbTypes refFbTypes) {
        LOGGER.debug("Deleting RefFbTypes with {}", refFbTypes);
        this.wmGenericDao.delete(refFbTypes);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefFbTypes> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefFbTypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefFbTypes> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefFbTypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefFbTypes to {} format", exportType);
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
        queryBuilder.append("refFbTypes.id = '" + id + "'");

        return feedBackService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefFbSubTypes> findAssociatedRefFbSubTypeses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated refFbSubTypeses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("refFbTypes.id = '" + id + "'");

        return refFbSubTypesService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service FeedBackService instance
	 */
	protected void setFeedBackService(FeedBackService service) {
        this.feedBackService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefFbSubTypesService instance
	 */
	protected void setRefFbSubTypesService(RefFbSubTypesService service) {
        this.refFbSubTypesService = service;
    }

}

