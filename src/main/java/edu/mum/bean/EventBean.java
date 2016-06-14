/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.bean;

import edu.mum.domain.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author akolom
 */

@Named("eventBean")
@RequestScoped
public class EventBean {
    
    
//     private User employeeId;
//    private Status statusId;

    @NotNull(message = "{eventbean_name_notempty}")
    @NotEmpty(message = "{eventbean_name_notempty}")
    private String name;

    @NotNull(message = "{eventbean_startdate_notnull}")
    @Future(message = "{eventbean_startdate_future}")
    private Date startTime;

    @NotNull(message = "{eventbean_enddate_notnull}")
    @Future(message = "{eventbean_endtdate_future}")
    private Date endTime;
    
    private int duration;

    private String description;
    private List<String> users=new ArrayList<>();

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

   
    
    
    
}
