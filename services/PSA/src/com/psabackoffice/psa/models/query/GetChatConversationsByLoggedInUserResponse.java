/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetChatConversationsByLoggedInUserResponse implements Serializable {


    @JsonProperty("ConversationID")
    @ColumnAlias("ConversationID")
    private Integer conversationId;

    @JsonProperty("RecipientUserID")
    @ColumnAlias("RecipientUserID")
    private Integer recipientUserId;

    @JsonProperty("FirstName")
    @ColumnAlias("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    @ColumnAlias("LastName")
    private String lastName;

    @JsonProperty("Email")
    @ColumnAlias("Email")
    private String email;

    @JsonProperty("Timestamp")
    @ColumnAlias("Timestamp")
    private LocalDateTime timestamp;

    @JsonProperty("LastMessage")
    @ColumnAlias("LastMessage")
    private String lastMessage;

    @JsonProperty("Status")
    @ColumnAlias("Status")
    private Short status;

    @JsonProperty("Author")
    @ColumnAlias("Author")
    private Integer author;

    public Integer getConversationId() {
        return this.conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getRecipientUserId() {
        return this.recipientUserId;
    }

    public void setRecipientUserId(Integer recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getLastMessage() {
        return this.lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Short getStatus() {
        return this.status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getAuthor() {
        return this.author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetChatConversationsByLoggedInUserResponse)) return false;
        final GetChatConversationsByLoggedInUserResponse getChatConversationsByLoggedInUserResponse = (GetChatConversationsByLoggedInUserResponse) o;
        return Objects.equals(getConversationId(), getChatConversationsByLoggedInUserResponse.getConversationId()) &&
                Objects.equals(getRecipientUserId(), getChatConversationsByLoggedInUserResponse.getRecipientUserId()) &&
                Objects.equals(getFirstName(), getChatConversationsByLoggedInUserResponse.getFirstName()) &&
                Objects.equals(getLastName(), getChatConversationsByLoggedInUserResponse.getLastName()) &&
                Objects.equals(getEmail(), getChatConversationsByLoggedInUserResponse.getEmail()) &&
                Objects.equals(getTimestamp(), getChatConversationsByLoggedInUserResponse.getTimestamp()) &&
                Objects.equals(getLastMessage(), getChatConversationsByLoggedInUserResponse.getLastMessage()) &&
                Objects.equals(getStatus(), getChatConversationsByLoggedInUserResponse.getStatus()) &&
                Objects.equals(getAuthor(), getChatConversationsByLoggedInUserResponse.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConversationId(),
                getRecipientUserId(),
                getFirstName(),
                getLastName(),
                getEmail(),
                getTimestamp(),
                getLastMessage(),
                getStatus(),
                getAuthor());
    }
}
