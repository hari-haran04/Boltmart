package com.bjorn.boltmart.Service;

import com.bjorn.boltmart.Repository.CheckoutRepository;
import com.bjorn.boltmart.Repository.ProductRepository;
import com.bjorn.boltmart.Repository.ShopRepository;
import com.bjorn.boltmart.model.Checkout;
import com.bjorn.boltmart.model.CheckoutResponse;
import com.bjorn.boltmart.model.Product;
import com.bjorn.boltmart.model.Shops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    private ShopRepository shopRepository;

    public Product addProduct(Product product, String shopId) {
        Shops shop = shopRepository.findByShopId(shopId);

        product.setShop(shop);
        return productRepository.save(product);
    }
    public Product addProductToCart(String userId, String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Checkout existingCheckout = checkoutRepository.findByProductId(productId);
        if (existingCheckout != null) {
            checkoutRepository.delete(existingCheckout);
        }
        product.setUserOwned(userId);
        productRepository.save(product);

        Checkout checkout = new Checkout();
        checkout.setProductId(product.getProductId());
        checkout.setUserOwned(userId);
        checkout.setProductTitle(product.getProductTitle());
        checkout.setProductPrice(product.getPrice());
        checkoutRepository.save(checkout);

        return product;
    }

    public void removeProductFromCart(String userId, String productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setUserOwned(null);
        productRepository.save(product);

        Checkout checkout = checkoutRepository.findByProductId(productId);
        if (checkout != null) {
            checkoutRepository.delete(checkout);
        }
    }

    public Product getProductDetails(String productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getProductsByShopId(String shopId) {
        Shops s = shopRepository.findByShopId(shopId);
        return productRepository.findByShop(s);
    }


    public CheckoutResponse checkout_user(String userid) {

        List<Checkout> checkoutList = checkoutRepository.findAllByUserOwned(userid);

        List<Product> ownedProducts = new ArrayList<>();

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Checkout checkout : checkoutList) {
            Product product = productRepository.findById(checkout.getProductId()).orElse(null);

            if (product != null) {
                ownedProducts.add(product);
                totalPrice = totalPrice.add(BigDecimal.valueOf(product.getPrice()));
                productRepository.deleteById(product.getProductId());
            }
        }
        checkoutRepository.deleteAllCheckoutByUserOwned(userid);
        return new CheckoutResponse(ownedProducts, totalPrice);
    }

    public CheckoutResponse user_products(String userid) {
        List<Checkout> checkoutList = checkoutRepository.findAllByUserOwned(userid);

        List<Product> ownedProducts = new ArrayList<>();

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Checkout checkout : checkoutList) {
            Product product = productRepository.findById(checkout.getProductId()).orElse(null);

            if (product != null) {
                ownedProducts.add(product);
                totalPrice = totalPrice.add(BigDecimal.valueOf(product.getPrice()));
            }
        }
        return new CheckoutResponse(ownedProducts, totalPrice);
    }
}
