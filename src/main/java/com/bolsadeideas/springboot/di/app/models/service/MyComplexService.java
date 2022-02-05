package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*La anotacion @Component me permite inyectar con el contenedor de Springboot
Se registra la clase como un bean con el contexto por defecto
El objeto se crea una sola vez en la aplicacion. Es un singleton (una sola instancia) que se distribuye en la app
Se puede usar @Service pero es lo mismo, es simplemente más descriptivo, por semántica
El valor del componente se usa para diferentes clases que implementen la misma interface
Desde donde se inyecta se debe especificar cual se va a usar o anotando la principal con @Primary
*/
//@Service
@Primary
@Component("miServicioComplejoPrincipal")
public class MyComplexService implements IMyService {

    //Una clase componente debe tener siempre un constructor vacio ya que Spring maneja la clase con ese constructor

    @Override
    public String operation() {
        return "Ejecutando alguna operación importante desde MyComplexService...";
    }
}
