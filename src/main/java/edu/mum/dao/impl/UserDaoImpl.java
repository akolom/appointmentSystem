/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao.impl;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HAGOS
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public  User findOneByCredentialsUserName(User userName){
                return entityManager.find(User.class, userName);
    }
    @Override
   public User findUserById(Integer id){
       User user=entityManager.find(User.class, id);
       return user;
   }

   

   

   
}
