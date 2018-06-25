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

import com.psabackoffice.psa.RefWeldTypes;

/**
 * Service object for domain model class {@link RefWeldTypes}.
 */
public interface RefWeldTypesService {

    /**
     * Creates a new RefWeldTypes. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RefWeldTypes if any.
     *
     * @param refWeldTypes Details of the RefWeldTypes to be created; value cannot be null.
     * @return The newly created RefWeldTypes.
     */
	RefWeldTypes create(@Valid RefWeldTypes refWeldTypes);


	/**
	 * Returns RefWeldTypes by given id if exists.
	 *
	 * @param refweldtypesId The id of the RefWeldTypes to get; value cannot be null.
	 * @return RefWeldTypes associated with the given refweldtypesId.
     * @throws EntityNotFoundException If no RefWeldTypes is found.
	 */
	RefWeldTypes getById(Integer refweldtypesId);

    /**
	 * Find and return the RefWeldTypes by given id if exists, returns null otherwise.
	 *
	 * @param refweldtypesId The id of the RefWeldTypes to get; value cannot be null.
	 * @return RefWeldTypes associated with the given refweldtypesId.
	 */
	RefWeldTypes findById(Integer refweldtypesId);


	/**
	 * Updates the details of an existing RefWeldTypes. It replaces all fields of the existing RefWeldTypes with the given refWeldTypes.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RefWeldTypes if any.
     *
	 * @param refWeldTypes The details of the RefWeldTypes to be updated; value cannot be null.
	 * @return The updated RefWeldTypes.
	 * @throws EntityNotFoundException if no RefWeldTypes is found with given input.
	 */
	RefWeldTypes update(@Valid RefWeldTypes refWeldTypes);

    /**
	 * Deletes an existing RefWeldTypes with the given id.
	 *
	 * @param refweldtypesId The id of the RefWeldTypes to be deleted; value cannot be null.
	 * @return The deleted RefWeldTypes.
	 * @throws EntityNotFoundException if no RefWeldTypes found with the given id.
	 */
	RefWeldTypes delete(Integer refweldtypesId);

    /**
	 * Deletes an existing RefWeldTypes with the given object.
	 *
	 * @param refWeldTypes The instance of the RefWeldTypes to be deleted; value cannot be null.
	 */
	void delete(RefWeldTypes refWeldTypes);

	/**
	 * Find all RefWeldTypes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefWeldTypes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RefWeldTypes> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RefWeldTypes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefWeldTypes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RefWeldTypes> findAll(String query, Pageable pageable);

    /**
	 * Exports all RefWeldTypes matching the given input query to the given exportType format.
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
	 * Retrieve the count of the RefWeldTypes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RefWeldTypes.
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

