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

import com.psabackoffice.psa.ChatConversationMembers;
import com.psabackoffice.psa.ChatMessages;
import com.psabackoffice.psa.FeedBack;
import com.psabackoffice.psa.FeedBackNotes;
import com.psabackoffice.psa.Settingsuser;
import com.psabackoffice.psa.TblCrews;
import com.psabackoffice.psa.TblUserJobNumbers;
import com.psabackoffice.psa.TblUserPsa;
import com.psabackoffice.psa.TblUserRoles;

/**
 * Service object for domain model class {@link TblUserPsa}.
 */
public interface TblUserPsaService {

    /**
     * Creates a new TblUserPsa. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TblUserPsa if any.
     *
     * @param tblUserPsa Details of the TblUserPsa to be created; value cannot be null.
     * @return The newly created TblUserPsa.
     */
	TblUserPsa create(@Valid TblUserPsa tblUserPsa);


	/**
	 * Returns TblUserPsa by given id if exists.
	 *
	 * @param tbluserpsaId The id of the TblUserPsa to get; value cannot be null.
	 * @return TblUserPsa associated with the given tbluserpsaId.
     * @throws EntityNotFoundException If no TblUserPsa is found.
	 */
	TblUserPsa getById(Integer tbluserpsaId);

    /**
	 * Find and return the TblUserPsa by given id if exists, returns null otherwise.
	 *
	 * @param tbluserpsaId The id of the TblUserPsa to get; value cannot be null.
	 * @return TblUserPsa associated with the given tbluserpsaId.
	 */
	TblUserPsa findById(Integer tbluserpsaId);

    /**
	 * Find and return the TblUserPsa for given email  if exists.
	 *
	 * @param email value of email; value cannot be null.
	 * @return TblUserPsa associated with the given inputs.
     * @throws EntityNotFoundException if no matching TblUserPsa found.
	 */
    TblUserPsa getByEmail(String email);

    /**
	 * Find and return the TblUserPsa for given pciEmployeeId  if exists.
	 *
	 * @param pciEmployeeId value of pciEmployeeId; value cannot be null.
	 * @return TblUserPsa associated with the given inputs.
     * @throws EntityNotFoundException if no matching TblUserPsa found.
	 */
    TblUserPsa getByPciEmployeeId(String pciEmployeeId);

	/**
	 * Updates the details of an existing TblUserPsa. It replaces all fields of the existing TblUserPsa with the given tblUserPsa.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TblUserPsa if any.
     *
	 * @param tblUserPsa The details of the TblUserPsa to be updated; value cannot be null.
	 * @return The updated TblUserPsa.
	 * @throws EntityNotFoundException if no TblUserPsa is found with given input.
	 */
	TblUserPsa update(@Valid TblUserPsa tblUserPsa);

    /**
	 * Deletes an existing TblUserPsa with the given id.
	 *
	 * @param tbluserpsaId The id of the TblUserPsa to be deleted; value cannot be null.
	 * @return The deleted TblUserPsa.
	 * @throws EntityNotFoundException if no TblUserPsa found with the given id.
	 */
	TblUserPsa delete(Integer tbluserpsaId);

    /**
	 * Deletes an existing TblUserPsa with the given object.
	 *
	 * @param tblUserPsa The instance of the TblUserPsa to be deleted; value cannot be null.
	 */
	void delete(TblUserPsa tblUserPsa);

	/**
	 * Find all TblUserPsas matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TblUserPsas.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TblUserPsa> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TblUserPsas matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TblUserPsas.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TblUserPsa> findAll(String query, Pageable pageable);

    /**
	 * Exports all TblUserPsas matching the given input query to the given exportType format.
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
	 * Retrieve the count of the TblUserPsas in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TblUserPsa.
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
     * Returns the associated chatConversationMemberses for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated ChatConversationMembers instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<ChatConversationMembers> findAssociatedChatConversationMemberses(Integer id, Pageable pageable);

    /*
     * Returns the associated chatMessageses for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated ChatMessages instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<ChatMessages> findAssociatedChatMessageses(Integer id, Pageable pageable);

    /*
     * Returns the associated feedBacks for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated FeedBack instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<FeedBack> findAssociatedFeedBacks(Integer id, Pageable pageable);

    /*
     * Returns the associated feedBackNoteses for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated FeedBackNotes instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<FeedBackNotes> findAssociatedFeedBackNoteses(Integer id, Pageable pageable);

    /*
     * Returns the associated settingsusers for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Settingsuser instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Settingsuser> findAssociatedSettingsusers(Integer id, Pageable pageable);

    /*
     * Returns the associated tblCrewsesForProjectManager for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TblCrews instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TblCrews> findAssociatedTblCrewsesForProjectManager(Integer id, Pageable pageable);

    /*
     * Returns the associated tblCrewsesForAreaManager for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TblCrews instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TblCrews> findAssociatedTblCrewsesForAreaManager(Integer id, Pageable pageable);

    /*
     * Returns the associated tblCrewsesForSiteManager for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TblCrews instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TblCrews> findAssociatedTblCrewsesForSiteManager(Integer id, Pageable pageable);

    /*
     * Returns the associated tblCrewsesForGf for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TblCrews instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TblCrews> findAssociatedTblCrewsesForGf(Integer id, Pageable pageable);

    /*
     * Returns the associated tblCrewsesForLeadman for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TblCrews instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TblCrews> findAssociatedTblCrewsesForLeadman(Integer id, Pageable pageable);

    /*
     * Returns the associated tblCrewsesForConstructionManager for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TblCrews instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TblCrews> findAssociatedTblCrewsesForConstructionManager(Integer id, Pageable pageable);

    /*
     * Returns the associated tblCrewsesForSuperintendent for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TblCrews instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TblCrews> findAssociatedTblCrewsesForSuperintendent(Integer id, Pageable pageable);

    /*
     * Returns the associated tblUserJobNumberses for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TblUserJobNumbers instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TblUserJobNumbers> findAssociatedTblUserJobNumberses(Integer id, Pageable pageable);

    /*
     * Returns the associated tblUserRoleses for given TblUserPsa id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated TblUserRoles instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<TblUserRoles> findAssociatedTblUserRoleses(Integer id, Pageable pageable);

}

