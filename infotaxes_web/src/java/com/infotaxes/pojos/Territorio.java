package com.infotaxes.pojos;
// Generated 8/06/2015 03:52:10 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Territorio generated by hbm2java
 */
@Entity
@Table(name="territorio"
    ,catalog="infotaxes"
)
public class Territorio  implements java.io.Serializable {


     private Integer id;
     private Territorio territorio;
     private String nombre;
     private String tipo;
     private Set usuarios = new HashSet(0);
     private Set territorios = new HashSet(0);
     private Set sucursals = new HashSet(0);

    public Territorio() {
    }

	
    public Territorio(Territorio territorio) {
        this.territorio = territorio;
    }
    public Territorio(Territorio territorio, String nombre, String tipo, Set usuarios, Set territorios, Set sucursals) {
       this.territorio = territorio;
       this.nombre = nombre;
       this.tipo = tipo;
       this.usuarios = usuarios;
       this.territorios = territorios;
       this.sucursals = sucursals;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="territorio_id", nullable=false)
    public Territorio getTerritorio() {
        return this.territorio;
    }
    
    public void setTerritorio(Territorio territorio) {
        this.territorio = territorio;
    }

    
    @Column(name="nombre", length=95)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="tipo", length=1)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="territorio")
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="territorio")
    public Set getTerritorios() {
        return this.territorios;
    }
    
    public void setTerritorios(Set territorios) {
        this.territorios = territorios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="territorio")
    public Set getSucursals() {
        return this.sucursals;
    }
    
    public void setSucursals(Set sucursals) {
        this.sucursals = sucursals;
    }




}


