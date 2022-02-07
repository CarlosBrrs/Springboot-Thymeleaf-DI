package com.bolsadeideas.springboot.di.app.models.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillItem {

    private Product product;
    private Integer quantity;

    //Para poder crear el bean en AppConfig
    public BillItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
