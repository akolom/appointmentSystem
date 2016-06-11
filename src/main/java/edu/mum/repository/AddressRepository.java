/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.repository;

import edu.mum.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author akolom
 */
public interface AddressRepository extends JpaRepository<Address, Long>{
    
}
