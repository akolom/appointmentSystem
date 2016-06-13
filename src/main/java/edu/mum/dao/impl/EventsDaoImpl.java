/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao.impl;

import edu.mum.dao.EventsDao;
import edu.mum.domain.Events;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HAGOS
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class EventsDaoImpl extends GenericDaoImpl<Events> implements EventsDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Events findById(Integer Id) {
        return entityManager.find(Events.class, Id);
    }

    @Override
    public List<Events> findAll() {
        List<Events> events
                = entityManager.createQuery("SELECT e FROM Events e", Events.class).getResultList();
        return events;
    }
      @Override
    public void save(Events events) {
        entityManager.persist(events);
    }

}
