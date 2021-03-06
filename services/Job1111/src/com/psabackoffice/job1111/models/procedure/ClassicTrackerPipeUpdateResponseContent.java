/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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

public class ClassicTrackerPipeUpdateResponseContent implements Serializable {


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
    private String ewonumber;

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

    @JsonProperty("LineNumber")
    @ColumnAlias("LineNumber")
    private String lineNumber;

    @JsonProperty("EngDrawingNumber")
    @ColumnAlias("EngDrawingNumber")
    private String engDrawingNumber;

    @JsonProperty("SheetNumber")
    @ColumnAlias("SheetNumber")
    private Short sheetNumber;

    @JsonProperty("DrawingRev")
    @ColumnAlias("DrawingRev")
    private Short drawingRev;

    @JsonProperty("Description")
    @ColumnAlias("Description")
    private String description;

    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private String activityType;

    @JsonProperty("ActivitySubType")
    @ColumnAlias("ActivitySubType")
    private String activitySubType;

    @JsonProperty("ClientMaterialSpec")
    @ColumnAlias("ClientMaterialSpec")
    private String clientMaterialSpec;

    @JsonProperty("PerformanceMaterialSpec")
    @ColumnAlias("PerformanceMaterialSpec")
    private String performanceMaterialSpec;

    @JsonProperty("Size")
    @ColumnAlias("Size")
    private Float size;

    @JsonProperty("System")
    @ColumnAlias("System")
    private String system;

    @JsonProperty("Service")
    @ColumnAlias("Service")
    private String service;

    @JsonProperty("ComponentNumber")
    @ColumnAlias("ComponentNumber")
    private String componentNumber;

    @JsonProperty("TakeOffQuantity")
    @ColumnAlias("TakeOffQuantity")
    private Double takeOffQuantity;

    @JsonProperty("QuantityUnit")
    @ColumnAlias("QuantityUnit")
    private String quantityUnit;

    @JsonProperty("EstimatedHours")
    @ColumnAlias("EstimatedHours")
    private BigDecimal estimatedHours;

    @JsonProperty("HoursMech")
    @ColumnAlias("HoursMech")
    private BigDecimal hoursMech;

    @JsonProperty("HoursTesting")
    @ColumnAlias("HoursTesting")
    private BigDecimal hoursTesting;

    @JsonProperty("HoursRFT")
    @ColumnAlias("HoursRFT")
    private BigDecimal hoursRft;

    @JsonProperty("HoursHydro")
    @ColumnAlias("HoursHydro")
    private BigDecimal hoursHydro;

    @JsonProperty("HoursCTO")
    @ColumnAlias("HoursCTO")
    private BigDecimal hoursCto;

    @JsonProperty("InstalledQuantity")
    @ColumnAlias("InstalledQuantity")
    private Double installedQuantity;

    @JsonProperty("HoursEarnedTotal")
    @ColumnAlias("HoursEarnedTotal")
    private BigDecimal hoursEarnedTotal;

    @JsonProperty("HoursEarnedMech")
    @ColumnAlias("HoursEarnedMech")
    private BigDecimal hoursEarnedMech;

    @JsonProperty("HoursEarnedTesting")
    @ColumnAlias("HoursEarnedTesting")
    private BigDecimal hoursEarnedTesting;

    @JsonProperty("HoursEarnedRFT")
    @ColumnAlias("HoursEarnedRFT")
    private BigDecimal hoursEarnedRft;

    @JsonProperty("HoursEarnedHydro")
    @ColumnAlias("HoursEarnedHydro")
    private BigDecimal hoursEarnedHydro;

    @JsonProperty("HoursEarnedCTO")
    @ColumnAlias("HoursEarnedCTO")
    private BigDecimal hoursEarnedCto;

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

    public String getEwonumber() {
        return this.ewonumber;
    }

