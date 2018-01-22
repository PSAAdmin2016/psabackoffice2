/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.psabackoffice.psa.TblCrews;
import com.psabackoffice.psa.TblCrewsRev;


/**
 * ServiceImpl object for domain model class TblCrews.
 *
 * @see TblCrews
 */
@Service("PSA.TblCrewsService")
@Validated
public class TblCrewsServiceImpl implements TblCrewsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TblCrewsServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("PSA.TblCrewsRevService")
	private TblCrewsRevService tblCrewsRevService;

    @Autowired
    @Qualifier("PSA.TblCrewsDao")
    private WMGenericDao<TblCrews, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TblCrews, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public TblCrews create(TblCrews tblCrews) {
        LOGGER.debug("Creating a new TblCrews with information: {}", tblCrews);
        List<TblCrewsRev> tblCrewsRevs = tblCrews.getTblCrewsRevs();

        TblCrews tblCrewsCreated = this.wmGenericDao.create(tblCrews);
        if(tblCrewsRevs != null) {
            for(TblCrewsRev _tblCrewsRev : tblCrewsRevs) {
                _tblCrewsRev.setTblCrews(tblCrewsCreated);
                LOGGER.debug("Creating a new child TblCrewsRev with information: {}", _tblCrewsRev);
                tblCrewsRevService.create(_tblCrewsRev);
            }
        }
        return tblCrewsCreated;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public TblCrews getById(Integer tblcrewsId) throws EntityNotFoundException {
        LOGGER.debug("Finding TblCrews by id: {}", tblcrewsId);
        TblCrews tblCrews = this.wmGenericDao.findById(tblcrewsId);
        if (tblCrews == null){
            LOGGER.debug("No TblCrews found with id: {}", tblcrewsId);
            throw new EntityNotFoundException(String.valueOf(tblcrewsId));
        }
        return tblCrews;
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public TblCrews findById(Integer tblcrewsId) {
        LOGGER.debug("Finding TblCrews by id: {}", tblcrewsId);
        return this.wmGenericDao.findById(tblcrewsId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public TblCrews getByForeman(Integer foreman) {
        Map<String, Object> foremanMap = new HashMap<>();
        foremanMap.put("foreman", foreman);

        LOGGER.debug("Finding TblCrews by unique keys: {}", foremanMap);
        TblCrews tblCrews = this.wmGenericDao.findByUniqueKey(foremanMap);

        if (tblCrews == null){
            LOGGER.debug("No TblCrews found with given unique key values: {}", foremanMap);
            throw new EntityNotFoundException(String.valueOf(foremanMap));
        }

        return tblCrews;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public TblCrews update(TblCrews tblCrews) throws EntityNotFoundException {
        LOGGER.debug("Updating TblCrews with information: {}", tblCrews);
        this.wmGenericDao.update(tblCrews);

        Integer tblcrewsId = tblCrews.getId();

        return this.wmGenericDao.findById(tblcrewsId);
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public TblCrews delete(Integer tblcrewsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TblCrews with id: {}", tblcrewsId);
        TblCrews deleted = this.wmGenericDao.findById(tblcrewsId);
        if (deleted == null) {
            LOGGER.debug("No TblCrews found with id: {}", tblcrewsId);
            throw new EntityNotFoundException(String.valueOf(tblcrewsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<TblCrews> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TblCrews");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<TblCrews> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TblCrews");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table TblCrews to {} format", exportType);
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
    public Page<TblCrewsRev> findAssociatedTblCrewsRevs(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated tblCrewsRevs");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("tblCrews.id = '" + id + "'");

        return tblCrewsRevService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TblCrewsRevService instance
	 */
	protected void setTblCrewsRevService(TblCrewsRevService service) {
        this.tblCrewsRevService = service;
    }

}

