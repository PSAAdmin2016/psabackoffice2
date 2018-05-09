/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * ChatConversations generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ChatConversations`")
public class ChatConversations implements Serializable {

    private Integer conversationId;
    private Timestamp timeStamp;
    private List<ChatConversationMembers> chatConversationMemberses;
    private List<ChatMessages> chatMessageses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ConversationID`", nullable = false, scale = 0, precision = 10)
    public Integer getConversationId() {
        return this.conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    @Column(name = "`TimeStamp`", nullable = true)
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chatConversations")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE})
    public List<ChatConversationMembers> getChatConversationMemberses() {
        return this.chatConversationMemberses;
    }

    public void setChatConversationMemberses(List<ChatConversationMembers> chatConversationMemberses) {
        this.chatConversationMemberses = chatConversationMemberses;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chatConversations")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE})
    public List<ChatMessages> getChatMessageses() {
        return this.chatMessageses;
    }

    public void setChatMessageses(List<ChatMessages> chatMessageses) {
        this.chatMessageses = chatMessageses;
    }

    @PostPersist
    public void onPostPersist() {
        if(chatConversationMemberses != null) {
            chatConversationMemberses.forEach(chatConversationMembers -> chatConversationMembers.setChatConversations(this));
        }
        if(chatMessageses != null) {
            chatMessageses.forEach(chatMessages -> chatMessages.setChatConversations(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatConversations)) return false;
        final ChatConversations chatConversations = (ChatConversations) o;
        return Objects.equals(getConversationId(), chatConversations.getConversationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConversationId());
    }
}

