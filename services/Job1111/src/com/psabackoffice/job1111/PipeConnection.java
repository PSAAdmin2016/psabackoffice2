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
 * PipeConnection generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PipeConnection`")
public class PipeConnection implements Serializable {

    private Integer activityId;
    private Integer connectionBidId;
    private String connectionSpool1;
    private String connectionSpool2;
    private String connectionDrawingNumber;
    private String connectionLineNumber;
    private String connectionSheetNumber;
    private Float connectionSize;
    private Short connectionQuantity;
    private Short connectionRework;
    private String connectionNotes;
    private Short activityType;
    private Short connectionTimeInForm;
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

    @Column(name = "`ConnectionBidID`", nullable = true, scale = 0, precision = 10)
    public Integer getConnectionBidId() {
        return this.connectionBidId;
    }

    public void setConnectionBidId(Integer connectionBidId) {
        this.connectionBidId = connectionBidId;
    }

    @Column(name = "`ConnectionSpool1`", nullable = true, length = 45)
    public String getConnectionSpool1() {
        return this.connectionSpool1;
    }

    public void setConnectionSpool1(String connectionSpool1) {
        this.connectionSpool1 = connectionSpool1;
    }

    @Column(name = "`ConnectionSpool2`", nullable = true, length = 45)
    public String getConnectionSpool2() {
        return this.connectionSpool2;
    }

    public void setConnectionSpool2(String connectionSpool2) {
        this.connectionSpool2 = connectionSpool2;
    }

    @Column(name = "`ConnectionDrawingNumber`", nullable = true, length = 45)
    public String getConnectionDrawingNumber() {
        return this.connectionDrawingNumber;
    }

    public void setConnectionDrawingNumber(String connectionDrawingNumber) {
        this.connectionDrawingNumber = connectionDrawingNumber;
    }

    @Column(name = "`ConnectionLineNumber`", nullable = true, length = 45)
    public String getConnectionLineNumber() {
        return this.connectionLineNumber;
    }

    public void setConnectionLineNumber(String connectionLineNumber) {
        this.connectionLineNumber = connectionLineNumber;
    }

    @Column(name = "`ConnectionSheetNumber`", nullable = true, length = 3)
    public String getConnectionSheetNumber() {
        return this.connectionSheetNumber;
    }

    public void setConnectionSheetNumber(String connectionSheetNumber) {
        this.connectionSheetNumber = connectionSheetNumber;
    }

    @Column(name = "`ConnectionSize`", nullable = true, scale = 2, precision = 5)
    public Float getConnectionSize() {
        return this.connectionSize;
    }

    public void setConnectionSize(Float connectionSize) {
        this.connectionSize = connectionSize;
    }

    @Column(name = "`ConnectionQuantity`", nullable = true, scale = 0, precision = 3)
    public Short getConnectionQuantity() {
        return this.connectionQuantity;
    }

    public void setConnectionQuantity(Short connectionQuantity) {
        this.connectionQuantity = connectionQuantity;
    }

    @Column(name = "`ConnectionRework`", nullable = true, scale = 0, precision = 3)
    public Short getConnectionRework() {
        return this.connectionRework;
    }

    public void setConnectionRework(Short connectionRework) {
        this.connectionRework = connectionRework;
    }

    @Column(name = "`ConnectionNotes`", nullable = true, length = 255)
    public String getConnectionNotes() {
        return this.connectionNotes;
    }

    public void setConnectionNotes(String connectionNotes) {
        this.connectionNotes = connectionNotes;
    }

    @Column(name = "`ActivityType`", nullable = true, scale = 0, precision = 3)
    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
    }

    @Column(name = "`ConnectionTimeInForm`", nullable = true, scale = 0, precision = 5)
    public Short getConnectionTimeInForm() {
        return this.connectionTimeInForm;
    }

    public void setConnectionTimeInForm(Short connectionTimeInForm) {
        this.connectionTimeInForm = connectionTimeInForm;
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
    @JoinColumn(name = "`ActivityID`", referencedColumnName = "`ActivityID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`PipeConnection_ActivityID_to_SASActivityID`"))
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
        if (!(o instanceof PipeConnection)) return false;
        final PipeConnection pipeConnection = (PipeConnection) o;
        return Objects.equals(getActivityId(), pipeConnection.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId());
    }
}

