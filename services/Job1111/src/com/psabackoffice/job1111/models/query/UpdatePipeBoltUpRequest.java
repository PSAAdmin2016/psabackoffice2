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

public class UpdatePipeBoltUpRequest implements Serializable {

    @JsonProperty("Spool1")
    private String spool1;
    @JsonProperty("Spool2")
    private String spool2;
    @JsonProperty("DrawingNumber")
    private String drawingNumber;
    @JsonProperty("LineNumber")
    private String lineNumber;
    @JsonProperty("SheetNumber")
    private String sheetNumber;
    @JsonProperty("Size")
    private BigDecimal size;
    @JsonProperty("Quantity")
    private Integer quantity;
    @JsonProperty("Rework")
    private Integer rework;
    @JsonProperty("Notes")
    private String notes;
    @NotNull
    @JsonProperty("FieldActivityID")
    private Integer fieldActivityId;

    public String getSpool1() {
        return this.spool1;
    }

    public void setSpool1(String spool1) {
        this.spool1 = spool1;
    }

    public String getSpool2() {
        return this.spool2;
    }

    public void setSpool2(String spool2) {
        this.spool2 = spool2;
    }

    public String getDrawingNumber() {
        return this.drawingNumber;
    }

    public void setDrawingNumber(String drawingNumber) {
        this.drawingNumber = drawingNumber;
    }

    public String getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getSheetNumber() {
        return this.sheetNumber;
    }

    public void setSheetNumber(String sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    public BigDecimal getSize() {
        return this.size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Integer getFieldActivityId() {
        return this.fieldActivityId;
    }

    public void setFieldActivityId(Integer fieldActivityId) {
        this.fieldActivityId = fieldActivityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdatePipeBoltUpRequest)) return false;
        final UpdatePipeBoltUpRequest updatePipeBoltUpRequest = (UpdatePipeBoltUpRequest) o;
        return Objects.equals(getSpool1(), updatePipeBoltUpRequest.getSpool1()) &&
                Objects.equals(getSpool2(), updatePipeBoltUpRequest.getSpool2()) &&
                Objects.equals(getDrawingNumber(), updatePipeBoltUpRequest.getDrawingNumber()) &&
                Objects.equals(getLineNumber(), updatePipeBoltUpRequest.getLineNumber()) &&
                Objects.equals(getSheetNumber(), updatePipeBoltUpRequest.getSheetNumber()) &&
                Objects.equals(getSize(), updatePipeBoltUpRequest.getSize()) &&
                Objects.equals(getQuantity(), updatePipeBoltUpRequest.getQuantity()) &&
                Objects.equals(getRework(), updatePipeBoltUpRequest.getRework()) &&
                Objects.equals(getNotes(), updatePipeBoltUpRequest.getNotes()) &&
                Objects.equals(getFieldActivityId(), updatePipeBoltUpRequest.getFieldActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpool1(),
                getSpool2(),
                getDrawingNumber(),
                getLineNumber(),
                getSheetNumber(),
                getSize(),
                getQuantity(),
                getRework(),
                getNotes(),
                getFieldActivityId());
    }
}