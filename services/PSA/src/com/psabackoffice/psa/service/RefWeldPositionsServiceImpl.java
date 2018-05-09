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

import com.psabackoffice.psa.RefWeldPositions;


/**
 * ServiceImpl object for domain model class RefWeldPositions.
 *
 * @see RefWeldPositions
 */
@Service("PSA.RefWeldPositionsService")
@Validated
public class RefWeldPositionsServiceImpl implements RefWeldPositionsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefWeldPositionsServiceImpl.class);


    @Autowired
    @Qualifier("PSA.RefWeldPositionsDao")
    private WMGenericDao<RefWeldPositions, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefWeldPositions, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefWeldPositions create(RefWeldPositions refWeldPositions) {
        LOGGER.debug("Creating a new RefWeldPositions with information: {}", refWeldPositions);

        RefWeldPositions refWeldPositionsCreated = this.wmGenericDao.create(refWeldPositions);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refWeldPositionsCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefWeldPositions getById(Integer refweldpositionsId) {
        LOGGER.debug("Finding RefWeldPositions by id: {}", refweldpositionsId);
        return this.wmGenericDao.findById(refweldpositionsId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefWeldPositions findById(Integer refweldpositionsId) {
        LOGGER.debug("Finding RefWeldPositions by id: {}", refweldpositionsId);
        try {
            return this.wmGenericDao.findById(refweldpositionsId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No RefWeldPositions found with id: {}", refweldpositionsId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefWeldPositions update(RefWeldPositions refWeldPositions) {
        LOGGER.debug("Updating RefWeldPositions with information: {}", refWeldPositions);

        this.wmGenericDao.update(refWeldPositions);
        this.wmGenericDao.refresh(refWeldPositions);

        return refWeldPositions;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefWeldPositions delete(Integer refweldpositionsId) {
        LOGGER.debug("Deleting RefWeldPositions with id: {}", refweldpositionsId);
        RefWeldPositions deleted = this.wmGenericDao.findById(refweldpositionsId);
        if (deleted == null) {
            LOGGER.debug("No RefWeldPositions found with id: {}", refweldpositionsId);
            throw new EntityNotFoundException(String.valueOf(refweldpositionsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(RefWeldPositions refWeldPositions) {
        LOGGER.debug("Deleting RefWeldPositions with {}", refWeldPositions);
        this.wmGenericDao.delete(refWeldPositions);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefWeldPositions> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefWeldPositions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefWeldPositions> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefWeldPositions");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefWeldPositions to {} format", exportType);
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

