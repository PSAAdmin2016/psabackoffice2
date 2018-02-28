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

import com.psabackoffice.job1111.CivilSellPackage;


/**
 * ServiceImpl object for domain model class CivilSellPackage.
 *
 * @see CivilSellPackage
 */
@Service("Job1111.CivilSellPackageService")
@Validated
public class CivilSellPackageServiceImpl implements CivilSellPackageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CivilSellPackageServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.CivilSellPackageDao")
    private WMGenericDao<CivilSellPackage, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CivilSellPackage, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public CivilSellPackage create(CivilSellPackage civilSellPackage) {
        LOGGER.debug("Creating a new CivilSellPackage with information: {}", civilSellPackage);

        CivilSellPackage civilSellPackageCreated = this.wmGenericDao.create(civilSellPackage);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(civilSellPackageCreated);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CivilSellPackage getById(Integer civilsellpackageId) throws EntityNotFoundException {
        LOGGER.debug("Finding CivilSellPackage by id: {}", civilsellpackageId);
        return this.wmGenericDao.findById(civilsellpackageId);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CivilSellPackage findById(Integer civilsellpackageId) {
        LOGGER.debug("Finding CivilSellPackage by id: {}", civilsellpackageId);
        try {
            return this.wmGenericDao.findById(civilsellpackageId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No CivilSellPackage found with id: {}", civilsellpackageId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public CivilSellPackage update(CivilSellPackage civilSellPackage) throws EntityNotFoundException {
        LOGGER.debug("Updating CivilSellPackage with information: {}", civilSellPackage);

        this.wmGenericDao.update(civilSellPackage);
        this.wmGenericDao.refresh(civilSellPackage);

        return civilSellPackage;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public CivilSellPackage delete(Integer civilsellpackageId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CivilSellPackage with id: {}", civilsellpackageId);
        CivilSellPackage deleted = this.wmGenericDao.findById(civilsellpackageId);
        if (deleted == null) {
            LOGGER.debug("No CivilSellPackage found with id: {}", civilsellpackageId);
            throw new EntityNotFoundException(String.valueOf(civilsellpackageId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public void delete(CivilSellPackage civilSellPackage) {
        LOGGER.debug("Deleting CivilSellPackage with {}", civilSellPackage);
        this.wmGenericDao.delete(civilSellPackage);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<CivilSellPackage> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CivilSellPackages");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<CivilSellPackage> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CivilSellPackages");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table CivilSellPackage to {} format", exportType);
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

