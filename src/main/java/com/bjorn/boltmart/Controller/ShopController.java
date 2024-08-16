package com.bjorn.boltmart.Controller;

import com.bjorn.boltmart.Service.ShopService;
import com.bjorn.boltmart.model.Shops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/add")
    public ResponseEntity<Shops> addShop(@RequestBody Shops shop) {
        Shops createdShop = shopService.addShop(shop);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShop);
    }

    @GetMapping("/{shopId}")
    public ResponseEntity<Shops> getShopById(@PathVariable String shopId) {
        return shopService.getShopById(shopId)
                .map(shop -> ResponseEntity.ok(shop))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
