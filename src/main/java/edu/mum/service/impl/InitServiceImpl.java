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
import edu.mum.service.AuthorityService;
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
    
    @Autowired
    AuthorityService authorityService;

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
        authorityService.save(authority);

        Authority authority1 = new Authority();
        authority1.setName("Admin");
        authority.setRole("ROLE_ADMIN");
        authorityService.save(authority1);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Credentials credentials = new Credentials();
        credentials.setUsername("user");
        credentials.setPassword("user");
        credentials.setAuthority(authority);
        credentials.setEnabled(true);

        Credentials credentials1 = new Credentials();
        credentials1.setUsername("admin");
        credentials1.setPassword("admin");
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
        user1.setFirstName("Chi");
        user1.setLastName("Dov");
        user1.setEmail("jobs@gmail.com");
        user1.setContact("9898989898");
        user1.setCredentials(credentials1);
        userService.save(user1);
        
        Credentials credentials2 = new Credentials();
        credentials2.setUsername("hagos");
        credentials2.setPassword("123");
        credentials2.setAuthority(authority);
        credentials2.setEnabled(true);
        
        User user2 = new User();
        user2.setFirstName("Hagos");
        user2.setLastName("Dov");
        user2.setEmail("jobs@gmail.com");
        user2.setContact("9898989898");
        user2.setCredentials(credentials2);
        userService.save(user2);

        Credentials credentials3 = new Credentials();
        credentials3.setUsername("mewael");
        credentials3.setPassword("123");
        credentials3.setAuthority(authority);
        credentials3.setEnabled(true);
        
        User user3 = new User();
        user3.setFirstName("Mewael");
        user3.setLastName("Zere");
        user3.setEmail("jobs@gmail.com");
        user3.setContact("9898989898");
        user3.setCredentials(credentials3);
        userService.save(user3);
    }
}
