package com.huseyingurel.service;

import com.huseyingurel.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product saveProduct(Product product);
    Product getProductById(Long id);
    List<Product> getProductByName(String productName);
    List<Product> getProductByActive(boolean active);




}
