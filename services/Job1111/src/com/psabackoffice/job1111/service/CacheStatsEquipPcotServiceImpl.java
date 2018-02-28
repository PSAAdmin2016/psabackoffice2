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

import com.psabackoffice.job1111.CacheStatsEquipPcot;


/**
 * ServiceImpl object for domain model class CacheStatsEquipPcot.
 *
 * @see CacheStatsEquipPcot
 */
@Service("Job1111.CacheStatsEquipPcotService")
@Validated
public class CacheStatsEquipPcotServiceImpl implements CacheStatsEquipPcotService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheStatsEquipPcotServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.CacheStatsEquipPcotDao")
    private WMGenericDao<CacheStatsEquipPcot, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CacheStatsEquipPcot, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public CacheStatsEquipPcot create(CacheStatsEquipPcot cacheStatsEquipPcot) {
        LOGGER.debug("Creating a new CacheStatsEquipPcot with information: {}", cacheStatsEquipPcot);

        CacheStatsEquipPcot cacheStatsEquipPcotCreated = this.wmGenericDao.create(cacheStatsEquipPcot);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(cacheStatsEquipPcotCreated);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CacheStatsEquipPcot getById(Integer cachestatsequippcotId) throws EntityNotFoundException {
        LOGGER.debug("Finding CacheStatsEquipPcot by id: {}", cachestatsequippcotId);
        return this.wmGenericDao.findById(cachestatsequippcotId);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CacheStatsEquipPcot findById(Integer cachestatsequippcotId) {
        LOGGER.debug("Finding CacheStatsEquipPcot by id: {}", cachestatsequippcotId);
        try {
            return this.wmGenericDao.findById(cachestatsequippcotId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No CacheStatsEquipPcot found with id: {}", cachestatsequippcotId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public CacheStatsEquipPcot update(CacheStatsEquipPcot cacheStatsEquipPcot) throws EntityNotFoundException {
        LOGGER.debug("Updating CacheStatsEquipPcot with information: {}", cacheStatsEquipPcot);

        this.wmGenericDao.update(cacheStatsEquipPcot);
        this.wmGenericDao.refresh(cacheStatsEquipPcot);

        return cacheStatsEquipPcot;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public CacheStatsEquipPcot delete(Integer cachestatsequippcotId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CacheStatsEquipPcot with id: {}", cachestatsequippcotId);
        CacheStatsEquipPcot deleted = this.wmGenericDao.findById(cachestatsequippcotId);
        if (deleted == null) {
            LOGGER.debug("No CacheStatsEquipPcot found with id: {}", cachestatsequippcotId);
            throw new EntityNotFoundException(String.valueOf(cachestatsequippcotId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public void delete(CacheStatsEquipPcot cacheStatsEquipPcot) {
        LOGGER.debug("Deleting CacheStatsEquipPcot with {}", cacheStatsEquipPcot);
        this.wmGenericDao.delete(cacheStatsEquipPcot);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<CacheStatsEquipPcot> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CacheStatsEquipPcots");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<CacheStatsEquipPcot> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CacheStatsEquipPcots");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table CacheStatsEquipPcot to {} format", exportType);
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

