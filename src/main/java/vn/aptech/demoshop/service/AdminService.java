/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.demoshop.entity.Admin;

/**
 *
 * @author quang
 */
public interface AdminService {
    
    List<Admin> findAll();
    
    Optional<Admin> findById(int id);
    
    Admin save(Admin adm);
    
    void deleteById(int id);
    
    Admin findByUsername(String username);
}
