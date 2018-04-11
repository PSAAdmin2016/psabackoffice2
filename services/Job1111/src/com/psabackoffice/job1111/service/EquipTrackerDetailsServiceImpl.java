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

import com.psabackoffice.job1111.EquipFa;
import com.psabackoffice.job1111.EquipTrackerDetails;


/**
 * ServiceImpl object for domain model class EquipTrackerDetails.
 *
 * @see EquipTrackerDetails
 */
@Service("Job1111.EquipTrackerDetailsService")
@Validated
public class EquipTrackerDetailsServiceImpl implements EquipTrackerDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquipTrackerDetailsServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("Job1111.EquipFaService")
	private EquipFaService equipFaService;

    @Autowired
    @Qualifier("Job1111.EquipTrackerDetailsDao")
    private WMGenericDao<EquipTrackerDetails, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EquipTrackerDetails, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public EquipTrackerDetails create(EquipTrackerDetails equipTrackerDetails) {
        LOGGER.debug("Creating a new EquipTrackerDetails with information: {}", equipTrackerDetails);

        EquipTrackerDetails equipTrackerDetailsCreated = this.wmGenericDao.create(equipTrackerDetails);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(equipTrackerDetailsCreated);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public EquipTrackerDetails getById(Integer equiptrackerdetailsId) throws EntityNotFoundException {
        LOGGER.debug("Finding EquipTrackerDetails by id: {}", equiptrackerdetailsId);
        return this.wmGenericDao.findById(equiptrackerdetailsId);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public EquipTrackerDetails findById(Integer equiptrackerdetailsId) {
        LOGGER.debug("Finding EquipTrackerDetails by id: {}", equiptrackerdetailsId);
        try {
            return this.wmGenericDao.findById(equiptrackerdetailsId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No EquipTrackerDetails found with id: {}", equiptrackerdetailsId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public EquipTrackerDetails update(EquipTrackerDetails equipTrackerDetails) throws EntityNotFoundException {
        LOGGER.debug("Updating EquipTrackerDetails with information: {}", equipTrackerDetails);

        List<EquipFa> equipFas = equipTrackerDetails.getEquipFas();

        if(equipFas != null && Hibernate.isInitialized(equipFas)) {
            if(!equipFas.isEmpty()) {
                for(EquipFa _equipFa : equipFas) {
                    _equipFa.setEquipTrackerDetails(equipTrackerDetails);
                }
            }
        }

        this.wmGenericDao.update(equipTrackerDetails);
        this.wmGenericDao.refresh(equipTrackerDetails);

        // Deleting children which are not present in the list.
        if(equipFas != null && Hibernate.isInitialized(equipFas) && !equipFas.isEmpty()) {
            List<EquipFa> _remainingChildren = wmGenericDao.execute(
                session -> DaoUtils.findAllRemainingChildren(session, EquipFa.class,
                        new DaoUtils.ChildrenFilter("equipTrackerDetails", equipTrackerDetails, equipFas)));
            LOGGER.debug("Found {} detached children, deleting", _remainingChildren.size());
            for(EquipFa _equipFa : _remainingChildren) {
                equipFaService.delete(_equipFa);
            }
            equipTrackerDetails.setEquipFas(equipFas);
        }

        return equipTrackerDetails;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public EquipTrackerDetails delete(Integer equiptrackerdetailsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting EquipTrackerDetails with id: {}", equiptrackerdetailsId);
        EquipTrackerDetails deleted = this.wmGenericDao.findById(equiptrackerdetailsId);
        if (deleted == null) {
            LOGGER.debug("No EquipTrackerDetails found with id: {}", equiptrackerdetailsId);
            throw new EntityNotFoundException(String.valueOf(equiptrackerdetailsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public void delete(EquipTrackerDetails equipTrackerDetails) {
        LOGGER.debug("Deleting EquipTrackerDetails with {}", equipTrackerDetails);
        this.wmGenericDao.delete(equipTrackerDetails);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<EquipTrackerDetails> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all EquipTrackerDetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<EquipTrackerDetails> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all EquipTrackerDetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table EquipTrackerDetails to {} format", exportType);
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
    public Page<EquipFa> findAssociatedEquipFas(Integer uid, Pageable pageable) {
        LOGGER.debug("Fetching all associated equipFas");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("equipTrackerDetails.uid = '" + uid + "'");

        return equipFaService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EquipFaService instance
	 */
	protected void setEquipFaService(EquipFaService service) {
        this.equipFaService = service;
    }

}

