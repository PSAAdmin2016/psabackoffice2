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
 * PipeDemo generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PipeDemo`")
public class PipeDemo implements Serializable {

    private Integer id;
    private int fkSubmissionId;
    private String demoDrawingNumber;
    private String demoLineNumber;
    private String demoSheetNumber;
    private Short demoQuantity;
    private Float demoSize;
    private String demoNotes;
    private Short activityType;
    private Short demoTimeInForm;
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

    @Column(name = "`DemoDrawingNumber`", nullable = true, length = 45)
    public String getDemoDrawingNumber() {
        return this.demoDrawingNumber;
    }

    public void setDemoDrawingNumber(String demoDrawingNumber) {
        this.demoDrawingNumber = demoDrawingNumber;
    }

    @Column(name = "`DemoLineNumber`", nullable = true, length = 45)
    public String getDemoLineNumber() {
        return this.demoLineNumber;
    }

    public void setDemoLineNumber(String demoLineNumber) {
        this.demoLineNumber = demoLineNumber;
    }

    @Column(name = "`DemoSheetNumber`", nullable = true, length = 3)
    public String getDemoSheetNumber() {
        return this.demoSheetNumber;
    }

    public void setDemoSheetNumber(String demoSheetNumber) {
        this.demoSheetNumber = demoSheetNumber;
    }

    @Column(name = "`DemoQuantity`", nullable = true, scale = 0, precision = 5)
    public Short getDemoQuantity() {
        return this.demoQuantity;
    }

    public void setDemoQuantity(Short demoQuantity) {
        this.demoQuantity = demoQuantity;
    }

    @Column(name = "`DemoSize`", nullable = true, scale = 2, precision = 5)
    public Float getDemoSize() {
        return this.demoSize;
    }

    public void setDemoSize(Float demoSize) {
        this.demoSize = demoSize;
    }

    @Column(name = "`DemoNotes`", nullable = true, length = 255)
    public String getDemoNotes() {
        return this.demoNotes;
    }

    public void setDemoNotes(String demoNotes) {
        this.demoNotes = demoNotes;
    }

    @Column(name = "`ActivityType`", nullable = true, scale = 0, precision = 3)
    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
    }

    @Column(name = "`DemoTimeInForm`", nullable = true, scale = 0, precision = 5)
    public Short getDemoTimeInForm() {
        return this.demoTimeInForm;
    }

    public void setDemoTimeInForm(Short demoTimeInForm) {
        this.demoTimeInForm = demoTimeInForm;
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
    @JoinColumn(name = "`fk_SubmissionId`", referencedColumnName = "`SubmissionID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`fk_DemoSubmissionID`"))
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
        if (!(o instanceof PipeDemo)) return false;
        final PipeDemo pipeDemo = (PipeDemo) o;
        return Objects.equals(getId(), pipeDemo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

