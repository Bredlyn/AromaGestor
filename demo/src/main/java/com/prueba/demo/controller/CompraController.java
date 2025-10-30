package com.prueba.demo.controller;

import com.prueba.demo.entity.Compra;
import com.prueba.demo.services.CompraService;
import com.prueba.demo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CompraService compraService;

    @GetMapping
    public String listarCompras(Model model) {
        model.addAttribute("compras", compraService.listarCompras());
        return "compras";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioCompra(Model model) {
        model.addAttribute("compra", new Compra());
        model.addAttribute("productos", productoService.listar());
        return "compra_form";
    }

    @PostMapping("/guardar")
    public String guardarCompra(@ModelAttribute Compra compra) {
        productoService.agregarStock(compra.getProducto().getId(), compra.getCantidad());
        compraService.guardarCompra(compra);
        return "redirect:/compras";
    }

}




