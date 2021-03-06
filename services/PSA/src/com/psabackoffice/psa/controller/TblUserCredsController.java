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

import com.psabackoffice.psa.TblUserCreds;
import com.psabackoffice.psa.service.TblUserCredsService;


/**
 * Controller object for domain model class TblUserCreds.
 * @see TblUserCreds
 */
@RestController("PSA.TblUserCredsController")
@Api(value = "TblUserCredsController", description = "Exposes APIs to work with TblUserCreds resource.")
@RequestMapping("/PSA/TblUserCreds")
public class TblUserCredsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TblUserCredsController.class);

    @Autowired
	@Qualifier("PSA.TblUserCredsService")
	private TblUserCredsService tblUserCredsService;

	@ApiOperation(value = "Creates a new TblUserCreds instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TblUserCreds createTblUserCreds(@RequestBody TblUserCreds tblUserCreds) {
		LOGGER.debug("Create TblUserCreds with information: {}" , tblUserCreds);

		tblUserCreds = tblUserCredsService.create(tblUserCreds);
		LOGGER.debug("Created TblUserCreds with information: {}" , tblUserCreds);

	    return tblUserCreds;
	}

    @ApiOperation(value = "Returns the TblUserCreds instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public TblUserCreds getTblUserCreds(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting TblUserCreds with id: {}" , id);

        TblUserCreds foundTblUserCreds = tblUserCredsService.getById(id);
        LOGGER.debug("TblUserCreds details with id: {}" , foundTblUserCreds);

        return foundTblUserCreds;
    }

    @ApiOperation(value = "Updates the TblUserCreds instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TblUserCreds editTblUserCreds(@PathVariable("id") Integer id, @RequestBody TblUserCreds tblUserCreds) {
        LOGGER.debug("Editing TblUserCreds with id: {}" , tblUserCreds.getUserId());

        tblUserCreds.setUserId(id);
        tblUserCreds = tblUserCredsService.update(tblUserCreds);
        LOGGER.debug("TblUserCreds details with id: {}" , tblUserCreds);

        return tblUserCreds;
    }

    @ApiOperation(value = "Deletes the TblUserCreds instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteTblUserCreds(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting TblUserCreds with id: {}" , id);

        TblUserCreds deletedTblUserCreds = tblUserCredsService.delete(id);

        return deletedTblUserCreds != null;
    }

    /**
     * @deprecated Use {@link #findTblUserCreds(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TblUserCreds instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblUserCreds> searchTblUserCredsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TblUserCreds list by query filter:{}", (Object) queryFilters);
        return tblUserCredsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TblUserCreds instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblUserCreds> findTblUserCreds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TblUserCreds list by filter:", query);
        return tblUserCredsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TblUserCreds instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblUserCreds> filterTblUserCreds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TblUserCreds list by filter", query);
        return tblUserCredsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTblUserCreds(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return tblUserCredsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of TblUserCreds instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTblUserCreds( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TblUserCreds");
		return tblUserCredsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTblUserCredsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return tblUserCredsService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TblUserCredsService instance
	 */
	protected void setTblUserCredsService(TblUserCredsService service) {
		this.tblUserCredsService = service;
	}

}

