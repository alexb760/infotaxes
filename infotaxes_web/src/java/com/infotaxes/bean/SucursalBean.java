/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotaxes.bean;

import com.infotaxes.dao.SucursalDaoImpl;
import com.infotaxes.dao.TerritorioDaoImpl;
import com.infotaxes.dao.TipoDaoImpl;
import com.infotaxes.pojos.Sucursal;
import com.infotaxes.pojos.Territorio;
import com.infotaxes.pojos.Tipo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "sucursalBean")
@RequestScoped
public class SucursalBean {
    
    public Sucursal sucursal;
    public List<Sucursal> list_sucursal;
    public Sucursal create_suc;
    public List<Territorio> list_ciudad;
    
    @ManagedProperty("#{territorioImpl2}")
    private TerritorioDaoImpl territorioImpl;
    private Territorio territorio;
    
    @ManagedProperty("#{tipoImpl}")
    private TipoDaoImpl tipoDaoImpl;
    private Tipo tipo;
    
    public SucursalBean() {
       // cargarObjetos();
    
    }  
    
    @PostConstruct
    public void init(){
        //cargarObjetos();
    }
    
    public void cargarObjetos() {
        SucursalDaoImpl sucuDao = new SucursalDaoImpl();
        list_sucursal = new ArrayList<Sucursal>();

        List<Object[]> ListDatos = (List<Object[]>) sucuDao.CargarSucursales();

        for (Object[] datos : ListDatos) {
            Sucursal suc = new Sucursal();
            Territorio ter = new Territorio();
            Tipo tip = new Tipo();

            suc.setId((int) datos[0]);
            suc.setNombre(datos[1].toString());
            suc.setDireccion(datos[2].toString());
            suc.setTelefono(datos[3].toString());            
            suc.setCorreo(datos[4].toString());
            
            tip.setNombre(datos[5].toString());
            suc.setTipo(tip);
            
            ter.setNombre(datos[6].toString());
            suc.setTerritorio(ter);
            
            list_sucursal.add(suc);

        }
        
        
    }
    
    public void guardar() throws Exception {
        try {
            
            SucursalDaoImpl sucursalImpl = new SucursalDaoImpl();
           
            sucursalImpl.create(sucursal);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha creado sucursal : ", this.sucursal.getNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            sucursal = null;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Inesperado: ", e.getMessage() + "\n " + e.getLocalizedMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    public void limpiar_Create(){
        
        sucursal = null;
        getCiudades("");
        getTipos();
        
    }
    
    public List<Territorio> getCiudades(String query){
        territorioImpl = new TerritorioDaoImpl();
        return territorioImpl.getbyType(query);
    }
    
    public List<Tipo> getTipos(){
        tipoDaoImpl = new TipoDaoImpl();
        return tipoDaoImpl.findAll();
    }

    public TipoDaoImpl getTipoDaoImpl() {
        return tipoDaoImpl;
    }

    public void setTipoDaoImpl(TipoDaoImpl tipoDaoImpl) {
        this.tipoDaoImpl = tipoDaoImpl;
    }

    public List<Territorio> getList_ciudad() {
        return list_ciudad;
    }

    public void setList_ciudad(List<Territorio> list_ciudad) {
        this.list_ciudad = list_ciudad;
    }

    public Territorio getTerritorio() {
        return territorio;
    }

    public void setTerritorio(Territorio territorio) {
        this.territorio = territorio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<Sucursal> getList_sucursal() {
        return list_sucursal;
    }

    public void setList_sucursal(List<Sucursal> list_sucursal) {
        this.list_sucursal = list_sucursal;
    }

    public Sucursal getCreate_suc() {
        return create_suc;
    }

    public void setCreate_suc(Sucursal create_suc) {
        this.create_suc = create_suc;
    }
    
    public TerritorioDaoImpl getTerritorioImpl() {
        return territorioImpl;
    }

    public void setTerritorioImpl(TerritorioDaoImpl territorioImpl) {
        this.territorioImpl = territorioImpl;
    }
}
