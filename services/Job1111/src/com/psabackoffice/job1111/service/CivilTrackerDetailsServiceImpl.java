/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.service;

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

import com.psabackoffice.job1111.CivilFa;
import com.psabackoffice.job1111.CivilTrackerDetails;


/**
 * ServiceImpl object for domain model class CivilTrackerDetails.
 *
 * @see CivilTrackerDetails
 */
@Service("Job1111.CivilTrackerDetailsService")
@Validated
public class CivilTrackerDetailsServiceImpl implements CivilTrackerDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CivilTrackerDetailsServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("Job1111.CivilFaService")
	private CivilFaService civilFaService;

    @Autowired
    @Qualifier("Job1111.CivilTrackerDetailsDao")
    private WMGenericDao<CivilTrackerDetails, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CivilTrackerDetails, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public CivilTrackerDetails create(CivilTrackerDetails civilTrackerDetails) {
        LOGGER.debug("Creating a new CivilTrackerDetails with information: {}", civilTrackerDetails);

        CivilTrackerDetails civilTrackerDetailsCreated = this.wmGenericDao.create(civilTrackerDetails);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(civilTrackerDetailsCreated);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CivilTrackerDetails getById(Integer civiltrackerdetailsId) throws EntityNotFoundException {
        LOGGER.debug("Finding CivilTrackerDetails by id: {}", civiltrackerdetailsId);
        return this.wmGenericDao.findById(civiltrackerdetailsId);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public CivilTrackerDetails findById(Integer civiltrackerdetailsId) {
        LOGGER.debug("Finding CivilTrackerDetails by id: {}", civiltrackerdetailsId);
        try {
            return this.wmGenericDao.findById(civiltrackerdetailsId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No CivilTrackerDetails found with id: {}", civiltrackerdetailsId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public CivilTrackerDetails update(CivilTrackerDetails civilTrackerDetails) throws EntityNotFoundException {
        LOGGER.debug("Updating CivilTrackerDetails with information: {}", civilTrackerDetails);

        List<CivilFa> civilFas = civilTrackerDetails.getCivilFas();

        if(civilFas != null && Hibernate.isInitialized(civilFas)) {
            if(!civilFas.isEmpty()) {
                for(CivilFa _civilFa : civilFas) {
                    _civilFa.setCivilTrackerDetails(civilTrackerDetails);
                }
            }
        }

        this.wmGenericDao.update(civilTrackerDetails);
        this.wmGenericDao.refresh(civilTrackerDetails);

        // Deleting children which are not present in the list.
        if(civilFas != null && Hibernate.isInitialized(civilFas) && !civilFas.isEmpty()) {
            List<CivilFa> _remainingChildren = wmGenericDao.execute(
                session -> DaoUtils.findAllRemainingChildren(session, CivilFa.class,
                        new DaoUtils.ChildrenFilter("civilTrackerDetails", civilTrackerDetails, civilFas)));
            LOGGER.debug("Found {} detached children, deleting", _remainingChildren.size());
            for(CivilFa _civilFa : _remainingChildren) {
                civilFaService.delete(_civilFa);
            }
            civilTrackerDetails.setCivilFas(civilFas);
        }

        return civilTrackerDetails;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public CivilTrackerDetails delete(Integer civiltrackerdetailsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CivilTrackerDetails with id: {}", civiltrackerdetailsId);
        CivilTrackerDetails deleted = this.wmGenericDao.findById(civiltrackerdetailsId);
        if (deleted == null) {
            LOGGER.debug("No CivilTrackerDetails found with id: {}", civiltrackerdetailsId);
            throw new EntityNotFoundException(String.valueOf(civiltrackerdetailsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public void delete(CivilTrackerDetails civilTrackerDetails) {
        LOGGER.debug("Deleting CivilTrackerDetails with {}", civilTrackerDetails);
        this.wmGenericDao.delete(civilTrackerDetails);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<CivilTrackerDetails> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CivilTrackerDetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<CivilTrackerDetails> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CivilTrackerDetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table CivilTrackerDetails to {} format", exportType);
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

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<CivilFa> findAssociatedCivilFas(Integer uid, Pageable pageable) {
        LOGGER.debug("Fetching all associated civilFas");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("civilTrackerDetails.uid = '" + uid + "'");

        return civilFaService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CivilFaService instance
	 */
	protected void setCivilFaService(CivilFaService service) {
        this.civilFaService = service;
    }

}

