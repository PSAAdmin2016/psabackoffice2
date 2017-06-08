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

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.job1111.CivilFa;


/**
 * ServiceImpl object for domain model class CivilFa.
 *
 * @see CivilFa
 */
@Service("Job1111.CivilFaService")
public class CivilFaServiceImpl implements CivilFaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CivilFaServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.CivilFaDao")
    private WMGenericDao<CivilFa, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CivilFa, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public CivilFa create(CivilFa civilFa) {
        LOGGER.debug("Creating a new CivilFa with information: {}", civilFa);
        CivilFa civilFaCreated = this.wmGenericDao.create(civilFa);
        return civilFaCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CivilFa getById(Integer civilfaId) throws EntityNotFoundException {
        LOGGER.debug("Finding CivilFa by id: {}", civilfaId);
        CivilFa civilFa = this.wmGenericDao.findById(civilfaId);
        if (civilFa == null){
            LOGGER.debug("No CivilFa found with id: {}", civilfaId);
            throw new EntityNotFoundException(String.valueOf(civilfaId));
        }
        return civilFa;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CivilFa findById(Integer civilfaId) {
        LOGGER.debug("Finding CivilFa by id: {}", civilfaId);
        return this.wmGenericDao.findById(civilfaId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public CivilFa update(CivilFa civilFa) throws EntityNotFoundException {
        LOGGER.debug("Updating CivilFa with information: {}", civilFa);
        this.wmGenericDao.update(civilFa);

        Integer civilfaId = civilFa.getActivityId();

        return this.wmGenericDao.findById(civilfaId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public CivilFa delete(Integer civilfaId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CivilFa with id: {}", civilfaId);
        CivilFa deleted = this.wmGenericDao.findById(civilfaId);
        if (deleted == null) {
            LOGGER.debug("No CivilFa found with id: {}", civilfaId);
            throw new EntityNotFoundException(String.valueOf(civilfaId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<CivilFa> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CivilFas");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<CivilFa> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CivilFas");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table CivilFa to {} format", exportType);
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

