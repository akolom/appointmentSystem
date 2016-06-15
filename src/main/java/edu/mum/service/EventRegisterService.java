/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service;

import edu.mum.domain.EventRegister;
import java.util.List;

/**
 *
 * @author HAGOS
 */
public interface EventRegisterService {
    public EventRegister findOne(int id);
    
    public List<EventRegister> getEventRegisterByUserId(int id);
    public List<EventRegister> getNotSelectedEventRegisterByEventId(int eventId);
    
    public void update(EventRegister event);
}
