package com.prueba.demo.controller;

import com.prueba.demo.entity.Producto;
import com.prueba.demo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEDOR')")
    public List<Producto> listar() {
        return productoService.listar();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('VENDEDOR')")
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
