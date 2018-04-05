/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
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

public class GetBidActivityQuantitiesSteelResponse implements Serializable {


    @JsonProperty("BidID")
    @ColumnAlias("BidID")
    private Integer bidId;

    @JsonProperty("SteelQuantity")
    @ColumnAlias("SteelQuantity")
    private Double steelQuantity;

    @JsonProperty("WeldQuantity")
    @ColumnAlias("WeldQuantity")
    private Short weldQuantity;

    @JsonProperty("ShakeHours")
    @ColumnAlias("ShakeHours")
    private BigDecimal shakeHours;

    @JsonProperty("ErectHours")
    @ColumnAlias("ErectHours")
    private BigDecimal erectHours;

    @JsonProperty("BoltoutHours")
    @ColumnAlias("BoltoutHours")
    private BigDecimal boltoutHours;

    @JsonProperty("ImpHours")
    @ColumnAlias("ImpHours")
    private BigDecimal impHours;

    @JsonProperty("WeldHours")
    @ColumnAlias("WeldHours")
    private BigDecimal weldHours;

    @JsonProperty("SellHours")
    @ColumnAlias("SellHours")
    private BigDecimal sellHours;

    @JsonProperty("DemoHours")
    @ColumnAlias("DemoHours")
    private BigDecimal demoHours;

    @JsonProperty("MiscHours")
    @ColumnAlias("MiscHours")
    private BigDecimal miscHours;

    @JsonProperty("InstalledShake")
    @ColumnAlias("InstalledShake")
    private BigInteger installedShake;

    @JsonProperty("InstalledErect")
    @ColumnAlias("InstalledErect")
    private BigDecimal installedErect;

    @JsonProperty("InstalledBoltout")
    @ColumnAlias("InstalledBoltout")
    private BigDecimal installedBoltout;

    @JsonProperty("InstalledImp")
    @ColumnAlias("InstalledImp")
    private BigDecimal installedImp;

    @JsonProperty("InstalledWeld")
    @ColumnAlias("InstalledWeld")
    private BigDecimal installedWeld;

    @JsonProperty("InstalledSell")
    @ColumnAlias("InstalledSell")
    private BigDecimal installedSell;

    @JsonProperty("InstalledDemo")
    @ColumnAlias("InstalledDemo")
    private BigInteger installedDemo;

    @JsonProperty("InstalledMisc")
    @ColumnAlias("InstalledMisc")
    private BigInteger installedMisc;

