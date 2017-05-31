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

public class GetBidWorkHistoryCivilResponse implements Serializable {

    @JsonProperty("SubmissionID")
    @ColumnAlias("SubmissionID")
    private Integer submissionId;
    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;
    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private String activityType;
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
    @JsonProperty("Quantity")
    @ColumnAlias("Quantity")
    private BigInteger quantity;
    @JsonProperty("PercentClaimed")
    @ColumnAlias("PercentClaimed")
    private Float percentClaimed;
    @JsonProperty("Notes")
    @ColumnAlias("Notes")
    private String notes;
    @JsonProperty("Rework")
    @ColumnAlias("Rework")
    private Integer rework;

    public Integer getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

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

    public BigInteger getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public Float getPercentClaimed() {
        return this.percentClaimed;
    }

    public void setPercentClaimed(Float percentClaimed) {
        this.percentClaimed = percentClaimed;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getRework() {
        return this.rework;
    }

    public void setRework(Integer rework) {
        this.rework = rework;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetBidWorkHistoryCivilResponse)) return false;
        final GetBidWorkHistoryCivilResponse getBidWorkHistoryCivilResponse = (GetBidWorkHistoryCivilResponse) o;
        return Objects.equals(getSubmissionId(), getBidWorkHistoryCivilResponse.getSubmissionId()) &&
                Objects.equals(getActivityId(), getBidWorkHistoryCivilResponse.getActivityId()) &&
                Objects.equals(getActivityType(), getBidWorkHistoryCivilResponse.getActivityType()) &&
                Objects.equals(getForeman(), getBidWorkHistoryCivilResponse.getForeman()) &&
                Objects.equals(getSupervisor(), getBidWorkHistoryCivilResponse.getSupervisor()) &&
                Objects.equals(getCompleteTime(), getBidWorkHistoryCivilResponse.getCompleteTime()) &&
                Objects.equals(getReviewedTime(), getBidWorkHistoryCivilResponse.getReviewedTime()) &&
                Objects.equals(getQuantity(), getBidWorkHistoryCivilResponse.getQuantity()) &&
                Objects.equals(getPercentClaimed(), getBidWorkHistoryCivilResponse.getPercentClaimed()) &&
                Objects.equals(getNotes(), getBidWorkHistoryCivilResponse.getNotes()) &&
                Objects.equals(getRework(), getBidWorkHistoryCivilResponse.getRework());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubmissionId(),
                getActivityId(),
                getActivityType(),
                getForeman(),
                getSupervisor(),
                getCompleteTime(),
                getReviewedTime(),
                getQuantity(),
                getPercentClaimed(),
                getNotes(),
                getRework());
    }
}
