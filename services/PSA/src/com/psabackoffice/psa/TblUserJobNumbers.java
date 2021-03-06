/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa;

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
 * TblUserJobNumbers generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`tblUserJobNumbers`")
public class TblUserJobNumbers implements Serializable {

    private Integer id;
    private Integer fkUserId;
    private Integer fkJobNumber;
    private TblUserPsa tblUserPsa;
    private TblJobNumbers tblJobNumbers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`fk_UserId`", nullable = true, scale = 0, precision = 10)
    public Integer getFkUserId() {
        return this.fkUserId;
    }

    public void setFkUserId(Integer fkUserId) {
        this.fkUserId = fkUserId;
    }

    @Column(name = "`fk_JobNumber`", nullable = true, scale = 0, precision = 10)
    public Integer getFkJobNumber() {
        return this.fkJobNumber;
    }

    public void setFkJobNumber(Integer fkJobNumber) {
        this.fkJobNumber = fkJobNumber;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_UserId`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`fk_UserId_tblUserPSA`"))
    @Fetch(FetchMode.JOIN)
    public TblUserPsa getTblUserPsa() {
        return this.tblUserPsa;
    }

    public void setTblUserPsa(TblUserPsa tblUserPsa) {
        if(tblUserPsa != null) {
            this.fkUserId = tblUserPsa.getId();
        }

        this.tblUserPsa = tblUserPsa;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_JobNumber`", referencedColumnName = "`JobNumber`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`fk_JobNumbers_tblJobNumbers`"))
    @Fetch(FetchMode.JOIN)
    public TblJobNumbers getTblJobNumbers() {
        return this.tblJobNumbers;
    }

    public void setTblJobNumbers(TblJobNumbers tblJobNumbers) {
        if(tblJobNumbers != null) {
            this.fkJobNumber = tblJobNumbers.getJobNumber();
        }

        this.tblJobNumbers = tblJobNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TblUserJobNumbers)) return false;
        final TblUserJobNumbers tblUserJobNumbers = (TblUserJobNumbers) o;
        return Objects.equals(getId(), tblUserJobNumbers.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

