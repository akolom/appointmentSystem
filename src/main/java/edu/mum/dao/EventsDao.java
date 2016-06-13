/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao;

import edu.mum.domain.Events;
import java.util.List;

/**
 *
 * @author HAGOS
 */
public interface EventsDao {

    


    public void save(Events event);
    public void update(Events event);
    public Events findById(Integer Id);
    public List<Events> findAll();

  

}
