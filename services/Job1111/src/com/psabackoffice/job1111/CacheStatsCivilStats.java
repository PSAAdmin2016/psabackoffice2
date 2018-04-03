/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CacheStatsCivilStats generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`CacheStats_CivilStats`")
public class CacheStatsCivilStats implements Serializable {

    private Integer bidId;
    private String projectServicesRep;
    private String scope;
    private String phase;
    private String stage;
    private String testPackageNumber;
    private String workPackage;
    private String costCode;
    private String p6id;
    private String p6description;
    private String assignedContractor;
    private String area;
    private String location;
    private String structure;
    private String cu;
    private String elevation;
    private String sortGroup1;
    private String sortGroup2;
    private String sortGroup3;
    private String system;
    private String service;
    private String activityType;
    private String activitySubType;
    private String wbs1;
    private String wbs2;
    private String wbs3;
    private String wbs4;
    private String wbs5;
    private String wbs6;
    private String wbs7;
    private String wbs8;
    private String wbs9;
    private String wbs10;
    private Double countExcavation;
    private Double countForm;
    private Double countRebar;
    private Double countConcrete;
    private Double countPrecast;
    private Double countAnchor;
    private Double countGrout;
    private Double countDemo;
    private Double hoursExcavation;
    private Double hoursForm;
    private Double hoursRebar;
    private Double hoursConcrete;
    private Double hoursPrecast;
    private Double hoursAnchor;
    private Double hoursGrout;
    private Double hoursDemo;
    private Double hoursAllCivil;
    private Double hoursSellPunch;
    private Double installedExcavation;
    private Double installedForm;
    private Double installedRebar;
    private Double installedConcrete;
    private Double installedPrecast;
    private Double installedAnchor;
    private Double installedGrout;
    private Double installedDemo;
    private Double earnedExcavationHours;
    private Double earnedFormHours;
    private Double earnedRebarHours;
    private Double earnedConcreteHours;
    private Double earnedPrecastHours;
    private Double earnedAnchorHours;
    private Double earnedGroutHours;
    private Double earnedDemoHours;
    private Double earnedAllCivilHours;
    private Double earnedSellPunchHours;
    private Double remainingExcavation;
    private Double remainingForm;
    private Double remainingRebar;
    private Double remainingConcrete;
    private Double remainingPrecast;
    private Double remainingAnchor;
    private Double remainingGrout;
    private Double remainingDemo;
    private Double remainingExcavationHours;
    private Double remainingFormHours;
    private Double remainingRebarHours;
    private Double remainingConcreteHours;
    private Double remainingPrecastHours;
    private Double remainingAnchorHours;
    private Double remainingGroutHours;
    private Double remainingDemoHours;
    private Double remainingAllCivilHours;
    private Double remainingSellPunchHours;

