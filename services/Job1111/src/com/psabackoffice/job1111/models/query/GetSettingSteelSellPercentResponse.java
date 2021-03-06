/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetSettingSteelSellPercentResponse implements Serializable {


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
        if (!(o instanceof GetSettingSteelSellPercentResponse)) return false;
        final GetSettingSteelSellPercentResponse getSettingSteelSellPercentResponse = (GetSettingSteelSellPercentResponse) o;
        return Objects.equals(getLabel(), getSettingSteelSellPercentResponse.getLabel()) &&
                Objects.equals(getValue1(), getSettingSteelSellPercentResponse.getValue1()) &&
                Objects.equals(getValue2(), getSettingSteelSellPercentResponse.getValue2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel(),
                getValue1(),
                getValue2());
    }
}
