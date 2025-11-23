package com.prueba.demo.controller;

import com.prueba.demo.document.Cliente;
import com.prueba.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@RequestMapping("/clientes")
public class ClienteWebController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEDOR')")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("cliente", new Cliente());
        return "clientes";
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEDOR')")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.guardar(cliente);
        return "redirect:/clientes";
    }

    @PostMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String eliminarCliente(@PathVariable String id) {
        clienteService.eliminar(id);
        return "redirect:/clientes";
    }
}