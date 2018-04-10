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

public class UpdatePipeErectionQuantityRequest implements Serializable {


    @JsonProperty("Spool1Length")
    private Integer spool1length;

    @JsonProperty("ActivityID")
    @NotNull
    private Integer activityId;

    public Integer getSpool1length() {
        return this.spool1length;
    }

    public void setSpool1length(Integer spool1length) {
        this.spool1length = spool1length;
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
        if (!(o instanceof UpdatePipeErectionQuantityRequest)) return false;
        final UpdatePipeErectionQuantityRequest updatePipeErectionQuantityRequest = (UpdatePipeErectionQuantityRequest) o;
        return Objects.equals(getSpool1length(), updatePipeErectionQuantityRequest.getSpool1length()) &&
                Objects.equals(getActivityId(), updatePipeErectionQuantityRequest.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpool1length(),
                getActivityId());
    }
}
