/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsertUserAssignedAppsRequest implements Serializable {


    @JsonProperty("UserID")
    private Integer userId;

    @JsonProperty("MobileAppGroupID")
    private Integer mobileAppGroupId;

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMobileAppGroupId() {
        return this.mobileAppGroupId;
    }

    public void setMobileAppGroupId(Integer mobileAppGroupId) {
        this.mobileAppGroupId = mobileAppGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsertUserAssignedAppsRequest)) return false;
        final InsertUserAssignedAppsRequest insertUserAssignedAppsRequest = (InsertUserAssignedAppsRequest) o;
        return Objects.equals(getUserId(), insertUserAssignedAppsRequest.getUserId()) &&
                Objects.equals(getMobileAppGroupId(), insertUserAssignedAppsRequest.getMobileAppGroupId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(),
                getMobileAppGroupId());
    }
}
