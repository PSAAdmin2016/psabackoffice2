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

public class GetQuantitiesTestPackageSteelResponse implements Serializable {

    @JsonProperty("BidID")
    @ColumnAlias("BidID")
    private Integer bidId;
    @JsonProperty("EarnedSellPunchHours")
    @ColumnAlias("EarnedSellPunchHours")
    private BigDecimal earnedSellPunchHours;
    @JsonProperty("InstalledSell")
    @ColumnAlias("InstalledSell")
    private BigDecimal installedSell;
    @JsonProperty("LooseHours")
    @ColumnAlias("LooseHours")
    private BigDecimal looseHours;
    @JsonProperty("SellPunchCount")
    @ColumnAlias("SellPunchCount")
    private BigDecimal sellPunchCount;
    @JsonProperty("SellPunchHours")
    @ColumnAlias("SellPunchHours")
    private BigDecimal sellPunchHours;
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

    public BigDecimal getInstalledSell() {
        return this.installedSell;
    }

    public void setInstalledSell(BigDecimal installedSell) {
        this.installedSell = installedSell;
    }

    public BigDecimal getLooseHours() {
        return this.looseHours;
    }

    public void setLooseHours(BigDecimal looseHours) {
        this.looseHours = looseHours;
    }

    public BigDecimal getSellPunchCount() {
        return this.sellPunchCount;
    }

    public void setSellPunchCount(BigDecimal sellPunchCount) {
        this.sellPunchCount = sellPunchCount;
    }

    public BigDecimal getSellPunchHours() {
        return this.sellPunchHours;
    }

    public void setSellPunchHours(BigDecimal sellPunchHours) {
        this.sellPunchHours = sellPunchHours;
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
        if (!(o instanceof GetQuantitiesTestPackageSteelResponse)) return false;
        final GetQuantitiesTestPackageSteelResponse getQuantitiesTestPackageSteelResponse = (GetQuantitiesTestPackageSteelResponse) o;
        return Objects.equals(getBidId(), getQuantitiesTestPackageSteelResponse.getBidId()) &&
                Objects.equals(getEarnedSellPunchHours(), getQuantitiesTestPackageSteelResponse.getEarnedSellPunchHours()) &&
                Objects.equals(getInstalledSell(), getQuantitiesTestPackageSteelResponse.getInstalledSell()) &&
                Objects.equals(getLooseHours(), getQuantitiesTestPackageSteelResponse.getLooseHours()) &&
                Objects.equals(getSellPunchCount(), getQuantitiesTestPackageSteelResponse.getSellPunchCount()) &&
                Objects.equals(getSellPunchHours(), getQuantitiesTestPackageSteelResponse.getSellPunchHours()) &&
                Objects.equals(getTestPackageNumber(), getQuantitiesTestPackageSteelResponse.getTestPackageNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBidId(),
                getEarnedSellPunchHours(),
                getInstalledSell(),
                getLooseHours(),
                getSellPunchCount(),
                getSellPunchHours(),
                getTestPackageNumber());
    }
}
