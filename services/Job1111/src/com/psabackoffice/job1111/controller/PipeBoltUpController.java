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

import com.psabackoffice.job1111.PipeBoltUp;
import com.psabackoffice.job1111.service.PipeBoltUpService;


/**
 * Controller object for domain model class PipeBoltUp.
 * @see PipeBoltUp
 */
@RestController("Job1111.PipeBoltUpController")
@Api(value = "PipeBoltUpController", description = "Exposes APIs to work with PipeBoltUp resource.")
@RequestMapping("/Job1111/PipeBoltUp")
public class PipeBoltUpController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PipeBoltUpController.class);

    @Autowired
	@Qualifier("Job1111.PipeBoltUpService")
	private PipeBoltUpService pipeBoltUpService;

	@ApiOperation(value = "Creates a new PipeBoltUp instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public PipeBoltUp createPipeBoltUp(@RequestBody PipeBoltUp pipeBoltUp) {
		LOGGER.debug("Create PipeBoltUp with information: {}" , pipeBoltUp);

		pipeBoltUp = pipeBoltUpService.create(pipeBoltUp);
		LOGGER.debug("Created PipeBoltUp with information: {}" , pipeBoltUp);

	    return pipeBoltUp;
	}


    @ApiOperation(value = "Returns the PipeBoltUp instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PipeBoltUp getPipeBoltUp(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting PipeBoltUp with id: {}" , id);

        PipeBoltUp foundPipeBoltUp = pipeBoltUpService.getById(id);
        LOGGER.debug("PipeBoltUp details with id: {}" , foundPipeBoltUp);

        return foundPipeBoltUp;
    }

    @ApiOperation(value = "Updates the PipeBoltUp instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public PipeBoltUp editPipeBoltUp(@PathVariable("id") Integer id, @RequestBody PipeBoltUp pipeBoltUp) throws EntityNotFoundException {
        LOGGER.debug("Editing PipeBoltUp with id: {}" , pipeBoltUp.getId());

        pipeBoltUp.setId(id);
        pipeBoltUp = pipeBoltUpService.update(pipeBoltUp);
        LOGGER.debug("PipeBoltUp details with id: {}" , pipeBoltUp);

        return pipeBoltUp;
    }

    @ApiOperation(value = "Deletes the PipeBoltUp instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePipeBoltUp(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting PipeBoltUp with id: {}" , id);

        PipeBoltUp deletedPipeBoltUp = pipeBoltUpService.delete(id);

        return deletedPipeBoltUp != null;
    }

    /**
     * @deprecated Use {@link #findPipeBoltUps(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of PipeBoltUp instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PipeBoltUp> searchPipeBoltUpsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering PipeBoltUps list");
        return pipeBoltUpService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PipeBoltUp instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PipeBoltUp> findPipeBoltUps(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PipeBoltUps list");
        return pipeBoltUpService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of PipeBoltUp instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PipeBoltUp> filterPipeBoltUps(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PipeBoltUps list");
        return pipeBoltUpService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPipeBoltUps(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return pipeBoltUpService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of PipeBoltUp instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPipeBoltUps( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting PipeBoltUps");
		return pipeBoltUpService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPipeBoltUpAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return pipeBoltUpService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PipeBoltUpService instance
	 */
	protected void setPipeBoltUpService(PipeBoltUpService service) {
		this.pipeBoltUpService = service;
	}

}
