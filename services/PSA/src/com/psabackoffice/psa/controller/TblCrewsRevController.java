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

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.psabackoffice.psa.TblCrewsRev;
import com.psabackoffice.psa.service.TblCrewsRevService;


/**
 * Controller object for domain model class TblCrewsRev.
 * @see TblCrewsRev
 */
@RestController("PSA.TblCrewsRevController")
@Api(value = "TblCrewsRevController", description = "Exposes APIs to work with TblCrewsRev resource.")
@RequestMapping("/PSA/TblCrewsRev")
public class TblCrewsRevController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TblCrewsRevController.class);

    @Autowired
	@Qualifier("PSA.TblCrewsRevService")
	private TblCrewsRevService tblCrewsRevService;

	@ApiOperation(value = "Creates a new TblCrewsRev instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TblCrewsRev createTblCrewsRev(@RequestBody TblCrewsRev tblCrewsRev) {
		LOGGER.debug("Create TblCrewsRev with information: {}" , tblCrewsRev);

		tblCrewsRev = tblCrewsRevService.create(tblCrewsRev);
		LOGGER.debug("Created TblCrewsRev with information: {}" , tblCrewsRev);

	    return tblCrewsRev;
	}

    @ApiOperation(value = "Returns the TblCrewsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public TblCrewsRev getTblCrewsRev(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting TblCrewsRev with id: {}" , id);

        TblCrewsRev foundTblCrewsRev = tblCrewsRevService.getById(id);
        LOGGER.debug("TblCrewsRev details with id: {}" , foundTblCrewsRev);

        return foundTblCrewsRev;
    }

    @ApiOperation(value = "Updates the TblCrewsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TblCrewsRev editTblCrewsRev(@PathVariable("id") Integer id, @RequestBody TblCrewsRev tblCrewsRev) {
        LOGGER.debug("Editing TblCrewsRev with id: {}" , tblCrewsRev.getId());

        tblCrewsRev.setId(id);
        tblCrewsRev = tblCrewsRevService.update(tblCrewsRev);
        LOGGER.debug("TblCrewsRev details with id: {}" , tblCrewsRev);

        return tblCrewsRev;
    }

    @ApiOperation(value = "Deletes the TblCrewsRev instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteTblCrewsRev(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting TblCrewsRev with id: {}" , id);

        TblCrewsRev deletedTblCrewsRev = tblCrewsRevService.delete(id);

        return deletedTblCrewsRev != null;
    }

    /**
     * @deprecated Use {@link #findTblCrewsRevs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TblCrewsRev instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblCrewsRev> searchTblCrewsRevsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TblCrewsRevs list by query filter:{}", (Object) queryFilters);
        return tblCrewsRevService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TblCrewsRev instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblCrewsRev> findTblCrewsRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TblCrewsRevs list by filter:", query);
        return tblCrewsRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TblCrewsRev instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblCrewsRev> filterTblCrewsRevs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TblCrewsRevs list by filter", query);
        return tblCrewsRevService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTblCrewsRevs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return tblCrewsRevService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of TblCrewsRev instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTblCrewsRevs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TblCrewsRevs");
		return tblCrewsRevService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTblCrewsRevAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return tblCrewsRevService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TblCrewsRevService instance
	 */
	protected void setTblCrewsRevService(TblCrewsRevService service) {
		this.tblCrewsRevService = service;
	}

}

