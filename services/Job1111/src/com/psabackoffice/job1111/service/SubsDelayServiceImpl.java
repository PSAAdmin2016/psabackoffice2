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

import com.psabackoffice.job1111.SubsDelay;


/**
 * ServiceImpl object for domain model class SubsDelay.
 *
 * @see SubsDelay
 */
@Service("Job1111.SubsDelayService")
public class SubsDelayServiceImpl implements SubsDelayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubsDelayServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.SubsDelayDao")
    private WMGenericDao<SubsDelay, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SubsDelay, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SubsDelay create(SubsDelay subsDelay) {
        LOGGER.debug("Creating a new SubsDelay with information: {}", subsDelay);
        SubsDelay subsDelayCreated = this.wmGenericDao.create(subsDelay);
        return subsDelayCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubsDelay getById(Integer subsdelayId) throws EntityNotFoundException {
        LOGGER.debug("Finding SubsDelay by id: {}", subsdelayId);
        SubsDelay subsDelay = this.wmGenericDao.findById(subsdelayId);
        if (subsDelay == null){
            LOGGER.debug("No SubsDelay found with id: {}", subsdelayId);
            throw new EntityNotFoundException(String.valueOf(subsdelayId));
        }
        return subsDelay;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubsDelay findById(Integer subsdelayId) {
        LOGGER.debug("Finding SubsDelay by id: {}", subsdelayId);
        return this.wmGenericDao.findById(subsdelayId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SubsDelay update(SubsDelay subsDelay) throws EntityNotFoundException {
        LOGGER.debug("Updating SubsDelay with information: {}", subsDelay);
        this.wmGenericDao.update(subsDelay);

        Integer subsdelayId = subsDelay.getId();

        return this.wmGenericDao.findById(subsdelayId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SubsDelay delete(Integer subsdelayId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SubsDelay with id: {}", subsdelayId);
        SubsDelay deleted = this.wmGenericDao.findById(subsdelayId);
        if (deleted == null) {
            LOGGER.debug("No SubsDelay found with id: {}", subsdelayId);
            throw new EntityNotFoundException(String.valueOf(subsdelayId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SubsDelay> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SubsDelays");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SubsDelay> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SubsDelays");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SubsDelay to {} format", exportType);
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

