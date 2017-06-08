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
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * PipeEwo generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PipeEWO`")
public class PipeEwo implements Serializable {

    private Integer activityId;
    private String ewonumber;
    private Short ewohours;
    private String ewodrawingNumber;
    private String ewolineNumber;
    private String ewosheetNumber;
    private Short eworework;
    private String ewonotes;
    private Short activityType;
    private Short ewotimeInForm;
    private short rev;
    private Timestamp timeStamp;
    private SubmissionActivityStatus submissionActivityStatus;

    @Id
    @GenericGenerator(name = "generator", strategy = "foreign", 
            parameters = @Parameter(name = "property", value = "submissionActivityStatus"))
    @GeneratedValue(generator = "generator")
    @Column(name = "`ActivityID`", nullable = false, insertable = false, updatable = false, scale = 0, precision = 10)
    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Column(name = "`EWONumber`", nullable = true, length = 45)
    public String getEwonumber() {
        return this.ewonumber;
    }

    public void setEwonumber(String ewonumber) {
        this.ewonumber = ewonumber;
    }

    @Column(name = "`EWOHours`", nullable = true, scale = 0, precision = 3)
    public Short getEwohours() {
        return this.ewohours;
    }

    public void setEwohours(Short ewohours) {
        this.ewohours = ewohours;
    }

    @Column(name = "`EWODrawingNumber`", nullable = true, length = 45)
    public String getEwodrawingNumber() {
        return this.ewodrawingNumber;
    }

    public void setEwodrawingNumber(String ewodrawingNumber) {
        this.ewodrawingNumber = ewodrawingNumber;
    }

    @Column(name = "`EWOLineNumber`", nullable = true, length = 45)
    public String getEwolineNumber() {
        return this.ewolineNumber;
    }

    public void setEwolineNumber(String ewolineNumber) {
        this.ewolineNumber = ewolineNumber;
    }

    @Column(name = "`EWOSheetNumber`", nullable = true, length = 45)
    public String getEwosheetNumber() {
        return this.ewosheetNumber;
    }

    public void setEwosheetNumber(String ewosheetNumber) {
        this.ewosheetNumber = ewosheetNumber;
    }

    @Column(name = "`EWORework`", nullable = true, scale = 0, precision = 3)
    public Short getEworework() {
        return this.eworework;
    }

    public void setEworework(Short eworework) {
        this.eworework = eworework;
    }

    @Column(name = "`EWONotes`", nullable = true, length = 255)
    public String getEwonotes() {
        return this.ewonotes;
    }

    public void setEwonotes(String ewonotes) {
        this.ewonotes = ewonotes;
    }

    @Column(name = "`ActivityType`", nullable = true, scale = 0, precision = 3)
    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
    }

    @Column(name = "`EWOTimeInForm`", nullable = true, scale = 0, precision = 5)
    public Short getEwotimeInForm() {
        return this.ewotimeInForm;
    }

    public void setEwotimeInForm(Short ewotimeInForm) {
        this.ewotimeInForm = ewotimeInForm;
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

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
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
        if (!(o instanceof PipeEwo)) return false;
        final PipeEwo pipeEwo = (PipeEwo) o;
        return Objects.equals(getActivityId(), pipeEwo.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId());
    }
}

