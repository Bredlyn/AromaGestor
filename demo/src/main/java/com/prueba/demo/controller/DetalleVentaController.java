package com.prueba.demo.controller;


import com.prueba.demo.entity.DetalleVenta;
import com.prueba.demo.services.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalle-ventas")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'VENDEDOR')")
    public List<DetalleVenta> listar() {
        return detalleVentaService.listar();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('VENDEDOR')")
    public DetalleVenta guardar(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.guardar(detalleVenta);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")

    public void eliminar(@PathVariable Long id) {
        detalleVentaService.eliminar(id);
    }
}
