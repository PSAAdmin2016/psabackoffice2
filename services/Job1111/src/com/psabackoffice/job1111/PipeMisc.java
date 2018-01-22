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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PipeMisc generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PipeMisc`")
public class PipeMisc implements Serializable {

    private Integer id;
    private int fkSubmissionId;
    private String miscDrawingNumber;
    private String miscLineNumber;
    private String miscSheetNumber;
    private Short miscTimeInForm;
    private Double miscQuantity;
    private Short miscRework;
    private String miscNotes;
    private Short activityType;
    private short rev;
    private Timestamp timeStamp;
    private SubsDetails subsDetails;

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

    @Column(name = "`MiscDrawingNumber`", nullable = true, length = 45)
    public String getMiscDrawingNumber() {
        return this.miscDrawingNumber;
    }

    public void setMiscDrawingNumber(String miscDrawingNumber) {
        this.miscDrawingNumber = miscDrawingNumber;
    }

    @Column(name = "`MiscLineNumber`", nullable = true, length = 45)
    public String getMiscLineNumber() {
        return this.miscLineNumber;
    }

    public void setMiscLineNumber(String miscLineNumber) {
        this.miscLineNumber = miscLineNumber;
    }

    @Column(name = "`MiscSheetNumber`", nullable = true, length = 3)
    public String getMiscSheetNumber() {
        return this.miscSheetNumber;
    }

    public void setMiscSheetNumber(String miscSheetNumber) {
        this.miscSheetNumber = miscSheetNumber;
    }

    @Column(name = "`MiscTimeInForm`", nullable = true, scale = 0, precision = 5)
    public Short getMiscTimeInForm() {
        return this.miscTimeInForm;
    }

    public void setMiscTimeInForm(Short miscTimeInForm) {
        this.miscTimeInForm = miscTimeInForm;
    }

    @Column(name = "`MiscQuantity`", nullable = true, scale = 6, precision = 18)
    public Double getMiscQuantity() {
        return this.miscQuantity;
    }

    public void setMiscQuantity(Double miscQuantity) {
        this.miscQuantity = miscQuantity;
    }

    @Column(name = "`MiscRework`", nullable = true, scale = 0, precision = 3)
    public Short getMiscRework() {
        return this.miscRework;
    }

    public void setMiscRework(Short miscRework) {
        this.miscRework = miscRework;
    }

    @Column(name = "`MiscNotes`", nullable = true, length = 255)
    public String getMiscNotes() {
        return this.miscNotes;
    }

    public void setMiscNotes(String miscNotes) {
        this.miscNotes = miscNotes;
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
    @JoinColumn(name = "`fk_SubmissionId`", referencedColumnName = "`SubmissionID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`fk_MiscSubmissionId`"))
    public SubsDetails getSubsDetails() {
        return this.subsDetails;
    }

    public void setSubsDetails(SubsDetails subsDetails) {
        if(subsDetails != null) {
            this.fkSubmissionId = subsDetails.getSubmissionId();
        }

        this.subsDetails = subsDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PipeMisc)) return false;
        final PipeMisc pipeMisc = (PipeMisc) o;
        return Objects.equals(getId(), pipeMisc.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

