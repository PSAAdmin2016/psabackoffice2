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

import com.psabackoffice.psa.RefRolesMobileFolders;

/**
 * Service object for domain model class {@link RefRolesMobileFolders}.
 */
public interface RefRolesMobileFoldersService {

    /**
     * Creates a new RefRolesMobileFolders. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RefRolesMobileFolders if any.
     *
     * @param refRolesMobileFolders Details of the RefRolesMobileFolders to be created; value cannot be null.
     * @return The newly created RefRolesMobileFolders.
     */
	RefRolesMobileFolders create(@Valid RefRolesMobileFolders refRolesMobileFolders);


	/**
	 * Returns RefRolesMobileFolders by given id if exists.
	 *
	 * @param refrolesmobilefoldersId The id of the RefRolesMobileFolders to get; value cannot be null.
	 * @return RefRolesMobileFolders associated with the given refrolesmobilefoldersId.
     * @throws EntityNotFoundException If no RefRolesMobileFolders is found.
	 */
	RefRolesMobileFolders getById(Integer refrolesmobilefoldersId) throws EntityNotFoundException;

    /**
	 * Find and return the RefRolesMobileFolders by given id if exists, returns null otherwise.
	 *
	 * @param refrolesmobilefoldersId The id of the RefRolesMobileFolders to get; value cannot be null.
	 * @return RefRolesMobileFolders associated with the given refrolesmobilefoldersId.
	 */
	RefRolesMobileFolders findById(Integer refrolesmobilefoldersId);


	/**
	 * Updates the details of an existing RefRolesMobileFolders. It replaces all fields of the existing RefRolesMobileFolders with the given refRolesMobileFolders.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RefRolesMobileFolders if any.
     *
	 * @param refRolesMobileFolders The details of the RefRolesMobileFolders to be updated; value cannot be null.
	 * @return The updated RefRolesMobileFolders.
	 * @throws EntityNotFoundException if no RefRolesMobileFolders is found with given input.
	 */
	RefRolesMobileFolders update(@Valid RefRolesMobileFolders refRolesMobileFolders) throws EntityNotFoundException;

    /**
	 * Deletes an existing RefRolesMobileFolders with the given id.
	 *
	 * @param refrolesmobilefoldersId The id of the RefRolesMobileFolders to be deleted; value cannot be null.
	 * @return The deleted RefRolesMobileFolders.
	 * @throws EntityNotFoundException if no RefRolesMobileFolders found with the given id.
	 */
	RefRolesMobileFolders delete(Integer refrolesmobilefoldersId) throws EntityNotFoundException;

    /**
	 * Deletes an existing RefRolesMobileFolders with the given object.
	 *
	 * @param refRolesMobileFolders The instance of the RefRolesMobileFolders to be deleted; value cannot be null.
	 */
	void delete(RefRolesMobileFolders refRolesMobileFolders);

	/**
	 * Find all RefRolesMobileFolders matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefRolesMobileFolders.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RefRolesMobileFolders> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RefRolesMobileFolders matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefRolesMobileFolders.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RefRolesMobileFolders> findAll(String query, Pageable pageable);

    /**
	 * Exports all RefRolesMobileFolders matching the given input query to the given exportType format.
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
	 * Retrieve the count of the RefRolesMobileFolders in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RefRolesMobileFolders.
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

