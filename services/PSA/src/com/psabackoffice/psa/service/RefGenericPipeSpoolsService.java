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

import com.psabackoffice.psa.RefGenericPipeSpools;

/**
 * Service object for domain model class {@link RefGenericPipeSpools}.
 */
public interface RefGenericPipeSpoolsService {

    /**
     * Creates a new RefGenericPipeSpools. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RefGenericPipeSpools if any.
     *
     * @param refGenericPipeSpools Details of the RefGenericPipeSpools to be created; value cannot be null.
     * @return The newly created RefGenericPipeSpools.
     */
	RefGenericPipeSpools create(@Valid RefGenericPipeSpools refGenericPipeSpools);


	/**
	 * Returns RefGenericPipeSpools by given id if exists.
	 *
	 * @param refgenericpipespoolsId The id of the RefGenericPipeSpools to get; value cannot be null.
	 * @return RefGenericPipeSpools associated with the given refgenericpipespoolsId.
     * @throws EntityNotFoundException If no RefGenericPipeSpools is found.
	 */
	RefGenericPipeSpools getById(Integer refgenericpipespoolsId);

    /**
	 * Find and return the RefGenericPipeSpools by given id if exists, returns null otherwise.
	 *
	 * @param refgenericpipespoolsId The id of the RefGenericPipeSpools to get; value cannot be null.
	 * @return RefGenericPipeSpools associated with the given refgenericpipespoolsId.
	 */
	RefGenericPipeSpools findById(Integer refgenericpipespoolsId);


	/**
	 * Updates the details of an existing RefGenericPipeSpools. It replaces all fields of the existing RefGenericPipeSpools with the given refGenericPipeSpools.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RefGenericPipeSpools if any.
     *
	 * @param refGenericPipeSpools The details of the RefGenericPipeSpools to be updated; value cannot be null.
	 * @return The updated RefGenericPipeSpools.
	 * @throws EntityNotFoundException if no RefGenericPipeSpools is found with given input.
	 */
	RefGenericPipeSpools update(@Valid RefGenericPipeSpools refGenericPipeSpools);

    /**
	 * Deletes an existing RefGenericPipeSpools with the given id.
	 *
	 * @param refgenericpipespoolsId The id of the RefGenericPipeSpools to be deleted; value cannot be null.
	 * @return The deleted RefGenericPipeSpools.
	 * @throws EntityNotFoundException if no RefGenericPipeSpools found with the given id.
	 */
	RefGenericPipeSpools delete(Integer refgenericpipespoolsId);

    /**
	 * Deletes an existing RefGenericPipeSpools with the given object.
	 *
	 * @param refGenericPipeSpools The instance of the RefGenericPipeSpools to be deleted; value cannot be null.
	 */
	void delete(RefGenericPipeSpools refGenericPipeSpools);

	/**
	 * Find all RefGenericPipeSpools matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefGenericPipeSpools.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RefGenericPipeSpools> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RefGenericPipeSpools matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefGenericPipeSpools.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RefGenericPipeSpools> findAll(String query, Pageable pageable);

    /**
	 * Exports all RefGenericPipeSpools matching the given input query to the given exportType format.
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
	 * Retrieve the count of the RefGenericPipeSpools in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RefGenericPipeSpools.
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

