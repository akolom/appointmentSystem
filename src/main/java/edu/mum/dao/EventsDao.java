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
public interface EventsDao extends GenericDao<Event>{

    public Event findById(Integer Id);

  

}
