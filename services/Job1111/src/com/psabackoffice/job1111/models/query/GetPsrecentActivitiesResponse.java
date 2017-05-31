/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetPsrecentActivitiesResponse implements Serializable {

    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private String activityType;
    @JsonProperty("PSAActivityID")
    @ColumnAlias("PSAActivityID")
    private Integer psaactivityId;
    @JsonProperty("Status")
    @ColumnAlias("Status")
    private String status;
    @JsonProperty("TimeStamp")
    @ColumnAlias("TimeStamp")
    private Timestamp timeStamp;

    public String getActivityType() {
        return this.activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Integer getPsaactivityId() {
        return this.psaactivityId;
    }

    public void setPsaactivityId(Integer psaactivityId) {
        this.psaactivityId = psaactivityId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetPsrecentActivitiesResponse)) return false;
        final GetPsrecentActivitiesResponse getPsrecentActivitiesResponse = (GetPsrecentActivitiesResponse) o;
        return Objects.equals(getActivityType(), getPsrecentActivitiesResponse.getActivityType()) &&
                Objects.equals(getPsaactivityId(), getPsrecentActivitiesResponse.getPsaactivityId()) &&
                Objects.equals(getStatus(), getPsrecentActivitiesResponse.getStatus()) &&
                Objects.equals(getTimeStamp(), getPsrecentActivitiesResponse.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityType(),
                getPsaactivityId(),
                getStatus(),
                getTimeStamp());
    }
}
