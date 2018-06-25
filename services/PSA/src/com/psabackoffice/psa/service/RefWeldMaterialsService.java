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

import com.psabackoffice.psa.RefWeldMaterials;

/**
 * Service object for domain model class {@link RefWeldMaterials}.
 */
public interface RefWeldMaterialsService {

    /**
     * Creates a new RefWeldMaterials. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RefWeldMaterials if any.
     *
     * @param refWeldMaterials Details of the RefWeldMaterials to be created; value cannot be null.
     * @return The newly created RefWeldMaterials.
     */
	RefWeldMaterials create(@Valid RefWeldMaterials refWeldMaterials);


	/**
	 * Returns RefWeldMaterials by given id if exists.
	 *
	 * @param refweldmaterialsId The id of the RefWeldMaterials to get; value cannot be null.
	 * @return RefWeldMaterials associated with the given refweldmaterialsId.
     * @throws EntityNotFoundException If no RefWeldMaterials is found.
	 */
	RefWeldMaterials getById(Integer refweldmaterialsId);

    /**
	 * Find and return the RefWeldMaterials by given id if exists, returns null otherwise.
	 *
	 * @param refweldmaterialsId The id of the RefWeldMaterials to get; value cannot be null.
	 * @return RefWeldMaterials associated with the given refweldmaterialsId.
	 */
	RefWeldMaterials findById(Integer refweldmaterialsId);


	/**
	 * Updates the details of an existing RefWeldMaterials. It replaces all fields of the existing RefWeldMaterials with the given refWeldMaterials.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RefWeldMaterials if any.
     *
	 * @param refWeldMaterials The details of the RefWeldMaterials to be updated; value cannot be null.
	 * @return The updated RefWeldMaterials.
	 * @throws EntityNotFoundException if no RefWeldMaterials is found with given input.
	 */
	RefWeldMaterials update(@Valid RefWeldMaterials refWeldMaterials);

    /**
	 * Deletes an existing RefWeldMaterials with the given id.
	 *
	 * @param refweldmaterialsId The id of the RefWeldMaterials to be deleted; value cannot be null.
	 * @return The deleted RefWeldMaterials.
	 * @throws EntityNotFoundException if no RefWeldMaterials found with the given id.
	 */
	RefWeldMaterials delete(Integer refweldmaterialsId);

    /**
	 * Deletes an existing RefWeldMaterials with the given object.
	 *
	 * @param refWeldMaterials The instance of the RefWeldMaterials to be deleted; value cannot be null.
	 */
	void delete(RefWeldMaterials refWeldMaterials);

	/**
	 * Find all RefWeldMaterials matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefWeldMaterials.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RefWeldMaterials> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RefWeldMaterials matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefWeldMaterials.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RefWeldMaterials> findAll(String query, Pageable pageable);

    /**
	 * Exports all RefWeldMaterials matching the given input query to the given exportType format.
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
	 * Retrieve the count of the RefWeldMaterials in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RefWeldMaterials.
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

