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

public class UpdateSteelSellPackageRequest implements Serializable {

    @JsonProperty("TestPackage")
    private String testPackage;
    @JsonProperty("Notes")
    private String notes;
    @NotNull
    @JsonProperty("FieldActivityID")
    private Integer fieldActivityId;

    public String getTestPackage() {
        return this.testPackage;
    }

    public void setTestPackage(String testPackage) {
        this.testPackage = testPackage;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getFieldActivityId() {
        return this.fieldActivityId;
    }

    public void setFieldActivityId(Integer fieldActivityId) {
        this.fieldActivityId = fieldActivityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateSteelSellPackageRequest)) return false;
        final UpdateSteelSellPackageRequest updateSteelSellPackageRequest = (UpdateSteelSellPackageRequest) o;
        return Objects.equals(getTestPackage(), updateSteelSellPackageRequest.getTestPackage()) &&
                Objects.equals(getNotes(), updateSteelSellPackageRequest.getNotes()) &&
                Objects.equals(getFieldActivityId(), updateSteelSellPackageRequest.getFieldActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestPackage(),
                getNotes(),
                getFieldActivityId());
    }
}
