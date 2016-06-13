/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao.impl;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HAGOS
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        super.setDaoType(User.class);
    }

    @Override
    public User findOneByCredentialsUserName(User userName) {
        return entityManager.find(User.class, userName);
    }

    @Override
    public User findUserById(Integer id) {
        User user = entityManager.find(User.class, id);
        return user;
    }    

}
