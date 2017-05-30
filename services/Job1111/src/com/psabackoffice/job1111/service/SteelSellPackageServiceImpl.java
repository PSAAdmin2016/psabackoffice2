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

import com.psabackoffice.job1111.SteelSellPackage;


/**
 * ServiceImpl object for domain model class SteelSellPackage.
 *
 * @see SteelSellPackage
 */
@Service("Job1111.SteelSellPackageService")
public class SteelSellPackageServiceImpl implements SteelSellPackageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelSellPackageServiceImpl.class);


    @Autowired
    @Qualifier("Job1111.SteelSellPackageDao")
    private WMGenericDao<SteelSellPackage, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SteelSellPackage, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SteelSellPackage create(SteelSellPackage steelSellPackage) {
        LOGGER.debug("Creating a new SteelSellPackage with information: {}", steelSellPackage);
        SteelSellPackage steelSellPackageCreated = this.wmGenericDao.create(steelSellPackage);
        return steelSellPackageCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelSellPackage getById(Integer steelsellpackageId) throws EntityNotFoundException {
        LOGGER.debug("Finding SteelSellPackage by id: {}", steelsellpackageId);
        SteelSellPackage steelSellPackage = this.wmGenericDao.findById(steelsellpackageId);
        if (steelSellPackage == null){
            LOGGER.debug("No SteelSellPackage found with id: {}", steelsellpackageId);
            throw new EntityNotFoundException(String.valueOf(steelsellpackageId));
        }
        return steelSellPackage;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SteelSellPackage findById(Integer steelsellpackageId) {
        LOGGER.debug("Finding SteelSellPackage by id: {}", steelsellpackageId);
        return this.wmGenericDao.findById(steelsellpackageId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SteelSellPackage update(SteelSellPackage steelSellPackage) throws EntityNotFoundException {
        LOGGER.debug("Updating SteelSellPackage with information: {}", steelSellPackage);
        this.wmGenericDao.update(steelSellPackage);

        Integer steelsellpackageId = steelSellPackage.getId();

        return this.wmGenericDao.findById(steelsellpackageId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SteelSellPackage delete(Integer steelsellpackageId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelSellPackage with id: {}", steelsellpackageId);
        SteelSellPackage deleted = this.wmGenericDao.findById(steelsellpackageId);
        if (deleted == null) {
            LOGGER.debug("No SteelSellPackage found with id: {}", steelsellpackageId);
            throw new EntityNotFoundException(String.valueOf(steelsellpackageId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SteelSellPackage> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SteelSellPackages");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SteelSellPackage> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SteelSellPackages");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SteelSellPackage to {} format", exportType);
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

