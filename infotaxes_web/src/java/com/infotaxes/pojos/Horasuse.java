package com.infotaxes.pojos;
// Generated 8/06/2015 05:19:51 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Horasuse generated by hbm2java
 */
@Entity
@Table(name="horasuse"
    ,catalog="infotaxes"
)
public class Horasuse  implements java.io.Serializable {


     private Integer idhorasuse;
     private Servicio servicio;
     private Sucursal sucursal;
     private String horaIn;
     private String horafin;
     private String decripcion;

    public Horasuse() {
    }

	
    public Horasuse(Servicio servicio, Sucursal sucursal, String horaIn, String horafin) {
        this.servicio = servicio;
        this.sucursal = sucursal;
        this.horaIn = horaIn;
        this.horafin = horafin;
    }
    public Horasuse(Servicio servicio, Sucursal sucursal, String horaIn, String horafin, String decripcion) {
       this.servicio = servicio;
       this.sucursal = sucursal;
       this.horaIn = horaIn;
       this.horafin = horafin;
       this.decripcion = decripcion;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idhorasuse", unique=true, nullable=false)
    public Integer getIdhorasuse() {
        return this.idhorasuse;
    }
    
    public void setIdhorasuse(Integer idhorasuse) {
        this.idhorasuse = idhorasuse;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="servicio_id", nullable=false)
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sucursal_id", nullable=false)
    public Sucursal getSucursal() {
        return this.sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    
    @Column(name="horaIn", nullable=false, length=45)
    public String getHoraIn() {
        return this.horaIn;
    }
    
    public void setHoraIn(String horaIn) {
        this.horaIn = horaIn;
    }

    
    @Column(name="horafin", nullable=false, length=45)
    public String getHorafin() {
        return this.horafin;
    }
    
    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    
    @Column(name="decripcion", length=120)
    public String getDecripcion() {
        return this.decripcion;
    }
    
    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }




}


