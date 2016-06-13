/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao.impl;

import edu.mum.dao.AuthorityDao;
import edu.mum.domain.Authority;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HAGOS
 */
public class AuthorityDaoImpl extends GenericDaoImpl<Authority> implements AuthorityDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Authority findOneByName(String name) {
        Query query = entityManager.createQuery("from Authority e where e.name = :name");
        query.setParameter("username", name);
        List<Authority> authority = query.getResultList();
        if (authority.isEmpty()) {
            return null;
        } else {
            return authority.get(0);
        }

    }
}
