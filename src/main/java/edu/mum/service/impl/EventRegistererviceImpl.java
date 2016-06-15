/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service.impl;

import edu.mum.dao.EventRegisterDao;
import edu.mum.domain.EventRegister;
import edu.mum.service.EventRegisterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HAGOS
 */
@Service
@Transactional
public class EventRegistererviceImpl implements EventRegisterService {

    @Autowired
    private EventRegisterDao eventRegisterDao;

    @Override
    public EventRegister findOne(int id) {
        return eventRegisterDao.findOne(id);
    }

    @Override
    public List<EventRegister> getEventRegisterByUserId(int id) {

        return eventRegisterDao.getEventRegisterByUserId(id);
    }

    @Override
    public void update(EventRegister eventRegister) {
        eventRegisterDao.update(eventRegister);

    }

    @Override
    public List<EventRegister> getNotSelectedEventRegisterByEventId(int eventId) {
        return eventRegisterDao.getNotSelectedEventRegisterByEventId(eventId);
    }

}
