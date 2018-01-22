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

import com.psabackoffice.job1111.SteelSellPackage;
import com.psabackoffice.job1111.service.SteelSellPackageService;


/**
 * Controller object for domain model class SteelSellPackage.
 * @see SteelSellPackage
 */
@RestController("Job1111.SteelSellPackageController")
@Api(value = "SteelSellPackageController", description = "Exposes APIs to work with SteelSellPackage resource.")
@RequestMapping("/Job1111/SteelSellPackage")
public class SteelSellPackageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteelSellPackageController.class);

    @Autowired
	@Qualifier("Job1111.SteelSellPackageService")
	private SteelSellPackageService steelSellPackageService;

	@ApiOperation(value = "Creates a new SteelSellPackage instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelSellPackage createSteelSellPackage(@RequestBody SteelSellPackage steelSellPackage) {
		LOGGER.debug("Create SteelSellPackage with information: {}" , steelSellPackage);

		steelSellPackage = steelSellPackageService.create(steelSellPackage);
		LOGGER.debug("Created SteelSellPackage with information: {}" , steelSellPackage);

	    return steelSellPackage;
	}

    @ApiOperation(value = "Returns the SteelSellPackage instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelSellPackage getSteelSellPackage(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting SteelSellPackage with id: {}" , id);

        SteelSellPackage foundSteelSellPackage = steelSellPackageService.getById(id);
        LOGGER.debug("SteelSellPackage details with id: {}" , foundSteelSellPackage);

        return foundSteelSellPackage;
    }

    @ApiOperation(value = "Updates the SteelSellPackage instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SteelSellPackage editSteelSellPackage(@PathVariable("id") Integer id, @RequestBody SteelSellPackage steelSellPackage) throws EntityNotFoundException {
        LOGGER.debug("Editing SteelSellPackage with id: {}" , steelSellPackage.getId());

        steelSellPackage.setId(id);
        steelSellPackage = steelSellPackageService.update(steelSellPackage);
        LOGGER.debug("SteelSellPackage details with id: {}" , steelSellPackage);

        return steelSellPackage;
    }

    @ApiOperation(value = "Deletes the SteelSellPackage instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSteelSellPackage(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting SteelSellPackage with id: {}" , id);

        SteelSellPackage deletedSteelSellPackage = steelSellPackageService.delete(id);

        return deletedSteelSellPackage != null;
    }

    /**
     * @deprecated Use {@link #findSteelSellPackages(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SteelSellPackage instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelSellPackage> searchSteelSellPackagesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SteelSellPackages list");
        return steelSellPackageService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelSellPackage instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelSellPackage> findSteelSellPackages(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelSellPackages list");
        return steelSellPackageService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SteelSellPackage instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SteelSellPackage> filterSteelSellPackages(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SteelSellPackages list");
        return steelSellPackageService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSteelSellPackages(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return steelSellPackageService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of SteelSellPackage instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSteelSellPackages( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SteelSellPackages");
		return steelSellPackageService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSteelSellPackageAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return steelSellPackageService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SteelSellPackageService instance
	 */
	protected void setSteelSellPackageService(SteelSellPackageService service) {
		this.steelSellPackageService = service;
	}

}

