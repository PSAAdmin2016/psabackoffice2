/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.service;

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

import com.psabackoffice.psa.TblCrewsRev;

/**
 * Service object for domain model class {@link TblCrewsRev}.
 */
public interface TblCrewsRevService {

    /**
     * Creates a new TblCrewsRev. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TblCrewsRev if any.
     *
     * @param tblCrewsRev Details of the TblCrewsRev to be created; value cannot be null.
     * @return The newly created TblCrewsRev.
     */
	TblCrewsRev create(@Valid TblCrewsRev tblCrewsRev);


	/**
	 * Returns TblCrewsRev by given id if exists.
	 *
	 * @param tblcrewsrevId The id of the TblCrewsRev to get; value cannot be null.
	 * @return TblCrewsRev associated with the given tblcrewsrevId.
     * @throws EntityNotFoundException If no TblCrewsRev is found.
	 */
	TblCrewsRev getById(Integer tblcrewsrevId) throws EntityNotFoundException;

    /**
	 * Find and return the TblCrewsRev by given id if exists, returns null otherwise.
	 *
	 * @param tblcrewsrevId The id of the TblCrewsRev to get; value cannot be null.
	 * @return TblCrewsRev associated with the given tblcrewsrevId.
	 */
	TblCrewsRev findById(Integer tblcrewsrevId);


	/**
	 * Updates the details of an existing TblCrewsRev. It replaces all fields of the existing TblCrewsRev with the given tblCrewsRev.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TblCrewsRev if any.
     *
	 * @param tblCrewsRev The details of the TblCrewsRev to be updated; value cannot be null.
	 * @return The updated TblCrewsRev.
	 * @throws EntityNotFoundException if no TblCrewsRev is found with given input.
	 */
	TblCrewsRev update(@Valid TblCrewsRev tblCrewsRev) throws EntityNotFoundException;

    /**
	 * Deletes an existing TblCrewsRev with the given id.
	 *
	 * @param tblcrewsrevId The id of the TblCrewsRev to be deleted; value cannot be null.
	 * @return The deleted TblCrewsRev.
	 * @throws EntityNotFoundException if no TblCrewsRev found with the given id.
	 */
	TblCrewsRev delete(Integer tblcrewsrevId) throws EntityNotFoundException;

	/**
	 * Find all TblCrewsRevs matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TblCrewsRevs.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TblCrewsRev> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TblCrewsRevs matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TblCrewsRevs.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TblCrewsRev> findAll(String query, Pageable pageable);

    /**
	 * Exports all TblCrewsRevs matching the given input query to the given exportType format.
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
	 * Retrieve the count of the TblCrewsRevs in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TblCrewsRev.
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

