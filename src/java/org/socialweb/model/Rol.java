package org.socialweb.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(catalog = "socialweb",
        schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll",
            query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByCodigo",
            query = "SELECT r FROM Rol r WHERE r.codigo = :codigo")})
public class Rol implements Serializable {

    public static final int ADMINISTRADOR_GENERAL = 1;
    public static final int ADMINISTRADOR_EMPRESA_SOCIAL = 2;
    public static final int EMPRENDEDOR = 3;

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer codigo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1,
            max = 2147483647)
    @Column(nullable = false,
            length = 2147483647)
    private String descripcion;

    @ManyToMany(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_rol",
        joinColumns = {
            @JoinColumn(name = "rol",
                    nullable = false,
                    updatable = false)
        },
        inverseJoinColumns = {
            @JoinColumn(name = "usuario",
                    nullable = false,
                    updatable = false)
        }
    )
    private Set<Usuario> usuarios;

    public Rol() {}

    public Rol(Integer codigo) {
        this.codigo = codigo;
    }

    public Rol(Integer codigo,
            String descripcion) {
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
    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
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
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.Rol[ codigo=" + codigo + " ]";
    }
}