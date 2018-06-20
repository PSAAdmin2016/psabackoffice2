/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class ClassicTrackerCivilUpdateResponseContent implements Serializable {


    @JsonProperty("UID")
    @ColumnAlias("UID")
    private Integer uid;

    @JsonProperty("BidID")
    @ColumnAlias("BidID")
    private Integer bidId;

    @JsonProperty("ProjectServicesRep")
    @ColumnAlias("ProjectServicesRep")
    private String projectServicesRep;

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

    @JsonProperty("WorkPackage")
    @ColumnAlias("WorkPackage")
    private String workPackage;

    @JsonProperty("CostCode")
    @ColumnAlias("CostCode")
    private String costCode;

    @JsonProperty("P6ID")
    @ColumnAlias("P6ID")
    private String p6id;

    @JsonProperty("P6Description")
    @ColumnAlias("P6Description")
    private String p6description;

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

    @JsonProperty("SortGroup1")
    @ColumnAlias("SortGroup1")
    private String sortGroup1;

    @JsonProperty("SortGroup2")
    @ColumnAlias("SortGroup2")
    private String sortGroup2;

    @JsonProperty("SortGroup3")
    @ColumnAlias("SortGroup3")
    private String sortGroup3;

    @JsonProperty("EngDrawingNumber")
    @ColumnAlias("EngDrawingNumber")
    private String engDrawingNumber;

    @JsonProperty("SheetNumber")
    @ColumnAlias("SheetNumber")
    private Short sheetNumber;

    @JsonProperty("DrawingRev")
    @ColumnAlias("DrawingRev")
    private Short drawingRev;

    @JsonProperty("DetailDrawingNumber")
    @ColumnAlias("DetailDrawingNumber")
    private String detailDrawingNumber;

    @JsonProperty("DetailRev")
    @ColumnAlias("DetailRev")
    private Short detailRev;

    @JsonProperty("DetailName")
    @ColumnAlias("DetailName")
    private String detailName;

    @JsonProperty("Description")
    @ColumnAlias("Description")
    private String description;

    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private String activityType;

    @JsonProperty("ActivitySubType")
    @ColumnAlias("ActivitySubType")
    private String activitySubType;

    @JsonProperty("System")
    @ColumnAlias("System")
    private String system;

    @JsonProperty("Service")
    @ColumnAlias("Service")
    private String service;

    @JsonProperty("TakeOffQuantity")
    @ColumnAlias("TakeOffQuantity")
    private Double takeOffQuantity;

    @JsonProperty("QuantityUnit")
    @ColumnAlias("QuantityUnit")
    private String quantityUnit;

    @JsonProperty("EstimatedHours")
    @ColumnAlias("EstimatedHours")
    private BigDecimal estimatedHours;

    @JsonProperty("HoursCivilWork")
    @ColumnAlias("HoursCivilWork")
    private BigDecimal hoursCivilWork;

    @JsonProperty("HoursSellPunch")
    @ColumnAlias("HoursSellPunch")
    private BigDecimal hoursSellPunch;

    @JsonProperty("InstalledQuantity")
    @ColumnAlias("InstalledQuantity")
    private Double installedQuantity;

    @JsonProperty("EarnedWorkHours")
    @ColumnAlias("EarnedWorkHours")
    private BigDecimal earnedWorkHours;

    @JsonProperty("EarnedSellPunch")
    @ColumnAlias("EarnedSellPunch")
    private BigDecimal earnedSellPunch;

    @JsonProperty("EarnedAllHours")
    @ColumnAlias("EarnedAllHours")
    private BigDecimal earnedAllHours;

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

    @JsonProperty("TimeStamp")
    @ColumnAlias("TimeStamp")
    private Timestamp timeStamp;

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

    public String getProjectServicesRep() {
        return this.projectServicesRep;
    }

    public void setProjectServicesRep(String projectServicesRep) {
        this.projectServicesRep = projectServicesRep;
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

    public String getWorkPackage() {
        return this.workPackage;
    }

    public void setWorkPackage(String workPackage) {
        this.workPackage = workPackage;
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

    public String getP6description() {
        return this.p6description;
    }

    public void setP6description(String p6description) {
        this.p6description = p6description;
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

    public String getSortGroup1() {
        return this.sortGroup1;
    }

    public void setSortGroup1(String sortGroup1) {
        this.sortGroup1 = sortGroup1;
    }

    public String getSortGroup2() {
        return this.sortGroup2;
    }

    public void setSortGroup2(String sortGroup2) {
        this.sortGroup2 = sortGroup2;
    }

    public String getSortGroup3() {
        return this.sortGroup3;
    }

    public void setSortGroup3(String sortGroup3) {
        this.sortGroup3 = sortGroup3;
    }

    public String getEngDrawingNumber() {
        return this.engDrawingNumber;
    }

    public void setEngDrawingNumber(String engDrawingNumber) {
        this.engDrawingNumber = engDrawingNumber;
    }

    public Short getSheetNumber() {
        return this.sheetNumber;
    }

    public void setSheetNumber(Short sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    public Short getDrawingRev() {
        return this.drawingRev;
    }

    public void setDrawingRev(Short drawingRev) {
        this.drawingRev = drawingRev;
    }

    public String getDetailDrawingNumber() {
        return this.detailDrawingNumber;
    }

    public void setDetailDrawingNumber(String detailDrawingNumber) {
        this.detailDrawingNumber = detailDrawingNumber;
    }

    public Short getDetailRev() {
        return this.detailRev;
    }

    public void setDetailRev(Short detailRev) {
        this.detailRev = detailRev;
    }

    public String getDetailName() {
        return this.detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
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

    public String getActivitySubType() {
        return this.activitySubType;
    }

    public void setActivitySubType(String activitySubType) {
        this.activitySubType = activitySubType;
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

    public Double getTakeOffQuantity() {
        return this.takeOffQuantity;
    }

    public void setTakeOffQuantity(Double takeOffQuantity) {
        this.takeOffQuantity = takeOffQuantity;
    }

    public String getQuantityUnit() {
        return this.quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public BigDecimal getEstimatedHours() {
        return this.estimatedHours;
    }

    public void setEstimatedHours(BigDecimal estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public BigDecimal getHoursCivilWork() {
        return this.hoursCivilWork;
    }

    public void setHoursCivilWork(BigDecimal hoursCivilWork) {
        this.hoursCivilWork = hoursCivilWork;
    }

    public BigDecimal getHoursSellPunch() {
        return this.hoursSellPunch;
    }

    public void setHoursSellPunch(BigDecimal hoursSellPunch) {
        this.hoursSellPunch = hoursSellPunch;
    }

    public Double getInstalledQuantity() {
        return this.installedQuantity;
    }

    public void setInstalledQuantity(Double installedQuantity) {
        this.installedQuantity = installedQuantity;
    }

    public BigDecimal getEarnedWorkHours() {
        return this.earnedWorkHours;
    }

    public void setEarnedWorkHours(BigDecimal earnedWorkHours) {
        this.earnedWorkHours = earnedWorkHours;
    }

    public BigDecimal getEarnedSellPunch() {
        return this.earnedSellPunch;
    }

    public void setEarnedSellPunch(BigDecimal earnedSellPunch) {
        this.earnedSellPunch = earnedSellPunch;
    }

    public BigDecimal getEarnedAllHours() {
        return this.earnedAllHours;
    }

    public void setEarnedAllHours(BigDecimal earnedAllHours) {
        this.earnedAllHours = earnedAllHours;
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

    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassicTrackerCivilUpdateResponseContent)) return false;
        final ClassicTrackerCivilUpdateResponseContent classicTrackerCivilUpdateResponseContent = (ClassicTrackerCivilUpdateResponseContent) o;
        return Objects.equals(getUid(), classicTrackerCivilUpdateResponseContent.getUid()) &&
                Objects.equals(getBidId(), classicTrackerCivilUpdateResponseContent.getBidId()) &&
                Objects.equals(getProjectServicesRep(), classicTrackerCivilUpdateResponseContent.getProjectServicesRep()) &&
                Objects.equals(getEwonumber(), classicTrackerCivilUpdateResponseContent.getEwonumber()) &&
                Objects.equals(getScope(), classicTrackerCivilUpdateResponseContent.getScope()) &&
                Objects.equals(getPhase(), classicTrackerCivilUpdateResponseContent.getPhase()) &&
                Objects.equals(getStage(), classicTrackerCivilUpdateResponseContent.getStage()) &&
                Objects.equals(getTestPackageNumber(), classicTrackerCivilUpdateResponseContent.getTestPackageNumber()) &&
                Objects.equals(getWorkPackage(), classicTrackerCivilUpdateResponseContent.getWorkPackage()) &&
                Objects.equals(getCostCode(), classicTrackerCivilUpdateResponseContent.getCostCode()) &&
                Objects.equals(getP6id(), classicTrackerCivilUpdateResponseContent.getP6id()) &&
                Objects.equals(getP6description(), classicTrackerCivilUpdateResponseContent.getP6description()) &&
                Objects.equals(getAssignedContractor(), classicTrackerCivilUpdateResponseContent.getAssignedContractor()) &&
                Objects.equals(getArea(), classicTrackerCivilUpdateResponseContent.getArea()) &&
                Objects.equals(getLocation(), classicTrackerCivilUpdateResponseContent.getLocation()) &&
                Objects.equals(getStructure(), classicTrackerCivilUpdateResponseContent.getStructure()) &&
                Objects.equals(getCu(), classicTrackerCivilUpdateResponseContent.getCu()) &&
                Objects.equals(getElevation(), classicTrackerCivilUpdateResponseContent.getElevation()) &&
                Objects.equals(getSortGroup1(), classicTrackerCivilUpdateResponseContent.getSortGroup1()) &&
                Objects.equals(getSortGroup2(), classicTrackerCivilUpdateResponseContent.getSortGroup2()) &&
                Objects.equals(getSortGroup3(), classicTrackerCivilUpdateResponseContent.getSortGroup3()) &&
                Objects.equals(getEngDrawingNumber(), classicTrackerCivilUpdateResponseContent.getEngDrawingNumber()) &&
                Objects.equals(getSheetNumber(), classicTrackerCivilUpdateResponseContent.getSheetNumber()) &&
                Objects.equals(getDrawingRev(), classicTrackerCivilUpdateResponseContent.getDrawingRev()) &&
                Objects.equals(getDetailDrawingNumber(), classicTrackerCivilUpdateResponseContent.getDetailDrawingNumber()) &&
                Objects.equals(getDetailRev(), classicTrackerCivilUpdateResponseContent.getDetailRev()) &&
                Objects.equals(getDetailName(), classicTrackerCivilUpdateResponseContent.getDetailName()) &&
                Objects.equals(getDescription(), classicTrackerCivilUpdateResponseContent.getDescription()) &&
                Objects.equals(getActivityType(), classicTrackerCivilUpdateResponseContent.getActivityType()) &&
                Objects.equals(getActivitySubType(), classicTrackerCivilUpdateResponseContent.getActivitySubType()) &&
                Objects.equals(getSystem(), classicTrackerCivilUpdateResponseContent.getSystem()) &&
                Objects.equals(getService(), classicTrackerCivilUpdateResponseContent.getService()) &&
                Objects.equals(getTakeOffQuantity(), classicTrackerCivilUpdateResponseContent.getTakeOffQuantity()) &&
                Objects.equals(getQuantityUnit(), classicTrackerCivilUpdateResponseContent.getQuantityUnit()) &&
                Objects.equals(getEstimatedHours(), classicTrackerCivilUpdateResponseContent.getEstimatedHours()) &&
                Objects.equals(getHoursCivilWork(), classicTrackerCivilUpdateResponseContent.getHoursCivilWork()) &&
                Objects.equals(getHoursSellPunch(), classicTrackerCivilUpdateResponseContent.getHoursSellPunch()) &&
                Objects.equals(getInstalledQuantity(), classicTrackerCivilUpdateResponseContent.getInstalledQuantity()) &&
                Objects.equals(getEarnedWorkHours(), classicTrackerCivilUpdateResponseContent.getEarnedWorkHours()) &&
                Objects.equals(getEarnedSellPunch(), classicTrackerCivilUpdateResponseContent.getEarnedSellPunch()) &&
                Objects.equals(getEarnedAllHours(), classicTrackerCivilUpdateResponseContent.getEarnedAllHours()) &&
                Objects.equals(getWbs1(), classicTrackerCivilUpdateResponseContent.getWbs1()) &&
                Objects.equals(getWbs2(), classicTrackerCivilUpdateResponseContent.getWbs2()) &&
                Objects.equals(getWbs3(), classicTrackerCivilUpdateResponseContent.getWbs3()) &&
                Objects.equals(getWbs4(), classicTrackerCivilUpdateResponseContent.getWbs4()) &&
                Objects.equals(getWbs5(), classicTrackerCivilUpdateResponseContent.getWbs5()) &&
                Objects.equals(getWbs6(), classicTrackerCivilUpdateResponseContent.getWbs6()) &&
                Objects.equals(getWbs7(), classicTrackerCivilUpdateResponseContent.getWbs7()) &&
                Objects.equals(getWbs8(), classicTrackerCivilUpdateResponseContent.getWbs8()) &&
                Objects.equals(getWbs9(), classicTrackerCivilUpdateResponseContent.getWbs9()) &&
                Objects.equals(getWbs10(), classicTrackerCivilUpdateResponseContent.getWbs10()) &&
                Objects.equals(getTimeStamp(), classicTrackerCivilUpdateResponseContent.getTimeStamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(),
                getBidId(),
                getProjectServicesRep(),
                getEwonumber(),
                getScope(),
                getPhase(),
                getStage(),
                getTestPackageNumber(),
                getWorkPackage(),
                getCostCode(),
                getP6id(),
                getP6description(),
                getAssignedContractor(),
                getArea(),
                getLocation(),
                getStructure(),
                getCu(),
                getElevation(),
                getSortGroup1(),
                getSortGroup2(),
                getSortGroup3(),
                getEngDrawingNumber(),
                getSheetNumber(),
                getDrawingRev(),
                getDetailDrawingNumber(),
                getDetailRev(),
                getDetailName(),
                getDescription(),
                getActivityType(),
                getActivitySubType(),
                getSystem(),
                getService(),
                getTakeOffQuantity(),
                getQuantityUnit(),
                getEstimatedHours(),
                getHoursCivilWork(),
                getHoursSellPunch(),
                getInstalledQuantity(),
                getEarnedWorkHours(),
                getEarnedSellPunch(),
                getEarnedAllHours(),
                getWbs1(),
                getWbs2(),
                getWbs3(),
                getWbs4(),
                getWbs5(),
                getWbs6(),
                getWbs7(),
                getWbs8(),
                getWbs9(),
                getWbs10(),
                getTimeStamp());
    }
}
