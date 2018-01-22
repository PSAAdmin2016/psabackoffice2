/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class LandingToTrackerPipeResponse implements Serializable {


    @ColumnAlias("ReturnStatus")
    private Boolean returnStatus;

    @ColumnAlias("ReturnError")
    private String returnError;

    public Boolean getReturnStatus() {
        return this.returnStatus;
    }

    public void setReturnStatus(Boolean returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getReturnError() {
        return this.returnError;
    }

    public void setReturnError(String returnError) {
        this.returnError = returnError;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LandingToTrackerPipeResponse)) return false;
        final LandingToTrackerPipeResponse landingToTrackerPipeResponse = (LandingToTrackerPipeResponse) o;
        return Objects.equals(getReturnStatus(), landingToTrackerPipeResponse.getReturnStatus()) &&
                Objects.equals(getReturnError(), landingToTrackerPipeResponse.getReturnError());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReturnStatus(),
                getReturnError());
    }
}
