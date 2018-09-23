package org.socialweb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enzo
 */
@Entity
@Table(
        catalog = "socialweb",
        schema = "public",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"usuario_login"}),
            @UniqueConstraint(columnNames = {"correo_electronico_login"})
        })
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
    @Column(name = "persona_humana", nullable = false)
    private Integer personaHumana;

    @JoinColumn(name = "persona_humana",
            referencedColumnName = "codigo",
            nullable = false,
            insertable = false,
            updatable = false)
    @OneToOne(optional = false)
    private PersonaHumana personaHumanaSuperClase;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1,
            max = 2147483647)
    @Column(name = "correo_electronico_login",
            nullable = false,
            length = 2147483647)
    private String correoElectronicoLogin;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1,
            max = 2147483647)
    @Column(name = "usuario_login",
            nullable = false,
            length = 2147483647)
    private String usuarioLogin;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1,
            max = 2147483647)
    @Column(name = "password_login",
            nullable = false,
            length = 2147483647)
    private String passwordLogin;

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
            String correoElectronicoLogin,
            String usuarioLogin,
            String passwordLogin,
            String usrCreate,
            Date timeCreate,
            String usrLastUpdate,
            Date timeLastUpdate) {
        this.personaHumana = personaHumana;
        this.correoElectronicoLogin = correoElectronicoLogin;
        this.usuarioLogin = usuarioLogin;
        this.passwordLogin = passwordLogin;
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

    public String getCorreoElectronicoLogin() {
        return correoElectronicoLogin;
    }

    public void setCorreoElectronicoLogin(String correoElectronicoLogin) {
        this.correoElectronicoLogin = correoElectronicoLogin;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
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