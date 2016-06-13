/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.managedBean;

import edu.mum.bean.EventBean;
import edu.mum.domain.Event;
import edu.mum.service.EventService;
import edu.mum.service.impl.EventServiceImpl;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.primefaces.event.RowEditEvent;


/**
 *
 * @author akolom
 */
@Named(value = "eventManagedBean")
@ConversationScoped
public class EventManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of EventManagedBean
     */
    @Inject
    private EventBean eventBean;
    
   // @Inject
    private EventService eventService= new EventServiceImpl();
    
    private List<Event> eventList;
    public EventManagedBean() {
    }
    
    @PostConstruct
    public void init() {
        eventList = eventService.listEvent();
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

    public List<Event> getEventList() {
        return eventService.listEvent();
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
    
     public String createEvent() {

        int uId = Integer.valueOf(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("userId"));

        Mapper mapper = new DozerBeanMapper();
        //eventBean.setStatusId(new Status(statusId));
       // eventBean.setUser(new User(uId));
        Event event = mapper.map(eventBean, Event.class);
       // product.setId(updateProductId);

//        if (updateProductId > 0) {
//            productService.updateProduct(product);
//            FacesMessage msg = new FacesMessage("Product Backlog Updated", String.valueOf(updateProductId));
//            FacesContext.getCurrentInstance().addMessage(null, msg);
        //} else {
            eventService.createEvent(event);
            FacesMessage msg = new FacesMessage("New Event Backlog Added", event.getId().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
       // }

        return "eventList.faces";
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
