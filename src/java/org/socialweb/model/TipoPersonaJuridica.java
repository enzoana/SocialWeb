package org.socialweb.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoPersonaJuridica generated by hbm2java
 */
@Entity
@Table(name="tipo_persona_juridica"
    ,schema="public"
)
public class TipoPersonaJuridica implements java.io.Serializable {


     private int codigo;
     private String descripcion;
     private List<PersonaJuridica> personasJuridicas = new ArrayList<PersonaJuridica>(0);

    public TipoPersonaJuridica() {}

    public TipoPersonaJuridica(int codigo,
            String descripcion) {

        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public TipoPersonaJuridica(int codigo,
            String descripcion,
            List<PersonaJuridica> personasJuridicas) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.personasJuridicas = personasJuridicas;
    }

    @Id
    @Column(name="codigo",
            unique=true,
            nullable=false)
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name="descripcion",
            nullable=false)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="tipoPersonaJuridica")
    public List<PersonaJuridica> getPersonasJuridicas() {
        return this.personasJuridicas;
    }

    public void setPersonasJuridicas(List<PersonaJuridica> personasJuridicas) {
        this.personasJuridicas = personasJuridicas;
    }
}