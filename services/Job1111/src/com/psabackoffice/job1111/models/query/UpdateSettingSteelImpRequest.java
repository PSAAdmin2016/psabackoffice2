/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateSettingSteelImpRequest implements Serializable {


    @JsonProperty("Value1")
    private BigDecimal value1;

    public BigDecimal getValue1() {
        return this.value1;
    }

    public void setValue1(BigDecimal value1) {
        this.value1 = value1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateSettingSteelImpRequest)) return false;
        final UpdateSettingSteelImpRequest updateSettingSteelImpRequest = (UpdateSettingSteelImpRequest) o;
        return Objects.equals(getValue1(), updateSettingSteelImpRequest.getValue1());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue1());
    }
}
