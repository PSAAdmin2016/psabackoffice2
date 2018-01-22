/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetActivitiesPendingReviewResponse implements Serializable {


    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;

    @JsonProperty("SubmissionID")
    @ColumnAlias("SubmissionID")
    private Integer submissionId;

    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private Short activityType;

    @JsonProperty("fk_BidIDAssigned")
    @ColumnAlias("fk_BidIDAssigned")
    private Integer fkBidIdassigned;

    @JsonProperty("fk_ActivityStatus")
    @ColumnAlias("fk_ActivityStatus")
    private Integer fkActivityStatus;

    @JsonProperty("fk_LastModifiedBy")
    @ColumnAlias("fk_LastModifiedBy")
    private Integer fkLastModifiedBy;

    @JsonProperty("LockField")
    @ColumnAlias("LockField")
    private Integer lockField;

    @JsonProperty("Rev")
    @ColumnAlias("Rev")
    private Short rev;

    @JsonProperty("TimeStamp")
    @ColumnAlias("TimeStamp")
    private Timestamp timeStamp;

    @JsonProperty("ActivityTypeName")
    @ColumnAlias("ActivityTypeName")
    private String activityTypeName;

    @JsonProperty("ReceivedTime")
    @ColumnAlias("ReceivedTime")
    private Timestamp receivedTime;

    @JsonProperty("FirstName")
    @ColumnAlias("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    @ColumnAlias("LastName")
    private String lastName;

    @JsonProperty("NameFull")
    @ColumnAlias("NameFull")
    private String nameFull;

    @JsonProperty("Status")
    @ColumnAlias("Status")
    private String status;

    @JsonProperty("Craft")
    @ColumnAlias("Craft")
    private String craft;

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
    }

    public Integer getFkBidIdassigned() {
        return this.fkBidIdassigned;
    }

    public void setFkBidIdassigned(Integer fkBidIdassigned) {
        this.fkBidIdassigned = fkBidIdassigned;
    }

    public Integer getFkActivityStatus() {
        return this.fkActivityStatus;
    }

    public void setFkActivityStatus(Integer fkActivityStatus) {
        this.fkActivityStatus = fkActivityStatus;
    }

    public Integer getFkLastModifiedBy() {
        return this.fkLastModifiedBy;
    }

    public void setFkLastModifiedBy(Integer fkLastModifiedBy) {
        this.fkLastModifiedBy = fkLastModifiedBy;
    }

    public Integer getLockField() {
        return this.lockField;
    }

    public void setLockField(Integer lockField) {
        this.lockField = lockField;
    }

    public Short getRev() {
        return this.rev;
    }

    public void setRev(Short rev) {
        this.rev = rev;
    }

    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getActivityTypeName() {
        return this.activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public Timestamp getReceivedTime() {
        return this.receivedTime;
    }

    public void setReceivedTime(Timestamp receivedTime) {
        this.receivedTime = receivedTime;
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

    public String getNameFull() {
        return this.nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCraft() {
        return this.craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetActivitiesPendingReviewResponse)) return false;
        final GetActivitiesPendingReviewResponse getActivitiesPendingReviewResponse = (GetActivitiesPendingReviewResponse) o;
        return Objects.equals(getActivityId(), getActivitiesPendingReviewResponse.getActivityId()) &&
                Objects.equals(getSubmissionId(), getActivitiesPendingReviewResponse.getSubmissionId()) &&
                Objects.equals(getActivityType(), getActivitiesPendingReviewResponse.getActivityType()) &&
                Objects.equals(getFkBidIdassigned(), getActivitiesPendingReviewResponse.getFkBidIdassigned()) &&
                Objects.equals(getFkActivityStatus(), getActivitiesPendingReviewResponse.getFkActivityStatus()) &&
                Objects.equals(getFkLastModifiedBy(), getActivitiesPendingReviewResponse.getFkLastModifiedBy()) &&
                Objects.equals(getLockField(), getActivitiesPendingReviewResponse.getLockField()) &&
                Objects.equals(getRev(), getActivitiesPendingReviewResponse.getRev()) &&
                Objects.equals(getTimeStamp(), getActivitiesPendingReviewResponse.getTimeStamp()) &&
                Objects.equals(getActivityTypeName(), getActivitiesPendingReviewResponse.getActivityTypeName()) &&
                Objects.equals(getReceivedTime(), getActivitiesPendingReviewResponse.getReceivedTime()) &&
                Objects.equals(getFirstName(), getActivitiesPendingReviewResponse.getFirstName()) &&
                Objects.equals(getLastName(), getActivitiesPendingReviewResponse.getLastName()) &&
                Objects.equals(getNameFull(), getActivitiesPendingReviewResponse.getNameFull()) &&
                Objects.equals(getStatus(), getActivitiesPendingReviewResponse.getStatus()) &&
                Objects.equals(getCraft(), getActivitiesPendingReviewResponse.getCraft());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(),
                getSubmissionId(),
                getActivityType(),
                getFkBidIdassigned(),
                getFkActivityStatus(),
                getFkLastModifiedBy(),
                getLockField(),
                getRev(),
                getTimeStamp(),
                getActivityTypeName(),
                getReceivedTime(),
                getFirstName(),
                getLastName(),
                getNameFull(),
                getStatus(),
                getCraft());
    }
}
