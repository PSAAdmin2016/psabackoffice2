/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePipeFaRequest implements Serializable {


    @JsonProperty("BidID")
    @NotNull
    private Integer bidId;

    @JsonProperty("Quantity")
    @NotNull
    private Integer quantity;

    @JsonProperty("Percent")
    @NotNull
    private BigDecimal percent;

    @JsonProperty("Rework")
    @NotNull
    private Integer rework;

    @JsonProperty("Notes")
    private String notes;

    @JsonProperty("ActivityID")
    @NotNull
    private Integer activityId;

    public Integer getBidId() {
        return this.bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPercent() {
        return this.percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public Integer getRework() {
        return this.rework;
    }

    public void setRework(Integer rework) {
        this.rework = rework;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdatePipeFaRequest)) return false;
        final UpdatePipeFaRequest updatePipeFaRequest = (UpdatePipeFaRequest) o;
        return Objects.equals(getBidId(), updatePipeFaRequest.getBidId()) &&
                Objects.equals(getQuantity(), updatePipeFaRequest.getQuantity()) &&
                Objects.equals(getPercent(), updatePipeFaRequest.getPercent()) &&
                Objects.equals(getRework(), updatePipeFaRequest.getRework()) &&
                Objects.equals(getNotes(), updatePipeFaRequest.getNotes()) &&
                Objects.equals(getActivityId(), updatePipeFaRequest.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBidId(),
                getQuantity(),
                getPercent(),
                getRework(),
                getNotes(),
                getActivityId());
    }
}