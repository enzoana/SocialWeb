package org.socialweb.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LogAuditoria generated by hbm2java
 */
@Entity
@Table(name="log_auditoria"
    ,schema="public"
)
public class LogAuditoria implements java.io.Serializable {

     private int codigo;
     private Date fecha;
     private String tabla;
     private String usuario;
     private String operacion;
     private String datosViejos;
     private String datosNuevos;

    public LogAuditoria() {}
	
    public LogAuditoria(int codigo,
            Date fecha,
            String tabla,
            String usuario,
            String operacion) {

        this.codigo = codigo;
        this.fecha = fecha;
        this.tabla = tabla;
        this.usuario = usuario;
        this.operacion = operacion;
    }

    public LogAuditoria(int codigo,
            Date fecha,
            String tabla,
            String usuario,
            String operacion,
            String datosViejos,
            String datosNuevos) {

        this.codigo = codigo;
        this.fecha = fecha;
        this.tabla = tabla;
        this.usuario = usuario;
        this.operacion = operacion;
        this.datosViejos = datosViejos;
        this.datosNuevos = datosNuevos;
    }

    @Id
    @SequenceGenerator(name="logAuditoriaGenerator",
            sequenceName="seq_codigo_log_auditoria")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="logAuditoriaGenerator")
    @Column(name="codigo",
            unique=true,
            nullable=false)
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha",
            nullable=false,
            length=29)
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name="tabla",
            nullable=false)
    public String getTabla() {
        return this.tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    @Column(name="usuario",
            nullable=false)
    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name="operacion",
            nullable=false)
    public String getOperacion() {
        return this.operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Column(name="datos_viejos")
    public String getDatosViejos() {
        return this.datosViejos;
    }

    public void setDatosViejos(String datosViejos) {
        this.datosViejos = datosViejos;
    }

    @Column(name="datos_nuevos")
    public String getDatosNuevos() {
        return this.datosNuevos;
    }

    public void setDatosNuevos(String datosNuevos) {
        this.datosNuevos = datosNuevos;
    }
}