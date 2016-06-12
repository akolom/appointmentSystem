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
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author akolom
 */
public interface EventRepository extends JpaRepository<Events, Integer> {
    
    List<Events> findByUser(User user);
    Events findById(Integer id);
@Query("select e from Events e where e.name like %?1% or  e.description like %?1%")
    public List<Events> findByDescription(String description);

    public List<Integer> findAllEventIdByUserId(Integer userId);
@Query(nativeQuery = true, value = " select e.id from Events e where e.id not in "
        + "(select events_id from User_Event where user_id = ?1)")
    public List<Integer> findAllNotAppliedEvents(Integer userId);

    public List<Events> findByDescriptionByNotApplied(List<Integer> ids, String key);
    
}
