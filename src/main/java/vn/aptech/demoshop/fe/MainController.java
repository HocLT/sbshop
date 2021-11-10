/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.fe;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.aptech.demoshop.entity.Product;
import vn.aptech.demoshop.model.CartItem;
import vn.aptech.demoshop.service.OrderService;
import vn.aptech.demoshop.service.ProductService;

/**
 *
 * @author quang
 */
@Controller
public class MainController {
    @Autowired
    private ProductService serviceProduct;
    
    @Autowired
    private OrderService serviceOrder;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", serviceProduct.findAll());
        return "fe/index";
    }
    
    // đối tượng request sẽ được inject vào
    @GetMapping("/add-cart/{id}")
    public String addCart(Model model,
            HttpServletRequest request,
            @PathVariable("id") String id) {
        // tạo đối tượng HttpSession từ request
        HttpSession session = request.getSession();
        List<CartItem> cart;
        if (session.getAttribute("cart") != null) {
            // nếu có cart trong session, gán vào đối tượng cart
            cart = (List<CartItem>)session.getAttribute("cart");
        } else {
            // ngược lại thì tạo mới
            cart = new ArrayList<>();
        }
        serviceProduct.findById(id).ifPresent(p->{
            boolean founded = false;
            for (CartItem item : cart) {
                if (item.getProduct().getId().equals(p.getId())) {
                    item.setQuantity(item.getQuantity()+1);
                    founded = true;
                    break;
                }
            }
            if (!founded) {
                CartItem ci = new CartItem();
                ci.setProduct(p);
                ci.setQuantity(1);
                cart.add(ci);   // thêm vào giỏ hàng
            }
            
            // lưu giỏ hàng vào session
            session.setAttribute("cart", cart);
        });
        return "redirect:/";    // chọn xong quay về trang chủ
    }
}
