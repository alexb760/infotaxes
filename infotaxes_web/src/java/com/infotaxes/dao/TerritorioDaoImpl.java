/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotaxes.dao;

import com.infotaxes.pojos.Territorio;
import com.infotaxes.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author usuario
 */
public class TerritorioDaoImpl extends GenericDaoImpl<Territorio, Integer> implements TerritorioDao {

    public List<Territorio> getbyName(String name) {
        List<Territorio> ciudad = new ArrayList<Territorio>();
        for (Territorio ci : super.findAll()) {
            if (ci.getNombre().toLowerCase().startsWith(name.toLowerCase())) {
                ciudad.add(ci);
            }
        }
        return ciudad;
    }

    /**
     * Metodo para realizar la consulta de territorios por tipo
     *
     * @param name
     * @return
     */
    public List<Territorio> getbyType(String name) {
//        Query q;
//        List<Territorio> ciudad = new ArrayList<Territorio>();
//         try {
//            session = HibernateUtil.getSession();
//            tx = session.beginTransaction();
//
//            q = session.createQuery("select ter.id, ter.nombre from Territorio as ter where ter.tipo='C' " );
//
//            tx.commit();
//        } catch (HibernateException e) {
//            //list = null;
//            tx.rollback();
//            throw e;
//        }
//     
//        return q.list();
        
        List<Territorio> ciudad = new ArrayList<Territorio>();
        for (Territorio ci : super.findAll()) {
            if (ci.getNombre().toLowerCase().startsWith(name.toLowerCase()) && ci.getTipo().equalsIgnoreCase("C")) {
                ciudad.add(ci);
            }
        }
        return ciudad;
    }

}
