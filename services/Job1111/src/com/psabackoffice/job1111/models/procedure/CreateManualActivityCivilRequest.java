/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateManualActivityCivilRequest implements Serializable {


    @JsonProperty("varBidID")
    @NotNull
    private Integer varBidId;

    @JsonProperty("varQuantity")
    @NotNull
    private Integer varQuantity;

    @JsonProperty("varPercentCompleted")
    @NotNull
    private BigDecimal varPercentCompleted;

    @JsonProperty("varNotes")
    @NotNull
    private String varNotes;

    @JsonProperty("varUserId")
    @NotNull
    private Integer varUserId;

    public Integer getVarBidId() {
        return this.varBidId;
    }

    public void setVarBidId(Integer varBidId) {
        this.varBidId = varBidId;
    }

    public Integer getVarQuantity() {
        return this.varQuantity;
    }

    public void setVarQuantity(Integer varQuantity) {
        this.varQuantity = varQuantity;
    }

    public BigDecimal getVarPercentCompleted() {
        return this.varPercentCompleted;
    }

    public void setVarPercentCompleted(BigDecimal varPercentCompleted) {
        this.varPercentCompleted = varPercentCompleted;
    }

    public String getVarNotes() {
        return this.varNotes;
    }

    public void setVarNotes(String varNotes) {
        this.varNotes = varNotes;
    }

    public Integer getVarUserId() {
        return this.varUserId;
    }

    public void setVarUserId(Integer varUserId) {
        this.varUserId = varUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateManualActivityCivilRequest)) return false;
        final CreateManualActivityCivilRequest createManualActivityCivilRequest = (CreateManualActivityCivilRequest) o;
        return Objects.equals(getVarBidId(), createManualActivityCivilRequest.getVarBidId()) &&
                Objects.equals(getVarQuantity(), createManualActivityCivilRequest.getVarQuantity()) &&
                Objects.equals(getVarPercentCompleted(), createManualActivityCivilRequest.getVarPercentCompleted()) &&
                Objects.equals(getVarNotes(), createManualActivityCivilRequest.getVarNotes()) &&
                Objects.equals(getVarUserId(), createManualActivityCivilRequest.getVarUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVarBidId(),
                getVarQuantity(),
                getVarPercentCompleted(),
                getVarNotes(),
                getVarUserId());
    }
}
