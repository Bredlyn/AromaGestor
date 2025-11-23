package com.prueba.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login/verificar")
    public String verificarLogin(@RequestParam String usuario,
                                 @RequestParam String password,
                                 HttpSession session,
                                 Model model) {

        if (usuario.equals("admin") && password.equals("admin123")) {
            session.setAttribute("rol", "ADMIN");
            return "redirect:/menuAdministrador";

        } else if (usuario.equals("vendedor") && password.equals("vendedor123")) {
            session.setAttribute("rol", "VENDEDOR");
            return "redirect:/menuVendedor";

        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

    @PostMapping("/login/verificarFlutter")
    @ResponseBody
    public Map<String, Object> loginFlutter(@RequestBody Map<String, String> body, HttpSession session) {
        String usuario = body.get("usuario");
        String password = body.get("password");

        Map<String, Object> response = new HashMap<>();

        if (usuario.equals("admin") && password.equals("admin123")) {
            session.setAttribute("rol", "ADMIN");
            response.put("status", "ok");
            response.put("rol", "ADMIN");

        } else if (usuario.equals("vendedor") && password.equals("vendedor123")) {
            session.setAttribute("rol", "VENDEDOR");
            response.put("status", "ok");
            response.put("rol", "VENDEDOR");

        } else {
            response.put("status", "error");
        }

        return response;
    }
}
