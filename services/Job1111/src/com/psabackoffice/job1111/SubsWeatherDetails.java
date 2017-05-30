/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.job1111;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * SubsWeatherDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SubsWeatherDetails`")
public class SubsWeatherDetails implements Serializable {

    private Integer id;
    private String highTemp;
    private String lowTemp;
    private List<SubsDetails> subsDetailses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`HighTemp`", nullable = true, length = 45)
    public String getHighTemp() {
        return this.highTemp;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }

    @Column(name = "`LowTemp`", nullable = true, length = 45)
    public String getLowTemp() {
        return this.lowTemp;
    }

    public void setLowTemp(String lowTemp) {
        this.lowTemp = lowTemp;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "subsWeatherDetails")
    public List<SubsDetails> getSubsDetailses() {
        return this.subsDetailses;
    }

    public void setSubsDetailses(List<SubsDetails> subsDetailses) {
        this.subsDetailses = subsDetailses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubsWeatherDetails)) return false;
        final SubsWeatherDetails subsWeatherDetails = (SubsWeatherDetails) o;
        return Objects.equals(getId(), subsWeatherDetails.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
