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

import com.psabackoffice.psa.MenuHelpVideos;
import com.psabackoffice.psa.MenuSubHelpVideos;
import com.psabackoffice.psa.service.MenuHelpVideosService;


/**
 * Controller object for domain model class MenuHelpVideos.
 * @see MenuHelpVideos
 */
@RestController("PSA.MenuHelpVideosController")
@Api(value = "MenuHelpVideosController", description = "Exposes APIs to work with MenuHelpVideos resource.")
@RequestMapping("/PSA/MenuHelpVideos")
public class MenuHelpVideosController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuHelpVideosController.class);

    @Autowired
	@Qualifier("PSA.MenuHelpVideosService")
	private MenuHelpVideosService menuHelpVideosService;

	@ApiOperation(value = "Creates a new MenuHelpVideos instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public MenuHelpVideos createMenuHelpVideos(@RequestBody MenuHelpVideos menuHelpVideos) {
		LOGGER.debug("Create MenuHelpVideos with information: {}" , menuHelpVideos);

		menuHelpVideos = menuHelpVideosService.create(menuHelpVideos);
		LOGGER.debug("Created MenuHelpVideos with information: {}" , menuHelpVideos);

	    return menuHelpVideos;
	}

    @ApiOperation(value = "Returns the MenuHelpVideos instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public MenuHelpVideos getMenuHelpVideos(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting MenuHelpVideos with id: {}" , id);

        MenuHelpVideos foundMenuHelpVideos = menuHelpVideosService.getById(id);
        LOGGER.debug("MenuHelpVideos details with id: {}" , foundMenuHelpVideos);

        return foundMenuHelpVideos;
    }

    @ApiOperation(value = "Updates the MenuHelpVideos instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public MenuHelpVideos editMenuHelpVideos(@PathVariable("id") Integer id, @RequestBody MenuHelpVideos menuHelpVideos) {
        LOGGER.debug("Editing MenuHelpVideos with id: {}" , menuHelpVideos.getId());

        menuHelpVideos.setId(id);
        menuHelpVideos = menuHelpVideosService.update(menuHelpVideos);
        LOGGER.debug("MenuHelpVideos details with id: {}" , menuHelpVideos);

        return menuHelpVideos;
    }

    @ApiOperation(value = "Deletes the MenuHelpVideos instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteMenuHelpVideos(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting MenuHelpVideos with id: {}" , id);

        MenuHelpVideos deletedMenuHelpVideos = menuHelpVideosService.delete(id);

        return deletedMenuHelpVideos != null;
    }

    /**
     * @deprecated Use {@link #findMenuHelpVideos(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of MenuHelpVideos instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<MenuHelpVideos> searchMenuHelpVideosByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering MenuHelpVideos list by query filter:{}", (Object) queryFilters);
        return menuHelpVideosService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of MenuHelpVideos instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<MenuHelpVideos> findMenuHelpVideos(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering MenuHelpVideos list by filter:", query);
        return menuHelpVideosService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of MenuHelpVideos instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<MenuHelpVideos> filterMenuHelpVideos(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering MenuHelpVideos list by filter", query);
        return menuHelpVideosService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportMenuHelpVideos(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return menuHelpVideosService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of MenuHelpVideos instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countMenuHelpVideos( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting MenuHelpVideos");
		return menuHelpVideosService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getMenuHelpVideosAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return menuHelpVideosService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/menuSubHelpVideoses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the menuSubHelpVideoses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<MenuSubHelpVideos> findAssociatedMenuSubHelpVideoses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated menuSubHelpVideoses");
        return menuHelpVideosService.findAssociatedMenuSubHelpVideoses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service MenuHelpVideosService instance
	 */
	protected void setMenuHelpVideosService(MenuHelpVideosService service) {
		this.menuHelpVideosService = service;
	}

}

