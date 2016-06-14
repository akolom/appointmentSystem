/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.managedBean;

import edu.mum.bean.RegisterBean;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author mewael
 */
@Named(value = "registerManagedBean")
@Dependent
public class RegisterManagedBean {

    /**
     * Creates a new instance of RegisterManagedBean
     */
    @Inject
    private RegisterBean registerBean;

    public RegisterBean getRegisterBean() {
        return registerBean;
    }

    public void setRegisterBean(RegisterBean registerBean) {
        this.registerBean = registerBean;
    }
    
    
    public RegisterManagedBean() {
    }
    public String regisgerEvent(){
        return "registerEvent.jsf";
    }
    
}
