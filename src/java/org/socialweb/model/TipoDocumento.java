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
@Table(name = "tipo_documento",
        catalog = "socialweb",
        schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll",
            query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByCodigo",
            query = "SELECT t FROM TipoDocumento t WHERE t.codigo = :codigo")})
public class TipoDocumento implements Serializable {

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

    @Basic(optional = false)
    @NotNull
    @Size(min = 1,
            max = 2147483647)
    @Column(name = "descripcion_corta",
            nullable = false,
            length = 2147483647)
    private String descripcionCorta;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "tipoDocumento")
    @JsonIgnore
    private Set<PersonaHumana> personasHumanas;

    public TipoDocumento() {}

    public TipoDocumento(Integer codigo) {
        this.codigo = codigo;
    }

    public TipoDocumento(Integer codigo,
            String descripcion,
            String descripcionCorta) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.descripcionCorta = descripcionCorta;
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

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    @XmlTransient
    public Set<PersonaHumana> getPersonasHumanas() {
        return personasHumanas;
    }

    public void setPersonasHumanas(Set<PersonaHumana> personasHumanas) {
        this.personasHumanas = personasHumanas;
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
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.TipoDocumento[ codigo=" + codigo + " ]";
    }
}