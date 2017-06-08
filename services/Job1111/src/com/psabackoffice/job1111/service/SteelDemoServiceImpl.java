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

import com.psabackoffice.job1111.SteelDemo;


/**
 * ServiceImpl object for domain model class SteelDemo.
 *
 * @see SteelDemo
 */
@Service("Job1111.SteelDemoService")
public class SteelDemoServiceImpl implements SteelDemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelDemoServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.SteelDemoDao")
    private WMGenericDao<SteelDemo, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SteelDemo, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SteelDemo create(SteelDemo steelDemo) {
        LOGGER.debug("Creating a new SteelDemo with information: {}", steelDemo);
        SteelDemo steelDemoCreated = this.wmGenericDao.create(steelDemo);
        return steelDemoCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelDemo getById(Integer steeldemoId) throws EntityNotFoundException {
        LOGGER.debug("Finding SteelDemo by id: {}", steeldemoId);
        SteelDemo steelDemo = this.wmGenericDao.findById(steeldemoId);
        if (steelDemo == null){
            LOGGER.debug("No SteelDemo found with id: {}", steeldemoId);
            throw new EntityNotFoundException(String.valueOf(steeldemoId));
        }
        return steelDemo;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelDemo findById(Integer steeldemoId) {
        LOGGER.debug("Finding SteelDemo by id: {}", steeldemoId);
        return this.wmGenericDao.findById(steeldemoId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SteelDemo update(SteelDemo steelDemo) throws EntityNotFoundException {
        LOGGER.debug("Updating SteelDemo with information: {}", steelDemo);
        this.wmGenericDao.update(steelDemo);

        Integer steeldemoId = steelDemo.getActivityId();

        return this.wmGenericDao.findById(steeldemoId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SteelDemo delete(Integer steeldemoId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelDemo with id: {}", steeldemoId);
        SteelDemo deleted = this.wmGenericDao.findById(steeldemoId);
        if (deleted == null) {
            LOGGER.debug("No SteelDemo found with id: {}", steeldemoId);
            throw new EntityNotFoundException(String.valueOf(steeldemoId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SteelDemo> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SteelDemos");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SteelDemo> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SteelDemos");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SteelDemo to {} format", exportType);
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

