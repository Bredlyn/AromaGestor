package com.prueba.demo.controller;

import com.prueba.demo.document.Producto;
import com.prueba.demo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@RequestMapping("/productos")
public class ProductoWebController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'VENDEDOR')")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listar());
        return "productos";
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'VENDEDOR')")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public String eliminarProducto(@PathVariable String id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }

    @GetMapping("/nuevo")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'VENDEDOR')")
    public String mostrarFormularioNuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "nuevo_producto";
    }

}
