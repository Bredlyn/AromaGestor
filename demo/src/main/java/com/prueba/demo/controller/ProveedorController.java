package com.prueba.demo.controller;

import com.prueba.demo.document.Proveedor;
import com.prueba.demo.document.ProveedorForm;
import com.prueba.demo.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEDOR')")
    public String listar(Model model) {
        List<Proveedor> proveedores = proveedorService.listar();
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("proveedorForm", new ProveedorForm()); // DTO para el formulario
        return "proveedores";
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEDOR')")
    public String guardar(@ModelAttribute ProveedorForm proveedorForm) {

        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(proveedorForm.getNombre());

        Proveedor.ProductoSuministrado ps = new Proveedor.ProductoSuministrado();
        ps.setNombre(proveedorForm.getProducto());
        ps.setCantidadProducto(proveedorForm.getCantidadProducto());

        proveedor.setProductosSuministrados(List.of(ps));

        proveedorService.guardar(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String eliminar(@PathVariable String id) {
        proveedorService.eliminar(id);
        return "redirect:/proveedores";
    }
}
