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

import com.psabackoffice.job1111.CivilMisc;


/**
 * ServiceImpl object for domain model class CivilMisc.
 *
 * @see CivilMisc
 */
@Service("Job1111.CivilMiscService")
public class CivilMiscServiceImpl implements CivilMiscService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CivilMiscServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.CivilMiscDao")
    private WMGenericDao<CivilMisc, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CivilMisc, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public CivilMisc create(CivilMisc civilMisc) {
        LOGGER.debug("Creating a new CivilMisc with information: {}", civilMisc);
        CivilMisc civilMiscCreated = this.wmGenericDao.create(civilMisc);
        return civilMiscCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CivilMisc getById(Integer civilmiscId) throws EntityNotFoundException {
        LOGGER.debug("Finding CivilMisc by id: {}", civilmiscId);
        CivilMisc civilMisc = this.wmGenericDao.findById(civilmiscId);
        if (civilMisc == null){
            LOGGER.debug("No CivilMisc found with id: {}", civilmiscId);
            throw new EntityNotFoundException(String.valueOf(civilmiscId));
        }
        return civilMisc;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CivilMisc findById(Integer civilmiscId) {
        LOGGER.debug("Finding CivilMisc by id: {}", civilmiscId);
        return this.wmGenericDao.findById(civilmiscId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public CivilMisc update(CivilMisc civilMisc) throws EntityNotFoundException {
        LOGGER.debug("Updating CivilMisc with information: {}", civilMisc);
        this.wmGenericDao.update(civilMisc);

        Integer civilmiscId = civilMisc.getActivityId();

        return this.wmGenericDao.findById(civilmiscId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public CivilMisc delete(Integer civilmiscId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CivilMisc with id: {}", civilmiscId);
        CivilMisc deleted = this.wmGenericDao.findById(civilmiscId);
        if (deleted == null) {
            LOGGER.debug("No CivilMisc found with id: {}", civilmiscId);
            throw new EntityNotFoundException(String.valueOf(civilmiscId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<CivilMisc> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CivilMiscs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<CivilMisc> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CivilMiscs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table CivilMisc to {} format", exportType);
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

