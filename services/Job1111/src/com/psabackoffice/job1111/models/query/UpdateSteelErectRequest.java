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

public class UpdateSteelErectRequest implements Serializable {

    @JsonProperty("Area")
    private String area;
    @JsonProperty("Piece")
    private String piece;
    @JsonProperty("Quantity")
    private Integer quantity;
    @JsonProperty("Percent")
    private BigDecimal percent;
    @JsonProperty("Rework")
    private Byte rework;
    @JsonProperty("Notes")
    private String notes;
    @NotNull
    @JsonProperty("FieldActivityID")
    private Integer fieldActivityId;

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

    public Byte getRework() {
        return this.rework;
    }

    public void setRework(Byte rework) {
        this.rework = rework;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getFieldActivityId() {
        return this.fieldActivityId;
    }

    public void setFieldActivityId(Integer fieldActivityId) {
        this.fieldActivityId = fieldActivityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateSteelErectRequest)) return false;
        final UpdateSteelErectRequest updateSteelErectRequest = (UpdateSteelErectRequest) o;
        return Objects.equals(getArea(), updateSteelErectRequest.getArea()) &&
                Objects.equals(getPiece(), updateSteelErectRequest.getPiece()) &&
                Objects.equals(getQuantity(), updateSteelErectRequest.getQuantity()) &&
                Objects.equals(getPercent(), updateSteelErectRequest.getPercent()) &&
                Objects.equals(getRework(), updateSteelErectRequest.getRework()) &&
                Objects.equals(getNotes(), updateSteelErectRequest.getNotes()) &&
                Objects.equals(getFieldActivityId(), updateSteelErectRequest.getFieldActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArea(),
                getPiece(),
                getQuantity(),
                getPercent(),
                getRework(),
                getNotes(),
                getFieldActivityId());
    }
}
