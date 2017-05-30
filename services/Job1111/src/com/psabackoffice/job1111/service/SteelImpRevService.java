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

import com.psabackoffice.job1111.SteelImpRev;

/**
 * Service object for domain model class {@link SteelImpRev}.
 */
public interface SteelImpRevService {

    /**
     * Creates a new SteelImpRev. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SteelImpRev if any.
     *
     * @param steelImpRev Details of the SteelImpRev to be created; value cannot be null.
     * @return The newly created SteelImpRev.
     */
	SteelImpRev create(SteelImpRev steelImpRev);


	/**
	 * Returns SteelImpRev by given id if exists.
	 *
	 * @param steelimprevId The id of the SteelImpRev to get; value cannot be null.
	 * @return SteelImpRev associated with the given steelimprevId.
     * @throws EntityNotFoundException If no SteelImpRev is found.
	 */
	SteelImpRev getById(Integer steelimprevId) throws EntityNotFoundException;

    /**
	 * Find and return the SteelImpRev by given id if exists, returns null otherwise.
	 *
	 * @param steelimprevId The id of the SteelImpRev to get; value cannot be null.
	 * @return SteelImpRev associated with the given steelimprevId.
	 */
	SteelImpRev findById(Integer steelimprevId);


	/**
	 * Updates the details of an existing SteelImpRev. It replaces all fields of the existing SteelImpRev with the given steelImpRev.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on SteelImpRev if any.
     *
	 * @param steelImpRev The details of the SteelImpRev to be updated; value cannot be null.
	 * @return The updated SteelImpRev.
	 * @throws EntityNotFoundException if no SteelImpRev is found with given input.
	 */
	SteelImpRev update(SteelImpRev steelImpRev) throws EntityNotFoundException;

    /**
	 * Deletes an existing SteelImpRev with the given id.
	 *
	 * @param steelimprevId The id of the SteelImpRev to be deleted; value cannot be null.
	 * @return The deleted SteelImpRev.
	 * @throws EntityNotFoundException if no SteelImpRev found with the given id.
	 */
	SteelImpRev delete(Integer steelimprevId) throws EntityNotFoundException;

	/**
	 * Find all SteelImpRevs matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SteelImpRevs.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<SteelImpRev> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all SteelImpRevs matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SteelImpRevs.
     *
     * @see Pageable
     * @see Page
	 */
    Page<SteelImpRev> findAll(String query, Pageable pageable);

    /**
	 * Exports all SteelImpRevs matching the given input query to the given exportType format.
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
	 * Retrieve the count of the SteelImpRevs in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the SteelImpRev.
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

