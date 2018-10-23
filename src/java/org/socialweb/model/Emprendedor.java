package org.socialweb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enzo
 */
@Entity
@Table(catalog = "socialweb",
        schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprendedor.findAll",
            query = "SELECT e FROM Emprendedor e"),
    @NamedQuery(name = "Emprendedor.findByPersonaHumana",
            query = "SELECT e FROM Emprendedor e WHERE e.personaHumana = :personaHumana")})
public class Emprendedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer personaHumana;

    @JoinColumn(name = "persona_humana",
            referencedColumnName = "persona",
            nullable = false,
            insertable = false,
            updatable = false)
    @OneToOne(optional = false)
    private PersonaHumana personaHumanaSuperClase;

    @JoinColumn(name = "empresa_social",
            referencedColumnName = "personaJuridica",
            nullable = false)
    @ManyToOne(cascade = CascadeType.ALL,
            optional = false)
    private EmpresaSocial empresaSocial;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int usuario;

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

    public Emprendedor() {}

    public Emprendedor(Integer personaHumana) {
        this.personaHumana = personaHumana;
    }

    public Emprendedor(Integer personaHumana,
            String usrCreate,
            Date timeCreate,
            String usrLastUpdate,
            Date timeLastUpdate) {
        this.personaHumana = personaHumana;
        this.usrCreate = usrCreate;
        this.timeCreate = timeCreate;
        this.usrLastUpdate = usrLastUpdate;
        this.timeLastUpdate = timeLastUpdate;
    }

    public Integer getPersonaHumana() {
        return personaHumana;
    }

    public void setPersonaHumana(Integer personaHumana) {
        this.personaHumana = personaHumana;
    }

    public PersonaHumana getPersonaHumanaSuperClase() {
        return personaHumanaSuperClase;
    }

    public void setPersonaHumanaSuperClase(PersonaHumana personaHumanaSuperClase) {
        this.personaHumanaSuperClase = personaHumanaSuperClase;
    }

    public EmpresaSocial getEmpresaSocial() {
        return empresaSocial;
    }

    public void setEmpresaSocial(EmpresaSocial empresaSocial) {
        this.empresaSocial = empresaSocial;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaHumana != null ? personaHumana.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprendedor)) {
            return false;
        }
        Emprendedor other = (Emprendedor) object;
        if ((this.personaHumana == null && other.personaHumana != null) || (this.personaHumana != null && !this.personaHumana.equals(other.personaHumana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.Emprendedor[ personaHumana=" + personaHumana + " ]";
    }
}