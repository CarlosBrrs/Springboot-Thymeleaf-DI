package com.bolsadeideas.springboot.di.app.models.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
public class Client {

    //Value para definirlos desde el properties
    @Value("${client.name}")
    private String name;
    @Value("${client.lastname}")
    private String lastname;

}
