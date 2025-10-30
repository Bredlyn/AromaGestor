package com.prueba.demo.controller;


import com.prueba.demo.entity.Proveedor;
import com.prueba.demo.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> listar() {
        return proveedorService.listar();
    }

    @PostMapping
    public Proveedor guardar(@RequestBody Proveedor proveedor) {
        return proveedorService.guardar(proveedor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        proveedorService.eliminar(id);
    }
}