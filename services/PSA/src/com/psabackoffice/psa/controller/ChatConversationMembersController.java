/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.psabackoffice.psa.ChatConversationMembers;
import com.psabackoffice.psa.service.ChatConversationMembersService;


/**
 * Controller object for domain model class ChatConversationMembers.
 * @see ChatConversationMembers
 */
@RestController("PSA.ChatConversationMembersController")
@Api(value = "ChatConversationMembersController", description = "Exposes APIs to work with ChatConversationMembers resource.")
@RequestMapping("/PSA/ChatConversationMembers")
public class ChatConversationMembersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatConversationMembersController.class);

    @Autowired
	@Qualifier("PSA.ChatConversationMembersService")
	private ChatConversationMembersService chatConversationMembersService;

	@ApiOperation(value = "Creates a new ChatConversationMembers instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public ChatConversationMembers createChatConversationMembers(@RequestBody ChatConversationMembers chatConversationMembers) {
		LOGGER.debug("Create ChatConversationMembers with information: {}" , chatConversationMembers);

		chatConversationMembers = chatConversationMembersService.create(chatConversationMembers);
		LOGGER.debug("Created ChatConversationMembers with information: {}" , chatConversationMembers);

	    return chatConversationMembers;
	}


    @ApiOperation(value = "Returns the ChatConversationMembers instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ChatConversationMembers getChatConversationMembers(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting ChatConversationMembers with id: {}" , id);

        ChatConversationMembers foundChatConversationMembers = chatConversationMembersService.getById(id);
        LOGGER.debug("ChatConversationMembers details with id: {}" , foundChatConversationMembers);

        return foundChatConversationMembers;
    }

    @ApiOperation(value = "Updates the ChatConversationMembers instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ChatConversationMembers editChatConversationMembers(@PathVariable("id") Integer id, @RequestBody ChatConversationMembers chatConversationMembers) throws EntityNotFoundException {
        LOGGER.debug("Editing ChatConversationMembers with id: {}" , chatConversationMembers.getUid());

        chatConversationMembers.setUid(id);
        chatConversationMembers = chatConversationMembersService.update(chatConversationMembers);
        LOGGER.debug("ChatConversationMembers details with id: {}" , chatConversationMembers);

        return chatConversationMembers;
    }

    @ApiOperation(value = "Deletes the ChatConversationMembers instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteChatConversationMembers(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting ChatConversationMembers with id: {}" , id);

        ChatConversationMembers deletedChatConversationMembers = chatConversationMembersService.delete(id);

        return deletedChatConversationMembers != null;
    }

    /**
     * @deprecated Use {@link #findChatConversationMembers(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ChatConversationMembers instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ChatConversationMembers> searchChatConversationMembersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ChatConversationMembers list");
        return chatConversationMembersService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ChatConversationMembers instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ChatConversationMembers> findChatConversationMembers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ChatConversationMembers list");
        return chatConversationMembersService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ChatConversationMembers instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ChatConversationMembers> filterChatConversationMembers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ChatConversationMembers list");
        return chatConversationMembersService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportChatConversationMembers(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return chatConversationMembersService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of ChatConversationMembers instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countChatConversationMembers( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ChatConversationMembers");
		return chatConversationMembersService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getChatConversationMembersAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return chatConversationMembersService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ChatConversationMembersService instance
	 */
	protected void setChatConversationMembersService(ChatConversationMembersService service) {
		this.chatConversationMembersService = service;
	}

}

