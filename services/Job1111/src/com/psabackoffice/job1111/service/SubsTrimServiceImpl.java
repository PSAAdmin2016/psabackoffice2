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

import com.psabackoffice.job1111.SubsTrim;


/**
 * ServiceImpl object for domain model class SubsTrim.
 *
 * @see SubsTrim
 */
@Service("Job1111.SubsTrimService")
public class SubsTrimServiceImpl implements SubsTrimService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubsTrimServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.SubsTrimDao")
    private WMGenericDao<SubsTrim, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SubsTrim, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SubsTrim create(SubsTrim subsTrim) {
        LOGGER.debug("Creating a new SubsTrim with information: {}", subsTrim);
        SubsTrim subsTrimCreated = this.wmGenericDao.create(subsTrim);
        return subsTrimCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubsTrim getById(Integer substrimId) throws EntityNotFoundException {
        LOGGER.debug("Finding SubsTrim by id: {}", substrimId);
        SubsTrim subsTrim = this.wmGenericDao.findById(substrimId);
        if (subsTrim == null){
            LOGGER.debug("No SubsTrim found with id: {}", substrimId);
            throw new EntityNotFoundException(String.valueOf(substrimId));
        }
        return subsTrim;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubsTrim findById(Integer substrimId) {
        LOGGER.debug("Finding SubsTrim by id: {}", substrimId);
        return this.wmGenericDao.findById(substrimId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SubsTrim update(SubsTrim subsTrim) throws EntityNotFoundException {
        LOGGER.debug("Updating SubsTrim with information: {}", subsTrim);
        this.wmGenericDao.update(subsTrim);

        Integer substrimId = subsTrim.getId();

        return this.wmGenericDao.findById(substrimId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SubsTrim delete(Integer substrimId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SubsTrim with id: {}", substrimId);
        SubsTrim deleted = this.wmGenericDao.findById(substrimId);
        if (deleted == null) {
            LOGGER.debug("No SubsTrim found with id: {}", substrimId);
            throw new EntityNotFoundException(String.valueOf(substrimId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SubsTrim> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SubsTrims");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SubsTrim> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SubsTrims");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SubsTrim to {} format", exportType);
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

