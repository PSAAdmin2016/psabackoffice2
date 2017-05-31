/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetQuantityBoltUpInstalledResponse implements Serializable {

    @JsonProperty("Total")
    @ColumnAlias("Total")
    private BigDecimal total;

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetQuantityBoltUpInstalledResponse)) return false;
        final GetQuantityBoltUpInstalledResponse getQuantityBoltUpInstalledResponse = (GetQuantityBoltUpInstalledResponse) o;
        return Objects.equals(getTotal(), getQuantityBoltUpInstalledResponse.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotal());
    }
}
