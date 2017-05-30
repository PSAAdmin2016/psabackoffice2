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

import com.psabackoffice.job1111.PipeBoltUp;


/**
 * ServiceImpl object for domain model class PipeBoltUp.
 *
 * @see PipeBoltUp
 */
@Service("Job1111.PipeBoltUpService")
public class PipeBoltUpServiceImpl implements PipeBoltUpService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PipeBoltUpServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.PipeBoltUpDao")
    private WMGenericDao<PipeBoltUp, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PipeBoltUp, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public PipeBoltUp create(PipeBoltUp pipeBoltUp) {
        LOGGER.debug("Creating a new PipeBoltUp with information: {}", pipeBoltUp);
        PipeBoltUp pipeBoltUpCreated = this.wmGenericDao.create(pipeBoltUp);
        return pipeBoltUpCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public PipeBoltUp getById(Integer pipeboltupId) throws EntityNotFoundException {
        LOGGER.debug("Finding PipeBoltUp by id: {}", pipeboltupId);
        PipeBoltUp pipeBoltUp = this.wmGenericDao.findById(pipeboltupId);
        if (pipeBoltUp == null){
            LOGGER.debug("No PipeBoltUp found with id: {}", pipeboltupId);
            throw new EntityNotFoundException(String.valueOf(pipeboltupId));
        }
        return pipeBoltUp;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public PipeBoltUp findById(Integer pipeboltupId) {
        LOGGER.debug("Finding PipeBoltUp by id: {}", pipeboltupId);
        return this.wmGenericDao.findById(pipeboltupId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public PipeBoltUp update(PipeBoltUp pipeBoltUp) throws EntityNotFoundException {
        LOGGER.debug("Updating PipeBoltUp with information: {}", pipeBoltUp);
        this.wmGenericDao.update(pipeBoltUp);

        Integer pipeboltupId = pipeBoltUp.getId();

        return this.wmGenericDao.findById(pipeboltupId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public PipeBoltUp delete(Integer pipeboltupId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PipeBoltUp with id: {}", pipeboltupId);
        PipeBoltUp deleted = this.wmGenericDao.findById(pipeboltupId);
        if (deleted == null) {
            LOGGER.debug("No PipeBoltUp found with id: {}", pipeboltupId);
            throw new EntityNotFoundException(String.valueOf(pipeboltupId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<PipeBoltUp> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PipeBoltUps");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<PipeBoltUp> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PipeBoltUps");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table PipeBoltUp to {} format", exportType);
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
