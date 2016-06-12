/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.repository;

import edu.mum.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author akolom
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    
    User findOneByEmail(String email);

	User findOneByCredentialsUserName(String userName);
    
}
