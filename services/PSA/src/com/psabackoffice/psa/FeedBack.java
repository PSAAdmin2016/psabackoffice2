/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa;

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
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * FeedBack generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`FeedBack`")
public class FeedBack implements Serializable {

    private Integer id;
    private Integer userId;
    private Integer feedBackType;
    private Integer severity;
    private Integer status;
    private Timestamp timeStamp;
    private RefFbTypes refFbTypes;
    private TblUserPsa tblUserPsa;
    private RefFbStatuses refFbStatuses;
    private RefFbSeverity refFbSeverity;
    private List<FeedBackNotes> feedBackNoteses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`UserID`", nullable = true, scale = 0, precision = 10)
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "`FeedBackType`", nullable = true, scale = 0, precision = 10)
    public Integer getFeedBackType() {
        return this.feedBackType;
    }

    public void setFeedBackType(Integer feedBackType) {
        this.feedBackType = feedBackType;
    }

    @Column(name = "`Severity`", nullable = true, scale = 0, precision = 10)
    public Integer getSeverity() {
        return this.severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    @Column(name = "`Status`", nullable = true, scale = 0, precision = 10)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "`TimeStamp`", nullable = true)
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`FeedBackType`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`fk_FeedBackType_FeedBackTypes`"))
    @Fetch(FetchMode.JOIN)
    public RefFbTypes getRefFbTypes() {
        return this.refFbTypes;
    }

    public void setRefFbTypes(RefFbTypes refFbTypes) {
        if(refFbTypes != null) {
            this.feedBackType = refFbTypes.getId();
        }

        this.refFbTypes = refFbTypes;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`UserID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`fk_UserID_UserID`"))
    @Fetch(FetchMode.JOIN)
    public TblUserPsa getTblUserPsa() {
        return this.tblUserPsa;
    }

    public void setTblUserPsa(TblUserPsa tblUserPsa) {
        if(tblUserPsa != null) {
            this.userId = tblUserPsa.getId();
        }

        this.tblUserPsa = tblUserPsa;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`Status`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`fk_Status_Statuses`"))
    @Fetch(FetchMode.JOIN)
    public RefFbStatuses getRefFbStatuses() {
        return this.refFbStatuses;
    }

    public void setRefFbStatuses(RefFbStatuses refFbStatuses) {
        if(refFbStatuses != null) {
            this.status = refFbStatuses.getId();
        }

        this.refFbStatuses = refFbStatuses;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`Severity`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`fk_ErrorSeverity_ErrorSeverity`"))
    @Fetch(FetchMode.JOIN)
    public RefFbSeverity getRefFbSeverity() {
        return this.refFbSeverity;
    }

    public void setRefFbSeverity(RefFbSeverity refFbSeverity) {
        if(refFbSeverity != null) {
            this.severity = refFbSeverity.getId();
        }

        this.refFbSeverity = refFbSeverity;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "feedBack")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE})
    public List<FeedBackNotes> getFeedBackNoteses() {
        return this.feedBackNoteses;
    }

    public void setFeedBackNoteses(List<FeedBackNotes> feedBackNoteses) {
        this.feedBackNoteses = feedBackNoteses;
    }

    @PostPersist
    public void onPostPersist() {
        if(feedBackNoteses != null) {
            for(FeedBackNotes feedBackNotes : feedBackNoteses) {
                feedBackNotes.setFeedBack(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FeedBack)) return false;
        final FeedBack feedBack = (FeedBack) o;
        return Objects.equals(getId(), feedBack.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

