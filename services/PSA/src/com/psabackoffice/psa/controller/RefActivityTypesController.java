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

import com.psabackoffice.psa.RefActivityTypes;
import com.psabackoffice.psa.service.RefActivityTypesService;


/**
 * Controller object for domain model class RefActivityTypes.
 * @see RefActivityTypes
 */
@RestController("PSA.RefActivityTypesController")
@Api(value = "RefActivityTypesController", description = "Exposes APIs to work with RefActivityTypes resource.")
@RequestMapping("/PSA/RefActivityTypes")
public class RefActivityTypesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefActivityTypesController.class);

    @Autowired
	@Qualifier("PSA.RefActivityTypesService")
	private RefActivityTypesService refActivityTypesService;

	@ApiOperation(value = "Creates a new RefActivityTypes instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefActivityTypes createRefActivityTypes(@RequestBody RefActivityTypes refActivityTypes) {
		LOGGER.debug("Create RefActivityTypes with information: {}" , refActivityTypes);

		refActivityTypes = refActivityTypesService.create(refActivityTypes);
		LOGGER.debug("Created RefActivityTypes with information: {}" , refActivityTypes);

	    return refActivityTypes;
	}

    @ApiOperation(value = "Returns the RefActivityTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public RefActivityTypes getRefActivityTypes(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting RefActivityTypes with id: {}" , id);

        RefActivityTypes foundRefActivityTypes = refActivityTypesService.getById(id);
        LOGGER.debug("RefActivityTypes details with id: {}" , foundRefActivityTypes);

        return foundRefActivityTypes;
    }

    @ApiOperation(value = "Updates the RefActivityTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefActivityTypes editRefActivityTypes(@PathVariable("id") Integer id, @RequestBody RefActivityTypes refActivityTypes) {
        LOGGER.debug("Editing RefActivityTypes with id: {}" , refActivityTypes.getId());

        refActivityTypes.setId(id);
        refActivityTypes = refActivityTypesService.update(refActivityTypes);
        LOGGER.debug("RefActivityTypes details with id: {}" , refActivityTypes);

        return refActivityTypes;
    }

    @ApiOperation(value = "Deletes the RefActivityTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteRefActivityTypes(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting RefActivityTypes with id: {}" , id);

        RefActivityTypes deletedRefActivityTypes = refActivityTypesService.delete(id);

        return deletedRefActivityTypes != null;
    }

    /**
     * @deprecated Use {@link #findRefActivityTypes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefActivityTypes instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefActivityTypes> searchRefActivityTypesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefActivityTypes list by query filter:{}", (Object) queryFilters);
        return refActivityTypesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefActivityTypes instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefActivityTypes> findRefActivityTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefActivityTypes list by filter:", query);
        return refActivityTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefActivityTypes instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefActivityTypes> filterRefActivityTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefActivityTypes list by filter", query);
        return refActivityTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefActivityTypes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refActivityTypesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefActivityTypes instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefActivityTypes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefActivityTypes");
		return refActivityTypesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefActivityTypesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refActivityTypesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefActivityTypesService instance
	 */
	protected void setRefActivityTypesService(RefActivityTypesService service) {
		this.refActivityTypesService = service;
	}

}

