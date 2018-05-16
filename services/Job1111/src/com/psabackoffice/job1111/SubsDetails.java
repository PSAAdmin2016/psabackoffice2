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
 * SubsDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SubsDetails`")
public class SubsDetails implements Serializable {

    private Integer submissionId;
    private String formName;
    private String formVersion;
    private Integer userId;
    private Integer crewId;
    private Short crewRev;
    private Float latitude;
    private Float longitude;
    private Timestamp startTime;
    private Timestamp completeTime;
    private Timestamp receivedTime;
    private short rev;
    private Timestamp timeStamp;
    private List<SubmissionActivityStatus> submissionActivityStatuses;
    private List<SubsSignatures> subsSignatureses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`SubmissionID`", nullable = false, scale = 0, precision = 10)
    public Integer getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    @Column(name = "`FormName`", nullable = true, length = 20)
    public String getFormName() {
        return this.formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    @Column(name = "`FormVersion`", nullable = true, length = 12)
    public String getFormVersion() {
        return this.formVersion;
    }

    public void setFormVersion(String formVersion) {
        this.formVersion = formVersion;
    }

    @Column(name = "`UserID`", nullable = true, scale = 0, precision = 10)
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "`CrewID`", nullable = true, scale = 0, precision = 10)
    public Integer getCrewId() {
        return this.crewId;
    }

    public void setCrewId(Integer crewId) {
        this.crewId = crewId;
    }

    @Column(name = "`CrewRev`", nullable = true, scale = 0, precision = 5)
    public Short getCrewRev() {
        return this.crewRev;
    }

    public void setCrewRev(Short crewRev) {
        this.crewRev = crewRev;
    }

    @Column(name = "`Latitude`", nullable = true, scale = 7, precision = 10)
    public Float getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @Column(name = "`Longitude`", nullable = true, scale = 7, precision = 10)
    public Float getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Column(name = "`StartTime`", nullable = true)
    public Timestamp getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Column(name = "`CompleteTime`", nullable = true)
    public Timestamp getCompleteTime() {
        return this.completeTime;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    @Column(name = "`ReceivedTime`", nullable = true)
    public Timestamp getReceivedTime() {
        return this.receivedTime;
    }

    public void setReceivedTime(Timestamp receivedTime) {
        this.receivedTime = receivedTime;
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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subsDetails")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<SubmissionActivityStatus> getSubmissionActivityStatuses() {
        return this.submissionActivityStatuses;
    }

    public void setSubmissionActivityStatuses(List<SubmissionActivityStatus> submissionActivityStatuses) {
        this.submissionActivityStatuses = submissionActivityStatuses;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subsDetails")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<SubsSignatures> getSubsSignatureses() {
        return this.subsSignatureses;
    }

    public void setSubsSignatureses(List<SubsSignatures> subsSignatureses) {
        this.subsSignatureses = subsSignatureses;
    }

    @PostPersist
    public void onPostPersist() {
        if(submissionActivityStatuses != null) {
            submissionActivityStatuses.forEach(submissionActivityStatus -> submissionActivityStatus.setSubsDetails(this));
        }
        if(subsSignatureses != null) {
            subsSignatureses.forEach(subsSignatures -> subsSignatures.setSubsDetails(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubsDetails)) return false;
        final SubsDetails subsDetails = (SubsDetails) o;
        return Objects.equals(getSubmissionId(), subsDetails.getSubmissionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubmissionId());
    }
}

