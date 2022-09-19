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

import java.util.UUID;


@Controller
public class ProductCacheController {
    private ProductCacheService productCacheService;

    public ProductCacheController(ProductCacheService productCacheService) {
        this.productCacheService = productCacheService;
    }

    @GetMapping("/productsCache/new")
    public String createProductCacheForm(Model model){
        ProductCache productCache = new ProductCache();
        model.addAttribute("productCache", productCache);
        return "create_product_cache";
    }

    @PostMapping("/productsCache")
    public String saveProductCache(@ModelAttribute("productCache")ProductCache productCache){
        productCache.setId(UUID.randomUUID().toString());
        productCacheService.saveCacheProduct(productCache);
        return "productsCache-list";
    }

    @GetMapping("/productsCache")
    public void listProductsCache(Model model){
        model.addAttribute("productCache",productCacheService.getAllCacheProducts());
//        return "productsCache-list";
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
