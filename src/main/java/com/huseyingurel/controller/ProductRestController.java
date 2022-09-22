package com.huseyingurel.controller;

import com.huseyingurel.model.Product;
import com.huseyingurel.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private ProductService productService;

    public ProductRestController(ProductService productService) {
        super();
        this.productService = productService;
    }
    //handler method to handle list students and return mode and view
    @GetMapping
    public List<Product> listProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/new")
    public String saveProduct(@RequestBody Product product){
        try {
            productService.saveProduct(product);
        } catch (Exception e) {
            return "The product couldn't save , please fill in the required fields and try again.";
        }
        return "The product was saved successfully";
    }

    @PutMapping("/{id}")
    public String updateProductStatus(@PathVariable Long id){


        //get product from database by id
        Product existingProduct = productService.getProductById(id);

        existingProduct.setActive(!existingProduct.isActive());
        //save updated changes
        productService.saveProduct(existingProduct);

        return "Product updated successfully";
    }

    @GetMapping("/name/{productName}")
    public List<Product> productsByName(@PathVariable String productName){

        return productService.getProductByName(productName);
    }
    @GetMapping("/active/{active}")
    public List<Product> productsByActive(@PathVariable("active")boolean active){

        return productService.getProductByActive(active);
    }
}
