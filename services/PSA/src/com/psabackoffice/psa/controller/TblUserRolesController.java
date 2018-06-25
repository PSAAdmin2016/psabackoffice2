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

import com.psabackoffice.psa.TblUserRoles;
import com.psabackoffice.psa.service.TblUserRolesService;


/**
 * Controller object for domain model class TblUserRoles.
 * @see TblUserRoles
 */
@RestController("PSA.TblUserRolesController")
@Api(value = "TblUserRolesController", description = "Exposes APIs to work with TblUserRoles resource.")
@RequestMapping("/PSA/TblUserRoles")
public class TblUserRolesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TblUserRolesController.class);

    @Autowired
	@Qualifier("PSA.TblUserRolesService")
	private TblUserRolesService tblUserRolesService;

	@ApiOperation(value = "Creates a new TblUserRoles instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TblUserRoles createTblUserRoles(@RequestBody TblUserRoles tblUserRoles) {
		LOGGER.debug("Create TblUserRoles with information: {}" , tblUserRoles);

		tblUserRoles = tblUserRolesService.create(tblUserRoles);
		LOGGER.debug("Created TblUserRoles with information: {}" , tblUserRoles);

	    return tblUserRoles;
	}

    @ApiOperation(value = "Returns the TblUserRoles instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public TblUserRoles getTblUserRoles(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting TblUserRoles with id: {}" , id);

        TblUserRoles foundTblUserRoles = tblUserRolesService.getById(id);
        LOGGER.debug("TblUserRoles details with id: {}" , foundTblUserRoles);

        return foundTblUserRoles;
    }

    @ApiOperation(value = "Updates the TblUserRoles instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TblUserRoles editTblUserRoles(@PathVariable("id") Integer id, @RequestBody TblUserRoles tblUserRoles) {
        LOGGER.debug("Editing TblUserRoles with id: {}" , tblUserRoles.getId());

        tblUserRoles.setId(id);
        tblUserRoles = tblUserRolesService.update(tblUserRoles);
        LOGGER.debug("TblUserRoles details with id: {}" , tblUserRoles);

        return tblUserRoles;
    }

    @ApiOperation(value = "Deletes the TblUserRoles instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteTblUserRoles(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting TblUserRoles with id: {}" , id);

        TblUserRoles deletedTblUserRoles = tblUserRolesService.delete(id);

        return deletedTblUserRoles != null;
    }

    /**
     * @deprecated Use {@link #findTblUserRoles(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TblUserRoles instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblUserRoles> searchTblUserRolesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TblUserRoles list by query filter:{}", (Object) queryFilters);
        return tblUserRolesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TblUserRoles instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblUserRoles> findTblUserRoles(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TblUserRoles list by filter:", query);
        return tblUserRolesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TblUserRoles instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblUserRoles> filterTblUserRoles(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TblUserRoles list by filter", query);
        return tblUserRolesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTblUserRoles(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return tblUserRolesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of TblUserRoles instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTblUserRoles( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TblUserRoles");
		return tblUserRolesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTblUserRolesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return tblUserRolesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TblUserRolesService instance
	 */
	protected void setTblUserRolesService(TblUserRolesService service) {
		this.tblUserRolesService = service;
	}

}

