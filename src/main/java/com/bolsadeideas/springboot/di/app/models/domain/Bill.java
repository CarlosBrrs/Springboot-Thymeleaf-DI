package com.bolsadeideas.springboot.di.app.models.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

    //Ejecuta una tarea o proceso justo despues de construir el objeto en el contenedor de Spring
    @PostConstruct
    public void init() {
        client.setName(client.getName().concat(" Andrés"));
        description = description.concat(" del cliente: ").concat(client.getName()).concat(" ").concat(client.getLastname());
        System.out.println("Factura del cliente: ".concat(client.getName()).concat(" CREADA"));
    }

    //Ejecuta una tarea o proceso justo antes de detener la aplicación
    @PreDestroy
    public void destroy() {
        System.out.println("Factura del cliente: ".concat(client.getName()).concat(" DESTRUIDA"));
    }
}
