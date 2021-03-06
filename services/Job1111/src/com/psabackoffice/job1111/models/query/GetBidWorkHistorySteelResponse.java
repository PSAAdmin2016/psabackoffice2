/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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

public class GetBidWorkHistorySteelResponse implements Serializable {


    @JsonProperty("SubmissionID")
    @ColumnAlias("SubmissionID")
    private Integer submissionId;

    @JsonProperty("BidID")
    @ColumnAlias("BidID")
    private Integer bidId;

    @JsonProperty("ShakeQuantity")
    @ColumnAlias("ShakeQuantity")
    private BigInteger shakeQuantity;

    @JsonProperty("ErectQuantity")
    @ColumnAlias("ErectQuantity")
    private BigInteger erectQuantity;

    @JsonProperty("ErectPercent")
    @ColumnAlias("ErectPercent")
    private BigDecimal erectPercent;

    @JsonProperty("BoltoutQuantity")
    @ColumnAlias("BoltoutQuantity")
    private BigInteger boltoutQuantity;

    @JsonProperty("BoltoutPercent")
    @ColumnAlias("BoltoutPercent")
    private BigDecimal boltoutPercent;

    @JsonProperty("ImpQuantity")
    @ColumnAlias("ImpQuantity")
    private BigInteger impQuantity;

    @JsonProperty("ImpPercent")
    @ColumnAlias("ImpPercent")
    private BigDecimal impPercent;

    @JsonProperty("WeldQuantity")
    @ColumnAlias("WeldQuantity")
    private BigInteger weldQuantity;

    @JsonProperty("WeldPercent")
    @ColumnAlias("WeldPercent")
    private BigDecimal weldPercent;

    @JsonProperty("SellQuantity")
    @ColumnAlias("SellQuantity")
    private BigInteger sellQuantity;

    @JsonProperty("DemoQuantity")
    @ColumnAlias("DemoQuantity")
    private BigDecimal demoQuantity;

    @JsonProperty("MiscQuantity")
    @ColumnAlias("MiscQuantity")
    private BigDecimal miscQuantity;

    @JsonProperty("Foreman")
    @ColumnAlias("Foreman")
    private String foreman;

    @JsonProperty("Supervisor")
    @ColumnAlias("Supervisor")
    private String supervisor;

    @JsonProperty("CompleteTime")
    @ColumnAlias("CompleteTime")
    private Timestamp completeTime;

    @JsonProperty("ReviewedTime")
    @ColumnAlias("ReviewedTime")
    private Timestamp reviewedTime;

    public Integer getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Integer getBidId() {
        return this.bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public BigInteger getShakeQuantity() {
        return this.shakeQuantity;
    }

    public void setShakeQuantity(BigInteger shakeQuantity) {
        this.shakeQuantity = shakeQuantity;
    }

    public BigInteger getErectQuantity() {
        return this.erectQuantity;
    }

    public void setErectQuantity(BigInteger erectQuantity) {
        this.erectQuantity = erectQuantity;
    }

    public BigDecimal getErectPercent() {
        return this.erectPercent;
    }

    public void setErectPercent(BigDecimal erectPercent) {
        this.erectPercent = erectPercent;
    }

    public BigInteger getBoltoutQuantity() {
        return this.boltoutQuantity;
    }

    public void setBoltoutQuantity(BigInteger boltoutQuantity) {
        this.boltoutQuantity = boltoutQuantity;
    }

    public BigDecimal getBoltoutPercent() {
        return this.boltoutPercent;
    }

    public void setBoltoutPercent(BigDecimal boltoutPercent) {
        this.boltoutPercent = boltoutPercent;
    }

    public BigInteger getImpQuantity() {
        return this.impQuantity;
    }

    public void setImpQuantity(BigInteger impQuantity) {
        this.impQuantity = impQuantity;
    }

    public BigDecimal getImpPercent() {
        return this.impPercent;
    }

    public void setImpPercent(BigDecimal impPercent) {
        this.impPercent = impPercent;
    }

    public BigInteger getWeldQuantity() {
        return this.weldQuantity;
    }

    public void setWeldQuantity(BigInteger weldQuantity) {
        this.weldQuantity = weldQuantity;
    }

    public BigDecimal getWeldPercent() {
        return this.weldPercent;
    }

    public void setWeldPercent(BigDecimal weldPercent) {
        this.weldPercent = weldPercent;
    }

    public BigInteger getSellQuantity() {
        return this.sellQuantity;
    }

    public void setSellQuantity(BigInteger sellQuantity) {
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

    public String getForeman() {
        return this.foreman;
    }

    public void setForeman(String foreman) {
        this.foreman = foreman;
    }

    public String getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Timestamp getCompleteTime() {
        return this.completeTime;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    public Timestamp getReviewedTime() {
        return this.reviewedTime;
    }

    public void setReviewedTime(Timestamp reviewedTime) {
        this.reviewedTime = reviewedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetBidWorkHistorySteelResponse)) return false;
        final GetBidWorkHistorySteelResponse getBidWorkHistorySteelResponse = (GetBidWorkHistorySteelResponse) o;
        return Objects.equals(getSubmissionId(), getBidWorkHistorySteelResponse.getSubmissionId()) &&
                Objects.equals(getBidId(), getBidWorkHistorySteelResponse.getBidId()) &&
                Objects.equals(getShakeQuantity(), getBidWorkHistorySteelResponse.getShakeQuantity()) &&
                Objects.equals(getErectQuantity(), getBidWorkHistorySteelResponse.getErectQuantity()) &&
                Objects.equals(getErectPercent(), getBidWorkHistorySteelResponse.getErectPercent()) &&
                Objects.equals(getBoltoutQuantity(), getBidWorkHistorySteelResponse.getBoltoutQuantity()) &&
                Objects.equals(getBoltoutPercent(), getBidWorkHistorySteelResponse.getBoltoutPercent()) &&
                Objects.equals(getImpQuantity(), getBidWorkHistorySteelResponse.getImpQuantity()) &&
                Objects.equals(getImpPercent(), getBidWorkHistorySteelResponse.getImpPercent()) &&
                Objects.equals(getWeldQuantity(), getBidWorkHistorySteelResponse.getWeldQuantity()) &&
                Objects.equals(getWeldPercent(), getBidWorkHistorySteelResponse.getWeldPercent()) &&
                Objects.equals(getSellQuantity(), getBidWorkHistorySteelResponse.getSellQuantity()) &&
                Objects.equals(getDemoQuantity(), getBidWorkHistorySteelResponse.getDemoQuantity()) &&
                Objects.equals(getMiscQuantity(), getBidWorkHistorySteelResponse.getMiscQuantity()) &&
                Objects.equals(getForeman(), getBidWorkHistorySteelResponse.getForeman()) &&
                Objects.equals(getSupervisor(), getBidWorkHistorySteelResponse.getSupervisor()) &&
                Objects.equals(getCompleteTime(), getBidWorkHistorySteelResponse.getCompleteTime()) &&
                Objects.equals(getReviewedTime(), getBidWorkHistorySteelResponse.getReviewedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubmissionId(),
                getBidId(),
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
                getForeman(),
                getSupervisor(),
                getCompleteTime(),
                getReviewedTime());
    }
}
