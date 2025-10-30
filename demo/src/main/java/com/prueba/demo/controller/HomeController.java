package com.prueba.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String mostrarMenu(Model model) {
        model.addAttribute("mensaje", "Bienvenido a AromaGestor");
        return "index";
    }
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mensaje", "Bienvenido a AromaGestor");
        return "index";
    }

}
