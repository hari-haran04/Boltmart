package com.bjorn.boltmart.Repository;

import com.bjorn.boltmart.model.Product;
import com.bjorn.boltmart.model.Shops;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,String> {

    @Override
    Optional<Product> findById(String s);

    List<Product> findByShop(Shops shops);
}
