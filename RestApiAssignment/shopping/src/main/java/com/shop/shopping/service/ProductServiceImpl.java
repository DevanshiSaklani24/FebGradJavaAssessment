package com.shop.shopping.service;
import com.shop.shopping.Exception.NoEntityException;
import com.shop.shopping.model.Product;
import com.shop.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hibernate.internal.util.collections.CollectionHelper.toMap;

@Service
public class ProductServiceImpl {
    @Autowired
    private ProductRepository productRepository;
    private static List<Product> products;
    private static List<Map<String,String>> productsMap = new ArrayList<Map<String,String>>();

    public void addProduct(String productName, Double productPrice){
        productRepository.save(new Product(productName, productPrice));
    }

    public Product findById(long id) throws NoEntityException {
        Product product = productRepository.findById(id).orElseThrow(()
                -> new NoEntityException(id, "Product not found"));
        return product;
    }

//    public long findIdByName(String productName){
//        return productRepository.findByProductName(productName).getProductID();
//    }
//
//
    public List<Map<String, String>> findIdByName(String productName) {
        productsMap.clear();
        toMap(productRepository.findByProductName(productName).getProductID());
        return productsMap;
    }

}