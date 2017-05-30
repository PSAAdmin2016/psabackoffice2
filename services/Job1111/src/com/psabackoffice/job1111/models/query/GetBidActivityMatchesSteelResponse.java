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

public class GetBidActivityMatchesSteelResponse implements Serializable {

    @JsonProperty("UID")
    @ColumnAlias("UID")
    private Integer uid;
    @JsonProperty("BidID")
    @ColumnAlias("BidID")
    private Integer bidId;
    @JsonProperty("EWONumber")
    @ColumnAlias("EWONumber")
    private Integer ewonumber;
    @JsonProperty("Scope")
    @ColumnAlias("Scope")
    private String scope;
    @JsonProperty("Phase")
    @ColumnAlias("Phase")
    private String phase;
    @JsonProperty("Stage")
    @ColumnAlias("Stage")
    private String stage;
    @JsonProperty("TestPackageNumber")
    @ColumnAlias("TestPackageNumber")
    private String testPackageNumber;
    @JsonProperty("CostCode")
    @ColumnAlias("CostCode")
    private String costCode;
    @JsonProperty("P6ID")
    @ColumnAlias("P6ID")
    private String p6id;
    @JsonProperty("AssignedContractor")
    @ColumnAlias("AssignedContractor")
    private String assignedContractor;
    @JsonProperty("Area")
    @ColumnAlias("Area")
    private String area;
    @JsonProperty("Location")
    @ColumnAlias("Location")
    private String location;
    @JsonProperty("Structure")
    @ColumnAlias("Structure")
    private String structure;
    @JsonProperty("CU")
    @ColumnAlias("CU")
    private String cu;
    @JsonProperty("Elevation")
    @ColumnAlias("Elevation")
    private String elevation;
    @JsonProperty("P6Description")
    @ColumnAlias("P6Description")
    private String p6description;
    @JsonProperty("PieceMark")
    @ColumnAlias("PieceMark")
    private String pieceMark;
    @JsonProperty("PieceMarkRev")
    @ColumnAlias("PieceMarkRev")
    private Short pieceMarkRev;
    @JsonProperty("Description")
    @ColumnAlias("Description")
    private String description;
    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private String activityType;
    @JsonProperty("ClientMaterialSpec")
    @ColumnAlias("ClientMaterialSpec")
    private String clientMaterialSpec;
    @JsonProperty("PerformanceMaterialSpec")
    @ColumnAlias("PerformanceMaterialSpec")
    private String performanceMaterialSpec;
    @JsonProperty("MaterialType")
    @ColumnAlias("MaterialType")
    private String materialType;
    @JsonProperty("Length")
    @ColumnAlias("Length")
    private BigDecimal length;
    @JsonProperty("Weight")
    @ColumnAlias("Weight")
    private BigDecimal weight;
    @JsonProperty("System")
    @ColumnAlias("System")
    private String system;
    @JsonProperty("Service")
    @ColumnAlias("Service")
    private String service;
    @JsonProperty("TakeOffQuantity")
    @ColumnAlias("TakeOffQuantity")
    private BigDecimal takeOffQuantity;
    @JsonProperty("WeldCount")
    @ColumnAlias("WeldCount")
    private BigInteger weldCount;
    @JsonProperty("SteelHours")
    @ColumnAlias("SteelHours")
    private BigDecimal steelHours;
    @JsonProperty("WeldHours")
    @ColumnAlias("WeldHours")
    private BigDecimal weldHours;
    @JsonProperty("WBS1")
    @ColumnAlias("WBS1")
    private String wbs1;
    @JsonProperty("WBS2")
    @ColumnAlias("WBS2")
    private String wbs2;
    @JsonProperty("WBS3")
    @ColumnAlias("WBS3")
    private String wbs3;
    @JsonProperty("WBS4")
    @ColumnAlias("WBS4")
    private String wbs4;
    @JsonProperty("WBS5")
    @ColumnAlias("WBS5")
    private String wbs5;
    @JsonProperty("WBS6")
    @ColumnAlias("WBS6")
    private String wbs6;
    @JsonProperty("WBS7")
    @ColumnAlias("WBS7")
    private String wbs7;
    @JsonProperty("WBS8")
    @ColumnAlias("WBS8")
    private String wbs8;
    @JsonProperty("WBS9")
    @ColumnAlias("WBS9")
    private String wbs9;
    @JsonProperty("WBS10")
    @ColumnAlias("WBS10")
    private String wbs10;

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBidId() {
        return this.bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Integer getEwonumber() {
        return this.ewonumber;
    }

    public void setEwonumber(Integer ewonumber) {
        this.ewonumber = ewonumber;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getPhase() {
        return this.phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStage() {
        return this.stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getTestPackageNumber() {
        return this.testPackageNumber;
    }

    public void setTestPackageNumber(String testPackageNumber) {
        this.testPackageNumber = testPackageNumber;
    }

    public String getCostCode() {
        return this.costCode;
    }

    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }

    public String getP6id() {
        return this.p6id;
    }

    public void setP6id(String p6id) {
        this.p6id = p6id;
    }

    public String getAssignedContractor() {
        return this.assignedContractor;
    }

    public void setAssignedContractor(String assignedContractor) {
        this.assignedContractor = assignedContractor;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStructure() {
        return this.structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getCu() {
        return this.cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public String getElevation() {
        return this.elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getP6description() {
        return this.p6description;
    }

    public void setP6description(String p6description) {
        this.p6description = p6description;
    }

    public String getPieceMark() {
        return this.pieceMark;
    }

    public void setPieceMark(String pieceMark) {
        this.pieceMark = pieceMark;
    }

    public Short getPieceMarkRev() {
        return this.pieceMarkRev;
    }

    public void setPieceMarkRev(Short pieceMarkRev) {
        this.pieceMarkRev = pieceMarkRev;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getClientMaterialSpec() {
        return this.clientMaterialSpec;
    }

    public void setClientMaterialSpec(String clientMaterialSpec) {
        this.clientMaterialSpec = clientMaterialSpec;
    }

    public String getPerformanceMaterialSpec() {
        return this.performanceMaterialSpec;
    }

    public void setPerformanceMaterialSpec(String performanceMaterialSpec) {
        this.performanceMaterialSpec = performanceMaterialSpec;
    }

    public String getMaterialType() {
        return this.materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public BigDecimal getLength() {
        return this.length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWeight() {
        return this.weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getSystem() {
        return this.system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public BigDecimal getTakeOffQuantity() {
        return this.takeOffQuantity;
    }

    public void setTakeOffQuantity(BigDecimal takeOffQuantity) {
        this.takeOffQuantity = takeOffQuantity;
    }

    public BigInteger getWeldCount() {
        return this.weldCount;
    }

    public void setWeldCount(BigInteger weldCount) {
        this.weldCount = weldCount;
    }

    public BigDecimal getSteelHours() {
        return this.steelHours;
    }

    public void setSteelHours(BigDecimal steelHours) {
        this.steelHours = steelHours;
    }

    public BigDecimal getWeldHours() {
        return this.weldHours;
    }

    public void setWeldHours(BigDecimal weldHours) {
        this.weldHours = weldHours;
    }

    public String getWbs1() {
        return this.wbs1;
    }

    public void setWbs1(String wbs1) {
        this.wbs1 = wbs1;
    }

    public String getWbs2() {
        return this.wbs2;
    }

    public void setWbs2(String wbs2) {
        this.wbs2 = wbs2;
    }

    public String getWbs3() {
        return this.wbs3;
    }

    public void setWbs3(String wbs3) {
        this.wbs3 = wbs3;
    }

    public String getWbs4() {
        return this.wbs4;
    }

    public void setWbs4(String wbs4) {
        this.wbs4 = wbs4;
    }

    public String getWbs5() {
        return this.wbs5;
    }

    public void setWbs5(String wbs5) {
        this.wbs5 = wbs5;
    }

    public String getWbs6() {
        return this.wbs6;
    }

    public void setWbs6(String wbs6) {
        this.wbs6 = wbs6;
    }

    public String getWbs7() {
        return this.wbs7;
    }

    public void setWbs7(String wbs7) {
        this.wbs7 = wbs7;
    }

    public String getWbs8() {
        return this.wbs8;
    }

    public void setWbs8(String wbs8) {
        this.wbs8 = wbs8;
    }

    public String getWbs9() {
        return this.wbs9;
    }

    public void setWbs9(String wbs9) {
        this.wbs9 = wbs9;
    }

    public String getWbs10() {
        return this.wbs10;
    }

    public void setWbs10(String wbs10) {
        this.wbs10 = wbs10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetBidActivityMatchesSteelResponse)) return false;
        final GetBidActivityMatchesSteelResponse getBidActivityMatchesSteelResponse = (GetBidActivityMatchesSteelResponse) o;
        return Objects.equals(getUid(), getBidActivityMatchesSteelResponse.getUid()) &&
                Objects.equals(getBidId(), getBidActivityMatchesSteelResponse.getBidId()) &&
                Objects.equals(getEwonumber(), getBidActivityMatchesSteelResponse.getEwonumber()) &&
                Objects.equals(getScope(), getBidActivityMatchesSteelResponse.getScope()) &&
                Objects.equals(getPhase(), getBidActivityMatchesSteelResponse.getPhase()) &&
                Objects.equals(getStage(), getBidActivityMatchesSteelResponse.getStage()) &&
                Objects.equals(getTestPackageNumber(), getBidActivityMatchesSteelResponse.getTestPackageNumber()) &&
                Objects.equals(getCostCode(), getBidActivityMatchesSteelResponse.getCostCode()) &&
                Objects.equals(getP6id(), getBidActivityMatchesSteelResponse.getP6id()) &&
                Objects.equals(getAssignedContractor(), getBidActivityMatchesSteelResponse.getAssignedContractor()) &&
                Objects.equals(getArea(), getBidActivityMatchesSteelResponse.getArea()) &&
                Objects.equals(getLocation(), getBidActivityMatchesSteelResponse.getLocation()) &&
                Objects.equals(getStructure(), getBidActivityMatchesSteelResponse.getStructure()) &&
                Objects.equals(getCu(), getBidActivityMatchesSteelResponse.getCu()) &&
                Objects.equals(getElevation(), getBidActivityMatchesSteelResponse.getElevation()) &&
                Objects.equals(getP6description(), getBidActivityMatchesSteelResponse.getP6description()) &&
                Objects.equals(getPieceMark(), getBidActivityMatchesSteelResponse.getPieceMark()) &&
                Objects.equals(getPieceMarkRev(), getBidActivityMatchesSteelResponse.getPieceMarkRev()) &&
                Objects.equals(getDescription(), getBidActivityMatchesSteelResponse.getDescription()) &&
                Objects.equals(getActivityType(), getBidActivityMatchesSteelResponse.getActivityType()) &&
                Objects.equals(getClientMaterialSpec(), getBidActivityMatchesSteelResponse.getClientMaterialSpec()) &&
                Objects.equals(getPerformanceMaterialSpec(), getBidActivityMatchesSteelResponse.getPerformanceMaterialSpec()) &&
                Objects.equals(getMaterialType(), getBidActivityMatchesSteelResponse.getMaterialType()) &&
                Objects.equals(getLength(), getBidActivityMatchesSteelResponse.getLength()) &&
                Objects.equals(getWeight(), getBidActivityMatchesSteelResponse.getWeight()) &&
                Objects.equals(getSystem(), getBidActivityMatchesSteelResponse.getSystem()) &&
                Objects.equals(getService(), getBidActivityMatchesSteelResponse.getService()) &&
                Objects.equals(getTakeOffQuantity(), getBidActivityMatchesSteelResponse.getTakeOffQuantity()) &&
                Objects.equals(getWeldCount(), getBidActivityMatchesSteelResponse.getWeldCount()) &&
                Objects.equals(getSteelHours(), getBidActivityMatchesSteelResponse.getSteelHours()) &&
                Objects.equals(getWeldHours(), getBidActivityMatchesSteelResponse.getWeldHours()) &&
                Objects.equals(getWbs1(), getBidActivityMatchesSteelResponse.getWbs1()) &&
                Objects.equals(getWbs2(), getBidActivityMatchesSteelResponse.getWbs2()) &&
                Objects.equals(getWbs3(), getBidActivityMatchesSteelResponse.getWbs3()) &&
                Objects.equals(getWbs4(), getBidActivityMatchesSteelResponse.getWbs4()) &&
                Objects.equals(getWbs5(), getBidActivityMatchesSteelResponse.getWbs5()) &&
                Objects.equals(getWbs6(), getBidActivityMatchesSteelResponse.getWbs6()) &&
                Objects.equals(getWbs7(), getBidActivityMatchesSteelResponse.getWbs7()) &&
                Objects.equals(getWbs8(), getBidActivityMatchesSteelResponse.getWbs8()) &&
                Objects.equals(getWbs9(), getBidActivityMatchesSteelResponse.getWbs9()) &&
                Objects.equals(getWbs10(), getBidActivityMatchesSteelResponse.getWbs10());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(),
                getBidId(),
                getEwonumber(),
                getScope(),
                getPhase(),
                getStage(),
                getTestPackageNumber(),
                getCostCode(),
                getP6id(),
                getAssignedContractor(),
                getArea(),
                getLocation(),
                getStructure(),
                getCu(),
                getElevation(),
                getP6description(),
                getPieceMark(),
                getPieceMarkRev(),
                getDescription(),
                getActivityType(),
                getClientMaterialSpec(),
                getPerformanceMaterialSpec(),
                getMaterialType(),
                getLength(),
                getWeight(),
                getSystem(),
                getService(),
                getTakeOffQuantity(),
                getWeldCount(),
                getSteelHours(),
                getWeldHours(),
                getWbs1(),
                getWbs2(),
                getWbs3(),
                getWbs4(),
                getWbs5(),
                getWbs6(),
                getWbs7(),
                getWbs8(),
                getWbs9(),
                getWbs10());
    }
}
