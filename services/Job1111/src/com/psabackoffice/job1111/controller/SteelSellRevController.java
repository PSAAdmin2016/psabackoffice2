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

import com.psabackoffice.job1111.SteelSellRev;
import com.psabackoffice.job1111.service.SteelSellRevService;


/**
 * Controller object for domain model class SteelSellRev.
 * @see SteelSellRev
 */
@RestController("Job1111.SteelSellRevController")
@Api(value = "SteelSellRevController", description = "Exposes APIs to work with SteelSellRev resource.")
@RequestMapping("/Job1111/SteelSellRev")
public class SteelSellRevController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelSellRevController.class);

    @Autowired
	@Qualifier("Job1111.SteelSellRevService")
	private SteelSellRevService steelSellRevService;

	@ApiOperation(value = "Creates a new SteelSellRev instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public SteelSellRev createSteelSellRev(@RequestBody SteelSellRev steelSellRev) {
		LOGGER.debug("Create SteelSellRev with information: {}" , steelSellRev);

		steelSellRev = steelSellRevService.create(steelSellRev);
		LOGGER.debug("Created SteelSellRev with information: {}" , steelSellRev);

	    return steelSellRev;
	}


    @ApiOperation(value = "Returns the SteelSellRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelSellRev getSteelSellRev(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting SteelSellRev with id: {}" , id);

        SteelSellRev foundSteelSellRev = steelSellRevService.getById(id);
        LOGGER.debug("SteelSellRev details with id: {}" , foundSteelSellRev);

        return foundSteelSellRev;
    }

    @ApiOperation(value = "Updates the SteelSellRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelSellRev editSteelSellRev(@PathVariable("id") Integer id, @RequestBody SteelSellRev steelSellRev) throws EntityNotFoundException {
        LOGGER.debug("Editing SteelSellRev with id: {}" , steelSellRev.getId());

        steelSellRev.setId(id);
        steelSellRev = steelSellRevService.update(steelSellRev);
        LOGGER.debug("SteelSellRev details with id: {}" , steelSellRev);

        return steelSellRev;
    }

    @ApiOperation(value = "Deletes the SteelSellRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSteelSellRev(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelSellRev with id: {}" , id);

        SteelSellRev deletedSteelSellRev = steelSellRevService.delete(id);

        return deletedSteelSellRev != null;
    }

    /**
     * @deprecated Use {@link #findSteelSellRevs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SteelSellRev instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelSellRev> searchSteelSellRevsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SteelSellRevs list");
        return steelSellRevService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelSellRev instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelSellRev> findSteelSellRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelSellRevs list");
        return steelSellRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelSellRev instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelSellRev> filterSteelSellRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelSellRevs list");
        return steelSellRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSteelSellRevs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return steelSellRevService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of SteelSellRev instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSteelSellRevs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SteelSellRevs");
		return steelSellRevService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSteelSellRevAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return steelSellRevService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SteelSellRevService instance
	 */
	protected void setSteelSellRevService(SteelSellRevService service) {
		this.steelSellRevService = service;
	}

}

