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

import com.psabackoffice.psa.RefPipeSchedules;


/**
 * ServiceImpl object for domain model class RefPipeSchedules.
 *
 * @see RefPipeSchedules
 */
@Service("PSA.RefPipeSchedulesService")
public class RefPipeSchedulesServiceImpl implements RefPipeSchedulesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefPipeSchedulesServiceImpl.class);


    @Autowired
    @Qualifier("PSA.RefPipeSchedulesDao")
    private WMGenericDao<RefPipeSchedules, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefPipeSchedules, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefPipeSchedules create(RefPipeSchedules refPipeSchedules) {
        LOGGER.debug("Creating a new RefPipeSchedules with information: {}", refPipeSchedules);
        RefPipeSchedules refPipeSchedulesCreated = this.wmGenericDao.create(refPipeSchedules);
        return refPipeSchedulesCreated;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefPipeSchedules getById(Integer refpipeschedulesId) throws EntityNotFoundException {
        LOGGER.debug("Finding RefPipeSchedules by id: {}", refpipeschedulesId);
        RefPipeSchedules refPipeSchedules = this.wmGenericDao.findById(refpipeschedulesId);
        if (refPipeSchedules == null){
            LOGGER.debug("No RefPipeSchedules found with id: {}", refpipeschedulesId);
            throw new EntityNotFoundException(String.valueOf(refpipeschedulesId));
        }
        return refPipeSchedules;
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefPipeSchedules findById(Integer refpipeschedulesId) {
        LOGGER.debug("Finding RefPipeSchedules by id: {}", refpipeschedulesId);
        return this.wmGenericDao.findById(refpipeschedulesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefPipeSchedules update(RefPipeSchedules refPipeSchedules) throws EntityNotFoundException {
        LOGGER.debug("Updating RefPipeSchedules with information: {}", refPipeSchedules);
        this.wmGenericDao.update(refPipeSchedules);

        Integer refpipeschedulesId = refPipeSchedules.getId();

        return this.wmGenericDao.findById(refpipeschedulesId);
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefPipeSchedules delete(Integer refpipeschedulesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefPipeSchedules with id: {}", refpipeschedulesId);
        RefPipeSchedules deleted = this.wmGenericDao.findById(refpipeschedulesId);
        if (deleted == null) {
            LOGGER.debug("No RefPipeSchedules found with id: {}", refpipeschedulesId);
            throw new EntityNotFoundException(String.valueOf(refpipeschedulesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefPipeSchedules> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefPipeSchedules");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefPipeSchedules> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefPipeSchedules");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefPipeSchedules to {} format", exportType);
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

