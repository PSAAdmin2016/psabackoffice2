/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetSteelPcotResponse implements Serializable {


    @JsonProperty("content")
    @ColumnAlias("content")
    private List<GetSteelPcotResponseContent> content;

    @JsonProperty("ReturnStatus")
    @ColumnAlias("ReturnStatus")
    private Boolean returnStatus;

    @JsonProperty("ErrorText")
    @ColumnAlias("ErrorText")
    private String errorText;

    public List<GetSteelPcotResponseContent> getContent() {
        return this.content;
    }

    public void setContent(List<GetSteelPcotResponseContent> content) {
        this.content = content;
    }

    public Boolean getReturnStatus() {
        return this.returnStatus;
    }

    public void setReturnStatus(Boolean returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getErrorText() {
        return this.errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetSteelPcotResponse)) return false;
        final GetSteelPcotResponse getSteelPcotResponse = (GetSteelPcotResponse) o;
        return Objects.equals(getContent(), getSteelPcotResponse.getContent()) &&
                Objects.equals(getReturnStatus(), getSteelPcotResponse.getReturnStatus()) &&
                Objects.equals(getErrorText(), getSteelPcotResponse.getErrorText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContent(),
                getReturnStatus(),
                getErrorText());
    }
}
