/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao.impl;

import edu.mum.dao.EventRegisterDao;
import edu.mum.dao.EventsDao;
import edu.mum.domain.Event;
import edu.mum.domain.EventRegister;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HAGOS
 */
@Repository
public class EventDaoRegisterImpl extends GenericDaoImpl<EventRegister> implements EventRegisterDao {

    public EventDaoRegisterImpl() {
        super.setDaoType(EventRegister.class);
    }

    
    @Override
    public List<EventRegister> getEventRegisterByUserId(int id) {
        Query query=this.entityManager.createQuery("SELECT er from EventRegister er where er.user.id=:id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<EventRegister> getNotSelectedEventRegisterByEventId(int eventId) {
        Query query=this.entityManager.createQuery
        ("SELECT er from EventRegister er where er.event.id=:id and er.user=null");
        query.setParameter("id", eventId);
        return query.getResultList();
    }
}