    public void setEwonumber(String ewonumber) {
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

    public String getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
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

    public Float getSize() {
        return this.size;
    }

    public void setSize(Float size) {
        this.size = size;
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

    public String getComponentNumber() {
        return this.componentNumber;
    }

    public void setComponentNumber(String componentNumber) {
        this.componentNumber = componentNumber;
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

    public BigDecimal getHoursMech() {
        return this.hoursMech;
    }

    public void setHoursMech(BigDecimal hoursMech) {
        this.hoursMech = hoursMech;
    }

    public BigDecimal getHoursTesting() {
        return this.hoursTesting;
    }

    public void setHoursTesting(BigDecimal hoursTesting) {
        this.hoursTesting = hoursTesting;
    }

    public BigDecimal getHoursRft() {
        return this.hoursRft;
    }

    public void setHoursRft(BigDecimal hoursRft) {
        this.hoursRft = hoursRft;
    }

    public BigDecimal getHoursHydro() {
        return this.hoursHydro;
    }

    public void setHoursHydro(BigDecimal hoursHydro) {
        this.hoursHydro = hoursHydro;
    }

    public BigDecimal getHoursCto() {
        return this.hoursCto;
    }

    public void setHoursCto(BigDecimal hoursCto) {
        this.hoursCto = hoursCto;
    }

    public Double getInstalledQuantity() {
        return this.installedQuantity;
    }

    public void setInstalledQuantity(Double installedQuantity) {
        this.installedQuantity = installedQuantity;
    }

    public BigDecimal getHoursEarnedTotal() {
        return this.hoursEarnedTotal;
    }

    public void setHoursEarnedTotal(BigDecimal hoursEarnedTotal) {
        this.hoursEarnedTotal = hoursEarnedTotal;
    }

    public BigDecimal getHoursEarnedMech() {
        return this.hoursEarnedMech;
    }

    public void setHoursEarnedMech(BigDecimal hoursEarnedMech) {
        this.hoursEarnedMech = hoursEarnedMech;
    }

    public BigDecimal getHoursEarnedTesting() {
        return this.hoursEarnedTesting;
    }

    public void setHoursEarnedTesting(BigDecimal hoursEarnedTesting) {
        this.hoursEarnedTesting = hoursEarnedTesting;
    }

    public BigDecimal getHoursEarnedRft() {
        return this.hoursEarnedRft;
    }

    public void setHoursEarnedRft(BigDecimal hoursEarnedRft) {
        this.hoursEarnedRft = hoursEarnedRft;
    }

    public BigDecimal getHoursEarnedHydro() {
        return this.hoursEarnedHydro;
    }

    public void setHoursEarnedHydro(BigDecimal hoursEarnedHydro) {
        this.hoursEarnedHydro = hoursEarnedHydro;
    }

    public BigDecimal getHoursEarnedCto() {
        return this.hoursEarnedCto;
    }

    public void setHoursEarnedCto(BigDecimal hoursEarnedCto) {
        this.hoursEarnedCto = hoursEarnedCto;
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
        if (!(o instanceof ClassicTrackerPipeUpdateResponseContent)) return false;
        final ClassicTrackerPipeUpdateResponseContent classicTrackerPipeUpdateResponseContent = (ClassicTrackerPipeUpdateResponseContent) o;
        return Objects.equals(getUid(), classicTrackerPipeUpdateResponseContent.getUid()) &&
                Objects.equals(getBidId(), classicTrackerPipeUpdateResponseContent.getBidId()) &&
                Objects.equals(getProjectServicesRep(), classicTrackerPipeUpdateResponseContent.getProjectServicesRep()) &&
                Objects.equals(getEwonumber(), classicTrackerPipeUpdateResponseContent.getEwonumber()) &&
                Objects.equals(getScope(), classicTrackerPipeUpdateResponseContent.getScope()) &&
                Objects.equals(getPhase(), classicTrackerPipeUpdateResponseContent.getPhase()) &&
                Objects.equals(getStage(), classicTrackerPipeUpdateResponseContent.getStage()) &&
                Objects.equals(getTestPackageNumber(), classicTrackerPipeUpdateResponseContent.getTestPackageNumber()) &&
                Objects.equals(getWorkPackage(), classicTrackerPipeUpdateResponseContent.getWorkPackage()) &&
                Objects.equals(getCostCode(), classicTrackerPipeUpdateResponseContent.getCostCode()) &&
                Objects.equals(getP6id(), classicTrackerPipeUpdateResponseContent.getP6id()) &&
                Objects.equals(getP6description(), classicTrackerPipeUpdateResponseContent.getP6description()) &&
                Objects.equals(getAssignedContractor(), classicTrackerPipeUpdateResponseContent.getAssignedContractor()) &&
                Objects.equals(getArea(), classicTrackerPipeUpdateResponseContent.getArea()) &&
                Objects.equals(getLocation(), classicTrackerPipeUpdateResponseContent.getLocation()) &&
                Objects.equals(getStructure(), classicTrackerPipeUpdateResponseContent.getStructure()) &&
                Objects.equals(getCu(), classicTrackerPipeUpdateResponseContent.getCu()) &&
                Objects.equals(getElevation(), classicTrackerPipeUpdateResponseContent.getElevation()) &&
                Objects.equals(getLineNumber(), classicTrackerPipeUpdateResponseContent.getLineNumber()) &&
                Objects.equals(getEngDrawingNumber(), classicTrackerPipeUpdateResponseContent.getEngDrawingNumber()) &&
                Objects.equals(getSheetNumber(), classicTrackerPipeUpdateResponseContent.getSheetNumber()) &&
                Objects.equals(getDrawingRev(), classicTrackerPipeUpdateResponseContent.getDrawingRev()) &&
                Objects.equals(getDescription(), classicTrackerPipeUpdateResponseContent.getDescription()) &&
                Objects.equals(getActivityType(), classicTrackerPipeUpdateResponseContent.getActivityType()) &&
                Objects.equals(getActivitySubType(), classicTrackerPipeUpdateResponseContent.getActivitySubType()) &&
                Objects.equals(getClientMaterialSpec(), classicTrackerPipeUpdateResponseContent.getClientMaterialSpec()) &&
                Objects.equals(getPerformanceMaterialSpec(), classicTrackerPipeUpdateResponseContent.getPerformanceMaterialSpec()) &&
                Objects.equals(getSize(), classicTrackerPipeUpdateResponseContent.getSize()) &&
                Objects.equals(getSystem(), classicTrackerPipeUpdateResponseContent.getSystem()) &&
                Objects.equals(getService(), classicTrackerPipeUpdateResponseContent.getService()) &&
                Objects.equals(getComponentNumber(), classicTrackerPipeUpdateResponseContent.getComponentNumber()) &&
                Objects.equals(getTakeOffQuantity(), classicTrackerPipeUpdateResponseContent.getTakeOffQuantity()) &&
                Objects.equals(getQuantityUnit(), classicTrackerPipeUpdateResponseContent.getQuantityUnit()) &&
                Objects.equals(getEstimatedHours(), classicTrackerPipeUpdateResponseContent.getEstimatedHours()) &&
                Objects.equals(getHoursMech(), classicTrackerPipeUpdateResponseContent.getHoursMech()) &&
                Objects.equals(getHoursTesting(), classicTrackerPipeUpdateResponseContent.getHoursTesting()) &&
                Objects.equals(getHoursRft(), classicTrackerPipeUpdateResponseContent.getHoursRft()) &&
                Objects.equals(getHoursHydro(), classicTrackerPipeUpdateResponseContent.getHoursHydro()) &&
                Objects.equals(getHoursCto(), classicTrackerPipeUpdateResponseContent.getHoursCto()) &&
                Objects.equals(getInstalledQuantity(), classicTrackerPipeUpdateResponseContent.getInstalledQuantity()) &&
                Objects.equals(getHoursEarnedTotal(), classicTrackerPipeUpdateResponseContent.getHoursEarnedTotal()) &&
                Objects.equals(getHoursEarnedMech(), classicTrackerPipeUpdateResponseContent.getHoursEarnedMech()) &&
                Objects.equals(getHoursEarnedTesting(), classicTrackerPipeUpdateResponseContent.getHoursEarnedTesting()) &&
                Objects.equals(getHoursEarnedRft(), classicTrackerPipeUpdateResponseContent.getHoursEarnedRft()) &&
                Objects.equals(getHoursEarnedHydro(), classicTrackerPipeUpdateResponseContent.getHoursEarnedHydro()) &&
                Objects.equals(getHoursEarnedCto(), classicTrackerPipeUpdateResponseContent.getHoursEarnedCto()) &&
                Objects.equals(getWbs1(), classicTrackerPipeUpdateResponseContent.getWbs1()) &&
                Objects.equals(getWbs2(), classicTrackerPipeUpdateResponseContent.getWbs2()) &&
                Objects.equals(getWbs3(), classicTrackerPipeUpdateResponseContent.getWbs3()) &&
                Objects.equals(getWbs4(), classicTrackerPipeUpdateResponseContent.getWbs4()) &&
                Objects.equals(getWbs5(), classicTrackerPipeUpdateResponseContent.getWbs5()) &&
                Objects.equals(getWbs6(), classicTrackerPipeUpdateResponseContent.getWbs6()) &&
                Objects.equals(getWbs7(), classicTrackerPipeUpdateResponseContent.getWbs7()) &&
                Objects.equals(getWbs8(), classicTrackerPipeUpdateResponseContent.getWbs8()) &&
                Objects.equals(getWbs9(), classicTrackerPipeUpdateResponseContent.getWbs9()) &&
                Objects.equals(getWbs10(), classicTrackerPipeUpdateResponseContent.getWbs10()) &&
                Objects.equals(getTimeStamp(), classicTrackerPipeUpdateResponseContent.getTimeStamp());
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
                getLineNumber(),
                getEngDrawingNumber(),
                getSheetNumber(),
                getDrawingRev(),
                getDescription(),
                getActivityType(),
                getActivitySubType(),
                getClientMaterialSpec(),
                getPerformanceMaterialSpec(),
                getSize(),
                getSystem(),
                getService(),
                getComponentNumber(),
                getTakeOffQuantity(),
                getQuantityUnit(),
                getEstimatedHours(),
                getHoursMech(),
                getHoursTesting(),
                getHoursRft(),
                getHoursHydro(),
                getHoursCto(),
                getInstalledQuantity(),
                getHoursEarnedTotal(),
                getHoursEarnedMech(),
                getHoursEarnedTesting(),
                getHoursEarnedRft(),
                getHoursEarnedHydro(),
                getHoursEarnedCto(),
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
