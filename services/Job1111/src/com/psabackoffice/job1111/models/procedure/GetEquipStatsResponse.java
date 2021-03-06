/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetEquipStatsResponse implements Serializable {


    @ColumnAlias("content")
    private List<GetEquipStatsResponseContent> content;

    @ColumnAlias("ReturnStatus")
    private Boolean returnStatus;

    @ColumnAlias("ErrorText")
    private String errorText;

    public List<GetEquipStatsResponseContent> getContent() {
        return this.content;
    }

    public void setContent(List<GetEquipStatsResponseContent> content) {
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
        if (!(o instanceof GetEquipStatsResponse)) return false;
        final GetEquipStatsResponse getEquipStatsResponse = (GetEquipStatsResponse) o;
        return Objects.equals(getContent(), getEquipStatsResponse.getContent()) &&
                Objects.equals(getReturnStatus(), getEquipStatsResponse.getReturnStatus()) &&
                Objects.equals(getErrorText(), getEquipStatsResponse.getErrorText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContent(),
                getReturnStatus(),
                getErrorText());
    }
}
