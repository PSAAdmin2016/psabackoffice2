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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * SubmissionActivityStatus generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SubmissionActivityStatus`")
public class SubmissionActivityStatus implements Serializable {

    private Integer activityId;
    private Integer submissionId;
    private Short activityType;
    private Integer fkBidIdassigned;
    private Integer fkActivityStatus;
    private Integer fkLastModifiedBy;
    private Integer lockField;
    private short rev;
    private Timestamp timeStamp;
    private SubsDetails subsDetails;
    private CivilFa civilFa;
    private CivilSellPackage civilSellPackage;
    private EquipFa equipFa;
    private PipeConnection pipeConnection;
    private PipeDemo pipeDemo;
    private PipeErection pipeErection;
    private PipeMisc pipeMisc;
    private PipeSupports pipeSupports;
    private PipeTesting pipeTesting;
    private PipeTrim pipeTrim;
    private PipeWeld pipeWeld;
    private List<Sasnotes> sasnoteses;
    private SteelDemo steelDemo;
    private SteelFa steelFa;
    private SteelMisc steelMisc;
    private SteelSellPackage steelSellPackage;
    private SubsDelay subsDelay;
    private List<SubsEwo> subsEwos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ActivityID`", nullable = false, scale = 0, precision = 10)
    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Column(name = "`SubmissionID`", nullable = true, scale = 0, precision = 10)
    public Integer getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    @Column(name = "`ActivityType`", nullable = true, scale = 0, precision = 3)
    public Short getActivityType() {
        return this.activityType;
    }

    public void setActivityType(Short activityType) {
        this.activityType = activityType;
    }

    @Column(name = "`fk_BidIDAssigned`", nullable = true, scale = 0, precision = 10)
    public Integer getFkBidIdassigned() {
        return this.fkBidIdassigned;
    }

    public void setFkBidIdassigned(Integer fkBidIdassigned) {
        this.fkBidIdassigned = fkBidIdassigned;
    }

    @Column(name = "`fk_ActivityStatus`", nullable = true, scale = 0, precision = 3)
    public Integer getFkActivityStatus() {
        return this.fkActivityStatus;
    }

    public void setFkActivityStatus(Integer fkActivityStatus) {
        this.fkActivityStatus = fkActivityStatus;
    }

    @Column(name = "`fk_LastModifiedBy`", nullable = true, scale = 0, precision = 10)
    public Integer getFkLastModifiedBy() {
        return this.fkLastModifiedBy;
    }

    public void setFkLastModifiedBy(Integer fkLastModifiedBy) {
        this.fkLastModifiedBy = fkLastModifiedBy;
    }

    @Column(name = "`LockField`", nullable = true, scale = 0, precision = 7)
    public Integer getLockField() {
        return this.lockField;
    }

    public void setLockField(Integer lockField) {
        this.lockField = lockField;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`SubmissionID`", referencedColumnName = "`SubmissionID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`SAS_SubmissionID_to_SD_SubmissionID`"))
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

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public CivilFa getCivilFa() {
        return this.civilFa;
    }

    public void setCivilFa(CivilFa civilFa) {
        this.civilFa = civilFa;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public CivilSellPackage getCivilSellPackage() {
        return this.civilSellPackage;
    }

    public void setCivilSellPackage(CivilSellPackage civilSellPackage) {
        this.civilSellPackage = civilSellPackage;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public EquipFa getEquipFa() {
        return this.equipFa;
    }

    public void setEquipFa(EquipFa equipFa) {
        this.equipFa = equipFa;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public PipeConnection getPipeConnection() {
        return this.pipeConnection;
    }

    public void setPipeConnection(PipeConnection pipeConnection) {
        this.pipeConnection = pipeConnection;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public PipeDemo getPipeDemo() {
        return this.pipeDemo;
    }

    public void setPipeDemo(PipeDemo pipeDemo) {
        this.pipeDemo = pipeDemo;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public PipeErection getPipeErection() {
        return this.pipeErection;
    }

    public void setPipeErection(PipeErection pipeErection) {
        this.pipeErection = pipeErection;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public PipeMisc getPipeMisc() {
        return this.pipeMisc;
    }

    public void setPipeMisc(PipeMisc pipeMisc) {
        this.pipeMisc = pipeMisc;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public PipeSupports getPipeSupports() {
        return this.pipeSupports;
    }

    public void setPipeSupports(PipeSupports pipeSupports) {
        this.pipeSupports = pipeSupports;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public PipeTesting getPipeTesting() {
        return this.pipeTesting;
    }

    public void setPipeTesting(PipeTesting pipeTesting) {
        this.pipeTesting = pipeTesting;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public PipeTrim getPipeTrim() {
        return this.pipeTrim;
    }

    public void setPipeTrim(PipeTrim pipeTrim) {
        this.pipeTrim = pipeTrim;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public PipeWeld getPipeWeld() {
        return this.pipeWeld;
    }

    public void setPipeWeld(PipeWeld pipeWeld) {
        this.pipeWeld = pipeWeld;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<Sasnotes> getSasnoteses() {
        return this.sasnoteses;
    }

    public void setSasnoteses(List<Sasnotes> sasnoteses) {
        this.sasnoteses = sasnoteses;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public SteelDemo getSteelDemo() {
        return this.steelDemo;
    }

    public void setSteelDemo(SteelDemo steelDemo) {
        this.steelDemo = steelDemo;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public SteelFa getSteelFa() {
        return this.steelFa;
    }

    public void setSteelFa(SteelFa steelFa) {
        this.steelFa = steelFa;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public SteelMisc getSteelMisc() {
        return this.steelMisc;
    }

    public void setSteelMisc(SteelMisc steelMisc) {
        this.steelMisc = steelMisc;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public SteelSellPackage getSteelSellPackage() {
        return this.steelSellPackage;
    }

    public void setSteelSellPackage(SteelSellPackage steelSellPackage) {
        this.steelSellPackage = steelSellPackage;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public SubsDelay getSubsDelay() {
        return this.subsDelay;
    }

    public void setSubsDelay(SubsDelay subsDelay) {
        this.subsDelay = subsDelay;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "submissionActivityStatus")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<SubsEwo> getSubsEwos() {
        return this.subsEwos;
    }

    public void setSubsEwos(List<SubsEwo> subsEwos) {
        this.subsEwos = subsEwos;
    }

    @PostPersist
    public void onPostPersist() {
        if(civilFa != null) {
            civilFa.setSubmissionActivityStatus(this);
        }
        if(civilSellPackage != null) {
            civilSellPackage.setSubmissionActivityStatus(this);
        }
        if(equipFa != null) {
            equipFa.setSubmissionActivityStatus(this);
        }
        if(pipeConnection != null) {
            pipeConnection.setSubmissionActivityStatus(this);
        }
        if(pipeDemo != null) {
            pipeDemo.setSubmissionActivityStatus(this);
        }
        if(pipeErection != null) {
            pipeErection.setSubmissionActivityStatus(this);
        }
        if(pipeMisc != null) {
            pipeMisc.setSubmissionActivityStatus(this);
        }
        if(pipeSupports != null) {
            pipeSupports.setSubmissionActivityStatus(this);
        }
        if(pipeTesting != null) {
            pipeTesting.setSubmissionActivityStatus(this);
        }
        if(pipeTrim != null) {
            pipeTrim.setSubmissionActivityStatus(this);
        }
        if(pipeWeld != null) {
            pipeWeld.setSubmissionActivityStatus(this);
        }
        if(sasnoteses != null) {
            for(Sasnotes sasnotes : sasnoteses) {
                sasnotes.setSubmissionActivityStatus(this);
            }
        }
        if(steelDemo != null) {
            steelDemo.setSubmissionActivityStatus(this);
        }
        if(steelFa != null) {
            steelFa.setSubmissionActivityStatus(this);
        }
        if(steelMisc != null) {
            steelMisc.setSubmissionActivityStatus(this);
        }
        if(steelSellPackage != null) {
            steelSellPackage.setSubmissionActivityStatus(this);
        }
        if(subsDelay != null) {
            subsDelay.setSubmissionActivityStatus(this);
        }
        if(subsEwos != null) {
            for(SubsEwo subsEwo : subsEwos) {
                subsEwo.setSubmissionActivityStatus(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubmissionActivityStatus)) return false;
        final SubmissionActivityStatus submissionActivityStatus = (SubmissionActivityStatus) o;
        return Objects.equals(getActivityId(), submissionActivityStatus.getActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityId());
    }
}

