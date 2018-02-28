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

import com.psabackoffice.psa.RefActivityRejections;


/**
 * ServiceImpl object for domain model class RefActivityRejections.
 *
 * @see RefActivityRejections
 */
@Service("PSA.RefActivityRejectionsService")
@Validated
public class RefActivityRejectionsServiceImpl implements RefActivityRejectionsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefActivityRejectionsServiceImpl.class);


    @Autowired
    @Qualifier("PSA.RefActivityRejectionsDao")
    private WMGenericDao<RefActivityRejections, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefActivityRejections, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefActivityRejections create(RefActivityRejections refActivityRejections) {
        LOGGER.debug("Creating a new RefActivityRejections with information: {}", refActivityRejections);

        RefActivityRejections refActivityRejectionsCreated = this.wmGenericDao.create(refActivityRejections);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refActivityRejectionsCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefActivityRejections getById(Integer refactivityrejectionsId) throws EntityNotFoundException {
        LOGGER.debug("Finding RefActivityRejections by id: {}", refactivityrejectionsId);
        return this.wmGenericDao.findById(refactivityrejectionsId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefActivityRejections findById(Integer refactivityrejectionsId) {
        LOGGER.debug("Finding RefActivityRejections by id: {}", refactivityrejectionsId);
        try {
            return this.wmGenericDao.findById(refactivityrejectionsId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No RefActivityRejections found with id: {}", refactivityrejectionsId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefActivityRejections update(RefActivityRejections refActivityRejections) throws EntityNotFoundException {
        LOGGER.debug("Updating RefActivityRejections with information: {}", refActivityRejections);

        this.wmGenericDao.update(refActivityRejections);
        this.wmGenericDao.refresh(refActivityRejections);

        return refActivityRejections;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefActivityRejections delete(Integer refactivityrejectionsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefActivityRejections with id: {}", refactivityrejectionsId);
        RefActivityRejections deleted = this.wmGenericDao.findById(refactivityrejectionsId);
        if (deleted == null) {
            LOGGER.debug("No RefActivityRejections found with id: {}", refactivityrejectionsId);
            throw new EntityNotFoundException(String.valueOf(refactivityrejectionsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(RefActivityRejections refActivityRejections) {
        LOGGER.debug("Deleting RefActivityRejections with {}", refActivityRejections);
        this.wmGenericDao.delete(refActivityRejections);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefActivityRejections> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefActivityRejections");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefActivityRejections> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefActivityRejections");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefActivityRejections to {} format", exportType);
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

