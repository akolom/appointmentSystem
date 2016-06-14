/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.dao.impl;

import edu.mum.dao.AuthorityDao;
import edu.mum.domain.Authority;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HAGOS
 */
@Repository
public class AuthorityDaoImpl extends GenericDaoImpl<Authority> implements AuthorityDao {

    public AuthorityDaoImpl() {
        super.setDaoType(Authority.class);
    }

    @Override
    public Authority findOneByName(String name) {
        Query query = entityManager.createQuery("from Authority e where e.name = :name");
        query.setParameter("name", name);
        List<Authority> authority = query.getResultList();
        if (authority.isEmpty()) {
            return null;
        } else {
            return authority.get(0);
        }

    }
}
