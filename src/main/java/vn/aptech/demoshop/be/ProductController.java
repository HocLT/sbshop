/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.be;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.demoshop.entity.Product;
import vn.aptech.demoshop.service.ProductService;

/**
 *
 * @author quang
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService service;
    
    @GetMapping(value = "/be/product")
    public String index(Model model) {
        model.addAttribute("products", service.findAll());
        return "be/product/index";
    }
    
    @GetMapping(value = "/be/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "be/product/create";
    }
    @PostMapping(value = "/be/product/save")
    public String save(Model model, 
            @ModelAttribute("product") Product product,
            @RequestParam("images") MultipartFile image, // part hình
            BindingResult result,
            final RedirectAttributes redirectAttributes
            ) {
        // kiểm tra xem có hình không?
        if (!image.isEmpty()) {
            try {
                byte[] bytes = image.getBytes();    // copy dữ liệu hình vào biến bytes
                File uploadFolder = ResourceUtils.getFile("classpath:static/images");   // tạo đối tượng File trỏ đến thư mục static/images
                Path imagePath = Paths.get(uploadFolder.getPath(), image.getOriginalFilename());    // kết hợp path của thư mục images với filename để tạo thành đường dẫn của file cần upload
                Files.write(imagePath, bytes);  // ghi mảng bytes vào file
                product.setImage(image.getOriginalFilename());
            } catch (Exception ex) {
                ex.printStackTrace();
            }  
        } else {
            // xử lý cho trường hợp update
            // cần đọc product cũ lên để copy image
            service.findById(product.getId()).ifPresent(p->{
                product.setImage(p.getImage()); 
            });
        }
        
        // lưu product
        service.save(product);
        return "redirect:/be/product";
    }
    
    @GetMapping(value = "/be/product/{id}/update")
    public String update(Model model, @PathVariable("id") String id) {
        service.findById(id).ifPresent(p->{
            model.addAttribute("product", p);
        });
        return "be/product/create";
    }
    
    @GetMapping(value = "/be/product/{id}/delete")
    public String delete(@PathVariable("id") String id) {
        service.deleteById(id);
        return "redirect:/be/product";
    }
}
