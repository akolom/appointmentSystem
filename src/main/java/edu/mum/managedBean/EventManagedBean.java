/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.managedBean;

import edu.mum.bean.EventBean;
import edu.mum.domain.Event;
import edu.mum.domain.User;
import edu.mum.service.EventService;
import edu.mum.service.UserService;
import edu.mum.service.impl.EventServiceImpl;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author akolom
 */
//@Named(value = "eventManagedBean")
//@SessionScoped
@Component
@Scope("session")
public class EventManagedBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of EventManagedBean
     */
    @Inject
    private EventBean eventBean;
    @Inject
    private LoginManagedBean loginManagedBean;
    @Autowired
    private EventService eventService;
    
    @Autowired
    private UserService userService;
    
    private List<Event> eventList;
    
    private List<User> users;
    
    public EventManagedBean() {
    }
    
    @PostConstruct
    public void init() {
        eventList = eventService.findAll();
        users = userService.findAll();
    }

    public void refreshUser() {
        eventBean = new EventBean();
        users = userService.findAll();
    }

    public EventBean getEventBean() {
        return eventBean;
    }
    
    public void setEventBean(EventBean eventBean) {
        this.eventBean = eventBean;
    }
    
    public EventService getEventService() {
        return eventService;
    }
    
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
    
    public List<User> getUsers() {
        
        return userService.findAllExceptThisUserId(loginManagedBean.getUserLogin().getId());
    }
    
    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public List<Event> getEventList() {
        return eventService.findEventsByUserId(loginManagedBean.getUserLogin().getId());
    }
    
    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
    
    public String createEvent() {
        List<User> users = new ArrayList<>();
        for (String id : eventBean.getUsers()) {
            User user = userService.findUserById(Integer.parseInt(id));
            users.add(user);
        }
        Event event = new Event();
        event.setEventOwner(loginManagedBean.getUserLogin());
        event.setName(eventBean.getName());
        event.setDescription(eventBean.getDescription());
        event.setStartTime(eventBean.getStartTime());
        event.setEndTime(eventBean.getEndTime());
        for (User user : users) {
            event.addUser(user);
        }
//        Mapper mapper = new DozerBeanMapper();
        //eventBean.setStatusId(new Status(statusId));
        // eventBean.setUser(new User(uId));
//        Event event = mapper.map(eventBean, Event.class);
        
        eventService.save(event);
//        FacesMessage msg = new FacesMessage("New Event Backlog Added", event.getId().toString());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
        // }

        return "eventList.jsf";
    }
    
    public void editEvent(RowEditEvent event) throws IOException {
//        FacesMessage msg = new FacesMessage("Product Backlog Edited", ((Product) event.getObject()).getId().toString());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//        Product tempProduct = (Product) event.getObject();
//        Mapper mapper = new DozerBeanMapper();
//        productBean = mapper.map(tempProduct, ProductBean.class);
//        statusId = tempProduct.getStatusId().getId();
//        updateProductId = tempProduct.getId();
//
//        FacesContext ctx = FacesContext.getCurrentInstance();
//        NavigationHandler navigationHandler = ctx.getApplication().getNavigationHandler();
//        navigationHandler.handleNavigation(ctx, null, "productForm");
    }
    
    public void cancelEditEvent(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Product) event.getObject()).getId().toString());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
