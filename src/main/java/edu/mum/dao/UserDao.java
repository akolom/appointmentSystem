/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao;

import edu.mum.domain.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HAGOS
 */
public interface UserDao extends GenericDao<User> {

    User findOneByCredentialsUserName(User userName);

    public User findUserById(Integer id);
    
    public List<User> findAllExceptThisUserId(Integer id);
    
}
