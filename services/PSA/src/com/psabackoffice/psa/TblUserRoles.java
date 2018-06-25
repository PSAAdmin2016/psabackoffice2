/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * TblUserRoles generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`tblUserRoles`")
public class TblUserRoles implements Serializable {

    private Integer id;
    private Integer userId;
    private Integer roleId;
    private Timestamp timeStamp;
    private RefRoles refRoles;
    private TblUserPsa tblUserPsa;

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

    @Column(name = "`RoleID`", nullable = true, scale = 0, precision = 10)
    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Column(name = "`TimeStamp`", nullable = true)
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`RoleID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`UserRoles_UserRoles_Roles`"))
    @Fetch(FetchMode.JOIN)
    public RefRoles getRefRoles() {
        return this.refRoles;
    }

    public void setRefRoles(RefRoles refRoles) {
        if(refRoles != null) {
            this.roleId = refRoles.getId();
        }

        this.refRoles = refRoles;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`UserID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`UserRoles_UserID_UserPSA`"))
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TblUserRoles)) return false;
        final TblUserRoles tblUserRoles = (TblUserRoles) o;
        return Objects.equals(getId(), tblUserRoles.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

