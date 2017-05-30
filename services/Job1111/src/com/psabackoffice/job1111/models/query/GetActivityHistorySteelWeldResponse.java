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

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetActivityHistorySteelWeldResponse implements Serializable {

    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private Byte activityType;
    @JsonProperty("FAArea")
    @ColumnAlias("FAArea")
    private String faarea;
    @JsonProperty("FANotes")
    @ColumnAlias("FANotes")
    private String fanotes;
    @JsonProperty("FAPieceNumber")
    @ColumnAlias("FAPieceNumber")
    private String fapieceNumber;
    @JsonProperty("FARework")
    @ColumnAlias("FARework")
    private Byte farework;
    @JsonProperty("FATimeInForm")
    @ColumnAlias("FATimeInForm")
    private Byte fatimeInForm;
    @JsonProperty("FAWeldPercent")
    @ColumnAlias("FAWeldPercent")
    private BigDecimal faweldPercent;
    @JsonProperty("FAWeldQuantity")
    @ColumnAlias("FAWeldQuantity")
    private Byte faweldQuantity;
    @JsonProperty("ID")
    @ColumnAlias("ID")
    private Integer id;
    @JsonProperty("Rev")
    @ColumnAlias("Rev")
    private Byte rev;
    @JsonProperty("TimeStamp")
    @ColumnAlias("TimeStamp")
    private Timestamp timeStamp;
    @JsonProperty("fk_SubmissionID")
    @ColumnAlias("fk_SubmissionID")
    private Integer fkSubmissionId;

    public Byte getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Byte activityType) {
        this.activityType = activityType;
    }

    public String getFaarea() {
        return this.faarea;
    }

    public void setFaarea(String faarea) {
        this.faarea = faarea;
    }

    public String getFanotes() {
        return this.fanotes;
    }

    public void setFanotes(String fanotes) {
        this.fanotes = fanotes;
    }

    public String getFapieceNumber() {
        return this.fapieceNumber;
    }

    public void setFapieceNumber(String fapieceNumber) {
        this.fapieceNumber = fapieceNumber;
    }

    public Byte getFarework() {
        return this.farework;
    }

    public void setFarework(Byte farework) {
        this.farework = farework;
    }

    public Byte getFatimeInForm() {
        return this.fatimeInForm;
    }

    public void setFatimeInForm(Byte fatimeInForm) {
        this.fatimeInForm = fatimeInForm;
    }

    public BigDecimal getFaweldPercent() {
        return this.faweldPercent;
    }

    public void setFaweldPercent(BigDecimal faweldPercent) {
        this.faweldPercent = faweldPercent;
    }

    public Byte getFaweldQuantity() {
        return this.faweldQuantity;
    }

    public void setFaweldQuantity(Byte faweldQuantity) {
        this.faweldQuantity = faweldQuantity;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getRev() {
        return this.rev;
    }

    public void setRev(Byte rev) {
        this.rev = rev;
    }

    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getFkSubmissionId() {
        return this.fkSubmissionId;
    }

    public void setFkSubmissionId(Integer fkSubmissionId) {
        this.fkSubmissionId = fkSubmissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetActivityHistorySteelWeldResponse)) return false;
        final GetActivityHistorySteelWeldResponse getActivityHistorySteelWeldResponse = (GetActivityHistorySteelWeldResponse) o;
        return Objects.equals(getActivityType(), getActivityHistorySteelWeldResponse.getActivityType()) &&
                Objects.equals(getFaarea(), getActivityHistorySteelWeldResponse.getFaarea()) &&
                Objects.equals(getFanotes(), getActivityHistorySteelWeldResponse.getFanotes()) &&
                Objects.equals(getFapieceNumber(), getActivityHistorySteelWeldResponse.getFapieceNumber()) &&
                Objects.equals(getFarework(), getActivityHistorySteelWeldResponse.getFarework()) &&
                Objects.equals(getFatimeInForm(), getActivityHistorySteelWeldResponse.getFatimeInForm()) &&
                Objects.equals(getFaweldPercent(), getActivityHistorySteelWeldResponse.getFaweldPercent()) &&
                Objects.equals(getFaweldQuantity(), getActivityHistorySteelWeldResponse.getFaweldQuantity()) &&
                Objects.equals(getId(), getActivityHistorySteelWeldResponse.getId()) &&
                Objects.equals(getRev(), getActivityHistorySteelWeldResponse.getRev()) &&
                Objects.equals(getTimeStamp(), getActivityHistorySteelWeldResponse.getTimeStamp()) &&
                Objects.equals(getFkSubmissionId(), getActivityHistorySteelWeldResponse.getFkSubmissionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityType(),
                getFaarea(),
                getFanotes(),
                getFapieceNumber(),
                getFarework(),
                getFatimeInForm(),
                getFaweldPercent(),
                getFaweldQuantity(),
                getId(),
                getRev(),
                getTimeStamp(),
                getFkSubmissionId());
    }
}
