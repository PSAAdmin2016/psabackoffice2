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

import com.psabackoffice.psa.Settings;
import com.psabackoffice.psa.service.SettingsService;


/**
 * Controller object for domain model class Settings.
 * @see Settings
 */
@RestController("PSA.SettingsController")
@Api(value = "SettingsController", description = "Exposes APIs to work with Settings resource.")
@RequestMapping("/PSA/Settings")
public class SettingsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingsController.class);

    @Autowired
	@Qualifier("PSA.SettingsService")
	private SettingsService settingsService;

	@ApiOperation(value = "Creates a new Settings instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Settings createSettings(@RequestBody Settings settings) {
		LOGGER.debug("Create Settings with information: {}" , settings);

		settings = settingsService.create(settings);
		LOGGER.debug("Created Settings with information: {}" , settings);

	    return settings;
	}

    @ApiOperation(value = "Returns the Settings instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Settings getSettings(@PathVariable("id") String id) {
        LOGGER.debug("Getting Settings with id: {}" , id);

        Settings foundSettings = settingsService.getById(id);
        LOGGER.debug("Settings details with id: {}" , foundSettings);

        return foundSettings;
    }

    @ApiOperation(value = "Updates the Settings instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Settings editSettings(@PathVariable("id") String id, @RequestBody Settings settings) {
        LOGGER.debug("Editing Settings with id: {}" , settings.getLabel());

        settings.setLabel(id);
        settings = settingsService.update(settings);
        LOGGER.debug("Settings details with id: {}" , settings);

        return settings;
    }

    @ApiOperation(value = "Deletes the Settings instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteSettings(@PathVariable("id") String id) {
        LOGGER.debug("Deleting Settings with id: {}" , id);

        Settings deletedSettings = settingsService.delete(id);

        return deletedSettings != null;
    }

    /**
     * @deprecated Use {@link #findSettings(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Settings instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Settings> searchSettingsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Settings list by query filter:{}", (Object) queryFilters);
        return settingsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Settings instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Settings> findSettings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Settings list by filter:", query);
        return settingsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Settings instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Settings> filterSettings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Settings list by filter", query);
        return settingsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSettings(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return settingsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Settings instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSettings( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Settings");
		return settingsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSettingsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return settingsService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SettingsService instance
	 */
	protected void setSettingsService(SettingsService service) {
		this.settingsService = service;
	}

}

