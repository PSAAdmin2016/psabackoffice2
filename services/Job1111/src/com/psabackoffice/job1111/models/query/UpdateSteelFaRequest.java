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

public class UpdateSteelFaRequest implements Serializable {


    @JsonProperty("BidID")
    @NotNull
    private Integer bidId;

    @JsonProperty("Quantity")
    @NotNull
    private Integer quantity;

    @JsonProperty("PercentCompleted")
    @NotNull
    private BigDecimal percentCompleted;

    @JsonProperty("Rework")
    @NotNull
    private Short rework;

    @JsonProperty("Notes")
    @NotNull
    private String notes;

    @JsonProperty("ActivityType")
    @NotNull
    private Short activityType;

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

    public BigDecimal getPercentCompleted() {
        return this.percentCompleted;
    }

    public void setPercentCompleted(BigDecimal percentCompleted) {
        this.percentCompleted = percentCompleted;
    }

    public Short getRework() {
        return this.rework;
    }

    public void setRework(Short rework) {
        this.rework = rework;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
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
        if (!(o instanceof UpdateSteelFaRequest)) return false;
        final UpdateSteelFaRequest updateSteelFaRequest = (UpdateSteelFaRequest) o;
        return Objects.equals(getBidId(), updateSteelFaRequest.getBidId()) &&
                Objects.equals(getQuantity(), updateSteelFaRequest.getQuantity()) &&
                Objects.equals(getPercentCompleted(), updateSteelFaRequest.getPercentCompleted()) &&
                Objects.equals(getRework(), updateSteelFaRequest.getRework()) &&
                Objects.equals(getNotes(), updateSteelFaRequest.getNotes()) &&
                Objects.equals(getActivityType(), updateSteelFaRequest.getActivityType()) &&
                Objects.equals(getActivityId(), updateSteelFaRequest.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBidId(),
                getQuantity(),
                getPercentCompleted(),
                getRework(),
                getNotes(),
                getActivityType(),
                getActivityId());
    }
}
