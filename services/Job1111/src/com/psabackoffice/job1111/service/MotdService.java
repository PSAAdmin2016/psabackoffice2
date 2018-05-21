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

import com.psabackoffice.job1111.Motd;

/**
 * Service object for domain model class {@link Motd}.
 */
public interface MotdService {

    /**
     * Creates a new Motd. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Motd if any.
     *
     * @param motd Details of the Motd to be created; value cannot be null.
     * @return The newly created Motd.
     */
	Motd create(@Valid Motd motd);


	/**
	 * Returns Motd by given id if exists.
	 *
	 * @param motdId The id of the Motd to get; value cannot be null.
	 * @return Motd associated with the given motdId.
     * @throws EntityNotFoundException If no Motd is found.
	 */
	Motd getById(Integer motdId);

    /**
	 * Find and return the Motd by given id if exists, returns null otherwise.
	 *
	 * @param motdId The id of the Motd to get; value cannot be null.
	 * @return Motd associated with the given motdId.
	 */
	Motd findById(Integer motdId);


	/**
	 * Updates the details of an existing Motd. It replaces all fields of the existing Motd with the given motd.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Motd if any.
     *
	 * @param motd The details of the Motd to be updated; value cannot be null.
	 * @return The updated Motd.
	 * @throws EntityNotFoundException if no Motd is found with given input.
	 */
	Motd update(@Valid Motd motd);

    /**
	 * Deletes an existing Motd with the given id.
	 *
	 * @param motdId The id of the Motd to be deleted; value cannot be null.
	 * @return The deleted Motd.
	 * @throws EntityNotFoundException if no Motd found with the given id.
	 */
	Motd delete(Integer motdId);

    /**
	 * Deletes an existing Motd with the given object.
	 *
	 * @param motd The instance of the Motd to be deleted; value cannot be null.
	 */
	void delete(Motd motd);

	/**
	 * Find all Motds matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Motds.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Motd> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Motds matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Motds.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Motd> findAll(String query, Pageable pageable);

    /**
	 * Exports all Motds matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Motds in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Motd.
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
