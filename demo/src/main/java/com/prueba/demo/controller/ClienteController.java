package com.prueba.demo.controller;

import com.prueba.demo.entity.Cliente;
import com.prueba.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEDOR')")
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEDOR')")
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
    }
}
