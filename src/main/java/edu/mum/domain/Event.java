/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author akolom
 */
@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty(message = "{NotEmpty}")
    private String name;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date endTime;

    private int duration;

    private String description;
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User eventOwner;
    

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<EventRegister> eventDetails = new ArrayList<>();

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getEventOwner() {
        return eventOwner;
    }

    public void setEventOwner(User eventOwner) {
        this.eventOwner = eventOwner;
    }
    
    

    public String formatStartDate() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm a").format(startTime);
    }

    public String formatDueDate() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm a").format(endTime);
    }

    public void addUser(User user) {
        this.users.add(user);
        user.getEvents().add(this);
    }
}
