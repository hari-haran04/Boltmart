package com.bjorn.boltmart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CheckoutResponse {
    private List<Product> products;
    private BigDecimal totalPrice;

}
