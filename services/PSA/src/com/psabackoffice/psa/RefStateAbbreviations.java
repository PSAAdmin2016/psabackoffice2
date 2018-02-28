/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * RefStateAbbreviations generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`REF_StateAbbreviations`")
public class RefStateAbbreviations implements Serializable {

    private String abbreviation;
    private String stateName;
    private List<TblJobSites> tblJobSiteses;

    @Id
    @Column(name = "`Abbreviation`", nullable = false, length = 2)
    public String getAbbreviation() {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Column(name = "`StateName`", nullable = true, length = 32)
    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "refStateAbbreviations")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE})
    public List<TblJobSites> getTblJobSiteses() {
        return this.tblJobSiteses;
    }

    public void setTblJobSiteses(List<TblJobSites> tblJobSiteses) {
        this.tblJobSiteses = tblJobSiteses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefStateAbbreviations)) return false;
        final RefStateAbbreviations refStateAbbreviations = (RefStateAbbreviations) o;
        return Objects.equals(getAbbreviation(), refStateAbbreviations.getAbbreviation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAbbreviation());
    }
}

