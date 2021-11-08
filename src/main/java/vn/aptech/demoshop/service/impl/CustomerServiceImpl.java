/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import vn.aptech.demoshop.entity.Customer;
import vn.aptech.demoshop.repository.CustomerRepository;
import vn.aptech.demoshop.service.CustomerService;

/**
 *
 * @author quang
 */
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository repo;
    
    @Override
    public List<Customer> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Customer save(Customer obj) {
        return repo.save(obj);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
    
}
