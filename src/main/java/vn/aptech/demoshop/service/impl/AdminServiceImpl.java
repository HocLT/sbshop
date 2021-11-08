/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.aptech.demoshop.entity.Admin;
import vn.aptech.demoshop.model.MyUserDetails;
import vn.aptech.demoshop.repository.AdminRepository;
import vn.aptech.demoshop.service.AdminService;

/**
 *
 * @author quang
 */
@Service
//@Component
//@Repository
public class AdminServiceImpl implements AdminService, UserDetailsService {

    @Autowired
    private AdminRepository repo;
    
    @Override
    public List<Admin> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Admin> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Admin save(Admin adm) {
        return repo.save(adm);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public Admin findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin u = repo.findByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("user not exist.");
        }
        return new MyUserDetails(u);
    }
    
}
