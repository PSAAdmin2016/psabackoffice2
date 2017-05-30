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

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetActivityHistoryMiscResponse implements Serializable {

    @JsonProperty("MiscDrawingNumber")
    @ColumnAlias("MiscDrawingNumber")
    private String miscDrawingNumber;
    @JsonProperty("TimeStamp")
    @ColumnAlias("TimeStamp")
    private Timestamp timeStamp;
    @JsonProperty("MiscLineNumber")
    @ColumnAlias("MiscLineNumber")
    private String miscLineNumber;
    @JsonProperty("MiscQuantity")
    @ColumnAlias("MiscQuantity")
    private Byte miscQuantity;
    @JsonProperty("ID")
    @ColumnAlias("ID")
    private Integer id;
    @JsonProperty("MiscRework")
    @ColumnAlias("MiscRework")
    private Byte miscRework;
    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private Byte activityType;
    @JsonProperty("fk_SubmissionId")
    @ColumnAlias("fk_SubmissionId")
    private Integer fkSubmissionId;
    @JsonProperty("MiscTimeInForm")
    @ColumnAlias("MiscTimeInForm")
    private Short miscTimeInForm;
    @JsonProperty("MiscSheetNumber")
    @ColumnAlias("MiscSheetNumber")
    private String miscSheetNumber;
    @JsonProperty("MiscNotes")
    @ColumnAlias("MiscNotes")
    private String miscNotes;
    @JsonProperty("Rev")
    @ColumnAlias("Rev")
    private Byte rev;

    public String getMiscDrawingNumber() {
        return this.miscDrawingNumber;
    }

    public void setMiscDrawingNumber(String miscDrawingNumber) {
        this.miscDrawingNumber = miscDrawingNumber;
    }

    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMiscLineNumber() {
        return this.miscLineNumber;
    }

    public void setMiscLineNumber(String miscLineNumber) {
        this.miscLineNumber = miscLineNumber;
    }

    public Byte getMiscQuantity() {
        return this.miscQuantity;
    }

    public void setMiscQuantity(Byte miscQuantity) {
        this.miscQuantity = miscQuantity;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getMiscRework() {
        return this.miscRework;
    }

    public void setMiscRework(Byte miscRework) {
        this.miscRework = miscRework;
    }

    public Byte getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Byte activityType) {
        this.activityType = activityType;
    }

    public Integer getFkSubmissionId() {
        return this.fkSubmissionId;
    }

    public void setFkSubmissionId(Integer fkSubmissionId) {
        this.fkSubmissionId = fkSubmissionId;
    }

    public Short getMiscTimeInForm() {
        return this.miscTimeInForm;
    }

    public void setMiscTimeInForm(Short miscTimeInForm) {
        this.miscTimeInForm = miscTimeInForm;
    }

    public String getMiscSheetNumber() {
        return this.miscSheetNumber;
    }

    public void setMiscSheetNumber(String miscSheetNumber) {
        this.miscSheetNumber = miscSheetNumber;
    }

    public String getMiscNotes() {
        return this.miscNotes;
    }

    public void setMiscNotes(String miscNotes) {
        this.miscNotes = miscNotes;
    }

    public Byte getRev() {
        return this.rev;
    }

    public void setRev(Byte rev) {
        this.rev = rev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetActivityHistoryMiscResponse)) return false;
        final GetActivityHistoryMiscResponse getActivityHistoryMiscResponse = (GetActivityHistoryMiscResponse) o;
        return Objects.equals(getMiscDrawingNumber(), getActivityHistoryMiscResponse.getMiscDrawingNumber()) &&
                Objects.equals(getTimeStamp(), getActivityHistoryMiscResponse.getTimeStamp()) &&
                Objects.equals(getMiscLineNumber(), getActivityHistoryMiscResponse.getMiscLineNumber()) &&
                Objects.equals(getMiscQuantity(), getActivityHistoryMiscResponse.getMiscQuantity()) &&
                Objects.equals(getId(), getActivityHistoryMiscResponse.getId()) &&
                Objects.equals(getMiscRework(), getActivityHistoryMiscResponse.getMiscRework()) &&
                Objects.equals(getActivityType(), getActivityHistoryMiscResponse.getActivityType()) &&
                Objects.equals(getFkSubmissionId(), getActivityHistoryMiscResponse.getFkSubmissionId()) &&
                Objects.equals(getMiscTimeInForm(), getActivityHistoryMiscResponse.getMiscTimeInForm()) &&
                Objects.equals(getMiscSheetNumber(), getActivityHistoryMiscResponse.getMiscSheetNumber()) &&
                Objects.equals(getMiscNotes(), getActivityHistoryMiscResponse.getMiscNotes()) &&
                Objects.equals(getRev(), getActivityHistoryMiscResponse.getRev());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMiscDrawingNumber(),
                getTimeStamp(),
                getMiscLineNumber(),
                getMiscQuantity(),
                getId(),
                getMiscRework(),
                getActivityType(),
                getFkSubmissionId(),
                getMiscTimeInForm(),
                getMiscSheetNumber(),
                getMiscNotes(),
                getRev());
    }
}
