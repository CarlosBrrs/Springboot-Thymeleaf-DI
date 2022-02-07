package com.bolsadeideas.springboot.di.app.configuration;

import com.bolsadeideas.springboot.di.app.models.domain.BillItem;
import com.bolsadeideas.springboot.di.app.models.domain.Product;
import com.bolsadeideas.springboot.di.app.models.service.IMyService;
import com.bolsadeideas.springboot.di.app.models.service.MyComplexService;
import com.bolsadeideas.springboot.di.app.models.service.MySimpleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    /*La otra manera de pasar beans al contenedor es con una clase anotada con @Configuration y @Bean en cada uno
      de los métodos beans, con esto no se necesitan las anotaciones en cada clase
      Se pueden usar los Quilifier y los Primary aqui*/
    @Bean
    @Primary
    public IMyService simpleService() {
        return new MySimpleService();
    }

    @Bean
    public IMyService complexService() {
        return new MyComplexService();
    }

    @Bean
    public List<BillItem> itemList() {
        Product product1 = Product.builder().productName("Camara Sony").price(150000).build();
        Product product2 = Product.builder().productName("Bicicleta Bianchi").price(500000).build();

        BillItem billItem1 = BillItem.builder().product(product1).quantity(2).build();
        BillItem billItem2 = BillItem.builder().product(product2).quantity(1).build();

        return Arrays.asList(billItem1, billItem2);
    }

}
