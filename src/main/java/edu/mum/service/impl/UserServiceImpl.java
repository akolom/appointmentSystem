/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service.impl;

import edu.mum.dao.UserDao;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import java.util.List;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HAGOS
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.getCredentials().setEnabled(true);
        user.getCredentials().setPassword(encoder.encode(user.getCredentials().getPassword()));
        String authorityName = user.getCredentials().getAuthority().getName();
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setCredentials(user.getCredentials());
        userDao.save(user);

    }

    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }

    
    

    @Override
    public void update(User user) {

        try {
             userDao.save(user);
        } catch (StaleObjectStateException e) {
            System.out.println(e);
           // return null;
        }

    }

   

    @Override
    public User findUserById(Integer id) {
        User user = userDao.findUserById(id);
        //user.getCredentials();
        return user;
    }

    



    
}
