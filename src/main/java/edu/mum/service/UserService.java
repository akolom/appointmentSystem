/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service;


import edu.mum.domain.User;
import java.util.List;

/**
 *
 * @author akolom
 */
public interface UserService {
    
    
    public void save(User user);

	public List<User> findAll();

	public void update(User user);

//	public User findOneByUsername(String userName);
//
        public User findUserById(Integer id);

	

//	public void removeEventsFromUser(User u, Events events);
//
//	
//
//	public void saveUserInEvents(Events Events, User user);

	

    
}
