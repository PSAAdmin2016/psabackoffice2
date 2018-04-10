/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetReportDprpipeResponse implements Serializable {


    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;

    @JsonProperty("ActivityTypeID")
    @ColumnAlias("ActivityTypeID")
    private Short activityTypeId;

    @JsonProperty("ActivityTypeName")
    @ColumnAlias("ActivityTypeName")
    private String activityTypeName;

    @JsonProperty("DrawingNumber")
    @ColumnAlias("DrawingNumber")
    private String drawingNumber;

    @JsonProperty("SheetNumber")
    @ColumnAlias("SheetNumber")
    private String sheetNumber;

    @JsonProperty("Spool1")
    @ColumnAlias("Spool1")
    private String spool1;

    @JsonProperty("Spool2")
    @ColumnAlias("Spool2")
    private String spool2;

    @JsonProperty("Size")
    @ColumnAlias("Size")
    private Float size;

    @JsonProperty("QuantityInstalled")
    @ColumnAlias("QuantityInstalled")
    private Double quantityInstalled;

    @JsonProperty("CurrentStatus")
    @ColumnAlias("CurrentStatus")
    private String currentStatus;

    @JsonProperty("Notes")
    @ColumnAlias("Notes")
    private String notes;

    @JsonProperty("Rework")
    @ColumnAlias("Rework")
    private Short rework;

    @JsonProperty("DateSubmitted")
    @ColumnAlias("DateSubmitted")
    private Date dateSubmitted;

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Short getActivityTypeId() {
        return this.activityTypeId;
    }

    public void setActivityTypeId(Short activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityTypeName() {
        return this.activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public String getDrawingNumber() {
        return this.drawingNumber;
    }

    public void setDrawingNumber(String drawingNumber) {
        this.drawingNumber = drawingNumber;
    }

    public String getSheetNumber() {
        return this.sheetNumber;
    }

    public void setSheetNumber(String sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

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

    public Float getSize() {
        return this.size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public Double getQuantityInstalled() {
        return this.quantityInstalled;
    }

    public void setQuantityInstalled(Double quantityInstalled) {
        this.quantityInstalled = quantityInstalled;
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Short getRework() {
        return this.rework;
    }

    public void setRework(Short rework) {
        this.rework = rework;
    }

    public Date getDateSubmitted() {
        return this.dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetReportDprpipeResponse)) return false;
        final GetReportDprpipeResponse getReportDprpipeResponse = (GetReportDprpipeResponse) o;
        return Objects.equals(getActivityId(), getReportDprpipeResponse.getActivityId()) &&
                Objects.equals(getActivityTypeId(), getReportDprpipeResponse.getActivityTypeId()) &&
                Objects.equals(getActivityTypeName(), getReportDprpipeResponse.getActivityTypeName()) &&
                Objects.equals(getDrawingNumber(), getReportDprpipeResponse.getDrawingNumber()) &&
                Objects.equals(getSheetNumber(), getReportDprpipeResponse.getSheetNumber()) &&
                Objects.equals(getSpool1(), getReportDprpipeResponse.getSpool1()) &&
                Objects.equals(getSpool2(), getReportDprpipeResponse.getSpool2()) &&
                Objects.equals(getSize(), getReportDprpipeResponse.getSize()) &&
                Objects.equals(getQuantityInstalled(), getReportDprpipeResponse.getQuantityInstalled()) &&
                Objects.equals(getCurrentStatus(), getReportDprpipeResponse.getCurrentStatus()) &&
                Objects.equals(getNotes(), getReportDprpipeResponse.getNotes()) &&
                Objects.equals(getRework(), getReportDprpipeResponse.getRework()) &&
                Objects.equals(getDateSubmitted(), getReportDprpipeResponse.getDateSubmitted());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(),
                getActivityTypeId(),
                getActivityTypeName(),
                getDrawingNumber(),
                getSheetNumber(),
                getSpool1(),
                getSpool2(),
                getSize(),
                getQuantityInstalled(),
                getCurrentStatus(),
                getNotes(),
                getRework(),
                getDateSubmitted());
    }
}
