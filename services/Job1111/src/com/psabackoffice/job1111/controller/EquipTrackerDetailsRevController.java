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

import com.psabackoffice.job1111.EquipTrackerDetailsRev;
import com.psabackoffice.job1111.service.EquipTrackerDetailsRevService;


/**
 * Controller object for domain model class EquipTrackerDetailsRev.
 * @see EquipTrackerDetailsRev
 */
@RestController("Job1111.EquipTrackerDetailsRevController")
@Api(value = "EquipTrackerDetailsRevController", description = "Exposes APIs to work with EquipTrackerDetailsRev resource.")
@RequestMapping("/Job1111/EquipTrackerDetailsRev")
public class EquipTrackerDetailsRevController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquipTrackerDetailsRevController.class);

    @Autowired
	@Qualifier("Job1111.EquipTrackerDetailsRevService")
	private EquipTrackerDetailsRevService equipTrackerDetailsRevService;

	@ApiOperation(value = "Creates a new EquipTrackerDetailsRev instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public EquipTrackerDetailsRev createEquipTrackerDetailsRev(@RequestBody EquipTrackerDetailsRev equipTrackerDetailsRev) {
		LOGGER.debug("Create EquipTrackerDetailsRev with information: {}" , equipTrackerDetailsRev);

		equipTrackerDetailsRev = equipTrackerDetailsRevService.create(equipTrackerDetailsRev);
		LOGGER.debug("Created EquipTrackerDetailsRev with information: {}" , equipTrackerDetailsRev);

	    return equipTrackerDetailsRev;
	}


    @ApiOperation(value = "Returns the EquipTrackerDetailsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public EquipTrackerDetailsRev getEquipTrackerDetailsRev(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting EquipTrackerDetailsRev with id: {}" , id);

        EquipTrackerDetailsRev foundEquipTrackerDetailsRev = equipTrackerDetailsRevService.getById(id);
        LOGGER.debug("EquipTrackerDetailsRev details with id: {}" , foundEquipTrackerDetailsRev);

        return foundEquipTrackerDetailsRev;
    }

    @ApiOperation(value = "Updates the EquipTrackerDetailsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public EquipTrackerDetailsRev editEquipTrackerDetailsRev(@PathVariable("id") Integer id, @RequestBody EquipTrackerDetailsRev equipTrackerDetailsRev) throws EntityNotFoundException {
        LOGGER.debug("Editing EquipTrackerDetailsRev with id: {}" , equipTrackerDetailsRev.getUid());

        equipTrackerDetailsRev.setUid(id);
        equipTrackerDetailsRev = equipTrackerDetailsRevService.update(equipTrackerDetailsRev);
        LOGGER.debug("EquipTrackerDetailsRev details with id: {}" , equipTrackerDetailsRev);

        return equipTrackerDetailsRev;
    }

    @ApiOperation(value = "Deletes the EquipTrackerDetailsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteEquipTrackerDetailsRev(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting EquipTrackerDetailsRev with id: {}" , id);

        EquipTrackerDetailsRev deletedEquipTrackerDetailsRev = equipTrackerDetailsRevService.delete(id);

        return deletedEquipTrackerDetailsRev != null;
    }

    /**
     * @deprecated Use {@link #findEquipTrackerDetailsRevs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of EquipTrackerDetailsRev instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<EquipTrackerDetailsRev> searchEquipTrackerDetailsRevsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering EquipTrackerDetailsRevs list");
        return equipTrackerDetailsRevService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of EquipTrackerDetailsRev instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<EquipTrackerDetailsRev> findEquipTrackerDetailsRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EquipTrackerDetailsRevs list");
        return equipTrackerDetailsRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of EquipTrackerDetailsRev instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<EquipTrackerDetailsRev> filterEquipTrackerDetailsRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EquipTrackerDetailsRevs list");
        return equipTrackerDetailsRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportEquipTrackerDetailsRevs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return equipTrackerDetailsRevService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of EquipTrackerDetailsRev instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countEquipTrackerDetailsRevs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting EquipTrackerDetailsRevs");
		return equipTrackerDetailsRevService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getEquipTrackerDetailsRevAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return equipTrackerDetailsRevService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EquipTrackerDetailsRevService instance
	 */
	protected void setEquipTrackerDetailsRevService(EquipTrackerDetailsRevService service) {
		this.equipTrackerDetailsRevService = service;
	}

}

