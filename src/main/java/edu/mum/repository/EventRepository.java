/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.domain.Events;
import edu.mum.domain.User;
import java.util.List;


/**
 *
 * @author akolom
 */
public interface EventRepository extends JpaRepository<Events, Integer> {
    
    List<Events> findByUser(User user);
    Events findById(Integer id);
    
}
