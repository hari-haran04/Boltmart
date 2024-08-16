package com.bjorn.boltmart.Service;

import com.bjorn.boltmart.Repository.ShopRepository;
import com.bjorn.boltmart.model.Shops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public Shops addShop(Shops shop) {
        return shopRepository.save(shop);
    }

    public Optional<Shops> getShopById(String shopId) {
        return shopRepository.findById(shopId);
    }

}
