/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SteelTrackerClassic generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SteelTrackerClassic`")
public class SteelTrackerClassic implements Serializable {

    private Integer uid;
    private Integer bidId;
    private String ewonumber;
    private String scope;
    private String phase;
    private String stage;
    private String testPackageNumber;
    private String costCode;
    private String p6id;
    private String assignedContractor;
    private String area;
    private String location;
    private String structure;
    private String cu;
    private String elevation;
    private String p6description;
    private String pieceMark;
    private Short pieceMarkRev;
    private String description;
    private String activityType;
    private String clientMaterialSpec;
    private String performanceMaterialSpec;
    private String materialType;
    private Float length;
    private Float weight;
    private String system;
    private String service;
    private Float quantityTakeOff;
    private Short quantityWeld;
    private Double hoursShake;
    private Double hoursErect;
    private Double hoursBoltout;
    private Double hoursImp;
    private Double hoursWeld;
    private Double hoursSell;
    private Double hoursDemo;
    private Double hoursMisc;
    private Double hoursAll;
    private Integer installedShake;
    private Float installedErect;
    private Float installedBoltout;
    private Float installedImp;
    private Float installedWeld;
    private Integer installedSell;
    private Integer installedDemo;
    private Float installedMisc;
    private Double earnedShakeHours;
    private Double earnedErectHours;
    private Double earnedBoltoutHours;
    private Double earnedImpHours;
    private Double earnedWeldHours;
    private Double earnedSellHours;
    private Double earnedDemoHours;
    private Double earnedMiscHours;
    private Double earnedAllHours;
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
    private Timestamp timeStamp;

    @Id
    @Column(name = "`UID`", nullable = false, scale = 0, precision = 10)
    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column(name = "`BidID`", nullable = true, scale = 0, precision = 10)
    public Integer getBidId() {
        return this.bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    @Column(name = "`EWONumber`", nullable = true, length = 45)
    public String getEwonumber() {
        return this.ewonumber;
    }

    public void setEwonumber(String ewonumber) {
        this.ewonumber = ewonumber;
    }

    @Column(name = "`Scope`", nullable = true, length = 32)
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

    @Column(name = "`P6Description`", nullable = true, length = 255)
    public String getP6description() {
        return this.p6description;
    }

    public void setP6description(String p6description) {
        this.p6description = p6description;
    }

    @Column(name = "`PieceMark`", nullable = true, length = 45)
    public String getPieceMark() {
        return this.pieceMark;
    }

    public void setPieceMark(String pieceMark) {
        this.pieceMark = pieceMark;
    }

    @Column(name = "`PieceMarkRev`", nullable = true, scale = 0, precision = 3)
    public Short getPieceMarkRev() {
        return this.pieceMarkRev;
    }

    public void setPieceMarkRev(Short pieceMarkRev) {
        this.pieceMarkRev = pieceMarkRev;
    }

    @Column(name = "`Description`", nullable = true, length = 255)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "`ActivityType`", nullable = true, length = 16)
    public String getActivityType() {
        return this.activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    @Column(name = "`ClientMaterialSpec`", nullable = true, length = 45)
    public String getClientMaterialSpec() {
        return this.clientMaterialSpec;
    }

    public void setClientMaterialSpec(String clientMaterialSpec) {
        this.clientMaterialSpec = clientMaterialSpec;
    }

    @Column(name = "`PerformanceMaterialSpec`", nullable = true, length = 45)
    public String getPerformanceMaterialSpec() {
        return this.performanceMaterialSpec;
    }

    public void setPerformanceMaterialSpec(String performanceMaterialSpec) {
        this.performanceMaterialSpec = performanceMaterialSpec;
    }

    @Column(name = "`MaterialType`", nullable = true, length = 32)
    public String getMaterialType() {
        return this.materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    @Column(name = "`Length`", nullable = true, scale = 4, precision = 9)
    public Float getLength() {
        return this.length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    @Column(name = "`Weight`", nullable = true, scale = 6, precision = 10)
    public Float getWeight() {
        return this.weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
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

    @Column(name = "`QuantityTakeOff`", nullable = true, scale = 2, precision = 7)
    public Float getQuantityTakeOff() {
        return this.quantityTakeOff;
    }

    public void setQuantityTakeOff(Float quantityTakeOff) {
        this.quantityTakeOff = quantityTakeOff;
    }

    @Column(name = "`QuantityWeld`", nullable = true, scale = 0, precision = 3)
    public Short getQuantityWeld() {
        return this.quantityWeld;
    }

    public void setQuantityWeld(Short quantityWeld) {
        this.quantityWeld = quantityWeld;
    }

    @Column(name = "`HoursShake`", nullable = true, scale = 6, precision = 16)
    public Double getHoursShake() {
        return this.hoursShake;
    }

    public void setHoursShake(Double hoursShake) {
        this.hoursShake = hoursShake;
    }

    @Column(name = "`HoursErect`", nullable = true, scale = 6, precision = 16)
    public Double getHoursErect() {
        return this.hoursErect;
    }

    public void setHoursErect(Double hoursErect) {
        this.hoursErect = hoursErect;
    }

    @Column(name = "`HoursBoltout`", nullable = true, scale = 6, precision = 16)
    public Double getHoursBoltout() {
        return this.hoursBoltout;
    }

    public void setHoursBoltout(Double hoursBoltout) {
        this.hoursBoltout = hoursBoltout;
    }

    @Column(name = "`HoursImp`", nullable = true, scale = 6, precision = 16)
    public Double getHoursImp() {
        return this.hoursImp;
    }

    public void setHoursImp(Double hoursImp) {
        this.hoursImp = hoursImp;
    }

    @Column(name = "`HoursWeld`", nullable = true, scale = 6, precision = 16)
    public Double getHoursWeld() {
        return this.hoursWeld;
    }

    public void setHoursWeld(Double hoursWeld) {
        this.hoursWeld = hoursWeld;
    }

    @Column(name = "`HoursSell`", nullable = true, scale = 6, precision = 16)
    public Double getHoursSell() {
        return this.hoursSell;
    }

    public void setHoursSell(Double hoursSell) {
        this.hoursSell = hoursSell;
    }

    @Column(name = "`HoursDemo`", nullable = true, scale = 6, precision = 16)
    public Double getHoursDemo() {
        return this.hoursDemo;
    }

    public void setHoursDemo(Double hoursDemo) {
        this.hoursDemo = hoursDemo;
    }

    @Column(name = "`HoursMisc`", nullable = true, scale = 6, precision = 16)
    public Double getHoursMisc() {
        return this.hoursMisc;
    }

    public void setHoursMisc(Double hoursMisc) {
        this.hoursMisc = hoursMisc;
    }

    @Column(name = "`HoursAll`", nullable = true, scale = 6, precision = 16)
    public Double getHoursAll() {
        return this.hoursAll;
    }

    public void setHoursAll(Double hoursAll) {
        this.hoursAll = hoursAll;
    }

    @Column(name = "`InstalledShake`", nullable = true, scale = 0, precision = 7)
    public Integer getInstalledShake() {
        return this.installedShake;
    }

    public void setInstalledShake(Integer installedShake) {
        this.installedShake = installedShake;
    }

    @Column(name = "`InstalledErect`", nullable = true, scale = 2, precision = 7)
    public Float getInstalledErect() {
        return this.installedErect;
    }

    public void setInstalledErect(Float installedErect) {
        this.installedErect = installedErect;
    }

    @Column(name = "`InstalledBoltout`", nullable = true, scale = 2, precision = 7)
    public Float getInstalledBoltout() {
        return this.installedBoltout;
    }

    public void setInstalledBoltout(Float installedBoltout) {
        this.installedBoltout = installedBoltout;
    }

    @Column(name = "`InstalledImp`", nullable = true, scale = 2, precision = 7)
    public Float getInstalledImp() {
        return this.installedImp;
    }

    public void setInstalledImp(Float installedImp) {
        this.installedImp = installedImp;
    }

    @Column(name = "`InstalledWeld`", nullable = true, scale = 2, precision = 5)
    public Float getInstalledWeld() {
        return this.installedWeld;
    }

    public void setInstalledWeld(Float installedWeld) {
        this.installedWeld = installedWeld;
    }

    @Column(name = "`InstalledSell`", nullable = true, scale = 0, precision = 7)
    public Integer getInstalledSell() {
        return this.installedSell;
    }

    public void setInstalledSell(Integer installedSell) {
        this.installedSell = installedSell;
    }

    @Column(name = "`InstalledDemo`", nullable = true, scale = 0, precision = 7)
    public Integer getInstalledDemo() {
        return this.installedDemo;
    }

    public void setInstalledDemo(Integer installedDemo) {
        this.installedDemo = installedDemo;
    }

    @Column(name = "`InstalledMisc`", nullable = true, scale = 2, precision = 7)
    public Float getInstalledMisc() {
        return this.installedMisc;
    }

    public void setInstalledMisc(Float installedMisc) {
        this.installedMisc = installedMisc;
    }

    @Column(name = "`EarnedShakeHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedShakeHours() {
        return this.earnedShakeHours;
    }

    public void setEarnedShakeHours(Double earnedShakeHours) {
        this.earnedShakeHours = earnedShakeHours;
    }

    @Column(name = "`EarnedErectHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedErectHours() {
        return this.earnedErectHours;
    }

    public void setEarnedErectHours(Double earnedErectHours) {
        this.earnedErectHours = earnedErectHours;
    }

    @Column(name = "`EarnedBoltoutHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedBoltoutHours() {
        return this.earnedBoltoutHours;
    }

    public void setEarnedBoltoutHours(Double earnedBoltoutHours) {
        this.earnedBoltoutHours = earnedBoltoutHours;
    }

    @Column(name = "`EarnedImpHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedImpHours() {
        return this.earnedImpHours;
    }

    public void setEarnedImpHours(Double earnedImpHours) {
        this.earnedImpHours = earnedImpHours;
    }

    @Column(name = "`EarnedWeldHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedWeldHours() {
        return this.earnedWeldHours;
    }

    public void setEarnedWeldHours(Double earnedWeldHours) {
        this.earnedWeldHours = earnedWeldHours;
    }

    @Column(name = "`EarnedSellHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedSellHours() {
        return this.earnedSellHours;
    }

    public void setEarnedSellHours(Double earnedSellHours) {
        this.earnedSellHours = earnedSellHours;
    }

    @Column(name = "`EarnedDemoHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedDemoHours() {
        return this.earnedDemoHours;
    }

    public void setEarnedDemoHours(Double earnedDemoHours) {
        this.earnedDemoHours = earnedDemoHours;
    }

    @Column(name = "`EarnedMiscHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedMiscHours() {
        return this.earnedMiscHours;
    }

    public void setEarnedMiscHours(Double earnedMiscHours) {
        this.earnedMiscHours = earnedMiscHours;
    }

    @Column(name = "`EarnedAllHours`", nullable = true, scale = 6, precision = 16)
    public Double getEarnedAllHours() {
        return this.earnedAllHours;
    }

    public void setEarnedAllHours(Double earnedAllHours) {
        this.earnedAllHours = earnedAllHours;
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

    @Column(name = "`TimeStamp`", nullable = true)
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SteelTrackerClassic)) return false;
        final SteelTrackerClassic steelTrackerClassic = (SteelTrackerClassic) o;
        return Objects.equals(getUid(), steelTrackerClassic.getUid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid());
    }
}

