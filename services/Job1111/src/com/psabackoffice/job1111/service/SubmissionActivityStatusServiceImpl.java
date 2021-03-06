/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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
import com.psabackoffice.job1111.CivilSellPackage;
import com.psabackoffice.job1111.EquipFa;
import com.psabackoffice.job1111.PipeFa;
import com.psabackoffice.job1111.PipeMisc;
import com.psabackoffice.job1111.PipeTesting;
import com.psabackoffice.job1111.PipeWeld;
import com.psabackoffice.job1111.Sasnotes;
import com.psabackoffice.job1111.SteelDemo;
import com.psabackoffice.job1111.SteelFa;
import com.psabackoffice.job1111.SteelMisc;
import com.psabackoffice.job1111.SteelSellPackage;
import com.psabackoffice.job1111.SubmissionActivityStatus;
import com.psabackoffice.job1111.SubsDelay;
import com.psabackoffice.job1111.SubsEwo;


/**
 * ServiceImpl object for domain model class SubmissionActivityStatus.
 *
 * @see SubmissionActivityStatus
 */
@Service("Job1111.SubmissionActivityStatusService")
@Validated
public class SubmissionActivityStatusServiceImpl implements SubmissionActivityStatusService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubmissionActivityStatusServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("Job1111.SasnotesService")
	private SasnotesService sasnotesService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.PipeMiscService")
	private PipeMiscService pipeMiscService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.SubsDelayService")
	private SubsDelayService subsDelayService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.EquipFaService")
	private EquipFaService equipFaService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.SteelMiscService")
	private SteelMiscService steelMiscService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.PipeTestingService")
	private PipeTestingService pipeTestingService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.SubsEwoService")
	private SubsEwoService subsEwoService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.PipeWeldService")
	private PipeWeldService pipeWeldService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.CivilSellPackageService")
	private CivilSellPackageService civilSellPackageService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.CivilFaService")
	private CivilFaService civilFaService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.SteelFaService")
	private SteelFaService steelFaService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.SteelDemoService")
	private SteelDemoService steelDemoService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.PipeFaService")
	private PipeFaService pipeFaService;

    @Lazy
    @Autowired
	@Qualifier("Job1111.SteelSellPackageService")
	private SteelSellPackageService steelSellPackageService;

    @Autowired
    @Qualifier("Job1111.SubmissionActivityStatusDao")
    private WMGenericDao<SubmissionActivityStatus, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SubmissionActivityStatus, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Job1111TransactionManager")
    @Override
	public SubmissionActivityStatus create(SubmissionActivityStatus submissionActivityStatus) {
        LOGGER.debug("Creating a new SubmissionActivityStatus with information: {}", submissionActivityStatus);

        SubmissionActivityStatus submissionActivityStatusCreated = this.wmGenericDao.create(submissionActivityStatus);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(submissionActivityStatusCreated);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubmissionActivityStatus getById(Integer submissionactivitystatusId) {
        LOGGER.debug("Finding SubmissionActivityStatus by id: {}", submissionactivitystatusId);
        return this.wmGenericDao.findById(submissionactivitystatusId);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public SubmissionActivityStatus findById(Integer submissionactivitystatusId) {
        LOGGER.debug("Finding SubmissionActivityStatus by id: {}", submissionactivitystatusId);
        try {
            return this.wmGenericDao.findById(submissionactivitystatusId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No SubmissionActivityStatus found with id: {}", submissionactivitystatusId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Job1111TransactionManager")
	@Override
	public SubmissionActivityStatus update(SubmissionActivityStatus submissionActivityStatus) {
        LOGGER.debug("Updating SubmissionActivityStatus with information: {}", submissionActivityStatus);

        CivilFa civilFa = submissionActivityStatus.getCivilFa();
        CivilSellPackage civilSellPackage = submissionActivityStatus.getCivilSellPackage();
        EquipFa equipFa = submissionActivityStatus.getEquipFa();
        PipeFa pipeFa = submissionActivityStatus.getPipeFa();
        PipeMisc pipeMisc = submissionActivityStatus.getPipeMisc();
        PipeTesting pipeTesting = submissionActivityStatus.getPipeTesting();
        PipeWeld pipeWeld = submissionActivityStatus.getPipeWeld();
        List<Sasnotes> sasnoteses = submissionActivityStatus.getSasnoteses();
        SteelDemo steelDemo = submissionActivityStatus.getSteelDemo();
        SteelFa steelFa = submissionActivityStatus.getSteelFa();
        SteelMisc steelMisc = submissionActivityStatus.getSteelMisc();
        SteelSellPackage steelSellPackage = submissionActivityStatus.getSteelSellPackage();
        SubsDelay subsDelay = submissionActivityStatus.getSubsDelay();
        List<SubsEwo> subsEwos = submissionActivityStatus.getSubsEwos();
        if(civilFa != null && Hibernate.isInitialized(civilFa)) {
            civilFa.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(civilSellPackage != null && Hibernate.isInitialized(civilSellPackage)) {
            civilSellPackage.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(equipFa != null && Hibernate.isInitialized(equipFa)) {
            equipFa.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(pipeFa != null && Hibernate.isInitialized(pipeFa)) {
            pipeFa.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(pipeMisc != null && Hibernate.isInitialized(pipeMisc)) {
            pipeMisc.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(pipeTesting != null && Hibernate.isInitialized(pipeTesting)) {
            pipeTesting.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(pipeWeld != null && Hibernate.isInitialized(pipeWeld)) {
            pipeWeld.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(sasnoteses != null && Hibernate.isInitialized(sasnoteses)) {
            sasnoteses.forEach(_sasnotes -> _sasnotes.setSubmissionActivityStatus(submissionActivityStatus));
        }
        if(steelDemo != null && Hibernate.isInitialized(steelDemo)) {
            steelDemo.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(steelFa != null && Hibernate.isInitialized(steelFa)) {
            steelFa.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(steelMisc != null && Hibernate.isInitialized(steelMisc)) {
            steelMisc.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(steelSellPackage != null && Hibernate.isInitialized(steelSellPackage)) {
            steelSellPackage.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(subsDelay != null && Hibernate.isInitialized(subsDelay)) {
            subsDelay.setSubmissionActivityStatus(submissionActivityStatus);
        }
        if(subsEwos != null && Hibernate.isInitialized(subsEwos)) {
            subsEwos.forEach(_subsEwo -> _subsEwo.setSubmissionActivityStatus(submissionActivityStatus));
        }

        this.wmGenericDao.update(submissionActivityStatus);
        this.wmGenericDao.refresh(submissionActivityStatus);

        // Deleting children which are not present in the list.
        if(sasnoteses != null && Hibernate.isInitialized(sasnoteses) && !sasnoteses.isEmpty()) {
            List<Sasnotes> _remainingChildren = wmGenericDao.execute(
                session -> DaoUtils.findAllRemainingChildren(session, Sasnotes.class,
                        new DaoUtils.ChildrenFilter<>("submissionActivityStatus", submissionActivityStatus, sasnoteses)));
            LOGGER.debug("Found {} detached children, deleting", _remainingChildren.size());
            _remainingChildren.forEach(_sasnotes -> sasnotesService.delete(_sasnotes));
            submissionActivityStatus.setSasnoteses(sasnoteses);
        }

        // Deleting children which are not present in the list.
        if(subsEwos != null && Hibernate.isInitialized(subsEwos) && !subsEwos.isEmpty()) {
            List<SubsEwo> _remainingChildren = wmGenericDao.execute(
                session -> DaoUtils.findAllRemainingChildren(session, SubsEwo.class,
                        new DaoUtils.ChildrenFilter<>("submissionActivityStatus", submissionActivityStatus, subsEwos)));
            LOGGER.debug("Found {} detached children, deleting", _remainingChildren.size());
            _remainingChildren.forEach(_subsEwo -> subsEwoService.delete(_subsEwo));
            submissionActivityStatus.setSubsEwos(subsEwos);
        }

        return submissionActivityStatus;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public SubmissionActivityStatus delete(Integer submissionactivitystatusId) {
        LOGGER.debug("Deleting SubmissionActivityStatus with id: {}", submissionactivitystatusId);
        SubmissionActivityStatus deleted = this.wmGenericDao.findById(submissionactivitystatusId);
        if (deleted == null) {
            LOGGER.debug("No SubmissionActivityStatus found with id: {}", submissionactivitystatusId);
            throw new EntityNotFoundException(String.valueOf(submissionactivitystatusId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "Job1111TransactionManager")
	@Override
	public void delete(SubmissionActivityStatus submissionActivityStatus) {
        LOGGER.debug("Deleting SubmissionActivityStatus with {}", submissionActivityStatus);
        this.wmGenericDao.delete(submissionActivityStatus);
    }

	@Transactional(readOnly = true, value = "Job1111TransactionManager")
	@Override
	public Page<SubmissionActivityStatus> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SubmissionActivityStatuses");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SubmissionActivityStatus> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SubmissionActivityStatuses");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Job1111 for table SubmissionActivityStatus to {} format", exportType);
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
    public Page<Sasnotes> findAssociatedSasnoteses(Integer activityId, Pageable pageable) {
        LOGGER.debug("Fetching all associated sasnoteses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("submissionActivityStatus.activityId = '" + activityId + "'");

        return sasnotesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "Job1111TransactionManager")
    @Override
    public Page<SubsEwo> findAssociatedSubsEwos(Integer activityId, Pageable pageable) {
        LOGGER.debug("Fetching all associated subsEwos");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("submissionActivityStatus.activityId = '" + activityId + "'");

        return subsEwoService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SasnotesService instance
	 */
	protected void setSasnotesService(SasnotesService service) {
        this.sasnotesService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PipeMiscService instance
	 */
	protected void setPipeMiscService(PipeMiscService service) {
        this.pipeMiscService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SubsDelayService instance
	 */
	protected void setSubsDelayService(SubsDelayService service) {
        this.subsDelayService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EquipFaService instance
	 */
	protected void setEquipFaService(EquipFaService service) {
        this.equipFaService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SteelMiscService instance
	 */
	protected void setSteelMiscService(SteelMiscService service) {
        this.steelMiscService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PipeTestingService instance
	 */
	protected void setPipeTestingService(PipeTestingService service) {
        this.pipeTestingService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SubsEwoService instance
	 */
	protected void setSubsEwoService(SubsEwoService service) {
        this.subsEwoService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PipeWeldService instance
	 */
	protected void setPipeWeldService(PipeWeldService service) {
        this.pipeWeldService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CivilSellPackageService instance
	 */
	protected void setCivilSellPackageService(CivilSellPackageService service) {
        this.civilSellPackageService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CivilFaService instance
	 */
	protected void setCivilFaService(CivilFaService service) {
        this.civilFaService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SteelFaService instance
	 */
	protected void setSteelFaService(SteelFaService service) {
        this.steelFaService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SteelDemoService instance
	 */
	protected void setSteelDemoService(SteelDemoService service) {
        this.steelDemoService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PipeFaService instance
	 */
	protected void setPipeFaService(PipeFaService service) {
        this.pipeFaService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SteelSellPackageService instance
	 */
	protected void setSteelSellPackageService(SteelSellPackageService service) {
        this.steelSellPackageService = service;
    }

}

