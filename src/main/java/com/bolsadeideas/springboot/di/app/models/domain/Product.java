package com.bolsadeideas.springboot.di.app.models.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private String productName;
    private Integer price;
}
