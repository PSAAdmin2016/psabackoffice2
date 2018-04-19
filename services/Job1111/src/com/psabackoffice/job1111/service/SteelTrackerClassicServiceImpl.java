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

import com.psabackoffice.job1111.SteelTrackerClassic;


/**
 * ServiceImpl object for domain model class SteelTrackerClassic.
 *
 * @see SteelTrackerClassic
 */
@Service("Job1111.SteelTrackerClassicService")
@Validated
public class SteelTrackerClassicServiceImpl implements SteelTrackerClassicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelTrackerClassicServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.SteelTrackerClassicDao")
    private WMGenericDao<SteelTrackerClassic, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SteelTrackerClassic, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SteelTrackerClassic create(SteelTrackerClassic steelTrackerClassic) {
        LOGGER.debug("Creating a new SteelTrackerClassic with information: {}", steelTrackerClassic);

        SteelTrackerClassic steelTrackerClassicCreated = this.wmGenericDao.create(steelTrackerClassic);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(steelTrackerClassicCreated);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelTrackerClassic getById(Integer steeltrackerclassicId) {
        LOGGER.debug("Finding SteelTrackerClassic by id: {}", steeltrackerclassicId);
        return this.wmGenericDao.findById(steeltrackerclassicId);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelTrackerClassic findById(Integer steeltrackerclassicId) {
        LOGGER.debug("Finding SteelTrackerClassic by id: {}", steeltrackerclassicId);
        try {
            return this.wmGenericDao.findById(steeltrackerclassicId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No SteelTrackerClassic found with id: {}", steeltrackerclassicId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SteelTrackerClassic update(SteelTrackerClassic steelTrackerClassic) {
        LOGGER.debug("Updating SteelTrackerClassic with information: {}", steelTrackerClassic);

        this.wmGenericDao.update(steelTrackerClassic);
        this.wmGenericDao.refresh(steelTrackerClassic);

        return steelTrackerClassic;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SteelTrackerClassic delete(Integer steeltrackerclassicId) {
        LOGGER.debug("Deleting SteelTrackerClassic with id: {}", steeltrackerclassicId);
        SteelTrackerClassic deleted = this.wmGenericDao.findById(steeltrackerclassicId);
        if (deleted == null) {
            LOGGER.debug("No SteelTrackerClassic found with id: {}", steeltrackerclassicId);
            throw new EntityNotFoundException(String.valueOf(steeltrackerclassicId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public void delete(SteelTrackerClassic steelTrackerClassic) {
        LOGGER.debug("Deleting SteelTrackerClassic with {}", steelTrackerClassic);
        this.wmGenericDao.delete(steelTrackerClassic);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SteelTrackerClassic> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SteelTrackerClassics");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SteelTrackerClassic> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SteelTrackerClassics");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SteelTrackerClassic to {} format", exportType);
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

