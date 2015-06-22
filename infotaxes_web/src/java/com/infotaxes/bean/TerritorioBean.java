
package com.infotaxes.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.infotaxes.dao.TerritorioDaoImpl;
import com.infotaxes.pojos.Territorio;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TerritorioBean {

    @ManagedProperty("#{territorioImpl}")
    private Territorio territorio;
    private TerritorioDaoImpl territorioImpl;
    
    public TerritorioBean() {
    }

    public List<Territorio> getCiudad(String Query){
        territorioImpl = new TerritorioDaoImpl();
        return territorioImpl.getbyName(Query);
        
    }
    
    public Territorio getTerritorio() {
        return territorio;
    }

    public void setTerritorio(Territorio territorio) {
        this.territorio = territorio;
    }

    public TerritorioDaoImpl getTerritorioImpl() {
        return territorioImpl;
    }

    public void setTerritorioImpl(TerritorioDaoImpl territorioImpl) {
        this.territorioImpl = territorioImpl;
    }
   
    
}
