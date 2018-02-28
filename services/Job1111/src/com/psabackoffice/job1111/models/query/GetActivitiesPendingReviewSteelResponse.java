/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetActivitiesPendingReviewSteelResponse implements Serializable {


    @ColumnAlias("SubmissionID")
    private Integer submissionId;

    @ColumnAlias("ActivityID")
    private Integer activityId;

    @ColumnAlias("ActivityType")
    private Short activityType;

    @ColumnAlias("fk_ActivityStatus")
    private Short fkActivityStatus;

    @ColumnAlias("ActivityTypeName")
    private String activityTypeName;

    @ColumnAlias("ReceivedTime")
    private Timestamp receivedTime;

    @ColumnAlias("NameFull")
    private String nameFull;

    @ColumnAlias("Status")
    private String status;

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

    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
    }

    public Short getFkActivityStatus() {
        return this.fkActivityStatus;
    }

    public void setFkActivityStatus(Short fkActivityStatus) {
        this.fkActivityStatus = fkActivityStatus;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetActivitiesPendingReviewSteelResponse)) return false;
        final GetActivitiesPendingReviewSteelResponse getActivitiesPendingReviewSteelResponse = (GetActivitiesPendingReviewSteelResponse) o;
        return Objects.equals(getSubmissionId(), getActivitiesPendingReviewSteelResponse.getSubmissionId()) &&
                Objects.equals(getActivityId(), getActivitiesPendingReviewSteelResponse.getActivityId()) &&
                Objects.equals(getActivityType(), getActivitiesPendingReviewSteelResponse.getActivityType()) &&
                Objects.equals(getFkActivityStatus(), getActivitiesPendingReviewSteelResponse.getFkActivityStatus()) &&
                Objects.equals(getActivityTypeName(), getActivitiesPendingReviewSteelResponse.getActivityTypeName()) &&
                Objects.equals(getReceivedTime(), getActivitiesPendingReviewSteelResponse.getReceivedTime()) &&
                Objects.equals(getNameFull(), getActivitiesPendingReviewSteelResponse.getNameFull()) &&
                Objects.equals(getStatus(), getActivitiesPendingReviewSteelResponse.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubmissionId(),
                getActivityId(),
                getActivityType(),
                getFkActivityStatus(),
                getActivityTypeName(),
                getReceivedTime(),
                getNameFull(),
                getStatus());
    }
}
