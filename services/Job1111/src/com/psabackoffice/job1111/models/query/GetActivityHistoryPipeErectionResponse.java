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

public class GetActivityHistoryPipeErectionResponse implements Serializable {

    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;
    @JsonProperty("ErectionSpool1")
    @ColumnAlias("ErectionSpool1")
    private String erectionSpool1;
    @JsonProperty("ErectionLengthSpool1")
    @ColumnAlias("ErectionLengthSpool1")
    private Integer erectionLengthSpool1;
    @JsonProperty("ErectionSpool2")
    @ColumnAlias("ErectionSpool2")
    private String erectionSpool2;
    @JsonProperty("ErectionLengthSpool2")
    @ColumnAlias("ErectionLengthSpool2")
    private Integer erectionLengthSpool2;
    @JsonProperty("ErectionSpool3")
    @ColumnAlias("ErectionSpool3")
    private String erectionSpool3;
    @JsonProperty("ErectionLengthSpool3")
    @ColumnAlias("ErectionLengthSpool3")
    private Integer erectionLengthSpool3;
    @JsonProperty("ErectionSpool4")
    @ColumnAlias("ErectionSpool4")
    private String erectionSpool4;
    @JsonProperty("ErectionLengthSpool4")
    @ColumnAlias("ErectionLengthSpool4")
    private Integer erectionLengthSpool4;
    @JsonProperty("ErectionSpool5")
    @ColumnAlias("ErectionSpool5")
    private String erectionSpool5;
    @JsonProperty("ErectionLengthSpool5")
    @ColumnAlias("ErectionLengthSpool5")
    private Integer erectionLengthSpool5;
    @JsonProperty("ErectionSpool6")
    @ColumnAlias("ErectionSpool6")
    private String erectionSpool6;
    @JsonProperty("ErectionLengthSpool6")
    @ColumnAlias("ErectionLengthSpool6")
    private Integer erectionLengthSpool6;
    @JsonProperty("ErectionOnCords")
    @ColumnAlias("ErectionOnCords")
    private Short erectionOnCords;
    @JsonProperty("ErectionDrawingNumber")
    @ColumnAlias("ErectionDrawingNumber")
    private String erectionDrawingNumber;
    @JsonProperty("ErectionLineNumber")
    @ColumnAlias("ErectionLineNumber")
    private String erectionLineNumber;
    @JsonProperty("ErectionSheetNumber")
    @ColumnAlias("ErectionSheetNumber")
    private String erectionSheetNumber;
    @JsonProperty("ErectionTimeInForm")
    @ColumnAlias("ErectionTimeInForm")
    private Integer erectionTimeInForm;
    @JsonProperty("ErectionPipeSize")
    @ColumnAlias("ErectionPipeSize")
    private Float erectionPipeSize;
    @JsonProperty("ErectionRework")
    @ColumnAlias("ErectionRework")
    private Short erectionRework;
    @JsonProperty("ErectionNotes")
    @ColumnAlias("ErectionNotes")
    private String erectionNotes;
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

    public String getErectionSpool1() {
        return this.erectionSpool1;
    }

    public void setErectionSpool1(String erectionSpool1) {
        this.erectionSpool1 = erectionSpool1;
    }

    public Integer getErectionLengthSpool1() {
        return this.erectionLengthSpool1;
    }

    public void setErectionLengthSpool1(Integer erectionLengthSpool1) {
        this.erectionLengthSpool1 = erectionLengthSpool1;
    }

    public String getErectionSpool2() {
        return this.erectionSpool2;
    }

    public void setErectionSpool2(String erectionSpool2) {
        this.erectionSpool2 = erectionSpool2;
    }

    public Integer getErectionLengthSpool2() {
        return this.erectionLengthSpool2;
    }

    public void setErectionLengthSpool2(Integer erectionLengthSpool2) {
        this.erectionLengthSpool2 = erectionLengthSpool2;
    }

    public String getErectionSpool3() {
        return this.erectionSpool3;
    }

    public void setErectionSpool3(String erectionSpool3) {
        this.erectionSpool3 = erectionSpool3;
    }

    public Integer getErectionLengthSpool3() {
        return this.erectionLengthSpool3;
    }

    public void setErectionLengthSpool3(Integer erectionLengthSpool3) {
        this.erectionLengthSpool3 = erectionLengthSpool3;
    }

    public String getErectionSpool4() {
        return this.erectionSpool4;
    }

    public void setErectionSpool4(String erectionSpool4) {
        this.erectionSpool4 = erectionSpool4;
    }

    public Integer getErectionLengthSpool4() {
        return this.erectionLengthSpool4;
    }

    public void setErectionLengthSpool4(Integer erectionLengthSpool4) {
        this.erectionLengthSpool4 = erectionLengthSpool4;
    }

    public String getErectionSpool5() {
        return this.erectionSpool5;
    }

    public void setErectionSpool5(String erectionSpool5) {
        this.erectionSpool5 = erectionSpool5;
    }

    public Integer getErectionLengthSpool5() {
        return this.erectionLengthSpool5;
    }

    public void setErectionLengthSpool5(Integer erectionLengthSpool5) {
        this.erectionLengthSpool5 = erectionLengthSpool5;
    }

    public String getErectionSpool6() {
        return this.erectionSpool6;
    }

    public void setErectionSpool6(String erectionSpool6) {
        this.erectionSpool6 = erectionSpool6;
    }

    public Integer getErectionLengthSpool6() {
        return this.erectionLengthSpool6;
    }

    public void setErectionLengthSpool6(Integer erectionLengthSpool6) {
        this.erectionLengthSpool6 = erectionLengthSpool6;
    }

