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

import com.psabackoffice.job1111.SubsSupports;
import com.psabackoffice.job1111.SubsSupportsRev;

/**
 * Service object for domain model class {@link SubsSupports}.
 */
public interface SubsSupportsService {

    /**
     * Creates a new SubsSupports. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SubsSupports if any.
     *
     * @param subsSupports Details of the SubsSupports to be created; value cannot be null.
     * @return The newly created SubsSupports.
     */
	SubsSupports create(SubsSupports subsSupports);


	/**
	 * Returns SubsSupports by given id if exists.
	 *
	 * @param subssupportsId The id of the SubsSupports to get; value cannot be null.
	 * @return SubsSupports associated with the given subssupportsId.
     * @throws EntityNotFoundException If no SubsSupports is found.
	 */
	SubsSupports getById(Integer subssupportsId) throws EntityNotFoundException;

    /**
	 * Find and return the SubsSupports by given id if exists, returns null otherwise.
	 *
	 * @param subssupportsId The id of the SubsSupports to get; value cannot be null.
	 * @return SubsSupports associated with the given subssupportsId.
	 */
	SubsSupports findById(Integer subssupportsId);


	/**
	 * Updates the details of an existing SubsSupports. It replaces all fields of the existing SubsSupports with the given subsSupports.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on SubsSupports if any.
     *
	 * @param subsSupports The details of the SubsSupports to be updated; value cannot be null.
	 * @return The updated SubsSupports.
	 * @throws EntityNotFoundException if no SubsSupports is found with given input.
	 */
	SubsSupports update(SubsSupports subsSupports) throws EntityNotFoundException;

    /**
	 * Deletes an existing SubsSupports with the given id.
	 *
	 * @param subssupportsId The id of the SubsSupports to be deleted; value cannot be null.
	 * @return The deleted SubsSupports.
	 * @throws EntityNotFoundException if no SubsSupports found with the given id.
	 */
	SubsSupports delete(Integer subssupportsId) throws EntityNotFoundException;

	/**
	 * Find all SubsSupports matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SubsSupports.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<SubsSupports> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all SubsSupports matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SubsSupports.
     *
     * @see Pageable
     * @see Page
	 */
    Page<SubsSupports> findAll(String query, Pageable pageable);

    /**
	 * Exports all SubsSupports matching the given input query to the given exportType format.
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
	 * Retrieve the count of the SubsSupports in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the SubsSupports.
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

    /*
     * Returns the associated subsSupportsRevs for given SubsSupports id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated SubsSupportsRev instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<SubsSupportsRev> findAssociatedSubsSupportsRevs(Integer id, Pageable pageable);

}

