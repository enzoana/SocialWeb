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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
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
        schema = "public",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"cuit_cuil_cdi"})
        })
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll",
            query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByCodigo",
            query = "SELECT p FROM Persona p WHERE p.codigo = :codigo")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "personaGenerator",
            sequenceName = "seq_codigo_persona")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "personaGenerator")
    @Basic(optional = false)
    @Column(name = "codigo",
            nullable = false,
            updatable = false)
    private Integer codigo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cuit_cuil_cdi",
            nullable = false)
    private Serializable cuitCuilCdi;

    @JoinColumn(name = "domicilio_real",
            referencedColumnName = "codigo",
            nullable = false)
    @ManyToOne(cascade = CascadeType.ALL,
            optional = false)
    private Domicilio domicilioReal;

    @JoinColumn(name = "domicilio_fiscal",
            referencedColumnName = "codigo")
    @ManyToOne(cascade = CascadeType.ALL,
            optional = false)
    private Domicilio domicilioFiscal;

    @JoinColumn(name = "domicilio_legal",
            referencedColumnName = "codigo")
    @ManyToOne(cascade = CascadeType.ALL,
            optional = false)
    private Domicilio domicilioLegal;

    @JoinColumn(name = "estado",
            referencedColumnName = "codigo",
            nullable = false)
    @ManyToOne(cascade = CascadeType.ALL,
            optional = false)
    private EstadoPersona estado;

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
            mappedBy = "persona")
    @JsonIgnore
    private Set<Contacto> contactos;

    @OneToOne(cascade = CascadeType.ALL,
            mappedBy = "personaSuperClase")
    private PersonaJuridica personaJuridica;

    @OneToOne(cascade = CascadeType.ALL,
            mappedBy = "personaSuperClase")
    private PersonaHumana personaHumana;

    public Persona() {}

    public Persona(Integer codigo) {
        this.codigo = codigo;
    }

    public Persona(Integer codigo,
            Serializable cuitCuilCdi,
            String usrCreate,
            Date timeCreate,
            String usrLastUpdate,
            Date timeLastUpdate) {
        this.codigo = codigo;
        this.cuitCuilCdi = cuitCuilCdi;
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

    public Serializable getCuitCuilCdi() {
        return cuitCuilCdi;
    }

    public void setCuitCuilCdi(Serializable cuitCuilCdi) {
        this.cuitCuilCdi = cuitCuilCdi;
    }

    public Domicilio getDomicilioReal() {
        return domicilioReal;
    }

    public void setDomicilioReal(Domicilio domicilioReal) {
        this.domicilioReal = domicilioReal;
    }

    public Domicilio getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(Domicilio domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }

    public Domicilio getDomicilioLegal() {
        return domicilioLegal;
    }

    public void setDomicilioLegal(Domicilio domicilioLegal) {
        this.domicilioLegal = domicilioLegal;
    }

    public EstadoPersona getEstado() {
        return estado;
    }

    public void setEstado(EstadoPersona estado) {
        this.estado = estado;
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
    public Set<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(Set<Contacto> contactos) {
        this.contactos = contactos;
    }

    public PersonaJuridica getPersonaJuridica() {
        return personaJuridica;
    }

    public void setPersonaJuridica(PersonaJuridica personaJuridica) {
        this.personaJuridica = personaJuridica;
    }

    public PersonaHumana getPersonaHumana() {
        return personaHumana;
    }

    public void setPersonaHumana(PersonaHumana personaHumana) {
        this.personaHumana = personaHumana;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.Persona[ codigo=" + codigo + " ]";
    }
}