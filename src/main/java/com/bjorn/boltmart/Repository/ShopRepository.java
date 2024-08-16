package com.bjorn.boltmart.Repository;

import com.bjorn.boltmart.model.Shops;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopRepository extends MongoRepository<Shops,String> {
    Shops findByShopId(String shopId);
}
