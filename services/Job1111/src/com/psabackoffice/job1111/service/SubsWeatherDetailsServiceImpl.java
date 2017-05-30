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

import com.psabackoffice.job1111.SubsDetails;
import com.psabackoffice.job1111.SubsWeatherDetails;


/**
 * ServiceImpl object for domain model class SubsWeatherDetails.
 *
 * @see SubsWeatherDetails
 */
@Service("Job1111.SubsWeatherDetailsService")
public class SubsWeatherDetailsServiceImpl implements SubsWeatherDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubsWeatherDetailsServiceImpl.class);

    @Autowired
	@Qualifier("Job1111.SubsDetailsService")
	private SubsDetailsService subsDetailsService;

    @Autowired
    @Qualifier("Job1111.SubsWeatherDetailsDao")
    private WMGenericDao<SubsWeatherDetails, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SubsWeatherDetails, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SubsWeatherDetails create(SubsWeatherDetails subsWeatherDetails) {
        LOGGER.debug("Creating a new SubsWeatherDetails with information: {}", subsWeatherDetails);
        SubsWeatherDetails subsWeatherDetailsCreated = this.wmGenericDao.create(subsWeatherDetails);
        if(subsWeatherDetailsCreated.getSubsDetailses() != null) {
            for(SubsDetails subsDetailse : subsWeatherDetailsCreated.getSubsDetailses()) {
                subsDetailse.setSubsWeatherDetails(subsWeatherDetailsCreated);
                LOGGER.debug("Creating a new child SubsDetails with information: {}", subsDetailse);
                subsDetailsService.create(subsDetailse);
            }
        }
        return subsWeatherDetailsCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubsWeatherDetails getById(Integer subsweatherdetailsId) throws EntityNotFoundException {
        LOGGER.debug("Finding SubsWeatherDetails by id: {}", subsweatherdetailsId);
        SubsWeatherDetails subsWeatherDetails = this.wmGenericDao.findById(subsweatherdetailsId);
        if (subsWeatherDetails == null){
            LOGGER.debug("No SubsWeatherDetails found with id: {}", subsweatherdetailsId);
            throw new EntityNotFoundException(String.valueOf(subsweatherdetailsId));
        }
        return subsWeatherDetails;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubsWeatherDetails findById(Integer subsweatherdetailsId) {
        LOGGER.debug("Finding SubsWeatherDetails by id: {}", subsweatherdetailsId);
        return this.wmGenericDao.findById(subsweatherdetailsId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SubsWeatherDetails update(SubsWeatherDetails subsWeatherDetails) throws EntityNotFoundException {
        LOGGER.debug("Updating SubsWeatherDetails with information: {}", subsWeatherDetails);
        this.wmGenericDao.update(subsWeatherDetails);

        Integer subsweatherdetailsId = subsWeatherDetails.getId();

        return this.wmGenericDao.findById(subsweatherdetailsId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SubsWeatherDetails delete(Integer subsweatherdetailsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SubsWeatherDetails with id: {}", subsweatherdetailsId);
        SubsWeatherDetails deleted = this.wmGenericDao.findById(subsweatherdetailsId);
        if (deleted == null) {
            LOGGER.debug("No SubsWeatherDetails found with id: {}", subsweatherdetailsId);
            throw new EntityNotFoundException(String.valueOf(subsweatherdetailsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SubsWeatherDetails> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SubsWeatherDetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SubsWeatherDetails> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SubsWeatherDetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SubsWeatherDetails to {} format", exportType);
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
    public Page<SubsDetails> findAssociatedSubsDetailses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated subsDetailses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("subsWeatherDetails.id = '" + id + "'");

        return subsDetailsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SubsDetailsService instance
	 */
	protected void setSubsDetailsService(SubsDetailsService service) {
        this.subsDetailsService = service;
    }

}
