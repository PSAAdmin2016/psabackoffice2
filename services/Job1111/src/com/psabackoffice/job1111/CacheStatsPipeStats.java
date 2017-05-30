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
 * CacheStatsPipeStats generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`CacheStats_PipeStats`")
public class CacheStatsPipeStats implements Serializable {

    private Integer bidId;
    private String scope;
    private String phase;
    private String stage;
    private String testPackageNumber;
    private String costCode;
    private String p6id;
    private String p6description;
    private String assignedContractor;
    private String area;
    private String location;
    private String structure;
    private String cu;
    private String elevation;
    private String system;
    private String service;
    private String pipingActivityType;
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
    private Double countErectionFootage;
    private Double countBoltUp;
    private Double countWeld;
    private Double countCut;
    private Double countTrimActivities;
    private Double countSupports;
    private Double countMiscActivities;
    private Double countDemo;
    private Double hoursErection;
    private Double hoursBoltUp;
    private Double hoursWeld;
    private Double hoursCut;
    private Double hoursTrim;
    private Double hoursSupports;
    private Double hoursMisc;
    private Double hoursDemo;
    private Double hoursReadyForTesting;
    private Double hoursHydro;
    private Double hoursClientTurnover;
    private Double hoursTesting;
    private Double hoursAllmech;
    private Double installedFootage;
    private Double installedBoltUps;
    private Double installedWelds;
    private Double installedCuts;
    private Double installedTrim;
    private Double installedSupports;
    private Double installedMisc;
    private Double installedDemo;
    private Double earnedErectionHours;
    private Double earnedBoltUpHours;
    private Double earnedWeldHours;
    private Double earnedCutHours;
    private Double earnedTrimHours;
    private Double earnedSupportHours;
    private Double earnedMiscHours;
    private Double earnedDemoHours;
    private Double earnedReadyForTestingHours;
    private Double earnedHydroHours;
    private Double earnedClientTurnoverHours;
    private Double earnedTestingHours;
    private Double earnedAllmech;
    private Double remainingFootage;
    private Double remainingBoltUps;
    private Double remainingWelds;
    private Double remainingCuts;
    private Double remainingTrimActivities;
    private Double remainingSupports;
    private Double remainingMiscActivities;
    private Double remainingDemoActivities;
    private Double remainingErectionHours;
    private Double remainingBoltUpHours;
    private Double remainingWeldHours;
    private Double remainingCutHours;
    private Double remainingTrimHours;
    private Double remainingSupportHours;
    private Double remainingMiscHours;
    private Double remainingDemoHours;
    private Double remainingReadyForTestingHours;
    private Double remainingHydroHours;
    private Double remainingClientTurnoverHours;
    private Double remainingTestingHours;
    private Double remainingAllmechHours;

