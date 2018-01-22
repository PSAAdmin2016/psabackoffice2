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

import com.psabackoffice.psa.RefCraftClasses;
import com.psabackoffice.psa.TblUserPsa;

/**
 * Service object for domain model class {@link RefCraftClasses}.
 */
public interface RefCraftClassesService {

    /**
     * Creates a new RefCraftClasses. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RefCraftClasses if any.
     *
     * @param refCraftClasses Details of the RefCraftClasses to be created; value cannot be null.
     * @return The newly created RefCraftClasses.
     */
	RefCraftClasses create(@Valid RefCraftClasses refCraftClasses);


	/**
	 * Returns RefCraftClasses by given id if exists.
	 *
	 * @param refcraftclassesId The id of the RefCraftClasses to get; value cannot be null.
	 * @return RefCraftClasses associated with the given refcraftclassesId.
     * @throws EntityNotFoundException If no RefCraftClasses is found.
	 */
	RefCraftClasses getById(Integer refcraftclassesId) throws EntityNotFoundException;

    /**
	 * Find and return the RefCraftClasses by given id if exists, returns null otherwise.
	 *
	 * @param refcraftclassesId The id of the RefCraftClasses to get; value cannot be null.
	 * @return RefCraftClasses associated with the given refcraftclassesId.
	 */
	RefCraftClasses findById(Integer refcraftclassesId);


	/**
	 * Updates the details of an existing RefCraftClasses. It replaces all fields of the existing RefCraftClasses with the given refCraftClasses.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RefCraftClasses if any.
     *
	 * @param refCraftClasses The details of the RefCraftClasses to be updated; value cannot be null.
	 * @return The updated RefCraftClasses.
	 * @throws EntityNotFoundException if no RefCraftClasses is found with given input.
	 */
	RefCraftClasses update(@Valid RefCraftClasses refCraftClasses) throws EntityNotFoundException;

    /**
	 * Deletes an existing RefCraftClasses with the given id.
	 *
	 * @param refcraftclassesId The id of the RefCraftClasses to be deleted; value cannot be null.
	 * @return The deleted RefCraftClasses.
	 * @throws EntityNotFoundException if no RefCraftClasses found with the given id.
	 */
	RefCraftClasses delete(Integer refcraftclassesId) throws EntityNotFoundException;

	/**
	 * Find all RefCraftClasses matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefCraftClasses.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RefCraftClasses> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RefCraftClasses matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefCraftClasses.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RefCraftClasses> findAll(String query, Pageable pageable);

    /**
	 * Exports all RefCraftClasses matching the given input query to the given exportType format.
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
	 * Retrieve the count of the RefCraftClasses in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RefCraftClasses.
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
     * Returns the associated tblUserPsas for given RefCraftClasses id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TblUserPsa instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TblUserPsa> findAssociatedTblUserPsas(Integer id, Pageable pageable);

}

