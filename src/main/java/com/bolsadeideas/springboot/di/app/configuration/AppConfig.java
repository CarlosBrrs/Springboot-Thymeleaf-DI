package com.bolsadeideas.springboot.di.app.configuration;

import com.bolsadeideas.springboot.di.app.models.service.IMyService;
import com.bolsadeideas.springboot.di.app.models.service.MyComplexService;
import com.bolsadeideas.springboot.di.app.models.service.MySimpleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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

}
