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

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.psabackoffice.psa.ChatMessages;
import com.psabackoffice.psa.service.ChatMessagesService;


/**
 * Controller object for domain model class ChatMessages.
 * @see ChatMessages
 */
@RestController("PSA.ChatMessagesController")
@Api(value = "ChatMessagesController", description = "Exposes APIs to work with ChatMessages resource.")
@RequestMapping("/PSA/ChatMessages")
public class ChatMessagesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatMessagesController.class);

    @Autowired
	@Qualifier("PSA.ChatMessagesService")
	private ChatMessagesService chatMessagesService;

	@ApiOperation(value = "Creates a new ChatMessages instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ChatMessages createChatMessages(@RequestBody ChatMessages chatMessages) {
		LOGGER.debug("Create ChatMessages with information: {}" , chatMessages);

		chatMessages = chatMessagesService.create(chatMessages);
		LOGGER.debug("Created ChatMessages with information: {}" , chatMessages);

	    return chatMessages;
	}

    @ApiOperation(value = "Returns the ChatMessages instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public ChatMessages getChatMessages(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting ChatMessages with id: {}" , id);

        ChatMessages foundChatMessages = chatMessagesService.getById(id);
        LOGGER.debug("ChatMessages details with id: {}" , foundChatMessages);

        return foundChatMessages;
    }

    @ApiOperation(value = "Updates the ChatMessages instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ChatMessages editChatMessages(@PathVariable("id") Integer id, @RequestBody ChatMessages chatMessages) {
        LOGGER.debug("Editing ChatMessages with id: {}" , chatMessages.getUid());

        chatMessages.setUid(id);
        chatMessages = chatMessagesService.update(chatMessages);
        LOGGER.debug("ChatMessages details with id: {}" , chatMessages);

        return chatMessages;
    }

    @ApiOperation(value = "Deletes the ChatMessages instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public boolean deleteChatMessages(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting ChatMessages with id: {}" , id);

        ChatMessages deletedChatMessages = chatMessagesService.delete(id);

        return deletedChatMessages != null;
    }

    /**
     * @deprecated Use {@link #findChatMessages(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ChatMessages instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ChatMessages> searchChatMessagesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ChatMessages list by query filter:{}", (Object) queryFilters);
        return chatMessagesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ChatMessages instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ChatMessages> findChatMessages(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ChatMessages list by filter:", query);
        return chatMessagesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ChatMessages instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ChatMessages> filterChatMessages(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ChatMessages list by filter", query);
        return chatMessagesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportChatMessages(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return chatMessagesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of ChatMessages instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countChatMessages( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ChatMessages");
		return chatMessagesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getChatMessagesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return chatMessagesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ChatMessagesService instance
	 */
	protected void setChatMessagesService(ChatMessagesService service) {
		this.chatMessagesService = service;
	}

}

