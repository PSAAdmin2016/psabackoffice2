/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
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

import com.psabackoffice.psa.RefPercentList;


/**
 * ServiceImpl object for domain model class RefPercentList.
 *
 * @see RefPercentList
 */
@Service("PSA.RefPercentListService")
@Validated
public class RefPercentListServiceImpl implements RefPercentListService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefPercentListServiceImpl.class);


    @Autowired
    @Qualifier("PSA.RefPercentListDao")
    private WMGenericDao<RefPercentList, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefPercentList, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefPercentList create(RefPercentList refPercentList) {
        LOGGER.debug("Creating a new RefPercentList with information: {}", refPercentList);

        RefPercentList refPercentListCreated = this.wmGenericDao.create(refPercentList);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refPercentListCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefPercentList getById(Integer refpercentlistId) {
        LOGGER.debug("Finding RefPercentList by id: {}", refpercentlistId);
        return this.wmGenericDao.findById(refpercentlistId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefPercentList findById(Integer refpercentlistId) {
        LOGGER.debug("Finding RefPercentList by id: {}", refpercentlistId);
        try {
            return this.wmGenericDao.findById(refpercentlistId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No RefPercentList found with id: {}", refpercentlistId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefPercentList update(RefPercentList refPercentList) {
        LOGGER.debug("Updating RefPercentList with information: {}", refPercentList);

        this.wmGenericDao.update(refPercentList);
        this.wmGenericDao.refresh(refPercentList);

        return refPercentList;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefPercentList delete(Integer refpercentlistId) {
        LOGGER.debug("Deleting RefPercentList with id: {}", refpercentlistId);
        RefPercentList deleted = this.wmGenericDao.findById(refpercentlistId);
        if (deleted == null) {
            LOGGER.debug("No RefPercentList found with id: {}", refpercentlistId);
            throw new EntityNotFoundException(String.valueOf(refpercentlistId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(RefPercentList refPercentList) {
        LOGGER.debug("Deleting RefPercentList with {}", refPercentList);
        this.wmGenericDao.delete(refPercentList);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefPercentList> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefPercentLists");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefPercentList> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefPercentLists");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefPercentList to {} format", exportType);
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

