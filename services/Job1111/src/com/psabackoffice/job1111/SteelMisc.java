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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * SteelMisc generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SteelMisc`")
public class SteelMisc implements Serializable {

    private Integer activityId;
    private String miscSortGroup1;
    private String miscPieceNumber;
    private Short miscQuantity;
    private Short miscRework;
    private String miscNotes;
    private Short activityType;
    private Short miscTimeInForm;
    private short rev;
    private Timestamp timeStamp;
    private SubmissionActivityStatus submissionActivityStatus;

    @Id
    @Column(name = "`ActivityID`", nullable = false, scale = 0, precision = 10)
    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Column(name = "`MiscSortGroup1`", nullable = true, length = 45)
    public String getMiscSortGroup1() {
        return this.miscSortGroup1;
    }

    public void setMiscSortGroup1(String miscSortGroup1) {
        this.miscSortGroup1 = miscSortGroup1;
    }

    @Column(name = "`MiscPieceNumber`", nullable = true, length = 45)
    public String getMiscPieceNumber() {
        return this.miscPieceNumber;
    }

    public void setMiscPieceNumber(String miscPieceNumber) {
        this.miscPieceNumber = miscPieceNumber;
    }

    @Column(name = "`MiscQuantity`", nullable = true, scale = 0, precision = 5)
    public Short getMiscQuantity() {
        return this.miscQuantity;
    }

    public void setMiscQuantity(Short miscQuantity) {
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

    @Column(name = "`MiscTimeInForm`", nullable = true, scale = 0, precision = 5)
    public Short getMiscTimeInForm() {
        return this.miscTimeInForm;
    }

    public void setMiscTimeInForm(Short miscTimeInForm) {
        this.miscTimeInForm = miscTimeInForm;
    }

    @Column(name = "`Rev`", nullable = false, scale = 0, precision = 3)
    public short getRev() {
        return this.rev;
    }

    public void setRev(short rev) {
        this.rev = rev;
    }

    @Column(name = "`TimeStamp`", nullable = false)
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ActivityID`", referencedColumnName = "`ActivityID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`SteelMisc_ActivityID_to_SASActivityID`"))
    @Fetch(FetchMode.JOIN)
    public SubmissionActivityStatus getSubmissionActivityStatus() {
        return this.submissionActivityStatus;
    }

    public void setSubmissionActivityStatus(SubmissionActivityStatus submissionActivityStatus) {
        if(submissionActivityStatus != null) {
            this.activityId = submissionActivityStatus.getActivityId();
        }

        this.submissionActivityStatus = submissionActivityStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SteelMisc)) return false;
        final SteelMisc steelMisc = (SteelMisc) o;
        return Objects.equals(getActivityId(), steelMisc.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId());
    }
}

