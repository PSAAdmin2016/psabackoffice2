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

import com.psabackoffice.job1111.SteelTrackerClassic;
import com.psabackoffice.job1111.service.SteelTrackerClassicService;


/**
 * Controller object for domain model class SteelTrackerClassic.
 * @see SteelTrackerClassic
 */
@RestController("Job1111.SteelTrackerClassicController")
@Api(value = "SteelTrackerClassicController", description = "Exposes APIs to work with SteelTrackerClassic resource.")
@RequestMapping("/Job1111/SteelTrackerClassic")
public class SteelTrackerClassicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelTrackerClassicController.class);

    @Autowired
	@Qualifier("Job1111.SteelTrackerClassicService")
	private SteelTrackerClassicService steelTrackerClassicService;

	@ApiOperation(value = "Creates a new SteelTrackerClassic instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelTrackerClassic createSteelTrackerClassic(@RequestBody SteelTrackerClassic steelTrackerClassic) {
		LOGGER.debug("Create SteelTrackerClassic with information: {}" , steelTrackerClassic);

		steelTrackerClassic = steelTrackerClassicService.create(steelTrackerClassic);
		LOGGER.debug("Created SteelTrackerClassic with information: {}" , steelTrackerClassic);

	    return steelTrackerClassic;
	}

    @ApiOperation(value = "Returns the SteelTrackerClassic instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelTrackerClassic getSteelTrackerClassic(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting SteelTrackerClassic with id: {}" , id);

        SteelTrackerClassic foundSteelTrackerClassic = steelTrackerClassicService.getById(id);
        LOGGER.debug("SteelTrackerClassic details with id: {}" , foundSteelTrackerClassic);

        return foundSteelTrackerClassic;
    }

    @ApiOperation(value = "Updates the SteelTrackerClassic instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelTrackerClassic editSteelTrackerClassic(@PathVariable("id") Integer id, @RequestBody SteelTrackerClassic steelTrackerClassic) throws EntityNotFoundException {
        LOGGER.debug("Editing SteelTrackerClassic with id: {}" , steelTrackerClassic.getUid());

        steelTrackerClassic.setUid(id);
        steelTrackerClassic = steelTrackerClassicService.update(steelTrackerClassic);
        LOGGER.debug("SteelTrackerClassic details with id: {}" , steelTrackerClassic);

        return steelTrackerClassic;
    }

    @ApiOperation(value = "Deletes the SteelTrackerClassic instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSteelTrackerClassic(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelTrackerClassic with id: {}" , id);

        SteelTrackerClassic deletedSteelTrackerClassic = steelTrackerClassicService.delete(id);

        return deletedSteelTrackerClassic != null;
    }

    /**
     * @deprecated Use {@link #findSteelTrackerClassics(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SteelTrackerClassic instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelTrackerClassic> searchSteelTrackerClassicsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SteelTrackerClassics list");
        return steelTrackerClassicService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelTrackerClassic instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelTrackerClassic> findSteelTrackerClassics(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelTrackerClassics list");
        return steelTrackerClassicService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelTrackerClassic instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelTrackerClassic> filterSteelTrackerClassics(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelTrackerClassics list");
        return steelTrackerClassicService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSteelTrackerClassics(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return steelTrackerClassicService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of SteelTrackerClassic instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSteelTrackerClassics( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SteelTrackerClassics");
		return steelTrackerClassicService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSteelTrackerClassicAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return steelTrackerClassicService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SteelTrackerClassicService instance
	 */
	protected void setSteelTrackerClassicService(SteelTrackerClassicService service) {
		this.steelTrackerClassicService = service;
	}

}

