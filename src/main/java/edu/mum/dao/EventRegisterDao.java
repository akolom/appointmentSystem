/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao;

import edu.mum.domain.Event;
import edu.mum.domain.EventRegister;
import java.util.List;

/**
 *
 * @author HAGOS
 */
public interface EventRegisterDao extends GenericDao<EventRegister>{
    public List<EventRegister> getEventRegisterByUserId(int id);
    public List<EventRegister> getNotSelectedEventRegisterByEventId(int eventId);
}
