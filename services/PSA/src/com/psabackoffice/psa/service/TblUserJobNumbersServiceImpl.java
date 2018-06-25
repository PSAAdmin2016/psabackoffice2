/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.psa.TblUserJobNumbers;


/**
 * ServiceImpl object for domain model class TblUserJobNumbers.
 *
 * @see TblUserJobNumbers
 */
@Service("PSA.TblUserJobNumbersService")
@Validated
public class TblUserJobNumbersServiceImpl implements TblUserJobNumbersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TblUserJobNumbersServiceImpl.class);


    @Autowired
    @Qualifier("PSA.TblUserJobNumbersDao")
    private WMGenericDao<TblUserJobNumbers, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TblUserJobNumbers, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public TblUserJobNumbers create(TblUserJobNumbers tblUserJobNumbers) {
        LOGGER.debug("Creating a new TblUserJobNumbers with information: {}", tblUserJobNumbers);

        TblUserJobNumbers tblUserJobNumbersCreated = this.wmGenericDao.create(tblUserJobNumbers);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(tblUserJobNumbersCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public TblUserJobNumbers getById(Integer tbluserjobnumbersId) {
        LOGGER.debug("Finding TblUserJobNumbers by id: {}", tbluserjobnumbersId);
        return this.wmGenericDao.findById(tbluserjobnumbersId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public TblUserJobNumbers findById(Integer tbluserjobnumbersId) {
        LOGGER.debug("Finding TblUserJobNumbers by id: {}", tbluserjobnumbersId);
        try {
            return this.wmGenericDao.findById(tbluserjobnumbersId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No TblUserJobNumbers found with id: {}", tbluserjobnumbersId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public TblUserJobNumbers update(TblUserJobNumbers tblUserJobNumbers) {
        LOGGER.debug("Updating TblUserJobNumbers with information: {}", tblUserJobNumbers);

        this.wmGenericDao.update(tblUserJobNumbers);
        this.wmGenericDao.refresh(tblUserJobNumbers);

        return tblUserJobNumbers;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public TblUserJobNumbers delete(Integer tbluserjobnumbersId) {
        LOGGER.debug("Deleting TblUserJobNumbers with id: {}", tbluserjobnumbersId);
        TblUserJobNumbers deleted = this.wmGenericDao.findById(tbluserjobnumbersId);
        if (deleted == null) {
            LOGGER.debug("No TblUserJobNumbers found with id: {}", tbluserjobnumbersId);
            throw new EntityNotFoundException(String.valueOf(tbluserjobnumbersId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(TblUserJobNumbers tblUserJobNumbers) {
        LOGGER.debug("Deleting TblUserJobNumbers with {}", tblUserJobNumbers);
        this.wmGenericDao.delete(tblUserJobNumbers);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<TblUserJobNumbers> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TblUserJobNumbers");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<TblUserJobNumbers> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TblUserJobNumbers");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table TblUserJobNumbers to {} format", exportType);
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

