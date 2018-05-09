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

import com.psabackoffice.psa.RefCrafts;
import com.psabackoffice.psa.TblUserPsa;

/**
 * Service object for domain model class {@link RefCrafts}.
 */
public interface RefCraftsService {

    /**
     * Creates a new RefCrafts. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RefCrafts if any.
     *
     * @param refCrafts Details of the RefCrafts to be created; value cannot be null.
     * @return The newly created RefCrafts.
     */
	RefCrafts create(@Valid RefCrafts refCrafts);


	/**
	 * Returns RefCrafts by given id if exists.
	 *
	 * @param refcraftsId The id of the RefCrafts to get; value cannot be null.
	 * @return RefCrafts associated with the given refcraftsId.
     * @throws EntityNotFoundException If no RefCrafts is found.
	 */
	RefCrafts getById(Integer refcraftsId);

    /**
	 * Find and return the RefCrafts by given id if exists, returns null otherwise.
	 *
	 * @param refcraftsId The id of the RefCrafts to get; value cannot be null.
	 * @return RefCrafts associated with the given refcraftsId.
	 */
	RefCrafts findById(Integer refcraftsId);


	/**
	 * Updates the details of an existing RefCrafts. It replaces all fields of the existing RefCrafts with the given refCrafts.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RefCrafts if any.
     *
	 * @param refCrafts The details of the RefCrafts to be updated; value cannot be null.
	 * @return The updated RefCrafts.
	 * @throws EntityNotFoundException if no RefCrafts is found with given input.
	 */
	RefCrafts update(@Valid RefCrafts refCrafts);

    /**
	 * Deletes an existing RefCrafts with the given id.
	 *
	 * @param refcraftsId The id of the RefCrafts to be deleted; value cannot be null.
	 * @return The deleted RefCrafts.
	 * @throws EntityNotFoundException if no RefCrafts found with the given id.
	 */
	RefCrafts delete(Integer refcraftsId);

    /**
	 * Deletes an existing RefCrafts with the given object.
	 *
	 * @param refCrafts The instance of the RefCrafts to be deleted; value cannot be null.
	 */
	void delete(RefCrafts refCrafts);

	/**
	 * Find all RefCrafts matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefCrafts.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RefCrafts> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RefCrafts matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefCrafts.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RefCrafts> findAll(String query, Pageable pageable);

    /**
	 * Exports all RefCrafts matching the given input query to the given exportType format.
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
	 * Retrieve the count of the RefCrafts in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RefCrafts.
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
     * Returns the associated tblUserPsas for given RefCrafts id.
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

