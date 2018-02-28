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

import com.psabackoffice.job1111.CivilFa;
import com.psabackoffice.job1111.service.CivilFaService;


/**
 * Controller object for domain model class CivilFa.
 * @see CivilFa
 */
@RestController("Job1111.CivilFaController")
@Api(value = "CivilFaController", description = "Exposes APIs to work with CivilFa resource.")
@RequestMapping("/Job1111/CivilFa")
public class CivilFaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CivilFaController.class);

    @Autowired
	@Qualifier("Job1111.CivilFaService")
	private CivilFaService civilFaService;

	@ApiOperation(value = "Creates a new CivilFa instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CivilFa createCivilFa(@RequestBody CivilFa civilFa) {
		LOGGER.debug("Create CivilFa with information: {}" , civilFa);

		civilFa = civilFaService.create(civilFa);
		LOGGER.debug("Created CivilFa with information: {}" , civilFa);

	    return civilFa;
	}

    @ApiOperation(value = "Returns the CivilFa instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CivilFa getCivilFa(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting CivilFa with id: {}" , id);

        CivilFa foundCivilFa = civilFaService.getById(id);
        LOGGER.debug("CivilFa details with id: {}" , foundCivilFa);

        return foundCivilFa;
    }

    @ApiOperation(value = "Updates the CivilFa instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CivilFa editCivilFa(@PathVariable("id") Integer id, @RequestBody CivilFa civilFa) throws EntityNotFoundException {
        LOGGER.debug("Editing CivilFa with id: {}" , civilFa.getActivityId());

        civilFa.setActivityId(id);
        civilFa = civilFaService.update(civilFa);
        LOGGER.debug("CivilFa details with id: {}" , civilFa);

        return civilFa;
    }

    @ApiOperation(value = "Deletes the CivilFa instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCivilFa(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting CivilFa with id: {}" , id);

        CivilFa deletedCivilFa = civilFaService.delete(id);

        return deletedCivilFa != null;
    }

    /**
     * @deprecated Use {@link #findCivilFas(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of CivilFa instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CivilFa> searchCivilFasByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CivilFas list");
        return civilFaService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CivilFa instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CivilFa> findCivilFas(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CivilFas list");
        return civilFaService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CivilFa instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CivilFa> filterCivilFas(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CivilFas list");
        return civilFaService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCivilFas(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return civilFaService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of CivilFa instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countCivilFas( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting CivilFas");
		return civilFaService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getCivilFaAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return civilFaService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CivilFaService instance
	 */
	protected void setCivilFaService(CivilFaService service) {
		this.civilFaService = service;
	}

}

