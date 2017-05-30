/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * SubsWeld generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SubsWeld`")
public class SubsWeld implements Serializable {

    private Integer id;
    private int fkSubmissionId;
    private String weldSpool1;
    private String weldSpool2;
    private String weldDrawingNumber;
    private String weldLineNumber;
    private String weldSheetNumber;
    private Short weldTimeInForm;
    private String weldLineSpec;
    private String weldNumber;
    private String weldStencil;
    private Float weldSize;
    private String weldThickness;
    private String weldType;
    private String weldPosition;
    private String weldMaterial;
    private String weldProcedure;
    private Short weldComplete;
    private Short weldShared;
    private String weldPercentCompleteChoice;
    private Integer weldPercentCompleted;
    private Short weldRework;
    private String weldNotes;
    private Short activityType;
    private short rev;
    private Timestamp timeStamp;
    private SubsDetails subsDetails;
    private List<SubsWeldRev> subsWeldRevs;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`fk_SubmissionId`", nullable = false, scale = 0, precision = 10)
    public int getFkSubmissionId() {
        return this.fkSubmissionId;
    }

    public void setFkSubmissionId(int fkSubmissionId) {
        this.fkSubmissionId = fkSubmissionId;
    }

    @Column(name = "`WeldSpool1`", nullable = true, length = 45)
    public String getWeldSpool1() {
        return this.weldSpool1;
    }

    public void setWeldSpool1(String weldSpool1) {
        this.weldSpool1 = weldSpool1;
    }

    @Column(name = "`WeldSpool2`", nullable = true, length = 45)
    public String getWeldSpool2() {
        return this.weldSpool2;
    }

    public void setWeldSpool2(String weldSpool2) {
        this.weldSpool2 = weldSpool2;
    }

    @Column(name = "`WeldDrawingNumber`", nullable = true, length = 45)
    public String getWeldDrawingNumber() {
        return this.weldDrawingNumber;
    }

    public void setWeldDrawingNumber(String weldDrawingNumber) {
        this.weldDrawingNumber = weldDrawingNumber;
    }

    @Column(name = "`WeldLineNumber`", nullable = true, length = 45)
    public String getWeldLineNumber() {
        return this.weldLineNumber;
    }

    public void setWeldLineNumber(String weldLineNumber) {
        this.weldLineNumber = weldLineNumber;
    }

    @Column(name = "`WeldSheetNumber`", nullable = true, length = 3)
    public String getWeldSheetNumber() {
        return this.weldSheetNumber;
    }

    public void setWeldSheetNumber(String weldSheetNumber) {
        this.weldSheetNumber = weldSheetNumber;
    }

    @Column(name = "`WeldTimeInForm`", nullable = true, scale = 0, precision = 5)
    public Short getWeldTimeInForm() {
        return this.weldTimeInForm;
    }

    public void setWeldTimeInForm(Short weldTimeInForm) {
        this.weldTimeInForm = weldTimeInForm;
    }

    @Column(name = "`WeldLineSpec`", nullable = true, length = 32)
    public String getWeldLineSpec() {
        return this.weldLineSpec;
    }

    public void setWeldLineSpec(String weldLineSpec) {
        this.weldLineSpec = weldLineSpec;
    }

    @Column(name = "`WeldNumber`", nullable = true, length = 32)
    public String getWeldNumber() {
        return this.weldNumber;
    }

    public void setWeldNumber(String weldNumber) {
        this.weldNumber = weldNumber;
    }

    @Column(name = "`WeldStencil`", nullable = true, length = 8)
    public String getWeldStencil() {
        return this.weldStencil;
    }

    public void setWeldStencil(String weldStencil) {
        this.weldStencil = weldStencil;
    }

    @Column(name = "`WeldSize`", nullable = true, scale = 2, precision = 5)
    public Float getWeldSize() {
        return this.weldSize;
    }

    public void setWeldSize(Float weldSize) {
        this.weldSize = weldSize;
    }

    @Column(name = "`WeldThickness`", nullable = true, length = 8)
    public String getWeldThickness() {
        return this.weldThickness;
    }

    public void setWeldThickness(String weldThickness) {
        this.weldThickness = weldThickness;
    }

    @Column(name = "`WeldType`", nullable = true, length = 32)
    public String getWeldType() {
        return this.weldType;
    }

    public void setWeldType(String weldType) {
        this.weldType = weldType;
    }

    @Column(name = "`WeldPosition`", nullable = true, length = 8)
    public String getWeldPosition() {
        return this.weldPosition;
    }

    public void setWeldPosition(String weldPosition) {
        this.weldPosition = weldPosition;
    }

    @Column(name = "`WeldMaterial`", nullable = true, length = 32)
    public String getWeldMaterial() {
        return this.weldMaterial;
    }

    public void setWeldMaterial(String weldMaterial) {
        this.weldMaterial = weldMaterial;
    }

    @Column(name = "`WeldProcedure`", nullable = true, length = 32)
    public String getWeldProcedure() {
        return this.weldProcedure;
    }

    public void setWeldProcedure(String weldProcedure) {
        this.weldProcedure = weldProcedure;
    }

    @Column(name = "`WeldComplete`", nullable = true, scale = 0, precision = 3)
    public Short getWeldComplete() {
        return this.weldComplete;
    }

    public void setWeldComplete(Short weldComplete) {
        this.weldComplete = weldComplete;
    }

    @Column(name = "`WeldShared`", nullable = true, scale = 0, precision = 3)
    public Short getWeldShared() {
        return this.weldShared;
    }

    public void setWeldShared(Short weldShared) {
        this.weldShared = weldShared;
    }

    @Column(name = "`WeldPercentCompleteChoice`", nullable = true, length = 8)
    public String getWeldPercentCompleteChoice() {
        return this.weldPercentCompleteChoice;
    }

    public void setWeldPercentCompleteChoice(String weldPercentCompleteChoice) {
        this.weldPercentCompleteChoice = weldPercentCompleteChoice;
    }

    @Column(name = "`WeldPercentCompleted`", nullable = true, scale = 0, precision = 10)
    public Integer getWeldPercentCompleted() {
        return this.weldPercentCompleted;
    }

    public void setWeldPercentCompleted(Integer weldPercentCompleted) {
        this.weldPercentCompleted = weldPercentCompleted;
    }

    @Column(name = "`WeldRework`", nullable = true, scale = 0, precision = 3)
    public Short getWeldRework() {
        return this.weldRework;
    }

    public void setWeldRework(Short weldRework) {
        this.weldRework = weldRework;
    }

    @Column(name = "`WeldNotes`", nullable = true, length = 255)
    public String getWeldNotes() {
        return this.weldNotes;
    }

    public void setWeldNotes(String weldNotes) {
        this.weldNotes = weldNotes;
    }

    @Column(name = "`ActivityType`", nullable = true, scale = 0, precision = 3)
    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_SubmissionId`", referencedColumnName = "`SubmissionID`", insertable = false, updatable = false)
    public SubsDetails getSubsDetails() {
        return this.subsDetails;
    }

    public void setSubsDetails(SubsDetails subsDetails) {
        if(subsDetails != null) {
            this.fkSubmissionId = subsDetails.getSubmissionId();
        }

        this.subsDetails = subsDetails;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "subsWeld")
    public List<SubsWeldRev> getSubsWeldRevs() {
        return this.subsWeldRevs;
    }

    public void setSubsWeldRevs(List<SubsWeldRev> subsWeldRevs) {
        this.subsWeldRevs = subsWeldRevs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubsWeld)) return false;
        final SubsWeld subsWeld = (SubsWeld) o;
        return Objects.equals(getId(), subsWeld.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

