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

import com.psabackoffice.job1111.CacheRefSpoolInfo;
import com.psabackoffice.job1111.service.CacheRefSpoolInfoService;


/**
 * Controller object for domain model class CacheRefSpoolInfo.
 * @see CacheRefSpoolInfo
 */
@RestController("Job1111.CacheRefSpoolInfoController")
@Api(value = "CacheRefSpoolInfoController", description = "Exposes APIs to work with CacheRefSpoolInfo resource.")
@RequestMapping("/Job1111/CacheRefSpoolInfo")
public class CacheRefSpoolInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheRefSpoolInfoController.class);

    @Autowired
	@Qualifier("Job1111.CacheRefSpoolInfoService")
	private CacheRefSpoolInfoService cacheRefSpoolInfoService;

	@ApiOperation(value = "Creates a new CacheRefSpoolInfo instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public CacheRefSpoolInfo createCacheRefSpoolInfo(@RequestBody CacheRefSpoolInfo cacheRefSpoolInfo) {
		LOGGER.debug("Create CacheRefSpoolInfo with information: {}" , cacheRefSpoolInfo);

		cacheRefSpoolInfo = cacheRefSpoolInfoService.create(cacheRefSpoolInfo);
		LOGGER.debug("Created CacheRefSpoolInfo with information: {}" , cacheRefSpoolInfo);

	    return cacheRefSpoolInfo;
	}


    @ApiOperation(value = "Returns the CacheRefSpoolInfo instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CacheRefSpoolInfo getCacheRefSpoolInfo(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting CacheRefSpoolInfo with id: {}" , id);

        CacheRefSpoolInfo foundCacheRefSpoolInfo = cacheRefSpoolInfoService.getById(id);
        LOGGER.debug("CacheRefSpoolInfo details with id: {}" , foundCacheRefSpoolInfo);

        return foundCacheRefSpoolInfo;
    }

    @ApiOperation(value = "Updates the CacheRefSpoolInfo instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CacheRefSpoolInfo editCacheRefSpoolInfo(@PathVariable("id") Integer id, @RequestBody CacheRefSpoolInfo cacheRefSpoolInfo) throws EntityNotFoundException {
        LOGGER.debug("Editing CacheRefSpoolInfo with id: {}" , cacheRefSpoolInfo.getId());

        cacheRefSpoolInfo.setId(id);
        cacheRefSpoolInfo = cacheRefSpoolInfoService.update(cacheRefSpoolInfo);
        LOGGER.debug("CacheRefSpoolInfo details with id: {}" , cacheRefSpoolInfo);

        return cacheRefSpoolInfo;
    }

    @ApiOperation(value = "Deletes the CacheRefSpoolInfo instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCacheRefSpoolInfo(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting CacheRefSpoolInfo with id: {}" , id);

        CacheRefSpoolInfo deletedCacheRefSpoolInfo = cacheRefSpoolInfoService.delete(id);

        return deletedCacheRefSpoolInfo != null;
    }

    /**
     * @deprecated Use {@link #findCacheRefSpoolInfos(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of CacheRefSpoolInfo instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CacheRefSpoolInfo> searchCacheRefSpoolInfosByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CacheRefSpoolInfos list");
        return cacheRefSpoolInfoService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CacheRefSpoolInfo instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CacheRefSpoolInfo> findCacheRefSpoolInfos(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CacheRefSpoolInfos list");
        return cacheRefSpoolInfoService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CacheRefSpoolInfo instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CacheRefSpoolInfo> filterCacheRefSpoolInfos(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CacheRefSpoolInfos list");
        return cacheRefSpoolInfoService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCacheRefSpoolInfos(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return cacheRefSpoolInfoService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of CacheRefSpoolInfo instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countCacheRefSpoolInfos( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting CacheRefSpoolInfos");
		return cacheRefSpoolInfoService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getCacheRefSpoolInfoAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return cacheRefSpoolInfoService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CacheRefSpoolInfoService instance
	 */
	protected void setCacheRefSpoolInfoService(CacheRefSpoolInfoService service) {
		this.cacheRefSpoolInfoService = service;
	}

}

