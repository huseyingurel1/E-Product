package com.huseyingurel.controller;

import com.huseyingurel.model.Product;
import com.huseyingurel.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }
    //handler method to handle list students and return mode and view
     @GetMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/products/new")
    public String createProductForm(Model model){

        Product product = new Product();
        model.addAttribute("product", product);
        return "create_product";

    }
    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product){
        try {
            productService.saveProduct(product);
        } catch (Exception e) {
            return "redirect:/products?error";
        }
        return "redirect:/products?success";
    }

    @PostMapping("/products/{id}")
    public String updateProductStatus(@PathVariable Long id, @ModelAttribute("product") Product product, Model model){


        //get product from database by id
        Product existingProduct = productService.getProductById(id);

        existingProduct.setActive(!existingProduct.isActive());

        //save updated student object
        productService.saveProduct(existingProduct);

        return "redirect:/products";
    }

    @GetMapping("/activeProducts")
    public String listOfActiveProducts(Model model, Product product){
        model.addAttribute("activeProducts", productService.getAllProductByActive(product.isActive()));
        return "activeProducts";
    }






}
