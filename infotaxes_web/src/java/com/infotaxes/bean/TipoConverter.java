/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotaxes.bean;

import com.infotaxes.dao.TipoDaoImpl;
import com.infotaxes.pojos.Tipo;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mikillo
 */

@FacesConverter(value="TipoConverter")
public class TipoConverter implements Converter {

    private TipoDaoImpl tipoImpl;
    private Tipo tipo;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
                if (value.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(value);
                tipoImpl = new TipoDaoImpl();
                return tipoImpl.findById(number);

            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Tipo No valido"));
            }
        }
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
     if (value == null || value.equals("")) {
            return "";
        } else {
            if(value instanceof Tipo){
			Tipo tp = (Tipo)value;
			return String.valueOf(tp.getId());
		}
		return "";
        }    
    } 
   
    
}
