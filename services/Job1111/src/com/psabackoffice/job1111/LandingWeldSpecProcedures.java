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
 * LandingWeldSpecProcedures generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`LandingWeldSpecProcedures`")
public class LandingWeldSpecProcedures implements Serializable {

    private Integer id;
    private String lineSpec;
    private String weldProcedure;
    private String materialType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`LineSpec`", nullable = true, length = 45)
    public String getLineSpec() {
        return this.lineSpec;
    }

    public void setLineSpec(String lineSpec) {
        this.lineSpec = lineSpec;
    }

    @Column(name = "`WeldProcedure`", nullable = true, length = 45)
    public String getWeldProcedure() {
        return this.weldProcedure;
    }

    public void setWeldProcedure(String weldProcedure) {
        this.weldProcedure = weldProcedure;
    }

    @Column(name = "`MaterialType`", nullable = true, length = 45)
    public String getMaterialType() {
        return this.materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LandingWeldSpecProcedures)) return false;
        final LandingWeldSpecProcedures landingWeldSpecProcedures = (LandingWeldSpecProcedures) o;
        return Objects.equals(getId(), landingWeldSpecProcedures.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

