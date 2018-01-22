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

import com.psabackoffice.psa.RefValveTypes;
import com.psabackoffice.psa.service.RefValveTypesService;


/**
 * Controller object for domain model class RefValveTypes.
 * @see RefValveTypes
 */
@RestController("PSA.RefValveTypesController")
@Api(value = "RefValveTypesController", description = "Exposes APIs to work with RefValveTypes resource.")
@RequestMapping("/PSA/RefValveTypes")
public class RefValveTypesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefValveTypesController.class);

    @Autowired
	@Qualifier("PSA.RefValveTypesService")
	private RefValveTypesService refValveTypesService;

	@ApiOperation(value = "Creates a new RefValveTypes instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefValveTypes createRefValveTypes(@RequestBody RefValveTypes refValveTypes) {
		LOGGER.debug("Create RefValveTypes with information: {}" , refValveTypes);

		refValveTypes = refValveTypesService.create(refValveTypes);
		LOGGER.debug("Created RefValveTypes with information: {}" , refValveTypes);

	    return refValveTypes;
	}

    @ApiOperation(value = "Returns the RefValveTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefValveTypes getRefValveTypes(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting RefValveTypes with id: {}" , id);

        RefValveTypes foundRefValveTypes = refValveTypesService.getById(id);
        LOGGER.debug("RefValveTypes details with id: {}" , foundRefValveTypes);

        return foundRefValveTypes;
    }

    @ApiOperation(value = "Updates the RefValveTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefValveTypes editRefValveTypes(@PathVariable("id") Integer id, @RequestBody RefValveTypes refValveTypes) throws EntityNotFoundException {
        LOGGER.debug("Editing RefValveTypes with id: {}" , refValveTypes.getId());

        refValveTypes.setId(id);
        refValveTypes = refValveTypesService.update(refValveTypes);
        LOGGER.debug("RefValveTypes details with id: {}" , refValveTypes);

        return refValveTypes;
    }

    @ApiOperation(value = "Deletes the RefValveTypes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRefValveTypes(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefValveTypes with id: {}" , id);

        RefValveTypes deletedRefValveTypes = refValveTypesService.delete(id);

        return deletedRefValveTypes != null;
    }

    /**
     * @deprecated Use {@link #findRefValveTypes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefValveTypes instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefValveTypes> searchRefValveTypesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefValveTypes list");
        return refValveTypesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefValveTypes instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefValveTypes> findRefValveTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefValveTypes list");
        return refValveTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefValveTypes instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefValveTypes> filterRefValveTypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefValveTypes list");
        return refValveTypesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefValveTypes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refValveTypesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefValveTypes instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefValveTypes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefValveTypes");
		return refValveTypesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefValveTypesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refValveTypesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefValveTypesService instance
	 */
	protected void setRefValveTypesService(RefValveTypesService service) {
		this.refValveTypesService = service;
	}

}

