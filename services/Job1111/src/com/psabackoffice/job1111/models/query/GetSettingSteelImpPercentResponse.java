/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetSettingSteelImpPercentResponse implements Serializable {

    @JsonProperty("Label")
    @ColumnAlias("Label")
    private String label;
    @JsonProperty("Value1")
    @ColumnAlias("Value1")
    private BigDecimal value1;
    @JsonProperty("Value2")
    @ColumnAlias("Value2")
    private String value2;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getValue1() {
        return this.value1;
    }

    public void setValue1(BigDecimal value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return this.value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetSettingSteelImpPercentResponse)) return false;
        final GetSettingSteelImpPercentResponse getSettingSteelImpPercentResponse = (GetSettingSteelImpPercentResponse) o;
        return Objects.equals(getLabel(), getSettingSteelImpPercentResponse.getLabel()) &&
                Objects.equals(getValue1(), getSettingSteelImpPercentResponse.getValue1()) &&
                Objects.equals(getValue2(), getSettingSteelImpPercentResponse.getValue2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel(),
                getValue1(),
                getValue2());
    }
}
