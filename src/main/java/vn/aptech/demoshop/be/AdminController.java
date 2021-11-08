/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.be;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author quang
 */
@Controller
public class AdminController {
    
    @GetMapping(value = "/be/login")
    public String login(Model model) {
        return "be/login";
    }
    
    @GetMapping(value = "/be/dashboard")
    public String dashboard(Model model) {
        return "be/dashboard";
    }
}
