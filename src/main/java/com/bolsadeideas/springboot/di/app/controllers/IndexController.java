package com.bolsadeideas.springboot.di.app.controllers;

import com.bolsadeideas.springboot.di.app.models.service.IMyService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private IMyService service;

    @GetMapping({"/index", "/home"})
    public String index(Model model) {
        model.addAttribute("operacion",service.operation());
        return "index";
    }
}
