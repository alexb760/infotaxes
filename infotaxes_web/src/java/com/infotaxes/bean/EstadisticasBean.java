package com.infotaxes.bean;

import com.infotaxes.dao.EstadisticaDaoImpl;
import com.infotaxes.pojos.Estadistica;
import com.infotaxes.pojos.Servicio;
import com.infotaxes.pojos.Sucursal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "EstadisticasBean")
@RequestScoped
public class EstadisticasBean {

    private Estadistica estadistica;
    private List<Estadistica> LEstadisticas;
    private List<Estadistica> LEstadisticaDetalle;

    public EstadisticasBean() {
    }

    @PostConstruct
    public void init() {
        CargarObjetos();
        CargarDetalle();
    }

    public void CargarObjetos() {
        EstadisticaDaoImpl estadist = new EstadisticaDaoImpl();
        LEstadisticas = new ArrayList<Estadistica>();

        List<Object[]> ListDatos = (List<Object[]>) estadist.Cargar();

        for (Object[] datos : ListDatos) {
            Estadistica est = new Estadistica();
            Sucursal suc = new Sucursal();

            suc.setId((int) datos[0]);
            Double valorDecimal = new Double((double) datos[1]);
            int ValorEntero = valorDecimal.intValue();
            est.setValor(ValorEntero);
            suc.setNombre(datos[2].toString());
            suc.setDireccion(datos[3].toString());
            suc.setTelefono(datos[4].toString());
            suc.setCorreo(datos[5].toString());
            suc.setDescripcion(datos[6].toString());

            est.setSucursal(suc);
            LEstadisticas.add(est);

        }
    }
    
    public void CargarDetalle(){
        EstadisticaDaoImpl estadist = new EstadisticaDaoImpl();
        LEstadisticaDetalle = new ArrayList<Estadistica>();
        
        List<Object[]> ListDatos = (List<Object[]>) estadist.CargarDetalle();
        
        for (Object[] datos : ListDatos) {
            Estadistica est = new Estadistica();
            Servicio ser = new Servicio();
            
            ser.setId((int)datos[0]);
            Double valorDecimal = new Double((double) datos[1]);
            int ValorEntero = valorDecimal.intValue();
            est.setValor(ValorEntero);
            ser.setDescripcion(datos[2].toString());
            est.setComentario(datos[3].toString());
            ser.setValor((double)datos[4]);
            
            est.setServicio(ser);
            LEstadisticaDetalle.add(est);

        }
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

    public List<Estadistica> getLEstadisticas() {
        return LEstadisticas;
    }

    public void setLEstadisticas(List<Estadistica> LEstadisticas) {
        this.LEstadisticas = LEstadisticas;
    }

    public List<Estadistica> getLEstadisticaDetalle() {
        return LEstadisticaDetalle;
    }

    public void setLEstadisticaDetalle(List<Estadistica> LEstadisticaDetalle) {
        this.LEstadisticaDetalle = LEstadisticaDetalle;
    }
    
}
