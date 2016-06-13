/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao;

import edu.mum.domain.Authority;

/**
 *
 * @author HAGOS
 */
public interface AuthorityDao extends GenericDao<Authority>{


    public Authority findOneByName(String name);
    
}
