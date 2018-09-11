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
 * EstadoPais generated by hbm2java
 */
@Entity
@Table(name="estado_pais",
        schema="public"
)
public class EstadoPais implements java.io.Serializable {

    private int codigo;
    private String descripcion;
    private List<Pais> paises = new ArrayList<Pais>(0);

    public EstadoPais() {}
	
    public EstadoPais(int codigo,
            String descripcion) {

        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public EstadoPais(int codigo,
            String descripcion,
            List<Pais> paises) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.paises = paises;
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
            mappedBy="estadoPais")
    public List<Pais> getPaises() {
        return this.paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }
}