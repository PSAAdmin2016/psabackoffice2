/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetCivilStatsResponseContent implements Serializable {


    @JsonProperty("BidID")
    @ColumnAlias("BidID")
    private Integer bidId;

    @JsonProperty("ProjectServicesRep")
    @ColumnAlias("ProjectServicesRep")
    private String projectServicesRep;

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

    @JsonProperty("System")
    @ColumnAlias("System")
    private String system;

    @JsonProperty("Service")
    @ColumnAlias("Service")
    private String service;

    @JsonProperty("ActivityType")
    @ColumnAlias("ActivityType")
    private String activityType;

    @JsonProperty("ActivitySubType")
    @ColumnAlias("ActivitySubType")
    private String activitySubType;

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

    @JsonProperty("CountExcavation")
    @ColumnAlias("CountExcavation")
    private BigDecimal countExcavation;

    @JsonProperty("CountForm")
    @ColumnAlias("CountForm")
    private BigDecimal countForm;

    @JsonProperty("CountRebar")
    @ColumnAlias("CountRebar")
    private BigDecimal countRebar;

    @JsonProperty("CountConcrete")
    @ColumnAlias("CountConcrete")
    private BigDecimal countConcrete;

    @JsonProperty("CountPrecast")
    @ColumnAlias("CountPrecast")
    private BigDecimal countPrecast;

    @JsonProperty("CountAnchor")
    @ColumnAlias("CountAnchor")
    private BigDecimal countAnchor;

    @JsonProperty("CountGrout")
    @ColumnAlias("CountGrout")
    private BigDecimal countGrout;

    @JsonProperty("CountDemo")
    @ColumnAlias("CountDemo")
    private BigDecimal countDemo;

    @JsonProperty("HoursExcavation")
    @ColumnAlias("HoursExcavation")
    private BigDecimal hoursExcavation;

    @JsonProperty("HoursForm")
    @ColumnAlias("HoursForm")
    private BigDecimal hoursForm;

    @JsonProperty("HoursRebar")
    @ColumnAlias("HoursRebar")
    private BigDecimal hoursRebar;

    @JsonProperty("HoursConcrete")
    @ColumnAlias("HoursConcrete")
    private BigDecimal hoursConcrete;

    @JsonProperty("HoursPrecast")
    @ColumnAlias("HoursPrecast")
    private BigDecimal hoursPrecast;

    @JsonProperty("HoursAnchor")
    @ColumnAlias("HoursAnchor")
    private BigDecimal hoursAnchor;

    @JsonProperty("HoursGrout")
    @ColumnAlias("HoursGrout")
    private BigDecimal hoursGrout;

    @JsonProperty("HoursDemo")
    @ColumnAlias("HoursDemo")
    private BigDecimal hoursDemo;

    @JsonProperty("HoursAllCivil")
    @ColumnAlias("HoursAllCivil")
    private BigDecimal hoursAllCivil;

    @JsonProperty("HoursSellPunch")
    @ColumnAlias("HoursSellPunch")
    private BigDecimal hoursSellPunch;

    @JsonProperty("InstalledExcavation")
    @ColumnAlias("InstalledExcavation")
    private BigDecimal installedExcavation;

    @JsonProperty("InstalledForm")
    @ColumnAlias("InstalledForm")
    private BigDecimal installedForm;

    @JsonProperty("InstalledRebar")
    @ColumnAlias("InstalledRebar")
    private BigDecimal installedRebar;

    @JsonProperty("InstalledConcrete")
    @ColumnAlias("InstalledConcrete")
    private BigDecimal installedConcrete;

    @JsonProperty("InstalledPrecast")
    @ColumnAlias("InstalledPrecast")
    private BigDecimal installedPrecast;

    @JsonProperty("InstalledAnchor")
    @ColumnAlias("InstalledAnchor")
    private BigDecimal installedAnchor;

    @JsonProperty("InstalledGrout")
    @ColumnAlias("InstalledGrout")
    private BigDecimal installedGrout;

    @JsonProperty("InstalledDemo")
    @ColumnAlias("InstalledDemo")
    private BigDecimal installedDemo;

    @JsonProperty("EarnedExcavationHours")
    @ColumnAlias("EarnedExcavationHours")
    private BigDecimal earnedExcavationHours;

    @JsonProperty("EarnedFormHours")
    @ColumnAlias("EarnedFormHours")
    private BigDecimal earnedFormHours;

    @JsonProperty("EarnedRebarHours")
    @ColumnAlias("EarnedRebarHours")
    private BigDecimal earnedRebarHours;

    @JsonProperty("EarnedConcreteHours")
    @ColumnAlias("EarnedConcreteHours")
    private BigDecimal earnedConcreteHours;

    @JsonProperty("EarnedPrecastHours")
    @ColumnAlias("EarnedPrecastHours")
    private BigDecimal earnedPrecastHours;

    @JsonProperty("EarnedAnchorHours")
    @ColumnAlias("EarnedAnchorHours")
    private BigDecimal earnedAnchorHours;

    @JsonProperty("EarnedGroutHours")
    @ColumnAlias("EarnedGroutHours")
    private BigDecimal earnedGroutHours;

    @JsonProperty("EarnedDemoHours")
    @ColumnAlias("EarnedDemoHours")
    private BigDecimal earnedDemoHours;

    @JsonProperty("EarnedAllCivilHours")
    @ColumnAlias("EarnedAllCivilHours")
    private BigDecimal earnedAllCivilHours;

    @JsonProperty("EarnedSellPunchHours")
    @ColumnAlias("EarnedSellPunchHours")
    private BigDecimal earnedSellPunchHours;

    @JsonProperty("RemainingExcavation")
    @ColumnAlias("RemainingExcavation")
    private BigDecimal remainingExcavation;

    @JsonProperty("RemainingForm")
    @ColumnAlias("RemainingForm")
    private BigDecimal remainingForm;

    @JsonProperty("RemainingRebar")
    @ColumnAlias("RemainingRebar")
    private BigDecimal remainingRebar;

    @JsonProperty("RemainingConcrete")
    @ColumnAlias("RemainingConcrete")
    private BigDecimal remainingConcrete;

    @JsonProperty("RemainingPrecast")
    @ColumnAlias("RemainingPrecast")
    private BigDecimal remainingPrecast;

    @JsonProperty("RemainingAnchor")
    @ColumnAlias("RemainingAnchor")
    private BigDecimal remainingAnchor;

    @JsonProperty("RemainingGrout")
    @ColumnAlias("RemainingGrout")
    private BigDecimal remainingGrout;

    @JsonProperty("RemainingDemo")
    @ColumnAlias("RemainingDemo")
    private BigDecimal remainingDemo;

    @JsonProperty("RemainingExcavationHours")
    @ColumnAlias("RemainingExcavationHours")
    private BigDecimal remainingExcavationHours;

    @JsonProperty("RemainingFormHours")
    @ColumnAlias("RemainingFormHours")
    private BigDecimal remainingFormHours;

    @JsonProperty("RemainingRebarHours")
    @ColumnAlias("RemainingRebarHours")
    private BigDecimal remainingRebarHours;

    @JsonProperty("RemainingConcreteHours")
    @ColumnAlias("RemainingConcreteHours")
    private BigDecimal remainingConcreteHours;

    @JsonProperty("RemainingPrecastHours")
    @ColumnAlias("RemainingPrecastHours")
    private BigDecimal remainingPrecastHours;

    @JsonProperty("RemainingAnchorHours")
    @ColumnAlias("RemainingAnchorHours")
    private BigDecimal remainingAnchorHours;

    @JsonProperty("RemainingGroutHours")
    @ColumnAlias("RemainingGroutHours")
    private BigDecimal remainingGroutHours;

    @JsonProperty("RemainingDemoHours")
    @ColumnAlias("RemainingDemoHours")
    private BigDecimal remainingDemoHours;

    @JsonProperty("RemainingAllCivilHours")
    @ColumnAlias("RemainingAllCivilHours")
    private BigDecimal remainingAllCivilHours;

    @JsonProperty("RemainingSellPunchHours")
    @ColumnAlias("RemainingSellPunchHours")
    private BigDecimal remainingSellPunchHours;

    @JsonProperty("CivilPercentComplete")
    @ColumnAlias("CivilPercentComplete")
    private BigDecimal civilPercentComplete;

    @JsonProperty("PercentComplete")
    @ColumnAlias("PercentComplete")
    private BigDecimal percentComplete;

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

    public BigDecimal getCountExcavation() {
        return this.countExcavation;
    }

    public void setCountExcavation(BigDecimal countExcavation) {
        this.countExcavation = countExcavation;
    }

    public BigDecimal getCountForm() {
        return this.countForm;
    }

    public void setCountForm(BigDecimal countForm) {
        this.countForm = countForm;
    }

    public BigDecimal getCountRebar() {
        return this.countRebar;
    }

    public void setCountRebar(BigDecimal countRebar) {
        this.countRebar = countRebar;
    }

    public BigDecimal getCountConcrete() {
        return this.countConcrete;
    }

    public void setCountConcrete(BigDecimal countConcrete) {
        this.countConcrete = countConcrete;
    }

    public BigDecimal getCountPrecast() {
        return this.countPrecast;
    }

    public void setCountPrecast(BigDecimal countPrecast) {
        this.countPrecast = countPrecast;
    }

    public BigDecimal getCountAnchor() {
        return this.countAnchor;
    }

    public void setCountAnchor(BigDecimal countAnchor) {
        this.countAnchor = countAnchor;
    }

    public BigDecimal getCountGrout() {
        return this.countGrout;
    }

    public void setCountGrout(BigDecimal countGrout) {
        this.countGrout = countGrout;
    }

    public BigDecimal getCountDemo() {
        return this.countDemo;
    }

    public void setCountDemo(BigDecimal countDemo) {
        this.countDemo = countDemo;
    }

    public BigDecimal getHoursExcavation() {
        return this.hoursExcavation;
    }

    public void setHoursExcavation(BigDecimal hoursExcavation) {
        this.hoursExcavation = hoursExcavation;
    }

    public BigDecimal getHoursForm() {
        return this.hoursForm;
    }

    public void setHoursForm(BigDecimal hoursForm) {
        this.hoursForm = hoursForm;
    }

    public BigDecimal getHoursRebar() {
        return this.hoursRebar;
    }

    public void setHoursRebar(BigDecimal hoursRebar) {
        this.hoursRebar = hoursRebar;
    }

    public BigDecimal getHoursConcrete() {
        return this.hoursConcrete;
    }

    public void setHoursConcrete(BigDecimal hoursConcrete) {
        this.hoursConcrete = hoursConcrete;
    }

    public BigDecimal getHoursPrecast() {
        return this.hoursPrecast;
    }

    public void setHoursPrecast(BigDecimal hoursPrecast) {
        this.hoursPrecast = hoursPrecast;
    }

    public BigDecimal getHoursAnchor() {
        return this.hoursAnchor;
    }

    public void setHoursAnchor(BigDecimal hoursAnchor) {
        this.hoursAnchor = hoursAnchor;
    }

    public BigDecimal getHoursGrout() {
        return this.hoursGrout;
    }

    public void setHoursGrout(BigDecimal hoursGrout) {
        this.hoursGrout = hoursGrout;
    }

    public BigDecimal getHoursDemo() {
        return this.hoursDemo;
    }

    public void setHoursDemo(BigDecimal hoursDemo) {
        this.hoursDemo = hoursDemo;
    }

    public BigDecimal getHoursAllCivil() {
        return this.hoursAllCivil;
    }

    public void setHoursAllCivil(BigDecimal hoursAllCivil) {
        this.hoursAllCivil = hoursAllCivil;
    }

    public BigDecimal getHoursSellPunch() {
        return this.hoursSellPunch;
    }

    public void setHoursSellPunch(BigDecimal hoursSellPunch) {
        this.hoursSellPunch = hoursSellPunch;
    }

    public BigDecimal getInstalledExcavation() {
        return this.installedExcavation;
    }

    public void setInstalledExcavation(BigDecimal installedExcavation) {
        this.installedExcavation = installedExcavation;
    }

    public BigDecimal getInstalledForm() {
        return this.installedForm;
    }

    public void setInstalledForm(BigDecimal installedForm) {
        this.installedForm = installedForm;
    }

    public BigDecimal getInstalledRebar() {
        return this.installedRebar;
    }

    public void setInstalledRebar(BigDecimal installedRebar) {
        this.installedRebar = installedRebar;
    }

    public BigDecimal getInstalledConcrete() {
        return this.installedConcrete;
    }

    public void setInstalledConcrete(BigDecimal installedConcrete) {
        this.installedConcrete = installedConcrete;
    }

    public BigDecimal getInstalledPrecast() {
        return this.installedPrecast;
    }

    public void setInstalledPrecast(BigDecimal installedPrecast) {
        this.installedPrecast = installedPrecast;
    }

    public BigDecimal getInstalledAnchor() {
        return this.installedAnchor;
    }

    public void setInstalledAnchor(BigDecimal installedAnchor) {
        this.installedAnchor = installedAnchor;
    }

    public BigDecimal getInstalledGrout() {
        return this.installedGrout;
    }

    public void setInstalledGrout(BigDecimal installedGrout) {
        this.installedGrout = installedGrout;
    }

    public BigDecimal getInstalledDemo() {
        return this.installedDemo;
    }

    public void setInstalledDemo(BigDecimal installedDemo) {
        this.installedDemo = installedDemo;
    }

    public BigDecimal getEarnedExcavationHours() {
        return this.earnedExcavationHours;
    }

    public void setEarnedExcavationHours(BigDecimal earnedExcavationHours) {
        this.earnedExcavationHours = earnedExcavationHours;
    }

    public BigDecimal getEarnedFormHours() {
        return this.earnedFormHours;
    }

    public void setEarnedFormHours(BigDecimal earnedFormHours) {
        this.earnedFormHours = earnedFormHours;
    }

    public BigDecimal getEarnedRebarHours() {
        return this.earnedRebarHours;
    }

    public void setEarnedRebarHours(BigDecimal earnedRebarHours) {
        this.earnedRebarHours = earnedRebarHours;
    }

    public BigDecimal getEarnedConcreteHours() {
        return this.earnedConcreteHours;
    }

    public void setEarnedConcreteHours(BigDecimal earnedConcreteHours) {
        this.earnedConcreteHours = earnedConcreteHours;
    }

    public BigDecimal getEarnedPrecastHours() {
        return this.earnedPrecastHours;
    }

    public void setEarnedPrecastHours(BigDecimal earnedPrecastHours) {
        this.earnedPrecastHours = earnedPrecastHours;
    }

    public BigDecimal getEarnedAnchorHours() {
        return this.earnedAnchorHours;
    }

    public void setEarnedAnchorHours(BigDecimal earnedAnchorHours) {
        this.earnedAnchorHours = earnedAnchorHours;
    }

    public BigDecimal getEarnedGroutHours() {
        return this.earnedGroutHours;
    }

    public void setEarnedGroutHours(BigDecimal earnedGroutHours) {
        this.earnedGroutHours = earnedGroutHours;
    }

    public BigDecimal getEarnedDemoHours() {
        return this.earnedDemoHours;
    }

    public void setEarnedDemoHours(BigDecimal earnedDemoHours) {
        this.earnedDemoHours = earnedDemoHours;
    }

    public BigDecimal getEarnedAllCivilHours() {
        return this.earnedAllCivilHours;
    }

    public void setEarnedAllCivilHours(BigDecimal earnedAllCivilHours) {
        this.earnedAllCivilHours = earnedAllCivilHours;
    }

    public BigDecimal getEarnedSellPunchHours() {
        return this.earnedSellPunchHours;
    }

    public void setEarnedSellPunchHours(BigDecimal earnedSellPunchHours) {
        this.earnedSellPunchHours = earnedSellPunchHours;
    }

    public BigDecimal getRemainingExcavation() {
        return this.remainingExcavation;
    }

    public void setRemainingExcavation(BigDecimal remainingExcavation) {
        this.remainingExcavation = remainingExcavation;
    }

    public BigDecimal getRemainingForm() {
        return this.remainingForm;
    }

    public void setRemainingForm(BigDecimal remainingForm) {
        this.remainingForm = remainingForm;
    }

    public BigDecimal getRemainingRebar() {
        return this.remainingRebar;
    }

    public void setRemainingRebar(BigDecimal remainingRebar) {
        this.remainingRebar = remainingRebar;
    }

    public BigDecimal getRemainingConcrete() {
        return this.remainingConcrete;
    }

    public void setRemainingConcrete(BigDecimal remainingConcrete) {
        this.remainingConcrete = remainingConcrete;
    }

    public BigDecimal getRemainingPrecast() {
        return this.remainingPrecast;
    }

    public void setRemainingPrecast(BigDecimal remainingPrecast) {
        this.remainingPrecast = remainingPrecast;
    }

    public BigDecimal getRemainingAnchor() {
        return this.remainingAnchor;
    }

    public void setRemainingAnchor(BigDecimal remainingAnchor) {
        this.remainingAnchor = remainingAnchor;
    }

    public BigDecimal getRemainingGrout() {
        return this.remainingGrout;
    }

    public void setRemainingGrout(BigDecimal remainingGrout) {
        this.remainingGrout = remainingGrout;
    }

    public BigDecimal getRemainingDemo() {
        return this.remainingDemo;
    }

    public void setRemainingDemo(BigDecimal remainingDemo) {
        this.remainingDemo = remainingDemo;
    }

    public BigDecimal getRemainingExcavationHours() {
        return this.remainingExcavationHours;
    }

    public void setRemainingExcavationHours(BigDecimal remainingExcavationHours) {
        this.remainingExcavationHours = remainingExcavationHours;
    }

    public BigDecimal getRemainingFormHours() {
        return this.remainingFormHours;
    }

    public void setRemainingFormHours(BigDecimal remainingFormHours) {
        this.remainingFormHours = remainingFormHours;
    }

    public BigDecimal getRemainingRebarHours() {
        return this.remainingRebarHours;
    }

    public void setRemainingRebarHours(BigDecimal remainingRebarHours) {
        this.remainingRebarHours = remainingRebarHours;
    }

    public BigDecimal getRemainingConcreteHours() {
        return this.remainingConcreteHours;
    }

    public void setRemainingConcreteHours(BigDecimal remainingConcreteHours) {
        this.remainingConcreteHours = remainingConcreteHours;
    }

    public BigDecimal getRemainingPrecastHours() {
        return this.remainingPrecastHours;
    }

    public void setRemainingPrecastHours(BigDecimal remainingPrecastHours) {
        this.remainingPrecastHours = remainingPrecastHours;
    }

    public BigDecimal getRemainingAnchorHours() {
        return this.remainingAnchorHours;
    }

    public void setRemainingAnchorHours(BigDecimal remainingAnchorHours) {
        this.remainingAnchorHours = remainingAnchorHours;
    }

    public BigDecimal getRemainingGroutHours() {
        return this.remainingGroutHours;
    }

    public void setRemainingGroutHours(BigDecimal remainingGroutHours) {
        this.remainingGroutHours = remainingGroutHours;
    }

    public BigDecimal getRemainingDemoHours() {
        return this.remainingDemoHours;
    }

    public void setRemainingDemoHours(BigDecimal remainingDemoHours) {
        this.remainingDemoHours = remainingDemoHours;
    }

    public BigDecimal getRemainingAllCivilHours() {
        return this.remainingAllCivilHours;
    }

    public void setRemainingAllCivilHours(BigDecimal remainingAllCivilHours) {
        this.remainingAllCivilHours = remainingAllCivilHours;
    }

    public BigDecimal getRemainingSellPunchHours() {
        return this.remainingSellPunchHours;
    }

    public void setRemainingSellPunchHours(BigDecimal remainingSellPunchHours) {
        this.remainingSellPunchHours = remainingSellPunchHours;
    }

    public BigDecimal getCivilPercentComplete() {
        return this.civilPercentComplete;
    }

    public void setCivilPercentComplete(BigDecimal civilPercentComplete) {
        this.civilPercentComplete = civilPercentComplete;
    }

    public BigDecimal getPercentComplete() {
        return this.percentComplete;
    }

    public void setPercentComplete(BigDecimal percentComplete) {
        this.percentComplete = percentComplete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetCivilStatsResponseContent)) return false;
        final GetCivilStatsResponseContent getCivilStatsResponseContent = (GetCivilStatsResponseContent) o;
        return Objects.equals(getBidId(), getCivilStatsResponseContent.getBidId()) &&
                Objects.equals(getProjectServicesRep(), getCivilStatsResponseContent.getProjectServicesRep()) &&
                Objects.equals(getScope(), getCivilStatsResponseContent.getScope()) &&
                Objects.equals(getPhase(), getCivilStatsResponseContent.getPhase()) &&
                Objects.equals(getStage(), getCivilStatsResponseContent.getStage()) &&
                Objects.equals(getTestPackageNumber(), getCivilStatsResponseContent.getTestPackageNumber()) &&
                Objects.equals(getWorkPackage(), getCivilStatsResponseContent.getWorkPackage()) &&
                Objects.equals(getCostCode(), getCivilStatsResponseContent.getCostCode()) &&
                Objects.equals(getP6id(), getCivilStatsResponseContent.getP6id()) &&
                Objects.equals(getP6description(), getCivilStatsResponseContent.getP6description()) &&
                Objects.equals(getAssignedContractor(), getCivilStatsResponseContent.getAssignedContractor()) &&
                Objects.equals(getArea(), getCivilStatsResponseContent.getArea()) &&
                Objects.equals(getLocation(), getCivilStatsResponseContent.getLocation()) &&
                Objects.equals(getStructure(), getCivilStatsResponseContent.getStructure()) &&
                Objects.equals(getCu(), getCivilStatsResponseContent.getCu()) &&
                Objects.equals(getElevation(), getCivilStatsResponseContent.getElevation()) &&
                Objects.equals(getSortGroup1(), getCivilStatsResponseContent.getSortGroup1()) &&
                Objects.equals(getSortGroup2(), getCivilStatsResponseContent.getSortGroup2()) &&
                Objects.equals(getSortGroup3(), getCivilStatsResponseContent.getSortGroup3()) &&
                Objects.equals(getSystem(), getCivilStatsResponseContent.getSystem()) &&
                Objects.equals(getService(), getCivilStatsResponseContent.getService()) &&
                Objects.equals(getActivityType(), getCivilStatsResponseContent.getActivityType()) &&
                Objects.equals(getActivitySubType(), getCivilStatsResponseContent.getActivitySubType()) &&
                Objects.equals(getWbs1(), getCivilStatsResponseContent.getWbs1()) &&
                Objects.equals(getWbs2(), getCivilStatsResponseContent.getWbs2()) &&
                Objects.equals(getWbs3(), getCivilStatsResponseContent.getWbs3()) &&
                Objects.equals(getWbs4(), getCivilStatsResponseContent.getWbs4()) &&
                Objects.equals(getWbs5(), getCivilStatsResponseContent.getWbs5()) &&
                Objects.equals(getWbs6(), getCivilStatsResponseContent.getWbs6()) &&
                Objects.equals(getWbs7(), getCivilStatsResponseContent.getWbs7()) &&
                Objects.equals(getWbs8(), getCivilStatsResponseContent.getWbs8()) &&
                Objects.equals(getWbs9(), getCivilStatsResponseContent.getWbs9()) &&
                Objects.equals(getWbs10(), getCivilStatsResponseContent.getWbs10()) &&
                Objects.equals(getCountExcavation(), getCivilStatsResponseContent.getCountExcavation()) &&
                Objects.equals(getCountForm(), getCivilStatsResponseContent.getCountForm()) &&
                Objects.equals(getCountRebar(), getCivilStatsResponseContent.getCountRebar()) &&
                Objects.equals(getCountConcrete(), getCivilStatsResponseContent.getCountConcrete()) &&
                Objects.equals(getCountPrecast(), getCivilStatsResponseContent.getCountPrecast()) &&
                Objects.equals(getCountAnchor(), getCivilStatsResponseContent.getCountAnchor()) &&
                Objects.equals(getCountGrout(), getCivilStatsResponseContent.getCountGrout()) &&
                Objects.equals(getCountDemo(), getCivilStatsResponseContent.getCountDemo()) &&
                Objects.equals(getHoursExcavation(), getCivilStatsResponseContent.getHoursExcavation()) &&
                Objects.equals(getHoursForm(), getCivilStatsResponseContent.getHoursForm()) &&
                Objects.equals(getHoursRebar(), getCivilStatsResponseContent.getHoursRebar()) &&
                Objects.equals(getHoursConcrete(), getCivilStatsResponseContent.getHoursConcrete()) &&
                Objects.equals(getHoursPrecast(), getCivilStatsResponseContent.getHoursPrecast()) &&
                Objects.equals(getHoursAnchor(), getCivilStatsResponseContent.getHoursAnchor()) &&
                Objects.equals(getHoursGrout(), getCivilStatsResponseContent.getHoursGrout()) &&
                Objects.equals(getHoursDemo(), getCivilStatsResponseContent.getHoursDemo()) &&
                Objects.equals(getHoursAllCivil(), getCivilStatsResponseContent.getHoursAllCivil()) &&
                Objects.equals(getHoursSellPunch(), getCivilStatsResponseContent.getHoursSellPunch()) &&
                Objects.equals(getInstalledExcavation(), getCivilStatsResponseContent.getInstalledExcavation()) &&
                Objects.equals(getInstalledForm(), getCivilStatsResponseContent.getInstalledForm()) &&
                Objects.equals(getInstalledRebar(), getCivilStatsResponseContent.getInstalledRebar()) &&
                Objects.equals(getInstalledConcrete(), getCivilStatsResponseContent.getInstalledConcrete()) &&
                Objects.equals(getInstalledPrecast(), getCivilStatsResponseContent.getInstalledPrecast()) &&
                Objects.equals(getInstalledAnchor(), getCivilStatsResponseContent.getInstalledAnchor()) &&
                Objects.equals(getInstalledGrout(), getCivilStatsResponseContent.getInstalledGrout()) &&
                Objects.equals(getInstalledDemo(), getCivilStatsResponseContent.getInstalledDemo()) &&
                Objects.equals(getEarnedExcavationHours(), getCivilStatsResponseContent.getEarnedExcavationHours()) &&
                Objects.equals(getEarnedFormHours(), getCivilStatsResponseContent.getEarnedFormHours()) &&
                Objects.equals(getEarnedRebarHours(), getCivilStatsResponseContent.getEarnedRebarHours()) &&
                Objects.equals(getEarnedConcreteHours(), getCivilStatsResponseContent.getEarnedConcreteHours()) &&
                Objects.equals(getEarnedPrecastHours(), getCivilStatsResponseContent.getEarnedPrecastHours()) &&
                Objects.equals(getEarnedAnchorHours(), getCivilStatsResponseContent.getEarnedAnchorHours()) &&
                Objects.equals(getEarnedGroutHours(), getCivilStatsResponseContent.getEarnedGroutHours()) &&
                Objects.equals(getEarnedDemoHours(), getCivilStatsResponseContent.getEarnedDemoHours()) &&
                Objects.equals(getEarnedAllCivilHours(), getCivilStatsResponseContent.getEarnedAllCivilHours()) &&
                Objects.equals(getEarnedSellPunchHours(), getCivilStatsResponseContent.getEarnedSellPunchHours()) &&
                Objects.equals(getRemainingExcavation(), getCivilStatsResponseContent.getRemainingExcavation()) &&
                Objects.equals(getRemainingForm(), getCivilStatsResponseContent.getRemainingForm()) &&
                Objects.equals(getRemainingRebar(), getCivilStatsResponseContent.getRemainingRebar()) &&
                Objects.equals(getRemainingConcrete(), getCivilStatsResponseContent.getRemainingConcrete()) &&
                Objects.equals(getRemainingPrecast(), getCivilStatsResponseContent.getRemainingPrecast()) &&
                Objects.equals(getRemainingAnchor(), getCivilStatsResponseContent.getRemainingAnchor()) &&
                Objects.equals(getRemainingGrout(), getCivilStatsResponseContent.getRemainingGrout()) &&
                Objects.equals(getRemainingDemo(), getCivilStatsResponseContent.getRemainingDemo()) &&
                Objects.equals(getRemainingExcavationHours(), getCivilStatsResponseContent.getRemainingExcavationHours()) &&
                Objects.equals(getRemainingFormHours(), getCivilStatsResponseContent.getRemainingFormHours()) &&
                Objects.equals(getRemainingRebarHours(), getCivilStatsResponseContent.getRemainingRebarHours()) &&
                Objects.equals(getRemainingConcreteHours(), getCivilStatsResponseContent.getRemainingConcreteHours()) &&
                Objects.equals(getRemainingPrecastHours(), getCivilStatsResponseContent.getRemainingPrecastHours()) &&
                Objects.equals(getRemainingAnchorHours(), getCivilStatsResponseContent.getRemainingAnchorHours()) &&
                Objects.equals(getRemainingGroutHours(), getCivilStatsResponseContent.getRemainingGroutHours()) &&
                Objects.equals(getRemainingDemoHours(), getCivilStatsResponseContent.getRemainingDemoHours()) &&
                Objects.equals(getRemainingAllCivilHours(), getCivilStatsResponseContent.getRemainingAllCivilHours()) &&
                Objects.equals(getRemainingSellPunchHours(), getCivilStatsResponseContent.getRemainingSellPunchHours()) &&
                Objects.equals(getCivilPercentComplete(), getCivilStatsResponseContent.getCivilPercentComplete()) &&
                Objects.equals(getPercentComplete(), getCivilStatsResponseContent.getPercentComplete());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBidId(),
                getProjectServicesRep(),
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
                getSystem(),
                getService(),
                getActivityType(),
                getActivitySubType(),
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
                getCountExcavation(),
                getCountForm(),
                getCountRebar(),
                getCountConcrete(),
                getCountPrecast(),
                getCountAnchor(),
                getCountGrout(),
                getCountDemo(),
                getHoursExcavation(),
                getHoursForm(),
                getHoursRebar(),
                getHoursConcrete(),
                getHoursPrecast(),
                getHoursAnchor(),
                getHoursGrout(),
                getHoursDemo(),
                getHoursAllCivil(),
                getHoursSellPunch(),
                getInstalledExcavation(),
                getInstalledForm(),
                getInstalledRebar(),
                getInstalledConcrete(),
                getInstalledPrecast(),
                getInstalledAnchor(),
                getInstalledGrout(),
                getInstalledDemo(),
                getEarnedExcavationHours(),
                getEarnedFormHours(),
                getEarnedRebarHours(),
                getEarnedConcreteHours(),
                getEarnedPrecastHours(),
                getEarnedAnchorHours(),
                getEarnedGroutHours(),
                getEarnedDemoHours(),
                getEarnedAllCivilHours(),
                getEarnedSellPunchHours(),
                getRemainingExcavation(),
                getRemainingForm(),
                getRemainingRebar(),
                getRemainingConcrete(),
                getRemainingPrecast(),
                getRemainingAnchor(),
                getRemainingGrout(),
                getRemainingDemo(),
                getRemainingExcavationHours(),
                getRemainingFormHours(),
                getRemainingRebarHours(),
                getRemainingConcreteHours(),
                getRemainingPrecastHours(),
                getRemainingAnchorHours(),
                getRemainingGroutHours(),
                getRemainingDemoHours(),
                getRemainingAllCivilHours(),
                getRemainingSellPunchHours(),
                getCivilPercentComplete(),
                getPercentComplete());
    }
}
