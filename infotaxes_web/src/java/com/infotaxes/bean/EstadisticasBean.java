package com.infotaxes.bean;

import com.infotaxes.dao.EstadisticaDaoImpl;
import com.infotaxes.pojos.Estadistica;
import com.infotaxes.pojos.Servicio;
import com.infotaxes.pojos.Sucursal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean(name = "EstadisticasBean")
@RequestScoped
public class EstadisticasBean {

    private Estadistica estadistica;
    private Servicio servicio;
    private List<Estadistica> LEstadisticas;
    private List<Estadistica> LEstadisticaDetalle;
    private List<Servicio> SelectedServicio;
    private List<Estadistica> LSerDetalle;

    public EstadisticasBean() {
    }

    @PostConstruct
    public void init() {
        CargarObjetos();
        //CargarDetalle();
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
    
    public void CargarDetalle(int idSucursal){
        EstadisticaDaoImpl estadist = new EstadisticaDaoImpl();
        LEstadisticaDetalle = new ArrayList<Estadistica>();
        
        List<Object[]> ListDatos = (List<Object[]>) estadist.CargarDetalle(idSucursal);
        
        for (Object[] datos : ListDatos) {
            Estadistica est = new Estadistica();
            Servicio ser = new Servicio();
            
            est.setIdestadistica((int) datos[0]);
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
        
        LSerDetalle =  new ArrayList<Estadistica>();
        LSerDetalle = estadist.findAll();
    }
    
    public void onRowSelect(SelectEvent event){
        Servicio est = (Servicio) event.getObject();
        
        FacesMessage msg = new FacesMessage("Selección", "" + est);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowUnselect(UnselectEvent event){
        FacesMessage msg = new FacesMessage("Selección", "" + ((Servicio) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void SeleccionarLink(int idServicio){
        System.out.println("Servicio" + idServicio);
        FacesMessage msg = new FacesMessage("Selección", "" + idServicio);
        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public List<Servicio> getSelectedServicio() {
        return SelectedServicio;
    }

    public void setSelectedServicio(List<Servicio> SelectedServicio) {
        this.SelectedServicio = SelectedServicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public List<Estadistica> getLSerDetalle() {
        return LSerDetalle;
    }

    public void setLSerDetalle(List<Estadistica> LSerDetalle) {
        this.LSerDetalle = LSerDetalle;
    }
    
}
