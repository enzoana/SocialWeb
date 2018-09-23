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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author enzo
 */
@Entity
@Table(name = "empresa_social",
        catalog = "socialweb",
        schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaSocial.findAll",
            query = "SELECT e FROM EmpresaSocial e"),
    @NamedQuery(name = "EmpresaSocial.findByPersonaJuridica",
            query = "SELECT e FROM EmpresaSocial e WHERE e.personaJuridica = :personaJuridica")})
public class EmpresaSocial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer personaJuridica;

    @JoinColumn(name = "persona_juridica",
            referencedColumnName = "codigo",
            nullable = false,
            insertable = false,
            updatable = false)
    @OneToOne(optional = false)
    private PersonaJuridica personaJuridicaSuperClase;

    @Column(name = "matricula_inaes")
    private Integer matriculaInaes;

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

    public EmpresaSocial() {}

    public EmpresaSocial(Integer personaJuridica) {
        this.personaJuridica = personaJuridica;
    }

    public EmpresaSocial(Integer personaJuridica,
            Integer matriculaInaes,
            String usrCreate,
            Date timeCreate,
            String usrLastUpdate,
            Date timeLastUpdate) {
        this.personaJuridica = personaJuridica;
        this.matriculaInaes = matriculaInaes;
        this.usrCreate = usrCreate;
        this.timeCreate = timeCreate;
        this.usrLastUpdate = usrLastUpdate;
        this.timeLastUpdate = timeLastUpdate;
    }

    public Integer getPersonaJuridica() {
        return personaJuridica;
    }

    public void setPersonaJuridica(Integer personaJuridica) {
        this.personaJuridica = personaJuridica;
    }

    public PersonaJuridica getPersonaJuridicaSuperClase() {
        return personaJuridicaSuperClase;
    }

    public void setPersonaJuridicaSuperClase(PersonaJuridica personaJuridicaSuperClase) {
        this.personaJuridicaSuperClase = personaJuridicaSuperClase;
    }

    public Integer getMatriculaInaes() {
        return matriculaInaes;
    }

    public void setMatriculaInaes(Integer matriculaInaes) {
        this.matriculaInaes = matriculaInaes;
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
        hash += (personaJuridica != null ? personaJuridica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaSocial)) {
            return false;
        }
        EmpresaSocial other = (EmpresaSocial) object;
        if ((this.personaJuridica == null && other.personaJuridica != null) || (this.personaJuridica != null && !this.personaJuridica.equals(other.personaJuridica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.EmpresaSocial[ personaJuridica=" + personaJuridica + " ]";
    }
}