package com.huseyingurel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SolmazProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolmazProjectApplication.class, args);
    }

}
