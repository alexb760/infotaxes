
package com.infotaxes.dao;

import com.infotaxes.pojos.Servicio;
import com.infotaxes.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;


public class ServicioDaoImpl extends GenericDaoImpl<Servicio, Integer> implements ServicioDao{
    
    public List<?> CargarServicios() {
        Query q;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();

            q = session.createQuery("select ser.id, ser.descripcion, ser.valor from Servicio as ser" );

            tx.commit();
        } catch (HibernateException e) {
            //list = null;
            tx.rollback();
            throw e;
        }

        return q.list();
    }
    
}
