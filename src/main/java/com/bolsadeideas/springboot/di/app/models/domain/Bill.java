package com.bolsadeideas.springboot.di.app.models.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Bill {

    @Value("${bill.description}")
    private String description;
    @Autowired
    private Client client;
    @Autowired
    private List<BillItem> items;
    private Integer total;

    public Integer totalBill() {
        int total = 0;
        for (BillItem item: items) {
            total = total + (item.getProduct().getPrice()*item.getQuantity());
        }
        return total;
    }
}
