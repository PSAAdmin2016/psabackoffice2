/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePipeFaquantityRequest implements Serializable {


    @JsonProperty("Quantity")
    @NotNull
    private Integer quantity;

    @JsonProperty("Percent")
    @NotNull
    private BigDecimal percent;

    @JsonProperty("ActivityID")
    @NotNull
    private Integer activityId;

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPercent() {
        return this.percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
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
        if (!(o instanceof UpdatePipeFaquantityRequest)) return false;
        final UpdatePipeFaquantityRequest updatePipeFaquantityRequest = (UpdatePipeFaquantityRequest) o;
        return Objects.equals(getQuantity(), updatePipeFaquantityRequest.getQuantity()) &&
                Objects.equals(getPercent(), updatePipeFaquantityRequest.getPercent()) &&
                Objects.equals(getActivityId(), updatePipeFaquantityRequest.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantity(),
                getPercent(),
                getActivityId());
    }
}
