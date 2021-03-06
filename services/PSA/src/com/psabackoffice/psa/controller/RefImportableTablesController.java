/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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

import com.psabackoffice.psa.RefImportableTables;
import com.psabackoffice.psa.service.RefImportableTablesService;


/**
 * Controller object for domain model class RefImportableTables.
 * @see RefImportableTables
 */
@RestController("PSA.RefImportableTablesController")
@Api(value = "RefImportableTablesController", description = "Exposes APIs to work with RefImportableTables resource.")
@RequestMapping("/PSA/RefImportableTables")
public class RefImportableTablesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefImportableTablesController.class);

    @Autowired
	@Qualifier("PSA.RefImportableTablesService")
	private RefImportableTablesService refImportableTablesService;

	@ApiOperation(value = "Creates a new RefImportableTables instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefImportableTables createRefImportableTables(@RequestBody RefImportableTables refImportableTables) {
		LOGGER.debug("Create RefImportableTables with information: {}" , refImportableTables);

		refImportableTables = refImportableTablesService.create(refImportableTables);
		LOGGER.debug("Created RefImportableTables with information: {}" , refImportableTables);

	    return refImportableTables;
	}

    @ApiOperation(value = "Returns the RefImportableTables instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public RefImportableTables getRefImportableTables(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting RefImportableTables with id: {}" , id);

        RefImportableTables foundRefImportableTables = refImportableTablesService.getById(id);
        LOGGER.debug("RefImportableTables details with id: {}" , foundRefImportableTables);

        return foundRefImportableTables;
    }

    @ApiOperation(value = "Updates the RefImportableTables instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefImportableTables editRefImportableTables(@PathVariable("id") Integer id, @RequestBody RefImportableTables refImportableTables) {
        LOGGER.debug("Editing RefImportableTables with id: {}" , refImportableTables.getId());

        refImportableTables.setId(id);
        refImportableTables = refImportableTablesService.update(refImportableTables);
        LOGGER.debug("RefImportableTables details with id: {}" , refImportableTables);

        return refImportableTables;
    }

    @ApiOperation(value = "Deletes the RefImportableTables instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteRefImportableTables(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting RefImportableTables with id: {}" , id);

        RefImportableTables deletedRefImportableTables = refImportableTablesService.delete(id);

        return deletedRefImportableTables != null;
    }

    /**
     * @deprecated Use {@link #findRefImportableTables(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefImportableTables instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefImportableTables> searchRefImportableTablesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefImportableTables list by query filter:{}", (Object) queryFilters);
        return refImportableTablesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefImportableTables instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefImportableTables> findRefImportableTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefImportableTables list by filter:", query);
        return refImportableTablesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefImportableTables instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefImportableTables> filterRefImportableTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefImportableTables list by filter", query);
        return refImportableTablesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefImportableTables(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refImportableTablesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefImportableTables instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefImportableTables( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefImportableTables");
		return refImportableTablesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefImportableTablesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refImportableTablesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefImportableTablesService instance
	 */
	protected void setRefImportableTablesService(RefImportableTablesService service) {
		this.refImportableTablesService = service;
	}

}

