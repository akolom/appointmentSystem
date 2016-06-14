/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.managedBean;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author akolom
 */
@Named(value = "durationManagedBean")
@ApplicationScoped
public class DurationManagedBean {

    private int UIDuration;
    private int duration;

    public int getDuration() {
        return duration;
    }

    /**
     * Creates a new instance of DurationManagedBean
     */
    @PostConstruct
    public void init() {
        this.duration = 30;
        this.UIDuration = 30;
    }

    public int getUIDuration() {
        return UIDuration;
    }

    public void setUIDuration(int UIDuration) {
        this.UIDuration = UIDuration;
    }

    public DurationManagedBean() {
    }

    public String changeDuration() {
        this.duration = UIDuration;
        return "admin.jsf";
    }
}
