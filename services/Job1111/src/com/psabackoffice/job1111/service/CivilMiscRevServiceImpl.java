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

import com.psabackoffice.job1111.CivilMiscRev;


/**
 * ServiceImpl object for domain model class CivilMiscRev.
 *
 * @see CivilMiscRev
 */
@Service("Job1111.CivilMiscRevService")
public class CivilMiscRevServiceImpl implements CivilMiscRevService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CivilMiscRevServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.CivilMiscRevDao")
    private WMGenericDao<CivilMiscRev, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CivilMiscRev, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public CivilMiscRev create(CivilMiscRev civilMiscRev) {
        LOGGER.debug("Creating a new CivilMiscRev with information: {}", civilMiscRev);
        CivilMiscRev civilMiscRevCreated = this.wmGenericDao.create(civilMiscRev);
        return civilMiscRevCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CivilMiscRev getById(Integer civilmiscrevId) throws EntityNotFoundException {
        LOGGER.debug("Finding CivilMiscRev by id: {}", civilmiscrevId);
        CivilMiscRev civilMiscRev = this.wmGenericDao.findById(civilmiscrevId);
        if (civilMiscRev == null){
            LOGGER.debug("No CivilMiscRev found with id: {}", civilmiscrevId);
            throw new EntityNotFoundException(String.valueOf(civilmiscrevId));
        }
        return civilMiscRev;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CivilMiscRev findById(Integer civilmiscrevId) {
        LOGGER.debug("Finding CivilMiscRev by id: {}", civilmiscrevId);
        return this.wmGenericDao.findById(civilmiscrevId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public CivilMiscRev update(CivilMiscRev civilMiscRev) throws EntityNotFoundException {
        LOGGER.debug("Updating CivilMiscRev with information: {}", civilMiscRev);
        this.wmGenericDao.update(civilMiscRev);

        Integer civilmiscrevId = civilMiscRev.getId();

        return this.wmGenericDao.findById(civilmiscrevId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public CivilMiscRev delete(Integer civilmiscrevId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CivilMiscRev with id: {}", civilmiscrevId);
        CivilMiscRev deleted = this.wmGenericDao.findById(civilmiscrevId);
        if (deleted == null) {
            LOGGER.debug("No CivilMiscRev found with id: {}", civilmiscrevId);
            throw new EntityNotFoundException(String.valueOf(civilmiscrevId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<CivilMiscRev> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CivilMiscRevs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<CivilMiscRev> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CivilMiscRevs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table CivilMiscRev to {} format", exportType);
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

