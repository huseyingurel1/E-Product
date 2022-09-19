package com.huseyingurel.repository;


import com.huseyingurel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

//    Product findByActive(Boolean active);
}
