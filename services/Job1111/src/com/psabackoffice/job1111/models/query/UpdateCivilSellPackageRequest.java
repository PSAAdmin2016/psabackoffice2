/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCivilSellPackageRequest implements Serializable {

    @JsonProperty("TestPackageNumber")
    private String testPackageNumber;
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
        if (!(o instanceof UpdateCivilSellPackageRequest)) return false;
        final UpdateCivilSellPackageRequest updateCivilSellPackageRequest = (UpdateCivilSellPackageRequest) o;
        return Objects.equals(getTestPackageNumber(), updateCivilSellPackageRequest.getTestPackageNumber()) &&
                Objects.equals(getNotes(), updateCivilSellPackageRequest.getNotes()) &&
                Objects.equals(getRowId(), updateCivilSellPackageRequest.getRowId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestPackageNumber(),
                getNotes(),
                getRowId());
    }
}
