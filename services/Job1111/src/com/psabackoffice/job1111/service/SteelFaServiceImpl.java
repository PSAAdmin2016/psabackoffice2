/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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

import com.psabackoffice.job1111.SteelFa;


/**
 * ServiceImpl object for domain model class SteelFa.
 *
 * @see SteelFa
 */
@Service("Job1111.SteelFaService")
@Validated
public class SteelFaServiceImpl implements SteelFaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelFaServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.SteelFaDao")
    private WMGenericDao<SteelFa, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SteelFa, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SteelFa create(SteelFa steelFa) {
        LOGGER.debug("Creating a new SteelFa with information: {}", steelFa);

        SteelFa steelFaCreated = this.wmGenericDao.create(steelFa);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(steelFaCreated);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelFa getById(Integer steelfaId) {
        LOGGER.debug("Finding SteelFa by id: {}", steelfaId);
        return this.wmGenericDao.findById(steelfaId);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelFa findById(Integer steelfaId) {
        LOGGER.debug("Finding SteelFa by id: {}", steelfaId);
        try {
            return this.wmGenericDao.findById(steelfaId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No SteelFa found with id: {}", steelfaId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SteelFa update(SteelFa steelFa) {
        LOGGER.debug("Updating SteelFa with information: {}", steelFa);

        this.wmGenericDao.update(steelFa);
        this.wmGenericDao.refresh(steelFa);

        return steelFa;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SteelFa delete(Integer steelfaId) {
        LOGGER.debug("Deleting SteelFa with id: {}", steelfaId);
        SteelFa deleted = this.wmGenericDao.findById(steelfaId);
        if (deleted == null) {
            LOGGER.debug("No SteelFa found with id: {}", steelfaId);
            throw new EntityNotFoundException(String.valueOf(steelfaId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public void delete(SteelFa steelFa) {
        LOGGER.debug("Deleting SteelFa with {}", steelFa);
        this.wmGenericDao.delete(steelFa);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SteelFa> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SteelFas");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SteelFa> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SteelFas");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SteelFa to {} format", exportType);
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

