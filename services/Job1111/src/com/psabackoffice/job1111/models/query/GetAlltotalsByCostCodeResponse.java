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

public class GetAlltotalsByCostCodeResponse implements Serializable {

    @JsonProperty("PercentComplete")
    @ColumnAlias("PercentComplete")
    private BigDecimal percentComplete;
    @JsonProperty("HoursALLMech")
    @ColumnAlias("HoursALLMech")
    private BigDecimal hoursAllmech;
    @JsonProperty("RemainingBoltUps")
    @ColumnAlias("RemainingBoltUps")
    private Integer remainingBoltUps;
    @JsonProperty("HoursMisc")
    @ColumnAlias("HoursMisc")
    private BigDecimal hoursMisc;
    @JsonProperty("Area")
    @ColumnAlias("Area")
    private String area;
    @JsonProperty("RemainingBasicConnections")
    @ColumnAlias("RemainingBasicConnections")
    private BigDecimal remainingBasicConnections;
    @JsonProperty("EarnedTestingHours")
    @ColumnAlias("EarnedTestingHours")
    private BigDecimal earnedTestingHours;
    @JsonProperty("EarnedBasicConnectHours")
    @ColumnAlias("EarnedBasicConnectHours")
    private BigDecimal earnedBasicConnectHours;
    @JsonProperty("EarnedSupportHours")
    @ColumnAlias("EarnedSupportHours")
    private BigDecimal earnedSupportHours;
    @JsonProperty("RemainingWeldHours")
    @ColumnAlias("RemainingWeldHours")
    private BigDecimal remainingWeldHours;
    @JsonProperty("InstalledMisc")
    @ColumnAlias("InstalledMisc")
    private Integer installedMisc;
    @JsonProperty("HoursTrim")
    @ColumnAlias("HoursTrim")
    private BigDecimal hoursTrim;
    @JsonProperty("EarnedTrimHours")
    @ColumnAlias("EarnedTrimHours")
    private BigDecimal earnedTrimHours;
    @JsonProperty("InstalledSupports")
    @ColumnAlias("InstalledSupports")
    private BigDecimal installedSupports;
    @JsonProperty("RemainingFootage")
    @ColumnAlias("RemainingFootage")
    private BigDecimal remainingFootage;
    @JsonProperty("CountSupports")
    @ColumnAlias("CountSupports")
    private Integer countSupports;
    @JsonProperty("CountErectionFootage")
    @ColumnAlias("CountErectionFootage")
    private BigDecimal countErectionFootage;
    @JsonProperty("RemainingSupportHours")
    @ColumnAlias("RemainingSupportHours")
    private BigDecimal remainingSupportHours;
    @JsonProperty("EarnedMiscHours")
    @ColumnAlias("EarnedMiscHours")
    private BigDecimal earnedMiscHours;
    @JsonProperty("RemainingBasicTrimActivities")
    @ColumnAlias("RemainingBasicTrimActivities")
    private BigDecimal remainingBasicTrimActivities;
    @JsonProperty("CostCode")
    @ColumnAlias("CostCode")
    private String costCode;
    @JsonProperty("RemainingBasicTrimHours")
    @ColumnAlias("RemainingBasicTrimHours")
    private BigDecimal remainingBasicTrimHours;
    @JsonProperty("CountMiscActivities")
    @ColumnAlias("CountMiscActivities")
    private Integer countMiscActivities;
    @JsonProperty("RemainingBoltUpHours")
    @ColumnAlias("RemainingBoltUpHours")
    private BigDecimal remainingBoltUpHours;
    @JsonProperty("RemainingTrimActivities")
    @ColumnAlias("RemainingTrimActivities")
    private Integer remainingTrimActivities;
    @JsonProperty("HoursTesting")
    @ColumnAlias("HoursTesting")
    private BigDecimal hoursTesting;
    @JsonProperty("InstalledBasicTrim")
    @ColumnAlias("InstalledBasicTrim")
    private BigDecimal installedBasicTrim;
    @JsonProperty("Phase")
    @ColumnAlias("Phase")
    private String phase;
    @JsonProperty("EarnedBasicTrimHours")
    @ColumnAlias("EarnedBasicTrimHours")
    private BigDecimal earnedBasicTrimHours;
    @JsonProperty("InstalledTrim")
    @ColumnAlias("InstalledTrim")
    private Integer installedTrim;
    @JsonProperty("HoursErection")
    @ColumnAlias("HoursErection")
    private BigDecimal hoursErection;
    @JsonProperty("CountBasicConnection")
    @ColumnAlias("CountBasicConnection")
    private Integer countBasicConnection;
    @JsonProperty("EarnedWeldHours")
    @ColumnAlias("EarnedWeldHours")
    private BigDecimal earnedWeldHours;
    @JsonProperty("RemainingWelds")
    @ColumnAlias("RemainingWelds")
    private BigDecimal remainingWelds;
    @JsonProperty("HoursBoltUp")
    @ColumnAlias("HoursBoltUp")
    private BigDecimal hoursBoltUp;
    @JsonProperty("RemainingTrimHours")
    @ColumnAlias("RemainingTrimHours")
    private BigDecimal remainingTrimHours;
    @JsonProperty("RemainingMiscActivities")
    @ColumnAlias("RemainingMiscActivities")
    private Integer remainingMiscActivities;
    @JsonProperty("RemainingMiscHours")
    @ColumnAlias("RemainingMiscHours")
    private BigDecimal remainingMiscHours;
    @JsonProperty("HoursWeld")
    @ColumnAlias("HoursWeld")
    private BigDecimal hoursWeld;
    @JsonProperty("EarnedBoltUpHours")
    @ColumnAlias("EarnedBoltUpHours")
    private BigDecimal earnedBoltUpHours;
    @JsonProperty("CU")
    @ColumnAlias("CU")
    private String cu;
    @JsonProperty("CountTrimActivities")
    @ColumnAlias("CountTrimActivities")
    private Integer countTrimActivities;
    @JsonProperty("RemainingSupports")
    @ColumnAlias("RemainingSupports")
    private BigDecimal remainingSupports;
    @JsonProperty("CountBoltUp")
    @ColumnAlias("CountBoltUp")
    private Integer countBoltUp;
    @JsonProperty("EarnedErectionHours")
    @ColumnAlias("EarnedErectionHours")
    private BigDecimal earnedErectionHours;
    @JsonProperty("CountBasicTrimActivities")
    @ColumnAlias("CountBasicTrimActivities")
    private Integer countBasicTrimActivities;
    @JsonProperty("EarnedALLMech")
    @ColumnAlias("EarnedALLMech")
    private BigDecimal earnedAllmech;
    @JsonProperty("InstalledWelds")
    @ColumnAlias("InstalledWelds")
    private BigDecimal installedWelds;
    @JsonProperty("HoursBasicTrimActivities")
    @ColumnAlias("HoursBasicTrimActivities")
    private BigDecimal hoursBasicTrimActivities;
    @JsonProperty("InstalledBoltUps")
    @ColumnAlias("InstalledBoltUps")
    private Integer installedBoltUps;
    @JsonProperty("RemainingErectionHours")
    @ColumnAlias("RemainingErectionHours")
    private BigDecimal remainingErectionHours;
    @JsonProperty("RemainingBasicConnectionHours")
    @ColumnAlias("RemainingBasicConnectionHours")
    private BigDecimal remainingBasicConnectionHours;
    @JsonProperty("InstalledBasicConnections")
    @ColumnAlias("InstalledBasicConnections")
    private BigDecimal installedBasicConnections;
    @JsonProperty("HoursSupports")
    @ColumnAlias("HoursSupports")
    private BigDecimal hoursSupports;
    @JsonProperty("HoursBasicConnection")
    @ColumnAlias("HoursBasicConnection")
    private BigDecimal hoursBasicConnection;
    @JsonProperty("CountWeld")
    @ColumnAlias("CountWeld")
    private Integer countWeld;
    @JsonProperty("InstalledFootage")
    @ColumnAlias("InstalledFootage")
    private BigDecimal installedFootage;

