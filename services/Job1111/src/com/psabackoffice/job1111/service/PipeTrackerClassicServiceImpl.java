/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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

import com.psabackoffice.job1111.PipeTrackerClassic;


/**
 * ServiceImpl object for domain model class PipeTrackerClassic.
 *
 * @see PipeTrackerClassic
 */
@Service("Job1111.PipeTrackerClassicService")
@Validated
public class PipeTrackerClassicServiceImpl implements PipeTrackerClassicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PipeTrackerClassicServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.PipeTrackerClassicDao")
    private WMGenericDao<PipeTrackerClassic, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PipeTrackerClassic, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public PipeTrackerClassic create(PipeTrackerClassic pipeTrackerClassic) {
        LOGGER.debug("Creating a new PipeTrackerClassic with information: {}", pipeTrackerClassic);

        PipeTrackerClassic pipeTrackerClassicCreated = this.wmGenericDao.create(pipeTrackerClassic);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(pipeTrackerClassicCreated);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public PipeTrackerClassic getById(Integer pipetrackerclassicId) {
        LOGGER.debug("Finding PipeTrackerClassic by id: {}", pipetrackerclassicId);
        return this.wmGenericDao.findById(pipetrackerclassicId);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public PipeTrackerClassic findById(Integer pipetrackerclassicId) {
        LOGGER.debug("Finding PipeTrackerClassic by id: {}", pipetrackerclassicId);
        try {
            return this.wmGenericDao.findById(pipetrackerclassicId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No PipeTrackerClassic found with id: {}", pipetrackerclassicId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public PipeTrackerClassic update(PipeTrackerClassic pipeTrackerClassic) {
        LOGGER.debug("Updating PipeTrackerClassic with information: {}", pipeTrackerClassic);

        this.wmGenericDao.update(pipeTrackerClassic);
        this.wmGenericDao.refresh(pipeTrackerClassic);

        return pipeTrackerClassic;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public PipeTrackerClassic delete(Integer pipetrackerclassicId) {
        LOGGER.debug("Deleting PipeTrackerClassic with id: {}", pipetrackerclassicId);
        PipeTrackerClassic deleted = this.wmGenericDao.findById(pipetrackerclassicId);
        if (deleted == null) {
            LOGGER.debug("No PipeTrackerClassic found with id: {}", pipetrackerclassicId);
            throw new EntityNotFoundException(String.valueOf(pipetrackerclassicId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public void delete(PipeTrackerClassic pipeTrackerClassic) {
        LOGGER.debug("Deleting PipeTrackerClassic with {}", pipeTrackerClassic);
        this.wmGenericDao.delete(pipeTrackerClassic);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<PipeTrackerClassic> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PipeTrackerClassics");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<PipeTrackerClassic> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PipeTrackerClassics");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table PipeTrackerClassic to {} format", exportType);
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

