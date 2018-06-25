/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetSettingDashUpdateIntResponse implements Serializable {


    @JsonProperty("Interval1")
    @ColumnAlias("Interval1")
    private Integer interval1;

    @JsonProperty("Interval2")
    @ColumnAlias("Interval2")
    private Integer interval2;

    public Integer getInterval1() {
        return this.interval1;
    }

    public void setInterval1(Integer interval1) {
        this.interval1 = interval1;
    }

    public Integer getInterval2() {
        return this.interval2;
    }

    public void setInterval2(Integer interval2) {
        this.interval2 = interval2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetSettingDashUpdateIntResponse)) return false;
        final GetSettingDashUpdateIntResponse getSettingDashUpdateIntResponse = (GetSettingDashUpdateIntResponse) o;
        return Objects.equals(getInterval1(), getSettingDashUpdateIntResponse.getInterval1()) &&
                Objects.equals(getInterval2(), getSettingDashUpdateIntResponse.getInterval2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInterval1(),
                getInterval2());
    }
}
