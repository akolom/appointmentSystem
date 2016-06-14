/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.managedBean;

import edu.mum.bean.UserBean;
import edu.mum.dao.UserDao;
import edu.mum.dao.impl.UserDaoImpl;
import edu.mum.domain.User;
import edu.mum.service.UserService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    User user = new User();

    @Inject
    private UserBean userBean;
    @Autowired
    private UserService userService;

    /**
     * Creates a new instance of UserMangedBean
     */
    public UserMangedBean() {
    }

    public String addUser() {
        //user=new User(1,user.getFirstName(),user.getLastName(),user.getEmail());
        userService.save(user);
        //users.add(user);
        return "welcome.jsf";
    }
}
