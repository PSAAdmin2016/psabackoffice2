/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateTrimRequest implements Serializable {

    @JsonProperty("Size")
    private BigDecimal size;
    @JsonProperty("PlugQuantity")
    private Integer plugQuantity;
    @JsonProperty("HandleType")
    private String handleType;
    @JsonProperty("InstType")
    private String instType;
    @JsonProperty("DrawingNumber")
    private String drawingNumber;
    @JsonProperty("LineNumber")
    private String lineNumber;
    @JsonProperty("SheetNumber")
    private String sheetNumber;
    @JsonProperty("Rework")
    private Integer rework;
    @JsonProperty("Notes")
    private String notes;
    @JsonProperty("RowId")
    private Integer rowId;

    public BigDecimal getSize() {
        return this.size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public Integer getPlugQuantity() {
        return this.plugQuantity;
    }

    public void setPlugQuantity(Integer plugQuantity) {
        this.plugQuantity = plugQuantity;
    }

    public String getHandleType() {
        return this.handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getInstType() {
        return this.instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
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

    public Integer getRowId() {
        return this.rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateTrimRequest)) return false;
        final UpdateTrimRequest updateTrimRequest = (UpdateTrimRequest) o;
        return Objects.equals(getSize(), updateTrimRequest.getSize()) &&
                Objects.equals(getPlugQuantity(), updateTrimRequest.getPlugQuantity()) &&
                Objects.equals(getHandleType(), updateTrimRequest.getHandleType()) &&
                Objects.equals(getInstType(), updateTrimRequest.getInstType()) &&
                Objects.equals(getDrawingNumber(), updateTrimRequest.getDrawingNumber()) &&
                Objects.equals(getLineNumber(), updateTrimRequest.getLineNumber()) &&
                Objects.equals(getSheetNumber(), updateTrimRequest.getSheetNumber()) &&
                Objects.equals(getRework(), updateTrimRequest.getRework()) &&
                Objects.equals(getNotes(), updateTrimRequest.getNotes()) &&
                Objects.equals(getRowId(), updateTrimRequest.getRowId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSize(),
                getPlugQuantity(),
                getHandleType(),
                getInstType(),
                getDrawingNumber(),
                getLineNumber(),
                getSheetNumber(),
                getRework(),
                getNotes(),
                getRowId());
    }
}
