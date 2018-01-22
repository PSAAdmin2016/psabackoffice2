/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePipeSupportsQuantityRequest implements Serializable {


    @JsonProperty("Quantity")
    private Integer quantity;

    @JsonProperty("FieldActivityID")
    @NotNull
    private Integer fieldActivityId;

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        if (!(o instanceof UpdatePipeSupportsQuantityRequest)) return false;
        final UpdatePipeSupportsQuantityRequest updatePipeSupportsQuantityRequest = (UpdatePipeSupportsQuantityRequest) o;
        return Objects.equals(getQuantity(), updatePipeSupportsQuantityRequest.getQuantity()) &&
                Objects.equals(getFieldActivityId(), updatePipeSupportsQuantityRequest.getFieldActivityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantity(),
                getFieldActivityId());
    }
}
