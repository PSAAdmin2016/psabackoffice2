/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RefActivityTypes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`REF_ActivityTypes`")
public class RefActivityTypes implements Serializable {

    private Integer id;
    private String activityType;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`ActivityType`", nullable = true, length = 45)
    public String getActivityType() {
        return this.activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefActivityTypes)) return false;
        final RefActivityTypes refActivityTypes = (RefActivityTypes) o;
        return Objects.equals(getId(), refActivityTypes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

