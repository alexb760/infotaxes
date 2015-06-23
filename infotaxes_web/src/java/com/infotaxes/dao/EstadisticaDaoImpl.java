
package com.infotaxes.dao;

import com.infotaxes.pojos.Estadistica;
import com.infotaxes.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;


public class EstadisticaDaoImpl extends GenericDaoImpl<Estadistica, Integer> implements EstadisticaDao{
    
    public List<?> Cargar() {
        Query q;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();

            q = session.createQuery("Select Sucursal.id, avg(est.valor), "
                    + "Sucursal.nombre, Sucursal.direccion, Sucursal.telefono, "
                    + "Sucursal.correo, Sucursal.descripcion\n"
                    + "from Estadistica as est\n"
                    + "inner join est.sucursal as Sucursal\n"
                    + "group by est.sucursal\n"
                    + "order by avg(est.valor) desc");

            tx.commit();
        } catch (HibernateException e) {
            //list = null;
            tx.rollback();
            throw e;
        }

        return q.list();
    }

    public List<?> CargarDetalle(int idSucursal) {
        Query q;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();

            q = session.createQuery("Select Servicio.id, avg(est.valor), \n"
                    + "Servicio.descripcion, est.comentario, \n"
                    + "Servicio.valor From Estadistica as est\n"
                    + "inner join est.servicio as Servicio\n"
                    + "Where est.sucursal = " + idSucursal + "\n"
                    + "group by est.servicio");

            tx.commit();
        } catch (HibernateException e) {
            //list = null;
            tx.rollback();
            throw e;
        }

        return q.list();
    }
}
