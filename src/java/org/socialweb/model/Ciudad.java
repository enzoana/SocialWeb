package org.socialweb.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ciudad generated by hbm2java
 */
@Entity
@Table(name="ciudad"
    ,schema="public"
)
public class Ciudad implements java.io.Serializable {

    private int codigo;
    private EstadoCiudad estadoCiudad;
    private Provincia provincia;
    private String nombre;
    private String usrCreate;
    private Date timeCreate;
    private String usrLastUpdate;
    private Date timeLastUpdate;
    private List<Domicilio> domicilios = new ArrayList<Domicilio>(0);

    public Ciudad() {}
	
    public Ciudad(int codigo,
            EstadoCiudad estadoCiudad,
            Provincia provincia,
            String nombre,
            String usrCreate,
            Date timeCreate,
            String usrLastUpdate,
            Date timeLastUpdate) {

        this.codigo = codigo;
        this.estadoCiudad = estadoCiudad;
        this.provincia = provincia;
        this.nombre = nombre;
        this.usrCreate = usrCreate;
        this.timeCreate = timeCreate;
        this.usrLastUpdate = usrLastUpdate;
        this.timeLastUpdate = timeLastUpdate;
    }

    public Ciudad(int codigo,
            EstadoCiudad estadoCiudad,
            Provincia provincia,
            String nombre,
            String usrCreate,
            Date timeCreate,
            String usrLastUpdate,
            Date timeLastUpdate,
            List<Domicilio> domicilios) {

        this.codigo = codigo;
        this.estadoCiudad = estadoCiudad;
        this.provincia = provincia;
        this.nombre = nombre;
        this.usrCreate = usrCreate;
        this.timeCreate = timeCreate;
        this.usrLastUpdate = usrLastUpdate;
        this.timeLastUpdate = timeLastUpdate;
        this.domicilios = domicilios;
    }

    @Id
    @SequenceGenerator(name="ciudadGenerator",
            sequenceName="seq_codigo_ciudad")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="diudadGenerator")
    @JoinColumn(name="codigo",
            referencedColumnName="codigo",
            nullable=false,
            unique=true,
            insertable=false,
            updatable=false)
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="estado",
            nullable=false,
            insertable=false,
            updatable=false)
    public EstadoCiudad getEstadoCiudad() {
        return this.estadoCiudad;
    }

    public void setEstadoCiudad(EstadoCiudad estadoCiudad) {
        this.estadoCiudad = estadoCiudad;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="provincia",
            nullable=false,
            insertable=false,
            updatable=false)
    public Provincia getProvincia() {
        return this.provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Column(name="nombre",
            nullable=false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="usr_create",
            nullable=false)
    public String getUsrCreate() {
        return this.usrCreate;
    }

    public void setUsrCreate(String usrCreate) {
        this.usrCreate = usrCreate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_create",
            nullable=false,
            length=29)
    public Date getTimeCreate() {
        return this.timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    @Column(name="usr_last_update",
            nullable=false)
    public String getUsrLastUpdate() {
        return this.usrLastUpdate;
    }

    public void setUsrLastUpdate(String usrLastUpdate) {
        this.usrLastUpdate = usrLastUpdate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_last_update",
            nullable=false,
            length=29)
    public Date getTimeLastUpdate() {
        return this.timeLastUpdate;
    }

    public void setTimeLastUpdate(Date timeLastUpdate) {
        this.timeLastUpdate = timeLastUpdate;
    }

    @OneToMany(fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy="ciudad")
    public List<Domicilio> getDomicilios() {
        return this.domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }
}