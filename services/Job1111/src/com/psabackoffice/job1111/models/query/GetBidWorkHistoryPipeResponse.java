/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetBidWorkHistoryPipeResponse implements Serializable {

    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;
    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private String activityType;
    @JsonProperty("Quantity")
    @ColumnAlias("Quantity")
    private Double quantity;
    @JsonProperty("Notes")
    @ColumnAlias("Notes")
    private String notes;
    @JsonProperty("Rev")
    @ColumnAlias("Rev")
    private Short rev;
    @JsonProperty("Rework")
    @ColumnAlias("Rework")
    private String rework;
    @JsonProperty("Foreman")
    @ColumnAlias("Foreman")
    private String foreman;
    @JsonProperty("Supervisor")
    @ColumnAlias("Supervisor")
    private String supervisor;
    @JsonProperty("CompleteTime")
    @ColumnAlias("CompleteTime")
    private Timestamp completeTime;
    @JsonProperty("ReviewedTime")
    @ColumnAlias("ReviewedTime")
    private Timestamp reviewedTime;

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Short getRev() {
        return this.rev;
    }

    public void setRev(Short rev) {
        this.rev = rev;
    }

    public String getRework() {
        return this.rework;
    }

    public void setRework(String rework) {
        this.rework = rework;
    }

    public String getForeman() {
        return this.foreman;
    }

    public void setForeman(String foreman) {
        this.foreman = foreman;
    }

    public String getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Timestamp getCompleteTime() {
        return this.completeTime;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    public Timestamp getReviewedTime() {
        return this.reviewedTime;
    }

    public void setReviewedTime(Timestamp reviewedTime) {
        this.reviewedTime = reviewedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetBidWorkHistoryPipeResponse)) return false;
        final GetBidWorkHistoryPipeResponse getBidWorkHistoryPipeResponse = (GetBidWorkHistoryPipeResponse) o;
        return Objects.equals(getActivityId(), getBidWorkHistoryPipeResponse.getActivityId()) &&
                Objects.equals(getActivityType(), getBidWorkHistoryPipeResponse.getActivityType()) &&
                Objects.equals(getQuantity(), getBidWorkHistoryPipeResponse.getQuantity()) &&
                Objects.equals(getNotes(), getBidWorkHistoryPipeResponse.getNotes()) &&
                Objects.equals(getRev(), getBidWorkHistoryPipeResponse.getRev()) &&
                Objects.equals(getRework(), getBidWorkHistoryPipeResponse.getRework()) &&
                Objects.equals(getForeman(), getBidWorkHistoryPipeResponse.getForeman()) &&
                Objects.equals(getSupervisor(), getBidWorkHistoryPipeResponse.getSupervisor()) &&
                Objects.equals(getCompleteTime(), getBidWorkHistoryPipeResponse.getCompleteTime()) &&
                Objects.equals(getReviewedTime(), getBidWorkHistoryPipeResponse.getReviewedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(),
                getActivityType(),
                getQuantity(),
                getNotes(),
                getRev(),
                getRework(),
                getForeman(),
                getSupervisor(),
                getCompleteTime(),
                getReviewedTime());
    }
}
