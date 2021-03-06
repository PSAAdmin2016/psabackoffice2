/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetActivityHistorySteelMiscResponse implements Serializable {


    @JsonProperty("Description")
    @ColumnAlias("Description")
    private String description;

    @JsonProperty("PieceMark")
    @ColumnAlias("PieceMark")
    private String pieceMark;

    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;

    @JsonProperty("MiscBidID")
    @ColumnAlias("MiscBidID")
    private Integer miscBidId;

    @JsonProperty("MiscPercentCompleted")
    @ColumnAlias("MiscPercentCompleted")
    private Float miscPercentCompleted;

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPieceMark() {
        return this.pieceMark;
    }

    public void setPieceMark(String pieceMark) {
        this.pieceMark = pieceMark;
    }

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getMiscBidId() {
        return this.miscBidId;
    }

    public void setMiscBidId(Integer miscBidId) {
        this.miscBidId = miscBidId;
    }

    public Float getMiscPercentCompleted() {
        return this.miscPercentCompleted;
    }

    public void setMiscPercentCompleted(Float miscPercentCompleted) {
        this.miscPercentCompleted = miscPercentCompleted;
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
        return Objects.equals(getDescription(), getActivityHistorySteelMiscResponse.getDescription()) &&
                Objects.equals(getPieceMark(), getActivityHistorySteelMiscResponse.getPieceMark()) &&
                Objects.equals(getActivityId(), getActivityHistorySteelMiscResponse.getActivityId()) &&
                Objects.equals(getMiscBidId(), getActivityHistorySteelMiscResponse.getMiscBidId()) &&
                Objects.equals(getMiscPercentCompleted(), getActivityHistorySteelMiscResponse.getMiscPercentCompleted()) &&
                Objects.equals(getMiscRework(), getActivityHistorySteelMiscResponse.getMiscRework()) &&
                Objects.equals(getMiscNotes(), getActivityHistorySteelMiscResponse.getMiscNotes()) &&
                Objects.equals(getActivityType(), getActivityHistorySteelMiscResponse.getActivityType()) &&
                Objects.equals(getMiscTimeInForm(), getActivityHistorySteelMiscResponse.getMiscTimeInForm()) &&
                Objects.equals(getRev(), getActivityHistorySteelMiscResponse.getRev()) &&
                Objects.equals(getTimeStamp(), getActivityHistorySteelMiscResponse.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(),
                getPieceMark(),
                getActivityId(),
                getMiscBidId(),
                getMiscPercentCompleted(),
                getMiscRework(),
                getMiscNotes(),
                getActivityType(),
                getMiscTimeInForm(),
                getRev(),
                getTimeStamp());
    }
}
