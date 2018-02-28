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

import com.psabackoffice.psa.MenuHelpVideos;
import com.psabackoffice.psa.MenuSubHelpVideos;

/**
 * Service object for domain model class {@link MenuHelpVideos}.
 */
public interface MenuHelpVideosService {

    /**
     * Creates a new MenuHelpVideos. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on MenuHelpVideos if any.
     *
     * @param menuHelpVideos Details of the MenuHelpVideos to be created; value cannot be null.
     * @return The newly created MenuHelpVideos.
     */
	MenuHelpVideos create(@Valid MenuHelpVideos menuHelpVideos);


	/**
	 * Returns MenuHelpVideos by given id if exists.
	 *
	 * @param menuhelpvideosId The id of the MenuHelpVideos to get; value cannot be null.
	 * @return MenuHelpVideos associated with the given menuhelpvideosId.
     * @throws EntityNotFoundException If no MenuHelpVideos is found.
	 */
	MenuHelpVideos getById(Integer menuhelpvideosId) throws EntityNotFoundException;

    /**
	 * Find and return the MenuHelpVideos by given id if exists, returns null otherwise.
	 *
	 * @param menuhelpvideosId The id of the MenuHelpVideos to get; value cannot be null.
	 * @return MenuHelpVideos associated with the given menuhelpvideosId.
	 */
	MenuHelpVideos findById(Integer menuhelpvideosId);


	/**
	 * Updates the details of an existing MenuHelpVideos. It replaces all fields of the existing MenuHelpVideos with the given menuHelpVideos.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on MenuHelpVideos if any.
     *
	 * @param menuHelpVideos The details of the MenuHelpVideos to be updated; value cannot be null.
	 * @return The updated MenuHelpVideos.
	 * @throws EntityNotFoundException if no MenuHelpVideos is found with given input.
	 */
	MenuHelpVideos update(@Valid MenuHelpVideos menuHelpVideos) throws EntityNotFoundException;

    /**
	 * Deletes an existing MenuHelpVideos with the given id.
	 *
	 * @param menuhelpvideosId The id of the MenuHelpVideos to be deleted; value cannot be null.
	 * @return The deleted MenuHelpVideos.
	 * @throws EntityNotFoundException if no MenuHelpVideos found with the given id.
	 */
	MenuHelpVideos delete(Integer menuhelpvideosId) throws EntityNotFoundException;

    /**
	 * Deletes an existing MenuHelpVideos with the given object.
	 *
	 * @param menuHelpVideos The instance of the MenuHelpVideos to be deleted; value cannot be null.
	 */
	void delete(MenuHelpVideos menuHelpVideos);

	/**
	 * Find all MenuHelpVideos matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching MenuHelpVideos.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<MenuHelpVideos> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all MenuHelpVideos matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching MenuHelpVideos.
     *
     * @see Pageable
     * @see Page
	 */
    Page<MenuHelpVideos> findAll(String query, Pageable pageable);

    /**
	 * Exports all MenuHelpVideos matching the given input query to the given exportType format.
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
	 * Retrieve the count of the MenuHelpVideos in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the MenuHelpVideos.
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
     * Returns the associated menuSubHelpVideoses for given MenuHelpVideos id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated MenuSubHelpVideos instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<MenuSubHelpVideos> findAssociatedMenuSubHelpVideoses(Integer id, Pageable pageable);

}

