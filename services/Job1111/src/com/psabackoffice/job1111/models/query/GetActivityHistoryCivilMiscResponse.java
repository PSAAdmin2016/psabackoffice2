/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetActivityHistoryCivilMiscResponse implements Serializable {


    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;

    @JsonProperty("MiscFoundation")
    @ColumnAlias("MiscFoundation")
    private String miscFoundation;

    @JsonProperty("MiscDrawingNumber")
    @ColumnAlias("MiscDrawingNumber")
    private String miscDrawingNumber;

    @JsonProperty("MiscDetailDrawingNumber")
    @ColumnAlias("MiscDetailDrawingNumber")
    private String miscDetailDrawingNumber;

    @JsonProperty("MiscPercentComplete")
    @ColumnAlias("MiscPercentComplete")
    private Float miscPercentComplete;

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
    private Short miscTimeInForm;

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

    public String getMiscFoundation() {
        return this.miscFoundation;
    }

    public void setMiscFoundation(String miscFoundation) {
        this.miscFoundation = miscFoundation;
    }

    public String getMiscDrawingNumber() {
        return this.miscDrawingNumber;
    }

    public void setMiscDrawingNumber(String miscDrawingNumber) {
        this.miscDrawingNumber = miscDrawingNumber;
    }

    public String getMiscDetailDrawingNumber() {
        return this.miscDetailDrawingNumber;
    }

    public void setMiscDetailDrawingNumber(String miscDetailDrawingNumber) {
        this.miscDetailDrawingNumber = miscDetailDrawingNumber;
    }

    public Float getMiscPercentComplete() {
        return this.miscPercentComplete;
    }

    public void setMiscPercentComplete(Float miscPercentComplete) {
        this.miscPercentComplete = miscPercentComplete;
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

    public Short getMiscTimeInForm() {
        return this.miscTimeInForm;
    }

    public void setMiscTimeInForm(Short miscTimeInForm) {
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
        if (!(o instanceof GetActivityHistoryCivilMiscResponse)) return false;
        final GetActivityHistoryCivilMiscResponse getActivityHistoryCivilMiscResponse = (GetActivityHistoryCivilMiscResponse) o;
        return Objects.equals(getActivityId(), getActivityHistoryCivilMiscResponse.getActivityId()) &&
                Objects.equals(getMiscFoundation(), getActivityHistoryCivilMiscResponse.getMiscFoundation()) &&
                Objects.equals(getMiscDrawingNumber(), getActivityHistoryCivilMiscResponse.getMiscDrawingNumber()) &&
                Objects.equals(getMiscDetailDrawingNumber(), getActivityHistoryCivilMiscResponse.getMiscDetailDrawingNumber()) &&
                Objects.equals(getMiscPercentComplete(), getActivityHistoryCivilMiscResponse.getMiscPercentComplete()) &&
                Objects.equals(getMiscRework(), getActivityHistoryCivilMiscResponse.getMiscRework()) &&
                Objects.equals(getMiscNotes(), getActivityHistoryCivilMiscResponse.getMiscNotes()) &&
                Objects.equals(getActivityType(), getActivityHistoryCivilMiscResponse.getActivityType()) &&
                Objects.equals(getMiscTimeInForm(), getActivityHistoryCivilMiscResponse.getMiscTimeInForm()) &&
                Objects.equals(getRev(), getActivityHistoryCivilMiscResponse.getRev()) &&
                Objects.equals(getTimeStamp(), getActivityHistoryCivilMiscResponse.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(),
                getMiscFoundation(),
                getMiscDrawingNumber(),
                getMiscDetailDrawingNumber(),
                getMiscPercentComplete(),
                getMiscRework(),
                getMiscNotes(),
                getActivityType(),
                getMiscTimeInForm(),
                getRev(),
                getTimeStamp());
    }
}
