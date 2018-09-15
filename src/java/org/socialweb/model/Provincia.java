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
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p")
    , @NamedQuery(name = "Provincia.findByCodigo", query = "SELECT p FROM Provincia p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Provincia.findByNombre", query = "SELECT p FROM Provincia p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Provincia.findByCodigoIso", query = "SELECT p FROM Provincia p WHERE p.codigoIso = :codigoIso")
    , @NamedQuery(name = "Provincia.findByUsrCreate", query = "SELECT p FROM Provincia p WHERE p.usrCreate = :usrCreate")
    , @NamedQuery(name = "Provincia.findByTimeCreate", query = "SELECT p FROM Provincia p WHERE p.timeCreate = :timeCreate")
    , @NamedQuery(name = "Provincia.findByUsrLastUpdate", query = "SELECT p FROM Provincia p WHERE p.usrLastUpdate = :usrLastUpdate")
    , @NamedQuery(name = "Provincia.findByTimeLastUpdate", query = "SELECT p FROM Provincia p WHERE p.timeLastUpdate = :timeLastUpdate")})
public class Provincia implements Serializable {

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
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigo_iso", nullable = false, length = 2147483647)
    private String codigoIso;
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
    @JoinColumn(name = "estado", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false)
    private EstadoProvincia estado;
    @JoinColumn(name = "pais", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false)
    private Pais pais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia")
    private Set<Ciudad> ciudadSet;

    public Provincia() {
    }

    public Provincia(Integer codigo) {
        this.codigo = codigo;
    }

    public Provincia(Integer codigo, String nombre, String codigoIso, String usrCreate, Date timeCreate, String usrLastUpdate, Date timeLastUpdate) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoIso = codigoIso;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
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

    public EstadoProvincia getEstado() {
        return estado;
    }

    public void setEstado(EstadoProvincia estado) {
        this.estado = estado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @XmlTransient
    public Set<Ciudad> getCiudadSet() {
        return ciudadSet;
    }

    public void setCiudadSet(Set<Ciudad> ciudadSet) {
        this.ciudadSet = ciudadSet;
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
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.Provincia[ codigo=" + codigo + " ]";
    }
    
}
