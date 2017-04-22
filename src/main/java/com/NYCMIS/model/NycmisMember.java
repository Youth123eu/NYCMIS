/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "nycmis_member")
@NamedQueries({
    @NamedQuery(name = "NycmisMember.findAll", query = "SELECT n FROM NycmisMember n"),
    @NamedQuery(name = "NycmisMember.findByEmail", query = "SELECT n FROM NycmisMember n WHERE n.email = :email"),
    @NamedQuery(name = "NycmisMember.findByFirstName", query = "SELECT n FROM NycmisMember n WHERE n.firstName = :firstName"),
    @NamedQuery(name = "NycmisMember.findByLastName", query = "SELECT n FROM NycmisMember n WHERE n.lastName = :lastName"),
    @NamedQuery(name = "NycmisMember.findByPassword", query = "SELECT n FROM NycmisMember n WHERE n.password = :password"),
    @NamedQuery(name = "NycmisMember.findByRegisteredDate", query = "SELECT n FROM NycmisMember n WHERE n.registeredDate = :registeredDate")})
public class NycmisMember implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registeredDate")
    @Temporal(TemporalType.DATE)
    private Date registeredDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "email")
    private List<NycmisRole> nycmisRoleList;

    public NycmisMember() {
    }

    public NycmisMember(String email) {
        this.email = email;
    }

    public NycmisMember(String email, String firstName, String lastName, String password, Date registeredDate) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.registeredDate = registeredDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public List<NycmisRole> getNycmisRoleList() {
        return nycmisRoleList;
    }

    public void setNycmisRoleList(List<NycmisRole> nycmisRoleList) {
        this.nycmisRoleList = nycmisRoleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NycmisMember)) {
            return false;
        }
        NycmisMember other = (NycmisMember) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.NYCMIS.model.NycmisMember[ email=" + email + " ]";
    }
    
}
