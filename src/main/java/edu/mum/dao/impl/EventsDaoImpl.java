/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao.impl;

import edu.mum.dao.EventsDao;
import edu.mum.domain.Event;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HAGOS
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class EventsDaoImpl extends GenericDaoImpl<Event> implements EventsDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Event findById(Integer Id) {
        return entityManager.find(Event.class, Id);
    }

    @Override
    public List<Event> findAll() {
        List<Event> events
                = entityManager.createQuery("SELECT e FROM Events e", Event.class).getResultList();
        return events;
    }
      @Override
    public void save(Event events) {
        entityManager.persist(events);
    }

}
