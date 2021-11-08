/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.demoshop.entity.Customer;

/**
 *
 * @author quang
 */
public interface CustomerService {
    
    List<Customer> findAll();
    
    Optional<Customer> findById(int id);
    
    Customer save(Customer obj);
    
    void deleteById(int id);
}
