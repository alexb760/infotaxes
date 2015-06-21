
package com.infotaxes.dao;

import com.infotaxes.pojos.Usuario;
import java.io.Serializable;
import org.hibernate.Query;
import org.hibernate.Session;


public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao{
       
    public Usuario queryBylogin(Session session, String login, String mail) throws Exception{
        Usuario usuario = new Usuario();
        String hql = "from Usuario where (login = :lg or correo = :mail)";
        Query query = session.createQuery(hql);
        query.setParameter("lg", login);
        query.setParameter("mail", mail);
        return usuario = (Usuario) query.uniqueResult();
    }
}
