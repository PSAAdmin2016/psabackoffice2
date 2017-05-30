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

import com.psabackoffice.psa.RefActivityStatuses;
import com.psabackoffice.psa.service.RefActivityStatusesService;


/**
 * Controller object for domain model class RefActivityStatuses.
 * @see RefActivityStatuses
 */
@RestController("PSA.RefActivityStatusesController")
@Api(value = "RefActivityStatusesController", description = "Exposes APIs to work with RefActivityStatuses resource.")
@RequestMapping("/PSA/RefActivityStatuses")
public class RefActivityStatusesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefActivityStatusesController.class);

    @Autowired
	@Qualifier("PSA.RefActivityStatusesService")
	private RefActivityStatusesService refActivityStatusesService;

	@ApiOperation(value = "Creates a new RefActivityStatuses instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public RefActivityStatuses createRefActivityStatuses(@RequestBody RefActivityStatuses refActivityStatuses) {
		LOGGER.debug("Create RefActivityStatuses with information: {}" , refActivityStatuses);

		refActivityStatuses = refActivityStatusesService.create(refActivityStatuses);
		LOGGER.debug("Created RefActivityStatuses with information: {}" , refActivityStatuses);

	    return refActivityStatuses;
	}


    @ApiOperation(value = "Returns the RefActivityStatuses instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefActivityStatuses getRefActivityStatuses(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting RefActivityStatuses with id: {}" , id);

        RefActivityStatuses foundRefActivityStatuses = refActivityStatusesService.getById(id);
        LOGGER.debug("RefActivityStatuses details with id: {}" , foundRefActivityStatuses);

        return foundRefActivityStatuses;
    }

    @ApiOperation(value = "Updates the RefActivityStatuses instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefActivityStatuses editRefActivityStatuses(@PathVariable("id") Integer id, @RequestBody RefActivityStatuses refActivityStatuses) throws EntityNotFoundException {
        LOGGER.debug("Editing RefActivityStatuses with id: {}" , refActivityStatuses.getId());

        refActivityStatuses.setId(id);
        refActivityStatuses = refActivityStatusesService.update(refActivityStatuses);
        LOGGER.debug("RefActivityStatuses details with id: {}" , refActivityStatuses);

        return refActivityStatuses;
    }

    @ApiOperation(value = "Deletes the RefActivityStatuses instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRefActivityStatuses(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefActivityStatuses with id: {}" , id);

        RefActivityStatuses deletedRefActivityStatuses = refActivityStatusesService.delete(id);

        return deletedRefActivityStatuses != null;
    }

    /**
     * @deprecated Use {@link #findRefActivityStatuses(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefActivityStatuses instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefActivityStatuses> searchRefActivityStatusesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefActivityStatuses list");
        return refActivityStatusesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefActivityStatuses instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefActivityStatuses> findRefActivityStatuses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefActivityStatuses list");
        return refActivityStatusesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefActivityStatuses instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefActivityStatuses> filterRefActivityStatuses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefActivityStatuses list");
        return refActivityStatusesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefActivityStatuses(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refActivityStatusesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefActivityStatuses instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefActivityStatuses( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefActivityStatuses");
		return refActivityStatusesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefActivityStatusesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refActivityStatusesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefActivityStatusesService instance
	 */
	protected void setRefActivityStatusesService(RefActivityStatusesService service) {
		this.refActivityStatusesService = service;
	}

}

