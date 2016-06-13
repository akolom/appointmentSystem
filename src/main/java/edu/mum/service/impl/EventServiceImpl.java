/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service.impl;

import edu.mum.domain.Event;
import edu.mum.service.EventService;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author akolom
 */
public class EventServiceImpl implements EventService{

    @PersistenceContext
    protected EntityManager entityManager;

   
   
  
    public void save( Event entity ){
        entityManager.persist( entity );
     }


    @Override
    public List<Event> listEvent() {
return null;   }

    @Override
    public void createEvent(Event event) {
          save(event);  
    
    }
    
}
