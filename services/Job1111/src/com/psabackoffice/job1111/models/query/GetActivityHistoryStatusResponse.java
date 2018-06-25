/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetActivityHistoryStatusResponse implements Serializable {


    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;

    @JsonProperty("Status")
    @ColumnAlias("Status")
    private String status;

    @JsonProperty("LastModifiedBy")
    @ColumnAlias("LastModifiedBy")
    private String lastModifiedBy;

    @JsonProperty("TimeStamp")
    @ColumnAlias("TimeStamp")
    private Timestamp timeStamp;

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
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
        if (!(o instanceof GetActivityHistoryStatusResponse)) return false;
        final GetActivityHistoryStatusResponse getActivityHistoryStatusResponse = (GetActivityHistoryStatusResponse) o;
        return Objects.equals(getActivityId(), getActivityHistoryStatusResponse.getActivityId()) &&
                Objects.equals(getStatus(), getActivityHistoryStatusResponse.getStatus()) &&
                Objects.equals(getLastModifiedBy(), getActivityHistoryStatusResponse.getLastModifiedBy()) &&
                Objects.equals(getTimeStamp(), getActivityHistoryStatusResponse.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(),
                getStatus(),
                getLastModifiedBy(),
                getTimeStamp());
    }
}
