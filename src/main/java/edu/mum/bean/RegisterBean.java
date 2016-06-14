/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.bean;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author mewael
 */
@Named("registerBean")
@RequestScoped
public class RegisterBean {
    
    @NotNull(message = "{eventbean_name_notempty}")
    @NotEmpty(message = "{eventbean_name_notempty}")
    private int id;
    
    @NotNull(message = "{eventbean_startdate_notnull}")
    @Future(message = "{eventbean_startdate_future}")
    private Date startTime;
   
    @NotNull(message = "{eventbean_enddate_notnull}")
    @Future(message = "{eventbean_endtdate_future}")
    private Date endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    
}
