/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class CreateLooseHoursActivityCivilResponse implements Serializable {

    @JsonProperty("ReturnStatus")
    @ColumnAlias("ReturnStatus")
    private Boolean returnStatus;
    @JsonProperty("ErrorText")
    @ColumnAlias("ErrorText")
    private String errorText;

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
        if (!(o instanceof CreateLooseHoursActivityCivilResponse)) return false;
        final CreateLooseHoursActivityCivilResponse createLooseHoursActivityCivilResponse = (CreateLooseHoursActivityCivilResponse) o;
        return Objects.equals(getReturnStatus(), createLooseHoursActivityCivilResponse.getReturnStatus()) &&
                Objects.equals(getErrorText(), createLooseHoursActivityCivilResponse.getErrorText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReturnStatus(),
                getErrorText());
    }
}
