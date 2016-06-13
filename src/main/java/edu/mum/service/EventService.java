/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service;

import edu.mum.domain.Events;
import edu.mum.domain.User;
import java.util.List;

/**
 *
 * @author akolom
 */
public interface EventService {


    public List<Events> findAll(Integer userId);
    public void update(Events event);
    public void save(Events event);

}
