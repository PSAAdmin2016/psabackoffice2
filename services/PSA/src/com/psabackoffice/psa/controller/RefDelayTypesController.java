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

import com.psabackoffice.psa.RefDelayTypes;
import com.psabackoffice.psa.service.RefDelayTypesService;


/**
 * Controller object for domain model class RefDelayTypes.
 * @see RefDelayTypes
 */
@RestController("PSA.RefDelayTypesController")
@Api(value = "RefDelayTypesController", description = "Exposes APIs to work with RefDelayTypes resource.")
@RequestMapping("/PSA/RefDelayTypes")
public class RefDelayTypesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefDelayTypesController.class);

    @Autowired
	@Qualifier("PSA.RefDelayTypesService")
	private RefDelayTypesService refDelayTypesService;

	@ApiOperation(value = "Creates a new RefDelayTypes instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefDelayTypes createRefDelayTypes(@RequestBody RefDelayTypes refDelayTypes) {
		LOGGER.debug("Create RefDelayTypes with information: {}" , refDelayTypes);

		refDelayTypes = refDelayTypesService.create(refDelayTypes);
		LOGGER.debug("Created RefDelayTypes with information: {}" , refDelayTypes);

	    return refDelayTypes;
	}

    @ApiOperation(value = "Returns the RefDelayTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public RefDelayTypes getRefDelayTypes(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting RefDelayTypes with id: {}" , id);

        RefDelayTypes foundRefDelayTypes = refDelayTypesService.getById(id);
        LOGGER.debug("RefDelayTypes details with id: {}" , foundRefDelayTypes);

        return foundRefDelayTypes;
    }

    @ApiOperation(value = "Updates the RefDelayTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefDelayTypes editRefDelayTypes(@PathVariable("id") Integer id, @RequestBody RefDelayTypes refDelayTypes) {
        LOGGER.debug("Editing RefDelayTypes with id: {}" , refDelayTypes.getId());

        refDelayTypes.setId(id);
        refDelayTypes = refDelayTypesService.update(refDelayTypes);
        LOGGER.debug("RefDelayTypes details with id: {}" , refDelayTypes);

        return refDelayTypes;
    }

    @ApiOperation(value = "Deletes the RefDelayTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteRefDelayTypes(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting RefDelayTypes with id: {}" , id);

        RefDelayTypes deletedRefDelayTypes = refDelayTypesService.delete(id);

        return deletedRefDelayTypes != null;
    }

    /**
     * @deprecated Use {@link #findRefDelayTypes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefDelayTypes instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefDelayTypes> searchRefDelayTypesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefDelayTypes list by query filter:{}", (Object) queryFilters);
        return refDelayTypesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefDelayTypes instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefDelayTypes> findRefDelayTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefDelayTypes list by filter:", query);
        return refDelayTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefDelayTypes instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefDelayTypes> filterRefDelayTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefDelayTypes list by filter", query);
        return refDelayTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefDelayTypes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refDelayTypesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefDelayTypes instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefDelayTypes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefDelayTypes");
		return refDelayTypesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefDelayTypesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refDelayTypesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefDelayTypesService instance
	 */
	protected void setRefDelayTypesService(RefDelayTypesService service) {
		this.refDelayTypesService = service;
	}

}

