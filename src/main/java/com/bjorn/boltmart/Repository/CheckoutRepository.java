package com.bjorn.boltmart.Repository;

import com.bjorn.boltmart.model.Checkout;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CheckoutRepository extends MongoRepository<Checkout,String> {
    Checkout findByProductId(String productId);
    Checkout deleteCheckoutByUserOwned(String userid);

    List<Checkout> findAllByUserOwned(String userid);

    void deleteAllCheckoutByUserOwned(String userid);

}
