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

import com.psabackoffice.job1111.PipeSupports;


/**
 * ServiceImpl object for domain model class PipeSupports.
 *
 * @see PipeSupports
 */
@Service("Job1111.PipeSupportsService")
@Validated
public class PipeSupportsServiceImpl implements PipeSupportsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PipeSupportsServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.PipeSupportsDao")
    private WMGenericDao<PipeSupports, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PipeSupports, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public PipeSupports create(PipeSupports pipeSupports) {
        LOGGER.debug("Creating a new PipeSupports with information: {}", pipeSupports);

        PipeSupports pipeSupportsCreated = this.wmGenericDao.create(pipeSupports);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(pipeSupportsCreated);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public PipeSupports getById(Integer pipesupportsId) throws EntityNotFoundException {
        LOGGER.debug("Finding PipeSupports by id: {}", pipesupportsId);
        return this.wmGenericDao.findById(pipesupportsId);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public PipeSupports findById(Integer pipesupportsId) {
        LOGGER.debug("Finding PipeSupports by id: {}", pipesupportsId);
        try {
            return this.wmGenericDao.findById(pipesupportsId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No PipeSupports found with id: {}", pipesupportsId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public PipeSupports update(PipeSupports pipeSupports) throws EntityNotFoundException {
        LOGGER.debug("Updating PipeSupports with information: {}", pipeSupports);

        this.wmGenericDao.update(pipeSupports);
        this.wmGenericDao.refresh(pipeSupports);

        return pipeSupports;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public PipeSupports delete(Integer pipesupportsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PipeSupports with id: {}", pipesupportsId);
        PipeSupports deleted = this.wmGenericDao.findById(pipesupportsId);
        if (deleted == null) {
            LOGGER.debug("No PipeSupports found with id: {}", pipesupportsId);
            throw new EntityNotFoundException(String.valueOf(pipesupportsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public void delete(PipeSupports pipeSupports) {
        LOGGER.debug("Deleting PipeSupports with {}", pipeSupports);
        this.wmGenericDao.delete(pipeSupports);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<PipeSupports> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PipeSupports");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<PipeSupports> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PipeSupports");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table PipeSupports to {} format", exportType);
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

