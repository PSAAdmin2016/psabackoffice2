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

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.psa.RefDelayTypes;


/**
 * ServiceImpl object for domain model class RefDelayTypes.
 *
 * @see RefDelayTypes
 */
@Service("PSA.RefDelayTypesService")
public class RefDelayTypesServiceImpl implements RefDelayTypesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefDelayTypesServiceImpl.class);


    @Autowired
    @Qualifier("PSA.RefDelayTypesDao")
    private WMGenericDao<RefDelayTypes, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefDelayTypes, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefDelayTypes create(RefDelayTypes refDelayTypes) {
        LOGGER.debug("Creating a new RefDelayTypes with information: {}", refDelayTypes);
        RefDelayTypes refDelayTypesCreated = this.wmGenericDao.create(refDelayTypes);
        return refDelayTypesCreated;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefDelayTypes getById(Integer refdelaytypesId) throws EntityNotFoundException {
        LOGGER.debug("Finding RefDelayTypes by id: {}", refdelaytypesId);
        RefDelayTypes refDelayTypes = this.wmGenericDao.findById(refdelaytypesId);
        if (refDelayTypes == null){
            LOGGER.debug("No RefDelayTypes found with id: {}", refdelaytypesId);
            throw new EntityNotFoundException(String.valueOf(refdelaytypesId));
        }
        return refDelayTypes;
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefDelayTypes findById(Integer refdelaytypesId) {
        LOGGER.debug("Finding RefDelayTypes by id: {}", refdelaytypesId);
        return this.wmGenericDao.findById(refdelaytypesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefDelayTypes update(RefDelayTypes refDelayTypes) throws EntityNotFoundException {
        LOGGER.debug("Updating RefDelayTypes with information: {}", refDelayTypes);
        this.wmGenericDao.update(refDelayTypes);

        Integer refdelaytypesId = refDelayTypes.getId();

        return this.wmGenericDao.findById(refdelaytypesId);
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefDelayTypes delete(Integer refdelaytypesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefDelayTypes with id: {}", refdelaytypesId);
        RefDelayTypes deleted = this.wmGenericDao.findById(refdelaytypesId);
        if (deleted == null) {
            LOGGER.debug("No RefDelayTypes found with id: {}", refdelaytypesId);
            throw new EntityNotFoundException(String.valueOf(refdelaytypesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefDelayTypes> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefDelayTypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefDelayTypes> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefDelayTypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefDelayTypes to {} format", exportType);
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
