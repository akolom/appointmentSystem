/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao.impl;

import edu.mum.dao.EventsDao;
import edu.mum.domain.Event;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HAGOS
 */
@Repository
public class EventsDaoImpl extends GenericDaoImpl<Event> implements EventsDao {

    public EventsDaoImpl() {
        super.setDaoType(Event.class);
    }
    @Override
    public Event findById(Integer Id) {
        return entityManager.find(Event.class, Id);
    }

     

}
