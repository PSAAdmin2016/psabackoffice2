/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
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

import com.psabackoffice.psa.TblJobNumbers;
import com.psabackoffice.psa.TblJobSites;


/**
 * ServiceImpl object for domain model class TblJobSites.
 *
 * @see TblJobSites
 */
@Service("PSA.TblJobSitesService")
@Validated
public class TblJobSitesServiceImpl implements TblJobSitesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TblJobSitesServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("PSA.TblJobNumbersService")
	private TblJobNumbersService tblJobNumbersService;

    @Autowired
    @Qualifier("PSA.TblJobSitesDao")
    private WMGenericDao<TblJobSites, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TblJobSites, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public TblJobSites create(TblJobSites tblJobSites) {
        LOGGER.debug("Creating a new TblJobSites with information: {}", tblJobSites);

        TblJobSites tblJobSitesCreated = this.wmGenericDao.create(tblJobSites);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(tblJobSitesCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public TblJobSites getById(Integer tbljobsitesId) throws EntityNotFoundException {
        LOGGER.debug("Finding TblJobSites by id: {}", tbljobsitesId);
        return this.wmGenericDao.findById(tbljobsitesId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public TblJobSites findById(Integer tbljobsitesId) {
        LOGGER.debug("Finding TblJobSites by id: {}", tbljobsitesId);
        try {
            return this.wmGenericDao.findById(tbljobsitesId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No TblJobSites found with id: {}", tbljobsitesId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public TblJobSites update(TblJobSites tblJobSites) throws EntityNotFoundException {
        LOGGER.debug("Updating TblJobSites with information: {}", tblJobSites);

        List<TblJobNumbers> tblJobNumberses = tblJobSites.getTblJobNumberses();

        if(tblJobNumberses != null && Hibernate.isInitialized(tblJobNumberses)) {
            if(!tblJobNumberses.isEmpty()) {
                for(TblJobNumbers _tblJobNumbers : tblJobNumberses) {
                    _tblJobNumbers.setTblJobSites(tblJobSites);
                }
            }
        }

        this.wmGenericDao.update(tblJobSites);
        this.wmGenericDao.refresh(tblJobSites);

        return tblJobSites;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public TblJobSites delete(Integer tbljobsitesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TblJobSites with id: {}", tbljobsitesId);
        TblJobSites deleted = this.wmGenericDao.findById(tbljobsitesId);
        if (deleted == null) {
            LOGGER.debug("No TblJobSites found with id: {}", tbljobsitesId);
            throw new EntityNotFoundException(String.valueOf(tbljobsitesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(TblJobSites tblJobSites) {
        LOGGER.debug("Deleting TblJobSites with {}", tblJobSites);
        this.wmGenericDao.delete(tblJobSites);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<TblJobSites> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TblJobSites");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<TblJobSites> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TblJobSites");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table TblJobSites to {} format", exportType);
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
    public Page<TblJobNumbers> findAssociatedTblJobNumberses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated tblJobNumberses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("tblJobSites.id = '" + id + "'");

        return tblJobNumbersService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TblJobNumbersService instance
	 */
	protected void setTblJobNumbersService(TblJobNumbersService service) {
        this.tblJobNumbersService = service;
    }

}

