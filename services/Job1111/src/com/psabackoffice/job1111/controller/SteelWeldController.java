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

import com.psabackoffice.job1111.SteelWeld;
import com.psabackoffice.job1111.service.SteelWeldService;


/**
 * Controller object for domain model class SteelWeld.
 * @see SteelWeld
 */
@RestController("Job1111.SteelWeldController")
@Api(value = "SteelWeldController", description = "Exposes APIs to work with SteelWeld resource.")
@RequestMapping("/Job1111/SteelWeld")
public class SteelWeldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelWeldController.class);

    @Autowired
	@Qualifier("Job1111.SteelWeldService")
	private SteelWeldService steelWeldService;

	@ApiOperation(value = "Creates a new SteelWeld instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public SteelWeld createSteelWeld(@RequestBody SteelWeld steelWeld) {
		LOGGER.debug("Create SteelWeld with information: {}" , steelWeld);

		steelWeld = steelWeldService.create(steelWeld);
		LOGGER.debug("Created SteelWeld with information: {}" , steelWeld);

	    return steelWeld;
	}


    @ApiOperation(value = "Returns the SteelWeld instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelWeld getSteelWeld(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting SteelWeld with id: {}" , id);

        SteelWeld foundSteelWeld = steelWeldService.getById(id);
        LOGGER.debug("SteelWeld details with id: {}" , foundSteelWeld);

        return foundSteelWeld;
    }

    @ApiOperation(value = "Updates the SteelWeld instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelWeld editSteelWeld(@PathVariable("id") Integer id, @RequestBody SteelWeld steelWeld) throws EntityNotFoundException {
        LOGGER.debug("Editing SteelWeld with id: {}" , steelWeld.getId());

        steelWeld.setId(id);
        steelWeld = steelWeldService.update(steelWeld);
        LOGGER.debug("SteelWeld details with id: {}" , steelWeld);

        return steelWeld;
    }

    @ApiOperation(value = "Deletes the SteelWeld instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSteelWeld(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelWeld with id: {}" , id);

        SteelWeld deletedSteelWeld = steelWeldService.delete(id);

        return deletedSteelWeld != null;
    }

    /**
     * @deprecated Use {@link #findSteelWelds(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SteelWeld instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelWeld> searchSteelWeldsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SteelWelds list");
        return steelWeldService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelWeld instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelWeld> findSteelWelds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelWelds list");
        return steelWeldService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelWeld instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelWeld> filterSteelWelds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelWelds list");
        return steelWeldService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSteelWelds(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return steelWeldService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of SteelWeld instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSteelWelds( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SteelWelds");
		return steelWeldService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSteelWeldAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return steelWeldService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SteelWeldService instance
	 */
	protected void setSteelWeldService(SteelWeldService service) {
		this.steelWeldService = service;
	}

}

