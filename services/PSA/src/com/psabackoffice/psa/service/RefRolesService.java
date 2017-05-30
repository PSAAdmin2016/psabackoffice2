/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.psabackoffice.psa.RefRoles;
import com.psabackoffice.psa.RefRolesMobileFolders;
import com.psabackoffice.psa.TblUserPsa;

/**
 * Service object for domain model class {@link RefRoles}.
 */
public interface RefRolesService {

    /**
     * Creates a new RefRoles. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RefRoles if any.
     *
     * @param refRoles Details of the RefRoles to be created; value cannot be null.
     * @return The newly created RefRoles.
     */
	RefRoles create(RefRoles refRoles);


	/**
	 * Returns RefRoles by given id if exists.
	 *
	 * @param refrolesId The id of the RefRoles to get; value cannot be null.
	 * @return RefRoles associated with the given refrolesId.
     * @throws EntityNotFoundException If no RefRoles is found.
	 */
	RefRoles getById(Integer refrolesId) throws EntityNotFoundException;

    /**
	 * Find and return the RefRoles by given id if exists, returns null otherwise.
	 *
	 * @param refrolesId The id of the RefRoles to get; value cannot be null.
	 * @return RefRoles associated with the given refrolesId.
	 */
	RefRoles findById(Integer refrolesId);


	/**
	 * Updates the details of an existing RefRoles. It replaces all fields of the existing RefRoles with the given refRoles.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on RefRoles if any.
     *
	 * @param refRoles The details of the RefRoles to be updated; value cannot be null.
	 * @return The updated RefRoles.
	 * @throws EntityNotFoundException if no RefRoles is found with given input.
	 */
	RefRoles update(RefRoles refRoles) throws EntityNotFoundException;

    /**
	 * Deletes an existing RefRoles with the given id.
	 *
	 * @param refrolesId The id of the RefRoles to be deleted; value cannot be null.
	 * @return The deleted RefRoles.
	 * @throws EntityNotFoundException if no RefRoles found with the given id.
	 */
	RefRoles delete(Integer refrolesId) throws EntityNotFoundException;

	/**
	 * Find all RefRoles matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefRoles.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<RefRoles> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all RefRoles matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RefRoles.
     *
     * @see Pageable
     * @see Page
	 */
    Page<RefRoles> findAll(String query, Pageable pageable);

    /**
	 * Exports all RefRoles matching the given input query to the given exportType format.
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
	 * Retrieve the count of the RefRoles in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the RefRoles.
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
     * Returns the associated refRolesMobileFolderses for given RefRoles id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated RefRolesMobileFolders instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<RefRolesMobileFolders> findAssociatedRefRolesMobileFolderses(Integer id, Pageable pageable);

    /*
     * Returns the associated tblUserPsas for given RefRoles id.
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

