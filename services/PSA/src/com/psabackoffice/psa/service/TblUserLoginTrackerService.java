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

import com.psabackoffice.psa.TblUserLoginTracker;

/**
 * Service object for domain model class {@link TblUserLoginTracker}.
 */
public interface TblUserLoginTrackerService {

    /**
     * Creates a new TblUserLoginTracker. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TblUserLoginTracker if any.
     *
     * @param tblUserLoginTracker Details of the TblUserLoginTracker to be created; value cannot be null.
     * @return The newly created TblUserLoginTracker.
     */
	TblUserLoginTracker create(@Valid TblUserLoginTracker tblUserLoginTracker);


	/**
	 * Returns TblUserLoginTracker by given id if exists.
	 *
	 * @param tbluserlogintrackerId The id of the TblUserLoginTracker to get; value cannot be null.
	 * @return TblUserLoginTracker associated with the given tbluserlogintrackerId.
     * @throws EntityNotFoundException If no TblUserLoginTracker is found.
	 */
	TblUserLoginTracker getById(Integer tbluserlogintrackerId) throws EntityNotFoundException;

    /**
	 * Find and return the TblUserLoginTracker by given id if exists, returns null otherwise.
	 *
	 * @param tbluserlogintrackerId The id of the TblUserLoginTracker to get; value cannot be null.
	 * @return TblUserLoginTracker associated with the given tbluserlogintrackerId.
	 */
	TblUserLoginTracker findById(Integer tbluserlogintrackerId);


	/**
	 * Updates the details of an existing TblUserLoginTracker. It replaces all fields of the existing TblUserLoginTracker with the given tblUserLoginTracker.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TblUserLoginTracker if any.
     *
	 * @param tblUserLoginTracker The details of the TblUserLoginTracker to be updated; value cannot be null.
	 * @return The updated TblUserLoginTracker.
	 * @throws EntityNotFoundException if no TblUserLoginTracker is found with given input.
	 */
	TblUserLoginTracker update(@Valid TblUserLoginTracker tblUserLoginTracker) throws EntityNotFoundException;

    /**
	 * Deletes an existing TblUserLoginTracker with the given id.
	 *
	 * @param tbluserlogintrackerId The id of the TblUserLoginTracker to be deleted; value cannot be null.
	 * @return The deleted TblUserLoginTracker.
	 * @throws EntityNotFoundException if no TblUserLoginTracker found with the given id.
	 */
	TblUserLoginTracker delete(Integer tbluserlogintrackerId) throws EntityNotFoundException;

    /**
	 * Deletes an existing TblUserLoginTracker with the given object.
	 *
	 * @param tblUserLoginTracker The instance of the TblUserLoginTracker to be deleted; value cannot be null.
	 */
	void delete(TblUserLoginTracker tblUserLoginTracker);

	/**
	 * Find all TblUserLoginTrackers matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TblUserLoginTrackers.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TblUserLoginTracker> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TblUserLoginTrackers matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TblUserLoginTrackers.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TblUserLoginTracker> findAll(String query, Pageable pageable);

    /**
	 * Exports all TblUserLoginTrackers matching the given input query to the given exportType format.
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
	 * Retrieve the count of the TblUserLoginTrackers in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TblUserLoginTracker.
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

