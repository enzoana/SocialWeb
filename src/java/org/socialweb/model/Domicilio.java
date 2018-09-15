/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialweb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author enzo
 */
@Entity
@Table(catalog = "socialweb", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d")
    , @NamedQuery(name = "Domicilio.findByCodigo", query = "SELECT d FROM Domicilio d WHERE d.codigo = :codigo")
    , @NamedQuery(name = "Domicilio.findByCalle", query = "SELECT d FROM Domicilio d WHERE d.calle = :calle")
    , @NamedQuery(name = "Domicilio.findByNumero", query = "SELECT d FROM Domicilio d WHERE d.numero = :numero")
    , @NamedQuery(name = "Domicilio.findByDepartamento", query = "SELECT d FROM Domicilio d WHERE d.departamento = :departamento")
    , @NamedQuery(name = "Domicilio.findByUsrCreate", query = "SELECT d FROM Domicilio d WHERE d.usrCreate = :usrCreate")
    , @NamedQuery(name = "Domicilio.findByTimeCreate", query = "SELECT d FROM Domicilio d WHERE d.timeCreate = :timeCreate")
    , @NamedQuery(name = "Domicilio.findByUsrLastUpdate", query = "SELECT d FROM Domicilio d WHERE d.usrLastUpdate = :usrLastUpdate")
    , @NamedQuery(name = "Domicilio.findByTimeLastUpdate", query = "SELECT d FROM Domicilio d WHERE d.timeLastUpdate = :timeLastUpdate")})
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String calle;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String numero;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "usr_create", nullable = false, length = 2147483647)
    private String usrCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time_create", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCreate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "usr_last_update", nullable = false, length = 2147483647)
    private String usrLastUpdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time_last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeLastUpdate;
    @OneToMany(mappedBy = "domicilioFiscal")
    private Set<Persona> personaSet;
    @OneToMany(mappedBy = "domicilioLegal")
    private Set<Persona> personaSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domicilioReal")
    private Set<Persona> personaSet2;
    @JoinColumn(name = "ciudad", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false)
    private Ciudad ciudad;

    public Domicilio() {
    }

    public Domicilio(Integer codigo) {
        this.codigo = codigo;
    }

    public Domicilio(Integer codigo, String calle, String usrCreate, Date timeCreate, String usrLastUpdate, Date timeLastUpdate) {
        this.codigo = codigo;
        this.calle = calle;
        this.usrCreate = usrCreate;
        this.timeCreate = timeCreate;
        this.usrLastUpdate = usrLastUpdate;
        this.timeLastUpdate = timeLastUpdate;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getUsrCreate() {
        return usrCreate;
    }

    public void setUsrCreate(String usrCreate) {
        this.usrCreate = usrCreate;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public String getUsrLastUpdate() {
        return usrLastUpdate;
    }

    public void setUsrLastUpdate(String usrLastUpdate) {
        this.usrLastUpdate = usrLastUpdate;
    }

    public Date getTimeLastUpdate() {
        return timeLastUpdate;
    }

    public void setTimeLastUpdate(Date timeLastUpdate) {
        this.timeLastUpdate = timeLastUpdate;
    }

    @XmlTransient
    public Set<Persona> getPersonaSet() {
        return personaSet;
    }

    public void setPersonaSet(Set<Persona> personaSet) {
        this.personaSet = personaSet;
    }

    @XmlTransient
    public Set<Persona> getPersonaSet1() {
        return personaSet1;
    }

    public void setPersonaSet1(Set<Persona> personaSet1) {
        this.personaSet1 = personaSet1;
    }

    @XmlTransient
    public Set<Persona> getPersonaSet2() {
        return personaSet2;
    }

    public void setPersonaSet2(Set<Persona> personaSet2) {
        this.personaSet2 = personaSet2;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.Domicilio[ codigo=" + codigo + " ]";
    }
    
}
