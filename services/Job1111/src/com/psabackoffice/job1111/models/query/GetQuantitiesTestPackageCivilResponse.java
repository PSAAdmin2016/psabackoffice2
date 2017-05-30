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

public class GetQuantitiesTestPackageCivilResponse implements Serializable {

    @JsonProperty("BidID")
    @ColumnAlias("BidID")
    private Integer bidId;
    @JsonProperty("EarnedSellPunchHours")
    @ColumnAlias("EarnedSellPunchHours")
    private BigDecimal earnedSellPunchHours;
    @JsonProperty("LooseHours")
    @ColumnAlias("LooseHours")
    private Double looseHours;
    @JsonProperty("SellPunchCount")
    @ColumnAlias("SellPunchCount")
    private BigInteger sellPunchCount;
    @JsonProperty("SellPunchHours")
    @ColumnAlias("SellPunchHours")
    private BigDecimal sellPunchHours;
    @JsonProperty("SellPunchInstalled")
    @ColumnAlias("SellPunchInstalled")
    private BigDecimal sellPunchInstalled;
    @JsonProperty("TestPackageNumber")
    @ColumnAlias("TestPackageNumber")
    private String testPackageNumber;

    public Integer getBidId() {
        return this.bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public BigDecimal getEarnedSellPunchHours() {
        return this.earnedSellPunchHours;
    }

    public void setEarnedSellPunchHours(BigDecimal earnedSellPunchHours) {
        this.earnedSellPunchHours = earnedSellPunchHours;
    }

    public Double getLooseHours() {
        return this.looseHours;
    }

    public void setLooseHours(Double looseHours) {
        this.looseHours = looseHours;
    }

    public BigInteger getSellPunchCount() {
        return this.sellPunchCount;
    }

    public void setSellPunchCount(BigInteger sellPunchCount) {
        this.sellPunchCount = sellPunchCount;
    }

    public BigDecimal getSellPunchHours() {
        return this.sellPunchHours;
    }

    public void setSellPunchHours(BigDecimal sellPunchHours) {
        this.sellPunchHours = sellPunchHours;
    }

    public BigDecimal getSellPunchInstalled() {
        return this.sellPunchInstalled;
    }

    public void setSellPunchInstalled(BigDecimal sellPunchInstalled) {
        this.sellPunchInstalled = sellPunchInstalled;
    }

    public String getTestPackageNumber() {
        return this.testPackageNumber;
    }

    public void setTestPackageNumber(String testPackageNumber) {
        this.testPackageNumber = testPackageNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetQuantitiesTestPackageCivilResponse)) return false;
        final GetQuantitiesTestPackageCivilResponse getQuantitiesTestPackageCivilResponse = (GetQuantitiesTestPackageCivilResponse) o;
        return Objects.equals(getBidId(), getQuantitiesTestPackageCivilResponse.getBidId()) &&
                Objects.equals(getEarnedSellPunchHours(), getQuantitiesTestPackageCivilResponse.getEarnedSellPunchHours()) &&
                Objects.equals(getLooseHours(), getQuantitiesTestPackageCivilResponse.getLooseHours()) &&
                Objects.equals(getSellPunchCount(), getQuantitiesTestPackageCivilResponse.getSellPunchCount()) &&
                Objects.equals(getSellPunchHours(), getQuantitiesTestPackageCivilResponse.getSellPunchHours()) &&
                Objects.equals(getSellPunchInstalled(), getQuantitiesTestPackageCivilResponse.getSellPunchInstalled()) &&
                Objects.equals(getTestPackageNumber(), getQuantitiesTestPackageCivilResponse.getTestPackageNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBidId(),
                getEarnedSellPunchHours(),
                getLooseHours(),
                getSellPunchCount(),
                getSellPunchHours(),
                getSellPunchInstalled(),
                getTestPackageNumber());
    }
}
