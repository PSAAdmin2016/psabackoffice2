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

import com.psabackoffice.job1111.SubsDetailsRev;
import com.psabackoffice.job1111.service.SubsDetailsRevService;


/**
 * Controller object for domain model class SubsDetailsRev.
 * @see SubsDetailsRev
 */
@RestController("Job1111.SubsDetailsRevController")
@Api(value = "SubsDetailsRevController", description = "Exposes APIs to work with SubsDetailsRev resource.")
@RequestMapping("/Job1111/SubsDetailsRev")
public class SubsDetailsRevController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubsDetailsRevController.class);

    @Autowired
	@Qualifier("Job1111.SubsDetailsRevService")
	private SubsDetailsRevService subsDetailsRevService;

	@ApiOperation(value = "Creates a new SubsDetailsRev instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public SubsDetailsRev createSubsDetailsRev(@RequestBody SubsDetailsRev subsDetailsRev) {
		LOGGER.debug("Create SubsDetailsRev with information: {}" , subsDetailsRev);

		subsDetailsRev = subsDetailsRevService.create(subsDetailsRev);
		LOGGER.debug("Created SubsDetailsRev with information: {}" , subsDetailsRev);

	    return subsDetailsRev;
	}


    @ApiOperation(value = "Returns the SubsDetailsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SubsDetailsRev getSubsDetailsRev(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting SubsDetailsRev with id: {}" , id);

        SubsDetailsRev foundSubsDetailsRev = subsDetailsRevService.getById(id);
        LOGGER.debug("SubsDetailsRev details with id: {}" , foundSubsDetailsRev);

        return foundSubsDetailsRev;
    }

    @ApiOperation(value = "Updates the SubsDetailsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SubsDetailsRev editSubsDetailsRev(@PathVariable("id") Integer id, @RequestBody SubsDetailsRev subsDetailsRev) throws EntityNotFoundException {
        LOGGER.debug("Editing SubsDetailsRev with id: {}" , subsDetailsRev.getId());

        subsDetailsRev.setId(id);
        subsDetailsRev = subsDetailsRevService.update(subsDetailsRev);
        LOGGER.debug("SubsDetailsRev details with id: {}" , subsDetailsRev);

        return subsDetailsRev;
    }

    @ApiOperation(value = "Deletes the SubsDetailsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSubsDetailsRev(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting SubsDetailsRev with id: {}" , id);

        SubsDetailsRev deletedSubsDetailsRev = subsDetailsRevService.delete(id);

        return deletedSubsDetailsRev != null;
    }

    /**
     * @deprecated Use {@link #findSubsDetailsRevs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SubsDetailsRev instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubsDetailsRev> searchSubsDetailsRevsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SubsDetailsRevs list");
        return subsDetailsRevService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SubsDetailsRev instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubsDetailsRev> findSubsDetailsRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SubsDetailsRevs list");
        return subsDetailsRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SubsDetailsRev instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SubsDetailsRev> filterSubsDetailsRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SubsDetailsRevs list");
        return subsDetailsRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSubsDetailsRevs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return subsDetailsRevService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of SubsDetailsRev instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSubsDetailsRevs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SubsDetailsRevs");
		return subsDetailsRevService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSubsDetailsRevAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return subsDetailsRevService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SubsDetailsRevService instance
	 */
	protected void setSubsDetailsRevService(SubsDetailsRevService service) {
		this.subsDetailsRevService = service;
	}

}

