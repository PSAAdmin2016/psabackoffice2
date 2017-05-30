/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TblUserLoginTracker generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`tblUserLoginTracker`")
public class TblUserLoginTracker implements Serializable {

    private Integer uid;
    private Integer userId;
    private String email;
    private Boolean loginResult;
    private String failedPassword;
    private Timestamp timeStamp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`UID`", nullable = false, scale = 0, precision = 10)
    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column(name = "`UserID`", nullable = true, scale = 0, precision = 10)
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "`Email`", nullable = true, length = 120)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "`LoginResult`", nullable = true)
    public Boolean getLoginResult() {
        return this.loginResult;
    }

    public void setLoginResult(Boolean loginResult) {
        this.loginResult = loginResult;
    }

    @Column(name = "`FailedPassword`", nullable = true, length = 45)
    public String getFailedPassword() {
        return this.failedPassword;
    }

    public void setFailedPassword(String failedPassword) {
        this.failedPassword = failedPassword;
    }

    @Column(name = "`TimeStamp`", nullable = true)
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TblUserLoginTracker)) return false;
        final TblUserLoginTracker tblUserLoginTracker = (TblUserLoginTracker) o;
        return Objects.equals(getUid(), tblUserLoginTracker.getUid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid());
    }
}

