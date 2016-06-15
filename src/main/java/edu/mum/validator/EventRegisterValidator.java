/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.validator;

import edu.mum.domain.EventRegister;
import edu.mum.managedBean.DurationManagedBean;
import edu.mum.service.EventRegisterService;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author akolom
 */
@Named(value = "eventRegisterValidator")
@RequestScoped
public class EventRegisterValidator implements Validator {

    @Inject
    private EventRegisterService eventRegisterService;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        EventRegister eventRegister = eventRegisterService.findOne((int) value);
        if (eventRegister.getUser() != null) {
            FacesMessage msg
                    = new FacesMessage("The selected time has been taken! Please refresh your page!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}
