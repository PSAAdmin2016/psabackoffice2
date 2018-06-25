/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetActivityHistoryPipeMiscResponse implements Serializable {


    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;

    @JsonProperty("MiscDrawingNumber")
    @ColumnAlias("MiscDrawingNumber")
    private String miscDrawingNumber;

    @JsonProperty("MiscLineNumber")
    @ColumnAlias("MiscLineNumber")
    private String miscLineNumber;

    @JsonProperty("MiscSheetNumber")
    @ColumnAlias("MiscSheetNumber")
    private String miscSheetNumber;

    @JsonProperty("MiscTimeInForm")
    @ColumnAlias("MiscTimeInForm")
    private Integer miscTimeInForm;

    @JsonProperty("MiscQuantity")
    @ColumnAlias("MiscQuantity")
    private BigDecimal miscQuantity;

    @JsonProperty("MiscRework")
    @ColumnAlias("MiscRework")
    private Short miscRework;

    @JsonProperty("MiscNotes")
    @ColumnAlias("MiscNotes")
    private String miscNotes;

    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private Short activityType;

    @JsonProperty("Rev")
    @ColumnAlias("Rev")
    private Short rev;

    @JsonProperty("TimeStamp")
    @ColumnAlias("TimeStamp")
    private Timestamp timeStamp;

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getMiscDrawingNumber() {
        return this.miscDrawingNumber;
    }

    public void setMiscDrawingNumber(String miscDrawingNumber) {
        this.miscDrawingNumber = miscDrawingNumber;
    }

    public String getMiscLineNumber() {
        return this.miscLineNumber;
    }

    public void setMiscLineNumber(String miscLineNumber) {
        this.miscLineNumber = miscLineNumber;
    }

    public String getMiscSheetNumber() {
        return this.miscSheetNumber;
    }

    public void setMiscSheetNumber(String miscSheetNumber) {
        this.miscSheetNumber = miscSheetNumber;
    }

    public Integer getMiscTimeInForm() {
        return this.miscTimeInForm;
    }

    public void setMiscTimeInForm(Integer miscTimeInForm) {
        this.miscTimeInForm = miscTimeInForm;
    }

    public BigDecimal getMiscQuantity() {
        return this.miscQuantity;
    }

    public void setMiscQuantity(BigDecimal miscQuantity) {
        this.miscQuantity = miscQuantity;
    }

    public Short getMiscRework() {
        return this.miscRework;
    }

    public void setMiscRework(Short miscRework) {
        this.miscRework = miscRework;
    }

    public String getMiscNotes() {
        return this.miscNotes;
    }

    public void setMiscNotes(String miscNotes) {
        this.miscNotes = miscNotes;
    }

    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
    }

    public Short getRev() {
        return this.rev;
    }

    public void setRev(Short rev) {
        this.rev = rev;
    }

    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetActivityHistoryPipeMiscResponse)) return false;
        final GetActivityHistoryPipeMiscResponse getActivityHistoryPipeMiscResponse = (GetActivityHistoryPipeMiscResponse) o;
        return Objects.equals(getActivityId(), getActivityHistoryPipeMiscResponse.getActivityId()) &&
                Objects.equals(getMiscDrawingNumber(), getActivityHistoryPipeMiscResponse.getMiscDrawingNumber()) &&
                Objects.equals(getMiscLineNumber(), getActivityHistoryPipeMiscResponse.getMiscLineNumber()) &&
                Objects.equals(getMiscSheetNumber(), getActivityHistoryPipeMiscResponse.getMiscSheetNumber()) &&
                Objects.equals(getMiscTimeInForm(), getActivityHistoryPipeMiscResponse.getMiscTimeInForm()) &&
                Objects.equals(getMiscQuantity(), getActivityHistoryPipeMiscResponse.getMiscQuantity()) &&
                Objects.equals(getMiscRework(), getActivityHistoryPipeMiscResponse.getMiscRework()) &&
                Objects.equals(getMiscNotes(), getActivityHistoryPipeMiscResponse.getMiscNotes()) &&
                Objects.equals(getActivityType(), getActivityHistoryPipeMiscResponse.getActivityType()) &&
                Objects.equals(getRev(), getActivityHistoryPipeMiscResponse.getRev()) &&
                Objects.equals(getTimeStamp(), getActivityHistoryPipeMiscResponse.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(),
                getMiscDrawingNumber(),
                getMiscLineNumber(),
                getMiscSheetNumber(),
                getMiscTimeInForm(),
                getMiscQuantity(),
                getMiscRework(),
                getMiscNotes(),
                getActivityType(),
                getRev(),
                getTimeStamp());
    }
}
