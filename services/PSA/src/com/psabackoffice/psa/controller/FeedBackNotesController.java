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

import com.psabackoffice.psa.FeedBackNotes;
import com.psabackoffice.psa.service.FeedBackNotesService;


/**
 * Controller object for domain model class FeedBackNotes.
 * @see FeedBackNotes
 */
@RestController("PSA.FeedBackNotesController")
@Api(value = "FeedBackNotesController", description = "Exposes APIs to work with FeedBackNotes resource.")
@RequestMapping("/PSA/FeedBackNotes")
public class FeedBackNotesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedBackNotesController.class);

    @Autowired
	@Qualifier("PSA.FeedBackNotesService")
	private FeedBackNotesService feedBackNotesService;

	@ApiOperation(value = "Creates a new FeedBackNotes instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public FeedBackNotes createFeedBackNotes(@RequestBody FeedBackNotes feedBackNotes) {
		LOGGER.debug("Create FeedBackNotes with information: {}" , feedBackNotes);

		feedBackNotes = feedBackNotesService.create(feedBackNotes);
		LOGGER.debug("Created FeedBackNotes with information: {}" , feedBackNotes);

	    return feedBackNotes;
	}

    @ApiOperation(value = "Returns the FeedBackNotes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public FeedBackNotes getFeedBackNotes(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting FeedBackNotes with id: {}" , id);

        FeedBackNotes foundFeedBackNotes = feedBackNotesService.getById(id);
        LOGGER.debug("FeedBackNotes details with id: {}" , foundFeedBackNotes);

        return foundFeedBackNotes;
    }

    @ApiOperation(value = "Updates the FeedBackNotes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public FeedBackNotes editFeedBackNotes(@PathVariable("id") Integer id, @RequestBody FeedBackNotes feedBackNotes) {
        LOGGER.debug("Editing FeedBackNotes with id: {}" , feedBackNotes.getId());

        feedBackNotes.setId(id);
        feedBackNotes = feedBackNotesService.update(feedBackNotes);
        LOGGER.debug("FeedBackNotes details with id: {}" , feedBackNotes);

        return feedBackNotes;
    }

    @ApiOperation(value = "Deletes the FeedBackNotes instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteFeedBackNotes(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting FeedBackNotes with id: {}" , id);

        FeedBackNotes deletedFeedBackNotes = feedBackNotesService.delete(id);

        return deletedFeedBackNotes != null;
    }

    /**
     * @deprecated Use {@link #findFeedBackNotes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of FeedBackNotes instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<FeedBackNotes> searchFeedBackNotesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering FeedBackNotes list by query filter:{}", (Object) queryFilters);
        return feedBackNotesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of FeedBackNotes instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<FeedBackNotes> findFeedBackNotes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering FeedBackNotes list by filter:", query);
        return feedBackNotesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of FeedBackNotes instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<FeedBackNotes> filterFeedBackNotes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering FeedBackNotes list by filter", query);
        return feedBackNotesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportFeedBackNotes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return feedBackNotesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of FeedBackNotes instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countFeedBackNotes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting FeedBackNotes");
		return feedBackNotesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getFeedBackNotesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return feedBackNotesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service FeedBackNotesService instance
	 */
	protected void setFeedBackNotesService(FeedBackNotesService service) {
		this.feedBackNotesService = service;
	}

}

