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
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.job1111.LandingTrackerPipe;


/**
 * ServiceImpl object for domain model class LandingTrackerPipe.
 *
 * @see LandingTrackerPipe
 */
@Service("Job1111.LandingTrackerPipeService")
@Validated
public class LandingTrackerPipeServiceImpl implements LandingTrackerPipeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LandingTrackerPipeServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.LandingTrackerPipeDao")
    private WMGenericDao<LandingTrackerPipe, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<LandingTrackerPipe, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public LandingTrackerPipe create(LandingTrackerPipe landingTrackerPipe) {
        LOGGER.debug("Creating a new LandingTrackerPipe with information: {}", landingTrackerPipe);

        LandingTrackerPipe landingTrackerPipeCreated = this.wmGenericDao.create(landingTrackerPipe);
        return landingTrackerPipeCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public LandingTrackerPipe getById(Integer landingtrackerpipeId) throws EntityNotFoundException {
        LOGGER.debug("Finding LandingTrackerPipe by id: {}", landingtrackerpipeId);
        LandingTrackerPipe landingTrackerPipe = this.wmGenericDao.findById(landingtrackerpipeId);
        if (landingTrackerPipe == null){
            LOGGER.debug("No LandingTrackerPipe found with id: {}", landingtrackerpipeId);
            throw new EntityNotFoundException(String.valueOf(landingtrackerpipeId));
        }
        return landingTrackerPipe;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public LandingTrackerPipe findById(Integer landingtrackerpipeId) {
        LOGGER.debug("Finding LandingTrackerPipe by id: {}", landingtrackerpipeId);
        return this.wmGenericDao.findById(landingtrackerpipeId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public LandingTrackerPipe update(LandingTrackerPipe landingTrackerPipe) throws EntityNotFoundException {
        LOGGER.debug("Updating LandingTrackerPipe with information: {}", landingTrackerPipe);
        this.wmGenericDao.update(landingTrackerPipe);

        Integer landingtrackerpipeId = landingTrackerPipe.getId();

        return this.wmGenericDao.findById(landingtrackerpipeId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public LandingTrackerPipe delete(Integer landingtrackerpipeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting LandingTrackerPipe with id: {}", landingtrackerpipeId);
        LandingTrackerPipe deleted = this.wmGenericDao.findById(landingtrackerpipeId);
        if (deleted == null) {
            LOGGER.debug("No LandingTrackerPipe found with id: {}", landingtrackerpipeId);
            throw new EntityNotFoundException(String.valueOf(landingtrackerpipeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<LandingTrackerPipe> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all LandingTrackerPipes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<LandingTrackerPipe> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all LandingTrackerPipes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table LandingTrackerPipe to {} format", exportType);
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

