/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service.impl;

import edu.mum.dao.EventsDao;
import edu.mum.domain.Event;
import edu.mum.domain.EventRegister;
import edu.mum.service.EventService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
        List<EventRegister> eventRegisters=new ArrayList<>();
        long duration = event.getEndTime().getTime() - event.getStartTime().getTime();
        long diffInMins = TimeUnit.MILLISECONDS.toMinutes(duration);
        int slot = (int) (diffInMins / 30);
        Date date = event.getStartTime();
        for (int i = 0; i < slot; i++) {
            EventRegister eventRegister=new EventRegister();
            eventRegister.setStartTime(date);
            date=addMinutesToDate(30, date);
            eventRegister.setEndTime(date);
            eventRegister.setEvent(event);
            eventRegisters.add(eventRegister);
        }
        event.setEventDetails(eventRegisters);
        eventsDao.update(event);

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
        eventsDao.update(event);
    }

    /*
*  Convenience method to add a specified number of minutes to a Date object
*  From: http://stackoverflow.com/questions/9043981/how-to-add-minutes-to-my-date
*  @param  minutes  The number of minutes to add
*  @param  beforeTime  The time that will have minutes added to it
*  @return  A date object with the specified number of minutes added to it 
     */
    private static Date addMinutesToDate(int minutes, Date beforeTime) {
        final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

        long curTimeInMs = beforeTime.getTime();
        Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
        return afterAddingMins;
    }
}
