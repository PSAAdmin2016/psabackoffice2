/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class ManagersResponse implements Serializable {


    @JsonProperty("Email")
    @ColumnAlias("Email")
    private String email;

    @JsonProperty("Firstname")
    @ColumnAlias("Firstname")
    private String firstname;

    @JsonProperty("ID")
    @ColumnAlias("ID")
    private Integer id;

    @JsonProperty("LastName")
    @ColumnAlias("LastName")
    private String lastName;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ManagersResponse)) return false;
        final ManagersResponse managersResponse = (ManagersResponse) o;
        return Objects.equals(getEmail(), managersResponse.getEmail()) &&
                Objects.equals(getFirstname(), managersResponse.getFirstname()) &&
                Objects.equals(getId(), managersResponse.getId()) &&
                Objects.equals(getLastName(), managersResponse.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(),
                getFirstname(),
                getId(),
                getLastName());
    }
}
