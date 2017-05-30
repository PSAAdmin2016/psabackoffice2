/*Copyright (c) 2016-2017 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.safety;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
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
 * Csanotes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`CSANotes`")
public class Csanotes implements Serializable {

    private Integer id;
    private Integer csaid;
    private Byte notesType;
    private String notesForeman;
    private Date notesCorrectedDate;
    private String notesComments;
    private CorpSafetyAudit corpSafetyAudit;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`CSAID`", nullable = true, scale = 0, precision = 10)
    public Integer getCsaid() {
        return this.csaid;
    }

    public void setCsaid(Integer csaid) {
        this.csaid = csaid;
    }

    @Column(name = "`NotesType`", nullable = true, scale = 0, precision = 3)
    public Byte getNotesType() {
        return this.notesType;
    }

    public void setNotesType(Byte notesType) {
        this.notesType = notesType;
    }

    @Column(name = "`NotesForeman`", nullable = true, length = 45)
    public String getNotesForeman() {
        return this.notesForeman;
    }

    public void setNotesForeman(String notesForeman) {
        this.notesForeman = notesForeman;
    }

    @Column(name = "`NotesCorrectedDate`", nullable = true)
    public Date getNotesCorrectedDate() {
        return this.notesCorrectedDate;
    }

    public void setNotesCorrectedDate(Date notesCorrectedDate) {
        this.notesCorrectedDate = notesCorrectedDate;
    }

    @Column(name = "`NotesComments`", nullable = true, length = 1024)
    public String getNotesComments() {
        return this.notesComments;
    }

    public void setNotesComments(String notesComments) {
        this.notesComments = notesComments;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`CSAID`", referencedColumnName = "`ID`", insertable = false, updatable = false)
    public CorpSafetyAudit getCorpSafetyAudit() {
        return this.corpSafetyAudit;
    }

    public void setCorpSafetyAudit(CorpSafetyAudit corpSafetyAudit) {
        if(corpSafetyAudit != null) {
            this.csaid = corpSafetyAudit.getId();
        }

        this.corpSafetyAudit = corpSafetyAudit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Csanotes)) return false;
        final Csanotes csanotes = (Csanotes) o;
        return Objects.equals(getId(), csanotes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

