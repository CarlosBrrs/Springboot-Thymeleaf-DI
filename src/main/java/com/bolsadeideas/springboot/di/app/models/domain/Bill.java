package com.bolsadeideas.springboot.di.app.models.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@Component
public class Bill {

    @Value("${bill.description}")
    private String description;
    @Autowired
    private Client client;
    private List<BillItem> items;
}
