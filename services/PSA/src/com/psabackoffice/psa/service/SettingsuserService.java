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

import com.psabackoffice.psa.Settingsuser;

/**
 * Service object for domain model class {@link Settingsuser}.
 */
public interface SettingsuserService {

    /**
     * Creates a new Settingsuser. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Settingsuser if any.
     *
     * @param settingsuser Details of the Settingsuser to be created; value cannot be null.
     * @return The newly created Settingsuser.
     */
	Settingsuser create(@Valid Settingsuser settingsuser);


	/**
	 * Returns Settingsuser by given id if exists.
	 *
	 * @param settingsuserId The id of the Settingsuser to get; value cannot be null.
	 * @return Settingsuser associated with the given settingsuserId.
     * @throws EntityNotFoundException If no Settingsuser is found.
	 */
	Settingsuser getById(Integer settingsuserId);

    /**
	 * Find and return the Settingsuser by given id if exists, returns null otherwise.
	 *
	 * @param settingsuserId The id of the Settingsuser to get; value cannot be null.
	 * @return Settingsuser associated with the given settingsuserId.
	 */
	Settingsuser findById(Integer settingsuserId);


	/**
	 * Updates the details of an existing Settingsuser. It replaces all fields of the existing Settingsuser with the given settingsuser.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Settingsuser if any.
     *
	 * @param settingsuser The details of the Settingsuser to be updated; value cannot be null.
	 * @return The updated Settingsuser.
	 * @throws EntityNotFoundException if no Settingsuser is found with given input.
	 */
	Settingsuser update(@Valid Settingsuser settingsuser);

    /**
	 * Deletes an existing Settingsuser with the given id.
	 *
	 * @param settingsuserId The id of the Settingsuser to be deleted; value cannot be null.
	 * @return The deleted Settingsuser.
	 * @throws EntityNotFoundException if no Settingsuser found with the given id.
	 */
	Settingsuser delete(Integer settingsuserId);

    /**
	 * Deletes an existing Settingsuser with the given object.
	 *
	 * @param settingsuser The instance of the Settingsuser to be deleted; value cannot be null.
	 */
	void delete(Settingsuser settingsuser);

	/**
	 * Find all Settingsusers matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Settingsusers.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Settingsuser> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Settingsusers matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Settingsusers.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Settingsuser> findAll(String query, Pageable pageable);

    /**
	 * Exports all Settingsusers matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Settingsusers in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Settingsuser.
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

