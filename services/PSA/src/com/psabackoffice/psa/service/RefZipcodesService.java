/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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

import com.psabackoffice.psa.RefZipcodes;

/**
 * Service object for domain model class {@link RefZipcodes}.
 */
public interface RefZipcodesService {

    /**
     * Creates a new RefZipcodes. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RefZipcodes if any.
     *
     * @param refZipcodes Details of the RefZipcodes to be created; value cannot be null.
     * @return The newly created RefZipcodes.
     */
	RefZipcodes create(@Valid RefZipcodes refZipcodes);


	/**
	 * Returns RefZipcodes by given id if exists.
	 *
	 * @param refzipcodesId The id of the RefZipcodes to get; value cannot be null.
	 * @return RefZipcodes associated with the given refzipcodesId.
     * @throws EntityNotFoundException If no RefZipcodes is found.
	 */
	RefZipcodes getById(Integer refzipcodesId);

    /**
	 * Find and return the RefZipcodes by given id if exists, returns null otherwise.
	 *
	 * @param refzipcodesId The id of the RefZipcodes to get; value cannot be null.
	 * @return RefZipcodes associated with the given refzipcodesId.
	 */
	RefZipcodes findById(Integer refzipcodesId);


	/**
	 * Updates the details of an existing RefZipcodes. It replaces all fields of the existing RefZipcodes with the given refZipcodes.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RefZipcodes if any.
     *
	 * @param refZipcodes The details of the RefZipcodes to be updated; value cannot be null.
	 * @return The updated RefZipcodes.
	 * @throws EntityNotFoundException if no RefZipcodes is found with given input.
	 */
	RefZipcodes update(@Valid RefZipcodes refZipcodes);

    /**
	 * Deletes an existing RefZipcodes with the given id.
	 *
	 * @param refzipcodesId The id of the RefZipcodes to be deleted; value cannot be null.
	 * @return The deleted RefZipcodes.
	 * @throws EntityNotFoundException if no RefZipcodes found with the given id.
	 */
	RefZipcodes delete(Integer refzipcodesId);

    /**
	 * Deletes an existing RefZipcodes with the given object.
	 *
	 * @param refZipcodes The instance of the RefZipcodes to be deleted; value cannot be null.
	 */
	void delete(RefZipcodes refZipcodes);

	/**
	 * Find all RefZipcodes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefZipcodes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RefZipcodes> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RefZipcodes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefZipcodes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RefZipcodes> findAll(String query, Pageable pageable);

    /**
	 * Exports all RefZipcodes matching the given input query to the given exportType format.
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
	 * Retrieve the count of the RefZipcodes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RefZipcodes.
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

