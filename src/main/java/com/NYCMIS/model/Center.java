/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author surangi
 */
@Entity
@Table(name = "center")
@NamedQueries({
    @NamedQuery(name = "Center.findAll", query = "SELECT c FROM Center c"),
    @NamedQuery(name = "Center.findById", query = "SELECT c FROM Center c WHERE c.id = :id"),
    @NamedQuery(name = "Center.findByCenterId", query = "SELECT c FROM Center c WHERE c.centerId = :centerId"),
    @NamedQuery(name = "Center.findByCenterName", query = "SELECT c FROM Center c WHERE c.centerName = :centerName"),
    @NamedQuery(name = "Center.findByRegDate", query = "SELECT c FROM Center c WHERE c.regDate = :regDate")})
public class Center implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "centerId")
    private String centerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "centerName")
    private String centerName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "regDate")
    @Temporal(TemporalType.DATE)
    private Date regDate;

    public Center() {
    }

    public Center(String centerId) {
        this.centerId = centerId;
    }

    public Center(String centerId, int id, String centerName, Date regDate) {
        this.centerId = centerId;
        this.id = id;
        this.centerName = centerName;
        this.regDate = regDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (centerId != null ? centerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Center)) {
            return false;
        }
        Center other = (Center) object;
        if ((this.centerId == null && other.centerId != null) || (this.centerId != null && !this.centerId.equals(other.centerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.NYCMIS.model.Center[ centerId=" + centerId + " ]";
    }
    
}
