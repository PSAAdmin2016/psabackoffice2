/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.psabackoffice.job1111.Ssnotes;
import com.psabackoffice.job1111.SubmissionStatus;
import com.psabackoffice.job1111.SubmissionStatusRev;
import com.psabackoffice.job1111.service.SubmissionStatusService;


/**
 * Controller object for domain model class SubmissionStatus.
 * @see SubmissionStatus
 */
@RestController("Job1111.SubmissionStatusController")
@Api(value = "SubmissionStatusController", description = "Exposes APIs to work with SubmissionStatus resource.")
@RequestMapping("/Job1111/SubmissionStatus")
public class SubmissionStatusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubmissionStatusController.class);

    @Autowired
	@Qualifier("Job1111.SubmissionStatusService")
	private SubmissionStatusService submissionStatusService;

	@ApiOperation(value = "Creates a new SubmissionStatus instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public SubmissionStatus createSubmissionStatus(@RequestBody SubmissionStatus submissionStatus) {
		LOGGER.debug("Create SubmissionStatus with information: {}" , submissionStatus);

		submissionStatus = submissionStatusService.create(submissionStatus);
		LOGGER.debug("Created SubmissionStatus with information: {}" , submissionStatus);

	    return submissionStatus;
	}


    @ApiOperation(value = "Returns the SubmissionStatus instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SubmissionStatus getSubmissionStatus(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting SubmissionStatus with id: {}" , id);

        SubmissionStatus foundSubmissionStatus = submissionStatusService.getById(id);
        LOGGER.debug("SubmissionStatus details with id: {}" , foundSubmissionStatus);

        return foundSubmissionStatus;
    }

    @ApiOperation(value = "Updates the SubmissionStatus instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SubmissionStatus editSubmissionStatus(@PathVariable("id") Integer id, @RequestBody SubmissionStatus submissionStatus) throws EntityNotFoundException {
        LOGGER.debug("Editing SubmissionStatus with id: {}" , submissionStatus.getPsaactivityId());

        submissionStatus.setPsaactivityId(id);
        submissionStatus = submissionStatusService.update(submissionStatus);
        LOGGER.debug("SubmissionStatus details with id: {}" , submissionStatus);

        return submissionStatus;
    }

    @ApiOperation(value = "Deletes the SubmissionStatus instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSubmissionStatus(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting SubmissionStatus with id: {}" , id);

        SubmissionStatus deletedSubmissionStatus = submissionStatusService.delete(id);

        return deletedSubmissionStatus != null;
    }

    /**
     * @deprecated Use {@link #findSubmissionStatuses(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SubmissionStatus instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubmissionStatus> searchSubmissionStatusesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SubmissionStatuses list");
        return submissionStatusService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SubmissionStatus instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubmissionStatus> findSubmissionStatuses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SubmissionStatuses list");
        return submissionStatusService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SubmissionStatus instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubmissionStatus> filterSubmissionStatuses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SubmissionStatuses list");
        return submissionStatusService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSubmissionStatuses(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return submissionStatusService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of SubmissionStatus instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSubmissionStatuses( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SubmissionStatuses");
		return submissionStatusService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSubmissionStatusAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return submissionStatusService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/ssnoteses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the ssnoteses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Ssnotes> findAssociatedSsnoteses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated ssnoteses");
        return submissionStatusService.findAssociatedSsnoteses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/submissionStatusRevs", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the submissionStatusRevs instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubmissionStatusRev> findAssociatedSubmissionStatusRevs(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated submissionStatusRevs");
        return submissionStatusService.findAssociatedSubmissionStatusRevs(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SubmissionStatusService instance
	 */
	protected void setSubmissionStatusService(SubmissionStatusService service) {
		this.submissionStatusService = service;
	}

}

