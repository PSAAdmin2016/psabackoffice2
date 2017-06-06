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

public class GetActivityHistoryPipeWeldResponse implements Serializable {

    @JsonProperty("ID")
    @ColumnAlias("ID")
    private Integer id;
    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;
    @JsonProperty("WeldSpool1")
    @ColumnAlias("WeldSpool1")
    private String weldSpool1;
    @JsonProperty("WeldSpool2")
    @ColumnAlias("WeldSpool2")
    private String weldSpool2;
    @JsonProperty("WeldDrawingNumber")
    @ColumnAlias("WeldDrawingNumber")
    private String weldDrawingNumber;
    @JsonProperty("WeldLineNumber")
    @ColumnAlias("WeldLineNumber")
    private String weldLineNumber;
    @JsonProperty("WeldSheetNumber")
    @ColumnAlias("WeldSheetNumber")
    private String weldSheetNumber;
    @JsonProperty("WeldTimeInForm")
    @ColumnAlias("WeldTimeInForm")
    private Integer weldTimeInForm;
    @JsonProperty("WeldLineSpec")
    @ColumnAlias("WeldLineSpec")
    private String weldLineSpec;
    @JsonProperty("WeldNumber")
    @ColumnAlias("WeldNumber")
    private String weldNumber;
    @JsonProperty("WeldStencil")
    @ColumnAlias("WeldStencil")
    private String weldStencil;
    @JsonProperty("WeldSize")
    @ColumnAlias("WeldSize")
    private Float weldSize;
    @JsonProperty("WeldThickness")
    @ColumnAlias("WeldThickness")
    private String weldThickness;
    @JsonProperty("WeldType")
    @ColumnAlias("WeldType")
    private String weldType;
    @JsonProperty("WeldPosition")
    @ColumnAlias("WeldPosition")
    private String weldPosition;
    @JsonProperty("WeldMaterial")
    @ColumnAlias("WeldMaterial")
    private String weldMaterial;
    @JsonProperty("WeldProcedure")
    @ColumnAlias("WeldProcedure")
    private String weldProcedure;
    @JsonProperty("WeldComplete")
    @ColumnAlias("WeldComplete")
    private Short weldComplete;
    @JsonProperty("WeldShared")
    @ColumnAlias("WeldShared")
    private Short weldShared;
    @JsonProperty("WeldPercentCompleteChoice")
    @ColumnAlias("WeldPercentCompleteChoice")
    private String weldPercentCompleteChoice;
    @JsonProperty("WeldPercentCompleted")
    @ColumnAlias("WeldPercentCompleted")
    private Integer weldPercentCompleted;
    @JsonProperty("WeldRework")
    @ColumnAlias("WeldRework")
    private Short weldRework;
    @JsonProperty("WeldNotes")
    @ColumnAlias("WeldNotes")
    private String weldNotes;
    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private Short activityType;
    @JsonProperty("Rev")
    @ColumnAlias("Rev")
    private Short rev;
    @JsonProperty("TimeStamp")
    @ColumnAlias("TimeStamp")
    private Timestamp timeStamp;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getWeldSpool1() {
        return this.weldSpool1;
    }

    public void setWeldSpool1(String weldSpool1) {
        this.weldSpool1 = weldSpool1;
    }

    public String getWeldSpool2() {
        return this.weldSpool2;
    }

    public void setWeldSpool2(String weldSpool2) {
        this.weldSpool2 = weldSpool2;
    }

    public String getWeldDrawingNumber() {
        return this.weldDrawingNumber;
    }

    public void setWeldDrawingNumber(String weldDrawingNumber) {
        this.weldDrawingNumber = weldDrawingNumber;
    }

    public String getWeldLineNumber() {
        return this.weldLineNumber;
    }

    public void setWeldLineNumber(String weldLineNumber) {
        this.weldLineNumber = weldLineNumber;
    }

    public String getWeldSheetNumber() {
        return this.weldSheetNumber;
    }

    public void setWeldSheetNumber(String weldSheetNumber) {
        this.weldSheetNumber = weldSheetNumber;
    }

    public Integer getWeldTimeInForm() {
        return this.weldTimeInForm;
    }

    public void setWeldTimeInForm(Integer weldTimeInForm) {
        this.weldTimeInForm = weldTimeInForm;
    }

    public String getWeldLineSpec() {
        return this.weldLineSpec;
    }

    public void setWeldLineSpec(String weldLineSpec) {
        this.weldLineSpec = weldLineSpec;
    }

    public String getWeldNumber() {
        return this.weldNumber;
    }

    public void setWeldNumber(String weldNumber) {
        this.weldNumber = weldNumber;
    }

    public String getWeldStencil() {
        return this.weldStencil;
    }

    public void setWeldStencil(String weldStencil) {
        this.weldStencil = weldStencil;
    }

    public Float getWeldSize() {
        return this.weldSize;
    }

    public void setWeldSize(Float weldSize) {
        this.weldSize = weldSize;
    }

    public String getWeldThickness() {
        return this.weldThickness;
    }

