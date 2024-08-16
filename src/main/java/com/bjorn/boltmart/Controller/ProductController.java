package com.bjorn.boltmart.Controller;

import com.bjorn.boltmart.Service.ProductService;
import com.bjorn.boltmart.model.CheckoutResponse;
import com.bjorn.boltmart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add/{shop}")
    public ResponseEntity<Product> addProduct(@RequestBody Product product, @PathVariable String shop) {
        Product createdProduct = productService.addProduct(product, shop);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<Product> addProductToCart(@RequestHeader("userId") String userId, @RequestHeader("pid") String productId) {
        Product product = productService.addProductToCart(userId, productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping("/remove-from-cart")
    public ResponseEntity<Void> removeProductFromCart(@RequestHeader("userId") String userId, @RequestHeader("pid") String productId) {
        productService.removeProductFromCart(userId, productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductDetails(@PathVariable String productId) {
        Product product = productService.getProductDetails(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<Product>> getProductsByShopId(@PathVariable String shopId) {
        List<Product> products = productService.getProductsByShopId(shopId);
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @PostMapping("/checkout")
    public ResponseEntity<CheckoutResponse> checkoutUser(@RequestHeader("userId") String userId) {
        CheckoutResponse response = productService.checkout_user(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{kid}")
    public ResponseEntity<CheckoutResponse> user_products(@RequestHeader("userId") String userId) {
        CheckoutResponse response = productService.user_products(userId);
        return ResponseEntity.ok(response);
    }




}
