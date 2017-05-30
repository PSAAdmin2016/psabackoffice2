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

import com.psabackoffice.job1111.SubmissionActivityStatus;
import com.psabackoffice.job1111.SubsDetails;

/**
 * Service object for domain model class {@link SubsDetails}.
 */
public interface SubsDetailsService {

    /**
     * Creates a new SubsDetails. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SubsDetails if any.
     *
     * @param subsDetails Details of the SubsDetails to be created; value cannot be null.
     * @return The newly created SubsDetails.
     */
	SubsDetails create(SubsDetails subsDetails);


	/**
	 * Returns SubsDetails by given id if exists.
	 *
	 * @param subsdetailsId The id of the SubsDetails to get; value cannot be null.
	 * @return SubsDetails associated with the given subsdetailsId.
     * @throws EntityNotFoundException If no SubsDetails is found.
	 */
	SubsDetails getById(Integer subsdetailsId) throws EntityNotFoundException;

    /**
	 * Find and return the SubsDetails by given id if exists, returns null otherwise.
	 *
	 * @param subsdetailsId The id of the SubsDetails to get; value cannot be null.
	 * @return SubsDetails associated with the given subsdetailsId.
	 */
	SubsDetails findById(Integer subsdetailsId);


	/**
	 * Updates the details of an existing SubsDetails. It replaces all fields of the existing SubsDetails with the given subsDetails.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on SubsDetails if any.
     *
	 * @param subsDetails The details of the SubsDetails to be updated; value cannot be null.
	 * @return The updated SubsDetails.
	 * @throws EntityNotFoundException if no SubsDetails is found with given input.
	 */
	SubsDetails update(SubsDetails subsDetails) throws EntityNotFoundException;

    /**
	 * Deletes an existing SubsDetails with the given id.
	 *
	 * @param subsdetailsId The id of the SubsDetails to be deleted; value cannot be null.
	 * @return The deleted SubsDetails.
	 * @throws EntityNotFoundException if no SubsDetails found with the given id.
	 */
	SubsDetails delete(Integer subsdetailsId) throws EntityNotFoundException;

	/**
	 * Find all SubsDetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SubsDetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<SubsDetails> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all SubsDetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SubsDetails.
     *
     * @see Pageable
     * @see Page
	 */
    Page<SubsDetails> findAll(String query, Pageable pageable);

    /**
	 * Exports all SubsDetails matching the given input query to the given exportType format.
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
	 * Retrieve the count of the SubsDetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the SubsDetails.
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
     * Returns the associated submissionActivityStatuses for given SubsDetails id.
     *
     * @param submissionId value of submissionId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated SubmissionActivityStatus instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<SubmissionActivityStatus> findAssociatedSubmissionActivityStatuses(Integer submissionId, Pageable pageable);

}

