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

import com.psabackoffice.job1111.SteelTrackerDetails;


/**
 * ServiceImpl object for domain model class SteelTrackerDetails.
 *
 * @see SteelTrackerDetails
 */
@Service("Job1111.SteelTrackerDetailsService")
@Validated
public class SteelTrackerDetailsServiceImpl implements SteelTrackerDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelTrackerDetailsServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.SteelTrackerDetailsDao")
    private WMGenericDao<SteelTrackerDetails, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SteelTrackerDetails, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SteelTrackerDetails create(SteelTrackerDetails steelTrackerDetails) {
        LOGGER.debug("Creating a new SteelTrackerDetails with information: {}", steelTrackerDetails);

        SteelTrackerDetails steelTrackerDetailsCreated = this.wmGenericDao.create(steelTrackerDetails);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(steelTrackerDetailsCreated);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelTrackerDetails getById(Integer steeltrackerdetailsId) throws EntityNotFoundException {
        LOGGER.debug("Finding SteelTrackerDetails by id: {}", steeltrackerdetailsId);
        return this.wmGenericDao.findById(steeltrackerdetailsId);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelTrackerDetails findById(Integer steeltrackerdetailsId) {
        LOGGER.debug("Finding SteelTrackerDetails by id: {}", steeltrackerdetailsId);
        try {
            return this.wmGenericDao.findById(steeltrackerdetailsId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No SteelTrackerDetails found with id: {}", steeltrackerdetailsId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SteelTrackerDetails update(SteelTrackerDetails steelTrackerDetails) throws EntityNotFoundException {
        LOGGER.debug("Updating SteelTrackerDetails with information: {}", steelTrackerDetails);

        this.wmGenericDao.update(steelTrackerDetails);
        this.wmGenericDao.refresh(steelTrackerDetails);

        return steelTrackerDetails;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SteelTrackerDetails delete(Integer steeltrackerdetailsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelTrackerDetails with id: {}", steeltrackerdetailsId);
        SteelTrackerDetails deleted = this.wmGenericDao.findById(steeltrackerdetailsId);
        if (deleted == null) {
            LOGGER.debug("No SteelTrackerDetails found with id: {}", steeltrackerdetailsId);
            throw new EntityNotFoundException(String.valueOf(steeltrackerdetailsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public void delete(SteelTrackerDetails steelTrackerDetails) {
        LOGGER.debug("Deleting SteelTrackerDetails with {}", steelTrackerDetails);
        this.wmGenericDao.delete(steelTrackerDetails);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SteelTrackerDetails> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SteelTrackerDetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SteelTrackerDetails> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SteelTrackerDetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SteelTrackerDetails to {} format", exportType);
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

