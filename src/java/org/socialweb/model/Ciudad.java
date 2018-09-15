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
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByCodigo", query = "SELECT c FROM Ciudad c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Ciudad.findByNombre", query = "SELECT c FROM Ciudad c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Ciudad.findByUsrCreate", query = "SELECT c FROM Ciudad c WHERE c.usrCreate = :usrCreate")
    , @NamedQuery(name = "Ciudad.findByTimeCreate", query = "SELECT c FROM Ciudad c WHERE c.timeCreate = :timeCreate")
    , @NamedQuery(name = "Ciudad.findByUsrLastUpdate", query = "SELECT c FROM Ciudad c WHERE c.usrLastUpdate = :usrLastUpdate")
    , @NamedQuery(name = "Ciudad.findByTimeLastUpdate", query = "SELECT c FROM Ciudad c WHERE c.timeLastUpdate = :timeLastUpdate")})
public class Ciudad implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private Set<Domicilio> domicilioSet;
    @JoinColumn(name = "estado", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false)
    private EstadoCiudad estado;
    @JoinColumn(name = "provincia", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false)
    private Provincia provincia;

    public Ciudad() {
    }

    public Ciudad(Integer codigo) {
        this.codigo = codigo;
    }

    public Ciudad(Integer codigo, String nombre, String usrCreate, Date timeCreate, String usrLastUpdate, Date timeLastUpdate) {
        this.codigo = codigo;
        this.nombre = nombre;
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
    public Set<Domicilio> getDomicilioSet() {
        return domicilioSet;
    }

    public void setDomicilioSet(Set<Domicilio> domicilioSet) {
        this.domicilioSet = domicilioSet;
    }

    public EstadoCiudad getEstado() {
        return estado;
    }

    public void setEstado(EstadoCiudad estado) {
        this.estado = estado;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
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
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.Ciudad[ codigo=" + codigo + " ]";
    }
    
}
