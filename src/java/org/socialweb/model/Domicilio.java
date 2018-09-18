package org.socialweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
    @NamedQuery(name = "Domicilio.findAll",
            query = "SELECT d FROM Domicilio d"),
    @NamedQuery(name = "Domicilio.findByCodigo",
            query = "SELECT d FROM Domicilio d WHERE d.codigo = :codigo")})
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "domicilioGenerator",
            sequenceName = "seq_codigo_domicilio")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "domicilioGenerator")
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
    private String calle;

    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String numero;

    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String departamento;

    @JoinColumn(name = "ciudad",
            referencedColumnName = "codigo",
            nullable = false)
    @ManyToOne(cascade = CascadeType.ALL,
            optional = false)
    private Ciudad ciudad;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1,
            max = 2147483647)
    @Column(name = "usr_create",
            nullable = false,
            length = 2147483647)
    private String usrCreate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "time_create",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCreate;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1,
            max = 2147483647)
    @Column(name = "usr_last_update",
            nullable = false,
            length = 2147483647)
    private String usrLastUpdate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "time_last_update",
            nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeLastUpdate;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "domicilioReal")
    @JsonIgnore
    private Set<Persona> domiciliosRealesPersonas;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "domicilioFiscal")
    @JsonIgnore
    private Set<Persona> domiciliosFiscalesPersonas;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "domicilioLegal")
    @JsonIgnore
    private Set<Persona> domiciliosLegalesPersonas;

    public Domicilio() {}

    public Domicilio(Integer codigo) {
        this.codigo = codigo;
    }

    public Domicilio(Integer codigo,
            String calle,
            String usrCreate,
            Date timeCreate,
            String usrLastUpdate,
            Date timeLastUpdate) {
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

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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
    public Set<Persona> getDomiciliosRealesPersonas() {
        return domiciliosRealesPersonas;
    }

    public void setDomiciliosRealesPersonas(Set<Persona> domiciliosRealesPersonas) {
        this.domiciliosRealesPersonas = domiciliosRealesPersonas;
    }

    @XmlTransient
    public Set<Persona> getDomiciliosFiscalesPersonas() {
        return domiciliosFiscalesPersonas;
    }

    public void setDomiciliosFiscalesPersonas(Set<Persona> domiciliosFiscalesPersonas) {
        this.domiciliosFiscalesPersonas = domiciliosFiscalesPersonas;
    }

    @XmlTransient
    public Set<Persona> getDomiciliosLegalesPersonas() {
        return domiciliosLegalesPersonas;
    }

    public void setDomiciliosLegalesPersonas(Set<Persona> domiciliosLegalesPersonas) {
        this.domiciliosLegalesPersonas = domiciliosLegalesPersonas;
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