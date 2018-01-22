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

public class UpdatePipeWeldRequest implements Serializable {


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

    @JsonProperty("LineSpec")
    private String lineSpec;

    @JsonProperty("WeldNumber")
    private String weldNumber;

    @JsonProperty("Stencil")
    private String stencil;

    @JsonProperty("Size")
    private BigDecimal size;

    @JsonProperty("Thickness")
    private String thickness;

    @JsonProperty("WeldType")
    private String weldType;

    @JsonProperty("WeldPosition")
    private String weldPosition;

    @JsonProperty("Material")
    private String material;

    @JsonProperty("Procedure")
    private String procedure;

    @JsonProperty("Complete")
    private Byte complete;

    @JsonProperty("Shared")
    private Byte shared;

    @JsonProperty("PercentComplete")
    private BigInteger percentComplete;

    @JsonProperty("Rework")
    private Byte rework;

    @JsonProperty("Notes")
    private String notes;

    @JsonProperty("FieldActivityID")
    @NotNull
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

    public String getLineSpec() {
        return this.lineSpec;
    }

    public void setLineSpec(String lineSpec) {
        this.lineSpec = lineSpec;
    }

    public String getWeldNumber() {
        return this.weldNumber;
    }

    public void setWeldNumber(String weldNumber) {
        this.weldNumber = weldNumber;
    }

    public String getStencil() {
        return this.stencil;
    }

    public void setStencil(String stencil) {
        this.stencil = stencil;
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

    public String getWeldType() {
        return this.weldType;
    }

    public void setWeldType(String weldType) {
        this.weldType = weldType;
    }

    public String getWeldPosition() {
        return this.weldPosition;
    }

    public void setWeldPosition(String weldPosition) {
        this.weldPosition = weldPosition;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getProcedure() {
        return this.procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public Byte getComplete() {
        return this.complete;
    }

    public void setComplete(Byte complete) {
        this.complete = complete;
    }

    public Byte getShared() {
        return this.shared;
    }

    public void setShared(Byte shared) {
        this.shared = shared;
    }

    public BigInteger getPercentComplete() {
        return this.percentComplete;
    }

    public void setPercentComplete(BigInteger percentComplete) {
        this.percentComplete = percentComplete;
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
        if (!(o instanceof UpdatePipeWeldRequest)) return false;
        final UpdatePipeWeldRequest updatePipeWeldRequest = (UpdatePipeWeldRequest) o;
        return Objects.equals(getSpool1(), updatePipeWeldRequest.getSpool1()) &&
                Objects.equals(getSpool2(), updatePipeWeldRequest.getSpool2()) &&
                Objects.equals(getDrawingNumber(), updatePipeWeldRequest.getDrawingNumber()) &&
                Objects.equals(getLineNumber(), updatePipeWeldRequest.getLineNumber()) &&
                Objects.equals(getSheetNumber(), updatePipeWeldRequest.getSheetNumber()) &&
                Objects.equals(getLineSpec(), updatePipeWeldRequest.getLineSpec()) &&
                Objects.equals(getWeldNumber(), updatePipeWeldRequest.getWeldNumber()) &&
                Objects.equals(getStencil(), updatePipeWeldRequest.getStencil()) &&
                Objects.equals(getSize(), updatePipeWeldRequest.getSize()) &&
                Objects.equals(getThickness(), updatePipeWeldRequest.getThickness()) &&
                Objects.equals(getWeldType(), updatePipeWeldRequest.getWeldType()) &&
                Objects.equals(getWeldPosition(), updatePipeWeldRequest.getWeldPosition()) &&
                Objects.equals(getMaterial(), updatePipeWeldRequest.getMaterial()) &&
                Objects.equals(getProcedure(), updatePipeWeldRequest.getProcedure()) &&
                Objects.equals(getComplete(), updatePipeWeldRequest.getComplete()) &&
                Objects.equals(getShared(), updatePipeWeldRequest.getShared()) &&
                Objects.equals(getPercentComplete(), updatePipeWeldRequest.getPercentComplete()) &&
                Objects.equals(getRework(), updatePipeWeldRequest.getRework()) &&
                Objects.equals(getNotes(), updatePipeWeldRequest.getNotes()) &&
                Objects.equals(getFieldActivityId(), updatePipeWeldRequest.getFieldActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpool1(),
                getSpool2(),
                getDrawingNumber(),
                getLineNumber(),
                getSheetNumber(),
                getLineSpec(),
                getWeldNumber(),
                getStencil(),
                getSize(),
                getThickness(),
                getWeldType(),
                getWeldPosition(),
                getMaterial(),
                getProcedure(),
                getComplete(),
                getShared(),
                getPercentComplete(),
                getRework(),
                getNotes(),
                getFieldActivityId());
    }
}
