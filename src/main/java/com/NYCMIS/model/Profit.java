/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author surangi
 */
@Entity
@Table(name = "profit")
@NamedQueries({
    @NamedQuery(name = "Profit.findAll", query = "SELECT p FROM Profit p"),
    @NamedQuery(name = "Profit.findById", query = "SELECT p FROM Profit p WHERE p.id = :id"),
    @NamedQuery(name = "Profit.findByMonth", query = "SELECT p FROM Profit p WHERE p.month = :month"),
    @NamedQuery(name = "Profit.findByNetProfit", query = "SELECT p FROM Profit p WHERE p.netProfit = :netProfit")})
public class Profit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "month")
    private String month;
    @Basic(optional = false)
    @NotNull
    @Column(name = "netProfit")
    private int netProfit;

    public Profit() {
    }

    public Profit(Integer id) {
        this.id = id;
    }

    public Profit(Integer id, String month, int netProfit) {
        this.id = id;
        this.month = month;
        this.netProfit = netProfit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(int netProfit) {
        this.netProfit = netProfit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profit)) {
            return false;
        }
        Profit other = (Profit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.NYCMIS.model.Profit[ id=" + id + " ]";
    }
    
}
