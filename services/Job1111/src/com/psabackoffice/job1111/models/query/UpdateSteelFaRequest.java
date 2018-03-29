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

public class UpdateSteelFaRequest implements Serializable {


    @JsonProperty("Area")
    @NotNull
    private String area;

    @JsonProperty("Piece")
    @NotNull
    private String piece;

    @JsonProperty("Quantity")
    @NotNull
    private Integer quantity;

    @JsonProperty("Percent")
    @NotNull
    private BigDecimal percent;

    @JsonProperty("Rework")
    @NotNull
    private Short rework;

    @JsonProperty("Notes")
    @NotNull
    private String notes;

    @JsonProperty("ActivityType")
    @NotNull
    private Short activityType;

    @JsonProperty("FieldActivityID")
    @NotNull
    private Short fieldActivityId;

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPiece() {
        return this.piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

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

    public Short getRework() {
        return this.rework;
    }

    public void setRework(Short rework) {
        this.rework = rework;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
    }

    public Short getFieldActivityId() {
        return this.fieldActivityId;
    }

    public void setFieldActivityId(Short fieldActivityId) {
        this.fieldActivityId = fieldActivityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateSteelFaRequest)) return false;
        final UpdateSteelFaRequest updateSteelFaRequest = (UpdateSteelFaRequest) o;
        return Objects.equals(getArea(), updateSteelFaRequest.getArea()) &&
                Objects.equals(getPiece(), updateSteelFaRequest.getPiece()) &&
                Objects.equals(getQuantity(), updateSteelFaRequest.getQuantity()) &&
                Objects.equals(getPercent(), updateSteelFaRequest.getPercent()) &&
                Objects.equals(getRework(), updateSteelFaRequest.getRework()) &&
                Objects.equals(getNotes(), updateSteelFaRequest.getNotes()) &&
                Objects.equals(getActivityType(), updateSteelFaRequest.getActivityType()) &&
                Objects.equals(getFieldActivityId(), updateSteelFaRequest.getFieldActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArea(),
                getPiece(),
                getQuantity(),
                getPercent(),
                getRework(),
                getNotes(),
                getActivityType(),
                getFieldActivityId());
    }
}