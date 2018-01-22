/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
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

/**
 * RefRolesMobileFolders generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`REF_RolesMobileFolders`")
public class RefRolesMobileFolders implements Serializable {

    private Integer id;
    private Integer roleId;
    private String mobileFolder;
    private String mobileFolderName;
    private RefRoles refRoles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`RoleID`", nullable = true, scale = 0, precision = 10)
    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Column(name = "`MobileFolder`", nullable = true, length = 45)
    public String getMobileFolder() {
        return this.mobileFolder;
    }

    public void setMobileFolder(String mobileFolder) {
        this.mobileFolder = mobileFolder;
    }

    @Column(name = "`MobileFolderName`", nullable = true, length = 45)
    public String getMobileFolderName() {
        return this.mobileFolderName;
    }

    public void setMobileFolderName(String mobileFolderName) {
        this.mobileFolderName = mobileFolderName;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`RoleID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`MobileRoleIDTOREF_Roles`"))
    public RefRoles getRefRoles() {
        return this.refRoles;
    }

    public void setRefRoles(RefRoles refRoles) {
        if(refRoles != null) {
            this.roleId = refRoles.getId();
        }

        this.refRoles = refRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefRolesMobileFolders)) return false;
        final RefRolesMobileFolders refRolesMobileFolders = (RefRolesMobileFolders) o;
        return Objects.equals(getId(), refRolesMobileFolders.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

