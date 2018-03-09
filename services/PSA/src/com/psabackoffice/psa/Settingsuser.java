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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Settingsuser generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SETTINGSUser`")
public class Settingsuser implements Serializable {

    private Integer id;
    private Integer userId;
    private String label;
    private String valueString;
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

    @Column(name = "`Label`", nullable = true, length = 45)
    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Column(name = "`ValueString`", nullable = true, length = 16777215)
    public String getValueString() {
        return this.valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`UserID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`SettingsUser_to_tbleUserPSA`"))
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
        if (!(o instanceof Settingsuser)) return false;
        final Settingsuser settingsuser = (Settingsuser) o;
        return Objects.equals(getId(), settingsuser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

