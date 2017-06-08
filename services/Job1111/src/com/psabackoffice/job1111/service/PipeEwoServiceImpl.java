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

import com.psabackoffice.job1111.PipeEwo;


/**
 * ServiceImpl object for domain model class PipeEwo.
 *
 * @see PipeEwo
 */
@Service("Job1111.PipeEwoService")
public class PipeEwoServiceImpl implements PipeEwoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PipeEwoServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.PipeEwoDao")
    private WMGenericDao<PipeEwo, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PipeEwo, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public PipeEwo create(PipeEwo pipeEwo) {
        LOGGER.debug("Creating a new PipeEwo with information: {}", pipeEwo);
        PipeEwo pipeEwoCreated = this.wmGenericDao.create(pipeEwo);
        return pipeEwoCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public PipeEwo getById(Integer pipeewoId) throws EntityNotFoundException {
        LOGGER.debug("Finding PipeEwo by id: {}", pipeewoId);
        PipeEwo pipeEwo = this.wmGenericDao.findById(pipeewoId);
        if (pipeEwo == null){
            LOGGER.debug("No PipeEwo found with id: {}", pipeewoId);
            throw new EntityNotFoundException(String.valueOf(pipeewoId));
        }
        return pipeEwo;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public PipeEwo findById(Integer pipeewoId) {
        LOGGER.debug("Finding PipeEwo by id: {}", pipeewoId);
        return this.wmGenericDao.findById(pipeewoId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public PipeEwo update(PipeEwo pipeEwo) throws EntityNotFoundException {
        LOGGER.debug("Updating PipeEwo with information: {}", pipeEwo);
        this.wmGenericDao.update(pipeEwo);

        Integer pipeewoId = pipeEwo.getActivityId();

        return this.wmGenericDao.findById(pipeewoId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public PipeEwo delete(Integer pipeewoId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PipeEwo with id: {}", pipeewoId);
        PipeEwo deleted = this.wmGenericDao.findById(pipeewoId);
        if (deleted == null) {
            LOGGER.debug("No PipeEwo found with id: {}", pipeewoId);
            throw new EntityNotFoundException(String.valueOf(pipeewoId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<PipeEwo> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PipeEwos");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<PipeEwo> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PipeEwos");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table PipeEwo to {} format", exportType);
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

