/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetSubDetailsSuperResponse implements Serializable {


    @ColumnAlias("FullName")
    private String fullName;

    @ColumnAlias("Email")
    private String email;

    @ColumnAlias("StartTime")
    private Timestamp startTime;

    @ColumnAlias("CompleteTime")
    private Timestamp completeTime;

    @ColumnAlias("ReceivedTime")
    private Timestamp receivedTime;

    @ColumnAlias("SignatureData")
    private String signatureData;

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getCompleteTime() {
        return this.completeTime;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    public Timestamp getReceivedTime() {
        return this.receivedTime;
    }

    public void setReceivedTime(Timestamp receivedTime) {
        this.receivedTime = receivedTime;
    }

    public String getSignatureData() {
        return this.signatureData;
    }

    public void setSignatureData(String signatureData) {
        this.signatureData = signatureData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetSubDetailsSuperResponse)) return false;
        final GetSubDetailsSuperResponse getSubDetailsSuperResponse = (GetSubDetailsSuperResponse) o;
        return Objects.equals(getFullName(), getSubDetailsSuperResponse.getFullName()) &&
                Objects.equals(getEmail(), getSubDetailsSuperResponse.getEmail()) &&
                Objects.equals(getStartTime(), getSubDetailsSuperResponse.getStartTime()) &&
                Objects.equals(getCompleteTime(), getSubDetailsSuperResponse.getCompleteTime()) &&
                Objects.equals(getReceivedTime(), getSubDetailsSuperResponse.getReceivedTime()) &&
                Objects.equals(getSignatureData(), getSubDetailsSuperResponse.getSignatureData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(),
                getEmail(),
                getStartTime(),
                getCompleteTime(),
                getReceivedTime(),
                getSignatureData());
    }
}