    public BigDecimal getPercentComplete() {
        return this.percentComplete;
    }

    public void setPercentComplete(BigDecimal percentComplete) {
        this.percentComplete = percentComplete;
    }

    public BigDecimal getHoursAllmech() {
        return this.hoursAllmech;
    }

    public void setHoursAllmech(BigDecimal hoursAllmech) {
        this.hoursAllmech = hoursAllmech;
    }

    public Integer getRemainingBoltUps() {
        return this.remainingBoltUps;
    }

    public void setRemainingBoltUps(Integer remainingBoltUps) {
        this.remainingBoltUps = remainingBoltUps;
    }

    public BigDecimal getHoursMisc() {
        return this.hoursMisc;
    }

    public void setHoursMisc(BigDecimal hoursMisc) {
        this.hoursMisc = hoursMisc;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public BigDecimal getRemainingBasicConnections() {
        return this.remainingBasicConnections;
    }

    public void setRemainingBasicConnections(BigDecimal remainingBasicConnections) {
        this.remainingBasicConnections = remainingBasicConnections;
    }

    public BigDecimal getEarnedTestingHours() {
        return this.earnedTestingHours;
    }

    public void setEarnedTestingHours(BigDecimal earnedTestingHours) {
        this.earnedTestingHours = earnedTestingHours;
    }

    public BigDecimal getEarnedBasicConnectHours() {
        return this.earnedBasicConnectHours;
    }

    public void setEarnedBasicConnectHours(BigDecimal earnedBasicConnectHours) {
        this.earnedBasicConnectHours = earnedBasicConnectHours;
    }

    public BigDecimal getEarnedSupportHours() {
        return this.earnedSupportHours;
    }

    public void setEarnedSupportHours(BigDecimal earnedSupportHours) {
        this.earnedSupportHours = earnedSupportHours;
    }

    public BigDecimal getRemainingWeldHours() {
        return this.remainingWeldHours;
    }

    public void setRemainingWeldHours(BigDecimal remainingWeldHours) {
        this.remainingWeldHours = remainingWeldHours;
    }

    public Integer getInstalledMisc() {
        return this.installedMisc;
    }

    public void setInstalledMisc(Integer installedMisc) {
        this.installedMisc = installedMisc;
    }

    public BigDecimal getHoursTrim() {
        return this.hoursTrim;
    }

    public void setHoursTrim(BigDecimal hoursTrim) {
        this.hoursTrim = hoursTrim;
    }

    public BigDecimal getEarnedTrimHours() {
        return this.earnedTrimHours;
    }

    public void setEarnedTrimHours(BigDecimal earnedTrimHours) {
        this.earnedTrimHours = earnedTrimHours;
    }

    public BigDecimal getInstalledSupports() {
        return this.installedSupports;
    }

    public void setInstalledSupports(BigDecimal installedSupports) {
        this.installedSupports = installedSupports;
    }

    public BigDecimal getRemainingFootage() {
        return this.remainingFootage;
    }

    public void setRemainingFootage(BigDecimal remainingFootage) {
        this.remainingFootage = remainingFootage;
    }

    public Integer getCountSupports() {
        return this.countSupports;
    }

    public void setCountSupports(Integer countSupports) {
        this.countSupports = countSupports;
    }

    public BigDecimal getCountErectionFootage() {
        return this.countErectionFootage;
    }

    public void setCountErectionFootage(BigDecimal countErectionFootage) {
        this.countErectionFootage = countErectionFootage;
    }

    public BigDecimal getRemainingSupportHours() {
        return this.remainingSupportHours;
    }

    public void setRemainingSupportHours(BigDecimal remainingSupportHours) {
        this.remainingSupportHours = remainingSupportHours;
    }

    public BigDecimal getEarnedMiscHours() {
        return this.earnedMiscHours;
    }

    public void setEarnedMiscHours(BigDecimal earnedMiscHours) {
        this.earnedMiscHours = earnedMiscHours;
    }

    public BigDecimal getRemainingBasicTrimActivities() {
        return this.remainingBasicTrimActivities;
    }

    public void setRemainingBasicTrimActivities(BigDecimal remainingBasicTrimActivities) {
        this.remainingBasicTrimActivities = remainingBasicTrimActivities;
    }

    public String getCostCode() {
        return this.costCode;
    }

    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }

    public BigDecimal getRemainingBasicTrimHours() {
        return this.remainingBasicTrimHours;
    }

    public void setRemainingBasicTrimHours(BigDecimal remainingBasicTrimHours) {
        this.remainingBasicTrimHours = remainingBasicTrimHours;
    }

    public Integer getCountMiscActivities() {
        return this.countMiscActivities;
    }

    public void setCountMiscActivities(Integer countMiscActivities) {
        this.countMiscActivities = countMiscActivities;
    }

    public BigDecimal getRemainingBoltUpHours() {
        return this.remainingBoltUpHours;
    }

    public void setRemainingBoltUpHours(BigDecimal remainingBoltUpHours) {
        this.remainingBoltUpHours = remainingBoltUpHours;
    }

    public Integer getRemainingTrimActivities() {
        return this.remainingTrimActivities;
    }

    public void setRemainingTrimActivities(Integer remainingTrimActivities) {
        this.remainingTrimActivities = remainingTrimActivities;
    }

    public BigDecimal getHoursTesting() {
        return this.hoursTesting;
    }

    public void setHoursTesting(BigDecimal hoursTesting) {
        this.hoursTesting = hoursTesting;
    }

    public BigDecimal getInstalledBasicTrim() {
        return this.installedBasicTrim;
    }