    public Short getErectionOnCords() {
        return this.erectionOnCords;
    }

    public void setErectionOnCords(Short erectionOnCords) {
        this.erectionOnCords = erectionOnCords;
    }

    public String getErectionDrawingNumber() {
        return this.erectionDrawingNumber;
    }

    public void setErectionDrawingNumber(String erectionDrawingNumber) {
        this.erectionDrawingNumber = erectionDrawingNumber;
    }

    public String getErectionLineNumber() {
        return this.erectionLineNumber;
    }

    public void setErectionLineNumber(String erectionLineNumber) {
        this.erectionLineNumber = erectionLineNumber;
    }

    public String getErectionSheetNumber() {
        return this.erectionSheetNumber;
    }

    public void setErectionSheetNumber(String erectionSheetNumber) {
        this.erectionSheetNumber = erectionSheetNumber;
    }

    public Integer getErectionTimeInForm() {
        return this.erectionTimeInForm;
    }

    public void setErectionTimeInForm(Integer erectionTimeInForm) {
        this.erectionTimeInForm = erectionTimeInForm;
    }

    public Float getErectionPipeSize() {
        return this.erectionPipeSize;
    }

    public void setErectionPipeSize(Float erectionPipeSize) {
        this.erectionPipeSize = erectionPipeSize;
    }

    public Short getErectionRework() {
        return this.erectionRework;
    }

    public void setErectionRework(Short erectionRework) {
        this.erectionRework = erectionRework;
    }

    public String getErectionNotes() {
        return this.erectionNotes;
    }

    public void setErectionNotes(String erectionNotes) {
        this.erectionNotes = erectionNotes;
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
        if (!(o instanceof GetActivityHistoryPipeErectionResponse)) return false;
        final GetActivityHistoryPipeErectionResponse getActivityHistoryPipeErectionResponse = (GetActivityHistoryPipeErectionResponse) o;
        return Objects.equals(getActivityId(), getActivityHistoryPipeErectionResponse.getActivityId()) &&
                Objects.equals(getErectionSpool1(), getActivityHistoryPipeErectionResponse.getErectionSpool1()) &&
                Objects.equals(getErectionLengthSpool1(), getActivityHistoryPipeErectionResponse.getErectionLengthSpool1()) &&
                Objects.equals(getErectionSpool2(), getActivityHistoryPipeErectionResponse.getErectionSpool2()) &&
                Objects.equals(getErectionLengthSpool2(), getActivityHistoryPipeErectionResponse.getErectionLengthSpool2()) &&
                Objects.equals(getErectionSpool3(), getActivityHistoryPipeErectionResponse.getErectionSpool3()) &&
                Objects.equals(getErectionLengthSpool3(), getActivityHistoryPipeErectionResponse.getErectionLengthSpool3()) &&
                Objects.equals(getErectionSpool4(), getActivityHistoryPipeErectionResponse.getErectionSpool4()) &&
                Objects.equals(getErectionLengthSpool4(), getActivityHistoryPipeErectionResponse.getErectionLengthSpool4()) &&
                Objects.equals(getErectionSpool5(), getActivityHistoryPipeErectionResponse.getErectionSpool5()) &&
                Objects.equals(getErectionLengthSpool5(), getActivityHistoryPipeErectionResponse.getErectionLengthSpool5()) &&
                Objects.equals(getErectionSpool6(), getActivityHistoryPipeErectionResponse.getErectionSpool6()) &&
                Objects.equals(getErectionLengthSpool6(), getActivityHistoryPipeErectionResponse.getErectionLengthSpool6()) &&
                Objects.equals(getErectionOnCords(), getActivityHistoryPipeErectionResponse.getErectionOnCords()) &&
                Objects.equals(getErectionDrawingNumber(), getActivityHistoryPipeErectionResponse.getErectionDrawingNumber()) &&
                Objects.equals(getErectionLineNumber(), getActivityHistoryPipeErectionResponse.getErectionLineNumber()) &&
                Objects.equals(getErectionSheetNumber(), getActivityHistoryPipeErectionResponse.getErectionSheetNumber()) &&
                Objects.equals(getErectionTimeInForm(), getActivityHistoryPipeErectionResponse.getErectionTimeInForm()) &&
                Objects.equals(getErectionPipeSize(), getActivityHistoryPipeErectionResponse.getErectionPipeSize()) &&
                Objects.equals(getErectionRework(), getActivityHistoryPipeErectionResponse.getErectionRework()) &&
                Objects.equals(getErectionNotes(), getActivityHistoryPipeErectionResponse.getErectionNotes()) &&
                Objects.equals(getActivityType(), getActivityHistoryPipeErectionResponse.getActivityType()) &&
                Objects.equals(getRev(), getActivityHistoryPipeErectionResponse.getRev()) &&
                Objects.equals(getTimeStamp(), getActivityHistoryPipeErectionResponse.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(),
                getErectionSpool1(),
                getErectionLengthSpool1(),
                getErectionSpool2(),
                getErectionLengthSpool2(),
                getErectionSpool3(),
                getErectionLengthSpool3(),
                getErectionSpool4(),
                getErectionLengthSpool4(),
                getErectionSpool5(),
                getErectionLengthSpool5(),
                getErectionSpool6(),
                getErectionLengthSpool6(),
                getErectionOnCords(),
                getErectionDrawingNumber(),
                getErectionLineNumber(),
                getErectionSheetNumber(),
                getErectionTimeInForm(),
                getErectionPipeSize(),
                getErectionRework(),
                getErectionNotes(),
                getActivityType(),
                getRev(),
                getTimeStamp());
    }
}
