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
 * CivilMisc generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`CivilMisc`")
public class CivilMisc implements Serializable {

    private Integer id;
    private Integer fkSubmissionId;
    private String miscFoundation;
    private String miscDrawingNumber;
    private String miscDetailDrawingNumber;
    private float miscPercentComplete;
    private Short miscRework;
    private String miscNotes;
    private Short activityType;
    private Short miscTimeInForm;
    private short rev;
    private Timestamp timeStamp;
    private SubsDetails subsDetails;
    private List<CivilMiscRev> civilMiscRevs;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`fk_SubmissionID`", nullable = true, scale = 0, precision = 10)
    public Integer getFkSubmissionId() {
        return this.fkSubmissionId;
    }

    public void setFkSubmissionId(Integer fkSubmissionId) {
        this.fkSubmissionId = fkSubmissionId;
    }

    @Column(name = "`MiscFoundation`", nullable = true, length = 45)
    public String getMiscFoundation() {
        return this.miscFoundation;
    }

    public void setMiscFoundation(String miscFoundation) {
        this.miscFoundation = miscFoundation;
    }

    @Column(name = "`MiscDrawingNumber`", nullable = true, length = 45)
    public String getMiscDrawingNumber() {
        return this.miscDrawingNumber;
    }

    public void setMiscDrawingNumber(String miscDrawingNumber) {
        this.miscDrawingNumber = miscDrawingNumber;
    }

    @Column(name = "`MiscDetailDrawingNumber`", nullable = true, length = 45)
    public String getMiscDetailDrawingNumber() {
        return this.miscDetailDrawingNumber;
    }

    public void setMiscDetailDrawingNumber(String miscDetailDrawingNumber) {
        this.miscDetailDrawingNumber = miscDetailDrawingNumber;
    }

    @Column(name = "`MiscPercentComplete`", nullable = false, scale = 2, precision = 3)
    public float getMiscPercentComplete() {
        return this.miscPercentComplete;
    }

    public void setMiscPercentComplete(float miscPercentComplete) {
        this.miscPercentComplete = miscPercentComplete;
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

    @Column(name = "`MiscTimeInForm`", nullable = true, scale = 0, precision = 3)
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

    @Column(name = "`TimeStamp`", nullable = true)
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_SubmissionID`", referencedColumnName = "`SubmissionID`", insertable = false, updatable = false)
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
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "civilMisc")
    public List<CivilMiscRev> getCivilMiscRevs() {
        return this.civilMiscRevs;
    }

    public void setCivilMiscRevs(List<CivilMiscRev> civilMiscRevs) {
        this.civilMiscRevs = civilMiscRevs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CivilMisc)) return false;
        final CivilMisc civilMisc = (CivilMisc) o;
        return Objects.equals(getId(), civilMisc.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

