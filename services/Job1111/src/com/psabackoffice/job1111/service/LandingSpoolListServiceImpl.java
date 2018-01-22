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

import com.psabackoffice.job1111.LandingSpoolList;


/**
 * ServiceImpl object for domain model class LandingSpoolList.
 *
 * @see LandingSpoolList
 */
@Service("Job1111.LandingSpoolListService")
@Validated
public class LandingSpoolListServiceImpl implements LandingSpoolListService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LandingSpoolListServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.LandingSpoolListDao")
    private WMGenericDao<LandingSpoolList, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<LandingSpoolList, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public LandingSpoolList create(LandingSpoolList landingSpoolList) {
        LOGGER.debug("Creating a new LandingSpoolList with information: {}", landingSpoolList);

        LandingSpoolList landingSpoolListCreated = this.wmGenericDao.create(landingSpoolList);
        return landingSpoolListCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public LandingSpoolList getById(String landingspoollistId) throws EntityNotFoundException {
        LOGGER.debug("Finding LandingSpoolList by id: {}", landingspoollistId);
        LandingSpoolList landingSpoolList = this.wmGenericDao.findById(landingspoollistId);
        if (landingSpoolList == null){
            LOGGER.debug("No LandingSpoolList found with id: {}", landingspoollistId);
            throw new EntityNotFoundException(String.valueOf(landingspoollistId));
        }
        return landingSpoolList;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public LandingSpoolList findById(String landingspoollistId) {
        LOGGER.debug("Finding LandingSpoolList by id: {}", landingspoollistId);
        return this.wmGenericDao.findById(landingspoollistId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public LandingSpoolList update(LandingSpoolList landingSpoolList) throws EntityNotFoundException {
        LOGGER.debug("Updating LandingSpoolList with information: {}", landingSpoolList);
        this.wmGenericDao.update(landingSpoolList);

        String landingspoollistId = landingSpoolList.getSpoolNumber();

        return this.wmGenericDao.findById(landingspoollistId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public LandingSpoolList delete(String landingspoollistId) throws EntityNotFoundException {
        LOGGER.debug("Deleting LandingSpoolList with id: {}", landingspoollistId);
        LandingSpoolList deleted = this.wmGenericDao.findById(landingspoollistId);
        if (deleted == null) {
            LOGGER.debug("No LandingSpoolList found with id: {}", landingspoollistId);
            throw new EntityNotFoundException(String.valueOf(landingspoollistId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<LandingSpoolList> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all LandingSpoolLists");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<LandingSpoolList> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all LandingSpoolLists");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table LandingSpoolList to {} format", exportType);
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

