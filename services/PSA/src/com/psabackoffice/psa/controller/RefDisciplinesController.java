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

import com.psabackoffice.psa.RefDisciplines;
import com.psabackoffice.psa.TblCrews;
import com.psabackoffice.psa.TblUserPsa;
import com.psabackoffice.psa.service.RefDisciplinesService;


/**
 * Controller object for domain model class RefDisciplines.
 * @see RefDisciplines
 */
@RestController("PSA.RefDisciplinesController")
@Api(value = "RefDisciplinesController", description = "Exposes APIs to work with RefDisciplines resource.")
@RequestMapping("/PSA/RefDisciplines")
public class RefDisciplinesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefDisciplinesController.class);

    @Autowired
	@Qualifier("PSA.RefDisciplinesService")
	private RefDisciplinesService refDisciplinesService;

	@ApiOperation(value = "Creates a new RefDisciplines instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefDisciplines createRefDisciplines(@RequestBody RefDisciplines refDisciplines) {
		LOGGER.debug("Create RefDisciplines with information: {}" , refDisciplines);

		refDisciplines = refDisciplinesService.create(refDisciplines);
		LOGGER.debug("Created RefDisciplines with information: {}" , refDisciplines);

	    return refDisciplines;
	}

    @ApiOperation(value = "Returns the RefDisciplines instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefDisciplines getRefDisciplines(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting RefDisciplines with id: {}" , id);

        RefDisciplines foundRefDisciplines = refDisciplinesService.getById(id);
        LOGGER.debug("RefDisciplines details with id: {}" , foundRefDisciplines);

        return foundRefDisciplines;
    }

    @ApiOperation(value = "Updates the RefDisciplines instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RefDisciplines editRefDisciplines(@PathVariable("id") Integer id, @RequestBody RefDisciplines refDisciplines) throws EntityNotFoundException {
        LOGGER.debug("Editing RefDisciplines with id: {}" , refDisciplines.getId());

        refDisciplines.setId(id);
        refDisciplines = refDisciplinesService.update(refDisciplines);
        LOGGER.debug("RefDisciplines details with id: {}" , refDisciplines);

        return refDisciplines;
    }

    @ApiOperation(value = "Deletes the RefDisciplines instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRefDisciplines(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting RefDisciplines with id: {}" , id);

        RefDisciplines deletedRefDisciplines = refDisciplinesService.delete(id);

        return deletedRefDisciplines != null;
    }

    /**
     * @deprecated Use {@link #findRefDisciplines(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RefDisciplines instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefDisciplines> searchRefDisciplinesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RefDisciplines list");
        return refDisciplinesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefDisciplines instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefDisciplines> findRefDisciplines(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefDisciplines list");
        return refDisciplinesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RefDisciplines instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RefDisciplines> filterRefDisciplines(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RefDisciplines list");
        return refDisciplinesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRefDisciplines(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return refDisciplinesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of RefDisciplines instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRefDisciplines( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RefDisciplines");
		return refDisciplinesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getRefDisciplinesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return refDisciplinesService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/tblCrewses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the tblCrewses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblCrews> findAssociatedTblCrewses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated tblCrewses");
        return refDisciplinesService.findAssociatedTblCrewses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/tblUserPsas", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the tblUserPsas instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TblUserPsa> findAssociatedTblUserPsas(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated tblUserPsas");
        return refDisciplinesService.findAssociatedTblUserPsas(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RefDisciplinesService instance
	 */
	protected void setRefDisciplinesService(RefDisciplinesService service) {
		this.refDisciplinesService = service;
	}

}

