/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetRefTemperaturesResponse implements Serializable {


    @JsonProperty("Value")
    @ColumnAlias("Value")
    private String value;

    @JsonProperty("ID")
    @ColumnAlias("ID")
    private Integer id;

    @JsonProperty("Label")
    @ColumnAlias("Label")
    private String label;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetRefTemperaturesResponse)) return false;
        final GetRefTemperaturesResponse getRefTemperaturesResponse = (GetRefTemperaturesResponse) o;
        return Objects.equals(getValue(), getRefTemperaturesResponse.getValue()) &&
                Objects.equals(getId(), getRefTemperaturesResponse.getId()) &&
                Objects.equals(getLabel(), getRefTemperaturesResponse.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(),
                getId(),
                getLabel());
    }
}
