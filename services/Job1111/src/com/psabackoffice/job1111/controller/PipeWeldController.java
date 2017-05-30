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

import com.psabackoffice.job1111.PipeWeld;
import com.psabackoffice.job1111.service.PipeWeldService;


/**
 * Controller object for domain model class PipeWeld.
 * @see PipeWeld
 */
@RestController("Job1111.PipeWeldController")
@Api(value = "PipeWeldController", description = "Exposes APIs to work with PipeWeld resource.")
@RequestMapping("/Job1111/PipeWeld")
public class PipeWeldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PipeWeldController.class);

    @Autowired
	@Qualifier("Job1111.PipeWeldService")
	private PipeWeldService pipeWeldService;

	@ApiOperation(value = "Creates a new PipeWeld instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public PipeWeld createPipeWeld(@RequestBody PipeWeld pipeWeld) {
		LOGGER.debug("Create PipeWeld with information: {}" , pipeWeld);

		pipeWeld = pipeWeldService.create(pipeWeld);
		LOGGER.debug("Created PipeWeld with information: {}" , pipeWeld);

	    return pipeWeld;
	}


    @ApiOperation(value = "Returns the PipeWeld instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PipeWeld getPipeWeld(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting PipeWeld with id: {}" , id);

        PipeWeld foundPipeWeld = pipeWeldService.getById(id);
        LOGGER.debug("PipeWeld details with id: {}" , foundPipeWeld);

        return foundPipeWeld;
    }

    @ApiOperation(value = "Updates the PipeWeld instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PipeWeld editPipeWeld(@PathVariable("id") Integer id, @RequestBody PipeWeld pipeWeld) throws EntityNotFoundException {
        LOGGER.debug("Editing PipeWeld with id: {}" , pipeWeld.getId());

        pipeWeld.setId(id);
        pipeWeld = pipeWeldService.update(pipeWeld);
        LOGGER.debug("PipeWeld details with id: {}" , pipeWeld);

        return pipeWeld;
    }

    @ApiOperation(value = "Deletes the PipeWeld instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePipeWeld(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting PipeWeld with id: {}" , id);

        PipeWeld deletedPipeWeld = pipeWeldService.delete(id);

        return deletedPipeWeld != null;
    }

    /**
     * @deprecated Use {@link #findPipeWelds(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of PipeWeld instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PipeWeld> searchPipeWeldsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering PipeWelds list");
        return pipeWeldService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PipeWeld instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PipeWeld> findPipeWelds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PipeWelds list");
        return pipeWeldService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PipeWeld instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PipeWeld> filterPipeWelds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PipeWelds list");
        return pipeWeldService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPipeWelds(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return pipeWeldService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of PipeWeld instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPipeWelds( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting PipeWelds");
		return pipeWeldService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPipeWeldAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return pipeWeldService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PipeWeldService instance
	 */
	protected void setPipeWeldService(PipeWeldService service) {
		this.pipeWeldService = service;
	}

}
