/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetBidActivityQuantitiesPipeResponse implements Serializable {


    @JsonProperty("TakeOffQuantity")
    @ColumnAlias("TakeOffQuantity")
    private BigDecimal takeOffQuantity;

    @JsonProperty("QuantityUnit")
    @ColumnAlias("QuantityUnit")
    private String quantityUnit;

    @JsonProperty("EstimatedHours")
    @ColumnAlias("EstimatedHours")
    private BigDecimal estimatedHours;

    public BigDecimal getTakeOffQuantity() {
        return this.takeOffQuantity;
    }

    public void setTakeOffQuantity(BigDecimal takeOffQuantity) {
        this.takeOffQuantity = takeOffQuantity;
    }

    public String getQuantityUnit() {
        return this.quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public BigDecimal getEstimatedHours() {
        return this.estimatedHours;
    }

    public void setEstimatedHours(BigDecimal estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetBidActivityQuantitiesPipeResponse)) return false;
        final GetBidActivityQuantitiesPipeResponse getBidActivityQuantitiesPipeResponse = (GetBidActivityQuantitiesPipeResponse) o;
        return Objects.equals(getTakeOffQuantity(), getBidActivityQuantitiesPipeResponse.getTakeOffQuantity()) &&
                Objects.equals(getQuantityUnit(), getBidActivityQuantitiesPipeResponse.getQuantityUnit()) &&
                Objects.equals(getEstimatedHours(), getBidActivityQuantitiesPipeResponse.getEstimatedHours());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTakeOffQuantity(),
                getQuantityUnit(),
                getEstimatedHours());
    }
}
