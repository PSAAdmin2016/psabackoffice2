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
 * RefFbSubTypes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`REF_FB_SubTypes`")
public class RefFbSubTypes implements Serializable {

    private Integer id;
    private Integer typeId;
    private String label;
    private RefFbTypes refFbTypes;
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

    @Column(name = "`TypeID`", nullable = true, scale = 0, precision = 10)
    public Integer getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Column(name = "`Label`", nullable = true, length = 128)
    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`TypeID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`REF_FB_SubTypes_to_TypesID`"))
    @Fetch(FetchMode.JOIN)
    public RefFbTypes getRefFbTypes() {
        return this.refFbTypes;
    }

    public void setRefFbTypes(RefFbTypes refFbTypes) {
        if(refFbTypes != null) {
            this.typeId = refFbTypes.getId();
        }

        this.refFbTypes = refFbTypes;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "refFbSubTypes")
    @Cascade({CascadeType.SAVE_UPDATE})
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
                feedBack.setRefFbSubTypes(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefFbSubTypes)) return false;
        final RefFbSubTypes refFbSubTypes = (RefFbSubTypes) o;
        return Objects.equals(getId(), refFbSubTypes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

