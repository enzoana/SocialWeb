package org.socialweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "estado_provincia",
        catalog = "socialweb",
        schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoProvincia.findAll",
            query = "SELECT e FROM EstadoProvincia e"),
    @NamedQuery(name = "EstadoProvincia.findByCodigo",
            query = "SELECT e FROM EstadoProvincia e WHERE e.codigo = :codigo")})
public class EstadoProvincia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "codigo",
            nullable = false,
            updatable = false)
    private Integer codigo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1,
            max = 2147483647)
    @Column(nullable = false,
            length = 2147483647)
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "estado")
    @JsonIgnore
    private Set<Provincia> provincias;

    public EstadoProvincia() {}

    public EstadoProvincia(Integer codigo) {
        this.codigo = codigo;
    }

    public EstadoProvincia(Integer codigo,
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
    public Set<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(Set<Provincia> provincias) {
        this.provincias = provincias;
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
        if (!(object instanceof EstadoProvincia)) {
            return false;
        }
        EstadoProvincia other = (EstadoProvincia) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.EstadoProvincia[ codigo=" + codigo + " ]";
    }
}