/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class CompareColumnsResponse implements Serializable {

    @ColumnAlias("returnStatus")
    private Boolean returnStatus;
    @ColumnAlias("expectedColumn")
    private String expectedColumn;
    @ColumnAlias("recievedColumn")
    private String recievedColumn;

    public Boolean getReturnStatus() {
        return this.returnStatus;
    }

    public void setReturnStatus(Boolean returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getExpectedColumn() {
        return this.expectedColumn;
    }

    public void setExpectedColumn(String expectedColumn) {
        this.expectedColumn = expectedColumn;
    }

    public String getRecievedColumn() {
        return this.recievedColumn;
    }

    public void setRecievedColumn(String recievedColumn) {
        this.recievedColumn = recievedColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompareColumnsResponse)) return false;
        final CompareColumnsResponse compareColumnsResponse = (CompareColumnsResponse) o;
        return Objects.equals(getReturnStatus(), compareColumnsResponse.getReturnStatus()) &&
                Objects.equals(getExpectedColumn(), compareColumnsResponse.getExpectedColumn()) &&
                Objects.equals(getRecievedColumn(), compareColumnsResponse.getRecievedColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReturnStatus(),
                getExpectedColumn(),
                getRecievedColumn());
    }
}
