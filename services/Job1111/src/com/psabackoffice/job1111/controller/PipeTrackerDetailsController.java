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

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.psabackoffice.job1111.PipeFa;
import com.psabackoffice.job1111.PipeTrackerDetails;
import com.psabackoffice.job1111.service.PipeTrackerDetailsService;


/**
 * Controller object for domain model class PipeTrackerDetails.
 * @see PipeTrackerDetails
 */
@RestController("Job1111.PipeTrackerDetailsController")
@Api(value = "PipeTrackerDetailsController", description = "Exposes APIs to work with PipeTrackerDetails resource.")
@RequestMapping("/Job1111/PipeTrackerDetails")
public class PipeTrackerDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PipeTrackerDetailsController.class);

    @Autowired
	@Qualifier("Job1111.PipeTrackerDetailsService")
	private PipeTrackerDetailsService pipeTrackerDetailsService;

	@ApiOperation(value = "Creates a new PipeTrackerDetails instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PipeTrackerDetails createPipeTrackerDetails(@RequestBody PipeTrackerDetails pipeTrackerDetails) {
		LOGGER.debug("Create PipeTrackerDetails with information: {}" , pipeTrackerDetails);

		pipeTrackerDetails = pipeTrackerDetailsService.create(pipeTrackerDetails);
		LOGGER.debug("Created PipeTrackerDetails with information: {}" , pipeTrackerDetails);

	    return pipeTrackerDetails;
	}

    @ApiOperation(value = "Returns the PipeTrackerDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public PipeTrackerDetails getPipeTrackerDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting PipeTrackerDetails with id: {}" , id);

        PipeTrackerDetails foundPipeTrackerDetails = pipeTrackerDetailsService.getById(id);
        LOGGER.debug("PipeTrackerDetails details with id: {}" , foundPipeTrackerDetails);

        return foundPipeTrackerDetails;
    }

    @ApiOperation(value = "Updates the PipeTrackerDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PipeTrackerDetails editPipeTrackerDetails(@PathVariable("id") Integer id, @RequestBody PipeTrackerDetails pipeTrackerDetails) {
        LOGGER.debug("Editing PipeTrackerDetails with id: {}" , pipeTrackerDetails.getUid());

        pipeTrackerDetails.setUid(id);
        pipeTrackerDetails = pipeTrackerDetailsService.update(pipeTrackerDetails);
        LOGGER.debug("PipeTrackerDetails details with id: {}" , pipeTrackerDetails);

        return pipeTrackerDetails;
    }

    @ApiOperation(value = "Deletes the PipeTrackerDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deletePipeTrackerDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting PipeTrackerDetails with id: {}" , id);

        PipeTrackerDetails deletedPipeTrackerDetails = pipeTrackerDetailsService.delete(id);

        return deletedPipeTrackerDetails != null;
    }

    /**
     * @deprecated Use {@link #findPipeTrackerDetails(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of PipeTrackerDetails instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PipeTrackerDetails> searchPipeTrackerDetailsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering PipeTrackerDetails list by query filter:{}", (Object) queryFilters);
        return pipeTrackerDetailsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PipeTrackerDetails instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PipeTrackerDetails> findPipeTrackerDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PipeTrackerDetails list by filter:", query);
        return pipeTrackerDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PipeTrackerDetails instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PipeTrackerDetails> filterPipeTrackerDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PipeTrackerDetails list by filter", query);
        return pipeTrackerDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPipeTrackerDetails(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return pipeTrackerDetailsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of PipeTrackerDetails instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPipeTrackerDetails( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting PipeTrackerDetails");
		return pipeTrackerDetailsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPipeTrackerDetailsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return pipeTrackerDetailsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/pipeFas", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the pipeFas instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PipeFa> findAssociatedPipeFas(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated pipeFas");
        return pipeTrackerDetailsService.findAssociatedPipeFas(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PipeTrackerDetailsService instance
	 */
	protected void setPipeTrackerDetailsService(PipeTrackerDetailsService service) {
		this.pipeTrackerDetailsService = service;
	}

}

