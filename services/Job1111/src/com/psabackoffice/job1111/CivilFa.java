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
 * CivilFa generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`CivilFA`")
public class CivilFa implements Serializable {

    private Integer id;
    private Integer fkSubmissionId;
    private Integer fabidId;
    private String fafoundation;
    private String fadescription;
    private String fadrawingNumber;
    private String fadetailDrawingNumber;
    private float fapercentComplete;
    private int faquantity;
    private Short farework;
    private String fanotes;
    private Short activityType;
    private Short fatimeInForm;
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

    @Column(name = "`fk_SubmissionID`", nullable = true, scale = 0, precision = 10)
    public Integer getFkSubmissionId() {
        return this.fkSubmissionId;
    }

    public void setFkSubmissionId(Integer fkSubmissionId) {
        this.fkSubmissionId = fkSubmissionId;
    }

    @Column(name = "`FABidID`", nullable = true, scale = 0, precision = 10)
    public Integer getFabidId() {
        return this.fabidId;
    }

    public void setFabidId(Integer fabidId) {
        this.fabidId = fabidId;
    }

    @Column(name = "`FAFoundation`", nullable = true, length = 45)
    public String getFafoundation() {
        return this.fafoundation;
    }

    public void setFafoundation(String fafoundation) {
        this.fafoundation = fafoundation;
    }

    @Column(name = "`FADescription`", nullable = true, length = 45)
    public String getFadescription() {
        return this.fadescription;
    }

    public void setFadescription(String fadescription) {
        this.fadescription = fadescription;
    }

    @Column(name = "`FADrawingNumber`", nullable = true, length = 45)
    public String getFadrawingNumber() {
        return this.fadrawingNumber;
    }

    public void setFadrawingNumber(String fadrawingNumber) {
        this.fadrawingNumber = fadrawingNumber;
    }

    @Column(name = "`FADetailDrawingNumber`", nullable = true, length = 45)
    public String getFadetailDrawingNumber() {
        return this.fadetailDrawingNumber;
    }

    public void setFadetailDrawingNumber(String fadetailDrawingNumber) {
        this.fadetailDrawingNumber = fadetailDrawingNumber;
    }

    @Column(name = "`FAPercentComplete`", nullable = false, scale = 2, precision = 3)
    public float getFapercentComplete() {
        return this.fapercentComplete;
    }

    public void setFapercentComplete(float fapercentComplete) {
        this.fapercentComplete = fapercentComplete;
    }

    @Column(name = "`FAQuantity`", nullable = false, scale = 0, precision = 7)
    public int getFaquantity() {
        return this.faquantity;
    }

    public void setFaquantity(int faquantity) {
        this.faquantity = faquantity;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_SubmissionID`", referencedColumnName = "`SubmissionID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`fk_CivilFAIDtoSubsDetails`"))
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
        if (!(o instanceof CivilFa)) return false;
        final CivilFa civilFa = (CivilFa) o;
        return Objects.equals(getId(), civilFa.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

