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

import com.psabackoffice.job1111.SubsWeld;
import com.psabackoffice.job1111.SubsWeldRev;


/**
 * ServiceImpl object for domain model class SubsWeld.
 *
 * @see SubsWeld
 */
@Service("Job1111.SubsWeldService")
public class SubsWeldServiceImpl implements SubsWeldService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubsWeldServiceImpl.class);

    @Autowired
	@Qualifier("Job1111.SubsWeldRevService")
	private SubsWeldRevService subsWeldRevService;

    @Autowired
    @Qualifier("Job1111.SubsWeldDao")
    private WMGenericDao<SubsWeld, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SubsWeld, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SubsWeld create(SubsWeld subsWeld) {
        LOGGER.debug("Creating a new SubsWeld with information: {}", subsWeld);
        SubsWeld subsWeldCreated = this.wmGenericDao.create(subsWeld);
        if(subsWeldCreated.getSubsWeldRevs() != null) {
            for(SubsWeldRev subsWeldRev : subsWeldCreated.getSubsWeldRevs()) {
                subsWeldRev.setSubsWeld(subsWeldCreated);
                LOGGER.debug("Creating a new child SubsWeldRev with information: {}", subsWeldRev);
                subsWeldRevService.create(subsWeldRev);
            }
        }
        return subsWeldCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubsWeld getById(Integer subsweldId) throws EntityNotFoundException {
        LOGGER.debug("Finding SubsWeld by id: {}", subsweldId);
        SubsWeld subsWeld = this.wmGenericDao.findById(subsweldId);
        if (subsWeld == null){
            LOGGER.debug("No SubsWeld found with id: {}", subsweldId);
            throw new EntityNotFoundException(String.valueOf(subsweldId));
        }
        return subsWeld;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubsWeld findById(Integer subsweldId) {
        LOGGER.debug("Finding SubsWeld by id: {}", subsweldId);
        return this.wmGenericDao.findById(subsweldId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SubsWeld update(SubsWeld subsWeld) throws EntityNotFoundException {
        LOGGER.debug("Updating SubsWeld with information: {}", subsWeld);
        this.wmGenericDao.update(subsWeld);

        Integer subsweldId = subsWeld.getId();

        return this.wmGenericDao.findById(subsweldId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SubsWeld delete(Integer subsweldId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SubsWeld with id: {}", subsweldId);
        SubsWeld deleted = this.wmGenericDao.findById(subsweldId);
        if (deleted == null) {
            LOGGER.debug("No SubsWeld found with id: {}", subsweldId);
            throw new EntityNotFoundException(String.valueOf(subsweldId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SubsWeld> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SubsWelds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SubsWeld> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SubsWelds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SubsWeld to {} format", exportType);
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
    public Page<SubsWeldRev> findAssociatedSubsWeldRevs(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated subsWeldRevs");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("subsWeld.id = '" + id + "'");

        return subsWeldRevService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SubsWeldRevService instance
	 */
	protected void setSubsWeldRevService(SubsWeldRevService service) {
        this.subsWeldRevService = service;
    }

}

