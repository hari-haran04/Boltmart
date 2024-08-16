package com.bjorn.boltmart.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "checkout")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Checkout {

    @Id
    private String id;
    private String productId;
    private String userOwned;
    private String productTitle;
    private double productPrice;



}
