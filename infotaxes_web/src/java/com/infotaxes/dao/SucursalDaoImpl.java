package com.infotaxes.dao;

import com.infotaxes.pojos.Sucursal;
import com.infotaxes.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class SucursalDaoImpl extends GenericDaoImpl<Sucursal, Integer> implements SucursalDao {

    public List<?> CargarSucursales() {
        Query q;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();

            q = session.createQuery("select suc.id, suc.nombre, suc.direccion, suc.telefono, suc.correo, "
                    + "suc.tipo.nombre, suc.territorio.nombre from Sucursal as suc" );

            tx.commit();
        } catch (HibernateException e) {
            //list = null;
            tx.rollback();
            throw e;
        }

        return q.list();
    }

}
