package com.huseyingurel.service;

import com.huseyingurel.model.ProductCache;

import java.util.List;

public interface ProductCacheService {

    List<ProductCache> getAllCacheProducts();

    ProductCache saveCacheProduct(ProductCache productCache);

    String deleteProductsCache(String id);


//    ProductCache getProductCacheById(Long id);

}
