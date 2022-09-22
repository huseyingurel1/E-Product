package com.huseyingurel.controller;

import com.huseyingurel.model.Product;
import com.huseyingurel.model.ProductCache;
import com.huseyingurel.repository.CacheRepository;
import com.huseyingurel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productsCache")
public class ProductCacheRestController {

    @Autowired
    private ProductService productService;

    private CacheRepository cacheRepository;

    public ProductCacheRestController(CacheRepository cacheRepository) {
        this.cacheRepository = cacheRepository;
    }

    @PostMapping("/new")
    public ProductCache saveProductCache(@RequestBody ProductCache productCache){
        return cacheRepository.save(productCache);

    }

    @GetMapping
    public List<ProductCache> listProductsCache(){
        return cacheRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProductCache findProduct(@PathVariable Long id){
        return cacheRepository.findProductById(id);
    }

    @PostMapping("/transferDB/{id}")
    public String transferProductDB(@PathVariable Long id){
        ProductCache existingProductCache = cacheRepository.findProductById(id);
        Product productDB = new Product();
        productDB.setId(existingProductCache.getId());
        productDB.setProductName(existingProductCache.getProductName());
        productDB.setExpirationDay(existingProductCache.getExpirationDay());
        productDB.setPrice(existingProductCache.getPrice());
        productDB.setMoneyType(existingProductCache.getMoneyType());

        productService.saveProduct(productDB);

        cacheRepository.deleteProductById(id);
        return "Product Cache submitted to Product Database and removed from cache";
    }

    @DeleteMapping("/{id}")
    public String deleteProductCache(@PathVariable Long id){
        return cacheRepository.deleteProductById(id);
    }

}
