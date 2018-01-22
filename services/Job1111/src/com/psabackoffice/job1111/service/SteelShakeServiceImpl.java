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
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.job1111.SteelShake;


/**
 * ServiceImpl object for domain model class SteelShake.
 *
 * @see SteelShake
 */
@Service("Job1111.SteelShakeService")
@Validated
public class SteelShakeServiceImpl implements SteelShakeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelShakeServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.SteelShakeDao")
    private WMGenericDao<SteelShake, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SteelShake, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SteelShake create(SteelShake steelShake) {
        LOGGER.debug("Creating a new SteelShake with information: {}", steelShake);

        SteelShake steelShakeCreated = this.wmGenericDao.create(steelShake);
        return steelShakeCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelShake getById(Integer steelshakeId) throws EntityNotFoundException {
        LOGGER.debug("Finding SteelShake by id: {}", steelshakeId);
        SteelShake steelShake = this.wmGenericDao.findById(steelshakeId);
        if (steelShake == null){
            LOGGER.debug("No SteelShake found with id: {}", steelshakeId);
            throw new EntityNotFoundException(String.valueOf(steelshakeId));
        }
        return steelShake;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelShake findById(Integer steelshakeId) {
        LOGGER.debug("Finding SteelShake by id: {}", steelshakeId);
        return this.wmGenericDao.findById(steelshakeId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SteelShake update(SteelShake steelShake) throws EntityNotFoundException {
        LOGGER.debug("Updating SteelShake with information: {}", steelShake);
        this.wmGenericDao.update(steelShake);

        Integer steelshakeId = steelShake.getId();

        return this.wmGenericDao.findById(steelshakeId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SteelShake delete(Integer steelshakeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelShake with id: {}", steelshakeId);
        SteelShake deleted = this.wmGenericDao.findById(steelshakeId);
        if (deleted == null) {
            LOGGER.debug("No SteelShake found with id: {}", steelshakeId);
            throw new EntityNotFoundException(String.valueOf(steelshakeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SteelShake> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SteelShakes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SteelShake> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SteelShakes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SteelShake to {} format", exportType);
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

