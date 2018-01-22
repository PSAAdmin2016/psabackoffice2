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

import com.psabackoffice.job1111.LandingSpoolList;
import com.psabackoffice.job1111.service.LandingSpoolListService;


/**
 * Controller object for domain model class LandingSpoolList.
 * @see LandingSpoolList
 */
@RestController("Job1111.LandingSpoolListController")
@Api(value = "LandingSpoolListController", description = "Exposes APIs to work with LandingSpoolList resource.")
@RequestMapping("/Job1111/LandingSpoolList")
public class LandingSpoolListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LandingSpoolListController.class);

    @Autowired
	@Qualifier("Job1111.LandingSpoolListService")
	private LandingSpoolListService landingSpoolListService;

	@ApiOperation(value = "Creates a new LandingSpoolList instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public LandingSpoolList createLandingSpoolList(@RequestBody LandingSpoolList landingSpoolList) {
		LOGGER.debug("Create LandingSpoolList with information: {}" , landingSpoolList);

		landingSpoolList = landingSpoolListService.create(landingSpoolList);
		LOGGER.debug("Created LandingSpoolList with information: {}" , landingSpoolList);

	    return landingSpoolList;
	}

    @ApiOperation(value = "Returns the LandingSpoolList instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public LandingSpoolList getLandingSpoolList(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting LandingSpoolList with id: {}" , id);

        LandingSpoolList foundLandingSpoolList = landingSpoolListService.getById(id);
        LOGGER.debug("LandingSpoolList details with id: {}" , foundLandingSpoolList);

        return foundLandingSpoolList;
    }

    @ApiOperation(value = "Updates the LandingSpoolList instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public LandingSpoolList editLandingSpoolList(@PathVariable("id") String id, @RequestBody LandingSpoolList landingSpoolList) throws EntityNotFoundException {
        LOGGER.debug("Editing LandingSpoolList with id: {}" , landingSpoolList.getSpoolNumber());

        landingSpoolList.setSpoolNumber(id);
        landingSpoolList = landingSpoolListService.update(landingSpoolList);
        LOGGER.debug("LandingSpoolList details with id: {}" , landingSpoolList);

        return landingSpoolList;
    }

    @ApiOperation(value = "Deletes the LandingSpoolList instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteLandingSpoolList(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting LandingSpoolList with id: {}" , id);

        LandingSpoolList deletedLandingSpoolList = landingSpoolListService.delete(id);

        return deletedLandingSpoolList != null;
    }

    /**
     * @deprecated Use {@link #findLandingSpoolLists(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of LandingSpoolList instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LandingSpoolList> searchLandingSpoolListsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering LandingSpoolLists list");
        return landingSpoolListService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of LandingSpoolList instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LandingSpoolList> findLandingSpoolLists(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering LandingSpoolLists list");
        return landingSpoolListService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of LandingSpoolList instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LandingSpoolList> filterLandingSpoolLists(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering LandingSpoolLists list");
        return landingSpoolListService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportLandingSpoolLists(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return landingSpoolListService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of LandingSpoolList instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countLandingSpoolLists( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting LandingSpoolLists");
		return landingSpoolListService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getLandingSpoolListAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return landingSpoolListService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LandingSpoolListService instance
	 */
	protected void setLandingSpoolListService(LandingSpoolListService service) {
		this.landingSpoolListService = service;
	}

}

