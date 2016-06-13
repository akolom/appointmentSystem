/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao;

import edu.mum.domain.Event;
import java.util.List;

/**
 *
 * @author HAGOS
 */
public interface EventsDao {

    

public List<Event> findAll();
    public void save(Event event);
    public void update(Event event);
    public Event findById(Integer Id);
  //  public List<Event> findAll();

  

}
