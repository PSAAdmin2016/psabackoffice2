/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.controller;

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

import com.psabackoffice.job1111.UpdateTracker;
import com.psabackoffice.job1111.service.UpdateTrackerService;


/**
 * Controller object for domain model class UpdateTracker.
 * @see UpdateTracker
 */
@RestController("Job1111.UpdateTrackerController")
@Api(value = "UpdateTrackerController", description = "Exposes APIs to work with UpdateTracker resource.")
@RequestMapping("/Job1111/UpdateTracker")
public class UpdateTrackerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateTrackerController.class);

    @Autowired
	@Qualifier("Job1111.UpdateTrackerService")
	private UpdateTrackerService updateTrackerService;

	@ApiOperation(value = "Creates a new UpdateTracker instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public UpdateTracker createUpdateTracker(@RequestBody UpdateTracker updateTracker) {
		LOGGER.debug("Create UpdateTracker with information: {}" , updateTracker);

		updateTracker = updateTrackerService.create(updateTracker);
		LOGGER.debug("Created UpdateTracker with information: {}" , updateTracker);

	    return updateTracker;
	}


    @ApiOperation(value = "Returns the UpdateTracker instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UpdateTracker getUpdateTracker(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting UpdateTracker with id: {}" , id);

        UpdateTracker foundUpdateTracker = updateTrackerService.getById(id);
        LOGGER.debug("UpdateTracker details with id: {}" , foundUpdateTracker);

        return foundUpdateTracker;
    }

    @ApiOperation(value = "Updates the UpdateTracker instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UpdateTracker editUpdateTracker(@PathVariable("id") String id, @RequestBody UpdateTracker updateTracker) throws EntityNotFoundException {
        LOGGER.debug("Editing UpdateTracker with id: {}" , updateTracker.getTableName());

        updateTracker.setTableName(id);
        updateTracker = updateTrackerService.update(updateTracker);
        LOGGER.debug("UpdateTracker details with id: {}" , updateTracker);

        return updateTracker;
    }

    @ApiOperation(value = "Deletes the UpdateTracker instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUpdateTracker(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting UpdateTracker with id: {}" , id);

        UpdateTracker deletedUpdateTracker = updateTrackerService.delete(id);

        return deletedUpdateTracker != null;
    }

    /**
     * @deprecated Use {@link #findUpdateTrackers(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of UpdateTracker instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UpdateTracker> searchUpdateTrackersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering UpdateTrackers list");
        return updateTrackerService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UpdateTracker instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UpdateTracker> findUpdateTrackers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UpdateTrackers list");
        return updateTrackerService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UpdateTracker instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UpdateTracker> filterUpdateTrackers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UpdateTrackers list");
        return updateTrackerService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportUpdateTrackers(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return updateTrackerService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of UpdateTracker instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countUpdateTrackers( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting UpdateTrackers");
		return updateTrackerService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getUpdateTrackerAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return updateTrackerService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UpdateTrackerService instance
	 */
	protected void setUpdateTrackerService(UpdateTrackerService service) {
		this.updateTrackerService = service;
	}

}

