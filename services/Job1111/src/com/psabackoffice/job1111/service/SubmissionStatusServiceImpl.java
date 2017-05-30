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

import com.psabackoffice.job1111.Ssnotes;
import com.psabackoffice.job1111.SubmissionStatus;
import com.psabackoffice.job1111.SubmissionStatusRev;


/**
 * ServiceImpl object for domain model class SubmissionStatus.
 *
 * @see SubmissionStatus
 */
@Service("Job1111.SubmissionStatusService")
public class SubmissionStatusServiceImpl implements SubmissionStatusService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubmissionStatusServiceImpl.class);

    @Autowired
	@Qualifier("Job1111.SubmissionStatusRevService")
	private SubmissionStatusRevService submissionStatusRevService;

    @Autowired
	@Qualifier("Job1111.SsnotesService")
	private SsnotesService ssnotesService;

    @Autowired
    @Qualifier("Job1111.SubmissionStatusDao")
    private WMGenericDao<SubmissionStatus, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SubmissionStatus, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SubmissionStatus create(SubmissionStatus submissionStatus) {
        LOGGER.debug("Creating a new SubmissionStatus with information: {}", submissionStatus);
        SubmissionStatus submissionStatusCreated = this.wmGenericDao.create(submissionStatus);
        if(submissionStatusCreated.getSsnoteses() != null) {
            for(Ssnotes ssnotese : submissionStatusCreated.getSsnoteses()) {
                ssnotese.setSubmissionStatus(submissionStatusCreated);
                LOGGER.debug("Creating a new child Ssnotes with information: {}", ssnotese);
                ssnotesService.create(ssnotese);
            }
        }

        if(submissionStatusCreated.getSubmissionStatusRevs() != null) {
            for(SubmissionStatusRev submissionStatusRev : submissionStatusCreated.getSubmissionStatusRevs()) {
                submissionStatusRev.setSubmissionStatus(submissionStatusCreated);
                LOGGER.debug("Creating a new child SubmissionStatusRev with information: {}", submissionStatusRev);
                submissionStatusRevService.create(submissionStatusRev);
            }
        }
        return submissionStatusCreated;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubmissionStatus getById(Integer submissionstatusId) throws EntityNotFoundException {
        LOGGER.debug("Finding SubmissionStatus by id: {}", submissionstatusId);
        SubmissionStatus submissionStatus = this.wmGenericDao.findById(submissionstatusId);
        if (submissionStatus == null){
            LOGGER.debug("No SubmissionStatus found with id: {}", submissionstatusId);
            throw new EntityNotFoundException(String.valueOf(submissionstatusId));
        }
        return submissionStatus;
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubmissionStatus findById(Integer submissionstatusId) {
        LOGGER.debug("Finding SubmissionStatus by id: {}", submissionstatusId);
        return this.wmGenericDao.findById(submissionstatusId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SubmissionStatus update(SubmissionStatus submissionStatus) throws EntityNotFoundException {
        LOGGER.debug("Updating SubmissionStatus with information: {}", submissionStatus);
        this.wmGenericDao.update(submissionStatus);

        Integer submissionstatusId = submissionStatus.getPsaactivityId();

        return this.wmGenericDao.findById(submissionstatusId);
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SubmissionStatus delete(Integer submissionstatusId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SubmissionStatus with id: {}", submissionstatusId);
        SubmissionStatus deleted = this.wmGenericDao.findById(submissionstatusId);
        if (deleted == null) {
            LOGGER.debug("No SubmissionStatus found with id: {}", submissionstatusId);
            throw new EntityNotFoundException(String.valueOf(submissionstatusId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SubmissionStatus> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SubmissionStatuses");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SubmissionStatus> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SubmissionStatuses");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SubmissionStatus to {} format", exportType);
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
    public Page<Ssnotes> findAssociatedSsnoteses(Integer psaactivityId, Pageable pageable) {
        LOGGER.debug("Fetching all associated ssnoteses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("submissionStatus.psaactivityId = '" + psaactivityId + "'");

        return ssnotesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SubmissionStatusRev> findAssociatedSubmissionStatusRevs(Integer psaactivityId, Pageable pageable) {
        LOGGER.debug("Fetching all associated submissionStatusRevs");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("submissionStatus.psaactivityId = '" + psaactivityId + "'");

        return submissionStatusRevService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SubmissionStatusRevService instance
	 */
	protected void setSubmissionStatusRevService(SubmissionStatusRevService service) {
        this.submissionStatusRevService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SsnotesService instance
	 */
	protected void setSsnotesService(SsnotesService service) {
        this.ssnotesService = service;
    }

}

