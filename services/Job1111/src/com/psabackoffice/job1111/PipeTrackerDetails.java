/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * PipeTrackerDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PipeTrackerDetails`")
public class PipeTrackerDetails implements Serializable {

    private Integer uid;
    private int bidId;
    private String projectServicesRep;
    private Integer ewonumber;
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
    private String lineNumber;
    private String engDrawingNumber;
    private Short sheetNumber;
    private Short drawingRev = 0;
    private String description;
    private String activityType = "0";
    private String activitySubType = "0";
    private String clientMaterialSpec = "1";
    private String performanceMaterialSpec = "1";
    private Float size = 0.00F;
    private String system;
    private String service;
    private String componentNumber;
    private Double takeOffQuantity;
    private String quantityUnit;
    private Double estimatedHours;
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
    private short rev;
    private Timestamp timeStamp;
    private List<PipeFa> pipeFas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`UID`", nullable = false, scale = 0, precision = 10)
    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column(name = "`BidID`", nullable = false, scale = 0, precision = 10)
    public int getBidId() {
        return this.bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    @Column(name = "`ProjectServicesRep`", nullable = true, length = 45)
    public String getProjectServicesRep() {
        return this.projectServicesRep;
    }

    public void setProjectServicesRep(String projectServicesRep) {
        this.projectServicesRep = projectServicesRep;
    }

    @Column(name = "`EWONumber`", nullable = true, scale = 0, precision = 7)
    public Integer getEwonumber() {
        return this.ewonumber;
    }

    public void setEwonumber(Integer ewonumber) {
        this.ewonumber = ewonumber;
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

    @Column(name = "`P6Description`", nullable = true, length = 255)
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

    @Column(name = "`LineNumber`", nullable = true, length = 45)
    public String getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Column(name = "`EngDrawingNumber`", nullable = true, length = 45)
    public String getEngDrawingNumber() {
        return this.engDrawingNumber;
    }

    public void setEngDrawingNumber(String engDrawingNumber) {
        this.engDrawingNumber = engDrawingNumber;
    }

    @Column(name = "`SheetNumber`", nullable = true, scale = 0, precision = 3)
    public Short getSheetNumber() {
        return this.sheetNumber;
    }

    public void setSheetNumber(Short sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    @Column(name = "`DrawingRev`", nullable = true, scale = 0, precision = 3)
    public Short getDrawingRev() {
        return this.drawingRev;
    }

    public void setDrawingRev(Short drawingRev) {
        this.drawingRev = drawingRev;
    }

    @Column(name = "`Description`", nullable = true, length = 255)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "`ActivityType`", nullable = true, length = 4)
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

    @Column(name = "`Size`", nullable = true, scale = 2, precision = 4)
    public Float getSize() {
        return this.size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    @Column(name = "`System`", nullable = true, length = 45)
    public String getSystem() {
        return this.system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    @Column(name = "`Service`", nullable = true, length = 32)
    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Column(name = "`ComponentNumber`", nullable = true, length = 45)
    public String getComponentNumber() {
        return this.componentNumber;
    }

    public void setComponentNumber(String componentNumber) {
        this.componentNumber = componentNumber;
    }

    @Column(name = "`TakeOffQuantity`", nullable = true, scale = 2, precision = 12)
    public Double getTakeOffQuantity() {
        return this.takeOffQuantity;
    }

    public void setTakeOffQuantity(Double takeOffQuantity) {
        this.takeOffQuantity = takeOffQuantity;
    }

    @Column(name = "`QuantityUnit`", nullable = true, length = 8)
    public String getQuantityUnit() {
        return this.quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    @Column(name = "`EstimatedHours`", nullable = true, scale = 6, precision = 16)
    public Double getEstimatedHours() {
        return this.estimatedHours;
    }

    public void setEstimatedHours(Double estimatedHours) {
        this.estimatedHours = estimatedHours;
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

    @Column(name = "`Rev`", nullable = false, scale = 0, precision = 3)
    public short getRev() {
        return this.rev;
    }

    public void setRev(short rev) {
        this.rev = rev;
    }

    @Column(name = "`TimeStamp`", nullable = true)
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pipeTrackerDetails")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<PipeFa> getPipeFas() {
        return this.pipeFas;
    }

    public void setPipeFas(List<PipeFa> pipeFas) {
        this.pipeFas = pipeFas;
    }

    @PostPersist
    public void onPostPersist() {
        if(pipeFas != null) {
            pipeFas.forEach(pipeFa -> pipeFa.setPipeTrackerDetails(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PipeTrackerDetails)) return false;
        final PipeTrackerDetails pipeTrackerDetails = (PipeTrackerDetails) o;
        return Objects.equals(getUid(), pipeTrackerDetails.getUid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid());
    }
}

