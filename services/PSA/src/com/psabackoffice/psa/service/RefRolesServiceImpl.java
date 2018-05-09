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
import com.wavemaker.runtime.data.util.DaoUtils;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.psa.RefRoles;
import com.psabackoffice.psa.TblUserRoles;


/**
 * ServiceImpl object for domain model class RefRoles.
 *
 * @see RefRoles
 */
@Service("PSA.RefRolesService")
@Validated
public class RefRolesServiceImpl implements RefRolesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefRolesServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("PSA.TblUserRolesService")
	private TblUserRolesService tblUserRolesService;

    @Autowired
    @Qualifier("PSA.RefRolesDao")
    private WMGenericDao<RefRoles, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RefRoles, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "PSATransactionManager")
    @Override
	public RefRoles create(RefRoles refRoles) {
        LOGGER.debug("Creating a new RefRoles with information: {}", refRoles);

        RefRoles refRolesCreated = this.wmGenericDao.create(refRoles);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(refRolesCreated);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefRoles getById(Integer refrolesId) {
        LOGGER.debug("Finding RefRoles by id: {}", refrolesId);
        return this.wmGenericDao.findById(refrolesId);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public RefRoles findById(Integer refrolesId) {
        LOGGER.debug("Finding RefRoles by id: {}", refrolesId);
        try {
            return this.wmGenericDao.findById(refrolesId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No RefRoles found with id: {}", refrolesId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "PSATransactionManager")
	@Override
	public RefRoles update(RefRoles refRoles) {
        LOGGER.debug("Updating RefRoles with information: {}", refRoles);

        List<TblUserRoles> tblUserRoleses = refRoles.getTblUserRoleses();
        if(tblUserRoleses != null && Hibernate.isInitialized(tblUserRoleses)) {
            tblUserRoleses.forEach(_tblUserRoles -> _tblUserRoles.setRefRoles(refRoles));
        }

        this.wmGenericDao.update(refRoles);
        this.wmGenericDao.refresh(refRoles);

        // Deleting children which are not present in the list.
        if(tblUserRoleses != null && Hibernate.isInitialized(tblUserRoleses) && !tblUserRoleses.isEmpty()) {
            List<TblUserRoles> _remainingChildren = wmGenericDao.execute(
                session -> DaoUtils.findAllRemainingChildren(session, TblUserRoles.class,
                        new DaoUtils.ChildrenFilter<>("refRoles", refRoles, tblUserRoleses)));
            LOGGER.debug("Found {} detached children, deleting", _remainingChildren.size());
            _remainingChildren.forEach(_tblUserRoles -> tblUserRolesService.delete(_tblUserRoles));
            refRoles.setTblUserRoleses(tblUserRoleses);
        }

        return refRoles;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public RefRoles delete(Integer refrolesId) {
        LOGGER.debug("Deleting RefRoles with id: {}", refrolesId);
        RefRoles deleted = this.wmGenericDao.findById(refrolesId);
        if (deleted == null) {
            LOGGER.debug("No RefRoles found with id: {}", refrolesId);
            throw new EntityNotFoundException(String.valueOf(refrolesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "PSATransactionManager")
	@Override
	public void delete(RefRoles refRoles) {
        LOGGER.debug("Deleting RefRoles with {}", refRoles);
        this.wmGenericDao.delete(refRoles);
    }

	@Transactional(readOnly = true, value = "PSATransactionManager")
	@Override
	public Page<RefRoles> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RefRoles");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Page<RefRoles> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RefRoles");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "PSATransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service PSA for table RefRoles to {} format", exportType);
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
    public Page<TblUserRoles> findAssociatedTblUserRoleses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated tblUserRoleses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("refRoles.id = '" + id + "'");

        return tblUserRolesService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TblUserRolesService instance
	 */
	protected void setTblUserRolesService(TblUserRolesService service) {
        this.tblUserRolesService = service;
    }

}

