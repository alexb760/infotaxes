
package com.infotaxes.dao;

import com.infotaxes.pojos.Tipo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class TipoDaoImpl extends GenericDaoImpl<Tipo, Integer> implements TipoDao{

    public List<Tipo> getbyName(String name) {
        List<Tipo> tipos = new ArrayList<Tipo>();
        for (Tipo tp : super.findAll()) {           
                tipos.add(tp);
        }
        return tipos;
    }
}
