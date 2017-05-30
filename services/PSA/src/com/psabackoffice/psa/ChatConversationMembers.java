/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ChatConversationMembers generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ChatConversationMembers`")
public class ChatConversationMembers implements Serializable {

    private Integer uid;
    private Integer conversationId;
    private Integer status;
    private Integer userId;
    private TblUserPsa tblUserPsa;
    private ChatConversations chatConversations;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`UID`", nullable = false, scale = 0, precision = 10)
    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column(name = "`ConversationID`", nullable = true, scale = 0, precision = 10)
    public Integer getConversationId() {
        return this.conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    @Column(name = "`Status`", nullable = true, scale = 0, precision = 10)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "`UserID`", nullable = true, scale = 0, precision = 10)
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`UserID`", referencedColumnName = "`ID`", insertable = false, updatable = false)
    public TblUserPsa getTblUserPsa() {
        return this.tblUserPsa;
    }

    public void setTblUserPsa(TblUserPsa tblUserPsa) {
        if(tblUserPsa != null) {
            this.userId = tblUserPsa.getId();
        }

        this.tblUserPsa = tblUserPsa;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ConversationID`", referencedColumnName = "`ConversationID`", insertable = false, updatable = false)
    public ChatConversations getChatConversations() {
        return this.chatConversations;
    }

    public void setChatConversations(ChatConversations chatConversations) {
        if(chatConversations != null) {
            this.conversationId = chatConversations.getConversationId();
        }

        this.chatConversations = chatConversations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatConversationMembers)) return false;
        final ChatConversationMembers chatConversationMembers = (ChatConversationMembers) o;
        return Objects.equals(getUid(), chatConversationMembers.getUid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid());
    }
}

