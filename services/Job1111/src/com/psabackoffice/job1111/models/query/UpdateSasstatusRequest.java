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

public class UpdateSasstatusRequest implements Serializable {


    @JsonProperty("ActivityStatusID")
    @NotNull
    private Integer activityStatusId;

    @JsonProperty("UserID")
    @NotNull
    private String userId;

    @JsonProperty("ActivityID")
    @NotNull
    private String activityId;

    public Integer getActivityStatusId() {
        return this.activityStatusId;
    }

    public void setActivityStatusId(Integer activityStatusId) {
        this.activityStatusId = activityStatusId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateSasstatusRequest)) return false;
        final UpdateSasstatusRequest updateSasstatusRequest = (UpdateSasstatusRequest) o;
        return Objects.equals(getActivityStatusId(), updateSasstatusRequest.getActivityStatusId()) &&
                Objects.equals(getUserId(), updateSasstatusRequest.getUserId()) &&
                Objects.equals(getActivityId(), updateSasstatusRequest.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityStatusId(),
                getUserId(),
                getActivityId());
    }
}
