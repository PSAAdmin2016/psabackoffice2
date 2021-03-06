/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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

import com.psabackoffice.job1111.SubsDelay;

/**
 * Service object for domain model class {@link SubsDelay}.
 */
public interface SubsDelayService {

    /**
     * Creates a new SubsDelay. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SubsDelay if any.
     *
     * @param subsDelay Details of the SubsDelay to be created; value cannot be null.
     * @return The newly created SubsDelay.
     */
	SubsDelay create(@Valid SubsDelay subsDelay);


	/**
	 * Returns SubsDelay by given id if exists.
	 *
	 * @param subsdelayId The id of the SubsDelay to get; value cannot be null.
	 * @return SubsDelay associated with the given subsdelayId.
     * @throws EntityNotFoundException If no SubsDelay is found.
	 */
	SubsDelay getById(Integer subsdelayId);

    /**
	 * Find and return the SubsDelay by given id if exists, returns null otherwise.
	 *
	 * @param subsdelayId The id of the SubsDelay to get; value cannot be null.
	 * @return SubsDelay associated with the given subsdelayId.
	 */
	SubsDelay findById(Integer subsdelayId);


	/**
	 * Updates the details of an existing SubsDelay. It replaces all fields of the existing SubsDelay with the given subsDelay.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on SubsDelay if any.
     *
	 * @param subsDelay The details of the SubsDelay to be updated; value cannot be null.
	 * @return The updated SubsDelay.
	 * @throws EntityNotFoundException if no SubsDelay is found with given input.
	 */
	SubsDelay update(@Valid SubsDelay subsDelay);

    /**
	 * Deletes an existing SubsDelay with the given id.
	 *
	 * @param subsdelayId The id of the SubsDelay to be deleted; value cannot be null.
	 * @return The deleted SubsDelay.
	 * @throws EntityNotFoundException if no SubsDelay found with the given id.
	 */
	SubsDelay delete(Integer subsdelayId);

    /**
	 * Deletes an existing SubsDelay with the given object.
	 *
	 * @param subsDelay The instance of the SubsDelay to be deleted; value cannot be null.
	 */
	void delete(SubsDelay subsDelay);

	/**
	 * Find all SubsDelays matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SubsDelays.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<SubsDelay> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all SubsDelays matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SubsDelays.
     *
     * @see Pageable
     * @see Page
	 */
    Page<SubsDelay> findAll(String query, Pageable pageable);

    /**
	 * Exports all SubsDelays matching the given input query to the given exportType format.
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
	 * Retrieve the count of the SubsDelays in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the SubsDelay.
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

