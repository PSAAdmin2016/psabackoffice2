/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * CacheStatsPipePcot generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`CacheStats_PipePCOT`")
public class CacheStatsPipePcot implements Serializable {

    private Integer id;
    @Type(type = "DateTime")
    private LocalDateTime earnedDate;
    private Float erectionPercentComplete;
    private Float boltUpPercentComplete;
    private Float weldPercentComplete;
    private Float cutPercentComplete;
    private Float trimPercentComplete;
    private Float supportPercentComplete;
    private Float demoPercentComplete;
    private Float miscPercentComplete;
    private Float readyForTestingComplete;
    private Float hydroComplete;
    private Float clientTurnoverComplete;
    private Float mechPercentComplete;
    private Float testingPercentComplete;
    private Float totalPercentComplete;
    private Double totalHoursEarned;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`EarnedDate`", nullable = true)
    public LocalDateTime getEarnedDate() {
        return this.earnedDate;
    }

    public void setEarnedDate(LocalDateTime earnedDate) {
        this.earnedDate = earnedDate;
    }

    @Column(name = "`ErectionPercentComplete`", nullable = true, scale = 2, precision = 5)
    public Float getErectionPercentComplete() {
        return this.erectionPercentComplete;
    }

    public void setErectionPercentComplete(Float erectionPercentComplete) {
        this.erectionPercentComplete = erectionPercentComplete;
    }

    @Column(name = "`BoltUpPercentComplete`", nullable = true, scale = 2, precision = 5)
    public Float getBoltUpPercentComplete() {
        return this.boltUpPercentComplete;
    }

    public void setBoltUpPercentComplete(Float boltUpPercentComplete) {
        this.boltUpPercentComplete = boltUpPercentComplete;
    }

    @Column(name = "`WeldPercentComplete`", nullable = true, scale = 2, precision = 5)
    public Float getWeldPercentComplete() {
        return this.weldPercentComplete;
    }

    public void setWeldPercentComplete(Float weldPercentComplete) {
        this.weldPercentComplete = weldPercentComplete;
    }

    @Column(name = "`CutPercentComplete`", nullable = true, scale = 2, precision = 5)
    public Float getCutPercentComplete() {
        return this.cutPercentComplete;
    }

    public void setCutPercentComplete(Float cutPercentComplete) {
        this.cutPercentComplete = cutPercentComplete;
    }

    @Column(name = "`TrimPercentComplete`", nullable = true, scale = 2, precision = 5)
    public Float getTrimPercentComplete() {
        return this.trimPercentComplete;
    }

    public void setTrimPercentComplete(Float trimPercentComplete) {
        this.trimPercentComplete = trimPercentComplete;
    }

    @Column(name = "`SupportPercentComplete`", nullable = true, scale = 2, precision = 5)
    public Float getSupportPercentComplete() {
        return this.supportPercentComplete;
    }

    public void setSupportPercentComplete(Float supportPercentComplete) {
        this.supportPercentComplete = supportPercentComplete;
    }

    @Column(name = "`DemoPercentComplete`", nullable = true, scale = 2, precision = 5)
    public Float getDemoPercentComplete() {
        return this.demoPercentComplete;
    }

    public void setDemoPercentComplete(Float demoPercentComplete) {
        this.demoPercentComplete = demoPercentComplete;
    }

    @Column(name = "`MiscPercentComplete`", nullable = true, scale = 2, precision = 5)
    public Float getMiscPercentComplete() {
        return this.miscPercentComplete;
    }

    public void setMiscPercentComplete(Float miscPercentComplete) {
        this.miscPercentComplete = miscPercentComplete;
    }

    @Column(name = "`ReadyForTestingComplete`", nullable = true, scale = 2, precision = 5)
    public Float getReadyForTestingComplete() {
        return this.readyForTestingComplete;
    }

    public void setReadyForTestingComplete(Float readyForTestingComplete) {
        this.readyForTestingComplete = readyForTestingComplete;
    }

    @Column(name = "`HydroComplete`", nullable = true, scale = 2, precision = 5)
    public Float getHydroComplete() {
        return this.hydroComplete;
    }

    public void setHydroComplete(Float hydroComplete) {
        this.hydroComplete = hydroComplete;
    }

    @Column(name = "`ClientTurnoverComplete`", nullable = true, scale = 2, precision = 5)
    public Float getClientTurnoverComplete() {
        return this.clientTurnoverComplete;
    }

    public void setClientTurnoverComplete(Float clientTurnoverComplete) {
        this.clientTurnoverComplete = clientTurnoverComplete;
    }

    @Column(name = "`MechPercentComplete`", nullable = true, scale = 2, precision = 5)
    public Float getMechPercentComplete() {
        return this.mechPercentComplete;
    }

    public void setMechPercentComplete(Float mechPercentComplete) {
        this.mechPercentComplete = mechPercentComplete;
    }

    @Column(name = "`TestingPercentComplete`", nullable = true, scale = 2, precision = 5)
    public Float getTestingPercentComplete() {
        return this.testingPercentComplete;
    }

    public void setTestingPercentComplete(Float testingPercentComplete) {
        this.testingPercentComplete = testingPercentComplete;
    }

    @Column(name = "`TotalPercentComplete`", nullable = true, scale = 2, precision = 5)
    public Float getTotalPercentComplete() {
        return this.totalPercentComplete;
    }

    public void setTotalPercentComplete(Float totalPercentComplete) {
        this.totalPercentComplete = totalPercentComplete;
    }

    @Column(name = "`TotalHoursEarned`", nullable = true, scale = 6, precision = 16)
    public Double getTotalHoursEarned() {
        return this.totalHoursEarned;
    }

    public void setTotalHoursEarned(Double totalHoursEarned) {
        this.totalHoursEarned = totalHoursEarned;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CacheStatsPipePcot)) return false;
        final CacheStatsPipePcot cacheStatsPipePcot = (CacheStatsPipePcot) o;
        return Objects.equals(getId(), cacheStatsPipePcot.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

