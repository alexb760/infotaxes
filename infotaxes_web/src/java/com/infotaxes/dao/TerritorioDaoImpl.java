/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotaxes.dao;

import com.infotaxes.pojos.Territorio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class TerritorioDaoImpl extends GenericDaoImpl<Territorio, Integer> implements TerritorioDao{
 
        public List<Territorio> getbyName(String name){
        List<Territorio> ciudad = new ArrayList<Territorio>();
        for(Territorio ci : super.findAll()){
            if(ci.getNombre().toLowerCase().startsWith(name.toLowerCase()))
                ciudad.add(ci);
        }
        return ciudad;
    }
    
}
