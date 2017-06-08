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
 * SteelImp generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SteelImp`")
public class SteelImp implements Serializable {

    private Integer activityId;
    private String faarea;
    private String fapieceNumber;
    private short faimpQuantity;
    private Float faimpPercent;
    private Short farework;
    private String fanotes;
    private Short activityType;
    private Short fatimeInForm;
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

    @Column(name = "`FAArea`", nullable = true, length = 45)
    public String getFaarea() {
        return this.faarea;
    }

    public void setFaarea(String faarea) {
        this.faarea = faarea;
    }

    @Column(name = "`FAPieceNumber`", nullable = true, length = 45)
    public String getFapieceNumber() {
        return this.fapieceNumber;
    }

    public void setFapieceNumber(String fapieceNumber) {
        this.fapieceNumber = fapieceNumber;
    }

    @Column(name = "`FAImpQuantity`", nullable = false, scale = 0, precision = 3)
    public short getFaimpQuantity() {
        return this.faimpQuantity;
    }

    public void setFaimpQuantity(short faimpQuantity) {
        this.faimpQuantity = faimpQuantity;
    }

    @Column(name = "`FAImpPercent`", nullable = true, scale = 2, precision = 3)
    public Float getFaimpPercent() {
        return this.faimpPercent;
    }

    public void setFaimpPercent(Float faimpPercent) {
        this.faimpPercent = faimpPercent;
    }

    @Column(name = "`FARework`", nullable = true, scale = 0, precision = 3)
    public Short getFarework() {
        return this.farework;
    }

    public void setFarework(Short farework) {
        this.farework = farework;
    }

    @Column(name = "`FANotes`", nullable = true, length = 255)
    public String getFanotes() {
        return this.fanotes;
    }

    public void setFanotes(String fanotes) {
        this.fanotes = fanotes;
    }

    @Column(name = "`ActivityType`", nullable = true, scale = 0, precision = 3)
    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
    }

    @Column(name = "`FATimeInForm`", nullable = true, scale = 0, precision = 3)
    public Short getFatimeInForm() {
        return this.fatimeInForm;
    }

    public void setFatimeInForm(Short fatimeInForm) {
        this.fatimeInForm = fatimeInForm;
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
        if (!(o instanceof SteelImp)) return false;
        final SteelImp steelImp = (SteelImp) o;
        return Objects.equals(getActivityId(), steelImp.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId());
    }
}

