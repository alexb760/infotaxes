
package com.infotaxes.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.infotaxes.dao.UsuarioDaoImpl;
import com.infotaxes.pojos.Usuario;
import com.infotaxes.pojos.Territorio;
import com.infotaxes.util.Fantasma;
import com.infotaxes.dao.TerritorioDaoImpl;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alexander Bravo
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

   private Usuario usuario;

   @ManagedProperty("#{territorioImpl}")
   private Territorio territorio;
   private TerritorioDaoImpl territorioImpl;
    
    public UsuarioBean() {
        usuario = new Usuario();
    }
    
    public void guardar() throws Exception{
        Fantasma ghost = new Fantasma();
        UsuarioDaoImpl usuarioImpl = new UsuarioDaoImpl();
        usuario.setRol("Usuario");
        usuario.setClave(ghost.getStringMessageDigest(usuario.getClave(), ghost.getMD5()));
        usuarioImpl.create(usuario);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido a la Comunidad: ", this.usuario.getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public List<Territorio> getCiudad(String Query){
        territorioImpl = new TerritorioDaoImpl();
        return territorioImpl.getbyName(Query);
        
    }
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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