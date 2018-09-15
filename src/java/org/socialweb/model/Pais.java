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
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")
    , @NamedQuery(name = "Pais.findByCodigo", query = "SELECT p FROM Pais p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Pais.findByNombre", query = "SELECT p FROM Pais p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pais.findByNombreIso", query = "SELECT p FROM Pais p WHERE p.nombreIso = :nombreIso")
    , @NamedQuery(name = "Pais.findByCodigoIsoAlfa2", query = "SELECT p FROM Pais p WHERE p.codigoIsoAlfa2 = :codigoIsoAlfa2")
    , @NamedQuery(name = "Pais.findByCodigoIsoAlfa3", query = "SELECT p FROM Pais p WHERE p.codigoIsoAlfa3 = :codigoIsoAlfa3")
    , @NamedQuery(name = "Pais.findByCodigoIso", query = "SELECT p FROM Pais p WHERE p.codigoIso = :codigoIso")
    , @NamedQuery(name = "Pais.findByUsrCreate", query = "SELECT p FROM Pais p WHERE p.usrCreate = :usrCreate")
    , @NamedQuery(name = "Pais.findByTimeCreate", query = "SELECT p FROM Pais p WHERE p.timeCreate = :timeCreate")
    , @NamedQuery(name = "Pais.findByUsrLastUpdate", query = "SELECT p FROM Pais p WHERE p.usrLastUpdate = :usrLastUpdate")
    , @NamedQuery(name = "Pais.findByTimeLastUpdate", query = "SELECT p FROM Pais p WHERE p.timeLastUpdate = :timeLastUpdate")})
public class Pais implements Serializable {

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
    @Column(name = "nombre_iso", nullable = false, length = 2147483647)
    private String nombreIso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigo_iso_alfa_2", nullable = false, length = 2147483647)
    private String codigoIsoAlfa2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigo_iso_alfa_3", nullable = false, length = 2147483647)
    private String codigoIsoAlfa3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_iso", nullable = false)
    private int codigoIso;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private Set<Provincia> provinciaSet;
    @JoinColumn(name = "estado", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false)
    private EstadoPais estado;

    public Pais() {
    }

    public Pais(Integer codigo) {
        this.codigo = codigo;
    }

    public Pais(Integer codigo, String nombre, String nombreIso, String codigoIsoAlfa2, String codigoIsoAlfa3, int codigoIso, String usrCreate, Date timeCreate, String usrLastUpdate, Date timeLastUpdate) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombreIso = nombreIso;
        this.codigoIsoAlfa2 = codigoIsoAlfa2;
        this.codigoIsoAlfa3 = codigoIsoAlfa3;
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

    public String getNombreIso() {
        return nombreIso;
    }

    public void setNombreIso(String nombreIso) {
        this.nombreIso = nombreIso;
    }

    public String getCodigoIsoAlfa2() {
        return codigoIsoAlfa2;
    }

    public void setCodigoIsoAlfa2(String codigoIsoAlfa2) {
        this.codigoIsoAlfa2 = codigoIsoAlfa2;
    }

    public String getCodigoIsoAlfa3() {
        return codigoIsoAlfa3;
    }

    public void setCodigoIsoAlfa3(String codigoIsoAlfa3) {
        this.codigoIsoAlfa3 = codigoIsoAlfa3;
    }

    public int getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(int codigoIso) {
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

    @XmlTransient
    public Set<Provincia> getProvinciaSet() {
        return provinciaSet;
    }

    public void setProvinciaSet(Set<Provincia> provinciaSet) {
        this.provinciaSet = provinciaSet;
    }

    public EstadoPais getEstado() {
        return estado;
    }

    public void setEstado(EstadoPais estado) {
        this.estado = estado;
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
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.Pais[ codigo=" + codigo + " ]";
    }
    
}
