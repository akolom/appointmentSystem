/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service.impl;

import edu.mum.dao.EventsDao;
import edu.mum.domain.Event;
import edu.mum.service.EventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author akolom
 */
@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventsDao eventsDao;

    @Override
    public List<Event> findAll() {

        return eventsDao.findAll();
    }

    @Override
    public void save(Event event) {
        eventsDao.save(event);

    }

//    @Override
//    public List<Events> findAllByUser(User user) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Events findById(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    @Override
//    public List<Events> findAllAppliedEvents(Integer userId) {
//        List<Integer> eventId = eventsDao.findAllEventIdByUserId(userId);
//        List<Events> events = new ArrayList<>();
//        if (eventId == null || eventId.isEmpty()) {
//
//            return events;
//        }
//
//        for (Integer eId : eventId) {
//
//            events.add(eventsDao.findById(eId));
//
//        }
//        return events;
//    }
//
//    @Override
//    public List<Events> findAllNotAppliedEvents(String key, Integer userId) {
//
//        List<Integer> ids = eventsDao.findAllNotAppliedEvents(userId);
//        List<Events> events = new ArrayList<>();
//        if (ids == null || ids.isEmpty()) {
//            System.out.println("null return --> findall");
//            return events;
//        }
//        return eventsDao.findByDescriptionByNotApplied(ids, key);
//    }


    

    @Override
    public void update(Event event) {
eventsDao.save(event);
    }

   

   

}
