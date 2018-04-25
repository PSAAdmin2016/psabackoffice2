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

public class GetReportDprsteelCondensedResponse implements Serializable {


    @JsonProperty("SortGroup1")
    @ColumnAlias("SortGroup1")
    private String sortGroup1;

    @JsonProperty("PieceMark")
    @ColumnAlias("PieceMark")
    private String pieceMark;

    @JsonProperty("ShakeQuantity")
    @ColumnAlias("ShakeQuantity")
    private BigInteger shakeQuantity;

    @JsonProperty("ErectQuantity")
    @ColumnAlias("ErectQuantity")
    private BigDecimal erectQuantity;

    @JsonProperty("BoltoutQuantity")
    @ColumnAlias("BoltoutQuantity")
    private BigDecimal boltoutQuantity;

    @JsonProperty("ImpQuantity")
    @ColumnAlias("ImpQuantity")
    private BigDecimal impQuantity;

    @JsonProperty("WeldQuantity")
    @ColumnAlias("WeldQuantity")
    private BigDecimal weldQuantity;

    @JsonProperty("SellQuantity")
    @ColumnAlias("SellQuantity")
    private BigDecimal sellQuantity;

    @JsonProperty("DemoQuantity")
    @ColumnAlias("DemoQuantity")
    private BigDecimal demoQuantity;

    @JsonProperty("MiscQuantity")
    @ColumnAlias("MiscQuantity")
    private BigDecimal miscQuantity;

    @JsonProperty("ReceivedTime")
    @ColumnAlias("ReceivedTime")
    private Timestamp receivedTime;

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

    public BigInteger getShakeQuantity() {
        return this.shakeQuantity;
    }

    public void setShakeQuantity(BigInteger shakeQuantity) {
        this.shakeQuantity = shakeQuantity;
    }

    public BigDecimal getErectQuantity() {
        return this.erectQuantity;
    }

    public void setErectQuantity(BigDecimal erectQuantity) {
        this.erectQuantity = erectQuantity;
    }

    public BigDecimal getBoltoutQuantity() {
        return this.boltoutQuantity;
    }

    public void setBoltoutQuantity(BigDecimal boltoutQuantity) {
        this.boltoutQuantity = boltoutQuantity;
    }

    public BigDecimal getImpQuantity() {
        return this.impQuantity;
    }

    public void setImpQuantity(BigDecimal impQuantity) {
        this.impQuantity = impQuantity;
    }

    public BigDecimal getWeldQuantity() {
        return this.weldQuantity;
    }

    public void setWeldQuantity(BigDecimal weldQuantity) {
        this.weldQuantity = weldQuantity;
    }

    public BigDecimal getSellQuantity() {
        return this.sellQuantity;
    }

    public void setSellQuantity(BigDecimal sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    public BigDecimal getDemoQuantity() {
        return this.demoQuantity;
    }

    public void setDemoQuantity(BigDecimal demoQuantity) {
        this.demoQuantity = demoQuantity;
    }

    public BigDecimal getMiscQuantity() {
        return this.miscQuantity;
    }

    public void setMiscQuantity(BigDecimal miscQuantity) {
        this.miscQuantity = miscQuantity;
    }

    public Timestamp getReceivedTime() {
        return this.receivedTime;
    }

    public void setReceivedTime(Timestamp receivedTime) {
        this.receivedTime = receivedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetReportDprsteelCondensedResponse)) return false;
        final GetReportDprsteelCondensedResponse getReportDprsteelCondensedResponse = (GetReportDprsteelCondensedResponse) o;
        return Objects.equals(getSortGroup1(), getReportDprsteelCondensedResponse.getSortGroup1()) &&
                Objects.equals(getPieceMark(), getReportDprsteelCondensedResponse.getPieceMark()) &&
                Objects.equals(getShakeQuantity(), getReportDprsteelCondensedResponse.getShakeQuantity()) &&
                Objects.equals(getErectQuantity(), getReportDprsteelCondensedResponse.getErectQuantity()) &&
                Objects.equals(getBoltoutQuantity(), getReportDprsteelCondensedResponse.getBoltoutQuantity()) &&
                Objects.equals(getImpQuantity(), getReportDprsteelCondensedResponse.getImpQuantity()) &&
                Objects.equals(getWeldQuantity(), getReportDprsteelCondensedResponse.getWeldQuantity()) &&
                Objects.equals(getSellQuantity(), getReportDprsteelCondensedResponse.getSellQuantity()) &&
                Objects.equals(getDemoQuantity(), getReportDprsteelCondensedResponse.getDemoQuantity()) &&
                Objects.equals(getMiscQuantity(), getReportDprsteelCondensedResponse.getMiscQuantity()) &&
                Objects.equals(getReceivedTime(), getReportDprsteelCondensedResponse.getReceivedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSortGroup1(),
                getPieceMark(),
                getShakeQuantity(),
                getErectQuantity(),
                getBoltoutQuantity(),
                getImpQuantity(),
                getWeldQuantity(),
                getSellQuantity(),
                getDemoQuantity(),
                getMiscQuantity(),
                getReceivedTime());
    }
}
