package com.prueba.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaController {

    @GetMapping("/menuVendedor")
    public String mostrarMenuVendedor(HttpSession session) {
        String rol = (String) session.getAttribute("rol");

        if ("VENDEDOR".equalsIgnoreCase(rol)) {
            return "menuVendedor";
        }
        if ("ADMIN".equalsIgnoreCase(rol)) {
            return "redirect:/menuAdmin";
        }

        return "redirect:/login";
    }

    @GetMapping("/menuAdmin")
    public String mostrarMenuAdmin(HttpSession session) {
        String rol = (String) session.getAttribute("rol");

        if ("ADMIN".equalsIgnoreCase(rol)) {
            return "menuAdmin";
        }

        return "redirect:/login";
    }

    @GetMapping("/")
    public String inicio(HttpSession session) {
        String rol = (String) session.getAttribute("rol");

        if ("ADMIN".equalsIgnoreCase(rol)) {
            return "redirect:/menuAdmin";
        }
        if ("VENDEDOR".equalsIgnoreCase(rol)) {
            return "redirect:/menuVendedor";
        }

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
