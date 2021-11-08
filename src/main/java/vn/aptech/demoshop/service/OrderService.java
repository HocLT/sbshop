/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.demoshop.entity.Order;

/**
 *
 * @author quang
 */
public interface OrderService {
    
    List<Order> findAll();
    
    Optional<Order> findById(int id);
    
    Order save(Order obj);
    
    void deleteById(int id);
}
