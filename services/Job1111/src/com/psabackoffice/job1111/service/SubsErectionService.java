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

import com.psabackoffice.job1111.SubsErection;
import com.psabackoffice.job1111.SubsErectionRev;

/**
 * Service object for domain model class {@link SubsErection}.
 */
public interface SubsErectionService {

    /**
     * Creates a new SubsErection. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SubsErection if any.
     *
     * @param subsErection Details of the SubsErection to be created; value cannot be null.
     * @return The newly created SubsErection.
     */
	SubsErection create(SubsErection subsErection);


	/**
	 * Returns SubsErection by given id if exists.
	 *
	 * @param subserectionId The id of the SubsErection to get; value cannot be null.
	 * @return SubsErection associated with the given subserectionId.
     * @throws EntityNotFoundException If no SubsErection is found.
	 */
	SubsErection getById(Integer subserectionId) throws EntityNotFoundException;

    /**
	 * Find and return the SubsErection by given id if exists, returns null otherwise.
	 *
	 * @param subserectionId The id of the SubsErection to get; value cannot be null.
	 * @return SubsErection associated with the given subserectionId.
	 */
	SubsErection findById(Integer subserectionId);


	/**
	 * Updates the details of an existing SubsErection. It replaces all fields of the existing SubsErection with the given subsErection.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on SubsErection if any.
     *
	 * @param subsErection The details of the SubsErection to be updated; value cannot be null.
	 * @return The updated SubsErection.
	 * @throws EntityNotFoundException if no SubsErection is found with given input.
	 */
	SubsErection update(SubsErection subsErection) throws EntityNotFoundException;

    /**
	 * Deletes an existing SubsErection with the given id.
	 *
	 * @param subserectionId The id of the SubsErection to be deleted; value cannot be null.
	 * @return The deleted SubsErection.
	 * @throws EntityNotFoundException if no SubsErection found with the given id.
	 */
	SubsErection delete(Integer subserectionId) throws EntityNotFoundException;

	/**
	 * Find all SubsErections matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SubsErections.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<SubsErection> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all SubsErections matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SubsErections.
     *
     * @see Pageable
     * @see Page
	 */
    Page<SubsErection> findAll(String query, Pageable pageable);

    /**
	 * Exports all SubsErections matching the given input query to the given exportType format.
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
	 * Retrieve the count of the SubsErections in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the SubsErection.
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
     * Returns the associated subsErectionRevs for given SubsErection id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated SubsErectionRev instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<SubsErectionRev> findAssociatedSubsErectionRevs(Integer id, Pageable pageable);

}

