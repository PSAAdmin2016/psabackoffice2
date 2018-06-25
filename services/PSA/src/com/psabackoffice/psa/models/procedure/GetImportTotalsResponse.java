/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetImportTotalsResponse implements Serializable {


    @JsonProperty("returnStatus")
    @ColumnAlias("returnStatus")
    private Integer returnStatus;

    @JsonProperty("totalRows")
    @ColumnAlias("totalRows")
    private Integer totalRows;

    @JsonProperty("newRows")
    @ColumnAlias("newRows")
    private Integer newRows;

    @JsonProperty("ModifiedRows")
    @ColumnAlias("ModifiedRows")
    private Integer modifiedRows;

    @JsonProperty("hoursDelta")
    @ColumnAlias("hoursDelta")
    private BigDecimal hoursDelta;

    public Integer getReturnStatus() {
        return this.returnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Integer getTotalRows() {
        return this.totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getNewRows() {
        return this.newRows;
    }

    public void setNewRows(Integer newRows) {
        this.newRows = newRows;
    }

    public Integer getModifiedRows() {
        return this.modifiedRows;
    }

    public void setModifiedRows(Integer modifiedRows) {
        this.modifiedRows = modifiedRows;
    }

    public BigDecimal getHoursDelta() {
        return this.hoursDelta;
    }

    public void setHoursDelta(BigDecimal hoursDelta) {
        this.hoursDelta = hoursDelta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetImportTotalsResponse)) return false;
        final GetImportTotalsResponse getImportTotalsResponse = (GetImportTotalsResponse) o;
        return Objects.equals(getReturnStatus(), getImportTotalsResponse.getReturnStatus()) &&
                Objects.equals(getTotalRows(), getImportTotalsResponse.getTotalRows()) &&
                Objects.equals(getNewRows(), getImportTotalsResponse.getNewRows()) &&
                Objects.equals(getModifiedRows(), getImportTotalsResponse.getModifiedRows()) &&
                Objects.equals(getHoursDelta(), getImportTotalsResponse.getHoursDelta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReturnStatus(),
                getTotalRows(),
                getNewRows(),
                getModifiedRows(),
                getHoursDelta());
    }
}
