/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service;

import edu.mum.domain.Authority;

/**
 *
 * @author akolom
 */
public interface AuthorityService {

    public Object findAll();

    public Authority findOneByName(String name);
    
}
