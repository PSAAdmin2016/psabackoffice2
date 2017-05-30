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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SubsSupportsRev generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SubsSupportsREV`")
public class SubsSupportsRev implements Serializable {

    private Integer id;
    private int fkOrgActivityId;
    private Integer submissionId;
    private Short supportType;
    private String supportPartNumber;
    private Float supportQuantity;
    private String supportDrawingNumber;
    private String supportLineNumber;
    private String supportSheetNumber;
    private Short supportTimeInForm;
    private Short supportComplete;
    private Short supportShared;
    private Integer supportPercentCompleted;
    private Short supportRework;
    private String supportNotes;
    private Short activityType;
    private short rev;
    private Timestamp timeStamp;
    private SubsSupports subsSupports;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`fk_OrgActivityId`", nullable = false, scale = 0, precision = 10)
    public int getFkOrgActivityId() {
        return this.fkOrgActivityId;
    }

    public void setFkOrgActivityId(int fkOrgActivityId) {
        this.fkOrgActivityId = fkOrgActivityId;
    }

    @Column(name = "`SubmissionId`", nullable = true, scale = 0, precision = 10)
    public Integer getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    @Column(name = "`SupportType`", nullable = true, scale = 0, precision = 3)
    public Short getSupportType() {
        return this.supportType;
    }

    public void setSupportType(Short supportType) {
        this.supportType = supportType;
    }

    @Column(name = "`SupportPartNumber`", nullable = true, length = 45)
    public String getSupportPartNumber() {
        return this.supportPartNumber;
    }

    public void setSupportPartNumber(String supportPartNumber) {
        this.supportPartNumber = supportPartNumber;
    }

    @Column(name = "`SupportQuantity`", nullable = true, scale = 2, precision = 5)
    public Float getSupportQuantity() {
        return this.supportQuantity;
    }

    public void setSupportQuantity(Float supportQuantity) {
        this.supportQuantity = supportQuantity;
    }

    @Column(name = "`SupportDrawingNumber`", nullable = true, length = 45)
    public String getSupportDrawingNumber() {
        return this.supportDrawingNumber;
    }

    public void setSupportDrawingNumber(String supportDrawingNumber) {
        this.supportDrawingNumber = supportDrawingNumber;
    }

    @Column(name = "`SupportLineNumber`", nullable = true, length = 45)
    public String getSupportLineNumber() {
        return this.supportLineNumber;
    }

    public void setSupportLineNumber(String supportLineNumber) {
        this.supportLineNumber = supportLineNumber;
    }

    @Column(name = "`SupportSheetNumber`", nullable = true, length = 3)
    public String getSupportSheetNumber() {
        return this.supportSheetNumber;
    }

    public void setSupportSheetNumber(String supportSheetNumber) {
        this.supportSheetNumber = supportSheetNumber;
    }

    @Column(name = "`SupportTimeInForm`", nullable = true, scale = 0, precision = 5)
    public Short getSupportTimeInForm() {
        return this.supportTimeInForm;
    }

    public void setSupportTimeInForm(Short supportTimeInForm) {
        this.supportTimeInForm = supportTimeInForm;
    }

    @Column(name = "`SupportComplete`", nullable = true, scale = 0, precision = 3)
    public Short getSupportComplete() {
        return this.supportComplete;
    }

    public void setSupportComplete(Short supportComplete) {
        this.supportComplete = supportComplete;
    }

    @Column(name = "`SupportShared`", nullable = true, scale = 0, precision = 3)
    public Short getSupportShared() {
        return this.supportShared;
    }

    public void setSupportShared(Short supportShared) {
        this.supportShared = supportShared;
    }

    @Column(name = "`SupportPercentCompleted`", nullable = true, scale = 0, precision = 10)
    public Integer getSupportPercentCompleted() {
        return this.supportPercentCompleted;
    }

    public void setSupportPercentCompleted(Integer supportPercentCompleted) {
        this.supportPercentCompleted = supportPercentCompleted;
    }

    @Column(name = "`SupportRework`", nullable = true, scale = 0, precision = 3)
    public Short getSupportRework() {
        return this.supportRework;
    }

    public void setSupportRework(Short supportRework) {
        this.supportRework = supportRework;
    }

    @Column(name = "`SupportNotes`", nullable = true, length = 255)
    public String getSupportNotes() {
        return this.supportNotes;
    }

    public void setSupportNotes(String supportNotes) {
        this.supportNotes = supportNotes;
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
    @JoinColumn(name = "`fk_OrgActivityId`", referencedColumnName = "`ID`", insertable = false, updatable = false)
    public SubsSupports getSubsSupports() {
        return this.subsSupports;
    }

    public void setSubsSupports(SubsSupports subsSupports) {
        if(subsSupports != null) {
            this.fkOrgActivityId = subsSupports.getId();
        }

        this.subsSupports = subsSupports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubsSupportsRev)) return false;
        final SubsSupportsRev subsSupportsRev = (SubsSupportsRev) o;
        return Objects.equals(getId(), subsSupportsRev.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

