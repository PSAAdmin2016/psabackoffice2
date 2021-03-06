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

import com.psabackoffice.psa.TblCrewsRev;


/**
 * ServiceImpl object for domain model class TblCrewsRev.
 *
 * @see TblCrewsRev
 */
@Service("PSA.TblCrewsRevService")
@Validated
public class TblCrewsRevServiceImpl implements TblCrewsRevService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TblCrewsRevServiceImpl.class);


    @Autowired
    @Qualifier("PSA.TblCrewsRevDao")
    private WMGenericDao<TblCrewsRev, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TblCrewsRev, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public TblCrewsRev create(TblCrewsRev tblCrewsRev) {
        LOGGER.debug("Creating a new TblCrewsRev with information: {}", tblCrewsRev);

        TblCrewsRev tblCrewsRevCreated = this.wmGenericDao.create(tblCrewsRev);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(tblCrewsRevCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public TblCrewsRev getById(Integer tblcrewsrevId) {
        LOGGER.debug("Finding TblCrewsRev by id: {}", tblcrewsrevId);
        return this.wmGenericDao.findById(tblcrewsrevId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public TblCrewsRev findById(Integer tblcrewsrevId) {
        LOGGER.debug("Finding TblCrewsRev by id: {}", tblcrewsrevId);
        try {
            return this.wmGenericDao.findById(tblcrewsrevId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No TblCrewsRev found with id: {}", tblcrewsrevId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public TblCrewsRev update(TblCrewsRev tblCrewsRev) {
        LOGGER.debug("Updating TblCrewsRev with information: {}", tblCrewsRev);

        this.wmGenericDao.update(tblCrewsRev);
        this.wmGenericDao.refresh(tblCrewsRev);

        return tblCrewsRev;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public TblCrewsRev delete(Integer tblcrewsrevId) {
        LOGGER.debug("Deleting TblCrewsRev with id: {}", tblcrewsrevId);
        TblCrewsRev deleted = this.wmGenericDao.findById(tblcrewsrevId);
        if (deleted == null) {
            LOGGER.debug("No TblCrewsRev found with id: {}", tblcrewsrevId);
            throw new EntityNotFoundException(String.valueOf(tblcrewsrevId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(TblCrewsRev tblCrewsRev) {
        LOGGER.debug("Deleting TblCrewsRev with {}", tblCrewsRev);
        this.wmGenericDao.delete(tblCrewsRev);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<TblCrewsRev> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TblCrewsRevs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<TblCrewsRev> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TblCrewsRevs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table TblCrewsRev to {} format", exportType);
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

