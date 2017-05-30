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

import com.psabackoffice.job1111.CacheStatsCivilStats;


/**
 * ServiceImpl object for domain model class CacheStatsCivilStats.
 *
 * @see CacheStatsCivilStats
 */
@Service("Job1111.CacheStatsCivilStatsService")
public class CacheStatsCivilStatsServiceImpl implements CacheStatsCivilStatsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheStatsCivilStatsServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.CacheStatsCivilStatsDao")
    private WMGenericDao<CacheStatsCivilStats, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CacheStatsCivilStats, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public CacheStatsCivilStats create(CacheStatsCivilStats cacheStatsCivilStats) {
        LOGGER.debug("Creating a new CacheStatsCivilStats with information: {}", cacheStatsCivilStats);
        CacheStatsCivilStats cacheStatsCivilStatsCreated = this.wmGenericDao.create(cacheStatsCivilStats);
        return cacheStatsCivilStatsCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CacheStatsCivilStats getById(Integer cachestatscivilstatsId) throws EntityNotFoundException {
        LOGGER.debug("Finding CacheStatsCivilStats by id: {}", cachestatscivilstatsId);
        CacheStatsCivilStats cacheStatsCivilStats = this.wmGenericDao.findById(cachestatscivilstatsId);
        if (cacheStatsCivilStats == null){
            LOGGER.debug("No CacheStatsCivilStats found with id: {}", cachestatscivilstatsId);
            throw new EntityNotFoundException(String.valueOf(cachestatscivilstatsId));
        }
        return cacheStatsCivilStats;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CacheStatsCivilStats findById(Integer cachestatscivilstatsId) {
        LOGGER.debug("Finding CacheStatsCivilStats by id: {}", cachestatscivilstatsId);
        return this.wmGenericDao.findById(cachestatscivilstatsId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public CacheStatsCivilStats update(CacheStatsCivilStats cacheStatsCivilStats) throws EntityNotFoundException {
        LOGGER.debug("Updating CacheStatsCivilStats with information: {}", cacheStatsCivilStats);
        this.wmGenericDao.update(cacheStatsCivilStats);

        Integer cachestatscivilstatsId = cacheStatsCivilStats.getBidId();

        return this.wmGenericDao.findById(cachestatscivilstatsId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public CacheStatsCivilStats delete(Integer cachestatscivilstatsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CacheStatsCivilStats with id: {}", cachestatscivilstatsId);
        CacheStatsCivilStats deleted = this.wmGenericDao.findById(cachestatscivilstatsId);
        if (deleted == null) {
            LOGGER.debug("No CacheStatsCivilStats found with id: {}", cachestatscivilstatsId);
            throw new EntityNotFoundException(String.valueOf(cachestatscivilstatsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<CacheStatsCivilStats> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CacheStatsCivilStats");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<CacheStatsCivilStats> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CacheStatsCivilStats");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table CacheStatsCivilStats to {} format", exportType);
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

