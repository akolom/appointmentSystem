/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service.impl;

/**
 *
 * @author akolom
 */
import edu.mum.domain.Authority;
import edu.mum.domain.Credentials;
import edu.mum.domain.User;
import edu.mum.service.UserService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author KESHAV
 *
 * Service class to initialize data in database.
 *
 */
@Service
@Transactional
public class InitServiceImpl {

    @Autowired
    UserService userService;

    /**
     * This method executes after finishing dependency injections and invoked
     * before any class is put into service.
     *
     * This mehtod consist of many persistence level operations to save initial
     * data to databse.
     */
    @PostConstruct
    public void init() {

        Authority authority = new Authority();
        authority.setName("User");
        authority.setRole("ROLE_USER");

        Authority authority1 = new Authority();
        authority1.setName("Admin");
        authority1.setRole("ROLE_ADMIN");

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Credentials credentials = new Credentials();
        credentials.setUserName("user");
        credentials.setPassword(encoder.encode("user"));
        credentials.setAuthority(authority);
        credentials.setEnabled(true);

        Credentials credentials1 = new Credentials();
        credentials1.setUserName("admin");
        credentials1.setPassword(encoder.encode("admin"));
        credentials1.setAuthority(authority1);
        credentials1.setEnabled(true);

        User user = new User();
        user.setFirstName("Akolom");
        user.setLastName("Gebrezgabhier");
        user.setEmail("akolom.g2013@gmail.com");

        user.setCredentials(credentials);
        user.setContact("9898989889");

        userService.save(user);

        User user1 = new User();
        user1.setFirstName("steve");
        user1.setLastName("jobs");
        user1.setEmail("jobs@gmail.com");
        user1.setContact("9898989898");
        user1.setCredentials(credentials1);

        userService.save(user1);

    }
}
