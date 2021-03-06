/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsertFeedbackTicketNotesRequest implements Serializable {


    @JsonProperty("TicketID")
    private Integer ticketId;

    @JsonProperty("UserID")
    private Integer userId;

    @JsonProperty("Note")
    private String note;

    public Integer getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsertFeedbackTicketNotesRequest)) return false;
        final InsertFeedbackTicketNotesRequest insertFeedbackTicketNotesRequest = (InsertFeedbackTicketNotesRequest) o;
        return Objects.equals(getTicketId(), insertFeedbackTicketNotesRequest.getTicketId()) &&
                Objects.equals(getUserId(), insertFeedbackTicketNotesRequest.getUserId()) &&
                Objects.equals(getNote(), insertFeedbackTicketNotesRequest.getNote());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicketId(),
                getUserId(),
                getNote());
    }
}
