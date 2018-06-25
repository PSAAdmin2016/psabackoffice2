/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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

import com.psabackoffice.job1111.CivilFa;
import com.psabackoffice.job1111.CivilTrackerDetails;
import com.psabackoffice.job1111.service.CivilTrackerDetailsService;


/**
 * Controller object for domain model class CivilTrackerDetails.
 * @see CivilTrackerDetails
 */
@RestController("Job1111.CivilTrackerDetailsController")
@Api(value = "CivilTrackerDetailsController", description = "Exposes APIs to work with CivilTrackerDetails resource.")
@RequestMapping("/Job1111/CivilTrackerDetails")
public class CivilTrackerDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CivilTrackerDetailsController.class);

    @Autowired
	@Qualifier("Job1111.CivilTrackerDetailsService")
	private CivilTrackerDetailsService civilTrackerDetailsService;

	@ApiOperation(value = "Creates a new CivilTrackerDetails instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CivilTrackerDetails createCivilTrackerDetails(@RequestBody CivilTrackerDetails civilTrackerDetails) {
		LOGGER.debug("Create CivilTrackerDetails with information: {}" , civilTrackerDetails);

		civilTrackerDetails = civilTrackerDetailsService.create(civilTrackerDetails);
		LOGGER.debug("Created CivilTrackerDetails with information: {}" , civilTrackerDetails);

	    return civilTrackerDetails;
	}

    @ApiOperation(value = "Returns the CivilTrackerDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public CivilTrackerDetails getCivilTrackerDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting CivilTrackerDetails with id: {}" , id);

        CivilTrackerDetails foundCivilTrackerDetails = civilTrackerDetailsService.getById(id);
        LOGGER.debug("CivilTrackerDetails details with id: {}" , foundCivilTrackerDetails);

        return foundCivilTrackerDetails;
    }

    @ApiOperation(value = "Updates the CivilTrackerDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CivilTrackerDetails editCivilTrackerDetails(@PathVariable("id") Integer id, @RequestBody CivilTrackerDetails civilTrackerDetails) {
        LOGGER.debug("Editing CivilTrackerDetails with id: {}" , civilTrackerDetails.getUid());

        civilTrackerDetails.setUid(id);
        civilTrackerDetails = civilTrackerDetailsService.update(civilTrackerDetails);
        LOGGER.debug("CivilTrackerDetails details with id: {}" , civilTrackerDetails);

        return civilTrackerDetails;
    }

    @ApiOperation(value = "Deletes the CivilTrackerDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteCivilTrackerDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting CivilTrackerDetails with id: {}" , id);

        CivilTrackerDetails deletedCivilTrackerDetails = civilTrackerDetailsService.delete(id);

        return deletedCivilTrackerDetails != null;
    }

    /**
     * @deprecated Use {@link #findCivilTrackerDetails(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of CivilTrackerDetails instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CivilTrackerDetails> searchCivilTrackerDetailsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CivilTrackerDetails list by query filter:{}", (Object) queryFilters);
        return civilTrackerDetailsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CivilTrackerDetails instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CivilTrackerDetails> findCivilTrackerDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CivilTrackerDetails list by filter:", query);
        return civilTrackerDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CivilTrackerDetails instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CivilTrackerDetails> filterCivilTrackerDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CivilTrackerDetails list by filter", query);
        return civilTrackerDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCivilTrackerDetails(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return civilTrackerDetailsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of CivilTrackerDetails instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countCivilTrackerDetails( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting CivilTrackerDetails");
		return civilTrackerDetailsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getCivilTrackerDetailsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return civilTrackerDetailsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/civilFas", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the civilFas instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CivilFa> findAssociatedCivilFas(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated civilFas");
        return civilTrackerDetailsService.findAssociatedCivilFas(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CivilTrackerDetailsService instance
	 */
	protected void setCivilTrackerDetailsService(CivilTrackerDetailsService service) {
		this.civilTrackerDetailsService = service;
	}

}

