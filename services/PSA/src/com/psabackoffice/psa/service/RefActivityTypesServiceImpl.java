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

import com.psabackoffice.psa.RefActivityTypes;


/**
 * ServiceImpl object for domain model class RefActivityTypes.
 *
 * @see RefActivityTypes
 */
@Service("PSA.RefActivityTypesService")
@Validated
public class RefActivityTypesServiceImpl implements RefActivityTypesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefActivityTypesServiceImpl.class);


    @Autowired
    @Qualifier("PSA.RefActivityTypesDao")
    private WMGenericDao<RefActivityTypes, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefActivityTypes, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefActivityTypes create(RefActivityTypes refActivityTypes) {
        LOGGER.debug("Creating a new RefActivityTypes with information: {}", refActivityTypes);

        RefActivityTypes refActivityTypesCreated = this.wmGenericDao.create(refActivityTypes);
        return refActivityTypesCreated;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefActivityTypes getById(Integer refactivitytypesId) throws EntityNotFoundException {
        LOGGER.debug("Finding RefActivityTypes by id: {}", refactivitytypesId);
        RefActivityTypes refActivityTypes = this.wmGenericDao.findById(refactivitytypesId);
        if (refActivityTypes == null){
            LOGGER.debug("No RefActivityTypes found with id: {}", refactivitytypesId);
            throw new EntityNotFoundException(String.valueOf(refactivitytypesId));
        }
        return refActivityTypes;
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefActivityTypes findById(Integer refactivitytypesId) {
        LOGGER.debug("Finding RefActivityTypes by id: {}", refactivitytypesId);
        return this.wmGenericDao.findById(refactivitytypesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefActivityTypes update(RefActivityTypes refActivityTypes) throws EntityNotFoundException {
        LOGGER.debug("Updating RefActivityTypes with information: {}", refActivityTypes);
        this.wmGenericDao.update(refActivityTypes);

        Integer refactivitytypesId = refActivityTypes.getId();

        return this.wmGenericDao.findById(refactivitytypesId);
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefActivityTypes delete(Integer refactivitytypesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefActivityTypes with id: {}", refactivitytypesId);
        RefActivityTypes deleted = this.wmGenericDao.findById(refactivitytypesId);
        if (deleted == null) {
            LOGGER.debug("No RefActivityTypes found with id: {}", refactivitytypesId);
            throw new EntityNotFoundException(String.valueOf(refactivitytypesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefActivityTypes> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefActivityTypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefActivityTypes> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefActivityTypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefActivityTypes to {} format", exportType);
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

