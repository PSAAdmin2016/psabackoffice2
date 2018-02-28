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

import com.psabackoffice.psa.TblCrews;
import com.psabackoffice.psa.TblCrewsRev;

/**
 * Service object for domain model class {@link TblCrews}.
 */
public interface TblCrewsService {

    /**
     * Creates a new TblCrews. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TblCrews if any.
     *
     * @param tblCrews Details of the TblCrews to be created; value cannot be null.
     * @return The newly created TblCrews.
     */
	TblCrews create(@Valid TblCrews tblCrews);


	/**
	 * Returns TblCrews by given id if exists.
	 *
	 * @param tblcrewsId The id of the TblCrews to get; value cannot be null.
	 * @return TblCrews associated with the given tblcrewsId.
     * @throws EntityNotFoundException If no TblCrews is found.
	 */
	TblCrews getById(Integer tblcrewsId) throws EntityNotFoundException;

    /**
	 * Find and return the TblCrews by given id if exists, returns null otherwise.
	 *
	 * @param tblcrewsId The id of the TblCrews to get; value cannot be null.
	 * @return TblCrews associated with the given tblcrewsId.
	 */
	TblCrews findById(Integer tblcrewsId);

    /**
	 * Find and return the TblCrews for given foreman  if exists.
	 *
	 * @param foreman value of foreman; value cannot be null.
	 * @return TblCrews associated with the given inputs.
     * @throws EntityNotFoundException if no matching TblCrews found.
	 */
    TblCrews getByForeman(Integer foreman)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing TblCrews. It replaces all fields of the existing TblCrews with the given tblCrews.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TblCrews if any.
     *
	 * @param tblCrews The details of the TblCrews to be updated; value cannot be null.
	 * @return The updated TblCrews.
	 * @throws EntityNotFoundException if no TblCrews is found with given input.
	 */
	TblCrews update(@Valid TblCrews tblCrews) throws EntityNotFoundException;

    /**
	 * Deletes an existing TblCrews with the given id.
	 *
	 * @param tblcrewsId The id of the TblCrews to be deleted; value cannot be null.
	 * @return The deleted TblCrews.
	 * @throws EntityNotFoundException if no TblCrews found with the given id.
	 */
	TblCrews delete(Integer tblcrewsId) throws EntityNotFoundException;

    /**
	 * Deletes an existing TblCrews with the given object.
	 *
	 * @param tblCrews The instance of the TblCrews to be deleted; value cannot be null.
	 */
	void delete(TblCrews tblCrews);

	/**
	 * Find all TblCrews matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TblCrews.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TblCrews> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TblCrews matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TblCrews.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TblCrews> findAll(String query, Pageable pageable);

    /**
	 * Exports all TblCrews matching the given input query to the given exportType format.
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
	 * Retrieve the count of the TblCrews in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TblCrews.
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
     * Returns the associated tblCrewsRevs for given TblCrews id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TblCrewsRev instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TblCrewsRev> findAssociatedTblCrewsRevs(Integer id, Pageable pageable);

}

