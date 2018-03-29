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

import com.psabackoffice.psa.Settingsuser;


/**
 * ServiceImpl object for domain model class Settingsuser.
 *
 * @see Settingsuser
 */
@Service("PSA.SettingsuserService")
@Validated
public class SettingsuserServiceImpl implements SettingsuserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingsuserServiceImpl.class);


    @Autowired
    @Qualifier("PSA.SettingsuserDao")
    private WMGenericDao<Settingsuser, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Settingsuser, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public Settingsuser create(Settingsuser settingsuser) {
        LOGGER.debug("Creating a new Settingsuser with information: {}", settingsuser);

        Settingsuser settingsuserCreated = this.wmGenericDao.create(settingsuser);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(settingsuserCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Settingsuser getById(Integer settingsuserId) throws EntityNotFoundException {
        LOGGER.debug("Finding Settingsuser by id: {}", settingsuserId);
        return this.wmGenericDao.findById(settingsuserId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Settingsuser findById(Integer settingsuserId) {
        LOGGER.debug("Finding Settingsuser by id: {}", settingsuserId);
        try {
            return this.wmGenericDao.findById(settingsuserId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No Settingsuser found with id: {}", settingsuserId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public Settingsuser update(Settingsuser settingsuser) throws EntityNotFoundException {
        LOGGER.debug("Updating Settingsuser with information: {}", settingsuser);

        this.wmGenericDao.update(settingsuser);
        this.wmGenericDao.refresh(settingsuser);

        return settingsuser;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public Settingsuser delete(Integer settingsuserId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Settingsuser with id: {}", settingsuserId);
        Settingsuser deleted = this.wmGenericDao.findById(settingsuserId);
        if (deleted == null) {
            LOGGER.debug("No Settingsuser found with id: {}", settingsuserId);
            throw new EntityNotFoundException(String.valueOf(settingsuserId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(Settingsuser settingsuser) {
        LOGGER.debug("Deleting Settingsuser with {}", settingsuser);
        this.wmGenericDao.delete(settingsuser);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<Settingsuser> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Settingsusers");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<Settingsuser> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Settingsusers");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table Settingsuser to {} format", exportType);
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
