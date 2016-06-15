/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service.impl;

import edu.mum.dao.EventsDao;
import edu.mum.domain.Event;
import edu.mum.domain.EventRegister;
import edu.mum.managedBean.DurationManagedBean;
import edu.mum.service.EventService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
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

    @Inject
    private DurationManagedBean durationManagedBean;
    @Override
    public List<Event> findAll() {

        return eventsDao.findAll();
    }

    @Override
    public void save(Event event) {
        List<EventRegister> eventRegisters=new ArrayList<>();
        long duration = event.getEndTime().getTime() - event.getStartTime().getTime();
        long diffInMins = TimeUnit.MILLISECONDS.toMinutes(duration);
        int defaultDuration=durationManagedBean.getDuration();
        int slot = (int) (diffInMins / defaultDuration);
        Date date = event.getStartTime();
        for (int i = 0; i < slot; i++) {
            EventRegister eventRegister=new EventRegister();
            eventRegister.setStartTime(date);
            date=addMinutesToDate(defaultDuration, date);
            eventRegister.setEndTime(date);
            eventRegister.setEvent(event);
            eventRegisters.add(eventRegister);
        }
        event.setEventDetails(eventRegisters);
        eventsDao.update(event);

    }

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

    @Override
    public List<Event> findEventsByUserId(int userId) {
        
        return eventsDao.findEventsByUserId(userId);
    }

    @Override
    public List<Event> findInvitedEventsByUserId(int userId) {
        return eventsDao.findInvitedEventsByUserId(userId);
    }
}
