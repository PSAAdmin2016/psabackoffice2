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

import com.psabackoffice.psa.TblUserJobNumbers;

/**
 * Service object for domain model class {@link TblUserJobNumbers}.
 */
public interface TblUserJobNumbersService {

    /**
     * Creates a new TblUserJobNumbers. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TblUserJobNumbers if any.
     *
     * @param tblUserJobNumbers Details of the TblUserJobNumbers to be created; value cannot be null.
     * @return The newly created TblUserJobNumbers.
     */
	TblUserJobNumbers create(@Valid TblUserJobNumbers tblUserJobNumbers);


	/**
	 * Returns TblUserJobNumbers by given id if exists.
	 *
	 * @param tbluserjobnumbersId The id of the TblUserJobNumbers to get; value cannot be null.
	 * @return TblUserJobNumbers associated with the given tbluserjobnumbersId.
     * @throws EntityNotFoundException If no TblUserJobNumbers is found.
	 */
	TblUserJobNumbers getById(Integer tbluserjobnumbersId);

    /**
	 * Find and return the TblUserJobNumbers by given id if exists, returns null otherwise.
	 *
	 * @param tbluserjobnumbersId The id of the TblUserJobNumbers to get; value cannot be null.
	 * @return TblUserJobNumbers associated with the given tbluserjobnumbersId.
	 */
	TblUserJobNumbers findById(Integer tbluserjobnumbersId);


	/**
	 * Updates the details of an existing TblUserJobNumbers. It replaces all fields of the existing TblUserJobNumbers with the given tblUserJobNumbers.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TblUserJobNumbers if any.
     *
	 * @param tblUserJobNumbers The details of the TblUserJobNumbers to be updated; value cannot be null.
	 * @return The updated TblUserJobNumbers.
	 * @throws EntityNotFoundException if no TblUserJobNumbers is found with given input.
	 */
	TblUserJobNumbers update(@Valid TblUserJobNumbers tblUserJobNumbers);

    /**
	 * Deletes an existing TblUserJobNumbers with the given id.
	 *
	 * @param tbluserjobnumbersId The id of the TblUserJobNumbers to be deleted; value cannot be null.
	 * @return The deleted TblUserJobNumbers.
	 * @throws EntityNotFoundException if no TblUserJobNumbers found with the given id.
	 */
	TblUserJobNumbers delete(Integer tbluserjobnumbersId);

    /**
	 * Deletes an existing TblUserJobNumbers with the given object.
	 *
	 * @param tblUserJobNumbers The instance of the TblUserJobNumbers to be deleted; value cannot be null.
	 */
	void delete(TblUserJobNumbers tblUserJobNumbers);

	/**
	 * Find all TblUserJobNumbers matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TblUserJobNumbers.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TblUserJobNumbers> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TblUserJobNumbers matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TblUserJobNumbers.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TblUserJobNumbers> findAll(String query, Pageable pageable);

    /**
	 * Exports all TblUserJobNumbers matching the given input query to the given exportType format.
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
	 * Retrieve the count of the TblUserJobNumbers in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TblUserJobNumbers.
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

