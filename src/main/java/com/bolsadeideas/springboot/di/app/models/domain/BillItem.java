package com.bolsadeideas.springboot.di.app.models.domain;

import lombok.Data;

@Data
public class BillItem {

    private Product product;
    private Integer quantity;

    public BillItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getImport() {
        return product.getPrice()*quantity;
    }
}