    public void setInstalledBasicTrim(BigDecimal installedBasicTrim) {
        this.installedBasicTrim = installedBasicTrim;
    }

    public String getPhase() {
        return this.phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public BigDecimal getEarnedBasicTrimHours() {
        return this.earnedBasicTrimHours;
    }

    public void setEarnedBasicTrimHours(BigDecimal earnedBasicTrimHours) {
        this.earnedBasicTrimHours = earnedBasicTrimHours;
    }

    public Integer getInstalledTrim() {
        return this.installedTrim;
    }

    public void setInstalledTrim(Integer installedTrim) {
        this.installedTrim = installedTrim;
    }

    public BigDecimal getHoursErection() {
        return this.hoursErection;
    }

    public void setHoursErection(BigDecimal hoursErection) {
        this.hoursErection = hoursErection;
    }

    public Integer getCountBasicConnection() {
        return this.countBasicConnection;
    }

    public void setCountBasicConnection(Integer countBasicConnection) {
        this.countBasicConnection = countBasicConnection;
    }

    public BigDecimal getEarnedWeldHours() {
        return this.earnedWeldHours;
    }

    public void setEarnedWeldHours(BigDecimal earnedWeldHours) {
        this.earnedWeldHours = earnedWeldHours;
    }

    public BigDecimal getRemainingWelds() {
        return this.remainingWelds;
    }

    public void setRemainingWelds(BigDecimal remainingWelds) {
        this.remainingWelds = remainingWelds;
    }

    public BigDecimal getHoursBoltUp() {
        return this.hoursBoltUp;
    }

    public void setHoursBoltUp(BigDecimal hoursBoltUp) {
        this.hoursBoltUp = hoursBoltUp;
    }

    public BigDecimal getRemainingTrimHours() {
        return this.remainingTrimHours;
    }

    public void setRemainingTrimHours(BigDecimal remainingTrimHours) {
        this.remainingTrimHours = remainingTrimHours;
    }

    public Integer getRemainingMiscActivities() {
        return this.remainingMiscActivities;
    }

    public void setRemainingMiscActivities(Integer remainingMiscActivities) {
        this.remainingMiscActivities = remainingMiscActivities;
    }

    public BigDecimal getRemainingMiscHours() {
        return this.remainingMiscHours;
    }

    public void setRemainingMiscHours(BigDecimal remainingMiscHours) {
        this.remainingMiscHours = remainingMiscHours;
    }

    public BigDecimal getHoursWeld() {
        return this.hoursWeld;
    }

    public void setHoursWeld(BigDecimal hoursWeld) {
        this.hoursWeld = hoursWeld;
    }

    public BigDecimal getEarnedBoltUpHours() {
        return this.earnedBoltUpHours;
    }

    public void setEarnedBoltUpHours(BigDecimal earnedBoltUpHours) {
        this.earnedBoltUpHours = earnedBoltUpHours;
    }

    public String getCu() {
        return this.cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public Integer getCountTrimActivities() {
        return this.countTrimActivities;
    }

    public void setCountTrimActivities(Integer countTrimActivities) {
        this.countTrimActivities = countTrimActivities;
    }

    public BigDecimal getRemainingSupports() {
        return this.remainingSupports;
    }

    public void setRemainingSupports(BigDecimal remainingSupports) {
        this.remainingSupports = remainingSupports;
    }

    public Integer getCountBoltUp() {
        return this.countBoltUp;
    }

    public void setCountBoltUp(Integer countBoltUp) {
        this.countBoltUp = countBoltUp;
    }

    public BigDecimal getEarnedErectionHours() {
        return this.earnedErectionHours;
    }

    public void setEarnedErectionHours(BigDecimal earnedErectionHours) {
        this.earnedErectionHours = earnedErectionHours;
    }

    public Integer getCountBasicTrimActivities() {
        return this.countBasicTrimActivities;
    }

    public void setCountBasicTrimActivities(Integer countBasicTrimActivities) {
        this.countBasicTrimActivities = countBasicTrimActivities;
    }

    public BigDecimal getEarnedAllmech() {
        return this.earnedAllmech;
    }

    public void setEarnedAllmech(BigDecimal earnedAllmech) {
        this.earnedAllmech = earnedAllmech;
    }

    public BigDecimal getInstalledWelds() {
        return this.installedWelds;
    }

    public void setInstalledWelds(BigDecimal installedWelds) {
        this.installedWelds = installedWelds;
    }

    public BigDecimal getHoursBasicTrimActivities() {
        return this.hoursBasicTrimActivities;
    }

    public void setHoursBasicTrimActivities(BigDecimal hoursBasicTrimActivities) {
        this.hoursBasicTrimActivities = hoursBasicTrimActivities;
    }

    public Integer getInstalledBoltUps() {
        return this.installedBoltUps;
    }

    public void setInstalledBoltUps(Integer installedBoltUps) {
        this.installedBoltUps = installedBoltUps;
    }

    public BigDecimal getRemainingErectionHours() {
        return this.remainingErectionHours;
    }

    public void setRemainingErectionHours(BigDecimal remainingErectionHours) {
        this.remainingErectionHours = remainingErectionHours;
    }

    public BigDecimal getRemainingBasicConnectionHours() {
        return this.remainingBasicConnectionHours;
    }

    public void setRemainingBasicConnectionHours(BigDecimal remainingBasicConnectionHours) {
        this.remainingBasicConnectionHours = remainingBasicConnectionHours;
    }

    public BigDecimal getInstalledBasicConnections() {
        return this.installedBasicConnections;
    }

    public void setInstalledBasicConnections(BigDecimal installedBasicConnections) {
        this.installedBasicConnections = installedBasicConnections;
    }

    public BigDecimal getHoursSupports() {
        return this.hoursSupports;
    }

    public void setHoursSupports(BigDecimal hoursSupports) {
        this.hoursSupports = hoursSupports;
    }

    public BigDecimal getHoursBasicConnection() {
        return this.hoursBasicConnection;
    }

    public void setHoursBasicConnection(BigDecimal hoursBasicConnection) {
        this.hoursBasicConnection = hoursBasicConnection;
    }

    public Integer getCountWeld() {
        return this.countWeld;
    }

    public void setCountWeld(Integer countWeld) {
        this.countWeld = countWeld;
    }

    public BigDecimal getInstalledFootage() {
        return this.installedFootage;
    }

    public void setInstalledFootage(BigDecimal installedFootage) {
        this.installedFootage = installedFootage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAlltotalsByCostCodeResponse)) return false;
        final GetAlltotalsByCostCodeResponse getAlltotalsByCostCodeResponse = (GetAlltotalsByCostCodeResponse) o;
        return Objects.equals(getPercentComplete(), getAlltotalsByCostCodeResponse.getPercentComplete()) &&
                Objects.equals(getHoursAllmech(), getAlltotalsByCostCodeResponse.getHoursAllmech()) &&
                Objects.equals(getRemainingBoltUps(), getAlltotalsByCostCodeResponse.getRemainingBoltUps()) &&
                Objects.equals(getHoursMisc(), getAlltotalsByCostCodeResponse.getHoursMisc()) &&
                Objects.equals(getArea(), getAlltotalsByCostCodeResponse.getArea()) &&
                Objects.equals(getRemainingBasicConnections(), getAlltotalsByCostCodeResponse.getRemainingBasicConnections()) &&
                Objects.equals(getEarnedTestingHours(), getAlltotalsByCostCodeResponse.getEarnedTestingHours()) &&
                Objects.equals(getEarnedBasicConnectHours(), getAlltotalsByCostCodeResponse.getEarnedBasicConnectHours()) &&
                Objects.equals(getEarnedSupportHours(), getAlltotalsByCostCodeResponse.getEarnedSupportHours()) &&
                Objects.equals(getRemainingWeldHours(), getAlltotalsByCostCodeResponse.getRemainingWeldHours()) &&
                Objects.equals(getInstalledMisc(), getAlltotalsByCostCodeResponse.getInstalledMisc()) &&
                Objects.equals(getHoursTrim(), getAlltotalsByCostCodeResponse.getHoursTrim()) &&
                Objects.equals(getEarnedTrimHours(), getAlltotalsByCostCodeResponse.getEarnedTrimHours()) &&
                Objects.equals(getInstalledSupports(), getAlltotalsByCostCodeResponse.getInstalledSupports()) &&
                Objects.equals(getRemainingFootage(), getAlltotalsByCostCodeResponse.getRemainingFootage()) &&
                Objects.equals(getCountSupports(), getAlltotalsByCostCodeResponse.getCountSupports()) &&
                Objects.equals(getCountErectionFootage(), getAlltotalsByCostCodeResponse.getCountErectionFootage()) &&
                Objects.equals(getRemainingSupportHours(), getAlltotalsByCostCodeResponse.getRemainingSupportHours()) &&
                Objects.equals(getEarnedMiscHours(), getAlltotalsByCostCodeResponse.getEarnedMiscHours()) &&
                Objects.equals(getRemainingBasicTrimActivities(), getAlltotalsByCostCodeResponse.getRemainingBasicTrimActivities()) &&
                Objects.equals(getCostCode(), getAlltotalsByCostCodeResponse.getCostCode()) &&
                Objects.equals(getRemainingBasicTrimHours(), getAlltotalsByCostCodeResponse.getRemainingBasicTrimHours()) &&
                Objects.equals(getCountMiscActivities(), getAlltotalsByCostCodeResponse.getCountMiscActivities()) &&
                Objects.equals(getRemainingBoltUpHours(), getAlltotalsByCostCodeResponse.getRemainingBoltUpHours()) &&
                Objects.equals(getRemainingTrimActivities(), getAlltotalsByCostCodeResponse.getRemainingTrimActivities()) &&
                Objects.equals(getHoursTesting(), getAlltotalsByCostCodeResponse.getHoursTesting()) &&
                Objects.equals(getInstalledBasicTrim(), getAlltotalsByCostCodeResponse.getInstalledBasicTrim()) &&
                Objects.equals(getPhase(), getAlltotalsByCostCodeResponse.getPhase()) &&
                Objects.equals(getEarnedBasicTrimHours(), getAlltotalsByCostCodeResponse.getEarnedBasicTrimHours()) &&
                Objects.equals(getInstalledTrim(), getAlltotalsByCostCodeResponse.getInstalledTrim()) &&
                Objects.equals(getHoursErection(), getAlltotalsByCostCodeResponse.getHoursErection()) &&
                Objects.equals(getCountBasicConnection(), getAlltotalsByCostCodeResponse.getCountBasicConnection()) &&
                Objects.equals(getEarnedWeldHours(), getAlltotalsByCostCodeResponse.getEarnedWeldHours()) &&
                Objects.equals(getRemainingWelds(), getAlltotalsByCostCodeResponse.getRemainingWelds()) &&
                Objects.equals(getHoursBoltUp(), getAlltotalsByCostCodeResponse.getHoursBoltUp()) &&
                Objects.equals(getRemainingTrimHours(), getAlltotalsByCostCodeResponse.getRemainingTrimHours()) &&
                Objects.equals(getRemainingMiscActivities(), getAlltotalsByCostCodeResponse.getRemainingMiscActivities()) &&
                Objects.equals(getRemainingMiscHours(), getAlltotalsByCostCodeResponse.getRemainingMiscHours()) &&
                Objects.equals(getHoursWeld(), getAlltotalsByCostCodeResponse.getHoursWeld()) &&
                Objects.equals(getEarnedBoltUpHours(), getAlltotalsByCostCodeResponse.getEarnedBoltUpHours()) &&
                Objects.equals(getCu(), getAlltotalsByCostCodeResponse.getCu()) &&
                Objects.equals(getCountTrimActivities(), getAlltotalsByCostCodeResponse.getCountTrimActivities()) &&
                Objects.equals(getRemainingSupports(), getAlltotalsByCostCodeResponse.getRemainingSupports()) &&
                Objects.equals(getCountBoltUp(), getAlltotalsByCostCodeResponse.getCountBoltUp()) &&
                Objects.equals(getEarnedErectionHours(), getAlltotalsByCostCodeResponse.getEarnedErectionHours()) &&
                Objects.equals(getCountBasicTrimActivities(), getAlltotalsByCostCodeResponse.getCountBasicTrimActivities()) &&
                Objects.equals(getEarnedAllmech(), getAlltotalsByCostCodeResponse.getEarnedAllmech()) &&
                Objects.equals(getInstalledWelds(), getAlltotalsByCostCodeResponse.getInstalledWelds()) &&
                Objects.equals(getHoursBasicTrimActivities(), getAlltotalsByCostCodeResponse.getHoursBasicTrimActivities()) &&
                Objects.equals(getInstalledBoltUps(), getAlltotalsByCostCodeResponse.getInstalledBoltUps()) &&
                Objects.equals(getRemainingErectionHours(), getAlltotalsByCostCodeResponse.getRemainingErectionHours()) &&
                Objects.equals(getRemainingBasicConnectionHours(), getAlltotalsByCostCodeResponse.getRemainingBasicConnectionHours()) &&
                Objects.equals(getInstalledBasicConnections(), getAlltotalsByCostCodeResponse.getInstalledBasicConnections()) &&
                Objects.equals(getHoursSupports(), getAlltotalsByCostCodeResponse.getHoursSupports()) &&
                Objects.equals(getHoursBasicConnection(), getAlltotalsByCostCodeResponse.getHoursBasicConnection()) &&
                Objects.equals(getCountWeld(), getAlltotalsByCostCodeResponse.getCountWeld()) &&
                Objects.equals(getInstalledFootage(), getAlltotalsByCostCodeResponse.getInstalledFootage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPercentComplete(),
                getHoursAllmech(),
                getRemainingBoltUps(),
                getHoursMisc(),
                getArea(),
                getRemainingBasicConnections(),
                getEarnedTestingHours(),
                getEarnedBasicConnectHours(),
                getEarnedSupportHours(),
                getRemainingWeldHours(),
                getInstalledMisc(),
                getHoursTrim(),
                getEarnedTrimHours(),
                getInstalledSupports(),
                getRemainingFootage(),
                getCountSupports(),
                getCountErectionFootage(),
                getRemainingSupportHours(),
                getEarnedMiscHours(),
                getRemainingBasicTrimActivities(),
                getCostCode(),
                getRemainingBasicTrimHours(),
                getCountMiscActivities(),
                getRemainingBoltUpHours(),
                getRemainingTrimActivities(),
                getHoursTesting(),
                getInstalledBasicTrim(),
                getPhase(),
                getEarnedBasicTrimHours(),
                getInstalledTrim(),
                getHoursErection(),
                getCountBasicConnection(),
                getEarnedWeldHours(),
                getRemainingWelds(),
                getHoursBoltUp(),
                getRemainingTrimHours(),
                getRemainingMiscActivities(),
                getRemainingMiscHours(),
                getHoursWeld(),
                getEarnedBoltUpHours(),
                getCu(),
                getCountTrimActivities(),
                getRemainingSupports(),
                getCountBoltUp(),
                getEarnedErectionHours(),
                getCountBasicTrimActivities(),
                getEarnedAllmech(),
                getInstalledWelds(),
                getHoursBasicTrimActivities(),
                getInstalledBoltUps(),
                getRemainingErectionHours(),
                getRemainingBasicConnectionHours(),
                getInstalledBasicConnections(),
                getHoursSupports(),
                getHoursBasicConnection(),
                getCountWeld(),
                getInstalledFootage());
    }
}