    @Id
    @Column(name = "`BidID`", nullable = false, scale = 0, precision = 10)
    public Integer getBidId() {
        return this.bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
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

    @Column(name = "`PipingActivityType`", nullable = true, length = 45)
    public String getPipingActivityType() {
        return this.pipingActivityType;
    }

    public void setPipingActivityType(String pipingActivityType) {
        this.pipingActivityType = pipingActivityType;
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

    @Column(name = "`CountErectionFootage`", nullable = true, scale = 2, precision = 12)
    public Double getCountErectionFootage() {
        return this.countErectionFootage;
    }

    public void setCountErectionFootage(Double countErectionFootage) {
        this.countErectionFootage = countErectionFootage;
    }

    @Column(name = "`CountBoltUp`", nullable = true, scale = 2, precision = 12)
    public Double getCountBoltUp() {
        return this.countBoltUp;
    }

    public void setCountBoltUp(Double countBoltUp) {
        this.countBoltUp = countBoltUp;
    }

    @Column(name = "`CountWeld`", nullable = true, scale = 2, precision = 12)
    public Double getCountWeld() {
        return this.countWeld;
    }

    public void setCountWeld(Double countWeld) {
        this.countWeld = countWeld;
    }

    @Column(name = "`CountCut`", nullable = true, scale = 2, precision = 12)
    public Double getCountCut() {
        return this.countCut;
    }

    public void setCountCut(Double countCut) {
        this.countCut = countCut;
    }

    @Column(name = "`CountTrimActivities`", nullable = true, scale = 2, precision = 12)
    public Double getCountTrimActivities() {
        return this.countTrimActivities;
    }

    public void setCountTrimActivities(Double countTrimActivities) {
        this.countTrimActivities = countTrimActivities;
    }

    @Column(name = "`CountSupports`", nullable = true, scale = 2, precision = 12)
    public Double getCountSupports() {
        return this.countSupports;
    }

    public void setCountSupports(Double countSupports) {
        this.countSupports = countSupports;
    }

    @Column(name = "`CountMiscActivities`", nullable = true, scale = 2, precision = 12)
    public Double getCountMiscActivities() {
        return this.countMiscActivities;
    }

    public void setCountMiscActivities(Double countMiscActivities) {
        this.countMiscActivities = countMiscActivities;
    }

    @Column(name = "`CountDemo`", nullable = true, scale = 2, precision = 12)
    public Double getCountDemo() {
        return this.countDemo;
    }

    public void setCountDemo(Double countDemo) {
        this.countDemo = countDemo;
    }

    @Column(name = "`HoursErection`", nullable = true, scale = 6, precision = 16)
    public Double getHoursErection() {
        return this.hoursErection;
    }

    public void setHoursErection(Double hoursErection) {
        this.hoursErection = hoursErection;
    }

    @Column(name = "`HoursBoltUp`", nullable = true, scale = 6, precision = 16)
    public Double getHoursBoltUp() {
        return this.hoursBoltUp;
    }

    public void setHoursBoltUp(Double hoursBoltUp) {
        this.hoursBoltUp = hoursBoltUp;
    }

    @Column(name = "`HoursWeld`", nullable = true, scale = 6, precision = 16)
    public Double getHoursWeld() {
        return this.hoursWeld;
    }

    public void setHoursWeld(Double hoursWeld) {
        this.hoursWeld = hoursWeld;
    }

    @Column(name = "`HoursCut`", nullable = true, scale = 6, precision = 16)
    public Double getHoursCut() {
        return this.hoursCut;
    }

    public void setHoursCut(Double hoursCut) {
        this.hoursCut = hoursCut;
    }

    @Column(name = "`HoursTrim`", nullable = true, scale = 6, precision = 16)
    public Double getHoursTrim() {
        return this.hoursTrim;
    }

    public void setHoursTrim(Double hoursTrim) {
        this.hoursTrim = hoursTrim;
    }

    @Column(name = "`HoursSupports`", nullable = true, scale = 6, precision = 16)
    public Double getHoursSupports() {
        return this.hoursSupports;
    }

    public void setHoursSupports(Double hoursSupports) {
        this.hoursSupports = hoursSupports;
    }

    @Column(name = "`HoursMisc`", nullable = true, scale = 6, precision = 16)
    public Double getHoursMisc() {
        return this.hoursMisc;
    }

    public void setHoursMisc(Double hoursMisc) {
        this.hoursMisc = hoursMisc;
    }

    @Column(name = "`HoursDemo`", nullable = true, scale = 6, precision = 16)
    public Double getHoursDemo() {
        return this.hoursDemo;
    }

    public void setHoursDemo(Double hoursDemo) {
        this.hoursDemo = hoursDemo;
    }

    @Column(name = "`HoursReadyForTesting`", nullable = true, scale = 6, precision = 16)
    public Double getHoursReadyForTesting() {
        return this.hoursReadyForTesting;
    }

    public void setHoursReadyForTesting(Double hoursReadyForTesting) {
        this.hoursReadyForTesting = hoursReadyForTesting;
    }

    @Column(name = "`HoursHydro`", nullable = true, scale = 6, precision = 16)
    public Double getHoursHydro() {
        return this.hoursHydro;
    }

    public void setHoursHydro(Double hoursHydro) {
        this.hoursHydro = hoursHydro;
    }

    @Column(name = "`HoursClientTurnover`", nullable = true, scale = 6, precision = 16)
    public Double getHoursClientTurnover() {
        return this.hoursClientTurnover;
    }

    public void setHoursClientTurnover(Double hoursClientTurnover) {
        this.hoursClientTurnover = hoursClientTurnover;
    }

    @Column(name = "`HoursTesting`", nullable = true, scale = 6, precision = 16)
    public Double getHoursTesting() {
        return this.hoursTesting;
    }

    public void setHoursTesting(Double hoursTesting) {
        this.hoursTesting = hoursTesting;
    }

    @Column(name = "`HoursALLMech`", nullable = true, scale = 6, precision = 16)
    public Double getHoursAllmech() {
        return this.hoursAllmech;
    }

    public void setHoursAllmech(Double hoursAllmech) {
        this.hoursAllmech = hoursAllmech;
    }

    @Column(name = "`InstalledFootage`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledFootage() {
        return this.installedFootage;
    }

    public void setInstalledFootage(Double installedFootage) {
        this.installedFootage = installedFootage;
    }

    @Column(name = "`InstalledBoltUps`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledBoltUps() {
        return this.installedBoltUps;
    }

    public void setInstalledBoltUps(Double installedBoltUps) {
        this.installedBoltUps = installedBoltUps;
    }

    @Column(name = "`InstalledWelds`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledWelds() {
        return this.installedWelds;
    }

    public void setInstalledWelds(Double installedWelds) {
        this.installedWelds = installedWelds;
    }

    @Column(name = "`InstalledCuts`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledCuts() {
        return this.installedCuts;
    }

    public void setInstalledCuts(Double installedCuts) {
        this.installedCuts = installedCuts;
    }

    @Column(name = "`InstalledTrim`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledTrim() {
        return this.installedTrim;
    }

    public void setInstalledTrim(Double installedTrim) {
        this.installedTrim = installedTrim;
    }

    @Column(name = "`InstalledSupports`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledSupports() {
        return this.installedSupports;
    }

    public void setInstalledSupports(Double installedSupports) {
        this.installedSupports = installedSupports;
    }

    @Column(name = "`InstalledMisc`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledMisc() {
        return this.installedMisc;
    }

    public void setInstalledMisc(Double installedMisc) {
        this.installedMisc = installedMisc;
    }

    @Column(name = "`InstalledDemo`", nullable = true, scale = 2, precision = 12)
    public Double getInstalledDemo() {
        return this.installedDemo;
    }

    public void setInstalledDemo(Double installedDemo) {
        this.installedDemo = installedDemo;
    }

    @Column(name = "`EarnedErectionHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedErectionHours() {
        return this.earnedErectionHours;
    }

    public void setEarnedErectionHours(Double earnedErectionHours) {
        this.earnedErectionHours = earnedErectionHours;
    }

    @Column(name = "`EarnedBoltUpHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedBoltUpHours() {
        return this.earnedBoltUpHours;
    }

    public void setEarnedBoltUpHours(Double earnedBoltUpHours) {
        this.earnedBoltUpHours = earnedBoltUpHours;
    }

    @Column(name = "`EarnedWeldHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedWeldHours() {
        return this.earnedWeldHours;
    }

    public void setEarnedWeldHours(Double earnedWeldHours) {
        this.earnedWeldHours = earnedWeldHours;
    }

    @Column(name = "`EarnedCutHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedCutHours() {
        return this.earnedCutHours;
    }

    public void setEarnedCutHours(Double earnedCutHours) {
        this.earnedCutHours = earnedCutHours;
    }

    @Column(name = "`EarnedTrimHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedTrimHours() {
        return this.earnedTrimHours;
    }

    public void setEarnedTrimHours(Double earnedTrimHours) {
        this.earnedTrimHours = earnedTrimHours;
    }

    @Column(name = "`EarnedSupportHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedSupportHours() {
        return this.earnedSupportHours;
    }

    public void setEarnedSupportHours(Double earnedSupportHours) {
        this.earnedSupportHours = earnedSupportHours;
    }

    @Column(name = "`EarnedMiscHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedMiscHours() {
        return this.earnedMiscHours;
    }

    public void setEarnedMiscHours(Double earnedMiscHours) {
        this.earnedMiscHours = earnedMiscHours;
    }

    @Column(name = "`EarnedDemoHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedDemoHours() {
        return this.earnedDemoHours;
    }

    public void setEarnedDemoHours(Double earnedDemoHours) {
        this.earnedDemoHours = earnedDemoHours;
    }

    @Column(name = "`EarnedReadyForTestingHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedReadyForTestingHours() {
        return this.earnedReadyForTestingHours;
    }

    public void setEarnedReadyForTestingHours(Double earnedReadyForTestingHours) {
        this.earnedReadyForTestingHours = earnedReadyForTestingHours;
    }

    @Column(name = "`EarnedHydroHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedHydroHours() {
        return this.earnedHydroHours;
    }

    public void setEarnedHydroHours(Double earnedHydroHours) {
        this.earnedHydroHours = earnedHydroHours;
    }

    @Column(name = "`EarnedClientTurnoverHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedClientTurnoverHours() {
        return this.earnedClientTurnoverHours;
    }

    public void setEarnedClientTurnoverHours(Double earnedClientTurnoverHours) {
        this.earnedClientTurnoverHours = earnedClientTurnoverHours;
    }

    @Column(name = "`EarnedTestingHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedTestingHours() {
        return this.earnedTestingHours;
    }

    public void setEarnedTestingHours(Double earnedTestingHours) {
        this.earnedTestingHours = earnedTestingHours;
    }

    @Column(name = "`EarnedALLMech`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedAllmech() {
        return this.earnedAllmech;
    }

    public void setEarnedAllmech(Double earnedAllmech) {
        this.earnedAllmech = earnedAllmech;
    }

    @Column(name = "`RemainingFootage`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingFootage() {
        return this.remainingFootage;
    }

    public void setRemainingFootage(Double remainingFootage) {
        this.remainingFootage = remainingFootage;
    }

    @Column(name = "`RemainingBoltUps`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingBoltUps() {
        return this.remainingBoltUps;
    }

    public void setRemainingBoltUps(Double remainingBoltUps) {
        this.remainingBoltUps = remainingBoltUps;
    }

    @Column(name = "`RemainingWelds`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingWelds() {
        return this.remainingWelds;
    }

    public void setRemainingWelds(Double remainingWelds) {
        this.remainingWelds = remainingWelds;
    }

    @Column(name = "`RemainingCuts`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingCuts() {
        return this.remainingCuts;
    }

    public void setRemainingCuts(Double remainingCuts) {
        this.remainingCuts = remainingCuts;
    }

    @Column(name = "`RemainingTrimActivities`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingTrimActivities() {
        return this.remainingTrimActivities;
    }

    public void setRemainingTrimActivities(Double remainingTrimActivities) {
        this.remainingTrimActivities = remainingTrimActivities;
    }

    @Column(name = "`RemainingSupports`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingSupports() {
        return this.remainingSupports;
    }

    public void setRemainingSupports(Double remainingSupports) {
        this.remainingSupports = remainingSupports;
    }

    @Column(name = "`RemainingMiscActivities`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingMiscActivities() {
        return this.remainingMiscActivities;
    }

    public void setRemainingMiscActivities(Double remainingMiscActivities) {
        this.remainingMiscActivities = remainingMiscActivities;
    }

    @Column(name = "`RemainingDemoActivities`", nullable = true, scale = 2, precision = 12)
    public Double getRemainingDemoActivities() {
        return this.remainingDemoActivities;
    }

    public void setRemainingDemoActivities(Double remainingDemoActivities) {
        this.remainingDemoActivities = remainingDemoActivities;
    }

    @Column(name = "`RemainingErectionHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingErectionHours() {
        return this.remainingErectionHours;
    }

    public void setRemainingErectionHours(Double remainingErectionHours) {
        this.remainingErectionHours = remainingErectionHours;
    }

    @Column(name = "`RemainingBoltUpHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingBoltUpHours() {
        return this.remainingBoltUpHours;
    }

    public void setRemainingBoltUpHours(Double remainingBoltUpHours) {
        this.remainingBoltUpHours = remainingBoltUpHours;
    }

    @Column(name = "`RemainingWeldHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingWeldHours() {
        return this.remainingWeldHours;
    }

    public void setRemainingWeldHours(Double remainingWeldHours) {
        this.remainingWeldHours = remainingWeldHours;
    }

    @Column(name = "`RemainingCutHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingCutHours() {
        return this.remainingCutHours;
    }

    public void setRemainingCutHours(Double remainingCutHours) {
        this.remainingCutHours = remainingCutHours;
    }

    @Column(name = "`RemainingTrimHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingTrimHours() {
        return this.remainingTrimHours;
    }

    public void setRemainingTrimHours(Double remainingTrimHours) {
        this.remainingTrimHours = remainingTrimHours;
    }

    @Column(name = "`RemainingSupportHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingSupportHours() {
        return this.remainingSupportHours;
    }

    public void setRemainingSupportHours(Double remainingSupportHours) {
        this.remainingSupportHours = remainingSupportHours;
    }

    @Column(name = "`RemainingMiscHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingMiscHours() {
        return this.remainingMiscHours;
    }

    public void setRemainingMiscHours(Double remainingMiscHours) {
        this.remainingMiscHours = remainingMiscHours;
    }

    @Column(name = "`RemainingDemoHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingDemoHours() {
        return this.remainingDemoHours;
    }

    public void setRemainingDemoHours(Double remainingDemoHours) {
        this.remainingDemoHours = remainingDemoHours;
    }

    @Column(name = "`RemainingReadyForTestingHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingReadyForTestingHours() {
        return this.remainingReadyForTestingHours;
    }

    public void setRemainingReadyForTestingHours(Double remainingReadyForTestingHours) {
        this.remainingReadyForTestingHours = remainingReadyForTestingHours;
    }

    @Column(name = "`RemainingHydroHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingHydroHours() {
        return this.remainingHydroHours;
    }

    public void setRemainingHydroHours(Double remainingHydroHours) {
        this.remainingHydroHours = remainingHydroHours;
    }

    @Column(name = "`RemainingClientTurnoverHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingClientTurnoverHours() {
        return this.remainingClientTurnoverHours;
    }

    public void setRemainingClientTurnoverHours(Double remainingClientTurnoverHours) {
        this.remainingClientTurnoverHours = remainingClientTurnoverHours;
    }

    @Column(name = "`RemainingTestingHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingTestingHours() {
        return this.remainingTestingHours;
    }

    public void setRemainingTestingHours(Double remainingTestingHours) {
        this.remainingTestingHours = remainingTestingHours;
    }

    @Column(name = "`RemainingALLMechHours`", nullable = true, scale = 6, precision = 16)
    public Double getRemainingAllmechHours() {
        return this.remainingAllmechHours;
    }

    public void setRemainingAllmechHours(Double remainingAllmechHours) {
        this.remainingAllmechHours = remainingAllmechHours;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CacheStatsPipeStats)) return false;
        final CacheStatsPipeStats cacheStatsPipeStats = (CacheStatsPipeStats) o;
        return Objects.equals(getBidId(), cacheStatsPipeStats.getBidId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBidId());
    }
}

