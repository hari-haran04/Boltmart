package com.bjorn.boltmart.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "shop")
public class Shops {

    @Id
    private String id;
    private String shopName;
    private String shopId;

    @DBRef
    private List<Product> products;
}
