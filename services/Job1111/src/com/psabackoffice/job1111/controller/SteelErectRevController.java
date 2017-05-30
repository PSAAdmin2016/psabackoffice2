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

import com.psabackoffice.job1111.SteelErectRev;
import com.psabackoffice.job1111.service.SteelErectRevService;


/**
 * Controller object for domain model class SteelErectRev.
 * @see SteelErectRev
 */
@RestController("Job1111.SteelErectRevController")
@Api(value = "SteelErectRevController", description = "Exposes APIs to work with SteelErectRev resource.")
@RequestMapping("/Job1111/SteelErectRev")
public class SteelErectRevController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelErectRevController.class);

    @Autowired
	@Qualifier("Job1111.SteelErectRevService")
	private SteelErectRevService steelErectRevService;

	@ApiOperation(value = "Creates a new SteelErectRev instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public SteelErectRev createSteelErectRev(@RequestBody SteelErectRev steelErectRev) {
		LOGGER.debug("Create SteelErectRev with information: {}" , steelErectRev);

		steelErectRev = steelErectRevService.create(steelErectRev);
		LOGGER.debug("Created SteelErectRev with information: {}" , steelErectRev);

	    return steelErectRev;
	}


    @ApiOperation(value = "Returns the SteelErectRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelErectRev getSteelErectRev(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting SteelErectRev with id: {}" , id);

        SteelErectRev foundSteelErectRev = steelErectRevService.getById(id);
        LOGGER.debug("SteelErectRev details with id: {}" , foundSteelErectRev);

        return foundSteelErectRev;
    }

    @ApiOperation(value = "Updates the SteelErectRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelErectRev editSteelErectRev(@PathVariable("id") Integer id, @RequestBody SteelErectRev steelErectRev) throws EntityNotFoundException {
        LOGGER.debug("Editing SteelErectRev with id: {}" , steelErectRev.getId());

        steelErectRev.setId(id);
        steelErectRev = steelErectRevService.update(steelErectRev);
        LOGGER.debug("SteelErectRev details with id: {}" , steelErectRev);

        return steelErectRev;
    }

    @ApiOperation(value = "Deletes the SteelErectRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSteelErectRev(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelErectRev with id: {}" , id);

        SteelErectRev deletedSteelErectRev = steelErectRevService.delete(id);

        return deletedSteelErectRev != null;
    }

    /**
     * @deprecated Use {@link #findSteelErectRevs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SteelErectRev instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelErectRev> searchSteelErectRevsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SteelErectRevs list");
        return steelErectRevService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelErectRev instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelErectRev> findSteelErectRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelErectRevs list");
        return steelErectRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelErectRev instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelErectRev> filterSteelErectRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelErectRevs list");
        return steelErectRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSteelErectRevs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return steelErectRevService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of SteelErectRev instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSteelErectRevs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SteelErectRevs");
		return steelErectRevService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSteelErectRevAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return steelErectRevService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SteelErectRevService instance
	 */
	protected void setSteelErectRevService(SteelErectRevService service) {
		this.steelErectRevService = service;
	}

}

