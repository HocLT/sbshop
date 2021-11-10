/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoshop.model;

import lombok.Data;
import vn.aptech.demoshop.entity.Product;

/**
 *
 * @author quang
 */
@Data

public class CartItem {
    private Product product;
    private int quantity;
}
