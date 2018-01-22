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

import com.psabackoffice.psa.RefChatStatus;

/**
 * Service object for domain model class {@link RefChatStatus}.
 */
public interface RefChatStatusService {

    /**
     * Creates a new RefChatStatus. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RefChatStatus if any.
     *
     * @param refChatStatus Details of the RefChatStatus to be created; value cannot be null.
     * @return The newly created RefChatStatus.
     */
	RefChatStatus create(@Valid RefChatStatus refChatStatus);


	/**
	 * Returns RefChatStatus by given id if exists.
	 *
	 * @param refchatstatusId The id of the RefChatStatus to get; value cannot be null.
	 * @return RefChatStatus associated with the given refchatstatusId.
     * @throws EntityNotFoundException If no RefChatStatus is found.
	 */
	RefChatStatus getById(Integer refchatstatusId) throws EntityNotFoundException;

    /**
	 * Find and return the RefChatStatus by given id if exists, returns null otherwise.
	 *
	 * @param refchatstatusId The id of the RefChatStatus to get; value cannot be null.
	 * @return RefChatStatus associated with the given refchatstatusId.
	 */
	RefChatStatus findById(Integer refchatstatusId);


	/**
	 * Updates the details of an existing RefChatStatus. It replaces all fields of the existing RefChatStatus with the given refChatStatus.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RefChatStatus if any.
     *
	 * @param refChatStatus The details of the RefChatStatus to be updated; value cannot be null.
	 * @return The updated RefChatStatus.
	 * @throws EntityNotFoundException if no RefChatStatus is found with given input.
	 */
	RefChatStatus update(@Valid RefChatStatus refChatStatus) throws EntityNotFoundException;

    /**
	 * Deletes an existing RefChatStatus with the given id.
	 *
	 * @param refchatstatusId The id of the RefChatStatus to be deleted; value cannot be null.
	 * @return The deleted RefChatStatus.
	 * @throws EntityNotFoundException if no RefChatStatus found with the given id.
	 */
	RefChatStatus delete(Integer refchatstatusId) throws EntityNotFoundException;

	/**
	 * Find all RefChatStatuses matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefChatStatuses.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RefChatStatus> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RefChatStatuses matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefChatStatuses.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RefChatStatus> findAll(String query, Pageable pageable);

    /**
	 * Exports all RefChatStatuses matching the given input query to the given exportType format.
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
	 * Retrieve the count of the RefChatStatuses in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RefChatStatus.
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

