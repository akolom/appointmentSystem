/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.domain;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author akolom
 */
@Entity
public class Events {

    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty(message = "{NotEmpty}")
    private String name;

    private Date startTime;
    private Date endTime;

    private Date duration;

    private String description;

    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER)
    private List<User> user;
    
    @OneToMany(mappedBy="event" , cascade=CascadeType.ALL)
    private List<EventRegister>  eventDetails;

    public List<EventRegister> getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(List<EventRegister> eventDetails) {
        this.eventDetails = eventDetails;
    }
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