    public void setWeldThickness(String weldThickness) {
        this.weldThickness = weldThickness;
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

    public String getWeldMaterial() {
        return this.weldMaterial;
    }

    public void setWeldMaterial(String weldMaterial) {
        this.weldMaterial = weldMaterial;
    }

    public String getWeldProcedure() {
        return this.weldProcedure;
    }

    public void setWeldProcedure(String weldProcedure) {
        this.weldProcedure = weldProcedure;
    }

    public Short getWeldComplete() {
        return this.weldComplete;
    }

    public void setWeldComplete(Short weldComplete) {
        this.weldComplete = weldComplete;
    }

    public Short getWeldShared() {
        return this.weldShared;
    }

    public void setWeldShared(Short weldShared) {
        this.weldShared = weldShared;
    }

    public String getWeldPercentCompleteChoice() {
        return this.weldPercentCompleteChoice;
    }

    public void setWeldPercentCompleteChoice(String weldPercentCompleteChoice) {
        this.weldPercentCompleteChoice = weldPercentCompleteChoice;
    }

    public Integer getWeldPercentCompleted() {
        return this.weldPercentCompleted;
    }

    public void setWeldPercentCompleted(Integer weldPercentCompleted) {
        this.weldPercentCompleted = weldPercentCompleted;
    }

    public Short getWeldRework() {
        return this.weldRework;
    }

    public void setWeldRework(Short weldRework) {
        this.weldRework = weldRework;
    }

    public String getWeldNotes() {
        return this.weldNotes;
    }

    public void setWeldNotes(String weldNotes) {
        this.weldNotes = weldNotes;
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
        if (!(o instanceof GetActivityHistoryPipeWeldResponse)) return false;
        final GetActivityHistoryPipeWeldResponse getActivityHistoryPipeWeldResponse = (GetActivityHistoryPipeWeldResponse) o;
        return Objects.equals(getId(), getActivityHistoryPipeWeldResponse.getId()) &&
                Objects.equals(getActivityId(), getActivityHistoryPipeWeldResponse.getActivityId()) &&
                Objects.equals(getWeldSpool1(), getActivityHistoryPipeWeldResponse.getWeldSpool1()) &&
                Objects.equals(getWeldSpool2(), getActivityHistoryPipeWeldResponse.getWeldSpool2()) &&
                Objects.equals(getWeldDrawingNumber(), getActivityHistoryPipeWeldResponse.getWeldDrawingNumber()) &&
                Objects.equals(getWeldLineNumber(), getActivityHistoryPipeWeldResponse.getWeldLineNumber()) &&
                Objects.equals(getWeldSheetNumber(), getActivityHistoryPipeWeldResponse.getWeldSheetNumber()) &&
                Objects.equals(getWeldTimeInForm(), getActivityHistoryPipeWeldResponse.getWeldTimeInForm()) &&
                Objects.equals(getWeldLineSpec(), getActivityHistoryPipeWeldResponse.getWeldLineSpec()) &&
                Objects.equals(getWeldNumber(), getActivityHistoryPipeWeldResponse.getWeldNumber()) &&
                Objects.equals(getWeldStencil(), getActivityHistoryPipeWeldResponse.getWeldStencil()) &&
                Objects.equals(getWeldSize(), getActivityHistoryPipeWeldResponse.getWeldSize()) &&
                Objects.equals(getWeldThickness(), getActivityHistoryPipeWeldResponse.getWeldThickness()) &&
                Objects.equals(getWeldType(), getActivityHistoryPipeWeldResponse.getWeldType()) &&
                Objects.equals(getWeldPosition(), getActivityHistoryPipeWeldResponse.getWeldPosition()) &&
                Objects.equals(getWeldMaterial(), getActivityHistoryPipeWeldResponse.getWeldMaterial()) &&
                Objects.equals(getWeldProcedure(), getActivityHistoryPipeWeldResponse.getWeldProcedure()) &&
                Objects.equals(getWeldComplete(), getActivityHistoryPipeWeldResponse.getWeldComplete()) &&
                Objects.equals(getWeldShared(), getActivityHistoryPipeWeldResponse.getWeldShared()) &&
                Objects.equals(getWeldPercentCompleteChoice(), getActivityHistoryPipeWeldResponse.getWeldPercentCompleteChoice()) &&
                Objects.equals(getWeldPercentCompleted(), getActivityHistoryPipeWeldResponse.getWeldPercentCompleted()) &&
                Objects.equals(getWeldRework(), getActivityHistoryPipeWeldResponse.getWeldRework()) &&
                Objects.equals(getWeldNotes(), getActivityHistoryPipeWeldResponse.getWeldNotes()) &&
                Objects.equals(getActivityType(), getActivityHistoryPipeWeldResponse.getActivityType()) &&
                Objects.equals(getRev(), getActivityHistoryPipeWeldResponse.getRev()) &&
                Objects.equals(getTimeStamp(), getActivityHistoryPipeWeldResponse.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getActivityId(),
                getWeldSpool1(),
                getWeldSpool2(),
                getWeldDrawingNumber(),
                getWeldLineNumber(),
                getWeldSheetNumber(),
                getWeldTimeInForm(),
                getWeldLineSpec(),
                getWeldNumber(),
                getWeldStencil(),
                getWeldSize(),
                getWeldThickness(),
                getWeldType(),
                getWeldPosition(),
                getWeldMaterial(),
                getWeldProcedure(),
                getWeldComplete(),
                getWeldShared(),
                getWeldPercentCompleteChoice(),
                getWeldPercentCompleted(),
                getWeldRework(),
                getWeldNotes(),
                getActivityType(),
                getRev(),
                getTimeStamp());
    }
}
