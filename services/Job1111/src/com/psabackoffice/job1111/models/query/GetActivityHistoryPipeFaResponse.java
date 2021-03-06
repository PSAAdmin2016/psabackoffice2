/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetActivityHistoryPipeFaResponse implements Serializable {


    @ColumnAlias("ActivityID")
    private Integer activityId;

    @ColumnAlias("FABidID")
    private Integer fabidId;

    @ColumnAlias("FAQuantity")
    private Double faquantity;

    @ColumnAlias("FAPercentCompleted")
    private Float fapercentCompleted;

    @ColumnAlias("FARework")
    private Short farework;

    @ColumnAlias("FANotes")
    private String fanotes;

    @ColumnAlias("ActivityType")
    private Short activityType;

    @ColumnAlias("FATimeInForm")
    private Integer fatimeInForm;

    @ColumnAlias("Rev")
    private Short rev;

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

    public Double getFaquantity() {
        return this.faquantity;
    }

    public void setFaquantity(Double faquantity) {
        this.faquantity = faquantity;
    }

    public Float getFapercentCompleted() {
        return this.fapercentCompleted;
    }

    public void setFapercentCompleted(Float fapercentCompleted) {
        this.fapercentCompleted = fapercentCompleted;
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

    public Integer getFatimeInForm() {
        return this.fatimeInForm;
    }

    public void setFatimeInForm(Integer fatimeInForm) {
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
        if (!(o instanceof GetActivityHistoryPipeFaResponse)) return false;
        final GetActivityHistoryPipeFaResponse getActivityHistoryPipeFaResponse = (GetActivityHistoryPipeFaResponse) o;
        return Objects.equals(getActivityId(), getActivityHistoryPipeFaResponse.getActivityId()) &&
                Objects.equals(getFabidId(), getActivityHistoryPipeFaResponse.getFabidId()) &&
                Objects.equals(getFaquantity(), getActivityHistoryPipeFaResponse.getFaquantity()) &&
                Objects.equals(getFapercentCompleted(), getActivityHistoryPipeFaResponse.getFapercentCompleted()) &&
                Objects.equals(getFarework(), getActivityHistoryPipeFaResponse.getFarework()) &&
                Objects.equals(getFanotes(), getActivityHistoryPipeFaResponse.getFanotes()) &&
                Objects.equals(getActivityType(), getActivityHistoryPipeFaResponse.getActivityType()) &&
                Objects.equals(getFatimeInForm(), getActivityHistoryPipeFaResponse.getFatimeInForm()) &&
                Objects.equals(getRev(), getActivityHistoryPipeFaResponse.getRev()) &&
                Objects.equals(getTimeStamp(), getActivityHistoryPipeFaResponse.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId(),
                getFabidId(),
                getFaquantity(),
                getFapercentCompleted(),
                getFarework(),
                getFanotes(),
                getActivityType(),
                getFatimeInForm(),
                getRev(),
                getTimeStamp());
    }
}
