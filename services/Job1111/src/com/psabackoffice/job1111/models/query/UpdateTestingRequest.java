/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateTestingRequest implements Serializable {

    @JsonProperty("TestPackageNumber")
    private String testPackageNumber;
    @JsonProperty("Rework")
    private Integer rework;
    @JsonProperty("Notes")
    private String notes;
    @JsonProperty("RowID")
    private Integer rowId;

    public String getTestPackageNumber() {
        return this.testPackageNumber;
    }

    public void setTestPackageNumber(String testPackageNumber) {
        this.testPackageNumber = testPackageNumber;
    }

    public Integer getRework() {
        return this.rework;
    }

    public void setRework(Integer rework) {
        this.rework = rework;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getRowId() {
        return this.rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateTestingRequest)) return false;
        final UpdateTestingRequest updateTestingRequest = (UpdateTestingRequest) o;
        return Objects.equals(getTestPackageNumber(), updateTestingRequest.getTestPackageNumber()) &&
                Objects.equals(getRework(), updateTestingRequest.getRework()) &&
                Objects.equals(getNotes(), updateTestingRequest.getNotes()) &&
                Objects.equals(getRowId(), updateTestingRequest.getRowId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestPackageNumber(),
                getRework(),
                getNotes(),
                getRowId());
    }
}
