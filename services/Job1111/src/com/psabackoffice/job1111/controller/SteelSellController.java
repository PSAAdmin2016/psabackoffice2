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

import com.psabackoffice.job1111.SteelSell;
import com.psabackoffice.job1111.service.SteelSellService;


/**
 * Controller object for domain model class SteelSell.
 * @see SteelSell
 */
@RestController("Job1111.SteelSellController")
@Api(value = "SteelSellController", description = "Exposes APIs to work with SteelSell resource.")
@RequestMapping("/Job1111/SteelSell")
public class SteelSellController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelSellController.class);

    @Autowired
	@Qualifier("Job1111.SteelSellService")
	private SteelSellService steelSellService;

	@ApiOperation(value = "Creates a new SteelSell instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public SteelSell createSteelSell(@RequestBody SteelSell steelSell) {
		LOGGER.debug("Create SteelSell with information: {}" , steelSell);

		steelSell = steelSellService.create(steelSell);
		LOGGER.debug("Created SteelSell with information: {}" , steelSell);

	    return steelSell;
	}


    @ApiOperation(value = "Returns the SteelSell instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelSell getSteelSell(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting SteelSell with id: {}" , id);

        SteelSell foundSteelSell = steelSellService.getById(id);
        LOGGER.debug("SteelSell details with id: {}" , foundSteelSell);

        return foundSteelSell;
    }

    @ApiOperation(value = "Updates the SteelSell instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelSell editSteelSell(@PathVariable("id") Integer id, @RequestBody SteelSell steelSell) throws EntityNotFoundException {
        LOGGER.debug("Editing SteelSell with id: {}" , steelSell.getActivityId());

        steelSell.setActivityId(id);
        steelSell = steelSellService.update(steelSell);
        LOGGER.debug("SteelSell details with id: {}" , steelSell);

        return steelSell;
    }

    @ApiOperation(value = "Deletes the SteelSell instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSteelSell(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelSell with id: {}" , id);

        SteelSell deletedSteelSell = steelSellService.delete(id);

        return deletedSteelSell != null;
    }

    /**
     * @deprecated Use {@link #findSteelSells(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SteelSell instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelSell> searchSteelSellsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SteelSells list");
        return steelSellService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelSell instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelSell> findSteelSells(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelSells list");
        return steelSellService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelSell instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelSell> filterSteelSells(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelSells list");
        return steelSellService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSteelSells(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return steelSellService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of SteelSell instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSteelSells( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SteelSells");
		return steelSellService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSteelSellAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return steelSellService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SteelSellService instance
	 */
	protected void setSteelSellService(SteelSellService service) {
		this.steelSellService = service;
	}

}

