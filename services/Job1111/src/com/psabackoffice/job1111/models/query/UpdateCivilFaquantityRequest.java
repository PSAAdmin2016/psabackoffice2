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

public class UpdateCivilFaquantityRequest implements Serializable {

    @JsonProperty("Percent")
    private BigDecimal percent;
    @JsonProperty("Quantity")
    private Integer quantity;
    @JsonProperty("RowID")
    private Integer rowId;

    public BigDecimal getPercent() {
        return this.percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        if (!(o instanceof UpdateCivilFaquantityRequest)) return false;
        final UpdateCivilFaquantityRequest updateCivilFaquantityRequest = (UpdateCivilFaquantityRequest) o;
        return Objects.equals(getPercent(), updateCivilFaquantityRequest.getPercent()) &&
                Objects.equals(getQuantity(), updateCivilFaquantityRequest.getQuantity()) &&
                Objects.equals(getRowId(), updateCivilFaquantityRequest.getRowId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPercent(),
                getQuantity(),
                getRowId());
    }
}
