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

public class GetQuantitiesTestPackageResponse implements Serializable {

    @JsonProperty("ClientTurnoverHours")
    @ColumnAlias("ClientTurnoverHours")
    private BigDecimal clientTurnoverHours;
    @JsonProperty("ClientTurnoverInstalled")
    @ColumnAlias("ClientTurnoverInstalled")
    private BigDecimal clientTurnoverInstalled;
    @JsonProperty("EarnedClientTurnoverHours")
    @ColumnAlias("EarnedClientTurnoverHours")
    private BigDecimal earnedClientTurnoverHours;
    @JsonProperty("EarnedHydroHours")
    @ColumnAlias("EarnedHydroHours")
    private BigDecimal earnedHydroHours;
    @JsonProperty("EarnedReadyForTestingHours")
    @ColumnAlias("EarnedReadyForTestingHours")
    private BigDecimal earnedReadyForTestingHours;
    @JsonProperty("HydroHours")
    @ColumnAlias("HydroHours")
    private BigDecimal hydroHours;
    @JsonProperty("HydroInstalled")
    @ColumnAlias("HydroInstalled")
    private BigDecimal hydroInstalled;
    @JsonProperty("ItemsTotal")
    @ColumnAlias("ItemsTotal")
    private BigInteger itemsTotal;
    @JsonProperty("LooseHours")
    @ColumnAlias("LooseHours")
    private BigDecimal looseHours;
    @JsonProperty("ReadyForTestingHours")
    @ColumnAlias("ReadyForTestingHours")
    private BigDecimal readyForTestingHours;
    @JsonProperty("ReadyForTestingInstalled")
    @ColumnAlias("ReadyForTestingInstalled")
    private BigDecimal readyForTestingInstalled;
    @JsonProperty("TestPackageNumber")
    @ColumnAlias("TestPackageNumber")
    private String testPackageNumber;

    public BigDecimal getClientTurnoverHours() {
        return this.clientTurnoverHours;
    }

    public void setClientTurnoverHours(BigDecimal clientTurnoverHours) {
        this.clientTurnoverHours = clientTurnoverHours;
    }

    public BigDecimal getClientTurnoverInstalled() {
        return this.clientTurnoverInstalled;
    }

    public void setClientTurnoverInstalled(BigDecimal clientTurnoverInstalled) {
        this.clientTurnoverInstalled = clientTurnoverInstalled;
    }

    public BigDecimal getEarnedClientTurnoverHours() {
        return this.earnedClientTurnoverHours;
    }

    public void setEarnedClientTurnoverHours(BigDecimal earnedClientTurnoverHours) {
        this.earnedClientTurnoverHours = earnedClientTurnoverHours;
    }

    public BigDecimal getEarnedHydroHours() {
        return this.earnedHydroHours;
    }

    public void setEarnedHydroHours(BigDecimal earnedHydroHours) {
        this.earnedHydroHours = earnedHydroHours;
    }

    public BigDecimal getEarnedReadyForTestingHours() {
        return this.earnedReadyForTestingHours;
    }

    public void setEarnedReadyForTestingHours(BigDecimal earnedReadyForTestingHours) {
        this.earnedReadyForTestingHours = earnedReadyForTestingHours;
    }

    public BigDecimal getHydroHours() {
        return this.hydroHours;
    }

    public void setHydroHours(BigDecimal hydroHours) {
        this.hydroHours = hydroHours;
    }

    public BigDecimal getHydroInstalled() {
        return this.hydroInstalled;
    }

    public void setHydroInstalled(BigDecimal hydroInstalled) {
        this.hydroInstalled = hydroInstalled;
    }

    public BigInteger getItemsTotal() {
        return this.itemsTotal;
    }

    public void setItemsTotal(BigInteger itemsTotal) {
        this.itemsTotal = itemsTotal;
    }

    public BigDecimal getLooseHours() {
        return this.looseHours;
    }

    public void setLooseHours(BigDecimal looseHours) {
        this.looseHours = looseHours;
    }

    public BigDecimal getReadyForTestingHours() {
        return this.readyForTestingHours;
    }

    public void setReadyForTestingHours(BigDecimal readyForTestingHours) {
        this.readyForTestingHours = readyForTestingHours;
    }

    public BigDecimal getReadyForTestingInstalled() {
        return this.readyForTestingInstalled;
    }

    public void setReadyForTestingInstalled(BigDecimal readyForTestingInstalled) {
        this.readyForTestingInstalled = readyForTestingInstalled;
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
        if (!(o instanceof GetQuantitiesTestPackageResponse)) return false;
        final GetQuantitiesTestPackageResponse getQuantitiesTestPackageResponse = (GetQuantitiesTestPackageResponse) o;
        return Objects.equals(getClientTurnoverHours(), getQuantitiesTestPackageResponse.getClientTurnoverHours()) &&
                Objects.equals(getClientTurnoverInstalled(), getQuantitiesTestPackageResponse.getClientTurnoverInstalled()) &&
                Objects.equals(getEarnedClientTurnoverHours(), getQuantitiesTestPackageResponse.getEarnedClientTurnoverHours()) &&
                Objects.equals(getEarnedHydroHours(), getQuantitiesTestPackageResponse.getEarnedHydroHours()) &&
                Objects.equals(getEarnedReadyForTestingHours(), getQuantitiesTestPackageResponse.getEarnedReadyForTestingHours()) &&
                Objects.equals(getHydroHours(), getQuantitiesTestPackageResponse.getHydroHours()) &&
                Objects.equals(getHydroInstalled(), getQuantitiesTestPackageResponse.getHydroInstalled()) &&
                Objects.equals(getItemsTotal(), getQuantitiesTestPackageResponse.getItemsTotal()) &&
                Objects.equals(getLooseHours(), getQuantitiesTestPackageResponse.getLooseHours()) &&
                Objects.equals(getReadyForTestingHours(), getQuantitiesTestPackageResponse.getReadyForTestingHours()) &&
                Objects.equals(getReadyForTestingInstalled(), getQuantitiesTestPackageResponse.getReadyForTestingInstalled()) &&
                Objects.equals(getTestPackageNumber(), getQuantitiesTestPackageResponse.getTestPackageNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientTurnoverHours(),
                getClientTurnoverInstalled(),
                getEarnedClientTurnoverHours(),
                getEarnedHydroHours(),
                getEarnedReadyForTestingHours(),
                getHydroHours(),
                getHydroInstalled(),
                getItemsTotal(),
                getLooseHours(),
                getReadyForTestingHours(),
                getReadyForTestingInstalled(),
                getTestPackageNumber());
    }
}
