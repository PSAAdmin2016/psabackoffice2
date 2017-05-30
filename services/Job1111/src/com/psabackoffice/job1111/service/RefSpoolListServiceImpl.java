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

import com.psabackoffice.job1111.RefSpoolList;


/**
 * ServiceImpl object for domain model class RefSpoolList.
 *
 * @see RefSpoolList
 */
@Service("Job1111.RefSpoolListService")
public class RefSpoolListServiceImpl implements RefSpoolListService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefSpoolListServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.RefSpoolListDao")
    private WMGenericDao<RefSpoolList, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefSpoolList, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public RefSpoolList create(RefSpoolList refSpoolList) {
        LOGGER.debug("Creating a new RefSpoolList with information: {}", refSpoolList);
        RefSpoolList refSpoolListCreated = this.wmGenericDao.create(refSpoolList);
        return refSpoolListCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public RefSpoolList getById(String refspoollistId) throws EntityNotFoundException {
        LOGGER.debug("Finding RefSpoolList by id: {}", refspoollistId);
        RefSpoolList refSpoolList = this.wmGenericDao.findById(refspoollistId);
        if (refSpoolList == null){
            LOGGER.debug("No RefSpoolList found with id: {}", refspoollistId);
            throw new EntityNotFoundException(String.valueOf(refspoollistId));
        }
        return refSpoolList;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public RefSpoolList findById(String refspoollistId) {
        LOGGER.debug("Finding RefSpoolList by id: {}", refspoollistId);
        return this.wmGenericDao.findById(refspoollistId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public RefSpoolList update(RefSpoolList refSpoolList) throws EntityNotFoundException {
        LOGGER.debug("Updating RefSpoolList with information: {}", refSpoolList);
        this.wmGenericDao.update(refSpoolList);

        String refspoollistId = refSpoolList.getSpoolNumber();

        return this.wmGenericDao.findById(refspoollistId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public RefSpoolList delete(String refspoollistId) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefSpoolList with id: {}", refspoollistId);
        RefSpoolList deleted = this.wmGenericDao.findById(refspoollistId);
        if (deleted == null) {
            LOGGER.debug("No RefSpoolList found with id: {}", refspoollistId);
            throw new EntityNotFoundException(String.valueOf(refspoollistId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<RefSpoolList> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefSpoolLists");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<RefSpoolList> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefSpoolLists");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table RefSpoolList to {} format", exportType);
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

