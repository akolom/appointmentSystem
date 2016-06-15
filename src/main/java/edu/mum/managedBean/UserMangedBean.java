/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.managedBean;

import edu.mum.bean.UserBean;
import edu.mum.domain.Authority;
import edu.mum.domain.Credentials;
import edu.mum.domain.User;
import edu.mum.service.AuthorityService;
import edu.mum.service.UserService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author matt
 */
@Named(value = "userMangedBean")
@SessionScoped
@Component
public class UserMangedBean implements Serializable {

    @Inject
    private UserBean userBean;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;
    

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    /**
     * Creates a new instance of UserMangedBean
     */
    public UserMangedBean() {
    }

    public String addUser() {
        Authority authority=authorityService.findOneByName("User");
        Credentials credentials=new Credentials();
        credentials.setUsername(userBean.getUsername());
        credentials.setPassword(userBean.getPasword());
        credentials.setAuthority(authority);
        
        User user=new User();
        user.setFirstName(userBean.getFirstName());
        user.setLastName(userBean.getLastName());
        user.setContact(userBean.getContact());
        user.setEmail(userBean.getEmail());
        user.setCredentials(credentials);

        userService.save(user);
        
        return "welcome";
    }
}
