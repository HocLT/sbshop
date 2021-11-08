/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.demoshop.entity.Product;

/**
 *
 * @author quang
 */
public interface ProductService {
    
    List<Product> findAll();
    
    Optional<Product> findById(String id);
    
    Product save(Product obj);
    
    void deleteById(String id);
}
