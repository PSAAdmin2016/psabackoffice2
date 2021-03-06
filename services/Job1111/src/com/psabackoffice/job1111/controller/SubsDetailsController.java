/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.psabackoffice.job1111.SubmissionActivityStatus;
import com.psabackoffice.job1111.SubsDetails;
import com.psabackoffice.job1111.SubsSignatures;
import com.psabackoffice.job1111.service.SubsDetailsService;


/**
 * Controller object for domain model class SubsDetails.
 * @see SubsDetails
 */
@RestController("Job1111.SubsDetailsController")
@Api(value = "SubsDetailsController", description = "Exposes APIs to work with SubsDetails resource.")
@RequestMapping("/Job1111/SubsDetails")
public class SubsDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubsDetailsController.class);

    @Autowired
	@Qualifier("Job1111.SubsDetailsService")
	private SubsDetailsService subsDetailsService;

	@ApiOperation(value = "Creates a new SubsDetails instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SubsDetails createSubsDetails(@RequestBody SubsDetails subsDetails) {
		LOGGER.debug("Create SubsDetails with information: {}" , subsDetails);

		subsDetails = subsDetailsService.create(subsDetails);
		LOGGER.debug("Created SubsDetails with information: {}" , subsDetails);

	    return subsDetails;
	}

    @ApiOperation(value = "Returns the SubsDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public SubsDetails getSubsDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting SubsDetails with id: {}" , id);

        SubsDetails foundSubsDetails = subsDetailsService.getById(id);
        LOGGER.debug("SubsDetails details with id: {}" , foundSubsDetails);

        return foundSubsDetails;
    }

    @ApiOperation(value = "Updates the SubsDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SubsDetails editSubsDetails(@PathVariable("id") Integer id, @RequestBody SubsDetails subsDetails) {
        LOGGER.debug("Editing SubsDetails with id: {}" , subsDetails.getSubmissionId());

        subsDetails.setSubmissionId(id);
        subsDetails = subsDetailsService.update(subsDetails);
        LOGGER.debug("SubsDetails details with id: {}" , subsDetails);

        return subsDetails;
    }

    @ApiOperation(value = "Deletes the SubsDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteSubsDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting SubsDetails with id: {}" , id);

        SubsDetails deletedSubsDetails = subsDetailsService.delete(id);

        return deletedSubsDetails != null;
    }

    /**
     * @deprecated Use {@link #findSubsDetails(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SubsDetails instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubsDetails> searchSubsDetailsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SubsDetails list by query filter:{}", (Object) queryFilters);
        return subsDetailsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SubsDetails instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubsDetails> findSubsDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SubsDetails list by filter:", query);
        return subsDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SubsDetails instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubsDetails> filterSubsDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SubsDetails list by filter", query);
        return subsDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSubsDetails(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return subsDetailsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of SubsDetails instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSubsDetails( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SubsDetails");
		return subsDetailsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSubsDetailsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return subsDetailsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/submissionActivityStatuses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the submissionActivityStatuses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubmissionActivityStatus> findAssociatedSubmissionActivityStatuses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated submissionActivityStatuses");
        return subsDetailsService.findAssociatedSubmissionActivityStatuses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/subsSignatureses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the subsSignatureses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubsSignatures> findAssociatedSubsSignatureses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated subsSignatureses");
        return subsDetailsService.findAssociatedSubsSignatureses(id, pageable);
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

