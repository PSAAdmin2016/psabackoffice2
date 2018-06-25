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

/**
 * RefImportableTables generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`REF_ImportableTables`")
public class RefImportableTables implements Serializable {

    private Integer id;
    private String destinationLabel;
    private String landingTable;
    private String destinationTable;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`DestinationLabel`", nullable = true, length = 45)
    public String getDestinationLabel() {
        return this.destinationLabel;
    }

    public void setDestinationLabel(String destinationLabel) {
        this.destinationLabel = destinationLabel;
    }

    @Column(name = "`LandingTable`", nullable = true, length = 45)
    public String getLandingTable() {
        return this.landingTable;
    }

    public void setLandingTable(String landingTable) {
        this.landingTable = landingTable;
    }

    @Column(name = "`DestinationTable`", nullable = true, length = 45)
    public String getDestinationTable() {
        return this.destinationTable;
    }

    public void setDestinationTable(String destinationTable) {
        this.destinationTable = destinationTable;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefImportableTables)) return false;
        final RefImportableTables refImportableTables = (RefImportableTables) o;
        return Objects.equals(getId(), refImportableTables.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

