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

public class GetDrawingsByTestPackageResponse implements Serializable {

    @JsonProperty("EngDrawingNumber")
    @ColumnAlias("EngDrawingNumber")
    private String engDrawingNumber;
    @JsonProperty("LineNumber")
    @ColumnAlias("LineNumber")
    private String lineNumber;
    @JsonProperty("SheetNumber")
    @ColumnAlias("SheetNumber")
    private Byte sheetNumber;

    public String getEngDrawingNumber() {
        return this.engDrawingNumber;
    }

    public void setEngDrawingNumber(String engDrawingNumber) {
        this.engDrawingNumber = engDrawingNumber;
    }

    public String getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Byte getSheetNumber() {
        return this.sheetNumber;
    }

    public void setSheetNumber(Byte sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetDrawingsByTestPackageResponse)) return false;
        final GetDrawingsByTestPackageResponse getDrawingsByTestPackageResponse = (GetDrawingsByTestPackageResponse) o;
        return Objects.equals(getEngDrawingNumber(), getDrawingsByTestPackageResponse.getEngDrawingNumber()) &&
                Objects.equals(getLineNumber(), getDrawingsByTestPackageResponse.getLineNumber()) &&
                Objects.equals(getSheetNumber(), getDrawingsByTestPackageResponse.getSheetNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEngDrawingNumber(),
                getLineNumber(),
                getSheetNumber());
    }
}
