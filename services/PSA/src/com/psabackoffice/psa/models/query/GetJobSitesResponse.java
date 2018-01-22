/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetJobSitesResponse implements Serializable {


    @JsonProperty("ID")
    @ColumnAlias("ID")
    private Integer id;

    @JsonProperty("SiteCity")
    @ColumnAlias("SiteCity")
    private String siteCity;

    @JsonProperty("SiteName")
    @ColumnAlias("SiteName")
    private String siteName;

    @JsonProperty("SiteState")
    @ColumnAlias("SiteState")
    private String siteState;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteCity() {
        return this.siteCity;
    }

    public void setSiteCity(String siteCity) {
        this.siteCity = siteCity;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteState() {
        return this.siteState;
    }

    public void setSiteState(String siteState) {
        this.siteState = siteState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetJobSitesResponse)) return false;
        final GetJobSitesResponse getJobSitesResponse = (GetJobSitesResponse) o;
        return Objects.equals(getId(), getJobSitesResponse.getId()) &&
                Objects.equals(getSiteCity(), getJobSitesResponse.getSiteCity()) &&
                Objects.equals(getSiteName(), getJobSitesResponse.getSiteName()) &&
                Objects.equals(getSiteState(), getJobSitesResponse.getSiteState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getSiteCity(),
                getSiteName(),
                getSiteState());
    }
}
