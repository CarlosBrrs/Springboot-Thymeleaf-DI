package com.bolsadeideas.springboot.di.app.controllers;

import com.bolsadeideas.springboot.di.app.models.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

    private MyService service = new MyService();

    @GetMapping({"/index", "/home"})
    public String index(Model model) {
        model.addAttribute("operacion",service.operation());
        return "index";
    }
}
