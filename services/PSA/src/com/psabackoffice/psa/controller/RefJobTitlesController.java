/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.controller;

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

import com.psabackoffice.psa.RefJobTitles;
import com.psabackoffice.psa.service.RefJobTitlesService;


/**
 * Controller object for domain model class RefJobTitles.
 * @see RefJobTitles
 */
@RestController("PSA.RefJobTitlesController")
@Api(value = "RefJobTitlesController", description = "Exposes APIs to work with RefJobTitles resource.")
@RequestMapping("/PSA/RefJobTitles")
public class RefJobTitlesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefJobTitlesController.class);

    @Autowired
	@Qualifier("PSA.RefJobTitlesService")
	private RefJobTitlesService refJobTitlesService;

	@ApiOperation(value = "Creates a new RefJobTitles instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefJobTitles createRefJobTitles(@RequestBody RefJobTitles refJobTitles) {
		LOGGER.debug("Create RefJobTitles with information: {}" , refJobTitles);

		refJobTitles = refJobTitlesService.create(refJobTitles);
		LOGGER.debug("Created RefJobTitles with information: {}" , refJobTitles);

	    return refJobTitles;
	}

    @ApiOperation(value = "Returns the RefJobTitles instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public RefJobTitles getRefJobTitles(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting RefJobTitles with id: {}" , id);

        RefJobTitles foundRefJobTitles = refJobTitlesService.getById(id);
        LOGGER.debug("RefJobTitles details with id: {}" , foundRefJobTitles);

        return foundRefJobTitles;
    }

    @ApiOperation(value = "Updates the RefJobTitles instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefJobTitles editRefJobTitles(@PathVariable("id") Integer id, @RequestBody RefJobTitles refJobTitles) {
        LOGGER.debug("Editing RefJobTitles with id: {}" , refJobTitles.getId());

        refJobTitles.setId(id);
        refJobTitles = refJobTitlesService.update(refJobTitles);
        LOGGER.debug("RefJobTitles details with id: {}" , refJobTitles);

        return refJobTitles;
    }

    @ApiOperation(value = "Deletes the RefJobTitles instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteRefJobTitles(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting RefJobTitles with id: {}" , id);

        RefJobTitles deletedRefJobTitles = refJobTitlesService.delete(id);

        return deletedRefJobTitles != null;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching RefJobTitles with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefJobTitles getByUniqueKeyId(@PathVariable("id") int id) {
        LOGGER.debug("Getting RefJobTitles with uniques key UniqueKeyId");
        return refJobTitlesService.getByUniqueKeyId(id);
    }

    /**
     * @deprecated Use {@link #findRefJobTitles(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefJobTitles instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefJobTitles> searchRefJobTitlesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefJobTitles list by query filter:{}", (Object) queryFilters);
        return refJobTitlesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefJobTitles instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefJobTitles> findRefJobTitles(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefJobTitles list by filter:", query);
        return refJobTitlesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefJobTitles instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefJobTitles> filterRefJobTitles(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefJobTitles list by filter", query);
        return refJobTitlesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefJobTitles(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refJobTitlesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefJobTitles instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefJobTitles( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefJobTitles");
		return refJobTitlesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefJobTitlesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refJobTitlesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefJobTitlesService instance
	 */
	protected void setRefJobTitlesService(RefJobTitlesService service) {
		this.refJobTitlesService = service;
	}

}

