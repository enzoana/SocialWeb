package org.socialweb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
        schema = "public", uniqueConstraints = {
            @UniqueConstraint(columnNames = {"usuario_login"}),
            @UniqueConstraint(columnNames = {"correo_electronico_login"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll",
            query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCodigo",
            query = "SELECT u FROM Usuario u WHERE u.codigo = :codigo"),
    @NamedQuery(name = "Usuario.findByUsuarioLogin",
            query = "SELECT u FROM Usuario u WHERE u.usuarioLogin = :usuarioLogin"),
        @NamedQuery(name = "Usuario.findByUsuarioLoginCheckLogin",
            query = "SELECT u FROM Usuario u WHERE u.usuarioLogin = :usuarioLogin AND u.passwordLogin = :passwordLogin"),
    @NamedQuery(name = "Usuario.findByCorreoElectronicoLogin",
            query = "SELECT u FROM Usuario u WHERE u.correoElectronicoLogin = :correoElectronicoLogin"),
    @NamedQuery(name = "Usuario.findByCorreoElectronicoLoginCheckLogin",
            query = "SELECT u FROM Usuario u WHERE u.correoElectronicoLogin = :correoElectronicoLogin AND u.passwordLogin = :passwordLogin")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;

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
    @Size(min = 1, max = 2147483647)
    @Column(name = "correo_electronico_login",
            nullable = false,
            length = 2147483647)
    private String correoElectronicoLogin;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "password_login",
            nullable = false,
            length = 2147483647)
    private String passwordLogin;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
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
    @Size(min = 1, max = 2147483647)
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

    @ManyToMany(cascade = CascadeType.ALL,
            mappedBy = "usuarios")
    private Set<Rol> roles;

    public Usuario() {}

    public Usuario(Integer codigo) {
        this.codigo = codigo;
    }

    public Usuario(Integer codigo,
            String usuarioLogin,
            String correoElectronicoLogin,
            String passwordLogin,
            String usrCreate,
            Date timeCreate,
            String usrLastUpdate,
            Date timeLastUpdate) {
        this.codigo = codigo;
        this.usuarioLogin = usuarioLogin;
        this.correoElectronicoLogin = correoElectronicoLogin;
        this.passwordLogin = passwordLogin;
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

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getCorreoElectronicoLogin() {
        return correoElectronicoLogin;
    }

    public void setCorreoElectronicoLogin(String correoElectronicoLogin) {
        this.correoElectronicoLogin = correoElectronicoLogin;
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

    @XmlTransient
    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.Usuario[ codigo=" + codigo + " ]";
    }
}