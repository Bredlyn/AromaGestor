package com.prueba.demo.controller;

import com.prueba.demo.document.DetalleCompra;
import com.prueba.demo.services.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalle-compras")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'VENDEDOR')")
    public List<DetalleCompra> listar() {
        return detalleCompraService.listar();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public DetalleCompra guardar(@RequestBody DetalleCompra detalleCompra) {
        return detalleCompraService.guardar(detalleCompra);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable String id) {
        detalleCompraService.eliminar(id);
    }
}
