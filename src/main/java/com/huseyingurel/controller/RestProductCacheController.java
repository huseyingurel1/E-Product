//package com.huseyingurel.controller;
//
//import com.huseyingurel.model.ProductCache;
//import com.huseyingurel.repository.ProductCacheRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class ProductCacheController {
//    private final ProductCacheRepository productCacheRepository;
//
//    public ProductCacheController(ProductCacheRepository productCacheRepository) {
//        this.productCacheRepository = productCacheRepository;
//    }
//
//    @GetMapping("productHash")
//    public List<ProductCache> getAllProducts(){
//        return productCacheRepository.findAll();
//    }
//
//    @PostMapping("productHash")
//    public ProductCache save(@RequestBody ProductCache productCache){
//        return productCacheRepository.save(productCache);
//    }
//
//    @GetMapping("productHash/{id}")
//    public ProductCache findProductHashById(@PathVariable Long id){
//        return productCacheRepository.findProductHashById(id);
//    }
//
//    @DeleteMapping("productHash/{id}")
//    public String deleteProductHash(@PathVariable Long id){
//        return productCacheRepository.deleteProductHash(id);
//    }
//
//}


package com.huseyingurel.controller;

import com.huseyingurel.model.ProductCache;
import com.huseyingurel.service.ProductCacheService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/productCache")
public class RestProductCacheController {
    private ProductCacheService productCacheService;

    public RestProductCacheController(ProductCacheService productCacheService) {
        this.productCacheService = productCacheService;
    }

    @PostMapping("/new")
    public ProductCache saveProductCache(@RequestBody ProductCache productCache){
//        productCache.setId(UUID.randomUUID().toString());
        return productCacheService.saveCacheProduct(productCache);

    }

    @GetMapping
    public List<ProductCache> listProductsCache(Model model){
        return productCacheService.getAllCacheProducts();
    }

//    @GetMapping("/productsCache/{id}")
//    public ProductCache findProductsCacheById(@PathVariable Long id){
//        return productCacheService.getProductCacheById(id);
//    }

//    @CacheEvict(value = "test", key = "#id")
//    @DeleteMapping("/productsCache/{id}")
//    public String deleteProductsCache(@PathVariable Long id){
//        return productCacheService.deleteProductsCache(id);
//    }

}
