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

import com.psabackoffice.job1111.EquipFarev;


/**
 * ServiceImpl object for domain model class EquipFarev.
 *
 * @see EquipFarev
 */
@Service("Job1111.EquipFarevService")
public class EquipFarevServiceImpl implements EquipFarevService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquipFarevServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.EquipFarevDao")
    private WMGenericDao<EquipFarev, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EquipFarev, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public EquipFarev create(EquipFarev equipFarev) {
        LOGGER.debug("Creating a new EquipFarev with information: {}", equipFarev);
        EquipFarev equipFarevCreated = this.wmGenericDao.create(equipFarev);
        return equipFarevCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public EquipFarev getById(Integer equipfarevId) throws EntityNotFoundException {
        LOGGER.debug("Finding EquipFarev by id: {}", equipfarevId);
        EquipFarev equipFarev = this.wmGenericDao.findById(equipfarevId);
        if (equipFarev == null){
            LOGGER.debug("No EquipFarev found with id: {}", equipfarevId);
            throw new EntityNotFoundException(String.valueOf(equipfarevId));
        }
        return equipFarev;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public EquipFarev findById(Integer equipfarevId) {
        LOGGER.debug("Finding EquipFarev by id: {}", equipfarevId);
        return this.wmGenericDao.findById(equipfarevId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public EquipFarev update(EquipFarev equipFarev) throws EntityNotFoundException {
        LOGGER.debug("Updating EquipFarev with information: {}", equipFarev);
        this.wmGenericDao.update(equipFarev);

        Integer equipfarevId = equipFarev.getId();

        return this.wmGenericDao.findById(equipfarevId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public EquipFarev delete(Integer equipfarevId) throws EntityNotFoundException {
        LOGGER.debug("Deleting EquipFarev with id: {}", equipfarevId);
        EquipFarev deleted = this.wmGenericDao.findById(equipfarevId);
        if (deleted == null) {
            LOGGER.debug("No EquipFarev found with id: {}", equipfarevId);
            throw new EntityNotFoundException(String.valueOf(equipfarevId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<EquipFarev> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all EquipFarevs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<EquipFarev> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all EquipFarevs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table EquipFarev to {} format", exportType);
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

