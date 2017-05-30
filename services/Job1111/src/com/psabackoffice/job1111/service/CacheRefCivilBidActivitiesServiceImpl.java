/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.service;

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

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.job1111.CacheRefCivilBidActivities;


/**
 * ServiceImpl object for domain model class CacheRefCivilBidActivities.
 *
 * @see CacheRefCivilBidActivities
 */
@Service("Job1111.CacheRefCivilBidActivitiesService")
public class CacheRefCivilBidActivitiesServiceImpl implements CacheRefCivilBidActivitiesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheRefCivilBidActivitiesServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.CacheRefCivilBidActivitiesDao")
    private WMGenericDao<CacheRefCivilBidActivities, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CacheRefCivilBidActivities, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public CacheRefCivilBidActivities create(CacheRefCivilBidActivities cacheRefCivilBidActivities) {
        LOGGER.debug("Creating a new CacheRefCivilBidActivities with information: {}", cacheRefCivilBidActivities);
        CacheRefCivilBidActivities cacheRefCivilBidActivitiesCreated = this.wmGenericDao.create(cacheRefCivilBidActivities);
        return cacheRefCivilBidActivitiesCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CacheRefCivilBidActivities getById(Integer cacherefcivilbidactivitiesId) throws EntityNotFoundException {
        LOGGER.debug("Finding CacheRefCivilBidActivities by id: {}", cacherefcivilbidactivitiesId);
        CacheRefCivilBidActivities cacheRefCivilBidActivities = this.wmGenericDao.findById(cacherefcivilbidactivitiesId);
        if (cacheRefCivilBidActivities == null){
            LOGGER.debug("No CacheRefCivilBidActivities found with id: {}", cacherefcivilbidactivitiesId);
            throw new EntityNotFoundException(String.valueOf(cacherefcivilbidactivitiesId));
        }
        return cacheRefCivilBidActivities;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CacheRefCivilBidActivities findById(Integer cacherefcivilbidactivitiesId) {
        LOGGER.debug("Finding CacheRefCivilBidActivities by id: {}", cacherefcivilbidactivitiesId);
        return this.wmGenericDao.findById(cacherefcivilbidactivitiesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public CacheRefCivilBidActivities update(CacheRefCivilBidActivities cacheRefCivilBidActivities) throws EntityNotFoundException {
        LOGGER.debug("Updating CacheRefCivilBidActivities with information: {}", cacheRefCivilBidActivities);
        this.wmGenericDao.update(cacheRefCivilBidActivities);

        Integer cacherefcivilbidactivitiesId = cacheRefCivilBidActivities.getId();

        return this.wmGenericDao.findById(cacherefcivilbidactivitiesId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public CacheRefCivilBidActivities delete(Integer cacherefcivilbidactivitiesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CacheRefCivilBidActivities with id: {}", cacherefcivilbidactivitiesId);
        CacheRefCivilBidActivities deleted = this.wmGenericDao.findById(cacherefcivilbidactivitiesId);
        if (deleted == null) {
            LOGGER.debug("No CacheRefCivilBidActivities found with id: {}", cacherefcivilbidactivitiesId);
            throw new EntityNotFoundException(String.valueOf(cacherefcivilbidactivitiesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<CacheRefCivilBidActivities> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CacheRefCivilBidActivities");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<CacheRefCivilBidActivities> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CacheRefCivilBidActivities");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table CacheRefCivilBidActivities to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

