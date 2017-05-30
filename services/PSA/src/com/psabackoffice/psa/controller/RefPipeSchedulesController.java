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

import com.psabackoffice.psa.RefPipeSchedules;
import com.psabackoffice.psa.service.RefPipeSchedulesService;


/**
 * Controller object for domain model class RefPipeSchedules.
 * @see RefPipeSchedules
 */
@RestController("PSA.RefPipeSchedulesController")
@Api(value = "RefPipeSchedulesController", description = "Exposes APIs to work with RefPipeSchedules resource.")
@RequestMapping("/PSA/RefPipeSchedules")
public class RefPipeSchedulesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefPipeSchedulesController.class);

    @Autowired
	@Qualifier("PSA.RefPipeSchedulesService")
	private RefPipeSchedulesService refPipeSchedulesService;

	@ApiOperation(value = "Creates a new RefPipeSchedules instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public RefPipeSchedules createRefPipeSchedules(@RequestBody RefPipeSchedules refPipeSchedules) {
		LOGGER.debug("Create RefPipeSchedules with information: {}" , refPipeSchedules);

		refPipeSchedules = refPipeSchedulesService.create(refPipeSchedules);
		LOGGER.debug("Created RefPipeSchedules with information: {}" , refPipeSchedules);

	    return refPipeSchedules;
	}


    @ApiOperation(value = "Returns the RefPipeSchedules instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefPipeSchedules getRefPipeSchedules(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting RefPipeSchedules with id: {}" , id);

        RefPipeSchedules foundRefPipeSchedules = refPipeSchedulesService.getById(id);
        LOGGER.debug("RefPipeSchedules details with id: {}" , foundRefPipeSchedules);

        return foundRefPipeSchedules;
    }

    @ApiOperation(value = "Updates the RefPipeSchedules instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefPipeSchedules editRefPipeSchedules(@PathVariable("id") Integer id, @RequestBody RefPipeSchedules refPipeSchedules) throws EntityNotFoundException {
        LOGGER.debug("Editing RefPipeSchedules with id: {}" , refPipeSchedules.getId());

        refPipeSchedules.setId(id);
        refPipeSchedules = refPipeSchedulesService.update(refPipeSchedules);
        LOGGER.debug("RefPipeSchedules details with id: {}" , refPipeSchedules);

        return refPipeSchedules;
    }

    @ApiOperation(value = "Deletes the RefPipeSchedules instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRefPipeSchedules(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefPipeSchedules with id: {}" , id);

        RefPipeSchedules deletedRefPipeSchedules = refPipeSchedulesService.delete(id);

        return deletedRefPipeSchedules != null;
    }

    /**
     * @deprecated Use {@link #findRefPipeSchedules(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefPipeSchedules instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefPipeSchedules> searchRefPipeSchedulesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefPipeSchedules list");
        return refPipeSchedulesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefPipeSchedules instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefPipeSchedules> findRefPipeSchedules(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefPipeSchedules list");
        return refPipeSchedulesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefPipeSchedules instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefPipeSchedules> filterRefPipeSchedules(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefPipeSchedules list");
        return refPipeSchedulesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefPipeSchedules(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refPipeSchedulesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefPipeSchedules instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefPipeSchedules( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefPipeSchedules");
		return refPipeSchedulesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefPipeSchedulesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refPipeSchedulesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefPipeSchedulesService instance
	 */
	protected void setRefPipeSchedulesService(RefPipeSchedulesService service) {
		this.refPipeSchedulesService = service;
	}

}

