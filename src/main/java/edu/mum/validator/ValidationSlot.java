/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.validator;

import edu.mum.managedBean.DurationManagedBean;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author akolom
 */
@Named(value = "eventNameValidator")
@RequestScoped
public class ValidationSlot {

    
    @Inject
    private DurationManagedBean durationManagedBean;
    public void validate(ComponentSystemEvent event)  {
        FacesContext fc = FacesContext.getCurrentInstance();
        UIComponent components = event.getComponent();

        UIInput uiInputStartDate = (UIInput) components.findComponent("startDate");
        Date startDate = (Date) uiInputStartDate.getLocalValue();
        UIInput uiInputEndDate = (UIInput) components.findComponent("endDate");
        String endDateID=uiInputEndDate.getClientId();
        Date endDate = (Date) uiInputEndDate.getLocalValue();

        if (startDate != null && endDate != null) {
            Long duration = endDate.getTime() - startDate.getTime();
            long diffInMins = TimeUnit.MILLISECONDS.toMinutes(duration);
            //start date and end date must be in 24 hour
            if(diffInMins>1440){
                FacesMessage msg
                        = new FacesMessage("Start date and End date must be in 24 hour!");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                fc.addMessage(endDateID, msg);
                fc.renderResponse();
            }
           // String defaultDuration = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("defaultSlot");
            int defaultDurationInt = durationManagedBean.getDuration();
            //long defaultDurationMin = durationManagedBean.getDuration();
            //TimeUnit.MILLISECONDS.toMinutes(defaultDurationInt);

            if (diffInMins < defaultDurationInt) {
                FacesMessage msg
                        = new FacesMessage("Minimum Duration Slot validation failed.");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                fc.addMessage(endDateID, msg);
                fc.renderResponse();
            }
        }
    }

}
