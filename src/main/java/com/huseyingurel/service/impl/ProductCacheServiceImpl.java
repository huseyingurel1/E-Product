//package com.huseyingurel.service.impl;
//
//import com.huseyingurel.model.ProductCache;
//import com.huseyingurel.repository.ProductCacheRepository;
//import com.huseyingurel.repository.ProductRepository;
//import com.huseyingurel.service.ProductCacheService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProductCacheServiceImpl implements ProductCacheService {
//    public static final String HASH_KEY = "ProductCache";
//    @Autowired
//    private RedisTemplate template;
//
//    @Override
//    public List<ProductCache> getAllCacheProducts() {
//        return template.opsForHash().values(HASH_KEY);
//    }
//
//    @Override
//    public ProductCache saveCacheProduct(ProductCache productCache) {
//        template.opsForHash().put(HASH_KEY, productCache.getId(), productCache);
//        return productCache;
//    }
//
//    @Override
//    public ProductCache getProductCacheById(Long id) {
//        return (ProductCache) template.opsForHash().get(HASH_KEY,id);
//    }
//}

package com.huseyingurel.service.impl;

import com.huseyingurel.model.ProductCache;
import com.huseyingurel.repository.CacheRepository;
import com.huseyingurel.service.ProductCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCacheServiceImpl implements ProductCacheService {


    @Autowired
    private CacheRepository cacheRepository;


    @Override
    public List<ProductCache> getAllCacheProducts() {
        return cacheRepository.findAll();
    }

    @Override
    public ProductCache saveCacheProduct(ProductCache productCache) {
      return   cacheRepository.save(productCache);
    }

    @Override
    public String deleteProductsCache(String id) {
        cacheRepository.deleteProductHash(id);
        return HttpStatus.OK.toString();
    }

}

