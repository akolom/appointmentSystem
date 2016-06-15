/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.scheduler;

import edu.mum.domain.Event;
import edu.mum.service.EventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author sam
 */
@Component
public class ScheduleTask {

    @Autowired
    private EventService eventService;
    
    @Scheduled(fixedDelay = 15000, initialDelay = 2000)
    public void startjob() throws Exception {
        List<Event> events=eventService.findAll();
        System.out.println(String.format("We have %d events in our system now!", events.size()));
    }
}
