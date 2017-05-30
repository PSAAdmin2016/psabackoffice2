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

import com.psabackoffice.job1111.PipeMisc;


/**
 * ServiceImpl object for domain model class PipeMisc.
 *
 * @see PipeMisc
 */
@Service("Job1111.PipeMiscService")
public class PipeMiscServiceImpl implements PipeMiscService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PipeMiscServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.PipeMiscDao")
    private WMGenericDao<PipeMisc, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<PipeMisc, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public PipeMisc create(PipeMisc pipeMisc) {
        LOGGER.debug("Creating a new PipeMisc with information: {}", pipeMisc);
        PipeMisc pipeMiscCreated = this.wmGenericDao.create(pipeMisc);
        return pipeMiscCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public PipeMisc getById(Integer pipemiscId) throws EntityNotFoundException {
        LOGGER.debug("Finding PipeMisc by id: {}", pipemiscId);
        PipeMisc pipeMisc = this.wmGenericDao.findById(pipemiscId);
        if (pipeMisc == null){
            LOGGER.debug("No PipeMisc found with id: {}", pipemiscId);
            throw new EntityNotFoundException(String.valueOf(pipemiscId));
        }
        return pipeMisc;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public PipeMisc findById(Integer pipemiscId) {
        LOGGER.debug("Finding PipeMisc by id: {}", pipemiscId);
        return this.wmGenericDao.findById(pipemiscId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public PipeMisc update(PipeMisc pipeMisc) throws EntityNotFoundException {
        LOGGER.debug("Updating PipeMisc with information: {}", pipeMisc);
        this.wmGenericDao.update(pipeMisc);

        Integer pipemiscId = pipeMisc.getId();

        return this.wmGenericDao.findById(pipemiscId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public PipeMisc delete(Integer pipemiscId) throws EntityNotFoundException {
        LOGGER.debug("Deleting PipeMisc with id: {}", pipemiscId);
        PipeMisc deleted = this.wmGenericDao.findById(pipemiscId);
        if (deleted == null) {
            LOGGER.debug("No PipeMisc found with id: {}", pipemiscId);
            throw new EntityNotFoundException(String.valueOf(pipemiscId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<PipeMisc> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PipeMiscs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<PipeMisc> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PipeMiscs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table PipeMisc to {} format", exportType);
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
