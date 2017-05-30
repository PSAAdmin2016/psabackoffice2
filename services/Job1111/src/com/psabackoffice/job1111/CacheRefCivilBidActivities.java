/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CacheRefCivilBidActivities generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`CacheRef_CivilBidActivities`")
public class CacheRefCivilBidActivities implements Serializable {

    private Integer id;
    private String civilBidActivitiesObj;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`CivilBidActivitiesObj`", nullable = true, length = 2147483647)
    public String getCivilBidActivitiesObj() {
        return this.civilBidActivitiesObj;
    }

    public void setCivilBidActivitiesObj(String civilBidActivitiesObj) {
        this.civilBidActivitiesObj = civilBidActivitiesObj;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CacheRefCivilBidActivities)) return false;
        final CacheRefCivilBidActivities cacheRefCivilBidActivities = (CacheRefCivilBidActivities) o;
        return Objects.equals(getId(), cacheRefCivilBidActivities.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

