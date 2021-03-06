/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
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
 * SubsDelay generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SubsDelay`")
public class SubsDelay implements Serializable {

    private Integer activityId;
    private Short delayType;
    private Short delayWorkerCount;
    private Float delayLength;
    private Short delayTimeInForm;
    private String delayNotes;
    private Short activityType;
    private short rev = 0;
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

    @Column(name = "`DelayType`", nullable = true, scale = 0, precision = 3)
    public Short getDelayType() {
        return this.delayType;
    }

    public void setDelayType(Short delayType) {
        this.delayType = delayType;
    }

    @Column(name = "`DelayWorkerCount`", nullable = true, scale = 0, precision = 3)
    public Short getDelayWorkerCount() {
        return this.delayWorkerCount;
    }

    public void setDelayWorkerCount(Short delayWorkerCount) {
        this.delayWorkerCount = delayWorkerCount;
    }

    @Column(name = "`DelayLength`", nullable = true, scale = 2, precision = 3)
    public Float getDelayLength() {
        return this.delayLength;
    }

    public void setDelayLength(Float delayLength) {
        this.delayLength = delayLength;
    }

    @Column(name = "`DelayTimeInForm`", nullable = true, scale = 0, precision = 5)
    public Short getDelayTimeInForm() {
        return this.delayTimeInForm;
    }

    public void setDelayTimeInForm(Short delayTimeInForm) {
        this.delayTimeInForm = delayTimeInForm;
    }

    @Column(name = "`DelayNotes`", nullable = true, length = 255)
    public String getDelayNotes() {
        return this.delayNotes;
    }

    public void setDelayNotes(String delayNotes) {
        this.delayNotes = delayNotes;
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

    @Column(name = "`TimeStamp`", nullable = false)
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ActivityID`", referencedColumnName = "`ActivityID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`SubsDelay_ActivityID_to_SASActivityID`"))
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
        if (!(o instanceof SubsDelay)) return false;
        final SubsDelay subsDelay = (SubsDelay) o;
        return Objects.equals(getActivityId(), subsDelay.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId());
    }
}

