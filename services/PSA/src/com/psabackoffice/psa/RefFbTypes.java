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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * RefFbTypes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`REF_FB_Types`")
public class RefFbTypes implements Serializable {

    private Integer id;
    private String type;
    private String subType;
    private List<FeedBack> feedBacks;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`Type`", nullable = true, length = 45)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "`SubType`", nullable = true, length = 128)
    public String getSubType() {
        return this.subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "refFbTypes")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE})
    public List<FeedBack> getFeedBacks() {
        return this.feedBacks;
    }

    public void setFeedBacks(List<FeedBack> feedBacks) {
        this.feedBacks = feedBacks;
    }

    @PostPersist
    public void onPostPersist() {
        if(feedBacks != null) {
            for(FeedBack feedBack : feedBacks) {
                feedBack.setRefFbTypes(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefFbTypes)) return false;
        final RefFbTypes refFbTypes = (RefFbTypes) o;
        return Objects.equals(getId(), refFbTypes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

