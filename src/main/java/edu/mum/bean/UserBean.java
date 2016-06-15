/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author matt
 */
@Named("userBean")
@RequestScoped
public class UserBean {
    @NotEmpty(message = "{userbean_email_notempty}")
    @Email(message = "{userbean_email_notempty}")
    private String email;
    @NotNull(message = "{userbean_firstname_notempty}")
    @NotEmpty(message = "{userbean_firstname_notempty}")
    private String firstName;
    @NotNull(message = "{userbean_lastname_notempty}")
    @NotEmpty(message = "{userbean_lastname_notempty}")
    private String lastName;

    private String contact;
    
    private boolean status;
    @NotEmpty(message = "{userbean_username_error}")
     @Size(min=2, max=30,message = "{userbean_username_error}")
    private String username;
        @NotEmpty(message = "{userbean_password_error}")
      @Size(min=4, max=30,message = "{userbean_password_error}")
    private String pasword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
