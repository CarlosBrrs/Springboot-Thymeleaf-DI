package com.bolsadeideas.springboot.di.app.controllers;

import com.bolsadeideas.springboot.di.app.models.service.IMyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

    //Se desacopla la clase usando @Autowired aquí y @Component/@Service en la clase inyectada
    //Autowired busca un objeto de esa clase que este registrado en el contenedor de Spring, @Component lo registra
    //Se inyecta la interface para desacoplar aun más la aplicación
    //El autowired puede ir sobre el setter o sobre un constructor de la clase con el atributo como parametro. O puede ir el atributo y el constructor y ya no necesita autowired
    @Autowired
    //El quilifier se usa para definir cual componente se va a inyectar.
    //Se pueden tener varios atributos, unos anotados y otros no con el quilifier (en caso de tener un  primary)
    //Se puede usar el quilifier indicando cual se inyectará sin primary en las clases
    @Qualifier("miServicioSimpleSecundario")
    private IMyService service;

    @GetMapping({"/index", "/home"})
    public String index(Model model) {
        model.addAttribute("operacion", service.operation());
        return "index";
    }
}
