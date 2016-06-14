/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.service.impl;

import edu.mum.dao.AuthorityDao;
import edu.mum.domain.Authority;
import edu.mum.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HAGOS
 */
@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    private AuthorityDao authorityDao;

    public Authority findOneByName(String name) {
        return authorityDao.findOneByName(name);
    }

}
