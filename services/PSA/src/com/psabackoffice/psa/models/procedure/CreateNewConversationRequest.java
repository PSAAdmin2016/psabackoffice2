/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateNewConversationRequest implements Serializable {


    @JsonProperty("varCreator")
    private Integer varCreator;

    @JsonProperty("varRecipient")
    private Integer varRecipient;

    public Integer getVarCreator() {
        return this.varCreator;
    }

    public void setVarCreator(Integer varCreator) {
        this.varCreator = varCreator;
    }

    public Integer getVarRecipient() {
        return this.varRecipient;
    }

    public void setVarRecipient(Integer varRecipient) {
        this.varRecipient = varRecipient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateNewConversationRequest)) return false;
        final CreateNewConversationRequest createNewConversationRequest = (CreateNewConversationRequest) o;
        return Objects.equals(getVarCreator(), createNewConversationRequest.getVarCreator()) &&
                Objects.equals(getVarRecipient(), createNewConversationRequest.getVarRecipient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVarCreator(),
                getVarRecipient());
    }
}
