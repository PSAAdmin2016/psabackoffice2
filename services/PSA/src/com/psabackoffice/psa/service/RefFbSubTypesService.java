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

import com.psabackoffice.psa.FeedBack;
import com.psabackoffice.psa.RefFbSubTypes;

/**
 * Service object for domain model class {@link RefFbSubTypes}.
 */
public interface RefFbSubTypesService {

    /**
     * Creates a new RefFbSubTypes. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RefFbSubTypes if any.
     *
     * @param refFbSubTypes Details of the RefFbSubTypes to be created; value cannot be null.
     * @return The newly created RefFbSubTypes.
     */
	RefFbSubTypes create(@Valid RefFbSubTypes refFbSubTypes);


	/**
	 * Returns RefFbSubTypes by given id if exists.
	 *
	 * @param reffbsubtypesId The id of the RefFbSubTypes to get; value cannot be null.
	 * @return RefFbSubTypes associated with the given reffbsubtypesId.
     * @throws EntityNotFoundException If no RefFbSubTypes is found.
	 */
	RefFbSubTypes getById(Integer reffbsubtypesId);

    /**
	 * Find and return the RefFbSubTypes by given id if exists, returns null otherwise.
	 *
	 * @param reffbsubtypesId The id of the RefFbSubTypes to get; value cannot be null.
	 * @return RefFbSubTypes associated with the given reffbsubtypesId.
	 */
	RefFbSubTypes findById(Integer reffbsubtypesId);


	/**
	 * Updates the details of an existing RefFbSubTypes. It replaces all fields of the existing RefFbSubTypes with the given refFbSubTypes.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RefFbSubTypes if any.
     *
	 * @param refFbSubTypes The details of the RefFbSubTypes to be updated; value cannot be null.
	 * @return The updated RefFbSubTypes.
	 * @throws EntityNotFoundException if no RefFbSubTypes is found with given input.
	 */
	RefFbSubTypes update(@Valid RefFbSubTypes refFbSubTypes);

    /**
	 * Deletes an existing RefFbSubTypes with the given id.
	 *
	 * @param reffbsubtypesId The id of the RefFbSubTypes to be deleted; value cannot be null.
	 * @return The deleted RefFbSubTypes.
	 * @throws EntityNotFoundException if no RefFbSubTypes found with the given id.
	 */
	RefFbSubTypes delete(Integer reffbsubtypesId);

    /**
	 * Deletes an existing RefFbSubTypes with the given object.
	 *
	 * @param refFbSubTypes The instance of the RefFbSubTypes to be deleted; value cannot be null.
	 */
	void delete(RefFbSubTypes refFbSubTypes);

	/**
	 * Find all RefFbSubTypes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefFbSubTypes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RefFbSubTypes> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RefFbSubTypes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefFbSubTypes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RefFbSubTypes> findAll(String query, Pageable pageable);

    /**
	 * Exports all RefFbSubTypes matching the given input query to the given exportType format.
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
	 * Retrieve the count of the RefFbSubTypes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RefFbSubTypes.
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
     * Returns the associated feedBacks for given RefFbSubTypes id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated FeedBack instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<FeedBack> findAssociatedFeedBacks(Integer id, Pageable pageable);

}

