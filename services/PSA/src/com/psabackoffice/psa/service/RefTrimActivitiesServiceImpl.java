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

import com.psabackoffice.psa.RefTrimActivities;


/**
 * ServiceImpl object for domain model class RefTrimActivities.
 *
 * @see RefTrimActivities
 */
@Service("PSA.RefTrimActivitiesService")
@Validated
public class RefTrimActivitiesServiceImpl implements RefTrimActivitiesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefTrimActivitiesServiceImpl.class);


    @Autowired
    @Qualifier("PSA.RefTrimActivitiesDao")
    private WMGenericDao<RefTrimActivities, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefTrimActivities, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefTrimActivities create(RefTrimActivities refTrimActivities) {
        LOGGER.debug("Creating a new RefTrimActivities with information: {}", refTrimActivities);

        RefTrimActivities refTrimActivitiesCreated = this.wmGenericDao.create(refTrimActivities);
        return refTrimActivitiesCreated;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefTrimActivities getById(Integer reftrimactivitiesId) throws EntityNotFoundException {
        LOGGER.debug("Finding RefTrimActivities by id: {}", reftrimactivitiesId);
        RefTrimActivities refTrimActivities = this.wmGenericDao.findById(reftrimactivitiesId);
        if (refTrimActivities == null){
            LOGGER.debug("No RefTrimActivities found with id: {}", reftrimactivitiesId);
            throw new EntityNotFoundException(String.valueOf(reftrimactivitiesId));
        }
        return refTrimActivities;
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefTrimActivities findById(Integer reftrimactivitiesId) {
        LOGGER.debug("Finding RefTrimActivities by id: {}", reftrimactivitiesId);
        return this.wmGenericDao.findById(reftrimactivitiesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefTrimActivities update(RefTrimActivities refTrimActivities) throws EntityNotFoundException {
        LOGGER.debug("Updating RefTrimActivities with information: {}", refTrimActivities);
        this.wmGenericDao.update(refTrimActivities);

        Integer reftrimactivitiesId = refTrimActivities.getId();

        return this.wmGenericDao.findById(reftrimactivitiesId);
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefTrimActivities delete(Integer reftrimactivitiesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefTrimActivities with id: {}", reftrimactivitiesId);
        RefTrimActivities deleted = this.wmGenericDao.findById(reftrimactivitiesId);
        if (deleted == null) {
            LOGGER.debug("No RefTrimActivities found with id: {}", reftrimactivitiesId);
            throw new EntityNotFoundException(String.valueOf(reftrimactivitiesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefTrimActivities> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefTrimActivities");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefTrimActivities> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefTrimActivities");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefTrimActivities to {} format", exportType);
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

