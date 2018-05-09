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

import com.psabackoffice.psa.RefCrafts;
import com.psabackoffice.psa.TblUserPsa;


/**
 * ServiceImpl object for domain model class RefCrafts.
 *
 * @see RefCrafts
 */
@Service("PSA.RefCraftsService")
@Validated
public class RefCraftsServiceImpl implements RefCraftsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefCraftsServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("PSA.TblUserPsaService")
	private TblUserPsaService tblUserPsaService;

    @Autowired
    @Qualifier("PSA.RefCraftsDao")
    private WMGenericDao<RefCrafts, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefCrafts, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefCrafts create(RefCrafts refCrafts) {
        LOGGER.debug("Creating a new RefCrafts with information: {}", refCrafts);

        RefCrafts refCraftsCreated = this.wmGenericDao.create(refCrafts);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refCraftsCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefCrafts getById(Integer refcraftsId) {
        LOGGER.debug("Finding RefCrafts by id: {}", refcraftsId);
        return this.wmGenericDao.findById(refcraftsId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefCrafts findById(Integer refcraftsId) {
        LOGGER.debug("Finding RefCrafts by id: {}", refcraftsId);
        try {
            return this.wmGenericDao.findById(refcraftsId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No RefCrafts found with id: {}", refcraftsId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefCrafts update(RefCrafts refCrafts) {
        LOGGER.debug("Updating RefCrafts with information: {}", refCrafts);

        List<TblUserPsa> tblUserPsas = refCrafts.getTblUserPsas();
        if(tblUserPsas != null && Hibernate.isInitialized(tblUserPsas)) {
            tblUserPsas.forEach(_tblUserPsa -> _tblUserPsa.setRefCrafts(refCrafts));
        }

        this.wmGenericDao.update(refCrafts);
        this.wmGenericDao.refresh(refCrafts);

        return refCrafts;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefCrafts delete(Integer refcraftsId) {
        LOGGER.debug("Deleting RefCrafts with id: {}", refcraftsId);
        RefCrafts deleted = this.wmGenericDao.findById(refcraftsId);
        if (deleted == null) {
            LOGGER.debug("No RefCrafts found with id: {}", refcraftsId);
            throw new EntityNotFoundException(String.valueOf(refcraftsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(RefCrafts refCrafts) {
        LOGGER.debug("Deleting RefCrafts with {}", refCrafts);
        this.wmGenericDao.delete(refCrafts);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefCrafts> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefCrafts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefCrafts> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefCrafts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefCrafts to {} format", exportType);
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
    public Page<TblUserPsa> findAssociatedTblUserPsas(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated tblUserPsas");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("refCrafts.id = '" + id + "'");

        return tblUserPsaService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TblUserPsaService instance
	 */
	protected void setTblUserPsaService(TblUserPsaService service) {
        this.tblUserPsaService = service;
    }

}

