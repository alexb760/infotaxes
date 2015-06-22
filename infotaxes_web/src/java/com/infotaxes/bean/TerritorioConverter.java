
package com.infotaxes.bean;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


import com.infotaxes.dao.TerritorioDaoImpl;
import com.infotaxes.pojos.Territorio;

/**
 *
 * @author Alexander Bravo
 */
@FacesConverter(value="TerritorioConverter")
public class TerritorioConverter implements Converter{

    private TerritorioDaoImpl territorioImpl;
    private Territorio territorio;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
                if (value.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(value);
                territorioImpl = new TerritorioDaoImpl();
                return territorioImpl.findById(number);

            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Ciudad No valida"));
            }
        }
    }
       
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
     if (value == null || value.equals("")) {
            return "";
        } else {
            if(value instanceof Territorio){
			Territorio ci = (Territorio)value;
			return String.valueOf(ci.getId());
		}
		return "";
        }    
    }   
}
