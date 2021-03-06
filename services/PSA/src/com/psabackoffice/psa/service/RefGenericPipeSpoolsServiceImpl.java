/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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

import com.psabackoffice.psa.RefGenericPipeSpools;


/**
 * ServiceImpl object for domain model class RefGenericPipeSpools.
 *
 * @see RefGenericPipeSpools
 */
@Service("PSA.RefGenericPipeSpoolsService")
@Validated
public class RefGenericPipeSpoolsServiceImpl implements RefGenericPipeSpoolsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefGenericPipeSpoolsServiceImpl.class);


    @Autowired
    @Qualifier("PSA.RefGenericPipeSpoolsDao")
    private WMGenericDao<RefGenericPipeSpools, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefGenericPipeSpools, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefGenericPipeSpools create(RefGenericPipeSpools refGenericPipeSpools) {
        LOGGER.debug("Creating a new RefGenericPipeSpools with information: {}", refGenericPipeSpools);

        RefGenericPipeSpools refGenericPipeSpoolsCreated = this.wmGenericDao.create(refGenericPipeSpools);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refGenericPipeSpoolsCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefGenericPipeSpools getById(Integer refgenericpipespoolsId) {
        LOGGER.debug("Finding RefGenericPipeSpools by id: {}", refgenericpipespoolsId);
        return this.wmGenericDao.findById(refgenericpipespoolsId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefGenericPipeSpools findById(Integer refgenericpipespoolsId) {
        LOGGER.debug("Finding RefGenericPipeSpools by id: {}", refgenericpipespoolsId);
        try {
            return this.wmGenericDao.findById(refgenericpipespoolsId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No RefGenericPipeSpools found with id: {}", refgenericpipespoolsId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefGenericPipeSpools update(RefGenericPipeSpools refGenericPipeSpools) {
        LOGGER.debug("Updating RefGenericPipeSpools with information: {}", refGenericPipeSpools);

        this.wmGenericDao.update(refGenericPipeSpools);
        this.wmGenericDao.refresh(refGenericPipeSpools);

        return refGenericPipeSpools;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefGenericPipeSpools delete(Integer refgenericpipespoolsId) {
        LOGGER.debug("Deleting RefGenericPipeSpools with id: {}", refgenericpipespoolsId);
        RefGenericPipeSpools deleted = this.wmGenericDao.findById(refgenericpipespoolsId);
        if (deleted == null) {
            LOGGER.debug("No RefGenericPipeSpools found with id: {}", refgenericpipespoolsId);
            throw new EntityNotFoundException(String.valueOf(refgenericpipespoolsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(RefGenericPipeSpools refGenericPipeSpools) {
        LOGGER.debug("Deleting RefGenericPipeSpools with {}", refGenericPipeSpools);
        this.wmGenericDao.delete(refGenericPipeSpools);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefGenericPipeSpools> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefGenericPipeSpools");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefGenericPipeSpools> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefGenericPipeSpools");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefGenericPipeSpools to {} format", exportType);
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

