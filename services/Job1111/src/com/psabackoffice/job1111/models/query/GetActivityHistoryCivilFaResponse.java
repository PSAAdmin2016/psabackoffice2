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

public class GetActivityHistoryCivilFaResponse implements Serializable {


    @JsonProperty("ActivityID")
    @ColumnAlias("ActivityID")
    private Integer activityId;

    @JsonProperty("FABidID")
    @ColumnAlias("FABidID")
    private Integer fabidId;

    @JsonProperty("FAFoundation")
    @ColumnAlias("FAFoundation")
    private String fafoundation;

    @JsonProperty("FADescription")
    @ColumnAlias("FADescription")
    private String fadescription;

    @JsonProperty("FADrawingNumber")
    @ColumnAlias("FADrawingNumber")
    private String fadrawingNumber;

    @JsonProperty("FADetailDrawingNumber")
    @ColumnAlias("FADetailDrawingNumber")
    private String fadetailDrawingNumber;

    @JsonProperty("FAPercentComplete")
    @ColumnAlias("FAPercentComplete")
    private Float fapercentComplete;

    @JsonProperty("FAQuantity")
    @ColumnAlias("FAQuantity")
    private Integer faquantity;

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

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getFabidId() {
        return this.fabidId;
    }

    public void setFabidId(Integer fabidId) {
        this.fabidId = fabidId;
    }

    public String getFafoundation() {
        return this.fafoundation;
    }

    public void setFafoundation(String fafoundation) {
        this.fafoundation = fafoundation;
    }

    public String getFadescription() {
        return this.fadescription;
    }

    public void setFadescription(String fadescription) {
        this.fadescription = fadescription;
    }

    public String getFadrawingNumber() {
        return this.fadrawingNumber;
    }

    public void setFadrawingNumber(String fadrawingNumber) {
        this.fadrawingNumber = fadrawingNumber;
    }

    public String getFadetailDrawingNumber() {
        return this.fadetailDrawingNumber;
    }

    public void setFadetailDrawingNumber(String fadetailDrawingNumber) {
        this.fadetailDrawingNumber = fadetailDrawingNumber;
    }

    public Float getFapercentComplete() {
        return this.fapercentComplete;
    }

    public void setFapercentComplete(Float fapercentComplete) {
        this.fapercentComplete = fapercentComplete;
    }

    public Integer getFaquantity() {
        return this.faquantity;
    }

    public void setFaquantity(Integer faquantity) {
        this.faquantity = faquantity;
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
        if (!(o instanceof GetActivityHistoryCivilFaResponse)) return false;
        final GetActivityHistoryCivilFaResponse getActivityHistoryCivilFaResponse = (GetActivityHistoryCivilFaResponse) o;
        return Objects.equals(getActivityId(), getActivityHistoryCivilFaResponse.getActivityId()) &&
                Objects.equals(getFabidId(), getActivityHistoryCivilFaResponse.getFabidId()) &&
                Objects.equals(getFafoundation(), getActivityHistoryCivilFaResponse.getFafoundation()) &&
                Objects.equals(getFadescription(), getActivityHistoryCivilFaResponse.getFadescription()) &&
                Objects.equals(getFadrawingNumber(), getActivityHistoryCivilFaResponse.getFadrawingNumber()) &&
                Objects.equals(getFadetailDrawingNumber(), getActivityHistoryCivilFaResponse.getFadetailDrawingNumber()) &&
                Objects.equals(getFapercentComplete(), getActivityHistoryCivilFaResponse.getFapercentComplete()) &&
                Objects.equals(getFaquantity(), getActivityHistoryCivilFaResponse.getFaquantity()) &&
                Objects.equals(getFarework(), getActivityHistoryCivilFaResponse.getFarework()) &&
                Objects.equals(getFanotes(), getActivityHistoryCivilFaResponse.getFanotes()) &&
                Objects.equals(getActivityType(), getActivityHistoryCivilFaResponse.getActivityType()) &&
                Objects.equals(getFatimeInForm(), getActivityHistoryCivilFaResponse.getFatimeInForm()) &&
                Objects.equals(getRev(), getActivityHistoryCivilFaResponse.getRev()) &&
                Objects.equals(getTimeStamp(), getActivityHistoryCivilFaResponse.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(),
                getFabidId(),
                getFafoundation(),
                getFadescription(),
                getFadrawingNumber(),
                getFadetailDrawingNumber(),
                getFapercentComplete(),
                getFaquantity(),
                getFarework(),
                getFanotes(),
                getActivityType(),
                getFatimeInForm(),
                getRev(),
                getTimeStamp());
    }
}
