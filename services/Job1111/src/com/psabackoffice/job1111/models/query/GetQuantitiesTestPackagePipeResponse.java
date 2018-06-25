/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetQuantitiesTestPackagePipeResponse implements Serializable {


    @JsonProperty("TestPackageNumber")
    @ColumnAlias("TestPackageNumber")
    private String testPackageNumber;

    @JsonProperty("ItemsTotal")
    @ColumnAlias("ItemsTotal")
    private Long itemsTotal;

    @JsonProperty("RFTHours")
    @ColumnAlias("RFTHours")
    private BigDecimal rfthours;

    @JsonProperty("HydroHours")
    @ColumnAlias("HydroHours")
    private BigDecimal hydroHours;

    @JsonProperty("CTOHours")
    @ColumnAlias("CTOHours")
    private BigDecimal ctohours;

    @JsonProperty("RFTInstalled")
    @ColumnAlias("RFTInstalled")
    private BigInteger rftinstalled;

    @JsonProperty("HydroInstalled")
    @ColumnAlias("HydroInstalled")
    private BigInteger hydroInstalled;

    @JsonProperty("CTOInstalled")
    @ColumnAlias("CTOInstalled")
    private BigInteger ctoinstalled;

    @JsonProperty("EarnedRFTHours")
    @ColumnAlias("EarnedRFTHours")
    private BigDecimal earnedRfthours;

    @JsonProperty("EarnedHydroHours")
    @ColumnAlias("EarnedHydroHours")
    private BigDecimal earnedHydroHours;

    @JsonProperty("EarnedCTOHours")
    @ColumnAlias("EarnedCTOHours")
    private BigDecimal earnedCtohours;

    @JsonProperty("LooseHours")
    @ColumnAlias("LooseHours")
    private BigDecimal looseHours;

    public String getTestPackageNumber() {
        return this.testPackageNumber;
    }

    public void setTestPackageNumber(String testPackageNumber) {
        this.testPackageNumber = testPackageNumber;
    }

    public Long getItemsTotal() {
        return this.itemsTotal;
    }

    public void setItemsTotal(Long itemsTotal) {
        this.itemsTotal = itemsTotal;
    }

    public BigDecimal getRfthours() {
        return this.rfthours;
    }

    public void setRfthours(BigDecimal rfthours) {
        this.rfthours = rfthours;
    }

    public BigDecimal getHydroHours() {
        return this.hydroHours;
    }

    public void setHydroHours(BigDecimal hydroHours) {
        this.hydroHours = hydroHours;
    }

    public BigDecimal getCtohours() {
        return this.ctohours;
    }

    public void setCtohours(BigDecimal ctohours) {
        this.ctohours = ctohours;
    }

    public BigInteger getRftinstalled() {
        return this.rftinstalled;
    }

    public void setRftinstalled(BigInteger rftinstalled) {
        this.rftinstalled = rftinstalled;
    }

    public BigInteger getHydroInstalled() {
        return this.hydroInstalled;
    }

    public void setHydroInstalled(BigInteger hydroInstalled) {
        this.hydroInstalled = hydroInstalled;
    }

    public BigInteger getCtoinstalled() {
        return this.ctoinstalled;
    }

    public void setCtoinstalled(BigInteger ctoinstalled) {
        this.ctoinstalled = ctoinstalled;
    }

    public BigDecimal getEarnedRfthours() {
        return this.earnedRfthours;
    }

    public void setEarnedRfthours(BigDecimal earnedRfthours) {
        this.earnedRfthours = earnedRfthours;
    }

    public BigDecimal getEarnedHydroHours() {
        return this.earnedHydroHours;
    }

    public void setEarnedHydroHours(BigDecimal earnedHydroHours) {
        this.earnedHydroHours = earnedHydroHours;
    }

    public BigDecimal getEarnedCtohours() {
        return this.earnedCtohours;
    }

    public void setEarnedCtohours(BigDecimal earnedCtohours) {
        this.earnedCtohours = earnedCtohours;
    }

    public BigDecimal getLooseHours() {
        return this.looseHours;
    }

    public void setLooseHours(BigDecimal looseHours) {
        this.looseHours = looseHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetQuantitiesTestPackagePipeResponse)) return false;
        final GetQuantitiesTestPackagePipeResponse getQuantitiesTestPackagePipeResponse = (GetQuantitiesTestPackagePipeResponse) o;
        return Objects.equals(getTestPackageNumber(), getQuantitiesTestPackagePipeResponse.getTestPackageNumber()) &&
                Objects.equals(getItemsTotal(), getQuantitiesTestPackagePipeResponse.getItemsTotal()) &&
                Objects.equals(getRfthours(), getQuantitiesTestPackagePipeResponse.getRfthours()) &&
                Objects.equals(getHydroHours(), getQuantitiesTestPackagePipeResponse.getHydroHours()) &&
                Objects.equals(getCtohours(), getQuantitiesTestPackagePipeResponse.getCtohours()) &&
                Objects.equals(getRftinstalled(), getQuantitiesTestPackagePipeResponse.getRftinstalled()) &&
                Objects.equals(getHydroInstalled(), getQuantitiesTestPackagePipeResponse.getHydroInstalled()) &&
                Objects.equals(getCtoinstalled(), getQuantitiesTestPackagePipeResponse.getCtoinstalled()) &&
                Objects.equals(getEarnedRfthours(), getQuantitiesTestPackagePipeResponse.getEarnedRfthours()) &&
                Objects.equals(getEarnedHydroHours(), getQuantitiesTestPackagePipeResponse.getEarnedHydroHours()) &&
                Objects.equals(getEarnedCtohours(), getQuantitiesTestPackagePipeResponse.getEarnedCtohours()) &&
                Objects.equals(getLooseHours(), getQuantitiesTestPackagePipeResponse.getLooseHours());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestPackageNumber(),
                getItemsTotal(),
                getRfthours(),
                getHydroHours(),
                getCtohours(),
                getRftinstalled(),
                getHydroInstalled(),
                getCtoinstalled(),
                getEarnedRfthours(),
                getEarnedHydroHours(),
                getEarnedCtohours(),
                getLooseHours());
    }
}
