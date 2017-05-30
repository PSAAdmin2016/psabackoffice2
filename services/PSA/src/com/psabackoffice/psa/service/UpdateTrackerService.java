/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.psa.UpdateTracker;

/**
 * Service object for domain model class {@link UpdateTracker}.
 */
public interface UpdateTrackerService {

    /**
     * Creates a new UpdateTracker. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on UpdateTracker if any.
     *
     * @param updateTracker Details of the UpdateTracker to be created; value cannot be null.
     * @return The newly created UpdateTracker.
     */
	UpdateTracker create(UpdateTracker updateTracker);


	/**
	 * Returns UpdateTracker by given id if exists.
	 *
	 * @param updatetrackerId The id of the UpdateTracker to get; value cannot be null.
	 * @return UpdateTracker associated with the given updatetrackerId.
     * @throws EntityNotFoundException If no UpdateTracker is found.
	 */
	UpdateTracker getById(String updatetrackerId) throws EntityNotFoundException;

    /**
	 * Find and return the UpdateTracker by given id if exists, returns null otherwise.
	 *
	 * @param updatetrackerId The id of the UpdateTracker to get; value cannot be null.
	 * @return UpdateTracker associated with the given updatetrackerId.
	 */
	UpdateTracker findById(String updatetrackerId);


	/**
	 * Updates the details of an existing UpdateTracker. It replaces all fields of the existing UpdateTracker with the given updateTracker.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on UpdateTracker if any.
     *
	 * @param updateTracker The details of the UpdateTracker to be updated; value cannot be null.
	 * @return The updated UpdateTracker.
	 * @throws EntityNotFoundException if no UpdateTracker is found with given input.
	 */
	UpdateTracker update(UpdateTracker updateTracker) throws EntityNotFoundException;

    /**
	 * Deletes an existing UpdateTracker with the given id.
	 *
	 * @param updatetrackerId The id of the UpdateTracker to be deleted; value cannot be null.
	 * @return The deleted UpdateTracker.
	 * @throws EntityNotFoundException if no UpdateTracker found with the given id.
	 */
	UpdateTracker delete(String updatetrackerId) throws EntityNotFoundException;

	/**
	 * Find all UpdateTrackers matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UpdateTrackers.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<UpdateTracker> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all UpdateTrackers matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UpdateTrackers.
     *
     * @see Pageable
     * @see Page
	 */
    Page<UpdateTracker> findAll(String query, Pageable pageable);

    /**
	 * Exports all UpdateTrackers matching the given input query to the given exportType format.
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
	 * Retrieve the count of the UpdateTrackers in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the UpdateTracker.
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

