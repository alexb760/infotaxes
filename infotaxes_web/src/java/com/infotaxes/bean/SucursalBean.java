/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotaxes.bean;

import com.infotaxes.dao.SucursalDaoImpl;
import com.infotaxes.pojos.Sucursal;
import com.infotaxes.pojos.Territorio;
import com.infotaxes.pojos.Tipo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "sucursalBean")
@RequestScoped
public class SucursalBean {
    
    public Sucursal sucursal;
    public List<Sucursal> list_sucursal;
    
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
    
    
}
