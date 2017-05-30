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

import com.psabackoffice.psa.RefRoles;
import com.psabackoffice.psa.RefRolesMobileFolders;
import com.psabackoffice.psa.TblUserPsa;
import com.psabackoffice.psa.service.RefRolesService;


/**
 * Controller object for domain model class RefRoles.
 * @see RefRoles
 */
@RestController("PSA.RefRolesController")
@Api(value = "RefRolesController", description = "Exposes APIs to work with RefRoles resource.")
@RequestMapping("/PSA/RefRoles")
public class RefRolesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefRolesController.class);

    @Autowired
	@Qualifier("PSA.RefRolesService")
	private RefRolesService refRolesService;

	@ApiOperation(value = "Creates a new RefRoles instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public RefRoles createRefRoles(@RequestBody RefRoles refRoles) {
		LOGGER.debug("Create RefRoles with information: {}" , refRoles);

		refRoles = refRolesService.create(refRoles);
		LOGGER.debug("Created RefRoles with information: {}" , refRoles);

	    return refRoles;
	}


    @ApiOperation(value = "Returns the RefRoles instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefRoles getRefRoles(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting RefRoles with id: {}" , id);

        RefRoles foundRefRoles = refRolesService.getById(id);
        LOGGER.debug("RefRoles details with id: {}" , foundRefRoles);

        return foundRefRoles;
    }

    @ApiOperation(value = "Updates the RefRoles instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefRoles editRefRoles(@PathVariable("id") Integer id, @RequestBody RefRoles refRoles) throws EntityNotFoundException {
        LOGGER.debug("Editing RefRoles with id: {}" , refRoles.getId());

        refRoles.setId(id);
        refRoles = refRolesService.update(refRoles);
        LOGGER.debug("RefRoles details with id: {}" , refRoles);

        return refRoles;
    }

    @ApiOperation(value = "Deletes the RefRoles instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRefRoles(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefRoles with id: {}" , id);

        RefRoles deletedRefRoles = refRolesService.delete(id);

        return deletedRefRoles != null;
    }

    /**
     * @deprecated Use {@link #findRefRoles(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefRoles instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefRoles> searchRefRolesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefRoles list");
        return refRolesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefRoles instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefRoles> findRefRoles(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefRoles list");
        return refRolesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefRoles instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefRoles> filterRefRoles(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefRoles list");
        return refRolesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefRoles(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refRolesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefRoles instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefRoles( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefRoles");
		return refRolesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefRolesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refRolesService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/refRolesMobileFolderses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the refRolesMobileFolderses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefRolesMobileFolders> findAssociatedRefRolesMobileFolderses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated refRolesMobileFolderses");
        return refRolesService.findAssociatedRefRolesMobileFolderses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/tblUserPsas", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the tblUserPsas instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblUserPsa> findAssociatedTblUserPsas(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated tblUserPsas");
        return refRolesService.findAssociatedTblUserPsas(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefRolesService instance
	 */
	protected void setRefRolesService(RefRolesService service) {
		this.refRolesService = service;
	}

}

