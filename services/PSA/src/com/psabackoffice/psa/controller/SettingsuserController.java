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

import com.psabackoffice.psa.Settingsuser;
import com.psabackoffice.psa.service.SettingsuserService;


/**
 * Controller object for domain model class Settingsuser.
 * @see Settingsuser
 */
@RestController("PSA.SettingsuserController")
@Api(value = "SettingsuserController", description = "Exposes APIs to work with Settingsuser resource.")
@RequestMapping("/PSA/Settingsuser")
public class SettingsuserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingsuserController.class);

    @Autowired
	@Qualifier("PSA.SettingsuserService")
	private SettingsuserService settingsuserService;

	@ApiOperation(value = "Creates a new Settingsuser instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Settingsuser createSettingsuser(@RequestBody Settingsuser settingsuser) {
		LOGGER.debug("Create Settingsuser with information: {}" , settingsuser);

		settingsuser = settingsuserService.create(settingsuser);
		LOGGER.debug("Created Settingsuser with information: {}" , settingsuser);

	    return settingsuser;
	}

    @ApiOperation(value = "Returns the Settingsuser instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Settingsuser getSettingsuser(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Settingsuser with id: {}" , id);

        Settingsuser foundSettingsuser = settingsuserService.getById(id);
        LOGGER.debug("Settingsuser details with id: {}" , foundSettingsuser);

        return foundSettingsuser;
    }

    @ApiOperation(value = "Updates the Settingsuser instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Settingsuser editSettingsuser(@PathVariable("id") Integer id, @RequestBody Settingsuser settingsuser) {
        LOGGER.debug("Editing Settingsuser with id: {}" , settingsuser.getId());

        settingsuser.setId(id);
        settingsuser = settingsuserService.update(settingsuser);
        LOGGER.debug("Settingsuser details with id: {}" , settingsuser);

        return settingsuser;
    }

    @ApiOperation(value = "Deletes the Settingsuser instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteSettingsuser(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Settingsuser with id: {}" , id);

        Settingsuser deletedSettingsuser = settingsuserService.delete(id);

        return deletedSettingsuser != null;
    }

    /**
     * @deprecated Use {@link #findSettingsusers(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Settingsuser instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Settingsuser> searchSettingsusersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Settingsusers list by query filter:{}", (Object) queryFilters);
        return settingsuserService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Settingsuser instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Settingsuser> findSettingsusers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Settingsusers list by filter:", query);
        return settingsuserService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Settingsuser instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Settingsuser> filterSettingsusers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Settingsusers list by filter", query);
        return settingsuserService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSettingsusers(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return settingsuserService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Settingsuser instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSettingsusers( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Settingsusers");
		return settingsuserService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSettingsuserAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return settingsuserService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SettingsuserService instance
	 */
	protected void setSettingsuserService(SettingsuserService service) {
		this.settingsuserService = service;
	}

}

