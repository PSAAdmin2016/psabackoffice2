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

import com.psabackoffice.job1111.SteelDemo;

/**
 * Service object for domain model class {@link SteelDemo}.
 */
public interface SteelDemoService {

    /**
     * Creates a new SteelDemo. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SteelDemo if any.
     *
     * @param steelDemo Details of the SteelDemo to be created; value cannot be null.
     * @return The newly created SteelDemo.
     */
	SteelDemo create(@Valid SteelDemo steelDemo);


	/**
	 * Returns SteelDemo by given id if exists.
	 *
	 * @param steeldemoId The id of the SteelDemo to get; value cannot be null.
	 * @return SteelDemo associated with the given steeldemoId.
     * @throws EntityNotFoundException If no SteelDemo is found.
	 */
	SteelDemo getById(Integer steeldemoId) throws EntityNotFoundException;

    /**
	 * Find and return the SteelDemo by given id if exists, returns null otherwise.
	 *
	 * @param steeldemoId The id of the SteelDemo to get; value cannot be null.
	 * @return SteelDemo associated with the given steeldemoId.
	 */
	SteelDemo findById(Integer steeldemoId);


	/**
	 * Updates the details of an existing SteelDemo. It replaces all fields of the existing SteelDemo with the given steelDemo.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on SteelDemo if any.
     *
	 * @param steelDemo The details of the SteelDemo to be updated; value cannot be null.
	 * @return The updated SteelDemo.
	 * @throws EntityNotFoundException if no SteelDemo is found with given input.
	 */
	SteelDemo update(@Valid SteelDemo steelDemo) throws EntityNotFoundException;

    /**
	 * Deletes an existing SteelDemo with the given id.
	 *
	 * @param steeldemoId The id of the SteelDemo to be deleted; value cannot be null.
	 * @return The deleted SteelDemo.
	 * @throws EntityNotFoundException if no SteelDemo found with the given id.
	 */
	SteelDemo delete(Integer steeldemoId) throws EntityNotFoundException;

    /**
	 * Deletes an existing SteelDemo with the given object.
	 *
	 * @param steelDemo The instance of the SteelDemo to be deleted; value cannot be null.
	 */
	void delete(SteelDemo steelDemo);

	/**
	 * Find all SteelDemos matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SteelDemos.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<SteelDemo> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all SteelDemos matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SteelDemos.
     *
     * @see Pageable
     * @see Page
	 */
    Page<SteelDemo> findAll(String query, Pageable pageable);

    /**
	 * Exports all SteelDemos matching the given input query to the given exportType format.
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
	 * Retrieve the count of the SteelDemos in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the SteelDemo.
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

