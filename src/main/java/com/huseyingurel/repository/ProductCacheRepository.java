package com.huseyingurel.repository;


import com.huseyingurel.model.ProductCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductCacheRepository extends CrudRepository<ProductCache,String> {

}
