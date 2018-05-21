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

import com.psabackoffice.job1111.Motd;


/**
 * ServiceImpl object for domain model class Motd.
 *
 * @see Motd
 */
@Service("Job1111.MotdService")
@Validated
public class MotdServiceImpl implements MotdService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MotdServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.MotdDao")
    private WMGenericDao<Motd, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Motd, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public Motd create(Motd motd) {
        LOGGER.debug("Creating a new Motd with information: {}", motd);

        Motd motdCreated = this.wmGenericDao.create(motd);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(motdCreated);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Motd getById(Integer motdId) {
        LOGGER.debug("Finding Motd by id: {}", motdId);
        return this.wmGenericDao.findById(motdId);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Motd findById(Integer motdId) {
        LOGGER.debug("Finding Motd by id: {}", motdId);
        try {
            return this.wmGenericDao.findById(motdId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No Motd found with id: {}", motdId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public Motd update(Motd motd) {
        LOGGER.debug("Updating Motd with information: {}", motd);

        this.wmGenericDao.update(motd);
        this.wmGenericDao.refresh(motd);

        return motd;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public Motd delete(Integer motdId) {
        LOGGER.debug("Deleting Motd with id: {}", motdId);
        Motd deleted = this.wmGenericDao.findById(motdId);
        if (deleted == null) {
            LOGGER.debug("No Motd found with id: {}", motdId);
            throw new EntityNotFoundException(String.valueOf(motdId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public void delete(Motd motd) {
        LOGGER.debug("Deleting Motd with {}", motd);
        this.wmGenericDao.delete(motd);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<Motd> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Motds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<Motd> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Motds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table Motd to {} format", exportType);
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

