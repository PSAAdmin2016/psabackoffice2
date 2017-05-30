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

import com.psabackoffice.psa.RefTrimActivities;

/**
 * Service object for domain model class {@link RefTrimActivities}.
 */
public interface RefTrimActivitiesService {

    /**
     * Creates a new RefTrimActivities. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RefTrimActivities if any.
     *
     * @param refTrimActivities Details of the RefTrimActivities to be created; value cannot be null.
     * @return The newly created RefTrimActivities.
     */
	RefTrimActivities create(RefTrimActivities refTrimActivities);


	/**
	 * Returns RefTrimActivities by given id if exists.
	 *
	 * @param reftrimactivitiesId The id of the RefTrimActivities to get; value cannot be null.
	 * @return RefTrimActivities associated with the given reftrimactivitiesId.
     * @throws EntityNotFoundException If no RefTrimActivities is found.
	 */
	RefTrimActivities getById(Integer reftrimactivitiesId) throws EntityNotFoundException;

    /**
	 * Find and return the RefTrimActivities by given id if exists, returns null otherwise.
	 *
	 * @param reftrimactivitiesId The id of the RefTrimActivities to get; value cannot be null.
	 * @return RefTrimActivities associated with the given reftrimactivitiesId.
	 */
	RefTrimActivities findById(Integer reftrimactivitiesId);


	/**
	 * Updates the details of an existing RefTrimActivities. It replaces all fields of the existing RefTrimActivities with the given refTrimActivities.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RefTrimActivities if any.
     *
	 * @param refTrimActivities The details of the RefTrimActivities to be updated; value cannot be null.
	 * @return The updated RefTrimActivities.
	 * @throws EntityNotFoundException if no RefTrimActivities is found with given input.
	 */
	RefTrimActivities update(RefTrimActivities refTrimActivities) throws EntityNotFoundException;

    /**
	 * Deletes an existing RefTrimActivities with the given id.
	 *
	 * @param reftrimactivitiesId The id of the RefTrimActivities to be deleted; value cannot be null.
	 * @return The deleted RefTrimActivities.
	 * @throws EntityNotFoundException if no RefTrimActivities found with the given id.
	 */
	RefTrimActivities delete(Integer reftrimactivitiesId) throws EntityNotFoundException;

	/**
	 * Find all RefTrimActivities matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefTrimActivities.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RefTrimActivities> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RefTrimActivities matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefTrimActivities.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RefTrimActivities> findAll(String query, Pageable pageable);

    /**
	 * Exports all RefTrimActivities matching the given input query to the given exportType format.
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
	 * Retrieve the count of the RefTrimActivities in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RefTrimActivities.
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

