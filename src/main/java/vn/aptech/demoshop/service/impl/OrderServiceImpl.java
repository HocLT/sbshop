/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import vn.aptech.demoshop.entity.Order;
import vn.aptech.demoshop.repository.OrderRepository;
import vn.aptech.demoshop.service.OrderService;

/**
 *
 * @author quang
 */
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository repo;
    
    @Override
    public List<Order> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Order> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Order save(Order obj) {
        return repo.save(obj);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
