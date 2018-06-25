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

import com.psabackoffice.psa.FeedBack;
import com.psabackoffice.psa.RefFbStatuses;
import com.psabackoffice.psa.service.RefFbStatusesService;


/**
 * Controller object for domain model class RefFbStatuses.
 * @see RefFbStatuses
 */
@RestController("PSA.RefFbStatusesController")
@Api(value = "RefFbStatusesController", description = "Exposes APIs to work with RefFbStatuses resource.")
@RequestMapping("/PSA/RefFbStatuses")
public class RefFbStatusesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefFbStatusesController.class);

    @Autowired
	@Qualifier("PSA.RefFbStatusesService")
	private RefFbStatusesService refFbStatusesService;

	@ApiOperation(value = "Creates a new RefFbStatuses instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefFbStatuses createRefFbStatuses(@RequestBody RefFbStatuses refFbStatuses) {
		LOGGER.debug("Create RefFbStatuses with information: {}" , refFbStatuses);

		refFbStatuses = refFbStatusesService.create(refFbStatuses);
		LOGGER.debug("Created RefFbStatuses with information: {}" , refFbStatuses);

	    return refFbStatuses;
	}

    @ApiOperation(value = "Returns the RefFbStatuses instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public RefFbStatuses getRefFbStatuses(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting RefFbStatuses with id: {}" , id);

        RefFbStatuses foundRefFbStatuses = refFbStatusesService.getById(id);
        LOGGER.debug("RefFbStatuses details with id: {}" , foundRefFbStatuses);

        return foundRefFbStatuses;
    }

    @ApiOperation(value = "Updates the RefFbStatuses instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefFbStatuses editRefFbStatuses(@PathVariable("id") Integer id, @RequestBody RefFbStatuses refFbStatuses) {
        LOGGER.debug("Editing RefFbStatuses with id: {}" , refFbStatuses.getId());

        refFbStatuses.setId(id);
        refFbStatuses = refFbStatusesService.update(refFbStatuses);
        LOGGER.debug("RefFbStatuses details with id: {}" , refFbStatuses);

        return refFbStatuses;
    }

    @ApiOperation(value = "Deletes the RefFbStatuses instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteRefFbStatuses(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting RefFbStatuses with id: {}" , id);

        RefFbStatuses deletedRefFbStatuses = refFbStatusesService.delete(id);

        return deletedRefFbStatuses != null;
    }

    /**
     * @deprecated Use {@link #findRefFbStatuses(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefFbStatuses instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefFbStatuses> searchRefFbStatusesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefFbStatuses list by query filter:{}", (Object) queryFilters);
        return refFbStatusesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefFbStatuses instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefFbStatuses> findRefFbStatuses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefFbStatuses list by filter:", query);
        return refFbStatusesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefFbStatuses instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefFbStatuses> filterRefFbStatuses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefFbStatuses list by filter", query);
        return refFbStatusesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefFbStatuses(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refFbStatusesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefFbStatuses instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefFbStatuses( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefFbStatuses");
		return refFbStatusesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefFbStatusesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refFbStatusesService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/feedBacks", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the feedBacks instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<FeedBack> findAssociatedFeedBacks(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated feedBacks");
        return refFbStatusesService.findAssociatedFeedBacks(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefFbStatusesService instance
	 */
	protected void setRefFbStatusesService(RefFbStatusesService service) {
		this.refFbStatusesService = service;
	}

}

