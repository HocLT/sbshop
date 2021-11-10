/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.demoshop.entity.Product;
import vn.aptech.demoshop.repository.ProductRepository;
import vn.aptech.demoshop.service.ProductService;

/**
 *
 * @author quang
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository repo;
    
    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Product save(Product obj) {
        return repo.save(obj);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
