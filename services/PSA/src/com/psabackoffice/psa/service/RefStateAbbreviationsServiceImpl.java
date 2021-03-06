/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
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

import com.psabackoffice.psa.RefStateAbbreviations;
import com.psabackoffice.psa.TblJobSites;


/**
 * ServiceImpl object for domain model class RefStateAbbreviations.
 *
 * @see RefStateAbbreviations
 */
@Service("PSA.RefStateAbbreviationsService")
@Validated
public class RefStateAbbreviationsServiceImpl implements RefStateAbbreviationsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefStateAbbreviationsServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("PSA.TblJobSitesService")
	private TblJobSitesService tblJobSitesService;

    @Autowired
    @Qualifier("PSA.RefStateAbbreviationsDao")
    private WMGenericDao<RefStateAbbreviations, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefStateAbbreviations, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefStateAbbreviations create(RefStateAbbreviations refStateAbbreviations) {
        LOGGER.debug("Creating a new RefStateAbbreviations with information: {}", refStateAbbreviations);

        List<TblJobSites> tblJobSiteses = refStateAbbreviations.getTblJobSiteses();
        if(tblJobSiteses != null && Hibernate.isInitialized(tblJobSiteses)) {
            tblJobSiteses.forEach(_tblJobSites -> _tblJobSites.setRefStateAbbreviations(refStateAbbreviations));
        }

        RefStateAbbreviations refStateAbbreviationsCreated = this.wmGenericDao.create(refStateAbbreviations);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refStateAbbreviationsCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefStateAbbreviations getById(String refstateabbreviationsId) {
        LOGGER.debug("Finding RefStateAbbreviations by id: {}", refstateabbreviationsId);
        return this.wmGenericDao.findById(refstateabbreviationsId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefStateAbbreviations findById(String refstateabbreviationsId) {
        LOGGER.debug("Finding RefStateAbbreviations by id: {}", refstateabbreviationsId);
        try {
            return this.wmGenericDao.findById(refstateabbreviationsId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No RefStateAbbreviations found with id: {}", refstateabbreviationsId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefStateAbbreviations update(RefStateAbbreviations refStateAbbreviations) {
        LOGGER.debug("Updating RefStateAbbreviations with information: {}", refStateAbbreviations);

        List<TblJobSites> tblJobSiteses = refStateAbbreviations.getTblJobSiteses();
        if(tblJobSiteses != null && Hibernate.isInitialized(tblJobSiteses)) {
            tblJobSiteses.forEach(_tblJobSites -> _tblJobSites.setRefStateAbbreviations(refStateAbbreviations));
        }

        this.wmGenericDao.update(refStateAbbreviations);
        this.wmGenericDao.refresh(refStateAbbreviations);

        return refStateAbbreviations;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefStateAbbreviations delete(String refstateabbreviationsId) {
        LOGGER.debug("Deleting RefStateAbbreviations with id: {}", refstateabbreviationsId);
        RefStateAbbreviations deleted = this.wmGenericDao.findById(refstateabbreviationsId);
        if (deleted == null) {
            LOGGER.debug("No RefStateAbbreviations found with id: {}", refstateabbreviationsId);
            throw new EntityNotFoundException(String.valueOf(refstateabbreviationsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(RefStateAbbreviations refStateAbbreviations) {
        LOGGER.debug("Deleting RefStateAbbreviations with {}", refStateAbbreviations);
        this.wmGenericDao.delete(refStateAbbreviations);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefStateAbbreviations> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefStateAbbreviations");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefStateAbbreviations> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefStateAbbreviations");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefStateAbbreviations to {} format", exportType);
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

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<TblJobSites> findAssociatedTblJobSiteses(String abbreviation, Pageable pageable) {
        LOGGER.debug("Fetching all associated tblJobSiteses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("refStateAbbreviations.abbreviation = '" + abbreviation + "'");

        return tblJobSitesService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TblJobSitesService instance
	 */
	protected void setTblJobSitesService(TblJobSitesService service) {
        this.tblJobSitesService = service;
    }

}

