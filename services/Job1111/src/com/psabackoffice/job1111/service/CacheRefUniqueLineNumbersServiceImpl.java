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

import com.psabackoffice.job1111.CacheRefUniqueLineNumbers;


/**
 * ServiceImpl object for domain model class CacheRefUniqueLineNumbers.
 *
 * @see CacheRefUniqueLineNumbers
 */
@Service("Job1111.CacheRefUniqueLineNumbersService")
public class CacheRefUniqueLineNumbersServiceImpl implements CacheRefUniqueLineNumbersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheRefUniqueLineNumbersServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.CacheRefUniqueLineNumbersDao")
    private WMGenericDao<CacheRefUniqueLineNumbers, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CacheRefUniqueLineNumbers, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public CacheRefUniqueLineNumbers create(CacheRefUniqueLineNumbers cacheRefUniqueLineNumbers) {
        LOGGER.debug("Creating a new CacheRefUniqueLineNumbers with information: {}", cacheRefUniqueLineNumbers);
        CacheRefUniqueLineNumbers cacheRefUniqueLineNumbersCreated = this.wmGenericDao.create(cacheRefUniqueLineNumbers);
        return cacheRefUniqueLineNumbersCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CacheRefUniqueLineNumbers getById(Integer cacherefuniquelinenumbersId) throws EntityNotFoundException {
        LOGGER.debug("Finding CacheRefUniqueLineNumbers by id: {}", cacherefuniquelinenumbersId);
        CacheRefUniqueLineNumbers cacheRefUniqueLineNumbers = this.wmGenericDao.findById(cacherefuniquelinenumbersId);
        if (cacheRefUniqueLineNumbers == null){
            LOGGER.debug("No CacheRefUniqueLineNumbers found with id: {}", cacherefuniquelinenumbersId);
            throw new EntityNotFoundException(String.valueOf(cacherefuniquelinenumbersId));
        }
        return cacheRefUniqueLineNumbers;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CacheRefUniqueLineNumbers findById(Integer cacherefuniquelinenumbersId) {
        LOGGER.debug("Finding CacheRefUniqueLineNumbers by id: {}", cacherefuniquelinenumbersId);
        return this.wmGenericDao.findById(cacherefuniquelinenumbersId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public CacheRefUniqueLineNumbers update(CacheRefUniqueLineNumbers cacheRefUniqueLineNumbers) throws EntityNotFoundException {
        LOGGER.debug("Updating CacheRefUniqueLineNumbers with information: {}", cacheRefUniqueLineNumbers);
        this.wmGenericDao.update(cacheRefUniqueLineNumbers);

        Integer cacherefuniquelinenumbersId = cacheRefUniqueLineNumbers.getId();

        return this.wmGenericDao.findById(cacherefuniquelinenumbersId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public CacheRefUniqueLineNumbers delete(Integer cacherefuniquelinenumbersId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CacheRefUniqueLineNumbers with id: {}", cacherefuniquelinenumbersId);
        CacheRefUniqueLineNumbers deleted = this.wmGenericDao.findById(cacherefuniquelinenumbersId);
        if (deleted == null) {
            LOGGER.debug("No CacheRefUniqueLineNumbers found with id: {}", cacherefuniquelinenumbersId);
            throw new EntityNotFoundException(String.valueOf(cacherefuniquelinenumbersId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<CacheRefUniqueLineNumbers> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CacheRefUniqueLineNumbers");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<CacheRefUniqueLineNumbers> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CacheRefUniqueLineNumbers");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table CacheRefUniqueLineNumbers to {} format", exportType);
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

