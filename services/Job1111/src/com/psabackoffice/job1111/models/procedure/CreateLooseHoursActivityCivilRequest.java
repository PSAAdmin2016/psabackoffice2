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

public class CreateLooseHoursActivityCivilRequest implements Serializable {

    @NotNull
    @JsonProperty("SubmissionId")
    private Integer submissionId;
    @NotNull
    @JsonProperty("ActivityId")
    private Integer activityId;
    @NotNull
    @JsonProperty("UserId")
    private Integer userId;
    @NotNull
    @JsonProperty("TestPackage")
    private String testPackage;

    public Integer getSubmissionId() {
        return this.submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTestPackage() {
        return this.testPackage;
    }

    public void setTestPackage(String testPackage) {
        this.testPackage = testPackage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateLooseHoursActivityCivilRequest)) return false;
        final CreateLooseHoursActivityCivilRequest createLooseHoursActivityCivilRequest = (CreateLooseHoursActivityCivilRequest) o;
        return Objects.equals(getSubmissionId(), createLooseHoursActivityCivilRequest.getSubmissionId()) &&
                Objects.equals(getActivityId(), createLooseHoursActivityCivilRequest.getActivityId()) &&
                Objects.equals(getUserId(), createLooseHoursActivityCivilRequest.getUserId()) &&
                Objects.equals(getTestPackage(), createLooseHoursActivityCivilRequest.getTestPackage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubmissionId(),
                getActivityId(),
                getUserId(),
                getTestPackage());
    }
}
