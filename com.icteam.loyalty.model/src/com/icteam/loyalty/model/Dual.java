package com.icteam.loyalty.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dual
 */
@Entity
@Table(name = "DUAL")
@Access(AccessType.FIELD)
public class Dual implements Serializable {

    private static final long serialVersionUID = 6283480745491727848L;

    @Id
    @Column(name = "DUMMY")
    private String dummy;

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }
}
