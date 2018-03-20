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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * TblJobSites generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`tblJobSites`")
public class TblJobSites implements Serializable {

    private Integer id;
    private String siteName;
    private String siteCity;
    private String siteState;
    private Integer zipCode;
    private RefStateAbbreviations refStateAbbreviations;
    private List<TblJobNumbers> tblJobNumberses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`SiteName`", nullable = true, length = 45)
    public String getSiteName() {
        return this.siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @Column(name = "`SiteCity`", nullable = true, length = 45)
    public String getSiteCity() {
        return this.siteCity;
    }

    public void setSiteCity(String siteCity) {
        this.siteCity = siteCity;
    }

    @Column(name = "`SiteState`", nullable = true, length = 2)
    public String getSiteState() {
        return this.siteState;
    }

    public void setSiteState(String siteState) {
        this.siteState = siteState;
    }

    @Column(name = "`ZipCode`", nullable = true, scale = 0, precision = 7)
    public Integer getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`SiteState`", referencedColumnName = "`Abbreviation`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`fk_StateAbbreviation_JobSite`"))
    @Fetch(FetchMode.JOIN)
    public RefStateAbbreviations getRefStateAbbreviations() {
        return this.refStateAbbreviations;
    }

    public void setRefStateAbbreviations(RefStateAbbreviations refStateAbbreviations) {
        if(refStateAbbreviations != null) {
            this.siteState = refStateAbbreviations.getAbbreviation();
        }

        this.refStateAbbreviations = refStateAbbreviations;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tblJobSites")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE})
    public List<TblJobNumbers> getTblJobNumberses() {
        return this.tblJobNumberses;
    }

    public void setTblJobNumberses(List<TblJobNumbers> tblJobNumberses) {
        this.tblJobNumberses = tblJobNumberses;
    }

    @PostPersist
    public void onPostPersist() {
        if(tblJobNumberses != null) {
            for(TblJobNumbers tblJobNumbers : tblJobNumberses) {
                tblJobNumbers.setTblJobSites(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TblJobSites)) return false;
        final TblJobSites tblJobSites = (TblJobSites) o;
        return Objects.equals(getId(), tblJobSites.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

