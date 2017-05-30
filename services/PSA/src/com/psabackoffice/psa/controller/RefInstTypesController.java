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

import com.psabackoffice.psa.RefInstTypes;
import com.psabackoffice.psa.service.RefInstTypesService;


/**
 * Controller object for domain model class RefInstTypes.
 * @see RefInstTypes
 */
@RestController("PSA.RefInstTypesController")
@Api(value = "RefInstTypesController", description = "Exposes APIs to work with RefInstTypes resource.")
@RequestMapping("/PSA/RefInstTypes")
public class RefInstTypesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefInstTypesController.class);

    @Autowired
	@Qualifier("PSA.RefInstTypesService")
	private RefInstTypesService refInstTypesService;

	@ApiOperation(value = "Creates a new RefInstTypes instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public RefInstTypes createRefInstTypes(@RequestBody RefInstTypes refInstTypes) {
		LOGGER.debug("Create RefInstTypes with information: {}" , refInstTypes);

		refInstTypes = refInstTypesService.create(refInstTypes);
		LOGGER.debug("Created RefInstTypes with information: {}" , refInstTypes);

	    return refInstTypes;
	}


    @ApiOperation(value = "Returns the RefInstTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefInstTypes getRefInstTypes(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting RefInstTypes with id: {}" , id);

        RefInstTypes foundRefInstTypes = refInstTypesService.getById(id);
        LOGGER.debug("RefInstTypes details with id: {}" , foundRefInstTypes);

        return foundRefInstTypes;
    }

    @ApiOperation(value = "Updates the RefInstTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefInstTypes editRefInstTypes(@PathVariable("id") Integer id, @RequestBody RefInstTypes refInstTypes) throws EntityNotFoundException {
        LOGGER.debug("Editing RefInstTypes with id: {}" , refInstTypes.getId());

        refInstTypes.setId(id);
        refInstTypes = refInstTypesService.update(refInstTypes);
        LOGGER.debug("RefInstTypes details with id: {}" , refInstTypes);

        return refInstTypes;
    }

    @ApiOperation(value = "Deletes the RefInstTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRefInstTypes(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefInstTypes with id: {}" , id);

        RefInstTypes deletedRefInstTypes = refInstTypesService.delete(id);

        return deletedRefInstTypes != null;
    }

    /**
     * @deprecated Use {@link #findRefInstTypes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefInstTypes instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefInstTypes> searchRefInstTypesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefInstTypes list");
        return refInstTypesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefInstTypes instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefInstTypes> findRefInstTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefInstTypes list");
        return refInstTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefInstTypes instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefInstTypes> filterRefInstTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefInstTypes list");
        return refInstTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefInstTypes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refInstTypesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefInstTypes instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefInstTypes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefInstTypes");
		return refInstTypesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefInstTypesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refInstTypesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefInstTypesService instance
	 */
	protected void setRefInstTypesService(RefInstTypesService service) {
		this.refInstTypesService = service;
	}

}

