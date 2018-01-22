/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.job1111.LandingTrackerSteel;

/**
 * Service object for domain model class {@link LandingTrackerSteel}.
 */
public interface LandingTrackerSteelService {

    /**
     * Creates a new LandingTrackerSteel. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on LandingTrackerSteel if any.
     *
     * @param landingTrackerSteel Details of the LandingTrackerSteel to be created; value cannot be null.
     * @return The newly created LandingTrackerSteel.
     */
	LandingTrackerSteel create(@Valid LandingTrackerSteel landingTrackerSteel);


	/**
	 * Returns LandingTrackerSteel by given id if exists.
	 *
	 * @param landingtrackersteelId The id of the LandingTrackerSteel to get; value cannot be null.
	 * @return LandingTrackerSteel associated with the given landingtrackersteelId.
     * @throws EntityNotFoundException If no LandingTrackerSteel is found.
	 */
	LandingTrackerSteel getById(Integer landingtrackersteelId) throws EntityNotFoundException;

    /**
	 * Find and return the LandingTrackerSteel by given id if exists, returns null otherwise.
	 *
	 * @param landingtrackersteelId The id of the LandingTrackerSteel to get; value cannot be null.
	 * @return LandingTrackerSteel associated with the given landingtrackersteelId.
	 */
	LandingTrackerSteel findById(Integer landingtrackersteelId);


	/**
	 * Updates the details of an existing LandingTrackerSteel. It replaces all fields of the existing LandingTrackerSteel with the given landingTrackerSteel.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on LandingTrackerSteel if any.
     *
	 * @param landingTrackerSteel The details of the LandingTrackerSteel to be updated; value cannot be null.
	 * @return The updated LandingTrackerSteel.
	 * @throws EntityNotFoundException if no LandingTrackerSteel is found with given input.
	 */
	LandingTrackerSteel update(@Valid LandingTrackerSteel landingTrackerSteel) throws EntityNotFoundException;

    /**
	 * Deletes an existing LandingTrackerSteel with the given id.
	 *
	 * @param landingtrackersteelId The id of the LandingTrackerSteel to be deleted; value cannot be null.
	 * @return The deleted LandingTrackerSteel.
	 * @throws EntityNotFoundException if no LandingTrackerSteel found with the given id.
	 */
	LandingTrackerSteel delete(Integer landingtrackersteelId) throws EntityNotFoundException;

	/**
	 * Find all LandingTrackerSteels matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching LandingTrackerSteels.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<LandingTrackerSteel> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all LandingTrackerSteels matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching LandingTrackerSteels.
     *
     * @see Pageable
     * @see Page
	 */
    Page<LandingTrackerSteel> findAll(String query, Pageable pageable);

    /**
	 * Exports all LandingTrackerSteels matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the LandingTrackerSteels in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the LandingTrackerSteel.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

