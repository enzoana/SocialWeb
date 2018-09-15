/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialweb.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author enzo
 */
@Entity
@Table(name = "estado_pais", catalog = "socialweb", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPais.findAll", query = "SELECT e FROM EstadoPais e")
    , @NamedQuery(name = "EstadoPais.findByCodigo", query = "SELECT e FROM EstadoPais e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "EstadoPais.findByDescripcion", query = "SELECT e FROM EstadoPais e WHERE e.descripcion = :descripcion")})
public class EstadoPais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private Set<Pais> paisSet;

    public EstadoPais() {
    }

    public EstadoPais(Integer codigo) {
        this.codigo = codigo;
    }

    public EstadoPais(Integer codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Set<Pais> getPaisSet() {
        return paisSet;
    }

    public void setPaisSet(Set<Pais> paisSet) {
        this.paisSet = paisSet;
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
        if (!(object instanceof EstadoPais)) {
            return false;
        }
        EstadoPais other = (EstadoPais) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.EstadoPais[ codigo=" + codigo + " ]";
    }
    
}
