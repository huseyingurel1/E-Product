package com.huseyingurel.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "ProductCache")
public class ProductCache implements Serializable{

    private static final long serialVersionUID = -7571092848898680939L;
    @Id
    private String id;

    private String productName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String expirationDay;

    private double price;

    private String moneyType;


}
