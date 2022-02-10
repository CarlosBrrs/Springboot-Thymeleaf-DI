package com.bolsadeideas.springboot.di.app.controllers;

import com.bolsadeideas.springboot.di.app.models.domain.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private Bill bill;

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("titulo", "Ejemplo factura con inyección de dependencias");
        model.addAttribute("factura", bill);
        return "bill/view";
    }
}
