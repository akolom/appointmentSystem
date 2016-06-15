/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.managedBean;

import edu.mum.bean.RegisterBean;
import edu.mum.domain.Event;
import edu.mum.domain.EventRegister;
import edu.mum.service.EventRegisterService;
import edu.mum.service.EventService;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author mewael
 */
//@Named(value = "registerManagedBean")
//@SessionScoped
@Component
@Scope("session")
public class RegisterManagedBean implements Serializable {

    @Inject
    private RegisterBean registerBean;

    @Inject
    private LoginManagedBean loginManagedBean;

    @Autowired
    private EventService eventService;

    @Autowired
    private EventRegisterService eventRegisterService;

    private Event event;
    private int eventRegisteredId;

    public int getEventRegisteredId() {
        return eventRegisteredId;
    }

    public void setEventRegisteredId(int eventRegisteredId) {
        this.eventRegisteredId = eventRegisteredId;
    }

    public Event getEvent() {
        return event;
    }

    public List<EventRegister> getEventDetails() {
        return eventRegisterService.getNotSelectedEventRegisterByEventId(this.event.getId());
    }

    public RegisterBean getRegisterBean() {
        return registerBean;
    }

    public void setRegisterBean(RegisterBean registerBean) {
        this.registerBean = registerBean;
    }

    public RegisterManagedBean() {
    }

    public List<Event> eventInvitations() {

        return eventService.findInvitedEventsByUserId(
                loginManagedBean.getUserLogin().getId());
        // return "registerEvent.jsf";
    }

    public String registerForEvent(Event event) {

        this.event = event;
        //Event eventForRegester = event.
        return "registerPage?faces-redirect=true";
    }

    public String registeredForTheEvent() {
        EventRegister eventRegister = eventRegisterService.findOne(eventRegisteredId);
        if (eventRegister.getUser() != null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage msg
                    = new FacesMessage("The selected time has been taken! Please refresh your page!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc.addMessage(null, msg);
            fc.renderResponse();
        }
        eventRegister.setUser(loginManagedBean.getUserLogin());
        eventRegisterService.update(eventRegister);
        return "myRegisteredEvent?faces-redirect=true";
    }

    public List<EventRegister> listOfEventRegistered() {
        return eventRegisterService.getEventRegisterByUserId(loginManagedBean.getUserLogin().getId());
    }

}
