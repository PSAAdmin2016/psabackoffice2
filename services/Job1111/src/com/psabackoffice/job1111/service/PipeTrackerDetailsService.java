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

import com.psabackoffice.job1111.PipeTrackerDetails;

/**
 * Service object for domain model class {@link PipeTrackerDetails}.
 */
public interface PipeTrackerDetailsService {

    /**
     * Creates a new PipeTrackerDetails. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on PipeTrackerDetails if any.
     *
     * @param pipeTrackerDetails Details of the PipeTrackerDetails to be created; value cannot be null.
     * @return The newly created PipeTrackerDetails.
     */
	PipeTrackerDetails create(PipeTrackerDetails pipeTrackerDetails);


	/**
	 * Returns PipeTrackerDetails by given id if exists.
	 *
	 * @param pipetrackerdetailsId The id of the PipeTrackerDetails to get; value cannot be null.
	 * @return PipeTrackerDetails associated with the given pipetrackerdetailsId.
     * @throws EntityNotFoundException If no PipeTrackerDetails is found.
	 */
	PipeTrackerDetails getById(Integer pipetrackerdetailsId) throws EntityNotFoundException;

    /**
	 * Find and return the PipeTrackerDetails by given id if exists, returns null otherwise.
	 *
	 * @param pipetrackerdetailsId The id of the PipeTrackerDetails to get; value cannot be null.
	 * @return PipeTrackerDetails associated with the given pipetrackerdetailsId.
	 */
	PipeTrackerDetails findById(Integer pipetrackerdetailsId);


	/**
	 * Updates the details of an existing PipeTrackerDetails. It replaces all fields of the existing PipeTrackerDetails with the given pipeTrackerDetails.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on PipeTrackerDetails if any.
     *
	 * @param pipeTrackerDetails The details of the PipeTrackerDetails to be updated; value cannot be null.
	 * @return The updated PipeTrackerDetails.
	 * @throws EntityNotFoundException if no PipeTrackerDetails is found with given input.
	 */
	PipeTrackerDetails update(PipeTrackerDetails pipeTrackerDetails) throws EntityNotFoundException;

    /**
	 * Deletes an existing PipeTrackerDetails with the given id.
	 *
	 * @param pipetrackerdetailsId The id of the PipeTrackerDetails to be deleted; value cannot be null.
	 * @return The deleted PipeTrackerDetails.
	 * @throws EntityNotFoundException if no PipeTrackerDetails found with the given id.
	 */
	PipeTrackerDetails delete(Integer pipetrackerdetailsId) throws EntityNotFoundException;

	/**
	 * Find all PipeTrackerDetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PipeTrackerDetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<PipeTrackerDetails> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all PipeTrackerDetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching PipeTrackerDetails.
     *
     * @see Pageable
     * @see Page
	 */
    Page<PipeTrackerDetails> findAll(String query, Pageable pageable);

    /**
	 * Exports all PipeTrackerDetails matching the given input query to the given exportType format.
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
	 * Retrieve the count of the PipeTrackerDetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the PipeTrackerDetails.
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
