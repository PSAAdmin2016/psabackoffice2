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

import com.psabackoffice.job1111.CacheRefEquipBidActivities;

/**
 * Service object for domain model class {@link CacheRefEquipBidActivities}.
 */
public interface CacheRefEquipBidActivitiesService {

    /**
     * Creates a new CacheRefEquipBidActivities. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CacheRefEquipBidActivities if any.
     *
     * @param cacheRefEquipBidActivities Details of the CacheRefEquipBidActivities to be created; value cannot be null.
     * @return The newly created CacheRefEquipBidActivities.
     */
	CacheRefEquipBidActivities create(CacheRefEquipBidActivities cacheRefEquipBidActivities);


	/**
	 * Returns CacheRefEquipBidActivities by given id if exists.
	 *
	 * @param cacherefequipbidactivitiesId The id of the CacheRefEquipBidActivities to get; value cannot be null.
	 * @return CacheRefEquipBidActivities associated with the given cacherefequipbidactivitiesId.
     * @throws EntityNotFoundException If no CacheRefEquipBidActivities is found.
	 */
	CacheRefEquipBidActivities getById(Integer cacherefequipbidactivitiesId) throws EntityNotFoundException;

    /**
	 * Find and return the CacheRefEquipBidActivities by given id if exists, returns null otherwise.
	 *
	 * @param cacherefequipbidactivitiesId The id of the CacheRefEquipBidActivities to get; value cannot be null.
	 * @return CacheRefEquipBidActivities associated with the given cacherefequipbidactivitiesId.
	 */
	CacheRefEquipBidActivities findById(Integer cacherefequipbidactivitiesId);


	/**
	 * Updates the details of an existing CacheRefEquipBidActivities. It replaces all fields of the existing CacheRefEquipBidActivities with the given cacheRefEquipBidActivities.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on CacheRefEquipBidActivities if any.
     *
	 * @param cacheRefEquipBidActivities The details of the CacheRefEquipBidActivities to be updated; value cannot be null.
	 * @return The updated CacheRefEquipBidActivities.
	 * @throws EntityNotFoundException if no CacheRefEquipBidActivities is found with given input.
	 */
	CacheRefEquipBidActivities update(CacheRefEquipBidActivities cacheRefEquipBidActivities) throws EntityNotFoundException;

    /**
	 * Deletes an existing CacheRefEquipBidActivities with the given id.
	 *
	 * @param cacherefequipbidactivitiesId The id of the CacheRefEquipBidActivities to be deleted; value cannot be null.
	 * @return The deleted CacheRefEquipBidActivities.
	 * @throws EntityNotFoundException if no CacheRefEquipBidActivities found with the given id.
	 */
	CacheRefEquipBidActivities delete(Integer cacherefequipbidactivitiesId) throws EntityNotFoundException;

	/**
	 * Find all CacheRefEquipBidActivities matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CacheRefEquipBidActivities.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<CacheRefEquipBidActivities> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all CacheRefEquipBidActivities matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CacheRefEquipBidActivities.
     *
     * @see Pageable
     * @see Page
	 */
    Page<CacheRefEquipBidActivities> findAll(String query, Pageable pageable);

    /**
	 * Exports all CacheRefEquipBidActivities matching the given input query to the given exportType format.
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
	 * Retrieve the count of the CacheRefEquipBidActivities in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the CacheRefEquipBidActivities.
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

