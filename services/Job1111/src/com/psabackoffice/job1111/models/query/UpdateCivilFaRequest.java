/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCivilFaRequest implements Serializable {


    @JsonProperty("Quantity")
    @NotNull
    private String quantity;

    @JsonProperty("Percent")
    @NotNull
    private String percent;

    @JsonProperty("Rework")
    @NotNull
    private Integer rework;

    @JsonProperty("Notes")
    private String notes;

    @JsonProperty("ActivityID")
    @NotNull
    private String activityId;

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPercent() {
        return this.percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public Integer getRework() {
        return this.rework;
    }

    public void setRework(Integer rework) {
        this.rework = rework;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        if (!(o instanceof UpdateCivilFaRequest)) return false;
        final UpdateCivilFaRequest updateCivilFaRequest = (UpdateCivilFaRequest) o;
        return Objects.equals(getQuantity(), updateCivilFaRequest.getQuantity()) &&
                Objects.equals(getPercent(), updateCivilFaRequest.getPercent()) &&
                Objects.equals(getRework(), updateCivilFaRequest.getRework()) &&
                Objects.equals(getNotes(), updateCivilFaRequest.getNotes()) &&
                Objects.equals(getActivityId(), updateCivilFaRequest.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantity(),
                getPercent(),
                getRework(),
                getNotes(),
                getActivityId());
    }
}
