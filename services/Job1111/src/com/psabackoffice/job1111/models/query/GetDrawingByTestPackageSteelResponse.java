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

public class GetDrawingByTestPackageSteelResponse implements Serializable {

    @JsonProperty("Area")
    @ColumnAlias("Area")
    private String area;
    @JsonProperty("Description")
    @ColumnAlias("Description")
    private String description;
    @JsonProperty("PieceMark")
    @ColumnAlias("PieceMark")
    private String pieceMark;

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPieceMark() {
        return this.pieceMark;
    }

    public void setPieceMark(String pieceMark) {
        this.pieceMark = pieceMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetDrawingByTestPackageSteelResponse)) return false;
        final GetDrawingByTestPackageSteelResponse getDrawingByTestPackageSteelResponse = (GetDrawingByTestPackageSteelResponse) o;
        return Objects.equals(getArea(), getDrawingByTestPackageSteelResponse.getArea()) &&
                Objects.equals(getDescription(), getDrawingByTestPackageSteelResponse.getDescription()) &&
                Objects.equals(getPieceMark(), getDrawingByTestPackageSteelResponse.getPieceMark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArea(),
                getDescription(),
                getPieceMark());
    }
}
