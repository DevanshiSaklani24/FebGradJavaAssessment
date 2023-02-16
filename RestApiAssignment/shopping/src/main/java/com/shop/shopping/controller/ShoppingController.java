package com.shop.shopping.controller;

import com.shop.shopping.Exception.NoEntityException;
import com.shop.shopping.model.Product;
import com.shop.shopping.service.OrderServiceImpl;
import com.shop.shopping.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ShoppingController {
    @Autowired
    private OrderServiceImpl orderServiceImp;
    @Autowired
    private ProductServiceImpl productServiceImp;

    @GetMapping("/get")
    private List<Map<String,String>> get(){
        return orderServiceImp.getAll();
    }

    @GetMapping("/get/{orderName}")
    private List<Map<String,String>>getByName(@PathVariable String orderName){
        return orderServiceImp.findByOrderName(orderName);
    }

//    @GetMapping("/get/{productName}")
////    private List<Map<String,String>>getproductByName(@PathVariable String productName){
////        return productServiceImp.findIdByName(productName);
////    private ResponseEntity<List<Product>> getAllProducts(){
////        return ResponseEntity.ok().body(this.orderServiceImp.g());
//    }

    @PostMapping("/addProduct/{productName}-{price}")
    private void addProduct(@PathVariable String productName, @PathVariable Double price){
        productServiceImp.addProduct(productName,price);
    }


    @GetMapping("/addOrder/{orderName}-{quantity}-{product_id}")
    private String addOrder(@PathVariable String orderName,@PathVariable Integer quantity,
                            @PathVariable Integer product_id){
        return orderServiceImp.addOrder(orderName,quantity,product_id);
    }

    @PutMapping("/updtOrder/{orderId}-{productId}-{quantity}")
    private void updtOrder(@PathVariable Long orderId, @PathVariable Long productId,
                           @PathVariable Integer quantity) throws NoEntityException {
        orderServiceImp.updateOrder(orderId,productId,quantity);
    }

    @DeleteMapping("/delOrder")
    private void delOrder(Integer orderId) throws NoEntityException {
        orderServiceImp.delOrder(orderId);
    }

}
