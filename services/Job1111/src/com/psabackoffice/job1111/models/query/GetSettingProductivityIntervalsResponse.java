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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetSettingProductivityIntervalsResponse implements Serializable {

    @JsonProperty("Interval1")
    @ColumnAlias("Interval1")
    private Float interval1;
    @JsonProperty("Interval2")
    @ColumnAlias("Interval2")
    private Float interval2;
    @JsonProperty("Interval3")
    @ColumnAlias("Interval3")
    private Float interval3;
    @JsonProperty("Interval4")
    @ColumnAlias("Interval4")
    private Float interval4;

    public Float getInterval1() {
        return this.interval1;
    }

    public void setInterval1(Float interval1) {
        this.interval1 = interval1;
    }

    public Float getInterval2() {
        return this.interval2;
    }

    public void setInterval2(Float interval2) {
        this.interval2 = interval2;
    }

    public Float getInterval3() {
        return this.interval3;
    }

    public void setInterval3(Float interval3) {
        this.interval3 = interval3;
    }

    public Float getInterval4() {
        return this.interval4;
    }

    public void setInterval4(Float interval4) {
        this.interval4 = interval4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetSettingProductivityIntervalsResponse)) return false;
        final GetSettingProductivityIntervalsResponse getSettingProductivityIntervalsResponse = (GetSettingProductivityIntervalsResponse) o;
        return Objects.equals(getInterval1(), getSettingProductivityIntervalsResponse.getInterval1()) &&
                Objects.equals(getInterval2(), getSettingProductivityIntervalsResponse.getInterval2()) &&
                Objects.equals(getInterval3(), getSettingProductivityIntervalsResponse.getInterval3()) &&
                Objects.equals(getInterval4(), getSettingProductivityIntervalsResponse.getInterval4());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInterval1(),
                getInterval2(),
                getInterval3(),
                getInterval4());
    }
}
