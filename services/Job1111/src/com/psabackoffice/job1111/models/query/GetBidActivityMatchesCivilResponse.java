/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetBidActivityMatchesCivilResponse implements Serializable {


    @JsonProperty("ActivitySubType")
    @ColumnAlias("ActivitySubType")
    private String activitySubType;

    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private String activityType;

    @JsonProperty("Area")
    @ColumnAlias("Area")
    private String area;

    @JsonProperty("AssignedContractor")
    @ColumnAlias("AssignedContractor")
    private String assignedContractor;

    @JsonProperty("BidID")
    @ColumnAlias("BidID")
    private Integer bidId;

    @JsonProperty("CU")
    @ColumnAlias("CU")
    private String cu;

    @JsonProperty("CostCode")
    @ColumnAlias("CostCode")
    private String costCode;

    @JsonProperty("Description")
    @ColumnAlias("Description")
    private String description;

    @JsonProperty("DetailDrawingNumber")
    @ColumnAlias("DetailDrawingNumber")
    private String detailDrawingNumber;

    @JsonProperty("DetailName")
    @ColumnAlias("DetailName")
    private String detailName;

    @JsonProperty("DetailRev")
    @ColumnAlias("DetailRev")
    private Byte detailRev;

    @JsonProperty("DrawingRev")
    @ColumnAlias("DrawingRev")
    private Byte drawingRev;

    @JsonProperty("EWONumber")
    @ColumnAlias("EWONumber")
    private Integer ewonumber;

    @JsonProperty("EngDrawingNumber")
    @ColumnAlias("EngDrawingNumber")
    private String engDrawingNumber;

    @JsonProperty("EstimatedHours")
    @ColumnAlias("EstimatedHours")
    private BigDecimal estimatedHours;

    @JsonProperty("FoundationDescription")
    @ColumnAlias("FoundationDescription")
    private String foundationDescription;

    @JsonProperty("Grouping")
    @ColumnAlias("Grouping")
    private String grouping;

    @JsonProperty("Location")
    @ColumnAlias("Location")
    private String location;

    @JsonProperty("P6Description")
    @ColumnAlias("P6Description")
    private String p6description;

    @JsonProperty("P6ID")
    @ColumnAlias("P6ID")
    private String p6id;

    @JsonProperty("Phase")
    @ColumnAlias("Phase")
    private String phase;

    @JsonProperty("QuantityUnit")
    @ColumnAlias("QuantityUnit")
    private String quantityUnit;

    @JsonProperty("Scope")
    @ColumnAlias("Scope")
    private String scope;

    @JsonProperty("Service")
    @ColumnAlias("Service")
    private String service;

    @JsonProperty("SheetNumber")
    @ColumnAlias("SheetNumber")
    private Byte sheetNumber;

    @JsonProperty("Stage")
    @ColumnAlias("Stage")
    private String stage;

    @JsonProperty("Structure")
    @ColumnAlias("Structure")
    private String structure;

    @JsonProperty("System")
    @ColumnAlias("System")
    private String system;

    @JsonProperty("TakeOffQuantity")
    @ColumnAlias("TakeOffQuantity")
    private BigDecimal takeOffQuantity;

    @JsonProperty("TestPackageNumber")
    @ColumnAlias("TestPackageNumber")
    private String testPackageNumber;

    @JsonProperty("UID")
    @ColumnAlias("UID")
    private Integer uid;

    @JsonProperty("WBS1")
    @ColumnAlias("WBS1")
    private String wbs1;

    @JsonProperty("WBS10")
    @ColumnAlias("WBS10")
    private String wbs10;

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

    public String getActivitySubType() {
        return this.activitySubType;
    }

    public void setActivitySubType(String activitySubType) {
        this.activitySubType = activitySubType;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAssignedContractor() {
        return this.assignedContractor;
    }

    public void setAssignedContractor(String assignedContractor) {
        this.assignedContractor = assignedContractor;
    }

    public Integer getBidId() {
        return this.bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public String getCu() {
        return this.cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public String getCostCode() {
        return this.costCode;
    }

    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailDrawingNumber() {
        return this.detailDrawingNumber;
    }

    public void setDetailDrawingNumber(String detailDrawingNumber) {
        this.detailDrawingNumber = detailDrawingNumber;
    }

    public String getDetailName() {
        return this.detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public Byte getDetailRev() {
        return this.detailRev;
    }

    public void setDetailRev(Byte detailRev) {
        this.detailRev = detailRev;
    }

    public Byte getDrawingRev() {
        return this.drawingRev;
    }

    public void setDrawingRev(Byte drawingRev) {
        this.drawingRev = drawingRev;
    }

    public Integer getEwonumber() {
        return this.ewonumber;
    }

    public void setEwonumber(Integer ewonumber) {
        this.ewonumber = ewonumber;
    }

    public String getEngDrawingNumber() {
        return this.engDrawingNumber;
    }

    public void setEngDrawingNumber(String engDrawingNumber) {
        this.engDrawingNumber = engDrawingNumber;
    }

    public BigDecimal getEstimatedHours() {
        return this.estimatedHours;
    }

    public void setEstimatedHours(BigDecimal estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public String getFoundationDescription() {
        return this.foundationDescription;
    }

    public void setFoundationDescription(String foundationDescription) {
        this.foundationDescription = foundationDescription;
    }

    public String getGrouping() {
        return this.grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getP6description() {
        return this.p6description;
    }

    public void setP6description(String p6description) {
        this.p6description = p6description;
    }

    public String getP6id() {
        return this.p6id;
    }

    public void setP6id(String p6id) {
        this.p6id = p6id;
    }

    public String getPhase() {
        return this.phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getQuantityUnit() {
        return this.quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Byte getSheetNumber() {
        return this.sheetNumber;
    }

    public void setSheetNumber(Byte sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    public String getStage() {
        return this.stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getStructure() {
        return this.structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getSystem() {
        return this.system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public BigDecimal getTakeOffQuantity() {
        return this.takeOffQuantity;
    }

    public void setTakeOffQuantity(BigDecimal takeOffQuantity) {
        this.takeOffQuantity = takeOffQuantity;
    }

    public String getTestPackageNumber() {
        return this.testPackageNumber;
    }

    public void setTestPackageNumber(String testPackageNumber) {
        this.testPackageNumber = testPackageNumber;
    }

    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getWbs1() {
        return this.wbs1;
    }

    public void setWbs1(String wbs1) {
        this.wbs1 = wbs1;
    }

    public String getWbs10() {
        return this.wbs10;
    }

    public void setWbs10(String wbs10) {
        this.wbs10 = wbs10;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetBidActivityMatchesCivilResponse)) return false;
        final GetBidActivityMatchesCivilResponse getBidActivityMatchesCivilResponse = (GetBidActivityMatchesCivilResponse) o;
        return Objects.equals(getActivitySubType(), getBidActivityMatchesCivilResponse.getActivitySubType()) &&
                Objects.equals(getActivityType(), getBidActivityMatchesCivilResponse.getActivityType()) &&
                Objects.equals(getArea(), getBidActivityMatchesCivilResponse.getArea()) &&
                Objects.equals(getAssignedContractor(), getBidActivityMatchesCivilResponse.getAssignedContractor()) &&
                Objects.equals(getBidId(), getBidActivityMatchesCivilResponse.getBidId()) &&
                Objects.equals(getCu(), getBidActivityMatchesCivilResponse.getCu()) &&
                Objects.equals(getCostCode(), getBidActivityMatchesCivilResponse.getCostCode()) &&
                Objects.equals(getDescription(), getBidActivityMatchesCivilResponse.getDescription()) &&
                Objects.equals(getDetailDrawingNumber(), getBidActivityMatchesCivilResponse.getDetailDrawingNumber()) &&
                Objects.equals(getDetailName(), getBidActivityMatchesCivilResponse.getDetailName()) &&
                Objects.equals(getDetailRev(), getBidActivityMatchesCivilResponse.getDetailRev()) &&
                Objects.equals(getDrawingRev(), getBidActivityMatchesCivilResponse.getDrawingRev()) &&
                Objects.equals(getEwonumber(), getBidActivityMatchesCivilResponse.getEwonumber()) &&
                Objects.equals(getEngDrawingNumber(), getBidActivityMatchesCivilResponse.getEngDrawingNumber()) &&
                Objects.equals(getEstimatedHours(), getBidActivityMatchesCivilResponse.getEstimatedHours()) &&
                Objects.equals(getFoundationDescription(), getBidActivityMatchesCivilResponse.getFoundationDescription()) &&
                Objects.equals(getGrouping(), getBidActivityMatchesCivilResponse.getGrouping()) &&
                Objects.equals(getLocation(), getBidActivityMatchesCivilResponse.getLocation()) &&
                Objects.equals(getP6description(), getBidActivityMatchesCivilResponse.getP6description()) &&
                Objects.equals(getP6id(), getBidActivityMatchesCivilResponse.getP6id()) &&
                Objects.equals(getPhase(), getBidActivityMatchesCivilResponse.getPhase()) &&
                Objects.equals(getQuantityUnit(), getBidActivityMatchesCivilResponse.getQuantityUnit()) &&
                Objects.equals(getScope(), getBidActivityMatchesCivilResponse.getScope()) &&
                Objects.equals(getService(), getBidActivityMatchesCivilResponse.getService()) &&
                Objects.equals(getSheetNumber(), getBidActivityMatchesCivilResponse.getSheetNumber()) &&
                Objects.equals(getStage(), getBidActivityMatchesCivilResponse.getStage()) &&
                Objects.equals(getStructure(), getBidActivityMatchesCivilResponse.getStructure()) &&
                Objects.equals(getSystem(), getBidActivityMatchesCivilResponse.getSystem()) &&
                Objects.equals(getTakeOffQuantity(), getBidActivityMatchesCivilResponse.getTakeOffQuantity()) &&
                Objects.equals(getTestPackageNumber(), getBidActivityMatchesCivilResponse.getTestPackageNumber()) &&
                Objects.equals(getUid(), getBidActivityMatchesCivilResponse.getUid()) &&
                Objects.equals(getWbs1(), getBidActivityMatchesCivilResponse.getWbs1()) &&
                Objects.equals(getWbs10(), getBidActivityMatchesCivilResponse.getWbs10()) &&
                Objects.equals(getWbs2(), getBidActivityMatchesCivilResponse.getWbs2()) &&
                Objects.equals(getWbs3(), getBidActivityMatchesCivilResponse.getWbs3()) &&
                Objects.equals(getWbs4(), getBidActivityMatchesCivilResponse.getWbs4()) &&
                Objects.equals(getWbs5(), getBidActivityMatchesCivilResponse.getWbs5()) &&
                Objects.equals(getWbs6(), getBidActivityMatchesCivilResponse.getWbs6()) &&
                Objects.equals(getWbs7(), getBidActivityMatchesCivilResponse.getWbs7()) &&
                Objects.equals(getWbs8(), getBidActivityMatchesCivilResponse.getWbs8()) &&
                Objects.equals(getWbs9(), getBidActivityMatchesCivilResponse.getWbs9());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivitySubType(),
                getActivityType(),
                getArea(),
                getAssignedContractor(),
                getBidId(),
                getCu(),
                getCostCode(),
                getDescription(),
                getDetailDrawingNumber(),
                getDetailName(),
                getDetailRev(),
                getDrawingRev(),
                getEwonumber(),
                getEngDrawingNumber(),
                getEstimatedHours(),
                getFoundationDescription(),
                getGrouping(),
                getLocation(),
                getP6description(),
                getP6id(),
                getPhase(),
                getQuantityUnit(),
                getScope(),
                getService(),
                getSheetNumber(),
                getStage(),
                getStructure(),
                getSystem(),
                getTakeOffQuantity(),
                getTestPackageNumber(),
                getUid(),
                getWbs1(),
                getWbs10(),
                getWbs2(),
                getWbs3(),
                getWbs4(),
                getWbs5(),
                getWbs6(),
                getWbs7(),
                getWbs8(),
                getWbs9());
    }
}
