/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetActivityHistorySteelSellResponse implements Serializable {

    @JsonProperty("ID")
    @ColumnAlias("ID")
    private Integer id;
    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;
    @JsonProperty("FAArea")
    @ColumnAlias("FAArea")
    private String faarea;
    @JsonProperty("FAPieceNumber")
    @ColumnAlias("FAPieceNumber")
    private String fapieceNumber;
    @JsonProperty("FASellQuantity")
    @ColumnAlias("FASellQuantity")
    private Short fasellQuantity;
    @JsonProperty("FARework")
    @ColumnAlias("FARework")
    private Short farework;
    @JsonProperty("FANotes")
    @ColumnAlias("FANotes")
    private String fanotes;
    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private Short activityType;
    @JsonProperty("FATimeInForm")
    @ColumnAlias("FATimeInForm")
    private Short fatimeInForm;
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

    public String getFaarea() {
        return this.faarea;
    }

    public void setFaarea(String faarea) {
        this.faarea = faarea;
    }

    public String getFapieceNumber() {
        return this.fapieceNumber;
    }

    public void setFapieceNumber(String fapieceNumber) {
        this.fapieceNumber = fapieceNumber;
    }

    public Short getFasellQuantity() {
        return this.fasellQuantity;
    }

    public void setFasellQuantity(Short fasellQuantity) {
        this.fasellQuantity = fasellQuantity;
    }

    public Short getFarework() {
        return this.farework;
    }

    public void setFarework(Short farework) {
        this.farework = farework;
    }

    public String getFanotes() {
        return this.fanotes;
    }

    public void setFanotes(String fanotes) {
        this.fanotes = fanotes;
    }

    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
    }

    public Short getFatimeInForm() {
        return this.fatimeInForm;
    }

    public void setFatimeInForm(Short fatimeInForm) {
        this.fatimeInForm = fatimeInForm;
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
        if (!(o instanceof GetActivityHistorySteelSellResponse)) return false;
        final GetActivityHistorySteelSellResponse getActivityHistorySteelSellResponse = (GetActivityHistorySteelSellResponse) o;
        return Objects.equals(getId(), getActivityHistorySteelSellResponse.getId()) &&
                Objects.equals(getActivityId(), getActivityHistorySteelSellResponse.getActivityId()) &&
                Objects.equals(getFaarea(), getActivityHistorySteelSellResponse.getFaarea()) &&
                Objects.equals(getFapieceNumber(), getActivityHistorySteelSellResponse.getFapieceNumber()) &&
                Objects.equals(getFasellQuantity(), getActivityHistorySteelSellResponse.getFasellQuantity()) &&
                Objects.equals(getFarework(), getActivityHistorySteelSellResponse.getFarework()) &&
                Objects.equals(getFanotes(), getActivityHistorySteelSellResponse.getFanotes()) &&
                Objects.equals(getActivityType(), getActivityHistorySteelSellResponse.getActivityType()) &&
                Objects.equals(getFatimeInForm(), getActivityHistorySteelSellResponse.getFatimeInForm()) &&
                Objects.equals(getRev(), getActivityHistorySteelSellResponse.getRev()) &&
                Objects.equals(getTimeStamp(), getActivityHistorySteelSellResponse.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getActivityId(),
                getFaarea(),
                getFapieceNumber(),
                getFasellQuantity(),
                getFarework(),
                getFanotes(),
                getActivityType(),
                getFatimeInForm(),
                getRev(),
                getTimeStamp());
    }
}
