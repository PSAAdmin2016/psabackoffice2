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

import com.psabackoffice.psa.RefSteelTypes;


/**
 * ServiceImpl object for domain model class RefSteelTypes.
 *
 * @see RefSteelTypes
 */
@Service("PSA.RefSteelTypesService")
@Validated
public class RefSteelTypesServiceImpl implements RefSteelTypesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefSteelTypesServiceImpl.class);


    @Autowired
    @Qualifier("PSA.RefSteelTypesDao")
    private WMGenericDao<RefSteelTypes, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefSteelTypes, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefSteelTypes create(RefSteelTypes refSteelTypes) {
        LOGGER.debug("Creating a new RefSteelTypes with information: {}", refSteelTypes);

        RefSteelTypes refSteelTypesCreated = this.wmGenericDao.create(refSteelTypes);
        return refSteelTypesCreated;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefSteelTypes getById(Integer refsteeltypesId) throws EntityNotFoundException {
        LOGGER.debug("Finding RefSteelTypes by id: {}", refsteeltypesId);
        RefSteelTypes refSteelTypes = this.wmGenericDao.findById(refsteeltypesId);
        if (refSteelTypes == null){
            LOGGER.debug("No RefSteelTypes found with id: {}", refsteeltypesId);
            throw new EntityNotFoundException(String.valueOf(refsteeltypesId));
        }
        return refSteelTypes;
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefSteelTypes findById(Integer refsteeltypesId) {
        LOGGER.debug("Finding RefSteelTypes by id: {}", refsteeltypesId);
        return this.wmGenericDao.findById(refsteeltypesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefSteelTypes update(RefSteelTypes refSteelTypes) throws EntityNotFoundException {
        LOGGER.debug("Updating RefSteelTypes with information: {}", refSteelTypes);
        this.wmGenericDao.update(refSteelTypes);

        Integer refsteeltypesId = refSteelTypes.getId();

        return this.wmGenericDao.findById(refsteeltypesId);
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefSteelTypes delete(Integer refsteeltypesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefSteelTypes with id: {}", refsteeltypesId);
        RefSteelTypes deleted = this.wmGenericDao.findById(refsteeltypesId);
        if (deleted == null) {
            LOGGER.debug("No RefSteelTypes found with id: {}", refsteeltypesId);
            throw new EntityNotFoundException(String.valueOf(refsteeltypesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefSteelTypes> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefSteelTypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefSteelTypes> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefSteelTypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefSteelTypes to {} format", exportType);
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

