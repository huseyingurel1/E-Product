package com.huseyingurel.repository;


import com.huseyingurel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long > {
    Product findByActive(Boolean active);
}
