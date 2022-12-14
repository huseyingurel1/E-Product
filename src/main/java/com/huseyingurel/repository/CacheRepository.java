package com.huseyingurel.repository;


import com.huseyingurel.model.ProductCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Repository
public class CacheRepository {

    public static final String HASH_KEY = "ProductCache";

    private final RedisTemplate redisTemplate;

    public CacheRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public ProductCache save(ProductCache productCache) {
        redisTemplate.opsForHash().put(HASH_KEY, productCache.getId(), productCache);
        redisTemplate.expire(HASH_KEY,60, TimeUnit.MINUTES);
        return productCache;
    }

    public List<ProductCache> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public ProductCache findProductById(Long id) {
        return (ProductCache) redisTemplate.opsForHash().get(HASH_KEY,id);
    }

    public String deleteProductById(Long id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "This Product cache deleted from Cache";
    }
}
