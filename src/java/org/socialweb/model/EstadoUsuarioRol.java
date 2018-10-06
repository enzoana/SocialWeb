package org.socialweb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enzo
 */
@Entity
@Table(name = "estado_usuario_rol",
    catalog = "socialweb",
     schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoUsuarioRol.findAll",
            query = "SELECT e FROM EstadoUsuarioRol e"),
    @NamedQuery(name = "EstadoUsuarioRol.findByCodigo",
            query = "SELECT e FROM EstadoUsuarioRol e WHERE e.codigo = :codigo")})
public class EstadoUsuarioRol implements Serializable {

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

    public EstadoUsuarioRol() {}

    public EstadoUsuarioRol(Integer codigo) {
        this.codigo = codigo;
    }

    public EstadoUsuarioRol(Integer codigo, String descripcion) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoUsuarioRol)) {
            return false;
        }
        EstadoUsuarioRol other = (EstadoUsuarioRol) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.EstadoUsuarioRol[ codigo=" + codigo + " ]";
    }
}