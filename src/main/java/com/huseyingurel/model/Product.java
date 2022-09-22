package com.huseyingurel.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( name = "product_name", nullable = false)
    private String productName;

    @Column( name = "expiration_date", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String expirationDay;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "money_type", nullable = false)
    private String moneyType;

    @Column(name ="active")
    private boolean active = false;

}
