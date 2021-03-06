/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service;

import edu.mum.domain.Event;

import java.util.List;

/**
 *
 * @author akolom
 */
public interface EventService {


    public List<Event> findAll();
    public void update(Event event);
    public void save(Event event);
  public List<Event> findEventsByUserId(int userId);
  public List<Event> findInvitedEventsByUserId(int userId);
}
