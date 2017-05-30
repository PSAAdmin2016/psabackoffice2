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

import com.psabackoffice.psa.RefChatStatus;
import com.psabackoffice.psa.service.RefChatStatusService;


/**
 * Controller object for domain model class RefChatStatus.
 * @see RefChatStatus
 */
@RestController("PSA.RefChatStatusController")
@Api(value = "RefChatStatusController", description = "Exposes APIs to work with RefChatStatus resource.")
@RequestMapping("/PSA/RefChatStatus")
public class RefChatStatusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefChatStatusController.class);

    @Autowired
	@Qualifier("PSA.RefChatStatusService")
	private RefChatStatusService refChatStatusService;

	@ApiOperation(value = "Creates a new RefChatStatus instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public RefChatStatus createRefChatStatus(@RequestBody RefChatStatus refChatStatus) {
		LOGGER.debug("Create RefChatStatus with information: {}" , refChatStatus);

		refChatStatus = refChatStatusService.create(refChatStatus);
		LOGGER.debug("Created RefChatStatus with information: {}" , refChatStatus);

	    return refChatStatus;
	}


    @ApiOperation(value = "Returns the RefChatStatus instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefChatStatus getRefChatStatus(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting RefChatStatus with id: {}" , id);

        RefChatStatus foundRefChatStatus = refChatStatusService.getById(id);
        LOGGER.debug("RefChatStatus details with id: {}" , foundRefChatStatus);

        return foundRefChatStatus;
    }

    @ApiOperation(value = "Updates the RefChatStatus instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefChatStatus editRefChatStatus(@PathVariable("id") Integer id, @RequestBody RefChatStatus refChatStatus) throws EntityNotFoundException {
        LOGGER.debug("Editing RefChatStatus with id: {}" , refChatStatus.getId());

        refChatStatus.setId(id);
        refChatStatus = refChatStatusService.update(refChatStatus);
        LOGGER.debug("RefChatStatus details with id: {}" , refChatStatus);

        return refChatStatus;
    }

    @ApiOperation(value = "Deletes the RefChatStatus instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRefChatStatus(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefChatStatus with id: {}" , id);

        RefChatStatus deletedRefChatStatus = refChatStatusService.delete(id);

        return deletedRefChatStatus != null;
    }

    /**
     * @deprecated Use {@link #findRefChatStatuses(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefChatStatus instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefChatStatus> searchRefChatStatusesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefChatStatuses list");
        return refChatStatusService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefChatStatus instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefChatStatus> findRefChatStatuses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefChatStatuses list");
        return refChatStatusService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefChatStatus instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefChatStatus> filterRefChatStatuses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefChatStatuses list");
        return refChatStatusService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefChatStatuses(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refChatStatusService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefChatStatus instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefChatStatuses( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefChatStatuses");
		return refChatStatusService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefChatStatusAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refChatStatusService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefChatStatusService instance
	 */
	protected void setRefChatStatusService(RefChatStatusService service) {
		this.refChatStatusService = service;
	}

}

