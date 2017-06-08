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

import com.psabackoffice.job1111.SteelErect;


/**
 * ServiceImpl object for domain model class SteelErect.
 *
 * @see SteelErect
 */
@Service("Job1111.SteelErectService")
public class SteelErectServiceImpl implements SteelErectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelErectServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.SteelErectDao")
    private WMGenericDao<SteelErect, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SteelErect, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SteelErect create(SteelErect steelErect) {
        LOGGER.debug("Creating a new SteelErect with information: {}", steelErect);
        SteelErect steelErectCreated = this.wmGenericDao.create(steelErect);
        return steelErectCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelErect getById(Integer steelerectId) throws EntityNotFoundException {
        LOGGER.debug("Finding SteelErect by id: {}", steelerectId);
        SteelErect steelErect = this.wmGenericDao.findById(steelerectId);
        if (steelErect == null){
            LOGGER.debug("No SteelErect found with id: {}", steelerectId);
            throw new EntityNotFoundException(String.valueOf(steelerectId));
        }
        return steelErect;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelErect findById(Integer steelerectId) {
        LOGGER.debug("Finding SteelErect by id: {}", steelerectId);
        return this.wmGenericDao.findById(steelerectId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SteelErect update(SteelErect steelErect) throws EntityNotFoundException {
        LOGGER.debug("Updating SteelErect with information: {}", steelErect);
        this.wmGenericDao.update(steelErect);

        Integer steelerectId = steelErect.getActivityId();

        return this.wmGenericDao.findById(steelerectId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SteelErect delete(Integer steelerectId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelErect with id: {}", steelerectId);
        SteelErect deleted = this.wmGenericDao.findById(steelerectId);
        if (deleted == null) {
            LOGGER.debug("No SteelErect found with id: {}", steelerectId);
            throw new EntityNotFoundException(String.valueOf(steelerectId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SteelErect> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SteelErects");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SteelErect> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SteelErects");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SteelErect to {} format", exportType);
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

