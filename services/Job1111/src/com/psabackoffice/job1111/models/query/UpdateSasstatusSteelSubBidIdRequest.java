/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateSasstatusSteelSubBidIdRequest implements Serializable {


    @JsonProperty("NewStatusID")
    @NotNull
    private Integer newStatusId;

    @JsonProperty("UserID")
    @NotNull
    private Integer userId;

    @JsonProperty("SubmissionID")
    @NotNull
    private Integer submissionId;

    @JsonProperty("BidID")
    @NotNull
    private Integer bidId;

    @JsonProperty("CurrentStatusID")
    @NotNull
    private Integer currentStatusId;

    public Integer getNewStatusId() {
        return this.newStatusId;
    }

    public void setNewStatusId(Integer newStatusId) {
        this.newStatusId = newStatusId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Integer getBidId() {
        return this.bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Integer getCurrentStatusId() {
        return this.currentStatusId;
    }

    public void setCurrentStatusId(Integer currentStatusId) {
        this.currentStatusId = currentStatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateSasstatusSteelSubBidIdRequest)) return false;
        final UpdateSasstatusSteelSubBidIdRequest updateSasstatusSteelSubBidIdRequest = (UpdateSasstatusSteelSubBidIdRequest) o;
        return Objects.equals(getNewStatusId(), updateSasstatusSteelSubBidIdRequest.getNewStatusId()) &&
                Objects.equals(getUserId(), updateSasstatusSteelSubBidIdRequest.getUserId()) &&
                Objects.equals(getSubmissionId(), updateSasstatusSteelSubBidIdRequest.getSubmissionId()) &&
                Objects.equals(getBidId(), updateSasstatusSteelSubBidIdRequest.getBidId()) &&
                Objects.equals(getCurrentStatusId(), updateSasstatusSteelSubBidIdRequest.getCurrentStatusId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNewStatusId(),
                getUserId(),
                getSubmissionId(),
                getBidId(),
                getCurrentStatusId());
    }
}
