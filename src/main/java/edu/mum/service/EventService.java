/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service;

import edu.mum.domain.Events;
import edu.mum.domain.User;
import java.util.List;

/**
 *
 * @author akolom
 */
public interface EventService {
    
    public List<Events> findByDescription(String description);

	public List<Events> findAll(Integer userId);

	void saveEvent(Events event);

//	List<Events> findAllByUser(User user);
//
//	Events findById(Integer id);

	List<Events> findAllAppliedEvents(Integer userId);

	List<Events> findAllNotAppliedEvents(String key, Integer userId);

	

//	public Events getEventsById(Integer eventId);

	public void updateEvent(Events event);

    
}
