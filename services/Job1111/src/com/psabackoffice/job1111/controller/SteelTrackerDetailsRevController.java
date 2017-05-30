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

import com.psabackoffice.job1111.SteelTrackerDetailsRev;
import com.psabackoffice.job1111.service.SteelTrackerDetailsRevService;


/**
 * Controller object for domain model class SteelTrackerDetailsRev.
 * @see SteelTrackerDetailsRev
 */
@RestController("Job1111.SteelTrackerDetailsRevController")
@Api(value = "SteelTrackerDetailsRevController", description = "Exposes APIs to work with SteelTrackerDetailsRev resource.")
@RequestMapping("/Job1111/SteelTrackerDetailsRev")
public class SteelTrackerDetailsRevController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelTrackerDetailsRevController.class);

    @Autowired
	@Qualifier("Job1111.SteelTrackerDetailsRevService")
	private SteelTrackerDetailsRevService steelTrackerDetailsRevService;

	@ApiOperation(value = "Creates a new SteelTrackerDetailsRev instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public SteelTrackerDetailsRev createSteelTrackerDetailsRev(@RequestBody SteelTrackerDetailsRev steelTrackerDetailsRev) {
		LOGGER.debug("Create SteelTrackerDetailsRev with information: {}" , steelTrackerDetailsRev);

		steelTrackerDetailsRev = steelTrackerDetailsRevService.create(steelTrackerDetailsRev);
		LOGGER.debug("Created SteelTrackerDetailsRev with information: {}" , steelTrackerDetailsRev);

	    return steelTrackerDetailsRev;
	}


    @ApiOperation(value = "Returns the SteelTrackerDetailsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelTrackerDetailsRev getSteelTrackerDetailsRev(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting SteelTrackerDetailsRev with id: {}" , id);

        SteelTrackerDetailsRev foundSteelTrackerDetailsRev = steelTrackerDetailsRevService.getById(id);
        LOGGER.debug("SteelTrackerDetailsRev details with id: {}" , foundSteelTrackerDetailsRev);

        return foundSteelTrackerDetailsRev;
    }

    @ApiOperation(value = "Updates the SteelTrackerDetailsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelTrackerDetailsRev editSteelTrackerDetailsRev(@PathVariable("id") Integer id, @RequestBody SteelTrackerDetailsRev steelTrackerDetailsRev) throws EntityNotFoundException {
        LOGGER.debug("Editing SteelTrackerDetailsRev with id: {}" , steelTrackerDetailsRev.getUid());

        steelTrackerDetailsRev.setUid(id);
        steelTrackerDetailsRev = steelTrackerDetailsRevService.update(steelTrackerDetailsRev);
        LOGGER.debug("SteelTrackerDetailsRev details with id: {}" , steelTrackerDetailsRev);

        return steelTrackerDetailsRev;
    }

    @ApiOperation(value = "Deletes the SteelTrackerDetailsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSteelTrackerDetailsRev(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelTrackerDetailsRev with id: {}" , id);

        SteelTrackerDetailsRev deletedSteelTrackerDetailsRev = steelTrackerDetailsRevService.delete(id);

        return deletedSteelTrackerDetailsRev != null;
    }

    /**
     * @deprecated Use {@link #findSteelTrackerDetailsRevs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SteelTrackerDetailsRev instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelTrackerDetailsRev> searchSteelTrackerDetailsRevsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SteelTrackerDetailsRevs list");
        return steelTrackerDetailsRevService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelTrackerDetailsRev instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelTrackerDetailsRev> findSteelTrackerDetailsRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelTrackerDetailsRevs list");
        return steelTrackerDetailsRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelTrackerDetailsRev instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelTrackerDetailsRev> filterSteelTrackerDetailsRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelTrackerDetailsRevs list");
        return steelTrackerDetailsRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSteelTrackerDetailsRevs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return steelTrackerDetailsRevService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of SteelTrackerDetailsRev instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSteelTrackerDetailsRevs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SteelTrackerDetailsRevs");
		return steelTrackerDetailsRevService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSteelTrackerDetailsRevAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return steelTrackerDetailsRevService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SteelTrackerDetailsRevService instance
	 */
	protected void setSteelTrackerDetailsRevService(SteelTrackerDetailsRevService service) {
		this.steelTrackerDetailsRevService = service;
	}

}