    @Id
    @Column(name = "`BidID`", nullable = false, scale = 0, precision = 10)
    public Integer getBidId() {
        return this.bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    @Column(name = "`ProjectServicesRep`", nullable = true, length = 45)
    public String getProjectServicesRep() {
        return this.projectServicesRep;
    }

    public void setProjectServicesRep(String projectServicesRep) {
        this.projectServicesRep = projectServicesRep;
    }

    @Column(name = "`Scope`", nullable = true, length = 16)
    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Column(name = "`Phase`", nullable = true, length = 45)
    public String getPhase() {
        return this.phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @Column(name = "`Stage`", nullable = true, length = 45)
    public String getStage() {
        return this.stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @Column(name = "`TestPackageNumber`", nullable = true, length = 45)
    public String getTestPackageNumber() {
        return this.testPackageNumber;
    }

    public void setTestPackageNumber(String testPackageNumber) {
        this.testPackageNumber = testPackageNumber;
    }

    @Column(name = "`WorkPackage`", nullable = true, length = 45)
    public String getWorkPackage() {
        return this.workPackage;
    }

    public void setWorkPackage(String workPackage) {
        this.workPackage = workPackage;
    }

    @Column(name = "`CostCode`", nullable = true, length = 45)
    public String getCostCode() {
        return this.costCode;
    }

    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }

    @Column(name = "`P6ID`", nullable = true, length = 45)
    public String getP6id() {
        return this.p6id;
    }

    public void setP6id(String p6id) {
        this.p6id = p6id;
    }

    @Column(name = "`P6Description`", nullable = true, length = 45)
    public String getP6description() {
        return this.p6description;
    }

    public void setP6description(String p6description) {
        this.p6description = p6description;
    }

    @Column(name = "`AssignedContractor`", nullable = true, length = 45)
    public String getAssignedContractor() {
        return this.assignedContractor;
    }

    public void setAssignedContractor(String assignedContractor) {
        this.assignedContractor = assignedContractor;
    }

    @Column(name = "`Area`", nullable = true, length = 45)
    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "`Location`", nullable = true, length = 45)
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "`Structure`", nullable = true, length = 45)
    public String getStructure() {
        return this.structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Column(name = "`CU`", nullable = true, length = 45)
    public String getCu() {
        return this.cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    @Column(name = "`Elevation`", nullable = true, length = 45)
    public String getElevation() {
        return this.elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    @Column(name = "`SortGroup1`", nullable = true, length = 45)
    public String getSortGroup1() {
        return this.sortGroup1;
    }

    public void setSortGroup1(String sortGroup1) {
        this.sortGroup1 = sortGroup1;
    }

    @Column(name = "`SortGroup2`", nullable = true, length = 45)
    public String getSortGroup2() {
        return this.sortGroup2;
    }

    public void setSortGroup2(String sortGroup2) {
        this.sortGroup2 = sortGroup2;
    }

    @Column(name = "`SortGroup3`", nullable = true, length = 45)
    public String getSortGroup3() {
        return this.sortGroup3;
    }

    public void setSortGroup3(String sortGroup3) {
        this.sortGroup3 = sortGroup3;
    }

    @Column(name = "`System`", nullable = true, length = 45)
    public String getSystem() {
        return this.system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    @Column(name = "`Service`", nullable = true, length = 45)
    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Column(name = "`ActivityType`", nullable = true, length = 45)
    public String getActivityType() {
        return this.activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    @Column(name = "`ActivitySubType`", nullable = true, length = 45)
    public String getActivitySubType() {
        return this.activitySubType;
    }

    public void setActivitySubType(String activitySubType) {
        this.activitySubType = activitySubType;
    }

    @Column(name = "`WBS1`", nullable = true, length = 45)
    public String getWbs1() {
        return this.wbs1;
    }

    public void setWbs1(String wbs1) {
        this.wbs1 = wbs1;
    }

    @Column(name = "`WBS2`", nullable = true, length = 45)
    public String getWbs2() {
        return this.wbs2;
    }

    public void setWbs2(String wbs2) {
        this.wbs2 = wbs2;
    }

    @Column(name = "`WBS3`", nullable = true, length = 45)
    public String getWbs3() {
        return this.wbs3;
    }

    public void setWbs3(String wbs3) {
        this.wbs3 = wbs3;
    }

    @Column(name = "`WBS4`", nullable = true, length = 45)
    public String getWbs4() {
        return this.wbs4;
    }

    public void setWbs4(String wbs4) {
        this.wbs4 = wbs4;
    }

    @Column(name = "`WBS5`", nullable = true, length = 45)
    public String getWbs5() {
        return this.wbs5;
    }

    public void setWbs5(String wbs5) {
        this.wbs5 = wbs5;
    }

    @Column(name = "`WBS6`", nullable = true, length = 45)
    public String getWbs6() {
        return this.wbs6;
    }

    public void setWbs6(String wbs6) {
        this.wbs6 = wbs6;
    }

    @Column(name = "`WBS7`", nullable = true, length = 45)
    public String getWbs7() {
        return this.wbs7;
    }

    public void setWbs7(String wbs7) {
        this.wbs7 = wbs7;
    }

    @Column(name = "`WBS8`", nullable = true, length = 45)
    public String getWbs8() {
        return this.wbs8;
    }

    public void setWbs8(String wbs8) {
        this.wbs8 = wbs8;
    }

    @Column(name = "`WBS9`", nullable = true, length = 45)
    public String getWbs9() {
        return this.wbs9;
    }

    public void setWbs9(String wbs9) {
        this.wbs9 = wbs9;
    }

    @Column(name = "`WBS10`", nullable = true, length = 45)
    public String getWbs10() {
        return this.wbs10;
    }

    public void setWbs10(String wbs10) {
        this.wbs10 = wbs10;
    }

    @Column(name = "`CountExcavation`", nullable = true, scale = 2, precision = 12)
    public Double getCountExcavation() {
        return this.countExcavation;
    }

    public void setCountExcavation(Double countExcavation) {
        this.countExcavation = countExcavation;
    }

    @Column(name = "`CountForm`", nullable = true, scale = 2, precision = 12)
    public Double getCountForm() {
        return this.countForm;
    }

    public void setCountForm(Double countForm) {
        this.countForm = countForm;
    }

    @Column(name = "`CountRebar`", nullable = true, scale = 2, precision = 12)
    public Double getCountRebar() {
        return this.countRebar;
    }

    public void setCountRebar(Double countRebar) {
        this.countRebar = countRebar;
    }

    @Column(name = "`CountConcrete`", nullable = true, scale = 2, precision = 12)
    public Double getCountConcrete() {
        return this.countConcrete;
    }

    public void setCountConcrete(Double countConcrete) {
        this.countConcrete = countConcrete;
    }

    @Column(name = "`CountPrecast`", nullable = true, scale = 2, precision = 12)
    public Double getCountPrecast() {
        return this.countPrecast;
    }

    public void setCountPrecast(Double countPrecast) {
        this.countPrecast = countPrecast;
    }

    @Column(name = "`CountAnchor`", nullable = true, scale = 2, precision = 12)
    public Double getCountAnchor() {
        return this.countAnchor;
    }

    public void setCountAnchor(Double countAnchor) {
        this.countAnchor = countAnchor;
    }

    @Column(name = "`CountGrout`", nullable = true, scale = 2, precision = 12)
    public Double getCountGrout() {
        return this.countGrout;
    }

    public void setCountGrout(Double countGrout) {
        this.countGrout = countGrout;
    }

    @Column(name = "`CountDemo`", nullable = true, scale = 2, precision = 12)
    public Double getCountDemo() {
        return this.countDemo;
    }

    public void setCountDemo(Double countDemo) {
        this.countDemo = countDemo;
    }

    @Column(name = "`HoursExcavation`", nullable = true, scale = 6, precision = 16)
    public Double getHoursExcavation() {
        return this.hoursExcavation;
    }

    public void setHoursExcavation(Double hoursExcavation) {
        this.hoursExcavation = hoursExcavation;
    }

    @Column(name = "`HoursForm`", nullable = true, scale = 6, precision = 16)
    public Double getHoursForm() {
        return this.hoursForm;
    }

    public void setHoursForm(Double hoursForm) {
        this.hoursForm = hoursForm;
    }

    @Column(name = "`HoursRebar`", nullable = true, scale = 6, precision = 16)
    public Double getHoursRebar() {
        return this.hoursRebar;
    }

    public void setHoursRebar(Double hoursRebar) {
        this.hoursRebar = hoursRebar;
    }

    @Column(name = "`HoursConcrete`", nullable = true, scale = 6, precision = 16)
    public Double getHoursConcrete() {
        return this.hoursConcrete;
    }

    public void setHoursConcrete(Double hoursConcrete) {
        this.hoursConcrete = hoursConcrete;
    }

    @Column(name = "`HoursPrecast`", nullable = true, scale = 6, precision = 16)
    public Double getHoursPrecast() {
        return this.hoursPrecast;
    }

    public void setHoursPrecast(Double hoursPrecast) {
        this.hoursPrecast = hoursPrecast;
    }

    @Column(name = "`HoursAnchor`", nullable = true, scale = 6, precision = 16)
    public Double getHoursAnchor() {
        return this.hoursAnchor;
    }

    public void setHoursAnchor(Double hoursAnchor) {
        this.hoursAnchor = hoursAnchor;
    }

    @Column(name = "`HoursGrout`", nullable = true, scale = 6, precision = 16)
    public Double getHoursGrout() {
        return this.hoursGrout;
    }

    public void setHoursGrout(Double hoursGrout) {
        this.hoursGrout = hoursGrout;
    }

    @Column(name = "`HoursDemo`", nullable = true, scale = 6, precision = 16)
    public Double getHoursDemo() {
        return this.hoursDemo;
    }

    public void setHoursDemo(Double hoursDemo) {
        this.hoursDemo = hoursDemo;
    }

    @Column(name = "`HoursAllCivil`", nullable = true, scale = 6, precision = 16)
    public Double getHoursAllCivil() {
        return this.hoursAllCivil;
    }

    public void setHoursAllCivil(Double hoursAllCivil) {
        this.hoursAllCivil = hoursAllCivil;
    }

    @Column(name = "`HoursSellPunch`", nullable = true, scale = 6, precision = 16)
    public Double getHoursSellPunch() {
        return this.hoursSellPunch;
    }

    public void setHoursSellPunch(Double hoursSellPunch) {
        this.hoursSellPunch = hoursSellPunch;
    }

    @Column(name = "`InstalledExcavation`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledExcavation() {
        return this.installedExcavation;
    }

    public void setInstalledExcavation(Double installedExcavation) {
        this.installedExcavation = installedExcavation;
    }

    @Column(name = "`InstalledForm`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledForm() {
        return this.installedForm;
    }

    public void setInstalledForm(Double installedForm) {
        this.installedForm = installedForm;
    }

    @Column(name = "`InstalledRebar`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledRebar() {
        return this.installedRebar;
    }

    public void setInstalledRebar(Double installedRebar) {
        this.installedRebar = installedRebar;
    }

    @Column(name = "`InstalledConcrete`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledConcrete() {
        return this.installedConcrete;
    }

    public void setInstalledConcrete(Double installedConcrete) {
        this.installedConcrete = installedConcrete;
    }

    @Column(name = "`InstalledPrecast`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledPrecast() {
        return this.installedPrecast;
    }

    public void setInstalledPrecast(Double installedPrecast) {
        this.installedPrecast = installedPrecast;
    }

    @Column(name = "`InstalledAnchor`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledAnchor() {
        return this.installedAnchor;
    }

    public void setInstalledAnchor(Double installedAnchor) {
        this.installedAnchor = installedAnchor;
    }

    @Column(name = "`InstalledGrout`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledGrout() {
        return this.installedGrout;
    }

    public void setInstalledGrout(Double installedGrout) {
        this.installedGrout = installedGrout;
    }

    @Column(name = "`InstalledDemo`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledDemo() {
        return this.installedDemo;
    }

    public void setInstalledDemo(Double installedDemo) {
        this.installedDemo = installedDemo;
    }

    @Column(name = "`EarnedExcavationHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedExcavationHours() {
        return this.earnedExcavationHours;
    }

    public void setEarnedExcavationHours(Double earnedExcavationHours) {
        this.earnedExcavationHours = earnedExcavationHours;
    }

    @Column(name = "`EarnedFormHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedFormHours() {
        return this.earnedFormHours;
    }

    public void setEarnedFormHours(Double earnedFormHours) {
        this.earnedFormHours = earnedFormHours;
    }

    @Column(name = "`EarnedRebarHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedRebarHours() {
        return this.earnedRebarHours;
    }

    public void setEarnedRebarHours(Double earnedRebarHours) {
        this.earnedRebarHours = earnedRebarHours;
    }

    @Column(name = "`EarnedConcreteHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedConcreteHours() {
        return this.earnedConcreteHours;
    }

    public void setEarnedConcreteHours(Double earnedConcreteHours) {
        this.earnedConcreteHours = earnedConcreteHours;
    }

    @Column(name = "`EarnedPrecastHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedPrecastHours() {
        return this.earnedPrecastHours;
    }

    public void setEarnedPrecastHours(Double earnedPrecastHours) {
        this.earnedPrecastHours = earnedPrecastHours;
    }

    @Column(name = "`EarnedAnchorHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedAnchorHours() {
        return this.earnedAnchorHours;
    }

    public void setEarnedAnchorHours(Double earnedAnchorHours) {
        this.earnedAnchorHours = earnedAnchorHours;
    }

    @Column(name = "`EarnedGroutHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedGroutHours() {
        return this.earnedGroutHours;
    }

    public void setEarnedGroutHours(Double earnedGroutHours) {
        this.earnedGroutHours = earnedGroutHours;
    }

    @Column(name = "`EarnedDemoHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedDemoHours() {
        return this.earnedDemoHours;
    }

    public void setEarnedDemoHours(Double earnedDemoHours) {
        this.earnedDemoHours = earnedDemoHours;
    }

    @Column(name = "`EarnedAllCivilHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedAllCivilHours() {
        return this.earnedAllCivilHours;
    }

    public void setEarnedAllCivilHours(Double earnedAllCivilHours) {
        this.earnedAllCivilHours = earnedAllCivilHours;
    }

    @Column(name = "`EarnedSellPunchHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedSellPunchHours() {
        return this.earnedSellPunchHours;
    }

    public void setEarnedSellPunchHours(Double earnedSellPunchHours) {
        this.earnedSellPunchHours = earnedSellPunchHours;
    }

    @Column(name = "`RemainingExcavation`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingExcavation() {
        return this.remainingExcavation;
    }

    public void setRemainingExcavation(Double remainingExcavation) {
        this.remainingExcavation = remainingExcavation;
    }

    @Column(name = "`RemainingForm`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingForm() {
        return this.remainingForm;
    }

    public void setRemainingForm(Double remainingForm) {
        this.remainingForm = remainingForm;
    }

    @Column(name = "`RemainingRebar`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingRebar() {
        return this.remainingRebar;
    }

    public void setRemainingRebar(Double remainingRebar) {
        this.remainingRebar = remainingRebar;
    }

    @Column(name = "`RemainingConcrete`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingConcrete() {
        return this.remainingConcrete;
    }

    public void setRemainingConcrete(Double remainingConcrete) {
        this.remainingConcrete = remainingConcrete;
    }

    @Column(name = "`RemainingPrecast`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingPrecast() {
        return this.remainingPrecast;
    }

    public void setRemainingPrecast(Double remainingPrecast) {
        this.remainingPrecast = remainingPrecast;
    }

    @Column(name = "`RemainingAnchor`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingAnchor() {
        return this.remainingAnchor;
    }

    public void setRemainingAnchor(Double remainingAnchor) {
        this.remainingAnchor = remainingAnchor;
    }

    @Column(name = "`RemainingGrout`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingGrout() {
        return this.remainingGrout;
    }

    public void setRemainingGrout(Double remainingGrout) {
        this.remainingGrout = remainingGrout;
    }

    @Column(name = "`RemainingDemo`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingDemo() {
        return this.remainingDemo;
    }

    public void setRemainingDemo(Double remainingDemo) {
        this.remainingDemo = remainingDemo;
    }

    @Column(name = "`RemainingExcavationHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingExcavationHours() {
        return this.remainingExcavationHours;
    }

    public void setRemainingExcavationHours(Double remainingExcavationHours) {
        this.remainingExcavationHours = remainingExcavationHours;
    }

    @Column(name = "`RemainingFormHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingFormHours() {
        return this.remainingFormHours;
    }

    public void setRemainingFormHours(Double remainingFormHours) {
        this.remainingFormHours = remainingFormHours;
    }

    @Column(name = "`RemainingRebarHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingRebarHours() {
        return this.remainingRebarHours;
    }

    public void setRemainingRebarHours(Double remainingRebarHours) {
        this.remainingRebarHours = remainingRebarHours;
    }

    @Column(name = "`RemainingConcreteHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingConcreteHours() {
        return this.remainingConcreteHours;
    }

    public void setRemainingConcreteHours(Double remainingConcreteHours) {
        this.remainingConcreteHours = remainingConcreteHours;
    }

    @Column(name = "`RemainingPrecastHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingPrecastHours() {
        return this.remainingPrecastHours;
    }

    public void setRemainingPrecastHours(Double remainingPrecastHours) {
        this.remainingPrecastHours = remainingPrecastHours;
    }

    @Column(name = "`RemainingAnchorHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingAnchorHours() {
        return this.remainingAnchorHours;
    }

    public void setRemainingAnchorHours(Double remainingAnchorHours) {
        this.remainingAnchorHours = remainingAnchorHours;
    }

    @Column(name = "`RemainingGroutHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingGroutHours() {
        return this.remainingGroutHours;
    }

    public void setRemainingGroutHours(Double remainingGroutHours) {
        this.remainingGroutHours = remainingGroutHours;
    }

    @Column(name = "`RemainingDemoHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingDemoHours() {
        return this.remainingDemoHours;
    }

    public void setRemainingDemoHours(Double remainingDemoHours) {
        this.remainingDemoHours = remainingDemoHours;
    }

    @Column(name = "`RemainingAllCivilHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingAllCivilHours() {
        return this.remainingAllCivilHours;
    }

    public void setRemainingAllCivilHours(Double remainingAllCivilHours) {
        this.remainingAllCivilHours = remainingAllCivilHours;
    }

    @Column(name = "`RemainingSellPunchHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingSellPunchHours() {
        return this.remainingSellPunchHours;
    }

    public void setRemainingSellPunchHours(Double remainingSellPunchHours) {
        this.remainingSellPunchHours = remainingSellPunchHours;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CacheStatsCivilStats)) return false;
        final CacheStatsCivilStats cacheStatsCivilStats = (CacheStatsCivilStats) o;
        return Objects.equals(getBidId(), cacheStatsCivilStats.getBidId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBidId());
    }
}

