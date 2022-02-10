package com.bolsadeideas.springboot.di.app.models.domain;

import lombok.Data;

@Data
public class Product {

    private String productName;
    private Integer price;

    public Product(String productName, Integer price) {
        this.productName = productName;
        this.price = price;
    }
}
