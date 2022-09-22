package com.huseyingurel.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("ProductCache")
public class ProductCache implements Serializable{

    @Id
    private Long id;

    private String productName;

    private String expirationDay;

    private double price;

    private String moneyType;

    private boolean active = false;


}
