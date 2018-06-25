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

import com.psabackoffice.psa.RefWeldTypes;
import com.psabackoffice.psa.service.RefWeldTypesService;


/**
 * Controller object for domain model class RefWeldTypes.
 * @see RefWeldTypes
 */
@RestController("PSA.RefWeldTypesController")
@Api(value = "RefWeldTypesController", description = "Exposes APIs to work with RefWeldTypes resource.")
@RequestMapping("/PSA/RefWeldTypes")
public class RefWeldTypesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefWeldTypesController.class);

    @Autowired
	@Qualifier("PSA.RefWeldTypesService")
	private RefWeldTypesService refWeldTypesService;

	@ApiOperation(value = "Creates a new RefWeldTypes instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefWeldTypes createRefWeldTypes(@RequestBody RefWeldTypes refWeldTypes) {
		LOGGER.debug("Create RefWeldTypes with information: {}" , refWeldTypes);

		refWeldTypes = refWeldTypesService.create(refWeldTypes);
		LOGGER.debug("Created RefWeldTypes with information: {}" , refWeldTypes);

	    return refWeldTypes;
	}

    @ApiOperation(value = "Returns the RefWeldTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public RefWeldTypes getRefWeldTypes(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting RefWeldTypes with id: {}" , id);

        RefWeldTypes foundRefWeldTypes = refWeldTypesService.getById(id);
        LOGGER.debug("RefWeldTypes details with id: {}" , foundRefWeldTypes);

        return foundRefWeldTypes;
    }

    @ApiOperation(value = "Updates the RefWeldTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefWeldTypes editRefWeldTypes(@PathVariable("id") Integer id, @RequestBody RefWeldTypes refWeldTypes) {
        LOGGER.debug("Editing RefWeldTypes with id: {}" , refWeldTypes.getId());

        refWeldTypes.setId(id);
        refWeldTypes = refWeldTypesService.update(refWeldTypes);
        LOGGER.debug("RefWeldTypes details with id: {}" , refWeldTypes);

        return refWeldTypes;
    }

    @ApiOperation(value = "Deletes the RefWeldTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteRefWeldTypes(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting RefWeldTypes with id: {}" , id);

        RefWeldTypes deletedRefWeldTypes = refWeldTypesService.delete(id);

        return deletedRefWeldTypes != null;
    }

    /**
     * @deprecated Use {@link #findRefWeldTypes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefWeldTypes instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefWeldTypes> searchRefWeldTypesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefWeldTypes list by query filter:{}", (Object) queryFilters);
        return refWeldTypesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefWeldTypes instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefWeldTypes> findRefWeldTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefWeldTypes list by filter:", query);
        return refWeldTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefWeldTypes instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefWeldTypes> filterRefWeldTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefWeldTypes list by filter", query);
        return refWeldTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefWeldTypes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refWeldTypesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefWeldTypes instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefWeldTypes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefWeldTypes");
		return refWeldTypesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefWeldTypesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refWeldTypesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefWeldTypesService instance
	 */
	protected void setRefWeldTypesService(RefWeldTypesService service) {
		this.refWeldTypesService = service;
	}

}