    public Integer getBidId() {
        return this.bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Double getSteelQuantity() {
        return this.steelQuantity;
    }

    public void setSteelQuantity(Double steelQuantity) {
        this.steelQuantity = steelQuantity;
    }

    public Short getWeldQuantity() {
        return this.weldQuantity;
    }

    public void setWeldQuantity(Short weldQuantity) {
        this.weldQuantity = weldQuantity;
    }

    public BigDecimal getShakeHours() {
        return this.shakeHours;
    }

    public void setShakeHours(BigDecimal shakeHours) {
        this.shakeHours = shakeHours;
    }

    public BigDecimal getErectHours() {
        return this.erectHours;
    }

    public void setErectHours(BigDecimal erectHours) {
        this.erectHours = erectHours;
    }

    public BigDecimal getBoltoutHours() {
        return this.boltoutHours;
    }

    public void setBoltoutHours(BigDecimal boltoutHours) {
        this.boltoutHours = boltoutHours;
    }

    public BigDecimal getImpHours() {
        return this.impHours;
    }

    public void setImpHours(BigDecimal impHours) {
        this.impHours = impHours;
    }

    public BigDecimal getWeldHours() {
        return this.weldHours;
    }

    public void setWeldHours(BigDecimal weldHours) {
        this.weldHours = weldHours;
    }

    public BigDecimal getSellHours() {
        return this.sellHours;
    }

    public void setSellHours(BigDecimal sellHours) {
        this.sellHours = sellHours;
    }

    public BigDecimal getDemoHours() {
        return this.demoHours;
    }

    public void setDemoHours(BigDecimal demoHours) {
        this.demoHours = demoHours;
    }

    public BigDecimal getMiscHours() {
        return this.miscHours;
    }

    public void setMiscHours(BigDecimal miscHours) {
        this.miscHours = miscHours;
    }

    public BigInteger getInstalledShake() {
        return this.installedShake;
    }

    public void setInstalledShake(BigInteger installedShake) {
        this.installedShake = installedShake;
    }

    public BigDecimal getInstalledErect() {
        return this.installedErect;
    }

    public void setInstalledErect(BigDecimal installedErect) {
        this.installedErect = installedErect;
    }

    public BigDecimal getInstalledBoltout() {
        return this.installedBoltout;
    }

    public void setInstalledBoltout(BigDecimal installedBoltout) {
        this.installedBoltout = installedBoltout;
    }

    public BigDecimal getInstalledImp() {
        return this.installedImp;
    }

    public void setInstalledImp(BigDecimal installedImp) {
        this.installedImp = installedImp;
    }

    public BigDecimal getInstalledWeld() {
        return this.installedWeld;
    }

    public void setInstalledWeld(BigDecimal installedWeld) {
        this.installedWeld = installedWeld;
    }

    public BigDecimal getInstalledSell() {
        return this.installedSell;
    }

    public void setInstalledSell(BigDecimal installedSell) {
        this.installedSell = installedSell;
    }

    public BigInteger getInstalledDemo() {
        return this.installedDemo;
    }

    public void setInstalledDemo(BigInteger installedDemo) {
        this.installedDemo = installedDemo;
    }

    public BigInteger getInstalledMisc() {
        return this.installedMisc;
    }

    public void setInstalledMisc(BigInteger installedMisc) {
        this.installedMisc = installedMisc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetBidActivityQuantitiesSteelResponse)) return false;
        final GetBidActivityQuantitiesSteelResponse getBidActivityQuantitiesSteelResponse = (GetBidActivityQuantitiesSteelResponse) o;
        return Objects.equals(getBidId(), getBidActivityQuantitiesSteelResponse.getBidId()) &&
                Objects.equals(getSteelQuantity(), getBidActivityQuantitiesSteelResponse.getSteelQuantity()) &&
                Objects.equals(getWeldQuantity(), getBidActivityQuantitiesSteelResponse.getWeldQuantity()) &&
                Objects.equals(getShakeHours(), getBidActivityQuantitiesSteelResponse.getShakeHours()) &&
                Objects.equals(getErectHours(), getBidActivityQuantitiesSteelResponse.getErectHours()) &&
                Objects.equals(getBoltoutHours(), getBidActivityQuantitiesSteelResponse.getBoltoutHours()) &&
                Objects.equals(getImpHours(), getBidActivityQuantitiesSteelResponse.getImpHours()) &&
                Objects.equals(getWeldHours(), getBidActivityQuantitiesSteelResponse.getWeldHours()) &&
                Objects.equals(getSellHours(), getBidActivityQuantitiesSteelResponse.getSellHours()) &&
                Objects.equals(getDemoHours(), getBidActivityQuantitiesSteelResponse.getDemoHours()) &&
                Objects.equals(getMiscHours(), getBidActivityQuantitiesSteelResponse.getMiscHours()) &&
                Objects.equals(getInstalledShake(), getBidActivityQuantitiesSteelResponse.getInstalledShake()) &&
                Objects.equals(getInstalledErect(), getBidActivityQuantitiesSteelResponse.getInstalledErect()) &&
                Objects.equals(getInstalledBoltout(), getBidActivityQuantitiesSteelResponse.getInstalledBoltout()) &&
                Objects.equals(getInstalledImp(), getBidActivityQuantitiesSteelResponse.getInstalledImp()) &&
                Objects.equals(getInstalledWeld(), getBidActivityQuantitiesSteelResponse.getInstalledWeld()) &&
                Objects.equals(getInstalledSell(), getBidActivityQuantitiesSteelResponse.getInstalledSell()) &&
                Objects.equals(getInstalledDemo(), getBidActivityQuantitiesSteelResponse.getInstalledDemo()) &&
                Objects.equals(getInstalledMisc(), getBidActivityQuantitiesSteelResponse.getInstalledMisc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBidId(),
                getSteelQuantity(),
                getWeldQuantity(),
                getShakeHours(),
                getErectHours(),
                getBoltoutHours(),
                getImpHours(),
                getWeldHours(),
                getSellHours(),
                getDemoHours(),
                getMiscHours(),
                getInstalledShake(),
                getInstalledErect(),
                getInstalledBoltout(),
                getInstalledImp(),
                getInstalledWeld(),
                getInstalledSell(),
                getInstalledDemo(),
                getInstalledMisc());
    }
}
