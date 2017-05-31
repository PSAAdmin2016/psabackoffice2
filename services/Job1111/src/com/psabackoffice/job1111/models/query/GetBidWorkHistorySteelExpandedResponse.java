/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetBidWorkHistorySteelExpandedResponse implements Serializable {

    @JsonProperty("SubmissionID")
    @ColumnAlias("SubmissionID")
    private Integer submissionId;
    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;
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
    @JsonProperty("ActivityTypeName")
    @ColumnAlias("ActivityTypeName")
    private String activityTypeName;
    @JsonProperty("Quantity")
    @ColumnAlias("Quantity")
    private Long quantity;
    @JsonProperty("Percent")
    @ColumnAlias("Percent")
    private String percent;
    @JsonProperty("Notes")
    @ColumnAlias("Notes")
    private String notes;
    @JsonProperty("Rework")
    @ColumnAlias("Rework")
    private Long rework;

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

    public String getActivityTypeName() {
        return this.activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getPercent() {
        return this.percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getRework() {
        return this.rework;
    }

    public void setRework(Long rework) {
        this.rework = rework;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetBidWorkHistorySteelExpandedResponse)) return false;
        final GetBidWorkHistorySteelExpandedResponse getBidWorkHistorySteelExpandedResponse = (GetBidWorkHistorySteelExpandedResponse) o;
        return Objects.equals(getSubmissionId(), getBidWorkHistorySteelExpandedResponse.getSubmissionId()) &&
                Objects.equals(getActivityId(), getBidWorkHistorySteelExpandedResponse.getActivityId()) &&
                Objects.equals(getForeman(), getBidWorkHistorySteelExpandedResponse.getForeman()) &&
                Objects.equals(getSupervisor(), getBidWorkHistorySteelExpandedResponse.getSupervisor()) &&
                Objects.equals(getCompleteTime(), getBidWorkHistorySteelExpandedResponse.getCompleteTime()) &&
                Objects.equals(getReviewedTime(), getBidWorkHistorySteelExpandedResponse.getReviewedTime()) &&
                Objects.equals(getActivityTypeName(), getBidWorkHistorySteelExpandedResponse.getActivityTypeName()) &&
                Objects.equals(getQuantity(), getBidWorkHistorySteelExpandedResponse.getQuantity()) &&
                Objects.equals(getPercent(), getBidWorkHistorySteelExpandedResponse.getPercent()) &&
                Objects.equals(getNotes(), getBidWorkHistorySteelExpandedResponse.getNotes()) &&
                Objects.equals(getRework(), getBidWorkHistorySteelExpandedResponse.getRework());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubmissionId(),
                getActivityId(),
                getForeman(),
                getSupervisor(),
                getCompleteTime(),
                getReviewedTime(),
                getActivityTypeName(),
                getQuantity(),
                getPercent(),
                getNotes(),
                getRework());
    }
}
