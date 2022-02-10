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

    @Bean("BillItems")
    public List<BillItem> itemList() {
        Product product1 = new Product("Camara Sony", 150000);
        Product product2 = new Product("Bicicleta Bianchi", 500000);

        BillItem billItem1 = new BillItem(product1, 2);
        BillItem billItem2 = new BillItem(product2, 1);

        return Arrays.asList(billItem1, billItem2);
    }

    @Primary //Tambien se puede seleccionar cual se inyectará con el @Qualifier en el Controller
    @Bean("BillOfficeItems")
    public List<BillItem> itemOfficeList() {
        Product product1 = new Product("Monitor LG", 800000);
        Product product2 = new Product("Notebook ASUS", 1500000);
        Product product3 = new Product("Impresora HP multifuncional", 560000);
        Product product4 = new Product("Escritorio oficina", 550000);

        BillItem billItem1 = new BillItem(product1, 2);
        BillItem billItem2 = new BillItem(product2, 1);
        BillItem billItem3 = new BillItem(product3, 4);
        BillItem billItem4 = new BillItem(product4, 3);

        return Arrays.asList(billItem1, billItem2, billItem3, billItem4);
    }

/*
    @Bean
    public BillUsecase billUsecase(Bill bill) {
        return new BillUsecase(bill);
    }
*/

}
