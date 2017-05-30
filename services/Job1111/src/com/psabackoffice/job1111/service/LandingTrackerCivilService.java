/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.job1111.LandingTrackerCivil;

/**
 * Service object for domain model class {@link LandingTrackerCivil}.
 */
public interface LandingTrackerCivilService {

    /**
     * Creates a new LandingTrackerCivil. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on LandingTrackerCivil if any.
     *
     * @param landingTrackerCivil Details of the LandingTrackerCivil to be created; value cannot be null.
     * @return The newly created LandingTrackerCivil.
     */
	LandingTrackerCivil create(LandingTrackerCivil landingTrackerCivil);


	/**
	 * Returns LandingTrackerCivil by given id if exists.
	 *
	 * @param landingtrackercivilId The id of the LandingTrackerCivil to get; value cannot be null.
	 * @return LandingTrackerCivil associated with the given landingtrackercivilId.
     * @throws EntityNotFoundException If no LandingTrackerCivil is found.
	 */
	LandingTrackerCivil getById(Integer landingtrackercivilId) throws EntityNotFoundException;

    /**
	 * Find and return the LandingTrackerCivil by given id if exists, returns null otherwise.
	 *
	 * @param landingtrackercivilId The id of the LandingTrackerCivil to get; value cannot be null.
	 * @return LandingTrackerCivil associated with the given landingtrackercivilId.
	 */
	LandingTrackerCivil findById(Integer landingtrackercivilId);


	/**
	 * Updates the details of an existing LandingTrackerCivil. It replaces all fields of the existing LandingTrackerCivil with the given landingTrackerCivil.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on LandingTrackerCivil if any.
     *
	 * @param landingTrackerCivil The details of the LandingTrackerCivil to be updated; value cannot be null.
	 * @return The updated LandingTrackerCivil.
	 * @throws EntityNotFoundException if no LandingTrackerCivil is found with given input.
	 */
	LandingTrackerCivil update(LandingTrackerCivil landingTrackerCivil) throws EntityNotFoundException;

    /**
	 * Deletes an existing LandingTrackerCivil with the given id.
	 *
	 * @param landingtrackercivilId The id of the LandingTrackerCivil to be deleted; value cannot be null.
	 * @return The deleted LandingTrackerCivil.
	 * @throws EntityNotFoundException if no LandingTrackerCivil found with the given id.
	 */
	LandingTrackerCivil delete(Integer landingtrackercivilId) throws EntityNotFoundException;

	/**
	 * Find all LandingTrackerCivils matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching LandingTrackerCivils.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<LandingTrackerCivil> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all LandingTrackerCivils matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching LandingTrackerCivils.
     *
     * @see Pageable
     * @see Page
	 */
    Page<LandingTrackerCivil> findAll(String query, Pageable pageable);

    /**
	 * Exports all LandingTrackerCivils matching the given input query to the given exportType format.
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
	 * Retrieve the count of the LandingTrackerCivils in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the LandingTrackerCivil.
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

