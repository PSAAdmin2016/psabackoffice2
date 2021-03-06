/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * RefJobTitles generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`REF_JobTitles`", uniqueConstraints = {
            @UniqueConstraint(name = "`ID_UNIQUE`", columnNames = {"`ID`"})})
public class RefJobTitles implements Serializable {

    private Integer id;
    private String positionTitle;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`PositionTitle`", nullable = true, length = 32)
    public String getPositionTitle() {
        return this.positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefJobTitles)) return false;
        final RefJobTitles refJobTitles = (RefJobTitles) o;
        return Objects.equals(getId(), refJobTitles.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

