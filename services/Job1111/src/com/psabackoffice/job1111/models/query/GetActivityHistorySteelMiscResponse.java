/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetActivityHistorySteelMiscResponse implements Serializable {

    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;
    @JsonProperty("MiscArea")
    @ColumnAlias("MiscArea")
    private String miscArea;
    @JsonProperty("MiscPieceNumber")
    @ColumnAlias("MiscPieceNumber")
    private String miscPieceNumber;
    @JsonProperty("MiscQuantity")
    @ColumnAlias("MiscQuantity")
    private Short miscQuantity;
    @JsonProperty("MiscRework")
    @ColumnAlias("MiscRework")
    private Short miscRework;
    @JsonProperty("MiscNotes")
    @ColumnAlias("MiscNotes")
    private String miscNotes;
    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private Short activityType;
    @JsonProperty("MiscTimeInForm")
    @ColumnAlias("MiscTimeInForm")
    private Integer miscTimeInForm;
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

    public String getMiscArea() {
        return this.miscArea;
    }

    public void setMiscArea(String miscArea) {
        this.miscArea = miscArea;
    }

    public String getMiscPieceNumber() {
        return this.miscPieceNumber;
    }

    public void setMiscPieceNumber(String miscPieceNumber) {
        this.miscPieceNumber = miscPieceNumber;
    }

    public Short getMiscQuantity() {
        return this.miscQuantity;
    }

    public void setMiscQuantity(Short miscQuantity) {
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

    public Integer getMiscTimeInForm() {
        return this.miscTimeInForm;
    }

    public void setMiscTimeInForm(Integer miscTimeInForm) {
        this.miscTimeInForm = miscTimeInForm;
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
        if (!(o instanceof GetActivityHistorySteelMiscResponse)) return false;
        final GetActivityHistorySteelMiscResponse getActivityHistorySteelMiscResponse = (GetActivityHistorySteelMiscResponse) o;
        return Objects.equals(getActivityId(), getActivityHistorySteelMiscResponse.getActivityId()) &&
                Objects.equals(getMiscArea(), getActivityHistorySteelMiscResponse.getMiscArea()) &&
                Objects.equals(getMiscPieceNumber(), getActivityHistorySteelMiscResponse.getMiscPieceNumber()) &&
                Objects.equals(getMiscQuantity(), getActivityHistorySteelMiscResponse.getMiscQuantity()) &&
                Objects.equals(getMiscRework(), getActivityHistorySteelMiscResponse.getMiscRework()) &&
                Objects.equals(getMiscNotes(), getActivityHistorySteelMiscResponse.getMiscNotes()) &&
                Objects.equals(getActivityType(), getActivityHistorySteelMiscResponse.getActivityType()) &&
                Objects.equals(getMiscTimeInForm(), getActivityHistorySteelMiscResponse.getMiscTimeInForm()) &&
                Objects.equals(getRev(), getActivityHistorySteelMiscResponse.getRev()) &&
                Objects.equals(getTimeStamp(), getActivityHistorySteelMiscResponse.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(),
                getMiscArea(),
                getMiscPieceNumber(),
                getMiscQuantity(),
                getMiscRework(),
                getMiscNotes(),
                getActivityType(),
                getMiscTimeInForm(),
                getRev(),
                getTimeStamp());
    }
}
