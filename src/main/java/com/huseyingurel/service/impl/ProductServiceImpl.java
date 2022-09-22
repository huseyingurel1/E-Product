package com.huseyingurel.service.impl;

import com.huseyingurel.model.Product;
import com.huseyingurel.repository.ProductRepository;
import com.huseyingurel.service.ProductService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository ;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product ) {
        return productRepository.save(product);
    }
    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id).get();
    }

    @Override
    public List<Product>  getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> getProductByActive(boolean active) {
        return productRepository.findByActive(active);
    }

//    @Override
//    public List<Product> getAllProductByActive(Boolean active) {
//        return Collections.singletonList(productRepository.findByActive(active));
//    }


}
