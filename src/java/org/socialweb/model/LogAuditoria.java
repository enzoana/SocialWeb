/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialweb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "log_auditoria", catalog = "socialweb", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogAuditoria.findAll", query = "SELECT l FROM LogAuditoria l")
    , @NamedQuery(name = "LogAuditoria.findByCodigo", query = "SELECT l FROM LogAuditoria l WHERE l.codigo = :codigo")
    , @NamedQuery(name = "LogAuditoria.findByFecha", query = "SELECT l FROM LogAuditoria l WHERE l.fecha = :fecha")
    , @NamedQuery(name = "LogAuditoria.findByTabla", query = "SELECT l FROM LogAuditoria l WHERE l.tabla = :tabla")
    , @NamedQuery(name = "LogAuditoria.findByUsuario", query = "SELECT l FROM LogAuditoria l WHERE l.usuario = :usuario")
    , @NamedQuery(name = "LogAuditoria.findByOperacion", query = "SELECT l FROM LogAuditoria l WHERE l.operacion = :operacion")
    , @NamedQuery(name = "LogAuditoria.findByDatosViejos", query = "SELECT l FROM LogAuditoria l WHERE l.datosViejos = :datosViejos")
    , @NamedQuery(name = "LogAuditoria.findByDatosNuevos", query = "SELECT l FROM LogAuditoria l WHERE l.datosNuevos = :datosNuevos")})
public class LogAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String tabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String operacion;
    @Size(max = 2147483647)
    @Column(name = "datos_viejos", length = 2147483647)
    private String datosViejos;
    @Size(max = 2147483647)
    @Column(name = "datos_nuevos", length = 2147483647)
    private String datosNuevos;

    public LogAuditoria() {
    }

    public LogAuditoria(Integer codigo) {
        this.codigo = codigo;
    }

    public LogAuditoria(Integer codigo, Date fecha, String tabla, String usuario, String operacion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.tabla = tabla;
        this.usuario = usuario;
        this.operacion = operacion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getDatosViejos() {
        return datosViejos;
    }

    public void setDatosViejos(String datosViejos) {
        this.datosViejos = datosViejos;
    }

    public String getDatosNuevos() {
        return datosNuevos;
    }

    public void setDatosNuevos(String datosNuevos) {
        this.datosNuevos = datosNuevos;
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
        if (!(object instanceof LogAuditoria)) {
            return false;
        }
        LogAuditoria other = (LogAuditoria) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialweb.model.LogAuditoria[ codigo=" + codigo + " ]";
    }
    
}
