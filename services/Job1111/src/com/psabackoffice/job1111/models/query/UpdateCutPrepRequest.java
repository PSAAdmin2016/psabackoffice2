/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCutPrepRequest implements Serializable {

    @JsonProperty("DrawingNumber")
    private String drawingNumber;
    @JsonProperty("LineNumber")
    private String lineNumber;
    @JsonProperty("SheetNumber")
    private String sheetNumber;
    @JsonProperty("Size")
    private BigDecimal size;
    @JsonProperty("Thickness")
    private String thickness;
    @JsonProperty("Rework")
    private Integer rework;
    @JsonProperty("Notes")
    private String notes;
    @JsonProperty("RowID")
    private Integer rowId;

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

    public String getThickness() {
        return this.thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
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
        if (!(o instanceof UpdateCutPrepRequest)) return false;
        final UpdateCutPrepRequest updateCutPrepRequest = (UpdateCutPrepRequest) o;
        return Objects.equals(getDrawingNumber(), updateCutPrepRequest.getDrawingNumber()) &&
                Objects.equals(getLineNumber(), updateCutPrepRequest.getLineNumber()) &&
                Objects.equals(getSheetNumber(), updateCutPrepRequest.getSheetNumber()) &&
                Objects.equals(getSize(), updateCutPrepRequest.getSize()) &&
                Objects.equals(getThickness(), updateCutPrepRequest.getThickness()) &&
                Objects.equals(getRework(), updateCutPrepRequest.getRework()) &&
                Objects.equals(getNotes(), updateCutPrepRequest.getNotes()) &&
                Objects.equals(getRowId(), updateCutPrepRequest.getRowId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrawingNumber(),
                getLineNumber(),
                getSheetNumber(),
                getSize(),
                getThickness(),
                getRework(),
                getNotes(),
                getRowId());
    }
}
