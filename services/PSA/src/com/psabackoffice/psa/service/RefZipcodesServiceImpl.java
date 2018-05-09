/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.service;

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

import com.psabackoffice.psa.RefZipcodes;


/**
 * ServiceImpl object for domain model class RefZipcodes.
 *
 * @see RefZipcodes
 */
@Service("PSA.RefZipcodesService")
@Validated
public class RefZipcodesServiceImpl implements RefZipcodesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefZipcodesServiceImpl.class);


    @Autowired
    @Qualifier("PSA.RefZipcodesDao")
    private WMGenericDao<RefZipcodes, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefZipcodes, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefZipcodes create(RefZipcodes refZipcodes) {
        LOGGER.debug("Creating a new RefZipcodes with information: {}", refZipcodes);

        RefZipcodes refZipcodesCreated = this.wmGenericDao.create(refZipcodes);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refZipcodesCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefZipcodes getById(Integer refzipcodesId) {
        LOGGER.debug("Finding RefZipcodes by id: {}", refzipcodesId);
        return this.wmGenericDao.findById(refzipcodesId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefZipcodes findById(Integer refzipcodesId) {
        LOGGER.debug("Finding RefZipcodes by id: {}", refzipcodesId);
        try {
            return this.wmGenericDao.findById(refzipcodesId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No RefZipcodes found with id: {}", refzipcodesId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefZipcodes update(RefZipcodes refZipcodes) {
        LOGGER.debug("Updating RefZipcodes with information: {}", refZipcodes);

        this.wmGenericDao.update(refZipcodes);
        this.wmGenericDao.refresh(refZipcodes);

        return refZipcodes;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefZipcodes delete(Integer refzipcodesId) {
        LOGGER.debug("Deleting RefZipcodes with id: {}", refzipcodesId);
        RefZipcodes deleted = this.wmGenericDao.findById(refzipcodesId);
        if (deleted == null) {
            LOGGER.debug("No RefZipcodes found with id: {}", refzipcodesId);
            throw new EntityNotFoundException(String.valueOf(refzipcodesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(RefZipcodes refZipcodes) {
        LOGGER.debug("Deleting RefZipcodes with {}", refZipcodes);
        this.wmGenericDao.delete(refZipcodes);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefZipcodes> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefZipcodes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefZipcodes> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefZipcodes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefZipcodes to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

