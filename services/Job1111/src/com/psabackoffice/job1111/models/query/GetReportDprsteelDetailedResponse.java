/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetReportDprsteelDetailedResponse implements Serializable {


    @JsonProperty("SortGroup1")
    @ColumnAlias("SortGroup1")
    private String sortGroup1;

    @JsonProperty("PieceMark")
    @ColumnAlias("PieceMark")
    private String pieceMark;

    @JsonProperty("ShakeQuantity")
    @ColumnAlias("ShakeQuantity")
    private Short shakeQuantity;

    @JsonProperty("ErectQuantity")
    @ColumnAlias("ErectQuantity")
    private Short erectQuantity;

    @JsonProperty("ErectPercent")
    @ColumnAlias("ErectPercent")
    private String erectPercent;

    @JsonProperty("BoltoutQuantity")
    @ColumnAlias("BoltoutQuantity")
    private Short boltoutQuantity;

    @JsonProperty("BoltoutPercent")
    @ColumnAlias("BoltoutPercent")
    private String boltoutPercent;

    @JsonProperty("ImpQuantity")
    @ColumnAlias("ImpQuantity")
    private Short impQuantity;

    @JsonProperty("ImpPercent")
    @ColumnAlias("ImpPercent")
    private String impPercent;

    @JsonProperty("WeldQuantity")
    @ColumnAlias("WeldQuantity")
    private Short weldQuantity;

    @JsonProperty("WeldPercent")
    @ColumnAlias("WeldPercent")
    private String weldPercent;

    @JsonProperty("SellQuantity")
    @ColumnAlias("SellQuantity")
    private Short sellQuantity;

    @JsonProperty("DemoQuantity")
    @ColumnAlias("DemoQuantity")
    private Double demoQuantity;

    @JsonProperty("MiscQuantity")
    @ColumnAlias("MiscQuantity")
    private Double miscQuantity;

    @JsonProperty("ReceivedTime")
    @ColumnAlias("ReceivedTime")
    private Date receivedTime;

    @JsonProperty("CurrentStatus")
    @ColumnAlias("CurrentStatus")
    private String currentStatus;

    public String getSortGroup1() {
        return this.sortGroup1;
    }

    public void setSortGroup1(String sortGroup1) {
        this.sortGroup1 = sortGroup1;
    }

    public String getPieceMark() {
        return this.pieceMark;
    }

    public void setPieceMark(String pieceMark) {
        this.pieceMark = pieceMark;
    }

    public Short getShakeQuantity() {
        return this.shakeQuantity;
    }

    public void setShakeQuantity(Short shakeQuantity) {
        this.shakeQuantity = shakeQuantity;
    }

    public Short getErectQuantity() {
        return this.erectQuantity;
    }

    public void setErectQuantity(Short erectQuantity) {
        this.erectQuantity = erectQuantity;
    }

    public String getErectPercent() {
        return this.erectPercent;
    }

    public void setErectPercent(String erectPercent) {
        this.erectPercent = erectPercent;
    }

    public Short getBoltoutQuantity() {
        return this.boltoutQuantity;
    }

    public void setBoltoutQuantity(Short boltoutQuantity) {
        this.boltoutQuantity = boltoutQuantity;
    }

    public String getBoltoutPercent() {
        return this.boltoutPercent;
    }

    public void setBoltoutPercent(String boltoutPercent) {
        this.boltoutPercent = boltoutPercent;
    }

    public Short getImpQuantity() {
        return this.impQuantity;
    }

    public void setImpQuantity(Short impQuantity) {
        this.impQuantity = impQuantity;
    }

    public String getImpPercent() {
        return this.impPercent;
    }

    public void setImpPercent(String impPercent) {
        this.impPercent = impPercent;
    }

    public Short getWeldQuantity() {
        return this.weldQuantity;
    }

    public void setWeldQuantity(Short weldQuantity) {
        this.weldQuantity = weldQuantity;
    }

    public String getWeldPercent() {
        return this.weldPercent;
    }

    public void setWeldPercent(String weldPercent) {
        this.weldPercent = weldPercent;
    }

    public Short getSellQuantity() {
        return this.sellQuantity;
    }

    public void setSellQuantity(Short sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    public Double getDemoQuantity() {
        return this.demoQuantity;
    }

    public void setDemoQuantity(Double demoQuantity) {
        this.demoQuantity = demoQuantity;
    }

    public Double getMiscQuantity() {
        return this.miscQuantity;
    }

    public void setMiscQuantity(Double miscQuantity) {
        this.miscQuantity = miscQuantity;
    }

    public Date getReceivedTime() {
        return this.receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetReportDprsteelDetailedResponse)) return false;
        final GetReportDprsteelDetailedResponse getReportDprsteelDetailedResponse = (GetReportDprsteelDetailedResponse) o;
        return Objects.equals(getSortGroup1(), getReportDprsteelDetailedResponse.getSortGroup1()) &&
                Objects.equals(getPieceMark(), getReportDprsteelDetailedResponse.getPieceMark()) &&
                Objects.equals(getShakeQuantity(), getReportDprsteelDetailedResponse.getShakeQuantity()) &&
                Objects.equals(getErectQuantity(), getReportDprsteelDetailedResponse.getErectQuantity()) &&
                Objects.equals(getErectPercent(), getReportDprsteelDetailedResponse.getErectPercent()) &&
                Objects.equals(getBoltoutQuantity(), getReportDprsteelDetailedResponse.getBoltoutQuantity()) &&
                Objects.equals(getBoltoutPercent(), getReportDprsteelDetailedResponse.getBoltoutPercent()) &&
                Objects.equals(getImpQuantity(), getReportDprsteelDetailedResponse.getImpQuantity()) &&
                Objects.equals(getImpPercent(), getReportDprsteelDetailedResponse.getImpPercent()) &&
                Objects.equals(getWeldQuantity(), getReportDprsteelDetailedResponse.getWeldQuantity()) &&
                Objects.equals(getWeldPercent(), getReportDprsteelDetailedResponse.getWeldPercent()) &&
                Objects.equals(getSellQuantity(), getReportDprsteelDetailedResponse.getSellQuantity()) &&
                Objects.equals(getDemoQuantity(), getReportDprsteelDetailedResponse.getDemoQuantity()) &&
                Objects.equals(getMiscQuantity(), getReportDprsteelDetailedResponse.getMiscQuantity()) &&
                Objects.equals(getReceivedTime(), getReportDprsteelDetailedResponse.getReceivedTime()) &&
                Objects.equals(getCurrentStatus(), getReportDprsteelDetailedResponse.getCurrentStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSortGroup1(),
                getPieceMark(),
                getShakeQuantity(),
                getErectQuantity(),
                getErectPercent(),
                getBoltoutQuantity(),
                getBoltoutPercent(),
                getImpQuantity(),
                getImpPercent(),
                getWeldQuantity(),
                getWeldPercent(),
                getSellQuantity(),
                getDemoQuantity(),
                getMiscQuantity(),
                getReceivedTime(),
                getCurrentStatus());
    }
}
