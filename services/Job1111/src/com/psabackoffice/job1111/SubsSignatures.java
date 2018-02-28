/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * SubsSignatures generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SubsSignatures`")
public class SubsSignatures implements Serializable {

    private Integer id;
    private Integer submissionId;
    private String signatureData;
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

    @Column(name = "`SubmissionID`", nullable = true, scale = 0, precision = 10)
    public Integer getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    @Column(name = "`SignatureData`", nullable = true, length = 65535)
    public String getSignatureData() {
        return this.signatureData;
    }

    public void setSignatureData(String signatureData) {
        this.signatureData = signatureData;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`SubmissionID`", referencedColumnName = "`SubmissionID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`SubsSigs_SubmissionID_to_SD_SubmissionID`"))
    @Fetch(FetchMode.JOIN)
    public SubsDetails getSubsDetails() {
        return this.subsDetails;
    }

    public void setSubsDetails(SubsDetails subsDetails) {
        if(subsDetails != null) {
            this.submissionId = subsDetails.getSubmissionId();
        }

        this.subsDetails = subsDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubsSignatures)) return false;
        final SubsSignatures subsSignatures = (SubsSignatures) o;
        return Objects.equals(getId(), subsSignatures.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

