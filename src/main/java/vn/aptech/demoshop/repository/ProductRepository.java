/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.demoshop.entity.Product;

/**
 *
 * @author quang
 */
public interface ProductRepository extends JpaRepository<Product, String>{
    
}
