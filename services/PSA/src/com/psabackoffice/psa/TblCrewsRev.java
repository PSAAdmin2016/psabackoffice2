/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TblCrewsRev generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`tblCrewsRev`")
public class TblCrewsRev implements Serializable {

    private Integer id;
    private Integer orgId;
    private Integer crewNumber;
    private Integer jobNumber;
    private Integer projectManager;
    private Integer constructionManager;
    private Integer siteManager;
    private Integer areaManager;
    private Integer superintendent;
    private Integer gf;
    private Integer foreman;
    private Integer leadman;
    private Integer disciplineId;
    private Short rev;
    private Timestamp timeStamp;
    private TblCrews tblCrews;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`OrgID`", nullable = true, scale = 0, precision = 10)
    public Integer getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    @Column(name = "`CrewNumber`", nullable = true, scale = 0, precision = 10)
    public Integer getCrewNumber() {
        return this.crewNumber;
    }

    public void setCrewNumber(Integer crewNumber) {
        this.crewNumber = crewNumber;
    }

    @Column(name = "`JobNumber`", nullable = true, scale = 0, precision = 10)
    public Integer getJobNumber() {
        return this.jobNumber;
    }

    public void setJobNumber(Integer jobNumber) {
        this.jobNumber = jobNumber;
    }

    @Column(name = "`ProjectManager`", nullable = true, scale = 0, precision = 10)
    public Integer getProjectManager() {
        return this.projectManager;
    }

    public void setProjectManager(Integer projectManager) {
        this.projectManager = projectManager;
    }

    @Column(name = "`ConstructionManager`", nullable = true, scale = 0, precision = 10)
    public Integer getConstructionManager() {
        return this.constructionManager;
    }

    public void setConstructionManager(Integer constructionManager) {
        this.constructionManager = constructionManager;
    }

    @Column(name = "`SiteManager`", nullable = true, scale = 0, precision = 10)
    public Integer getSiteManager() {
        return this.siteManager;
    }

    public void setSiteManager(Integer siteManager) {
        this.siteManager = siteManager;
    }

    @Column(name = "`AreaManager`", nullable = true, scale = 0, precision = 10)
    public Integer getAreaManager() {
        return this.areaManager;
    }

    public void setAreaManager(Integer areaManager) {
        this.areaManager = areaManager;
    }

    @Column(name = "`Superintendent`", nullable = true, scale = 0, precision = 10)
    public Integer getSuperintendent() {
        return this.superintendent;
    }

    public void setSuperintendent(Integer superintendent) {
        this.superintendent = superintendent;
    }

    @Column(name = "`GF`", nullable = true, scale = 0, precision = 10)
    public Integer getGf() {
        return this.gf;
    }

    public void setGf(Integer gf) {
        this.gf = gf;
    }

    @Column(name = "`Foreman`", nullable = true, scale = 0, precision = 10)
    public Integer getForeman() {
        return this.foreman;
    }

    public void setForeman(Integer foreman) {
        this.foreman = foreman;
    }

    @Column(name = "`Leadman`", nullable = true, scale = 0, precision = 10)
    public Integer getLeadman() {
        return this.leadman;
    }

    public void setLeadman(Integer leadman) {
        this.leadman = leadman;
    }

    @Column(name = "`DisciplineId`", nullable = true, scale = 0, precision = 10)
    public Integer getDisciplineId() {
        return this.disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Column(name = "`Rev`", nullable = true, scale = 0, precision = 5)
    public Short getRev() {
        return this.rev;
    }

    public void setRev(Short rev) {
        this.rev = rev;
    }

    @Column(name = "`TimeStamp`", nullable = true)
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`OrgID`", referencedColumnName = "`ID`", insertable = false, updatable = false)
    public TblCrews getTblCrews() {
        return this.tblCrews;
    }

    public void setTblCrews(TblCrews tblCrews) {
        if(tblCrews != null) {
            this.orgId = tblCrews.getId();
        }

        this.tblCrews = tblCrews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TblCrewsRev)) return false;
        final TblCrewsRev tblCrewsRev = (TblCrewsRev) o;
        return Objects.equals(getId(), tblCrewsRev.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

