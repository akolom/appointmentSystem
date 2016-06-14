/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.converter;

import edu.mum.domain.User;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author akolom
 */
@FacesConverter("userConverter")
public class CustomUserConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        User user=new User();
        int id=Integer.parseInt(value);
        user.setId(id);
        return user;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        User user= (User) value;
        return user.getFirstName()+" "+user.getLastName();
    }
    
}
