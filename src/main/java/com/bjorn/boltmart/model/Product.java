package com.bjorn.boltmart.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String productId;

    private String userOwned;

    private String productTitle;

    private double price;

    @DBRef
    private Shops shop;

}
