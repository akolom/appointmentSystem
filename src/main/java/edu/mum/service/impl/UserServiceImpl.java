/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service.impl;

import edu.mum.domain.Events;
import edu.mum.domain.User;
import edu.mum.repository.UserRepository;
import edu.mum.service.UserService;
import java.util.List;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author akolom
 */

@Service
@Transactional
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    

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
			userRepository.save(user);
			
		
		
    }

    @Override
    public List<User> findAll() {

return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
return userRepository.findOneByEmail(email);
    }

    @Override
    public User update(User user) {
        
        try{
         return userRepository.save(user);     
        }
        catch (StaleObjectStateException e) {
			System.out.println(e);
			return null;
		}

    
    }

    @Override
    public User findOneByUsername(String userName) {
return userRepository.findOneByCredentialsUserName(userName);    }

    @Override
    public User findUserById(Integer id) {
User user = userRepository.findOne(id);
		user.getAddresses();
		
		user.getCredentials();
		return user;    }

    @Override
    public void removeEventsFromUser(User u, Events events) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveUserInEvents(Events Events, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
